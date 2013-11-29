package com.gooagoo.core.business.goods.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsCategoryGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsMarketingInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopPositionGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.CollectionCoreUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisListDao;

/**
 * 从缓存中查询商品相关信息
 */
@Service
public class GoodsCacheCoreServiceImpl implements GoodsCacheCoreService
{

    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private GoodsMarketingInfoGeneratorCoreService goodsMarketingInfoGeneratorCoreService;
    @Autowired
    private GoodsCategoryGeneratorCoreService goodsCategoryGeneratorCoreService;
    @Autowired
    private ShopPositionGeneratorCoreService shopPositionGeneratorCoreService;

    @Override
    public Map<String, String> findGoodsInfo(String goodsId)
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_goods);
        Map<String, String> result = redisHashDao.get(goodsId);
        if (result == null || result.size() == 0)
        {
            try
            {
                result = this.assembling(goodsId);
                if (result != null)
                {
                    redisHashDao.set(goodsId, result);
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("", e);
            }
        }
        return result;
    }

    private Map<String, String> assembling(String goodsId) throws Exception
    {
        Map<String, String> result = null;
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectUnDelByPrimaryKey(goodsId);
        if (goodsBaseInfo != null)
        {
            result = new HashMap<String, String>();
            String shopEntityId = goodsBaseInfo.getShopEntityId();
            result.put("goodsName", goodsBaseInfo.getGoodsName()); //商品名称
            result.put("goodsId", goodsBaseInfo.getGoodsId()); //商品id
            result.put("shopId", goodsBaseInfo.getShopId()); //商家id
            result.put("shopEntityId", shopEntityId); //实体店id
            result.put("goodsBrand", goodsBaseInfo.getGoodsBrand()); //品牌
            result.put("goodsSerial", goodsBaseInfo.getGoodsSerial()); //序列号
            result.put("itemSerial", goodsBaseInfo.getItemSerial()); //自定义序列号
            result.put("price", goodsBaseInfo.getPrice().toString()); //价格
            String goodsCategoryRoot = goodsBaseInfo.getGoodsCategoryRoot();//品类编号（根节点）
            String goodsCategoryLeaf = goodsBaseInfo.getGoodsCategoryLeaf();//品类编号（页节点）
            List<GoodsCategory> categories = this.findGoodsCategoryListByLeaf(shopEntityId, goodsCategoryRoot, goodsCategoryLeaf);
            StringBuffer category = new StringBuffer();
            StringBuffer categoryId = new StringBuffer();
            for (GoodsCategory goodsCategory : categories)
            {
                categoryId.append(goodsCategory.getId()).append(",");
                category.append(goodsCategory.getCategoryId()).append(",");
            }
            if (category.length() != 0)
            {
                categoryId.deleteCharAt(category.length() - 1);
                category.deleteCharAt(category.length() - 1);
            }
            result.put("categoryId", categoryId.toString());
            result.put("category", category.toString()); //序列号
            Map<String, String> mapCategoryRoot = this.findGoodsCategory(shopEntityId, goodsCategoryRoot);
            if (mapCategoryRoot != null)
            {
                result.put("goodsCategoryRootId", mapCategoryRoot.get("categoryId")); //父节点分类编号
                result.put("goodsCategoryRootName", mapCategoryRoot.get("categoryName")); //父节点分类名称
            }
            Map<String, String> mapCategoryLeaf = this.findGoodsCategory(shopEntityId, goodsCategoryLeaf);
            if (mapCategoryLeaf != null)
            {
                result.put("goodsCategoryLeafId", mapCategoryRoot.get("categoryId")); //当前（叶）节点分类编号
                result.put("goodsCategoryLeafName", mapCategoryLeaf.get("categoryName")); //当前（叶）节点分类名称
            }
            GoodsMarketingInfo marketingInfo = this.goodsMarketingInfoGeneratorCoreService.selectUnDelByPrimaryKey(goodsId);
            if (marketingInfo != null)
            {
                result.put("vendor", marketingInfo.getVendor()); //供应商
                result.put("positionId", marketingInfo.getPositionId()); //位置编号
                result.put("goodsImg", marketingInfo.getGoodsImg()); //图片
                result.put("crossGoods", marketingInfo.getCrossGoods()); //交叉商品
                result.put("replaceGoods", marketingInfo.getReplaceGoods()); //替换商品
                result.put("relationGoods", marketingInfo.getRelationGoods()); //关联商品
                result.put("address", marketingInfo.getAddress()); //产地
                result.put("useMessage", marketingInfo.getUseMessage()); //使用方法
                result.put("crowd", marketingInfo.getCrowd()); //人群
                result.put("feature", marketingInfo.getFeature()); //功能
                result.put("goodsSolution", marketingInfo.getGoodsSolution()); //解决方案
                result.put("goodsContent", marketingInfo.getGoodsContent()); //商品推荐描述
                ShopPosition shopPosition = this.shopPositionGeneratorCoreService.selectUnDelByPrimaryKey(marketingInfo.getPositionId());
                if (shopPosition != null)
                {
                    result.put("positionName", shopPosition.getPositionName());//位置名称
                }
            }
            CollectionCoreUtils.filterNullValue4Map(result);
        }
        return result;
    }

    private List<GoodsCategory> findGoodsCategoryListByLeaf(String shopEntityId, String goodsCategoryRoot, String goodsCategoryLeaf)
    {
        List<GoodsCategory> result = new ArrayList<GoodsCategory>();
        String category = goodsCategoryLeaf;

        while (true)
        {
            GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
            goodsCategoryExample.createCriteria().andIsDelEqualTo("N").andShopEntityIdEqualTo(shopEntityId).andCategoryIdEqualTo(category);
            List<GoodsCategory> categories = this.goodsCategoryGeneratorCoreService.selectByExample(goodsCategoryExample);
            if (categories != null && categories.size() != 0)
            {
                GoodsCategory goodsCategory = categories.get(0);
                result.add(goodsCategory);
                category = goodsCategory.getParentCategoryId();
                if (goodsCategory.getParentCategoryId().equals("-1"))
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return result;
    }

    @Override
    public Map<String, String> findGoodsCategory(String shopEntityId, String categoryId) throws Exception
    {
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_category);
        Map<String, String> result = hashDao.get(shopEntityId + "_" + categoryId);
        if (result == null || result.size() == 0)
        {
            GoodsCategoryExample example = new GoodsCategoryExample();
            example.createCriteria().andShopEntityIdEqualTo(shopEntityId).andCategoryIdEqualTo(categoryId);
            List<GoodsCategory> category = this.goodsCategoryGeneratorCoreService.selectByExample(example);
            if (category != null && category.size() != 0)
            {
                GoodsCategory goodsCategory = category.get(0);
                result = new HashMap<String, String>();
                result.put("categoryId", goodsCategory.getCategoryId());//品类编号
                result.put("categoryName", goodsCategory.getCategoryName());//品类名称
                result.put("shopId", goodsCategory.getShopId());//所属商家
                result.put("shopEntityId", goodsCategory.getShopEntityId());//实体店编号
                result.put("parentCategoryId", goodsCategory.getParentCategoryId());//父品类编号，-1表示没有父品类
                result.put("picUrl", goodsCategory.getPicUrl());//图片URL
                result.put("positionId", goodsCategory.getPositionId());//位置编号，描述品类在实体店中所处的位置
                CollectionCoreUtils.filterNullValue4Map(result);
                hashDao.set(shopEntityId + "_" + categoryId, result);
            }
        }
        return result;
    }

    @Override
    public boolean addExhaustedGoods(String shopEntityId, String itemSerialList) throws Exception
    {
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_exhausted);
        if (StringUtils.isBlank(itemSerialList))
        {
            return false;
        }
        redisListDao.put(shopEntityId, itemSerialList);
        return true;
    }
}

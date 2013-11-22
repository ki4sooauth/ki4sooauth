package com.gooagoo.query.business.goods.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.statistics.BuyStatisticQueryService;
import com.gooagoo.api.business.query.statistics.user.GoodsStatisticQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingItemLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.goods.GoodsProtectedQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.CrossGoods;
import com.gooagoo.entity.business.goods.GoodsCategoryBusiness;
import com.gooagoo.entity.business.goods.GoodsContainComment;
import com.gooagoo.entity.business.goods.GoodsDetail;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class GoodsQueryServiceImpl implements GoodsQueryService
{

    @Autowired
    GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;
    @Autowired
    private GoodsFeatureGeneratorQueryService goodsFeatureGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private GoodsBrandGeneratorQueryService goodsBrandGeneratorQueryService;
    @Autowired
    private GoodsFeatureInfoGeneratorQueryService goodsFeatureInfoGeneratorQueryService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private MarketingItemLinkGeneratorQueryService marketingItemLinkGeneratorQueryService;
    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;
    @Autowired
    private BuyStatisticQueryService buyStatisticQueryService;
    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;
    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private UserCacheQueryService userCacheQueryService;
    @Autowired
    private GoodsStatisticQueryService goodsStatisticQueryService;
    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;
    @Autowired
    private GoodsProtectedQueryService goodsProtectedQueryService;

    @Override
    public GoodsDetail findGoodsBaseDetail(String goodsId) throws Exception
    {
        //1、获取商品基本信息
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null || "Y".equals(goodsBaseInfo.getIsDel()))
        {
            GooagooLog.info("根据商品Id查询商品基本信息详情：商品（" + goodsId + "）不存在或已被删除");
            return null;
        }
        //2、获取商家详细信息
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(goodsBaseInfo.getShopId());
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("根据商品Id查询商品基本信息详情：商家（" + goodsBaseInfo.getShopId() + "）不存在或已被删除");
            return null;
        }
        //3、获取实体店联系电话
        String shopEntityPhone = this.getShopEntityPhone(goodsBaseInfo.getShopEntityId());
        //4、获取商品对应品牌名称
        String goodsBrandName = null;
        List<GoodsBrand> goodsBrandList = this.getGoodsBrandList(new HashMap<String, List<GoodsBrand>>(), goodsBaseInfo.getShopId(), goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsBrand());
        for (GoodsBrand goodsBrand : goodsBrandList)
        {
            if (goodsBaseInfo.getGoodsBrand().equals(goodsBrand.getBrandId()))
            {
                goodsBrandName = goodsBrand.getBrandName();
            }
        }
        //5、获取商品对应品类名称
        String goodsCategoryRootName = null;
        String goodsCategoryLeafName = null;
        List<GoodsCategory> goodsCategoryList = this.getGoodsCategoryList(new HashMap<String, List<GoodsCategory>>(), goodsBaseInfo.getShopId(), goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsCategoryRoot(), goodsBaseInfo.getGoodsCategoryLeaf());
        for (GoodsCategory goodsCategory : goodsCategoryList)
        {
            if (goodsBaseInfo.getGoodsCategoryRoot().equals(goodsCategory.getCategoryId()))
            {
                goodsCategoryRootName = goodsCategory.getCategoryName();
            }
            if (goodsBaseInfo.getGoodsCategoryLeaf().equals(goodsCategory.getCategoryId()))
            {
                goodsCategoryLeafName = goodsCategory.getCategoryName();
            }
        }
        //6、商品评分
        Map<String, String> data = this.goodsCacheQueryService.findGoodsInfo(goodsId);
        String commentLevel = null;
        if (data != null)
        {
            commentLevel = data.get("commentLevel");
        }
        //7、组装返回数据
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setShopName(shopInfo.getShopName());
        goodsDetail.setShopLogo1(shopInfo.getLogo1());
        goodsDetail.setShopLogo2(shopInfo.getLogo2());
        goodsDetail.setShopEntityPhone(shopEntityPhone);
        goodsDetail.setGoodsHot(this.buyStatisticQueryService.goodsBuyTimes(goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getItemSerial(), "W", "A", new Date()) + "");
        goodsDetail.setCommentLevel(commentLevel);
        goodsDetail.setGoodsCategoryRootName(goodsCategoryRootName);
        goodsDetail.setGoodsCategoryLeafName(goodsCategoryLeafName);
        goodsDetail.setGoodsBrandName(goodsBrandName);
        goodsDetail.setGoodsBaseInfo(goodsBaseInfo);

        return goodsDetail;
    }

    @Override
    public GoodsDetail findGoodsMarketingDetail(String goodsId) throws Exception
    {
        //1、获取商品营销信息
        GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
        if (goodsMarketingInfo == null || "Y".equals(goodsMarketingInfo.getIsDel()))
        {
            GooagooLog.info("根据商品Id查询商品基本营销详情：商品（" + goodsId + "）不存在或已被删除");
            return null;
        }
        //2、组装返回数据
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodsContent(goodsMarketingInfo.getGoodsContent());
        goodsDetail.setGoodsImg(goodsMarketingInfo.getGoodsContent());
        goodsDetail.setGoodsMarketingInfo(goodsMarketingInfo);

        return goodsDetail;
    }

    @Override
    public GoodsDetail findGoodsFeatureDetail(String goodsId) throws Exception
    {
        if (!StringUtils.hasText(goodsId))
        {
            GooagooLog.info("根据商品Id查询商品特征信息详情：商品ID（" + goodsId + "）为空");
            return null;
        }
        //1、获取特征信息
        GoodsFeatureInfoExample queryCondition = new GoodsFeatureInfoExample();
        queryCondition.createCriteria().andGoodsIdEqualTo(goodsId).andIsDelEqualTo("N");
        List<GoodsFeatureInfo> result = this.goodsFeatureInfoGeneratorQueryService.selectByExample(queryCondition);
        //2、过滤不需要显示在页面上的商品特征
        List<GoodsFeatureInfo> goodsFeatureInfoList = new ArrayList<GoodsFeatureInfo>();
        for (GoodsFeatureInfo goodsFeatureInfo : result)
        {
            GoodsFeatureExample queryCondition2 = new GoodsFeatureExample();
            queryCondition2.createCriteria().andShopIdEqualTo(goodsFeatureInfo.getShopId()).andTypeCodeEqualTo(goodsFeatureInfo.getFeatureCode()).andIsDisplayEqualTo("Y").andIsDelEqualTo("N");
            Integer count = this.goodsFeatureGeneratorQueryService.countByExample(queryCondition2);
            if (count == null || count == 0)
            {
                continue;
            }
            goodsFeatureInfoList.add(goodsFeatureInfo);
        }
        //3、组装返回数据
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodsFeatureInfoList(goodsFeatureInfoList);

        return goodsDetail;
    }

    @Override
    public GoodsBaseInfo findGoodsByItemSerial(String shopEntityId, String itemSerial)
    {
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andItemSerialEqualTo(itemSerial).andIsDelEqualTo("N");
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(goodsBaseInfoList))
        {
            return null;
        }
        return goodsBaseInfoList.get(0);
    }

    @Override
    public List<GoodsCategoryBusiness> findGoodsCategory(String ShopId, String shopEntityId, Integer pageIndex, Integer pageSize)
    {
        List<GoodsCategoryBusiness> goodsCategoryBusinessList = null;
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        goodsCategoryExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andParentCategoryIdEqualTo("-1").andIsDelEqualTo("N");
        goodsCategoryExample.setPage(pageIndex, pageSize);
        //获取某实体店父节点品类信息
        List<GoodsCategory> parentGoodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isNotEmpty(parentGoodsCategoryList))
        {
            goodsCategoryBusinessList = new ArrayList<GoodsCategoryBusiness>();
            for (GoodsCategory parentGoodsCategory : parentGoodsCategoryList)
            {
                GoodsCategoryBusiness goodsCategoryBusiness = new GoodsCategoryBusiness();
                goodsCategoryBusiness.setParentGoodsCategory(parentGoodsCategory);
                goodsCategoryExample = new GoodsCategoryExample();
                goodsCategoryExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andParentCategoryIdEqualTo(parentGoodsCategory.getCategoryId()).andIsDelEqualTo("N");
                //获取子节点品类集合
                List<GoodsCategory> childGoodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
                goodsCategoryBusiness.setChildGoodsCategoryList(childGoodsCategoryList);
                goodsCategoryBusinessList.add(goodsCategoryBusiness);
            }
        }
        return goodsCategoryBusinessList;
    }

    @Override
    public List<GoodsDetail> findGoods(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception
    {
        //1、校验入参
        if (!StringUtils.hasText(shopId) && !StringUtils.hasText(shopEntityId))
        {
            return null;
        }
        //2、获取商家总店编号
        if (!StringUtils.hasText(shopEntityId))
        {
            shopEntityId = this.shopProtectedQueryService.getShopEntity(shopId, null);
        }
        if (!StringUtils.hasText(shopEntityId))
        {
            return null;
        }
        //3、获取商品列表
        List<GoodsDetail> goodsDetailList = null;
        if (!StringUtils.hasText(orderByClause))
        {
            goodsDetailList = this.findGoods1(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize);
        }
        else if ("1".equalsIgnoreCase(orderByClause))
        {
            goodsDetailList = this.findGoods2(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize);
        }
        else if ("2".equalsIgnoreCase(orderByClause))
        {
            goodsDetailList = this.findGoods3(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize);
        }
        else if ("3".equalsIgnoreCase(orderByClause))
        {
            goodsDetailList = this.findGoods4(shopId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize);
        }

        return goodsDetailList;
    }

    @Override
    public Integer countGeneralGoods(String shopId)
    {
        //1、获取商家总店编号
        String shopEntityId = this.shopProtectedQueryService.getShopEntity(shopId, null);
        if (!StringUtils.hasText(shopEntityId))
        {
            return 0;
        }
        //2、统计总数
        GoodsBaseInfoExample queryCondition = new GoodsBaseInfoExample();
        Criteria criteria1 = queryCondition.createCriteria();
        criteria1.andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");

        return this.goodsBaseInfoGeneratorQueryService.countByExample(queryCondition);
    }

    @Override
    public List<ShopGoodsDetailInfo> findGoodsAndComment(List<Map<String, String>> goodsInfoList) throws Exception
    {
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = null;
        if (CollectionUtils.isNotEmpty(goodsInfoList))
        {
            shopGoodsDetailInfoList = new ArrayList<ShopGoodsDetailInfo>();
            for (Map<String, String> goodsInfo : goodsInfoList)
            {
                //redis获取商品信息
                Map<String, String> goodsInfoCache = this.goodsCacheQueryService.findGoodsInfo(goodsInfo.get("goodsid"));
                if (goodsInfoCache != null && goodsInfoCache.size() > 0)
                {
                    ShopGoodsDetailInfo shopGoodsDetailInfo = new ShopGoodsDetailInfo();
                    shopGoodsDetailInfo.setDiscountprice(goodsInfoCache.get("price"));//促销价格
                    shopGoodsDetailInfo.setGoodsscore(goodsInfoCache.get("commentLevel"));
                    //封装商品基本信息
                    shopGoodsDetailInfo.setGoodsBaseInfo(this.encapsulationGoodsBaseInfo4Cache(goodsInfoCache));
                    //封装商品营销信息
                    shopGoodsDetailInfo.setGoodsMarketingInfo(this.encapsulationGoodsMarketingInfo4Cache(goodsInfoCache));
                    //交叉商品信息列表
                    String crossGoodsJson = goodsInfoCache.get("crossGoods");
                    if (StringUtils.hasText(crossGoodsJson))
                    {
                        List<CrossGoods> crossGoodsList = new ArrayList<CrossGoods>();
                        List<String> goodsIdList = JsonUtils.json2List(crossGoodsJson);
                        for (String crossGoodsId : goodsIdList)
                        {
                            Map<String, String> crossGoodsCache = this.goodsCacheQueryService.findGoodsInfo(crossGoodsId);
                            if (crossGoodsCache != null && crossGoodsCache.size() > 0)
                            {
                                CrossGoods crossGoods = this.encapsulationCrossGoods4Cache(crossGoodsCache);
                                crossGoodsList.add(crossGoods);
                            }
                        }
                        shopGoodsDetailInfo.setCrossGoodsList(crossGoodsList);
                    }
                    shopGoodsDetailInfoList.add(shopGoodsDetailInfo);
                }
            }
        }
        return shopGoodsDetailInfoList;
    }

    /**
     * redis数据转换为GoodsBaseInfo
     * @param goodsInfoMap
     * @return
     * @throws Exception
     */
    private GoodsBaseInfo encapsulationGoodsBaseInfo4Cache(Map<String, String> goodsInfoMap) throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setGoodsId(goodsInfoMap.get("goodsId"));
        goodsBaseInfo.setGoodsName(goodsInfoMap.get("goodsName"));
        goodsBaseInfo.setShopId(goodsInfoMap.get("shopId"));
        goodsBaseInfo.setShopEntityId(goodsInfoMap.get("shopEntityId"));
        goodsBaseInfo.setGoodsCategoryRoot(goodsInfoMap.get("goodsCategoryRoot"));
        goodsBaseInfo.setGoodsCategoryLeaf(goodsInfoMap.get("goodsCategoryLeaf"));
        goodsBaseInfo.setGoodsBrand(goodsInfoMap.get("goodsBrand"));
        goodsBaseInfo.setGoodsSerial(goodsInfoMap.get("goodsSerial"));
        goodsBaseInfo.setItemSerial(goodsInfoMap.get("itemSerial"));
        goodsBaseInfo.setPrice(goodsInfoMap.get("price") != null ? Double.parseDouble(goodsInfoMap.get("price")) : null);
        goodsBaseInfo.setIsDel(goodsInfoMap.get("isDel"));
        goodsBaseInfo.setCreateTime(goodsInfoMap.get("createTime") != null ? TimeUtils.convertStringToDate(goodsInfoMap.get("createTime")) : null);
        goodsBaseInfo.setCTimeStamp(goodsInfoMap.get("cTimeStamp") != null ? TimeUtils.convertStringToDate(goodsInfoMap.get("cTimeStamp")) : null);
        return goodsBaseInfo;
    }

    /**
     * redis数据转换为GoodsMarketingInfo
     * @param goodsInfoMap
     * @return
     * @throws Exception
     */
    private GoodsMarketingInfo encapsulationGoodsMarketingInfo4Cache(Map<String, String> goodsInfoMap) throws Exception
    {
        GoodsMarketingInfo goodsMarketingInfo = new GoodsMarketingInfo();
        goodsMarketingInfo.setGoodsId(goodsInfoMap.get("goodsId"));
        goodsMarketingInfo.setShopId(goodsInfoMap.get("shopId"));
        goodsMarketingInfo.setShopEntityId(goodsInfoMap.get("shopEntityId"));
        goodsMarketingInfo.setVendor(goodsInfoMap.get("vendor"));
        goodsMarketingInfo.setPositionId(goodsInfoMap.get("positionId"));
        goodsMarketingInfo.setGoodsContent(goodsInfoMap.get("goodsContent"));
        goodsMarketingInfo.setGoodsSolution(goodsInfoMap.get("goodsSolution"));
        goodsMarketingInfo.setCrossGoods(goodsInfoMap.get("crossGoods"));
        goodsMarketingInfo.setRelationGoods(goodsInfoMap.get("relationGoods"));
        goodsMarketingInfo.setReplaceGoods(goodsInfoMap.get("replaceGoods"));
        goodsMarketingInfo.setLifeIdea(goodsInfoMap.get("lifeIdea"));
        goodsMarketingInfo.setUseType(goodsInfoMap.get("useType"));
        goodsMarketingInfo.setFeature(goodsInfoMap.get("feature"));
        goodsMarketingInfo.setAddress(goodsInfoMap.get("address"));
        goodsMarketingInfo.setCrowd(goodsInfoMap.get("crowd"));
        goodsMarketingInfo.setUseMessage(goodsInfoMap.get("useMessage"));
        if (StringUtils.hasText(goodsInfoMap.get("goodsImg")))
        {
            List<String> goodsImgList = JsonUtils.json2List(goodsInfoMap.get("goodsImg"));
            List<String> smallImgList = new ArrayList<String>();
            for (String goodsImg : goodsImgList)
            {
                smallImgList.add(UrlUtils.getAttachUrlByImg("s", goodsImg));
            }
            String smallImgJson = JsonUtils.toJson(smallImgList);
            goodsMarketingInfo.setGoodsImg(smallImgJson);
        }
        goodsMarketingInfo.setIsDel(goodsInfoMap.get("isDel"));
        goodsMarketingInfo.setCreateTime(goodsInfoMap.get("createTime") != null ? TimeUtils.convertStringToDate(goodsInfoMap.get("createTime")) : null);
        goodsMarketingInfo.setCTimeStamp(goodsInfoMap.get("cTimeStamp") != null ? TimeUtils.convertStringToDate(goodsInfoMap.get("cTimeStamp")) : null);
        return goodsMarketingInfo;
    }

    /**
     * redis数据转换为CrossGoods
     * @param crossGoodsCache
     * @return
     */
    private CrossGoods encapsulationCrossGoods4Cache(Map<String, String> crossGoodsCache)
    {
        CrossGoods crossGoods = new CrossGoods();
        crossGoods.setGoodsId(crossGoodsCache.get("goodsId"));
        crossGoods.setGoodsName(crossGoodsCache.get("goodsName"));
        crossGoods.setShopId(crossGoodsCache.get("shopId"));
        crossGoods.setShopEntityId(crossGoodsCache.get("shopEntityId"));
        crossGoods.setGoodsCategoryRoot(crossGoodsCache.get("goodsCategoryRoot"));
        crossGoods.setGoodsCategoryLeaf(crossGoodsCache.get("goodsCategoryLeaf"));
        crossGoods.setGoodsBrand(crossGoodsCache.get("goodsBrand"));
        crossGoods.setGoodsSerial(crossGoodsCache.get("goodsSerial"));
        crossGoods.setItemSerial(crossGoodsCache.get("itemSerial"));
        crossGoods.setGoodsImg(crossGoodsCache.get("goodsImg"));
        crossGoods.setPrice(StringUtils.hasText(crossGoodsCache.get("price")) ? Double.parseDouble(crossGoodsCache.get("price")) : null);
        Integer saleNums = this.buyStatisticQueryService.goodsBuyTimes(crossGoodsCache.get("shopEntityId"), crossGoodsCache.get("itemSerial"), "W", "A", new Date());
        crossGoods.setSaleNums(saleNums != null ? saleNums.toString() : "0");//销量
        return crossGoods;
    }

    /**
     * 按默认排序方式下，获取菜列表
     * @param shopId
     * @param shopEntityId
     * @param itemSerial
     * @param goodsName
     * @param categoryRoot
     * @param categoryLeaf
     * @param priceMin
     * @param priceMax
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception 
     */
    private List<GoodsDetail> findGoods1(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize) throws Exception
    {
        return this.findGoods0(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize, null);
    }

    /**
     * 按人气排序方式下，获取菜列表
     * @param shopId
     * @param shopEntityId
     * @param itemSerial
     * @param goodsName
     * @param categoryRoot
     * @param categoryLeaf
     * @param priceMin
     * @param priceMax
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception 
     */
    private List<GoodsDetail> findGoods2(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize) throws Exception
    {
        //1、获取菜列表
        List<GoodsDetail> goodsDetailList = this.findGoods0(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, null, null, null);
        //2、组装返回数据
        for (int i = 0; i < goodsDetailList.size() - 1; i++)
        {
            GoodsDetail goodsDetail1 = goodsDetailList.get(i);
            for (int j = i + 1; j < goodsDetailList.size(); j++)
            {
                GoodsDetail goodsDetail2 = goodsDetailList.get(j);
                if (Integer.valueOf(goodsDetail1.getGoodsHot()).intValue() < Integer.valueOf(goodsDetail2.getGoodsHot()).intValue())
                {
                    goodsDetailList.set(i, goodsDetail2);
                    goodsDetailList.set(j, goodsDetail1);
                }
            }
        }
        if (pageIndex == null || pageSize == null)
        {
            return goodsDetailList;
        }
        int fromIndex = pageIndex;
        fromIndex = fromIndex > goodsDetailList.size() ? goodsDetailList.size() : fromIndex;
        int toIndex = fromIndex + pageSize;
        toIndex = toIndex > goodsDetailList.size() ? goodsDetailList.size() : toIndex;

        return goodsDetailList.subList(fromIndex, toIndex);
    }

    /**
     * 按最新排序方式下，获取菜列表
     * @param shopId
     * @param shopEntityId
     * @param itemSerial
     * @param goodsName
     * @param categoryRoot
     * @param categoryLeaf
     * @param priceMin
     * @param priceMax
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception 
     */
    private List<GoodsDetail> findGoods3(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize) throws Exception
    {
        return this.findGoods0(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize, "c_time_stamp DESC");
    }

    /**
     * 按活动排序方式下，获取菜列表
     * @param shopEntityId
     * @param dishRequest
     * @param pageCondition
     * @return
     * @throws Exception 
     * @throws MerchantException
     */
    private List<GoodsDetail> findGoods4(String shopId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize) throws Exception
    {
        Date currentTime = new Date();
        //1、获取菜列表
        List<GoodsDetail> result1 = this.findGoods0(shopId, null, itemSerial, goodsName, categoryId, priceMin, priceMax, null, null, null);
        Map<String, GoodsDetail> goodsDetailMap = new HashMap<String, GoodsDetail>();
        for (GoodsDetail goodsDetail : result1)
        {
            goodsDetailMap.put(goodsDetail.getGoodsBaseInfo().getGoodsId(), goodsDetail);
        }
        //2、获取正在搞活动的商品
        MarketingItemLinkExample queryCondition = new MarketingItemLinkExample();
        queryCondition.createCriteria().andShopIdEqualTo(shopId).andMarketingTypeEqualTo("G").andIsDelEqualTo("N");
        List<MarketingItemLink> result2 = this.marketingItemLinkGeneratorQueryService.selectByExample(queryCondition);
        //3、过滤过期的活动
        Set<String> goodsIdSet = new HashSet<String>();
        Map<String, MarketingActivity> marketingActivityMap = new HashMap<String, MarketingActivity>();
        for (int i = 0; i < result2.size(); i++)
        {
            MarketingItemLink marketingItemLink = result2.get(0);
            MarketingActivity marketingActivity = marketingActivityMap.get(marketingItemLink.getActivityId());
            if (marketingActivity == null)
            {
                marketingActivity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(marketingItemLink.getActivityId());
                marketingActivityMap.put(marketingItemLink.getActivityId(), marketingActivity);
            }
            if (marketingActivity == null || "Y".equals(marketingActivity.getIsDel()) || currentTime.before(marketingActivity.getStartTime()) || currentTime.after(marketingActivity.getEndTime()) || !"P".equals(marketingActivity.getPublishStatus()))
            {
                continue;
            }
            goodsIdSet.add(marketingItemLink.getMarketingLinkId());
        }
        //4、组装返回数据
        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
        Iterator<String> it = goodsIdSet.iterator();
        while (it.hasNext())
        {
            GoodsDetail goodsDetail = goodsDetailMap.get(it.next());
            if (goodsDetail == null)
            {
                continue;
            }
            goodsDetailList.add(goodsDetail);
        }
        if (pageIndex == null || pageSize == null)
        {
            return goodsDetailList;
        }
        int fromIndex = pageIndex;
        fromIndex = fromIndex > goodsDetailList.size() ? goodsDetailList.size() : fromIndex;
        int toIndex = fromIndex + pageSize;
        toIndex = toIndex > goodsDetailList.size() ? goodsDetailList.size() : toIndex;

        return goodsDetailList.subList(fromIndex, toIndex);
    }

    /**
     * 查询商品信息
     * @param shopId
     * @param shopEntityId
     * @param itemSerial
     * @param goodsName
     * @param categoryRoot
     * @param categoryLeaf
     * @param priceMin
     * @param priceMax
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception 
     */
    private List<GoodsDetail> findGoods0(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception
    {
        //1、获取菜列表
        List<GoodsBaseInfo> goodsBaseInfoList = this.getGoodsBaseInfoList(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize, orderByClause);
        //2、组装返回数据
        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
        Map<String, GoodsMarketingInfo> goodsMarketingInfoMap = new HashMap<String, GoodsMarketingInfo>();
        Map<String, List<GoodsCategory>> goodsCategoryMap = new HashMap<String, List<GoodsCategory>>();
        Map<String, List<GoodsBrand>> goodsBrandMap = new HashMap<String, List<GoodsBrand>>();
        for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
        {
            //2.1、获取商品营销信息
            GoodsMarketingInfo goodsMarketingInfo = this.getGoodsMarketingInfo(goodsMarketingInfoMap, goodsBaseInfo.getGoodsId());
            //2.2、获取品类信息
            List<GoodsCategory> goodsCategoryList = this.getGoodsCategoryList(goodsCategoryMap, goodsBaseInfo.getShopId(), goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsCategoryRoot(), goodsBaseInfo.getGoodsCategoryLeaf());
            //2.3、获取品牌信息
            List<GoodsBrand> goodsBrandList = this.getGoodsBrandList(goodsBrandMap, goodsBaseInfo.getShopId(), goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsBrand());
            //2.4、组装数据
            GoodsDetail goodsDetail = new GoodsDetail();
            goodsDetail.setGoodsHot(this.buyStatisticQueryService.goodsBuyTimes(shopEntityId, goodsBaseInfo.getItemSerial(), "W", "A", new Date()) + "");
            for (GoodsCategory goodsCategory : goodsCategoryList)
            {
                if (goodsBaseInfo.getGoodsCategoryRoot().equals(goodsCategory.getCategoryId()))
                {
                    goodsDetail.setGoodsCategoryRoot(goodsCategory.getCategoryId());
                    goodsDetail.setGoodsCategoryRootName(goodsCategory.getCategoryName());
                }
                if (goodsBaseInfo.getGoodsCategoryLeaf().equals(goodsCategory.getCategoryId()))
                {
                    goodsDetail.setGoodsCategoryLeaf(goodsCategory.getCategoryId());
                    goodsDetail.setGoodsCategoryLeafName(goodsCategory.getCategoryName());
                }
            }
            for (GoodsBrand goodsBrand : goodsBrandList)
            {
                if (goodsBaseInfo.getGoodsBrand().equals(goodsBrand.getBrandId()))
                {
                    goodsDetail.setGoodsBrandName(goodsBrand.getBrandName());
                }
            }
            if (goodsMarketingInfo != null)
            {
                goodsDetail.setGoodsImg(goodsMarketingInfo.getGoodsImg());
            }
            goodsDetail.setGoodsBaseInfo(goodsBaseInfo);
            goodsDetailList.add(goodsDetail);
        }

        return goodsDetailList;
    }

    /**
     * 获取商品基本信息列表
     * @param shopId
     * @param shopEntityId
     * @param itemSerial
     * @param goodsName
     * @param categoryRoot
     * @param categoryLeaf
     * @param priceMin
     * @param priceMax
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception 
     */
    private List<GoodsBaseInfo> getGoodsBaseInfoList(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception
    {
        GoodsBaseInfoExample queryCondition = new GoodsBaseInfoExample();
        Criteria criteria1 = queryCondition.or();
        Criteria criteria2 = queryCondition.or();
        if (StringUtils.hasText(goodsName))
        {
            criteria1.andGoodsNameLike("%" + goodsName + "%");
        }
        if (StringUtils.hasText(itemSerial))
        {
            criteria2.andItemSerialLike("%" + itemSerial + "%");
        }
        if (StringUtils.hasText(shopId))
        {
            criteria1.andShopIdEqualTo(shopId);
            criteria2.andShopIdEqualTo(shopId);
        }
        if (StringUtils.hasText(categoryId))
        {
            List<String> categoryIdList = this.goodsProtectedQueryService.findGoodsCategoryListByParent(shopEntityId, categoryId);
            criteria1.andGoodsCategoryLeafIn(categoryIdList);
            criteria2.andGoodsCategoryLeafIn(categoryIdList);
        }
        if (StringUtils.hasText(priceMin) && StringUtils.hasText(priceMax))
        {
            criteria1.andPriceBetween(priceMin, priceMax);
            criteria2.andPriceBetween(priceMin, priceMax);
        }
        criteria1.andShopEntityIdEqualTo(shopEntityId);
        criteria2.andShopEntityIdEqualTo(shopEntityId);
        criteria1.andIsDelEqualTo("N");
        criteria2.andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            queryCondition.setPage(pageIndex, pageSize);
        }
        if (orderByClause != null)
        {
            queryCondition.setOrderByClause(orderByClause);
        }
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(queryCondition);

        return goodsBaseInfoList;
    }

    /**
     * 获取商品营销信息
     * @param goodsMarketingInfoMap
     * @param goodsId
     * @return
     */
    private GoodsMarketingInfo getGoodsMarketingInfo(Map<String, GoodsMarketingInfo> goodsMarketingInfoMap, String goodsId)
    {
        GoodsMarketingInfo goodsMarketingInfo = goodsMarketingInfoMap.get(goodsId);
        if (goodsMarketingInfo == null)
        {
            goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
            if (goodsMarketingInfo != null)
            {
                goodsMarketingInfoMap.put(goodsId, goodsMarketingInfo);
            }
        }

        return goodsMarketingInfo;
    }

    /**
     * 获取品类信息列表
     * @param goodsCategoryMap
     * @param shopId
     * @param shopEntityId
     * @param goodsCategoryRoot
     * @param goodsCategoryLeaf
     * @return
     */
    private List<GoodsCategory> getGoodsCategoryList(Map<String, List<GoodsCategory>> goodsCategoryMap, String shopId, String shopEntityId, String goodsCategoryRoot, String goodsCategoryLeaf)
    {
        List<GoodsCategory> goodsCategoryList = goodsCategoryMap.get(shopEntityId + "_" + goodsCategoryRoot + "_" + goodsCategoryLeaf);
        if (goodsCategoryList == null)
        {
            List<String> values = new ArrayList<String>();
            values.add(goodsCategoryRoot);
            values.add(goodsCategoryLeaf);
            GoodsCategoryExample queryCondition = new GoodsCategoryExample();
            queryCondition.createCriteria().andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andCategoryIdIn(values);
            goodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isNotEmpty(goodsCategoryList))
            {
                goodsCategoryMap.put(shopEntityId + "_" + goodsCategoryRoot + "_" + goodsCategoryLeaf, goodsCategoryList);
            }
        }

        return goodsCategoryList;
    }

    /**
     * 获取品牌列表
     * @param goodsBrandMap
     * @param shopId
     * @param shopEntityId
     * @param goodsBrandId
     * @return
     */
    private List<GoodsBrand> getGoodsBrandList(Map<String, List<GoodsBrand>> goodsBrandMap, String shopId, String shopEntityId, String goodsBrandId)
    {
        List<GoodsBrand> goodsBrandList = goodsBrandMap.get(shopEntityId + "_" + goodsBrandId);
        if (goodsBrandList == null)
        {
            GoodsBrandExample queryCondition = new GoodsBrandExample();
            queryCondition.createCriteria().andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andBrandIdEqualTo(goodsBrandId);
            goodsBrandList = this.goodsBrandGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isNotEmpty(goodsBrandList))
            {
                goodsBrandMap.put(shopEntityId + "_" + goodsBrandId, goodsBrandList);
            }
        }

        return goodsBrandList;
    }

    @Override
    public List<GoodsContainComment> findGoodsContainComment(String shopEntityId, String itemSerial) throws Exception
    {
        List<GoodsContainComment> goodsContainCommentList = null;
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andItemSerialEqualTo(itemSerial).andIsDelEqualTo("N").andPublishStatusEqualTo("P");
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(goodsBaseInfoList))
        {
            goodsBaseInfoExample = new GoodsBaseInfoExample();
            goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andGoodsSerialEqualTo(itemSerial).andIsDelEqualTo("N").andPublishStatusEqualTo("P");
            goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
        }
        if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
        {
            goodsContainCommentList = new ArrayList<GoodsContainComment>();
            for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
            {
                GoodsContainComment goodsContainComment = new GoodsContainComment();
                GoodsDetail goodsDetail = new GoodsDetail();
                Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(goodsBaseInfo.getGoodsId());
                Map<String, String> goodsCategoryRootMap = this.goodsCacheQueryService.findGoodsCategory(goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsCategoryRoot());
                Map<String, String> goodsCategoryLeafMap = this.goodsCacheQueryService.findGoodsCategory(goodsBaseInfo.getShopEntityId(), goodsBaseInfo.getGoodsCategoryLeaf());
                goodsDetail.setCommentLevel(goodsInfoMap.get("commentLevel"));//评分
                Integer commentNums = this.goodsStatisticQueryService.findCommentNum("hotComment", goodsBaseInfo.getGoodsId()).intValue();
                goodsDetail.setCommentNums(commentNums.toString());//评论次数
                goodsDetail.setGoodsContent(goodsInfoMap.get("goodsContent"));
                if (goodsCategoryRootMap != null)
                {
                    goodsDetail.setGoodsCategoryRootName(goodsCategoryRootMap.get("categoryName"));
                }
                if (goodsCategoryLeafMap != null)
                {
                    goodsDetail.setGoodsCategoryLeafName(goodsCategoryLeafMap.get("categoryName"));
                }
                goodsDetail.setGoodsBrandName(goodsInfoMap.get("brandName"));
                goodsDetail.setGoodsImg(goodsInfoMap.get("goodsImg"));
                goodsDetail.setGoodsBaseInfo(goodsBaseInfo);
                goodsContainComment.setGoodsDetail(goodsDetail);
                UserCommentExample userCommentExample = new UserCommentExample();
                userCommentExample.createCriteria().andGoodsIdEqualTo(goodsBaseInfo.getGoodsId()).andIsDelEqualTo("N");
                userCommentExample.setOrderByClause("c_time_stamp DESC");
                userCommentExample.setPage(1, 3);
                List<UserComment> userCommentList = this.userCommentGeneratorQueryService.selectByExample(userCommentExample);
                if (CollectionUtils.isNotEmpty(userCommentList))
                {
                    List<UserCommentDetail> userCommentDetailList = new ArrayList<UserCommentDetail>();
                    for (UserComment userComment : userCommentList)
                    {
                        Map<String, String> userInfoMap = this.userCacheQueryService.findUserInfo(userComment.getUserId());
                        Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(goodsBaseInfo.getShopId());
                        UserCommentDetail userCommentDetail = new UserCommentDetail();
                        userCommentDetail.setUserId(userComment.getUserId());
                        userCommentDetail.setUserAccount(userInfoMap.get("account"));
                        userCommentDetail.setUserMobile(userInfoMap.get("mobile"));
                        userCommentDetail.setUserEmail(userInfoMap.get("email"));
                        userCommentDetail.setUserHeadPic(userInfoMap.get("headPic"));
                        userCommentDetail.setShopId(goodsBaseInfo.getShopId());
                        userCommentDetail.setShopName(shopInfoMap.get("shopName"));
                        userCommentDetail.setGoodsId(goodsBaseInfo.getGoodsId());
                        userCommentDetail.setGoodsName(goodsBaseInfo.getGoodsName());
                        userCommentDetail.setCommentType(userComment.getCommentType());
                        userCommentDetail.setCommentLevel(userComment.getCommentLevel());
                        userCommentDetail.setContent(userComment.getContent());
                        userCommentDetail.setSource(userComment.getSource());
                        userCommentDetail.setCommentTime(userComment.getCreateTime());
                        userCommentDetailList.add(userCommentDetail);
                    }
                    goodsContainComment.setUserCommentDetailList(userCommentDetailList);
                }
                goodsContainCommentList.add(goodsContainComment);
            }
        }
        return goodsContainCommentList;
    }

    @Override
    public List<ShopGoodsDetailInfo> getGoodsMenu(String userId, String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = null;
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            if (pageSize != -1)
            {//当pageindex=1，pagesize=-1时，不分页
                goodsBaseInfoExample.setPage(pageIndex, pageSize);
            }

        }
        //商家商品基本信息列表
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
        {
            shopGoodsDetailInfoList = new ArrayList<ShopGoodsDetailInfo>();
            for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
            {
                ShopGoodsDetailInfo shopGoodsDetailInfo = new ShopGoodsDetailInfo();
                shopGoodsDetailInfo.setGoodsBaseInfo(goodsBaseInfo);

                //商品营销信息
                GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(goodsBaseInfo.getGoodsId());
                shopGoodsDetailInfo.setGoodsMarketingInfo(goodsMarketingInfo);
                //redis获取商品信息
                Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(goodsBaseInfo.getGoodsId());
                if (goodsInfoMap != null && goodsInfoMap.size() > 0)
                {
                    //添加分类名称
                    shopGoodsDetailInfo.setGoodsCategoryLeafName(goodsInfoMap.get("goodsCategoryLeafName"));//品类编号名称（叶节点）
                    shopGoodsDetailInfo.setGoodsCategoryRootName("goodsCategoryRootName");//品类编号名称（父节点）
                    shopGoodsDetailInfo.setGoodsscore(goodsInfoMap.get("commentLevel"));//商品评分(平均分)
                    //本周销量
                    this.buyStatisticQueryService.goodsBuyTimes(shopEntityId, goodsBaseInfo.getItemSerial(), "W", "A", new Date());
                    shopGoodsDetailInfo.setSalesw(null);
                    //当天点餐量
                    Integer salesd = this.buyStatisticQueryService.goodsBuyTimes(shopEntityId, goodsBaseInfo.getItemSerial(), "D", "A", new Date());
                    shopGoodsDetailInfo.setSalesd(salesd != null ? salesd.toString() : "0");
                }
                //是否收藏判断
                if (StringUtils.hasText(userId))
                {
                    FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
                    favoriteInfoExample.createCriteria().andUserIdEqualTo(userId).andObjectIdEqualTo(goodsBaseInfo.getGoodsId()).andIsDelEqualTo("N");
                    boolean isfav = this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample) > 0 ? true : false;
                    if (isfav)
                    {
                        shopGoodsDetailInfo.setIsFav("Y");
                    }
                    else
                    {
                        shopGoodsDetailInfo.setIsFav("N");
                    }
                }
                else
                {
                    shopGoodsDetailInfo.setIsFav("N");
                }
                shopGoodsDetailInfoList.add(shopGoodsDetailInfo);
            }
        }
        return shopGoodsDetailInfoList;
    }

    /**
     * 获取实体店联系电话
     * @param shopEntityId
     * @return
     */
    private String getShopEntityPhone(String shopEntityId)
    {
        String shopEntityPhone = null;//联系电话
        ShopEntityLink shopEntityLink = this.shopEntityLinkGeneratorQueryService.selectByPrimaryKey(shopEntityId);
        if (shopEntityLink == null || "Y".equals(shopEntityLink.getIsDel()))
        {
            return null;
        }
        shopEntityPhone = (StringUtils.hasText(shopEntityLink.getPhone())) ? shopEntityLink.getMobile() : shopEntityLink.getPhone();
        shopEntityPhone = (StringUtils.hasText(shopEntityPhone)) ? null : shopEntityPhone;

        return shopEntityPhone;
    }

}

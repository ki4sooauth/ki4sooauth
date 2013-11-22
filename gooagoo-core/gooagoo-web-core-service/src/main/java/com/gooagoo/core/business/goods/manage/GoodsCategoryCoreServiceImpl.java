package com.gooagoo.core.business.goods.manage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCategoryCoreService;
import com.gooagoo.api.generator.core.goods.GoodsCategoryGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;

@Service
public class GoodsCategoryCoreServiceImpl implements GoodsCategoryCoreService
{
    @Autowired
    private GoodsCategoryGeneratorCoreService goodsCategoryGeneratorCoreService;

    @Override
    public boolean deleteGoodsCategory(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除品类信息：主键为空");
            return false;
        }
        GoodsCategory goodsCategory = this.goodsCategoryGeneratorCoreService.selectUnDelByPrimaryKey(id);
        if (goodsCategory == null)
        {
            GooagooLog.warn("删除品类信息：品类不存在，id=" + id);
            return false;
        }
        //递归删除品类(包含子集)
        List<String> idList = new ArrayList<String>();
        idList.add(goodsCategory.getId());
        this.batchDelGoodsCategory(idList, goodsCategory.getShopEntityId(), goodsCategory.getCategoryId());
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        goodsCategoryExample.createCriteria().andIdIn(idList);
        return this.goodsCategoryGeneratorCoreService.deleteByExample(goodsCategoryExample);
    }

    @Override
    public boolean addGoodsCategory(GoodsCategory goodsCategory) throws Exception
    {
        goodsCategory.setIsDel("N");
        return this.goodsCategoryGeneratorCoreService.insertSelective(goodsCategory);
    }

    @Override
    public boolean updateGoodsCategory(GoodsCategory goodsCategory) throws Exception
    {
        return this.goodsCategoryGeneratorCoreService.updateByPrimaryKeySelective(goodsCategory);
    }

    /**递归获取指定商家品类主键集合(包含子集)
     * @param idList 品类主键集合
     * @param shopEntityId 实体店编号
     * @param parentId 父品类编号
     */
    private void batchDelGoodsCategory(List<String> idList, String shopEntityId, String parentId)
    {
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        goodsCategoryExample.createCriteria().andIsDelEqualTo("N").andShopEntityIdEqualTo(shopEntityId).andParentCategoryIdEqualTo(parentId);
        List<GoodsCategory> goodsCategoryList = this.goodsCategoryGeneratorCoreService.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isNotEmpty(goodsCategoryList))
        {
            for (GoodsCategory item : goodsCategoryList)
            {
                idList.add(item.getId());
                this.batchDelGoodsCategory(idList, shopEntityId, item.getCategoryId());
            }
        }
    }

}

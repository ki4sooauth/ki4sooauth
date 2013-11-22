package com.gooagoo.query.protecteds.goods;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.protecteds.query.goods.GoodsProtectedQueryService;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.exception.GooagooException;

@Service
public class GoodsProtectedQueryServiceImpl implements GoodsProtectedQueryService
{
    @Autowired
    private GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;

    @Override
    public List<String> findGoodsCategoryListByParent(String shopEntityId, String parentCategoryId) throws GooagooException
    {
        if (!StringUtils.hasText(parentCategoryId))
        {
            return null;
        }
        List<String> list = new ArrayList<String>();
        //把当前父节点加进去
        list.add(parentCategoryId);
        this.treeGoodsCategory(list, shopEntityId, parentCategoryId);
        return list;
    }

    /**
     * 通过父节点迭代查询子节点,并将子节点添加到集合中
     * @param goodsCategoryList
     * @param shopId
     * @param shopEntityId
     * @param parentId
     */
    private void treeGoodsCategory(List<String> list, String shopEntityId, String parentId)
    {
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        goodsCategoryExample.createCriteria().andIsDelEqualTo("N").andShopEntityIdEqualTo(shopEntityId).andParentCategoryIdEqualTo(parentId);
        List<GoodsCategory> goodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isNotEmpty(goodsCategoryList))
        {
            for (GoodsCategory item : goodsCategoryList)
            {
                list.add(item.getCategoryId());
                this.treeGoodsCategory(list, shopEntityId, item.getCategoryId());
            }
        }
    }

}

package com.gooagoo.entity.business.goods;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsCategory;

/**
 * 商品品类
 */

public class GoodsCategoryBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private GoodsCategory parentGoodsCategory;//父节点品类

    private List<GoodsCategory> childGoodsCategoryList;//子节点品类

    public GoodsCategory getParentGoodsCategory()
    {
        return this.parentGoodsCategory;
    }

    public void setParentGoodsCategory(GoodsCategory parentGoodsCategory)
    {
        this.parentGoodsCategory = parentGoodsCategory;
    }

    public List<GoodsCategory> getChildGoodsCategoryList()
    {
        return this.childGoodsCategoryList;
    }

    public void setChildGoodsCategoryList(List<GoodsCategory> childGoodsCategoryList)
    {
        this.childGoodsCategoryList = childGoodsCategoryList;
    }

    @Override
    public String toString()
    {
        return "GoodsCategoryBusiness [parentGoodsCategory=" + this.parentGoodsCategory.toString() + ", childGoodsCategoryList=" + this.childGoodsCategoryList.toString() + "]";
    }

}

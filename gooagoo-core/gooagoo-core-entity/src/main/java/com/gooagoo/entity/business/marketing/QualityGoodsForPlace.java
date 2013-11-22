package com.gooagoo.entity.business.marketing;

import java.util.List;

public class QualityGoodsForPlace extends ShopDetailForPlace
{
    private static final long serialVersionUID = 1L;

    private List<QualityGoodsBusiness> qualityGoodsBusinessList;

    public List<QualityGoodsBusiness> getQualityGoodsBusinessList()
    {
        return this.qualityGoodsBusinessList;
    }

    public void setQualityGoodsBusinessList(List<QualityGoodsBusiness> qualityGoodsBusinessList)
    {
        this.qualityGoodsBusinessList = qualityGoodsBusinessList;
    }

    @Override
    public String toString()
    {
        return "QualityGoodsForFavoritePlace [qualityGoodsBusinessList=" + this.qualityGoodsBusinessList + "]";
    }

}

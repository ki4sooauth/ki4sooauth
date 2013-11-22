package com.gooagoo.view.gms.good;

import java.io.Serializable;

public class FGoodsSpecial implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String featureCode;//特征编号
    private String featureName;//特征名称
    private String featureValue;//特征数值
    private String goodsId;//商品编号
    private String goodsName;//商品名称
    private String id; //自动编号
    private String shopId;//商家Id

    public String getFeatureCode()
    {
        return this.featureCode;
    }

    public String getFeatureName()
    {
        return this.featureName;
    }

    public String getFeatureValue()
    {
        return this.featureValue;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public String getId()
    {
        return this.id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setFeatureCode(String featureCode)
    {
        this.featureCode = featureCode;
    }

    public void setFeatureName(String featureName)
    {
        this.featureName = featureName;
    }

    public void setFeatureValue(String featureValue)
    {
        this.featureValue = featureValue;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }
}

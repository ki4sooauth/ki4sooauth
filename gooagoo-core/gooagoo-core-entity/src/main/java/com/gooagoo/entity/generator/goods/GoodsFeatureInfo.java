package com.gooagoo.entity.generator.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品特征信息
 */

public class GoodsFeatureInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private String shopId;//商家编号

    private String featureCode;//特征编码，如color

    private String featureName;//特征名称，如颜色

    private String featureValue;//特征数值，如蓝色

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getFeatureCode()
    {
        return this.featureCode;
    }

    public void setFeatureCode(String featureCode)
    {
        this.featureCode = featureCode;
    }

    public String getFeatureName()
    {
        return this.featureName;
    }

    public void setFeatureName(String featureName)
    {
        this.featureName = featureName;
    }

    public String getFeatureValue()
    {
        return this.featureValue;
    }

    public void setFeatureValue(String featureValue)
    {
        this.featureValue = featureValue;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.goodsId + "^" + this.goodsName + "^" + this.shopId + "^" + this.featureCode + "^" + this.featureName + "^" + this.featureValue + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

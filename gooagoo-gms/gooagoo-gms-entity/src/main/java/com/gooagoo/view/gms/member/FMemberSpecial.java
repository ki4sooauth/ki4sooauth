package com.gooagoo.view.gms.member;

import java.io.Serializable;

public class FMemberSpecial implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id;//自动编号
    private String shopId;//商家ID
    private String phyNo;//物理卡号
    private String userId;//用户编号
    private String scardNo;//电子卡号
    private String featureCode;//特征编码，如color
    private String featureName;//特征名称，如颜色
    private String featureValue;//特征数值，如蓝色

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getScardNo()
    {
        return this.scardNo;
    }

    public void setScardNo(String scardNo)
    {
        this.scardNo = scardNo;
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
}

package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员特征信息
 */

public class MemberFeatureInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号

    private String shopId;//商家ID

    private String phyNo;//物理卡号

    private String userId;//用户编号

    private String scardNo;//电子卡号

    private String featureCode;//特征编码，如color

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
        return this.id + "^" + this.shopId + "^" + this.phyNo + "^" + this.userId + "^" + this.scardNo + "^" + this.featureCode + "^" + this.featureValue + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

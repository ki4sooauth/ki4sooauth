package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体店基本信息
 */

public class ShopEntityInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店名称

    private String isGeneral;//是否为总店，每个商家只允许有一家总店，Y-是，N-否

    private String shopId;//商家编号

    private String tradeAreaId;//所属商圈

    private String registeredNumber;//工商注册号，即营业执照的注册号

    private String classificationCode;//行业类别代码，即国民经济行业分类代码

    private String organizationCode;//组织机构代码

    private String enterpriseName;//企业全称

    private String registeredCity;//注册城市，关联user_cityarea

    private String corporate;//法人代表

    private String registeredCapital;//注册资本

    private Date busnissAlotedStartTime;//营业期限开始时间

    private Date busnissAlotedEndTime;//营业期限终止时间

    private String businessLicense;//营业执照URL

    private Integer invoiceExpire;//拿到小票后开发票的截止天数

    private String openTime;//营业开门时间

    private String closeTime;//营业关门时间

    private String shopRoadGuide;//交通指南

    private String introduction;//店铺介绍

    private String promptinfo;//消费提示

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public String getIsGeneral()
    {
        return this.isGeneral;
    }

    public void setIsGeneral(String isGeneral)
    {
        this.isGeneral = isGeneral;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getTradeAreaId()
    {
        return this.tradeAreaId;
    }

    public void setTradeAreaId(String tradeAreaId)
    {
        this.tradeAreaId = tradeAreaId;
    }

    public String getRegisteredNumber()
    {
        return this.registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber)
    {
        this.registeredNumber = registeredNumber;
    }

    public String getClassificationCode()
    {
        return this.classificationCode;
    }

    public void setClassificationCode(String classificationCode)
    {
        this.classificationCode = classificationCode;
    }

    public String getOrganizationCode()
    {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }

    public String getEnterpriseName()
    {
        return this.enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName)
    {
        this.enterpriseName = enterpriseName;
    }

    public String getRegisteredCity()
    {
        return this.registeredCity;
    }

    public void setRegisteredCity(String registeredCity)
    {
        this.registeredCity = registeredCity;
    }

    public String getCorporate()
    {
        return this.corporate;
    }

    public void setCorporate(String corporate)
    {
        this.corporate = corporate;
    }

    public String getRegisteredCapital()
    {
        return this.registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital)
    {
        this.registeredCapital = registeredCapital;
    }

    public Date getBusnissAlotedStartTime()
    {
        return this.busnissAlotedStartTime;
    }

    public void setBusnissAlotedStartTime(Date busnissAlotedStartTime)
    {
        this.busnissAlotedStartTime = busnissAlotedStartTime;
    }

    public Date getBusnissAlotedEndTime()
    {
        return this.busnissAlotedEndTime;
    }

    public void setBusnissAlotedEndTime(Date busnissAlotedEndTime)
    {
        this.busnissAlotedEndTime = busnissAlotedEndTime;
    }

    public String getBusinessLicense()
    {
        return this.businessLicense;
    }

    public void setBusinessLicense(String businessLicense)
    {
        this.businessLicense = businessLicense;
    }

    public Integer getInvoiceExpire()
    {
        return this.invoiceExpire;
    }

    public void setInvoiceExpire(Integer invoiceExpire)
    {
        this.invoiceExpire = invoiceExpire;
    }

    public String getOpenTime()
    {
        return this.openTime;
    }

    public void setOpenTime(String openTime)
    {
        this.openTime = openTime;
    }

    public String getCloseTime()
    {
        return this.closeTime;
    }

    public void setCloseTime(String closeTime)
    {
        this.closeTime = closeTime;
    }

    public String getShopRoadGuide()
    {
        return this.shopRoadGuide;
    }

    public void setShopRoadGuide(String shopRoadGuide)
    {
        this.shopRoadGuide = shopRoadGuide;
    }

    public String getIntroduction()
    {
        return this.introduction;
    }

    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getPromptinfo()
    {
        return this.promptinfo;
    }

    public void setPromptinfo(String promptinfo)
    {
        this.promptinfo = promptinfo;
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
        return this.shopEntityId + "^" + this.shopEntityName + "^" + this.isGeneral + "^" + this.shopId + "^" + this.tradeAreaId + "^" + this.registeredNumber + "^" + this.classificationCode + "^" + this.organizationCode + "^" + this.enterpriseName + "^" + this.registeredCity + "^" + this.corporate + "^" + this.registeredCapital + "^" + this.busnissAlotedStartTime + "^" + this.busnissAlotedEndTime + "^" + this.businessLicense + "^" + this.invoiceExpire + "^" + this.openTime + "^" + this.closeTime + "^" + this.shopRoadGuide + "^" + this.introduction + "^" + this.promptinfo + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FShopEntityInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String businessLicense;//营业执照URL

    private Date busnissAlotedEndTime;//营业期限终止时间

    private Date busnissAlotedStartTime;//营业期限开始时间

    private String closeTime;//营业关门时间

    private String corporate;//法人代表

    private String enterpriseName;//企业全称

    private String introduction;//店铺介绍

    private Integer invoiceExpire;//拿到小票后开发票的截止天数

    private String openTime;//营业开门时间

    private String promptinfo;//消费提示

    private String registeredCapital;//注册资本

    private String registeredCity;//注册城市，关联user_cityarea

    private String registeredNumber;//注册号

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店名称

    private String shopId;//商家编号

    private String shopName; //商家名称

    private String shopRoadGuide;//交通指南

    private String address;//详细地址

    private String area;//区县

    private String city;//市

    private Date createTime;//创建时间

    private String mobile;//手机号码

    private String phone;//联系电话

    private String postCode;//邮政编码

    private String province;//省

    private String shopGpsBaidux;//GPS百度的X坐标

    private String shopGpsBaiduy;//GPS百度的Y坐标

    private String shopGpsGooglex;//GPS Google的X坐标

    private String shopGpsGoogley;//GPS Google的Y坐标
    
    private String note;//gps备注信息
    
    private String name1;//个人发票项目名称

    private String name2;//公司发票项目名称

    private Date cTimeStamp;//创建时间
    
    private String isGeneral;//是否为总店，每个商家只允许有一家总店，Y-是，N-否
    
    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPostCode()
    {
        return this.postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getProvince()
    {
        return this.province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getShopGpsBaidux()
    {
        return this.shopGpsBaidux;
    }

    public void setShopGpsBaidux(String shopGpsBaidux)
    {
        this.shopGpsBaidux = shopGpsBaidux;
    }

    public String getShopGpsBaiduy()
    {
        return this.shopGpsBaiduy;
    }

    public void setShopGpsBaiduy(String shopGpsBaiduy)
    {
        this.shopGpsBaiduy = shopGpsBaiduy;
    }

    public String getShopGpsGooglex()
    {
        return this.shopGpsGooglex;
    }

    public void setShopGpsGooglex(String shopGpsGooglex)
    {
        this.shopGpsGooglex = shopGpsGooglex;
    }

    public String getShopGpsGoogley()
    {
        return this.shopGpsGoogley;
    }

    public void setShopGpsGoogley(String shopGpsGoogley)
    {
        this.shopGpsGoogley = shopGpsGoogley;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getBusinessLicense()
    {
        return this.businessLicense;
    }

    public Date getBusnissAlotedEndTime()
    {
        return this.busnissAlotedEndTime;
    }

    public Date getBusnissAlotedStartTime()
    {
        return this.busnissAlotedStartTime;
    }

    public String getCloseTime()
    {
        return this.closeTime;
    }

    public String getCorporate()
    {
        return this.corporate;
    }

    public String getEnterpriseName()
    {
        return this.enterpriseName;
    }

    public String getIntroduction()
    {
        return this.introduction;
    }

    public Integer getInvoiceExpire()
    {
        return this.invoiceExpire;
    }

    public String getOpenTime()
    {
        return this.openTime;
    }

    public String getPromptinfo()
    {
        return this.promptinfo;
    }

    public String getRegisteredCapital()
    {
        return this.registeredCapital;
    }

    public String getRegisteredCity()
    {
        return this.registeredCity;
    }

    public String getRegisteredNumber()
    {
        return this.registeredNumber;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getShopRoadGuide()
    {
        return this.shopRoadGuide;
    }

    public void setBusinessLicense(String businessLicense)
    {
        this.businessLicense = businessLicense;
    }

    public void setBusnissAlotedEndTime(Date busnissAlotedEndTime)
    {
        this.busnissAlotedEndTime = busnissAlotedEndTime;
    }

    public void setBusnissAlotedStartTime(Date busnissAlotedStartTime)
    {
        this.busnissAlotedStartTime = busnissAlotedStartTime;
    }

    public void setCloseTime(String closeTime)
    {
        this.closeTime = closeTime;
    }

    public void setCorporate(String corporate)
    {
        this.corporate = corporate;
    }

    public void setEnterpriseName(String enterpriseName)
    {
        this.enterpriseName = enterpriseName;
    }

    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public void setInvoiceExpire(Integer invoiceExpire)
    {
        this.invoiceExpire = invoiceExpire;
    }

    public void setOpenTime(String openTime)
    {
        this.openTime = openTime;
    }

    public void setPromptinfo(String promptinfo)
    {
        this.promptinfo = promptinfo;
    }

    public void setRegisteredCapital(String registeredCapital)
    {
        this.registeredCapital = registeredCapital;
    }

    public void setRegisteredCity(String registeredCity)
    {
        this.registeredCity = registeredCity;
    }

    public void setRegisteredNumber(String registeredNumber)
    {
        this.registeredNumber = registeredNumber;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setShopRoadGuide(String shopRoadGuide)
    {
        this.shopRoadGuide = shopRoadGuide;
    }

    public String getName1()
    {
        return this.name1;
    }

    public void setName1(String name1)
    {
        this.name1 = name1;
    }

    public String getName2()
    {
        return this.name2;
    }

    public void setName2(String name2)
    {
        this.name2 = name2;
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
        return "FShopEntityInfo [businessLicense=" + this.businessLicense + ", busnissAlotedEndTime=" + this.busnissAlotedEndTime + ", busnissAlotedStartTime=" + this.busnissAlotedStartTime + ", closeTime=" + this.closeTime + ", corporate=" + this.corporate + ", enterpriseName=" + this.enterpriseName + ", introduction=" + this.introduction + ", invoiceExpire=" + this.invoiceExpire + ", openTime=" + this.openTime + ", promptinfo=" + this.promptinfo + ", registeredCapital=" + this.registeredCapital + ", registeredCity=" + this.registeredCity + ", registeredNumber=" + this.registeredNumber + ", shopEntityId=" + this.shopEntityId + ", shopEntityName=" + this.shopEntityName + ", shopId=" + this.shopId + ", shopName=" + this.shopName + ", shopRoadGuide=" + this.shopRoadGuide + ", address=" + this.address + ", area=" + this.area + ", city=" + this.city + ", createTime=" + this.createTime + ", mobile=" + this.mobile + ", phone=" + this.phone + ", postCode=" + this.postCode + ", province=" + this.province + ", shopGpsBaidux=" + this.shopGpsBaidux + ", shopGpsBaiduy=" + this.shopGpsBaiduy + ", shopGpsGooglex=" + this.shopGpsGooglex + ", shopGpsGoogley=" + this.shopGpsGoogley + ", note=" + this.note + "]";
    }

    public String getIsGeneral()
    {
        return this.isGeneral;
    }

    public void setIsGeneral(String isGeneral)
    {
        this.isGeneral = isGeneral;
    }

}

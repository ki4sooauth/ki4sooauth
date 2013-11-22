package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;

public class UConsigeeInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String consigneeId;//自动编号，UUID

    private String userId;//用户编号

    private String consigneeName;//收货人姓名

    private String provinceId;//省ID

    private String provinceName;//省名称

    private String cityId;//市ID

    private String cityName;//市名称

    private String areaId;//区县ID

    private String areaName;//区县名称

    private String address;//详细地址

    private String phone;//手机号码

    private String telephone;//联系电话

    private String postCode;//邮政编码

    private String isDefault;//是否默认选项，Y-是，N-否

    public String getConsigneeId()
    {
        return consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getConsigneeName()
    {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName)
    {
        this.consigneeName = consigneeName;
    }

    public String getProvinceId()
    {
        return provinceId;
    }

    public void setProvinceId(String provinceId)
    {
        this.provinceId = provinceId;
    }

    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getCityId()
    {
        return cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

}

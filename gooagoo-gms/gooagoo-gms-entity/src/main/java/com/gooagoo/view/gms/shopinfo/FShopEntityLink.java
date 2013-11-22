package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FShopEntityLink implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String address;//详细地址

    private String area;//区县

    private String city;//市

    private Date createTime;//创建时间

    private String mobile;//手机号码

    private String phone;//联系电话

    private String postCode;//邮政编码

    private String province;//省

    private String shopEntityId;//实体店编号

    private String shopId;//商家编号

    public String getAddress()
    {
        return this.address;
    }

    public String getArea()
    {
        return this.area;
    }

    public String getCity()
    {
        return this.city;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getPostCode()
    {
        return this.postCode;
    }

    public String getProvince()
    {
        return this.province;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    @Override
    public String toString()
    {
        return "FShopEntityLink [address=" + this.address + ", area=" + this.area + ", city=" + this.city + ", createTime=" + this.createTime + ", mobile=" + this.mobile + ", phone=" + this.phone + ", postCode=" + this.postCode + ", province=" + this.province + ", shopEntityId=" + this.shopEntityId + ", shopId=" + this.shopId + "]";
    }
}

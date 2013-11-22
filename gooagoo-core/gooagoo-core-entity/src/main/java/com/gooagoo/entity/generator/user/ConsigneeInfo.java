package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 收货人信息
 */

public class ConsigneeInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String consigneeId;//收货人信息编号，UUID

    private String userId;//用户编号

    private String consigneeName;//收货人姓名

    private String province;//省

    private String city;//市

    private String area;//区县

    private String address;//详细地址

    private String phone;//手机号码

    private String telephone;//联系电话

    private String postCode;//邮政编码

    private String isDefault;//是否默认选项，Y-是，N-否

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getConsigneeId()
    {
        return this.consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getConsigneeName()
    {
        return this.consigneeName;
    }

    public void setConsigneeName(String consigneeName)
    {
        this.consigneeName = consigneeName;
    }

    public String getProvince()
    {
        return this.province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getTelephone()
    {
        return this.telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getPostCode()
    {
        return this.postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
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
        return this.consigneeId + "^" + this.userId + "^" + this.consigneeName + "^" + this.province + "^" + this.city + "^" + this.area + "^" + this.address + "^" + this.phone + "^" + this.telephone + "^" + this.postCode + "^" + this.isDefault + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

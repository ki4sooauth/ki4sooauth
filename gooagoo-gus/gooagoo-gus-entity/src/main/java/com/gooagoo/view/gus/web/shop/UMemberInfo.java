package com.gooagoo.view.gus.web.shop;

import java.io.Serializable;

public class UMemberInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String name;//姓名

    private String sex;//性别，参考通用字典表的sex

    private String birthday;//出生日期

    private String shopId;//商家ID

    private String id;//会员基本信息卡编号

    private String idNo;//身份证号码

    private String mobile;//手机号码

    private String address;//通讯地址

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}

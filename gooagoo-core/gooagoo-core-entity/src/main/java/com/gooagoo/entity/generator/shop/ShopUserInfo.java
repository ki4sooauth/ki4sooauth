package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家营销中心用户信息表
 */

public class ShopUserInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户电子邮箱，由数字、字母、下划线、@组成

    private String shopId;//所属商家

    private String isShopAccount;//是否为商家帐号，Y-是，N-否（商家帐号只有一个，并且是不可删除、修改的）

    private String password;//密码，MD5加密

    private String status;//状态0-锁定，1-正常（如果是商家帐号，则需要与商家状态保持一致）

    private String name;//姓名

    private String sex;//性别 M-男 F-女

    private Date birthday;//出生日期

    private String idType;//证件类型

    private String idNo;//证件号码

    private String shopEntityId;//所属实体店，为空表示所有实体店

    private String brand;//所属品牌，为空表示所有品牌

    private String headImg;//'用户头像',

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getIsShopAccount()
    {
        return this.isShopAccount;
    }

    public void setIsShopAccount(String isShopAccount)
    {
        this.isShopAccount = isShopAccount;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getIdType()
    {
        return this.idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getHeadImg()
    {
        return this.headImg;
    }

    public void setHeadImg(String headImg)
    {
        this.headImg = headImg;
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
        return this.userId + "^" + this.shopId + "^" + this.isShopAccount + "^" + this.password + "^" + this.status + "^" + this.name + "^" + this.sex + "^" + this.birthday + "^" + this.idType + "^" + this.idNo + "^" + this.shopEntityId + "^" + this.brand + "^" + this.headImg + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

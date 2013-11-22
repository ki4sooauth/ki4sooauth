package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FShopUserInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Date birthday;//出生日期

    private String brand;//所属品牌，为空表示所有品牌

    private String brandName;//所属品牌，为空表示所有品牌
    private String shopEntityName;//所属品牌，为空表示所有品牌

    private Date createTime;//创建时间

    private String idNo;//证件号码

    private String idType;//证件类型

    private String idTypeCn;//证件类型中文名

    private String isDel;//是否删除，Y-已删除，N-未删除

    private String name;//姓名

    private String password;//密码，MD5加密

    private String sex;//性别 M-男 F-女

    private String shopEntityId;//所属实体店，为空表示所有实体店

    private String shopId;//所属商家

    private String status;//状态0-停用 1-启用

    private String userId;//用户电子邮箱，由数字、字母、下划线、@组成
    private String headImg;//'用户头像',

    public String getIdTypeCn()
    {
        return this.idTypeCn;
    }

    public void setIdTypeCn(String idTypeCn)
    {
        this.idTypeCn = idTypeCn;
    }

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public Date getBirthday()
    {
        return this.birthday;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public String getIdType()
    {
        return this.idType;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getSex()
    {
        return this.sex;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getStatus()
    {
        return this.status;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "FShopUserInfo [birthday=" + this.birthday + ", brand=" + this.brand + ", brandName=" + this.brandName + ", shopEntityName=" + this.shopEntityName + ", createTime=" + this.createTime + ", idNo=" + this.idNo + ", idType=" + this.idType + ", isDel=" + this.isDel + ", name=" + this.name + ", password=" + this.password + ", sex=" + this.sex + ", shopEntityId=" + this.shopEntityId + ", shopId=" + this.shopId + ", status=" + this.status + ", userId=" + this.userId + "]";
    }

    public String getHeadImg()
    {
        return this.headImg;
    }

    public void setHeadImg(String headImg)
    {
        this.headImg = headImg;
    }
}

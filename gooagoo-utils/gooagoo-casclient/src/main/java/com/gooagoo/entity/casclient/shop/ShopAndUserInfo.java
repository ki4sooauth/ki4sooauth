package com.gooagoo.entity.casclient.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家营销中心商家用户信息表
 */

public class ShopAndUserInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号，唯一，通过UUID产生

    private String shopEmail;//商家电子邮箱，唯一，字母、数字、下划线、@组成

    private String shopNickName;//商家昵称，默认为电子邮箱@之前的部分

    private String shopStatus;//商家状态，参考通用字典表的shop_status    L-锁定，P-待营业，U-正常营业，默认为锁定，审批通过之后为待营业，商家确认之后为正常营业。锁定和待营业期间商家可以使用部分功能，正常营业之后需要删除所有的测试信息（商家可选是否删除），只有商家帐号才能点击"正常营业"

    private String shopIsChain;//商家是否连锁，Y-连锁，N-非连锁

    private String shopServiceStyle;//商家部署模式，参考通用字典表的service_style

    private String shopName;//商家名称

    private Integer shopTypeRoot;//商家类型（根节点）

    private Integer shopTypeLeaf;//商家类型（叶节点）

    private String shopLogo1;//商家logo1，正方形

    private String shopLogo2;//商家logo2，长方形

    private String shopLogo3;//商家logo3，备用

    private String shopScope;//商家营业范围

    private String shopNote;//商家审核备注

    private String userId;//用户电子邮箱，由数字、字母、下划线、@组成

    private String userIsShopAccount;//用户是否为商家帐号，Y-是，N-否（商家帐号只有一个，并且是不可删除、修改的）

    private String userPassword;//密码，MD5加密

    private String userStatus;//状态0-锁定，1-正常（如果是商家帐号，则需要与商家状态保持一致）

    private String userName;//姓名

    private String userSex;//性别 M-男 F-女

    private Date userBirthday;//出生日期

    private String UserIdType;//证件类型

    private String userIdNo;//证件号码

    private String userShopEntityId;//所属实体店，为空表示所有实体店

    private String userBrand;//所属品牌，为空表示所有品牌

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEmail()
    {
        return this.shopEmail;
    }

    public void setShopEmail(String shopEmail)
    {
        this.shopEmail = shopEmail;
    }

    public String getShopNickName()
    {
        return this.shopNickName;
    }

    public void setShopNickName(String shopNickName)
    {
        this.shopNickName = shopNickName;
    }

    public String getShopStatus()
    {
        return this.shopStatus;
    }

    public void setShopStatus(String shopStatus)
    {
        this.shopStatus = shopStatus;
    }

    public String getShopIsChain()
    {
        return this.shopIsChain;
    }

    public void setShopIsChain(String shopIsChain)
    {
        this.shopIsChain = shopIsChain;
    }

    public String getShopServiceStyle()
    {
        return this.shopServiceStyle;
    }

    public void setShopServiceStyle(String shopServiceStyle)
    {
        this.shopServiceStyle = shopServiceStyle;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Integer getShopTypeRoot()
    {
        return this.shopTypeRoot;
    }

    public void setShopTypeRoot(Integer shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public Integer getShopTypeLeaf()
    {
        return this.shopTypeLeaf;
    }

    public void setShopTypeLeaf(Integer shopTypeLeaf)
    {
        this.shopTypeLeaf = shopTypeLeaf;
    }

    public String getShopLogo1()
    {
        return this.shopLogo1;
    }

    public void setShopLogo1(String shopLogo1)
    {
        this.shopLogo1 = shopLogo1;
    }

    public String getShopLogo2()
    {
        return this.shopLogo2;
    }

    public void setShopLogo2(String shopLogo2)
    {
        this.shopLogo2 = shopLogo2;
    }

    public String getShopLogo3()
    {
        return this.shopLogo3;
    }

    public void setShopLogo3(String shopLogo3)
    {
        this.shopLogo3 = shopLogo3;
    }

    public String getShopScope()
    {
        return this.shopScope;
    }

    public void setShopScope(String shopScope)
    {
        this.shopScope = shopScope;
    }

    public String getShopNote()
    {
        return this.shopNote;
    }

    public void setShopNote(String shopNote)
    {
        this.shopNote = shopNote;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserIsShopAccount()
    {
        return this.userIsShopAccount;
    }

    public void setUserIsShopAccount(String userIsShopAccount)
    {
        this.userIsShopAccount = userIsShopAccount;
    }

    public String getUserPassword()
    {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getUserStatus()
    {
        return this.userStatus;
    }

    public void setUserStatus(String userStatus)
    {
        this.userStatus = userStatus;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserSex()
    {
        return this.userSex;
    }

    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }

    public Date getUserBirthday()
    {
        return this.userBirthday;
    }

    public void setUserBirthday(Date userBirthday)
    {
        this.userBirthday = userBirthday;
    }

    public String getUserIdType()
    {
        return this.UserIdType;
    }

    public void setUserIdType(String userIdType)
    {
        this.UserIdType = userIdType;
    }

    public String getUserIdNo()
    {
        return this.userIdNo;
    }

    public void setUserIdNo(String userIdNo)
    {
        this.userIdNo = userIdNo;
    }

    public String getUserShopEntityId()
    {
        return this.userShopEntityId;
    }

    public void setUserShopEntityId(String userShopEntityId)
    {
        this.userShopEntityId = userShopEntityId;
    }

    public String getUserBrand()
    {
        return this.userBrand;
    }

    public void setUserBrand(String userBrand)
    {
        this.userBrand = userBrand;
    }

}

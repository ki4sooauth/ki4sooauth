package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家信息
 */

public class ShopInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号，唯一，通过UUID产生

    private String email;//电子邮箱，唯一，字母、数字、下划线、@组成

    private String nickName;//昵称，默认为电子邮箱@之前的部分

    private String shopStatus;//商家状态，参考通用字典表的shop_status    L-锁定，P-待营业，U-正常营业，默认为锁定，审批通过之后为待营业，商家确认之后为正常营业。锁定和待营业期间商家可以使用部分功能，正常营业之后需要删除所有的测试信息（商家可选是否删除），只有商家帐号才能点击"正常营业"

    private String isChain;//是否连锁，Y-连锁，N-非连锁

    private String serviceStyle;//部署模式，参考通用字典表的service_style

    private String shopName;//商家名称

    private Integer shopTypeRoot;//商家类型（根节点）

    private Integer shopTypeLeaf;//商家类型（叶节点）

    private String logo1;//商家logo1，正方形

    private String logo2;//商家logo2，长方形

    private String logo3;//商家logo3，备用

    private String scope;//营业范围

    private String note;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getShopStatus()
    {
        return this.shopStatus;
    }

    public void setShopStatus(String shopStatus)
    {
        this.shopStatus = shopStatus;
    }

    public String getIsChain()
    {
        return this.isChain;
    }

    public void setIsChain(String isChain)
    {
        this.isChain = isChain;
    }

    public String getServiceStyle()
    {
        return this.serviceStyle;
    }

    public void setServiceStyle(String serviceStyle)
    {
        this.serviceStyle = serviceStyle;
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

    public String getLogo1()
    {
        return this.logo1;
    }

    public void setLogo1(String logo1)
    {
        this.logo1 = logo1;
    }

    public String getLogo2()
    {
        return this.logo2;
    }

    public void setLogo2(String logo2)
    {
        this.logo2 = logo2;
    }

    public String getLogo3()
    {
        return this.logo3;
    }

    public void setLogo3(String logo3)
    {
        this.logo3 = logo3;
    }

    public String getScope()
    {
        return this.scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
        return this.shopId + "^" + this.email + "^" + this.nickName + "^" + this.shopStatus + "^" + this.isChain + "^" + this.serviceStyle + "^" + this.shopName + "^" + this.shopTypeRoot + "^" + this.shopTypeLeaf + "^" + this.logo1 + "^" + this.logo2 + "^" + this.logo3 + "^" + this.scope + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

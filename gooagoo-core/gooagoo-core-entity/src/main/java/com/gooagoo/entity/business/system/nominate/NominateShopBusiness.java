package com.gooagoo.entity.business.system.nominate;

import java.io.Serializable;
import java.util.Date;

/**
 * 竞拍详细信息
 */
public class NominateShopBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//推荐商家表自动编号
    private String shopId;//推荐商家表商家编号
    private String color;//推荐商家表推荐背景色值
    private String logo1;////商家logo1，正方形
    private String shopTypeRoot;//商家类型（根节点）
    private Date startTime;//推荐商家表起始时间
    private Date endTime;//推荐商家表结束时间
    private Date nominateShopCTimeStamp;//推荐商家表更新时间
    private String email;//商家信息表电子邮箱
    private String nickName;//商家信息表昵称
    private String shopStatus;//商家信息表商家状态
    private String isChain;//商家信息表是否连锁
    private String serviceStyle;//商家信息表部署模式
    private String shopName;//商家信息表商家名称
    private Date shopInfoCTimeStamp;//商家信息表更新时间
    private String isNominate;//商家信息表是否推荐（非数据库字段）Y-推荐，N-不推荐

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getLogo1()
    {
        return this.logo1;
    }

    public void setLogo1(String logo1)
    {
        this.logo1 = logo1;
    }

    public String getShopTypeRoot()
    {
        return this.shopTypeRoot;
    }

    public void setShopTypeRoot(String shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public Date getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getNominateShopCTimeStamp()
    {
        return this.nominateShopCTimeStamp;
    }

    public void setNominateShopCTimeStamp(Date nominateShopCTimeStamp)
    {
        this.nominateShopCTimeStamp = nominateShopCTimeStamp;
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

    public Date getShopInfoCTimeStamp()
    {
        return this.shopInfoCTimeStamp;
    }

    public void setShopInfoCTimeStamp(Date shopInfoCTimeStamp)
    {
        this.shopInfoCTimeStamp = shopInfoCTimeStamp;
    }

    public String getIsNominate()
    {
        return this.isNominate;
    }

    public void setIsNominate(String isNominate)
    {
        this.isNominate = isNominate;
    }

    @Override
    public String toString()
    {
        return "NominateShopBusiness [id=" + this.id + ", shopId=" + this.shopId + ", color=" + this.color + ", logo1=" + this.logo1 + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", nominateShopCTimeStamp=" + this.nominateShopCTimeStamp + ", email=" + this.email + ", nickName=" + this.nickName + ", shopStatus=" + this.shopStatus + ", isChain=" + this.isChain + ", serviceStyle=" + this.serviceStyle + ", shopName=" + this.shopName + ", shopInfoCTimeStamp=" + this.shopInfoCTimeStamp + ", isNominate=" + this.isNominate + "]";
    }

}

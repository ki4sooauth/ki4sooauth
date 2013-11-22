package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

public class MNominateShopBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//推荐商家表自动编号
    private String shopId;//推荐商家表商家编号
    private String color;//推荐商家表推荐背景色值
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
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getNominateShopCTimeStamp()
    {
        return nominateShopCTimeStamp;
    }

    public void setNominateShopCTimeStamp(Date nominateShopCTimeStamp)
    {
        this.nominateShopCTimeStamp = nominateShopCTimeStamp;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getShopStatus()
    {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus)
    {
        this.shopStatus = shopStatus;
    }

    public String getIsChain()
    {
        return isChain;
    }

    public void setIsChain(String isChain)
    {
        this.isChain = isChain;
    }

    public String getServiceStyle()
    {
        return serviceStyle;
    }

    public void setServiceStyle(String serviceStyle)
    {
        this.serviceStyle = serviceStyle;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Date getShopInfoCTimeStamp()
    {
        return shopInfoCTimeStamp;
    }

    public void setShopInfoCTimeStamp(Date shopInfoCTimeStamp)
    {
        this.shopInfoCTimeStamp = shopInfoCTimeStamp;
    }

    public String getIsNominate()
    {
        return isNominate;
    }

    public void setIsNominate(String isNominate)
    {
        this.isNominate = isNominate;
    }

}

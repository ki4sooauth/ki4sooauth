package com.gooagoo.analysis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为日志，记录一般性的行为
 */

public class Behave implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String behaveId;//行为编号，UUID

    private String userId;//用户编号

    private String account;//用户名

    private String gooagooID;//gooagooID，平台分配给手机设备的唯一编号

    private String ipAddress;//IP地址

    private String macAddress;//MAC地址

    private String mobile;//手机号

    private String ecAccount;//电子商务帐号

    private String scardno;//会员卡音频编号（电子卡号）

    private String phyCardNo;//物理卡号

    private String cardId;//会员等级（会员卡编号）

    private Date behaveTime;//行为发生时间

    private String source;//用户行为来源，参考通用字典表的behave_source

    private String behaveType;//行为类型：用户做了一个什么操作，比如浏览商品、收藏活动、关注商家等

    private String positionId;//行为发生地区的区域编号

    private Long duration;//当前时长（以秒为单位）

    private String remoteCode;//所调用的接口编码

    private String objectValue;//行为对象编号：用户所做操作的对象，比如商品、活动、商家

    private String objectType;//行为对象类型，A-活动，G-商品，C-优惠凭证，Y-吆喝，N-通知，Q-购好奇，M-邮件，S-手机服务，0-cms栏目，1-cms文章，2-广告

    private String objectName;//行为对象名称

    private String shopId;//行为对象所属商家编号

    private String shopEntityId;//行为对象所属实体店编号

    private String objectSource;//行为对象来源，记录优惠凭证是从哪个吆喝、通知中浏览和收藏的。

    private String categoryId;//品类，商品或账单所包含的品类

    private String brandId;//品牌，商品或账单所包含的品牌

    private String detail;//详细信息

    public String getBehaveId()
    {
        return this.behaveId;
    }

    public void setBehaveId(String behaveId)
    {
        this.behaveId = behaveId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getGooagooID()
    {
        return this.gooagooID;
    }

    public void setGooagooID(String gooagooID)
    {
        this.gooagooID = gooagooID;
    }

    public String getIpAddress()
    {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEcAccount()
    {
        return this.ecAccount;
    }

    public void setEcAccount(String ecAccount)
    {
        this.ecAccount = ecAccount;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getPhyCardNo()
    {
        return this.phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public Date getBehaveTime()
    {
        return this.behaveTime;
    }

    public void setBehaveTime(Date behaveTime)
    {
        this.behaveTime = behaveTime;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getRemoteCode()
    {
        return this.remoteCode;
    }

    public Long getDuration()
    {
        return this.duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public void setRemoteCode(String remoteCode)
    {
        this.remoteCode = remoteCode;
    }

    public String getObjectValue()
    {
        return this.objectValue;
    }

    public void setObjectValue(String objectValue)
    {
        this.objectValue = objectValue;
    }

    public String getObjectType()
    {
        return this.objectType;
    }

    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }

    public String getObjectName()
    {
        return this.objectName;
    }

    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getObjectSource()
    {
        return this.objectSource;
    }

    public void setObjectSource(String objectSource)
    {
        this.objectSource = objectSource;
    }

    public String getCategoryId()
    {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getBrandId()
    {
        return this.brandId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public String getDetail()
    {
        return this.detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

}

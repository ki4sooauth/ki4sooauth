package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为日志，记录一般性的行为
 */

public class BehaveLogExample implements Serializable
{
    private static final long serialVersionUID = -6662064434875315898L;

    private String behaveId;//行为编号，UUID

    private String userId;//用户编号

    private String account;//用户名

    private String gooagooID;//gooagooID，平台分配给手机设备的唯一编号

    private String ipAddress;//IP地址

    private String macAddress;//MAC地址

    private String hostName;//主机名

    private String mobile;//手机号

    private String ecAccount;//电子商务帐号

    private String scardno;//会员卡音频编号（电子卡号）

    private String phyCardNo;//物理卡号

    private String phoneType;//手机型号

    private String systemType;//操作系统类型

    private String browserType;//浏览器类型

    private String language;//浏览器语言设置

    private String screenResolution;//屏幕分辨率

    private String screenColor;//屏幕颜色

    private Date behaveTime;//行为发生时间

    private String source;//用户行为来源，参考通用字典表的behave_source

    private String operateResult;//操作结果，Y-成功，N-失败

    private String behaveType;//行为类型：用户做了一个什么操作，比如浏览商品、收藏活动、关注商家等

    private String positionId;//行为发生地区的区域编号

    private String remoteCode;//所调用的接口编码

    private String behaveValue;//行为对象编号：用户所做操作的对象，比如商品、活动、商家

    private String behaeName;//行为对象名称

    private String shopId;//行为对象所属商家编号

    private String shopEntityId;//行为对象所属实体店编号

    private String objectSource;//行为对象来源，记录优惠凭证是从哪个吆喝、通知中浏览和收藏的。

    private String detail;//详细信息

    private Date createTime;//创建时间
    private Date createTime_GTE;
    private Date createTime_LTE;

    public String getBehaveId()
    {
        return behaveId;
    }

    public void setBehaveId(String behaveId)
    {
        this.behaveId = behaveId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getGooagooID()
    {
        return gooagooID;
    }

    public void setGooagooID(String gooagooID)
    {
        this.gooagooID = gooagooID;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEcAccount()
    {
        return ecAccount;
    }

    public void setEcAccount(String ecAccount)
    {
        this.ecAccount = ecAccount;
    }

    public String getScardno()
    {
        return scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getPhyCardNo()
    {
        return phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

    public String getPhoneType()
    {
        return phoneType;
    }

    public void setPhoneType(String phoneType)
    {
        this.phoneType = phoneType;
    }

    public String getSystemType()
    {
        return systemType;
    }

    public void setSystemType(String systemType)
    {
        this.systemType = systemType;
    }

    public String getBrowserType()
    {
        return browserType;
    }

    public void setBrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getScreenResolution()
    {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution)
    {
        this.screenResolution = screenResolution;
    }

    public String getScreenColor()
    {
        return screenColor;
    }

    public void setScreenColor(String screenColor)
    {
        this.screenColor = screenColor;
    }

    public Date getBehaveTime()
    {
        return behaveTime;
    }

    public void setBehaveTime(Date behaveTime)
    {
        this.behaveTime = behaveTime;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getOperateResult()
    {
        return operateResult;
    }

    public void setOperateResult(String operateResult)
    {
        this.operateResult = operateResult;
    }

    public String getBehaveType()
    {
        return behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getRemoteCode()
    {
        return remoteCode;
    }

    public void setRemoteCode(String remoteCode)
    {
        this.remoteCode = remoteCode;
    }

    public String getBehaveValue()
    {
        return behaveValue;
    }

    public void setBehaveValue(String behaveValue)
    {
        this.behaveValue = behaveValue;
    }

    public String getBehaeName()
    {
        return behaeName;
    }

    public void setBehaeName(String behaeName)
    {
        this.behaeName = behaeName;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getObjectSource()
    {
        return objectSource;
    }

    public void setObjectSource(String objectSource)
    {
        this.objectSource = objectSource;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCreateTime_GTE()
    {
        return createTime_GTE;
    }

    public void setCreateTime_GTE(Date createTime_GTE)
    {
        this.createTime_GTE = createTime_GTE;
    }

    public Date getCreateTime_LTE()
    {
        return createTime_LTE;
    }

    public void setCreateTime_LTE(Date createTime_LTE)
    {
        this.createTime_LTE = createTime_LTE;
    }

}

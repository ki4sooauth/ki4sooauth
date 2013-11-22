package com.gooagoo.entity.log;

import java.io.Serializable;

/**
 * 用户客户端信息 用于日志
 * @author 
 *
 */
public class GusClientInfo implements Serializable
{
    private static final long serialVersionUID = 5552417129596159157L;

    private String ipAddress;//IP地址
    private String macAddress;//MAC地址
    private String hostName;//主机名
    private String phone;//手机号
    private String ecAccount;//电子商务帐号
    private String cardNo;//卡号
    private String phoneType;//手机型号
    private String systemType;//操作系统类型
    private String browserType;//浏览器类型
    private String language;//浏览器语言设置
    private String screenResolution;//屏幕分辨率
    private String screenColor;//屏幕颜色

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

    public String getHostName()
    {
        return this.hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEcAccount()
    {
        return this.ecAccount;
    }

    public void setEcAccount(String ecAccount)
    {
        this.ecAccount = ecAccount;
    }

    public String getCardNo()
    {
        return this.cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getPhoneType()
    {
        return this.phoneType;
    }

    public void setPhoneType(String phoneType)
    {
        this.phoneType = phoneType;
    }

    public String getSystemType()
    {
        return this.systemType;
    }

    public void setSystemType(String systemType)
    {
        this.systemType = systemType;
    }

    public String getBrowserType()
    {
        return this.browserType;
    }

    public void setBrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getScreenResolution()
    {
        return this.screenResolution;
    }

    public void setScreenResolution(String screenResolution)
    {
        this.screenResolution = screenResolution;
    }

    public String getScreenColor()
    {
        return this.screenColor;
    }

    public void setScreenColor(String screenColor)
    {
        this.screenColor = screenColor;
    }
}

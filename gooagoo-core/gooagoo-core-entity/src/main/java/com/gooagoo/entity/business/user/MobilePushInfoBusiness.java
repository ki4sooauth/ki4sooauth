package com.gooagoo.entity.business.user;

import java.io.Serializable;

public class MobilePushInfoBusiness implements Serializable
{
    private static final long serialVersionUID = -6885448170396379693L;

    private String ip;//服务器IP

    private int port;//服务器端口号

    private String macAddress;//MAC地址

    private String userId;//用户编号

    private String gooagooID;//gooagooID

    private String ipAddress;//IP地址

    private String hostName;//主机名

    private String phone;//手机号

    private String phoneType;//手机型号

    private String systemType;//操作系统类型

    private String browserType;//浏览器类型

    private String language;//浏览器语言设置

    private String screenResolution;//屏幕分辨率

    private String screenColor;//屏幕颜色

    public String getIp()
    {
        return this.ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public int getPort()
    {
        return this.port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

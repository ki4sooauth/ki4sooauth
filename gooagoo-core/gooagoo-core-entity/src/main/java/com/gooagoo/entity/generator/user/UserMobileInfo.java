package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户移动终端信息
 */

public class UserMobileInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号

    private String macAddress;//手机mac地址

    private String mId;//手机硬件id

    private String mVer;//手机程序版本

    private String mType;//手机系统类型

    private String sessionid;//手机登录后的SessionId值

    private String iphoneToken;//Iphone的token值

    private Date iphoneTokenTime;//得到tokentime的时间

    private Date cTimeStamp;//最后一次修改时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getMId()
    {
        return this.mId;
    }

    public void setMId(String mId)
    {
        this.mId = mId;
    }

    public String getMVer()
    {
        return this.mVer;
    }

    public void setMVer(String mVer)
    {
        this.mVer = mVer;
    }

    public String getMType()
    {
        return this.mType;
    }

    public void setMType(String mType)
    {
        this.mType = mType;
    }

    public String getSessionid()
    {
        return this.sessionid;
    }

    public void setSessionid(String sessionid)
    {
        this.sessionid = sessionid;
    }

    public String getIphoneToken()
    {
        return this.iphoneToken;
    }

    public void setIphoneToken(String iphoneToken)
    {
        this.iphoneToken = iphoneToken;
    }

    public Date getIphoneTokenTime()
    {
        return this.iphoneTokenTime;
    }

    public void setIphoneTokenTime(Date iphoneTokenTime)
    {
        this.iphoneTokenTime = iphoneTokenTime;
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
        return this.userId + "^" + this.macAddress + "^" + this.mId + "^" + this.mVer + "^" + this.mType + "^" + this.sessionid + "^" + this.iphoneToken + "^" + this.iphoneTokenTime + "^" + this.cTimeStamp;
    }
}

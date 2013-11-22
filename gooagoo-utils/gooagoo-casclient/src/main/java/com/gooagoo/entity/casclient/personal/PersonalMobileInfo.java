package com.gooagoo.entity.casclient.personal;

import java.io.Serializable;
import java.util.Date;

public class PersonalMobileInfo implements Serializable
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
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getMId()
    {
        return mId;
    }

    public void setMId(String mId)
    {
        this.mId = mId;
    }

    public String getMVer()
    {
        return mVer;
    }

    public void setMVer(String mVer)
    {
        this.mVer = mVer;
    }

    public String getMType()
    {
        return mType;
    }

    public void setMType(String mType)
    {
        this.mType = mType;
    }

    public String getSessionid()
    {
        return sessionid;
    }

    public void setSessionid(String sessionid)
    {
        this.sessionid = sessionid;
    }

    public String getIphoneToken()
    {
        return iphoneToken;
    }

    public void setIphoneToken(String iphoneToken)
    {
        this.iphoneToken = iphoneToken;
    }

    public Date getIphoneTokenTime()
    {
        return iphoneTokenTime;
    }

    public void setIphoneTokenTime(Date iphoneTokenTime)
    {
        this.iphoneTokenTime = iphoneTokenTime;
    }

    public Date getCTimeStamp()
    {
        return cTimeStamp;
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

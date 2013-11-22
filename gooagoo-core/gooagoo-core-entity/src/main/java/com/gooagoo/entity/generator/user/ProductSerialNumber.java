package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品序列号信息
 */

public class ProductSerialNumber implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String gooagooId;//产品序列号，UUID

    private String macAddress;//手机mac地址

    private String mId;//手机硬件id

    private String mVer;//手机程序版本

    private String mType;//手机系统类型

    private Date createTime;//创建时间

    public String getGooagooId()
    {
        return this.gooagooId;
    }

    public void setGooagooId(String gooagooId)
    {
        this.gooagooId = gooagooId;
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

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return this.gooagooId + "^" + this.macAddress + "^" + this.mId + "^" + this.mVer + "^" + this.mType + "^" + this.createTime;
    }
}

package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户反馈，收集用户对gooagooAPP的使用反馈
 */

public class UserFeedback implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String feedbackId;//反馈编号，UUID

    private String userId;//用户编号

    private String gooagooId;//gooagooID，平台分配给手机设备的唯一编号

    private String ipAddress;//IP地址

    private String macAddress;//MAC地址

    private String hostName;//主机名

    private String phone;//手机号

    private String phoneType;//手机型号

    private String version;//程序版本

    private String content;//反馈内容

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getFeedbackId()
    {
        return this.feedbackId;
    }

    public void setFeedbackId(String feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getGooagooId()
    {
        return this.gooagooId;
    }

    public void setGooagooId(String gooagooId)
    {
        this.gooagooId = gooagooId;
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

    public String getVersion()
    {
        return this.version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
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
        return this.feedbackId + "^" + this.userId + "^" + this.gooagooId + "^" + this.ipAddress + "^" + this.macAddress + "^" + this.hostName + "^" + this.phone + "^" + this.phoneType + "^" + this.version + "^" + this.content + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

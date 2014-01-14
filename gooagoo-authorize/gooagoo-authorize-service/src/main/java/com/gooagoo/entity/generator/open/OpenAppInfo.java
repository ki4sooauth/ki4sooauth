package com.gooagoo.entity.generator.open;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用基本信息表
 */

public class OpenAppInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer appKey;//应用KEY

    private String appName;//应用名称

    private String appType;//应用类型

    private String appLabel;//应用标签

    private String appSecret;//应用密钥

    private Integer volume;//证书流量

    private String appStatus;//应用状态

    private String userId;//用户ID

    private Date createDt;//应用创建时间

    private Date updateDt;//应用修改时间

    public Integer getAppKey()
    {
        return this.appKey;
    }

    public void setAppKey(Integer appKey)
    {
        this.appKey = appKey;
    }

    public String getAppName()
    {
        return this.appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getAppType()
    {
        return this.appType;
    }

    public void setAppType(String appType)
    {
        this.appType = appType;
    }

    public String getAppLabel()
    {
        return this.appLabel;
    }

    public void setAppLabel(String appLabel)
    {
        this.appLabel = appLabel;
    }

    public String getAppSecret()
    {
        return this.appSecret;
    }

    public void setAppSecret(String appSecret)
    {
        this.appSecret = appSecret;
    }

    public Integer getVolume()
    {
        return this.volume;
    }

    public void setVolume(Integer volume)
    {
        this.volume = volume;
    }

    public String getAppStatus()
    {
        return this.appStatus;
    }

    public void setAppStatus(String appStatus)
    {
        this.appStatus = appStatus;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Date getCreateDt()
    {
        return this.createDt;
    }

    public void setCreateDt(Date createDt)
    {
        this.createDt = createDt;
    }

    public Date getUpdateDt()
    {
        return this.updateDt;
    }

    public void setUpdateDt(Date updateDt)
    {
        this.updateDt = updateDt;
    }

    @Override
    public String toString()
    {
        return this.appKey + "^" + this.appName + "^" + this.appType + "^" + this.appLabel + "^" + this.appSecret + "^" + this.volume + "^" + this.appStatus + "^" + this.userId + "^" + this.createDt + "^" + this.updateDt;
    }
}

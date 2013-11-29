package com.gooagoo.authzserver.entity.business;

import java.io.Serializable;
import java.util.Date;

/**
 *授权code
 */
public class OauthCodeBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String appKey;//应用ID
    private String code;//临时token
    private Date createTime;//创建时间
    private Date expireTime;//过期时间

    public String getAppKey()
    {
        return this.appKey;
    }

    public void setAppKey(String appKey)
    {
        this.appKey = appKey;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getExpireTime()
    {
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime)
    {
        this.expireTime = expireTime;
    }

    @Override
    public String toString()
    {
        return "OauthCodeBusiness [appKey=" + this.appKey + ", code=" + this.code + ", createTime=" + this.createTime + ", expireTime=" + this.expireTime + "]";
    }
}

package com.gooagoo.entity.generator.open;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户和授权关系表
 */

public class OpenUserTokenRel implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tokenId;//访问ID

    private String userId;//用户ID

    private Integer appKey;//应用ID

    private Date expireTime;//过期时间

    private Date updateDt;//更新时间

    public String getTokenId()
    {
        return this.tokenId;
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getAppKey()
    {
        return this.appKey;
    }

    public void setAppKey(Integer appKey)
    {
        this.appKey = appKey;
    }

    public Date getExpireTime()
    {
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime)
    {
        this.expireTime = expireTime;
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
        return this.tokenId + "^" + this.userId + "^" + this.appKey + "^" + this.expireTime + "^" + this.updateDt;
    }
}

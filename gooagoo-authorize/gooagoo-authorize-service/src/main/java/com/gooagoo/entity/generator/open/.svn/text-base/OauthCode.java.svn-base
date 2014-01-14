package com.gooagoo.entity.generator.open;

import java.io.Serializable;
import java.util.Date;

/**
 * 授权code
 */

public class OauthCode implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer appKey;//应用ID

    private String code;//code

    private Date createTime;//创建时间

    private Date expireTime;//过期时间

    public Integer getAppKey()
    {
        return this.appKey;
    }

    public void setAppKey(Integer appKey)
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
        return this.appKey + "^" + this.code + "^" + this.createTime + "^" + this.expireTime;
    }
}

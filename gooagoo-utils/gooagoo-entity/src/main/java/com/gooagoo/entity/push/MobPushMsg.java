package com.gooagoo.entity.push;

import java.io.Serializable;

public class MobPushMsg implements Serializable
{
    private static final long serialVersionUID = 1L;
    /**消息流水号*/
    private String uuid;
    /**消息来源*/
    private String source;
    /**是否apn推送*/
    private String isApn;
    /**手机mac地址*/
    private String mac;
    /**推送内容*/
    private String content;

    public String getUuid()
    {
        return this.uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getIsApn()
    {
        return this.isApn;
    }

    public void setIsApn(String isApn)
    {
        this.isApn = isApn;
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}

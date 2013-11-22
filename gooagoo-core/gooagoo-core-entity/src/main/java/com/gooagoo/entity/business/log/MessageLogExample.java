package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消息日志，记录一般性的行为
 */

public class MessageLogExample implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String uuid; //uuid

    private String server; //server

    /*
     *  recetime_after< 要搜索的结果<recetime_before
     */
    private Date recetime_before; //查询这个时间之前的 

    private Date recetime_after; //查询这个时间之后的

    private Date sendtime_before;

    private Date sendtime_after;

    private String puuid; //puuid

    private String logType;//商家日志1，个人日志2，后台日志3

    private String source;//消息来源

    private String behaveCode;//记录接口编码

    private String behaveType;//记录行为类型

    //****************************************华丽的分割线*********************************//

    /**
     * UUID
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    /**
     * SERVER
     */
    public void setServer(String server)
    {
        this.server = server;
    }

    /**
     * 搜索在这个时间之前接收的
     */
    public void setRecetime_before(Date recetime_before)
    {
        this.recetime_before = recetime_before;
    }

    /**
     * 搜索在这个时间之后接收的
     */
    public Date getRecetime_after()
    {
        return this.recetime_after;
    }

    public void setRecetime_after(Date recetime_after)
    {
        this.recetime_after = recetime_after;
    }

    /**
     * 搜索在这个时间之前发送的
     */
    public void setSendtime_before(Date sendtime_before)
    {
        this.sendtime_before = sendtime_before;
    }

    /**
     * 搜索在这个时间之后发送的
     */
    public Date getSendtime_after()
    {
        return this.sendtime_after;
    }

    public void setSendtime_after(Date sendtime_after)
    {
        this.sendtime_after = sendtime_after;
    }

    /**
     * 父UUID
     */
    public void setPuuid(String puuid)
    {
        this.puuid = puuid;
    }

    public String getUuid()
    {
        return this.uuid;
    }

    public String getServer()
    {
        return this.server;
    }

    public Date getRecetime_before()
    {
        return this.recetime_before;
    }

    public Date getSendtime_before()
    {
        return this.sendtime_before;
    }

    public String getPuuid()
    {
        return this.puuid;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getBehaveCode()
    {
        return this.behaveCode;
    }

    public void setBehaveCode(String behaveCode)
    {
        this.behaveCode = behaveCode;
    }

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getLogType()
    {
        return this.logType;
    }

    public void setLogType(String logType)
    {
        this.logType = logType;
    }
}

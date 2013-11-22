package com.gooagoo.view.mis.common;

import java.io.Serializable;
import java.util.Date;

public class MMessageLog implements Serializable
{
    private static final long serialVersionUID = -2839396289937718791L;
    private String server;//消息到达服务名称
    private String source;//消息来源
    private String behaveCode;//记录接口编码
    private String behaveType;//记录行为类型
    private String logType;//商家日志1，个人日志2，后台日志3
    private Date recetime;//接收时间(消息到达时间)
    private Date recetimeBefore;//接收时间(消息到达时间)
    private Date recetimeAfter;//接收时间(消息到达时间)
    private Date sendtime;//发送时间(消息进入消息日志队列的时间)
    private Date sendtimeBefore;//发送时间(消息进入消息日志队列的时间)
    private Date sendtimeAfter;//发送时间(消息进入消息日志队列的时间)
    private String puuid;//父消息流水号
    private String exception;//异常信息(发送失败记录异常信息)

    private String uuid;//用于接收页面查询条件

    public String getServer()
    {
        return server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getBehaveType()
    {
        return behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getLogType()
    {
        return logType;
    }

    public void setLogType(String logType)
    {
        this.logType = logType;
    }

    public Date getRecetime()
    {
        return recetime;
    }

    public void setRecetime(Date recetime)
    {
        this.recetime = recetime;
    }

    public Date getRecetimeBefore()
    {
        return recetimeBefore;
    }

    public void setRecetimeBefore(Date recetimeBefore)
    {
        this.recetimeBefore = recetimeBefore;
    }

    public Date getRecetimeAfter()
    {
        return recetimeAfter;
    }

    public void setRecetimeAfter(Date recetimeAfter)
    {
        this.recetimeAfter = recetimeAfter;
    }

    public Date getSendtime()
    {
        return sendtime;
    }

    public void setSendtime(Date sendtime)
    {
        this.sendtime = sendtime;
    }

    public Date getSendtimeBefore()
    {
        return sendtimeBefore;
    }

    public void setSendtimeBefore(Date sendtimeBefore)
    {
        this.sendtimeBefore = sendtimeBefore;
    }

    public Date getSendtimeAfter()
    {
        return sendtimeAfter;
    }

    public void setSendtimeAfter(Date sendtimeAfter)
    {
        this.sendtimeAfter = sendtimeAfter;
    }

    public String getPuuid()
    {
        return puuid;
    }

    public void setPuuid(String puuid)
    {
        this.puuid = puuid;
    }

    public String getException()
    {
        return exception;
    }

    public void setException(String exception)
    {
        this.exception = exception;
    }

    public String getBehaveCode()
    {
        return behaveCode;
    }

    public void setBehaveCode(String behaveCode)
    {
        this.behaveCode = behaveCode;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

}

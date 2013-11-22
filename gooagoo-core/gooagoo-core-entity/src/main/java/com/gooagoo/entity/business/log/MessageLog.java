package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息路由日志
 * 服务名称
 * 1-手机APP
 * 2-手机网站
 * 3-个人消费中心
 * 4-定位引擎
 * 5-转发器
 * 6-店员助理
 * 7-商家管理中心
 * 8-购阿购管理系统
 * 9-推送分析
 * 10-实时统计
 * 11-营销引擎
 * 12-手机推送系统
 * 13-邮件系统
 * 14-短信系统
 * 15-消息服务总线
 */
public class MessageLog implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String uuid;//消息流水号(发送消息的流水号)
    private String server;//消息到达服务名称
    private String source;//消息来源
    private String logType;//商家日志1，个人日志2，后台日志3
    private String behaveCode;//记录接口编码
    private String behaveType;//记录行为类型
    private Date recetime;//接收时间(消息到达时间)
    private Date sendtime;//发送时间(消息进入消息日志队列的时间)
    private String puuid;//父消息流水号
    private String exception;//异常信息(发送失败记录异常信息)

    public String getPuuid()
    {
        return this.puuid;
    }

    public void setPuuid(String puuid)
    {
        this.puuid = puuid;
    }

    public String getUuid()
    {
        return this.uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getLogType()
    {
        return this.logType;
    }

    public void setLogType(String logType)
    {
        this.logType = logType;
    }

    public String getServer()
    {
        return this.server;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public void setServer(String server)
    {
        this.server = server;
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

    public Date getRecetime()
    {
        return this.recetime;
    }

    public void setRecetime(Date recetime)
    {
        this.recetime = recetime;
    }

    public Date getSendtime()
    {
        return this.sendtime;
    }

    public void setSendtime(Date sendtime)
    {
        this.sendtime = sendtime;
    }

    public String getException()
    {
        return this.exception;
    }

    public void setException(String exception)
    {
        this.exception = exception;
    }

}

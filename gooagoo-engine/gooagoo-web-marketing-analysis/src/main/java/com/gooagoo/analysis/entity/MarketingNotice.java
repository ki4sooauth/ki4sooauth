package com.gooagoo.analysis.entity;

import java.io.Serializable;

/**
 * 推送内容实体
 */
public class MarketingNotice<T> implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String type;//通知渠道:push-推送，email-邮件，message-短信，http-接口方式
    private T gooagooMessage;//GooagooMessage消息

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public T getGooagooMessage()
    {
        return this.gooagooMessage;
    }

    public void setGooagooMessage(T gooagooMessage)
    {
        this.gooagooMessage = gooagooMessage;
    }

}

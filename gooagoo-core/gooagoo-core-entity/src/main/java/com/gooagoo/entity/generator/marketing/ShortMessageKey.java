package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 短信内容表
 */

public class ShortMessageKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String messageId;//短信编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}

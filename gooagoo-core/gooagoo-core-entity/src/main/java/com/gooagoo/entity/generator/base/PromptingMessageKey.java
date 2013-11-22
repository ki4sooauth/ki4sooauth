package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 提示信息字典表
 */

public class PromptingMessageKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String messageId;//提示信息编码

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

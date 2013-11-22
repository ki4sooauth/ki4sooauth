package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 邮件内容配置
 */

public class EmailConfigKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String emailId;//邮件编码，参考字典表的邮件模板类型

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
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

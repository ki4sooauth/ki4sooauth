package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件内容配置
 */

public class EmailConfig implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String emailId;//邮件编码，参考字典表的邮件模板类型

    private String content;//邮件内容

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getEmailId()
    {
        return this.emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.emailId + "^" + this.content + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

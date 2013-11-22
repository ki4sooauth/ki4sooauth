package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 提示信息字典表
 */

public class PromptingMessage implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String messageId;//提示信息编码

    private String content;//提示信息内容

    private String sys;//所属系统（中文）

    private String func;//所属功能（中文）

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getMessageId()
    {
        return this.messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSys()
    {
        return this.sys;
    }

    public void setSys(String sys)
    {
        this.sys = sys;
    }

    public String getFunc()
    {
        return this.func;
    }

    public void setFunc(String func)
    {
        this.func = func;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
        return this.messageId + "^" + this.content + "^" + this.sys + "^" + this.func + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

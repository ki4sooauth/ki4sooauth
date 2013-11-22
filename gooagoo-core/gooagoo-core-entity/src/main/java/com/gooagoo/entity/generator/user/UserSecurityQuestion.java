package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户密保问题表
 */

public class UserSecurityQuestion implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//问题编号，UUID

    private String userId;//用户编号

    private String type;//问题类型，1-系统内置问题，2-用户自定义问题

    private String sysId;//系统问题编号

    private String content;//问题内容

    private String answer;//问题答案

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getSysId()
    {
        return this.sysId;
    }

    public void setSysId(String sysId)
    {
        this.sysId = sysId;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getAnswer()
    {
        return this.answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
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
        return this.id + "^" + this.userId + "^" + this.type + "^" + this.sysId + "^" + this.content + "^" + this.answer + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

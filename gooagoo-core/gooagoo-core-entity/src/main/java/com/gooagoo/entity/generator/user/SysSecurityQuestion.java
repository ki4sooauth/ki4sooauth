package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统密保问题表
 */

public class SysSecurityQuestion implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysId;//问题编号，UUID

    private String content;//问题内容

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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
        return this.sysId + "^" + this.content + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

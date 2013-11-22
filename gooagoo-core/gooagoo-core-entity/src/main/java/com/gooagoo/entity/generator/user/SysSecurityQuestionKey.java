package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 系统密保问题表
 */

public class SysSecurityQuestionKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysId;//问题编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getSysId()
    {
        return sysId;
    }

    public void setSysId(String sysId)
    {
        this.sysId = sysId;
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

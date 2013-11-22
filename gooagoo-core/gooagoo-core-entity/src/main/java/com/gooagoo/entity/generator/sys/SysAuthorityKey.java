package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 权限表，由数据库管理员维护，只有在新增功能时才有可能变动
 */

public class SysAuthorityKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String authorityId;//权限ID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getAuthorityId()
    {
        return authorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
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

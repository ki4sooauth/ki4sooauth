package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色-权限关联
 */

public class SysRoleAuthority implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysRoleAuthorityId;//自动编号，唯一，通过UUID产生

    private String roleId;//角色ID

    private String authorityId;//权限ID

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getSysRoleAuthorityId()
    {
        return this.sysRoleAuthorityId;
    }

    public void setSysRoleAuthorityId(String sysRoleAuthorityId)
    {
        this.sysRoleAuthorityId = sysRoleAuthorityId;
    }

    public String getRoleId()
    {
        return this.roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public String getAuthorityId()
    {
        return this.authorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
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
        return this.sysRoleAuthorityId + "^" + this.roleId + "^" + this.authorityId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

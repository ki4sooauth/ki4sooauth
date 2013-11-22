package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户-角色关联
 */

public class ShopUserRole implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysUserRoleId;//自动编号，唯一，通过UUID产生

    private String userId;//用户ID

    private String roleId;//角色ID

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getSysUserRoleId()
    {
        return this.sysUserRoleId;
    }

    public void setSysUserRoleId(String sysUserRoleId)
    {
        this.sysUserRoleId = sysUserRoleId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getRoleId()
    {
        return this.roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
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
        return this.sysUserRoleId + "^" + this.userId + "^" + this.roleId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

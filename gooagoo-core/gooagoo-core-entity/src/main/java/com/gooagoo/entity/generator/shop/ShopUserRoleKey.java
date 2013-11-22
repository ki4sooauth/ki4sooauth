package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 用户-角色关联
 */

public class ShopUserRoleKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysUserRoleId;//自动编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getSysUserRoleId()
    {
        return sysUserRoleId;
    }

    public void setSysUserRoleId(String sysUserRoleId)
    {
        this.sysUserRoleId = sysUserRoleId;
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

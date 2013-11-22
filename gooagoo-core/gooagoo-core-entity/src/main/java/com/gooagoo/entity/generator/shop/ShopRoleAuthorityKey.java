package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 角色-权限关联
 */

public class ShopRoleAuthorityKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysRoleAuthorityId;//自动编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getSysRoleAuthorityId()
    {
        return sysRoleAuthorityId;
    }

    public void setSysRoleAuthorityId(String sysRoleAuthorityId)
    {
        this.sysRoleAuthorityId = sysRoleAuthorityId;
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

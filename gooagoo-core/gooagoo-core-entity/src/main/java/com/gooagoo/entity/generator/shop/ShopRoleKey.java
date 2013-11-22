package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 用户角色表
 */

public class ShopRoleKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String roleId;//角色编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
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

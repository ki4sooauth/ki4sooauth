package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 角色-权限关联
 */

public class ShopRoleAuthority2Key implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

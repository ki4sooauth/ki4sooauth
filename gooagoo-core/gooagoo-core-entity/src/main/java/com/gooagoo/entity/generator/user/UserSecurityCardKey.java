package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 用户密保卡表
 */

public class UserSecurityCardKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//密保卡编号，UUID

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

package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 个人用户表
 */

public class UserInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

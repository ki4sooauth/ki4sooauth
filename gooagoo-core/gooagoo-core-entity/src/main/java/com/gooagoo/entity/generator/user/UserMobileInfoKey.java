package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 用户移动终端信息
 */

public class UserMobileInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

}

package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 用户辅助信息
 */

public class UserProfileKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，关联user_info表的用户编号

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

}

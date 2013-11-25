package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 后台管理系统用户信息表
 */

public class SysUserInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户电子邮箱，由数字、字母、下划线、@组成

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
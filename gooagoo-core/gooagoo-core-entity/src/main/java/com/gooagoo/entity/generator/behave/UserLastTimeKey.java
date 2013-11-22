package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 用户最后一次足迹以及购物时间
 */

public class UserLastTimeKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}

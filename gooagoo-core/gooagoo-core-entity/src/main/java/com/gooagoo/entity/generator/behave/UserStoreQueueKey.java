package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 排号记录，当餐桌够用时，不进行排号，餐桌不够用时才进行排号，由店员进行销号。当号码都已经消除，则重新排号。所有类型的餐桌
 */

public class UserStoreQueueKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

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

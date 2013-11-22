package com.gooagoo.view.gms.crm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FUserDetail implements Serializable
{
    private String id; //编号，对象redis中的键值
    private String name; //用户组名称
    private String desc; //用户组描述

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

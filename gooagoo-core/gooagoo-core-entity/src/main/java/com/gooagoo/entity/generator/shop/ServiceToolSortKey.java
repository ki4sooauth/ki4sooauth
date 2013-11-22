package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 服务工具排序
 */

public class ServiceToolSortKey implements Serializable
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

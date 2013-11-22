package com.gooagoo.view.gms.good;

import java.io.Serializable;

/**
 * 实体店，位置等的节点信息
 *
 */
public class FZtreeNode implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id;// id值
    private String name;// 名称

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

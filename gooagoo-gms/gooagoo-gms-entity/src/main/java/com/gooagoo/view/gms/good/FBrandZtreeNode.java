package com.gooagoo.view.gms.good;

import java.io.Serializable;

/**
 * 品牌的节点信息
 *
 */
public class FBrandZtreeNode implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String i;// id值
    private String id;// 品牌编号
    private String name;// 品牌名称

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

    public String getI()
    {
        return this.i;
    }

    public void setI(String i)
    {
        this.i = i;
    }
}

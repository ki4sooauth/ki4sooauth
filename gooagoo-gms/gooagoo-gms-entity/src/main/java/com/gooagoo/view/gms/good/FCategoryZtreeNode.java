package com.gooagoo.view.gms.good;

import java.io.Serializable;

/**
 * 品类的节点信息
 *
 */
public class FCategoryZtreeNode implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String i;//id值 
    private String id;// 品类编号
    private String pId;// 父品类编号
    private String rId;// 根品类编号
    private String name;// 品类名称
    private boolean open;// 是否打开

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getpId()
    {
        return this.pId;
    }

    public void setpId(String pId)
    {
        this.pId = pId;
    }

    public String getrId()
    {
        return this.rId;
    }

    public void setrId(String rId)
    {
        this.rId = rId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isOpen()
    {
        return this.open;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
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

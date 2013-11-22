package com.gooagoo.view.mis.common;

import java.io.Serializable;

public class MLeftMenu implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name = "";//左侧菜单名称
    private String authority = "";//左侧菜单权限
    private MNode[] Node;//子菜单

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public MNode[] getNode()
    {
        return this.Node;
    }

    public void setNode(MNode[] node)
    {
        this.Node = node;
    }

}

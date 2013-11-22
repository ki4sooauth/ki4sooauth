package com.gooagoo.view.mis.common;

import java.io.Serializable;

public class MNode implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name = "";//子菜单名称
    private String authority = "";//子菜单权限
    private String link = "";//子菜单链接

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

    public String getLink()
    {
        return this.link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

}

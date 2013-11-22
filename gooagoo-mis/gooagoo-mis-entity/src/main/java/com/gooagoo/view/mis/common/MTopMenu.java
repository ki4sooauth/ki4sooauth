package com.gooagoo.view.mis.common;

import java.io.Serializable;

public class MTopMenu implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String name = "";//顶部菜单名称
    private String authority = "";//顶部菜单权限
    private MLeftMenu[] LeftMenu;//左侧菜单

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

    public MLeftMenu[] getLeftMenu()
    {
        return this.LeftMenu;
    }

    public void setLeftMenu(MLeftMenu[] leftMenu)
    {
        this.LeftMenu = leftMenu;
    }

}

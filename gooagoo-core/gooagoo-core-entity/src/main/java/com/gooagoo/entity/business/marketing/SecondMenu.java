package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

/**
 *  二级菜单 
 */
public class SecondMenu implements Serializable
{

    private static final long serialVersionUID = 1L;

    /**  二级菜单编码  */
    private String secondmenucode = "";

    /**  二级菜单名称  */
    private String secondmenuname = "";

    /**
     * 设置 二级菜单编码 
     * @param secondmenucode	 二级菜单编码 
     */
    public void setSecondmenucode(String secondmenucode)
    {
        this.secondmenucode = secondmenucode;
    }

    /**
     * 获取 二级菜单编码 
     * @return	 二级菜单编码 
     */
    public String getSecondmenucode()
    {
        return this.secondmenucode;
    }

    /**
     * 设置 二级菜单名称 
     * @param secondmenuname	 二级菜单名称 
     */
    public void setSecondmenuname(String secondmenuname)
    {
        this.secondmenuname = secondmenuname;
    }

    /**
     * 获取 二级菜单名称 
     * @return	 二级菜单名称 
     */
    public String getSecondmenuname()
    {
        return this.secondmenuname;
    }
}
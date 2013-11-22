package com.gooagoo.template.entity;

import java.io.Serializable;

public class FNode implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String code;//编码
    private String name;//名称
    private String parentCode;//父节点
    private String icon;//图像连接地址
    private String remarks;//备注

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getParentCode()
    {
        return this.parentCode;
    }

    public void setParentCode(String parentCode)
    {
        this.parentCode = parentCode;
    }

    public String getIcon()
    {
        return this.icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getRemarks()
    {
        return this.remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

}

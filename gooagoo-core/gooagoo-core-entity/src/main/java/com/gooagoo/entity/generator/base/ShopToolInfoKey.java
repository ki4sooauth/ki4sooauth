package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 商家服务工具字典表
 */

public class ShopToolInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String toolId;//服务工具编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getToolId()
    {
        return toolId;
    }

    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}

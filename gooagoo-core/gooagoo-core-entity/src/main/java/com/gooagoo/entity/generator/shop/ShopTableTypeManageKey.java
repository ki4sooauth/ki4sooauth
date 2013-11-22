package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 餐桌类型管理
 */

public class ShopTableTypeManageKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tableTypeCode;//餐桌类型编码，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getTableTypeCode()
    {
        return tableTypeCode;
    }

    public void setTableTypeCode(String tableTypeCode)
    {
        this.tableTypeCode = tableTypeCode;
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

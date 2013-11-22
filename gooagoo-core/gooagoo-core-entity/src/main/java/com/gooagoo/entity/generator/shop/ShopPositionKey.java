package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 位置管理表
 */

public class ShopPositionKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String positionId;//位置编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
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

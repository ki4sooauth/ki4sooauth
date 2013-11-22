package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家LID详细分配信息
 */

public class ShopLidDetailKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lid;//LID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getLid()
    {
        return lid;
    }

    public void setLid(String lid)
    {
        this.lid = lid;
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

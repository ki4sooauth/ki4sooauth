package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家LID基本信息
 */

public class ShopLidInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lidBase;//LID基本信息，完整LID的前6位表示商家或实体店，此处只保存完整LID的前6位

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getLidBase()
    {
        return lidBase;
    }

    public void setLidBase(String lidBase)
    {
        this.lidBase = lidBase;
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

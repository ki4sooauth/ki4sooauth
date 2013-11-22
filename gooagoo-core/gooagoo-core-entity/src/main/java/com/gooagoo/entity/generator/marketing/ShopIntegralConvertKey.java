package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 积分兑换信息
 */

public class ShopIntegralConvertKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopIntegralConvertId;//积分兑换信息编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShopIntegralConvertId()
    {
        return shopIntegralConvertId;
    }

    public void setShopIntegralConvertId(String shopIntegralConvertId)
    {
        this.shopIntegralConvertId = shopIntegralConvertId;
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

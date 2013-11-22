package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 积分商城
 */

public class ShopIntegralKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopIntegralId;//积分营销编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShopIntegralId()
    {
        return shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
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

package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户订单原始信息商品详情
 */

public class UserOrderDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderDetailId;//订单明细编号

    private String userOrderId;//用户订单编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private Double goodsPrice;//商品单价

    private Double payPrice;//实际支付单价

    private Integer goodsNum;//商品数量

    private Double totalPrice;//实际支付总价=商品数量×实际支付单价

    private String userId;//提交者

    public String getUserOrderDetailId()
    {
        return this.userOrderDetailId;
    }

    public void setUserOrderDetailId(String userOrderDetailId)
    {
        this.userOrderDetailId = userOrderDetailId;
    }

    public String getUserOrderId()
    {
        return this.userOrderId;
    }

    public void setUserOrderId(String userOrderId)
    {
        this.userOrderId = userOrderId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice()
    {
        return this.goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public Double getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(Double payPrice)
    {
        this.payPrice = payPrice;
    }

    public Integer getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public Double getTotalPrice()
    {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return this.userOrderDetailId + "^" + this.userOrderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.goodsPrice + "^" + this.payPrice + "^" + this.goodsNum + "^" + this.totalPrice + "^" + this.userId;
    }
}

package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 原始账单商品详情
 */

public class OriginalBillDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billDetailId;//账单明细编号，UUID

    private String billId;//账单编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private Double goodsPrice;//商品单价

    private Double payPrice;//实际支付单价

    private Integer goodsNum;//商品数量

    private Double totalPrice;//实际支付总价=商品数量×实际支付单价

    private String goodsItemSerial;//商品自定义序列号

    public String getBillDetailId()
    {
        return this.billDetailId;
    }

    public void setBillDetailId(String billDetailId)
    {
        this.billDetailId = billDetailId;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
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

    public String getGoodsItemSerial()
    {
        return this.goodsItemSerial;
    }

    public void setGoodsItemSerial(String goodsItemSerial)
    {
        this.goodsItemSerial = goodsItemSerial;
    }

    @Override
    public String toString()
    {
        return "OriginalBillDetail [billDetailId=" + this.billDetailId + ", billId=" + this.billId + ", shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", goodsId=" + this.goodsId + ", goodsName=" + this.goodsName + ", goodsPrice=" + this.goodsPrice + ", payPrice=" + this.payPrice + ", goodsNum=" + this.goodsNum + ", totalPrice=" + this.totalPrice + ", goodsItemSerial=" + this.goodsItemSerial + "]";
    }

}

package com.gooagoo.trans.common;

import java.io.Serializable;

public class OrderGoodsInfo implements Serializable
{

    /**
     * 账单明细中商品信息
     */
    private static final long serialVersionUID = 1L;

    public String goodsId;//商品编号

    public String goodsName;//商品名称

    public Double goodsPrice = 0.0;//商品单价

    public Integer goodsTotalNum = 0;//商品个数

    public Double goodsTotalPrice = 0.0;//商品总价格

    public String goodsItemSerial;//商品条形码（自定义序列号）

    /**
     * 商品名称
     * @return
     */
    public String getGoodsName()
    {
        return this.goodsName;
    }

    /**
     * 商品名称
     * @return
     */
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    /**
     * 商品单价
     * @return
     */
    public Double getGoodsPrice()
    {
        return this.goodsPrice;
    }

    /**
     * 商品单价
     * @return
     */
    public void setGoodsPrice(Double goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 商品个数
     * @return
     */
    public Integer getGoodsTotalNum()
    {
        return this.goodsTotalNum;
    }

    /**
     * 商品个数
     * @return
     */
    public void setGoodsTotalNum(Integer goodsTotalNum)
    {
        this.goodsTotalNum = goodsTotalNum;
    }

    /**
     * 商品编号
     * @return
     */
    public String getGoodsId()
    {
        return this.goodsId;
    }

    /**
     * 商品编号
     * @return
     */
    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    /**
     * 商品总价格
     * @return
     */
    public Double getGoodsTotalPrice()
    {
        return this.goodsTotalPrice;
    }

    /**
     * 商品总价格
     * @return
     */
    public void setGoodsTotalPrice(Double goodsTotalPrice)
    {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    /**
     * 商品条形码（自定义序列号）
     * @return
     */
    public String getGoodsItemSerial()
    {
        return this.goodsItemSerial;
    }

    /**
     * 商品条形码（自定义序列号）
     * @return
     */
    public void setGoodsItemSerial(String goodsItemSerial)
    {
        this.goodsItemSerial = goodsItemSerial;
    }

    @Override
    public String toString()
    {
        return "OrderGoodsInfo [goodsId=" + this.goodsId + ", goodsName=" + this.goodsName + ", goodsPrice=" + this.goodsPrice + ", goodsTotalNum=" + this.goodsTotalNum + ", goodsTotalPrice=" + this.goodsTotalPrice + ", goodsItemSerial=" + this.goodsItemSerial + "]";
    }

}

package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 订单商品详细信息
 */

public class OrderDetailInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号，UUID

    private String orderId;//订单编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称（来自账单文件）

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsCategoryRoot;//品类编号（根节点）

    private String goodsCategoryLeaf;//品类编号（叶节点）

    private String goodsBrand;//品牌编号

    private String goodsSerial;//商品序列号（商品的唯一识别编码）

    private String itemSerial;//自定义序列号（商品细分的唯一识别编码）

    private Double price;//商品价格

    private String goodsImg;//商品主图地址

    private Double payPrice;//实际支付单价（来自账单文件）

    private Integer goodsNum;//商品数量（来自账单文件）

    private Double goodsWeight;//'商品重量（来自账单文件）',

    private Double totalPrice;//实际支付总价=商品数量×实际支付单价

    private String userId;//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）

    private String avoidItem;//'忌口',

    private Integer serveNum;//上菜情况（仅针对餐饮），默认值为0

    private String commentId;//评论编号

    public String getOrderDetailId()
    {
        return this.orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    public String getGoodsCategoryRoot()
    {
        return this.goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return this.goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
    }

    public String getGoodsBrand()
    {
        return this.goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSerial()
    {
        return this.goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return this.itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
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

    public Double getGoodsWeight()
    {
        return this.goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight)
    {
        this.goodsWeight = goodsWeight;
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

    public String getAvoidItem()
    {
        return this.avoidItem;
    }

    public void setAvoidItem(String avoidItem)
    {
        this.avoidItem = avoidItem;
    }

    public Integer getServeNum()
    {
        return this.serveNum;
    }

    public void setServeNum(Integer serveNum)
    {
        this.serveNum = serveNum;
    }

    public String getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    @Override
    public String toString()
    {
        return this.orderDetailId + "^" + this.orderId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.goodsCategoryRoot + "^" + this.goodsCategoryLeaf + "^" + this.goodsBrand + "^" + this.goodsSerial + "^" + this.itemSerial + "^" + this.price + "^" + this.goodsImg + "^" + this.payPrice + "^" + this.goodsNum + "^" + this.goodsWeight + "^" + this.totalPrice + "^" + this.userId + "^" + this.avoidItem + "^" + this.serveNum + "^" + this.commentId;
    }
}

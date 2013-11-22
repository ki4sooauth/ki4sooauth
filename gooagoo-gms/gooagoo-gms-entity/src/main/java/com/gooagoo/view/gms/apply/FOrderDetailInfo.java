package com.gooagoo.view.gms.apply;

import java.io.Serializable;

/**
 * 订单商品详细信息
 */

public class FOrderDetailInfo implements Serializable
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

    private Double totalPrice;//实际支付总价=商品数量×实际支付单价

    private String userId;//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）

    private Integer serveNum;//上菜情况（仅针对餐饮），默认值为0

    private String commentId;//评论编号

    public String getOrderDetailId()
    {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getGoodsCategoryRoot()
    {
        return goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
    }

    public String getGoodsBrand()
    {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSerial()
    {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public Double getPayPrice()
    {
        return payPrice;
    }

    public void setPayPrice(Double payPrice)
    {
        this.payPrice = payPrice;
    }

    public Integer getGoodsNum()
    {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getServeNum()
    {
        return serveNum;
    }

    public void setServeNum(Integer serveNum)
    {
        this.serveNum = serveNum;
    }

    public String getCommentId()
    {
        return commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    public String toString()
    {
        return this.orderDetailId + "^" + this.orderId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.goodsCategoryRoot + "^" + this.goodsCategoryLeaf + "^" + this.goodsBrand + "^" + this.goodsSerial + "^" + this.itemSerial + "^" + this.price + "^" + this.goodsImg + "^" + this.payPrice + "^" + this.goodsNum + "^" + this.totalPrice + "^" + this.userId + "^" + this.serveNum + "^" + this.commentId;
    }
}

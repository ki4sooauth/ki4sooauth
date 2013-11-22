package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

public class OrderGoodsBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billDetailId;//帐单详细ID

    private String goodsId;//商品ID

    private String shopId; //商家ID

    private String goodsName;//商品名称

    private String goodsImg;//商品图片

    private Double payPrice;//实际支付单价

    private Double save;//节省

    private String billId;//账单ID

    private String pic;//访问地址

    private Double priceChange;//差价

    private Integer goodsNum;//商品购买数量

    private String commentId;//评论id

    private Integer commentLevel; //评分

    private String content; //评论内容

    public String getBillDetailId()
    {
        return billDetailId;
    }

    public void setBillDetailId(String billDetailId)
    {
        this.billDetailId = billDetailId;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
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

    public Double getSave()
    {
        return save;
    }

    public void setSave(Double save)
    {
        this.save = save;
    }

    public String getBillId()
    {
        return billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getPic()
    {
        return pic;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public Double getPriceChange()
    {
        return priceChange;
    }

    public void setPriceChange(Double priceChange)
    {
        this.priceChange = priceChange;
    }

    public Integer getGoodsNum()
    {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getCommentId()
    {
        return commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    public Integer getCommentLevel()
    {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel)
    {
        this.commentLevel = commentLevel;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}

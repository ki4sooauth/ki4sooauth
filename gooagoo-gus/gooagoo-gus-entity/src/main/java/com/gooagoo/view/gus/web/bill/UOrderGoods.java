package com.gooagoo.view.gus.web.bill;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UOrderGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String billDetailId;//帐单详细ID

    private String goodsId;//商品ID

    private String shopId; //商家ID

    private String goodsName;//商品名称

    private Image goodsImg;//商品图片

    private String payPrice;//实际支付单价

    private String save;//节省

    private String billId;//账单ID

    private String picUrl;//访问地址

    private String priceChange;//差价

    private Integer goodsNum;//商品购买数量

    private String priceChangeName;//涨价/降价

    private String commentId;//评论id

    private Integer commentLevel; //评分

    private String content; //评论内容

    public String getPriceChangeName()
    {
        return this.priceChangeName;
    }

    public void setPriceChangeName(String priceChangeName)
    {
        this.priceChangeName = priceChangeName;
    }

    public String getBillDetailId()
    {
        return this.billDetailId;
    }

    public void setBillDetailId(String billDetailId)
    {
        this.billDetailId = billDetailId;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public Image getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(Image goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(String payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getSave()
    {
        return this.save;
    }

    public void setSave(String save)
    {
        this.save = save;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getPriceChange()
    {
        return this.priceChange;
    }

    public void setPriceChange(String priceChange)
    {
        this.priceChange = priceChange;
    }

    public Integer getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    public Integer getCommentLevel()
    {
        return this.commentLevel;
    }

    public void setCommentLevel(Integer commentLevel)
    {
        this.commentLevel = commentLevel;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}

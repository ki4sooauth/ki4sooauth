package com.gooagoo.entity.business.user.account.consume;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消费档案
 *
 */
public class ConsumeRecord implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String accountType;//帐号类型（gooagoo帐号、物理卡号、电子卡号、mac地址、gooagooid、电子商务网站帐号、手机号码）
    private String accountNo;//帐号
    private String orderNo; //商家订单编号
    private String money;//消费金额
    private String billId; //帐单编号
    private Date consumeTime;//消费发生时间
    private String billDetailId;//账单/订单明细编号，UUID
    private String goodsId;//商品编号
    private String goodsName;//商品名称
    private Double goodsPrice;//商品单价
    private String goodsSn;//商品条形码
    private String goodsSubject;//商品主题
    private String goodsImg;//商品图片地址
    private Double payPrice;//实际支付单价
    private Integer goodsNum;//商品数量
    private Double totalPrice;//实际支付总价=商品数量×实际支付单价
    private String commentId;//评论编号
    private String billImg;//账单图片

    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccountNo()
    {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

    public String getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getMoney()
    {
        return this.money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public Date getConsumeTime()
    {
        return this.consumeTime;
    }

    public void setConsumeTime(Date consumeTime)
    {
        this.consumeTime = consumeTime;
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

    public String getGoodsSn()
    {
        return this.goodsSn;
    }

    public void setGoodsSn(String goodsSn)
    {
        this.goodsSn = goodsSn;
    }

    public String getGoodsSubject()
    {
        return this.goodsSubject;
    }

    public void setGoodsSubject(String goodsSubject)
    {
        this.goodsSubject = goodsSubject;
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

    public Double getTotalPrice()
    {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    public String getBillImg()
    {
        return this.billImg;
    }

    public void setBillImg(String billImg)
    {
        this.billImg = billImg;
    }

}

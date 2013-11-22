package com.gooagoo.view.gus.web.bill;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.view.gus.common.Image;

public class UOrderInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String orderId;//订单编号，UUID
    private String shopId;//商家编号
    private String shopName;//商家名称
    private Image logo1;//商家logo1，正方形
    private List<Image> couponImgList; //使用的优惠凭证图片
    private String requestTime;//消费时间
    private String payPrice;//实际支付总价
    private String picUrl;//账单图片地址

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Image getLogo1()
    {
        return this.logo1;
    }

    public void setLogo1(Image logo1)
    {
        this.logo1 = logo1;
    }

    public List<Image> getCouponImgList()
    {
        return this.couponImgList;
    }

    public void setCouponImgList(List<Image> couponImgList)
    {
        this.couponImgList = couponImgList;
    }

    public String getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime)
    {
        this.requestTime = requestTime;
    }

    public String getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(String payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }
}

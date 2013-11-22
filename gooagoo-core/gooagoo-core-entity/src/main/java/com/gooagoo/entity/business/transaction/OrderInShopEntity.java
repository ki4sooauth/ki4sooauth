package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

/**
 * 店内消费记录
 * @author YL
 *
 */
public class OrderInShopEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String userid;//用户编号
    private String OrderId;//订单编号
    private String payprice;//总金额
    private String requesttime;//消费时间

    public String getUserid()
    {
        return this.userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getOrderId()
    {
        return this.OrderId;
    }

    public void setOrderId(String orderId)
    {
        this.OrderId = orderId;
    }

    public String getPayprice()
    {
        return this.payprice;
    }

    public void setPayprice(String payprice)
    {
        this.payprice = payprice;
    }

    public String getRequesttime()
    {
        return this.requesttime;
    }

    public void setRequesttime(String requesttime)
    {
        this.requesttime = requesttime;
    }

    @Override
    public String toString()
    {
        return "BillInShopEntity [userid=" + this.userid + ", OrderId=" + this.OrderId + ", payprice=" + this.payprice + ", requesttime=" + this.requesttime + "]";
    }

}

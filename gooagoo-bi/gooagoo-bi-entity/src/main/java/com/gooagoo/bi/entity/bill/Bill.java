package com.gooagoo.bi.entity.bill;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;

public class Bill
{
    private String source;
    private OrderInfo orderInfo = new OrderInfo();
    private List<String> coupons = new ArrayList<String>(); //优惠凭证id
    private List<OrderDetailInfo> orderDetailInfos = new ArrayList<OrderDetailInfo>();

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public OrderInfo getOrderInfo()
    {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo)
    {
        this.orderInfo = orderInfo;
    }

    public List<String> getCoupons()
    {
        return coupons;
    }

    public void setCoupons(List<String> coupons)
    {
        this.coupons = coupons;
    }

    public List<OrderDetailInfo> getOrderDetailInfos()
    {
        return orderDetailInfos;
    }

    public void setOrderDetailInfos(List<OrderDetailInfo> orderDetailInfos)
    {
        this.orderDetailInfos = orderDetailInfos;
    }

}

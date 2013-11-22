package com.gooagoo.view.gms.apply;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单图片详情
 */

public class FOrderPic implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号，UUID

    private String orderId;//订单编号

    private String picUrl;//图片地址

    private String picType;//图片类型，0-订单图片，1-账单图片

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

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

    public String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getPicType()
    {
        return picType;
    }

    public void setPicType(String picType)
    {
        this.picType = picType;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String toString()
    {
        return this.orderDetailId + "^" + this.orderId + "^" + this.picUrl + "^" + this.picType + "^" + this.isDel + "^" + this.createTime;
    }
}

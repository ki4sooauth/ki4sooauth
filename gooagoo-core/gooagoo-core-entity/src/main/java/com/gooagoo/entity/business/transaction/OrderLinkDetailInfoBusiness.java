package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.business.marketing.IsdeletedInfo;

public class OrderLinkDetailInfoBusiness implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<OrderDetailInfoBusiness> orderDetailInfoBusiness;

    private IsdeletedInfo isdeletedInfo;

    public List<OrderDetailInfoBusiness> getOrderDetailInfoBusiness()
    {
        return this.orderDetailInfoBusiness;
    }

    public void setOrderDetailInfoBusiness(List<OrderDetailInfoBusiness> orderDetailInfoBusiness)
    {
        this.orderDetailInfoBusiness = orderDetailInfoBusiness;
    }

    public IsdeletedInfo getIsdeletedInfo()
    {
        return this.isdeletedInfo;
    }

    public void setIsdeletedInfo(IsdeletedInfo isdeletedInfo)
    {
        this.isdeletedInfo = isdeletedInfo;
    }

    @Override
    public String toString()
    {
        return "OrderLinkDetailInfoBusiness [orderDetailInfoBusiness=" + this.orderDetailInfoBusiness + ", isdeletedInfo=" + this.isdeletedInfo + "]";
    }

}

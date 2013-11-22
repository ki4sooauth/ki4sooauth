package com.gooagoo.view.gms.apply;

import java.io.Serializable;
import java.util.Date;

/**
 * 开发票申请信息
 */

public class FBillInvoiceLog implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderId;//订单编号

    private String userId;//用户编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String invoicedType;//发票类型，0-个人，1-公司

    private String invoicedTile;//发票抬头，发票类型为公司时必填

    private Double invoicedPrice;//发票金额，为订单对应的实际支付金额

    private String invoicedItem;//开发票项目，如食品、礼品等，参考实体店的设定

    private Date invoicedTime;//开发票时间

    private Date invoicedRequestTime;//开发票申请时间

    private String needInvoicedDetail;//是否需要发票明细，Y-需要，N-不需要

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

    public String getInvoicedType()
    {
        return this.invoicedType;
    }

    public void setInvoicedType(String invoicedType)
    {
        this.invoicedType = invoicedType;
    }

    public String getInvoicedTile()
    {
        return this.invoicedTile;
    }

    public void setInvoicedTile(String invoicedTile)
    {
        this.invoicedTile = invoicedTile;
    }

    public Double getInvoicedPrice()
    {
        return this.invoicedPrice;
    }

    public void setInvoicedPrice(Double invoicedPrice)
    {
        this.invoicedPrice = invoicedPrice;
    }

    public String getInvoicedItem()
    {
        return this.invoicedItem;
    }

    public void setInvoicedItem(String invoicedItem)
    {
        this.invoicedItem = invoicedItem;
    }

    public Date getInvoicedTime()
    {
        return this.invoicedTime;
    }

    public void setInvoicedTime(Date invoicedTime)
    {
        this.invoicedTime = invoicedTime;
    }

    public Date getInvoicedRequestTime()
    {
        return this.invoicedRequestTime;
    }

    public void setInvoicedRequestTime(Date invoicedRequestTime)
    {
        this.invoicedRequestTime = invoicedRequestTime;
    }

    public String getNeedInvoicedDetail()
    {
        return this.needInvoicedDetail;
    }

    public void setNeedInvoicedDetail(String needInvoicedDetail)
    {
        this.needInvoicedDetail = needInvoicedDetail;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.orderId + "^" + this.userId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.invoicedType + "^" + this.invoicedTile + "^" + this.invoicedPrice + "^" + this.invoicedItem + "^" + this.invoicedTime + "^" + this.invoicedRequestTime + "^" + this.needInvoicedDetail + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}

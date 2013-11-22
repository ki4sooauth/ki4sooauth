package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FShopInvoiceInfo implements Serializable
{
    private String shopEntityId;//实体店id
    private String invoiceType; //发票类型
    private String invoiceName; //发票名称

    //    private String oldInvType; //旧的小票类型
    //    private String oldInvName; //旧小票名称

    //    public String getOldInvType()
    //    {
    //        return oldInvType;
    //    }
    //
    //    public void setOldInvType(String oldInvType)
    //    {
    //        this.oldInvType = oldInvType;
    //    }
    //
    //    public String getOldInvName()
    //    {
    //        return oldInvName;
    //    }
    //
    //    public void setOldInvName(String oldInvName)
    //    {
    //        this.oldInvName = oldInvName;
    //    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getInvoiceType()
    {
        return this.invoiceType;
    }

    public void setInvoiceType(String invoiceType)
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceName()
    {
        return this.invoiceName;
    }

    public void setInvoiceName(String invoiceName)
    {
        this.invoiceName = invoiceName;
    }
}

package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderPic;

/**
 * 商家订单原始信息
 */
public class OriginalShopOrderDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private ShopOrderInfo shopOrderInfo;//商家订单原始信息

    private List<ShopOrderDetail> shopOrderDetailList;//商家订单原始信息商品详情

    private ShopOrderPic shopOrderPicList;//商家订单原始信息图片详情

    public ShopOrderInfo getShopOrderInfo()
    {
        return this.shopOrderInfo;
    }

    public void setShopOrderInfo(ShopOrderInfo shopOrderInfo)
    {
        this.shopOrderInfo = shopOrderInfo;
    }

    public List<ShopOrderDetail> getShopOrderDetailList()
    {
        return this.shopOrderDetailList;
    }

    public void setShopOrderDetailList(List<ShopOrderDetail> shopOrderDetailList)
    {
        this.shopOrderDetailList = shopOrderDetailList;
    }

    public ShopOrderPic getShopOrderPicList()
    {
        return this.shopOrderPicList;
    }

    public void setShopOrderPicList(ShopOrderPic shopOrderPicList)
    {
        this.shopOrderPicList = shopOrderPicList;
    }

}

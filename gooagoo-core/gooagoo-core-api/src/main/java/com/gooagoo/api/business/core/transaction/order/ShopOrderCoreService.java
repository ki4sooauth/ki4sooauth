package com.gooagoo.api.business.core.transaction.order;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderPic;

/***
 * 商家订单管理
 * @author Administrator
 *
 */
public interface ShopOrderCoreService
{
    /**
     * 商家订单数据上传
     * @param shopOrderInfo
     * @param shopOrderDetailList
     * @param shopOrderPic
     * @return
     * @throws Exception
     */
    public boolean addShopOrder(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic) throws Exception;
}

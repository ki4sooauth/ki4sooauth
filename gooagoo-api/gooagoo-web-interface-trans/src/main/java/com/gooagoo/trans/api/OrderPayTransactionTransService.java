package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtse01.transform.OrderTransactionStatusRoot;

public interface OrderPayTransactionTransService
{
    /**
     * 接口 gtse01 : 订单支付交易状态信息查询
     * @param mac
     * @param billNo
     * @return
     * @throws Exception
     */
    OrderTransactionStatusRoot getOrderTransactionStatusRoot(String mac, String billNo) throws Exception;
}

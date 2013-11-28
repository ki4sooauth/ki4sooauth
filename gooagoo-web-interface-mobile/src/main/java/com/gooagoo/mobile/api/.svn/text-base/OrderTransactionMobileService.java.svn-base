package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobm01.transform.MobileOrderPayRoot;
import com.gooagoo.mobile.entity.mobm02.transform.TransactionStatusRoot;

/**
 * 手机交易支付接口
 */
public interface OrderTransactionMobileService
{
    /**
     * MOBM01:手机订单支付接口
     * 拍了付通過該接口請求支付，然後該調用該接口，
     * 通過訂單編號查詢訂單信息，並封裝調用拍了付的支付接口
     * @param orderId 訂單編號
     * @return
     */
    public MobileOrderPayRoot mobileOrderPay(String userId, String sessionId, String orderId) throws Exception;

    /**
     * 接口 MOBM02 :手机订单交易状态查询接口
     * 手機查詢訂單支付交易狀態，先查詢gooagoo服務器的訂單支付狀態信息，
     * 如果為查詢到信息或者查詢到信息支付狀態不成功，則需查詢拍了付的訂單狀態查詢接口
     * @param orderId 訂單編號
     * @return
     */
    public TransactionStatusRoot getTransactionStatus(String userId, String sessionId, String orderId) throws Exception;

}

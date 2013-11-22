package com.gooagoo.api.protecteds.query.transaction.order;

public interface OrderProtectedQueryService
{
    /**
     * 根据订单编号和订单状态获取订单图片地址
     * @param orderId
     * @param billType
     * @return billimg
     */
    public String getShopAuthorities(String orderId, String billType);
}

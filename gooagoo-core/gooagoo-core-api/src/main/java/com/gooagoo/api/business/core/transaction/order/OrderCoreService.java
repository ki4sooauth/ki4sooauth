package com.gooagoo.api.business.core.transaction.order;

public interface OrderCoreService
{

    /**
     * 批量删除账单
     * @param orderIds 多个订单编号逗号分隔
     * @return 
     * @throws Exception
     */
    public boolean deleteOrder(String orderIds) throws Exception;

    /**
     * 重量确认
     * @param orderId 订单编号
     * @param shopEntityId 实体店
     * @param tableName 桌号
     * @param itemSerial 自定义序列号
     * @param weightNum 重量
     * @return 
     * @throws Exception
     */
    public boolean confirmWeight(String orderId, String shopEntityId, String tableName, String itemSerial, String weightNum) throws Exception;

    /**
     * 接口gasl11:修改台头(用户就餐信息)
     * @param shopEntityId 实体店编号
     * @param tableName 餐桌号
     * @param peopleNums 就餐人数
     * @return
     * @throws Exception
     *         OperateFailException 修改台头信息失败异常
     */
    public boolean changeDiningNumbers(String shopEntityId, String tableName, String peopleNums) throws Exception;

    /**
     * 接口plf01：拍了付异步通知订单修改接口
     * @param orderId
     * @return
     * @throws Exception
     */
    public boolean PlfNsynOrderPay(String orderId) throws Exception;
}

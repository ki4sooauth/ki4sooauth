package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasm01.transform.GetInvoiceTitlesRoot;

public interface InvoiceLinkGasService
{
    /**
     * 接口gasm01:查询会员发票抬头信息
     * @param shopEntityId 实体店编号
     * @param userId 用户编号
     * @return
     * @throws Exception
     */
    public GetInvoiceTitlesRoot queryInvoiceTitles(String shopEntityId, String userId) throws Exception;

    /**
     * 接口gasm02:店员帮用户提交发票申请
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param userId 用户编号
     * @param title 发票抬头
     * @param invoicedType 发票类型，0-个人，1-公司
     * @return
     * @throws Exception
     */
    public boolean submitOpenInvoiceApply(String shopId, String shopEntityId, String userId, String title, String invoicedType, String orderid) throws Exception;

}

package com.gooagoo.api.business.core.transaction.invoice;

import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.exception.business.bill.InvoiceAlreadyExistsException;

/**
 * 发票管理
 *
 */
public interface InvoiceCoreService
{

    /**
     * 提交发票申请
     * gasm02,mobe02
     * @param billInvoiceLog
     * @return true/false
     * @throws InvoiceAlreadyExistsException 已开发票异常
     */
    public boolean AddInvoice(BillInvoiceLog billInvoiceLog) throws Exception;

    /**
     * 接口GTSC30:转发器上传打印发票确认
     * @param shopEntityId
     * @param orderId
     * @throws Exception
     *         OperateFailException 开发票确认失败异常
     */
    public boolean confirmOpenInvoice(String shopEntityId, String orderId) throws Exception;

}

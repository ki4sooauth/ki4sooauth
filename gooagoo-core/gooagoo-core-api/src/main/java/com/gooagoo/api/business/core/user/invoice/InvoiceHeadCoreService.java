package com.gooagoo.api.business.core.user.invoice;

import com.gooagoo.entity.generator.user.ReceiptInfo;

/**
 * 发票抬头管理
 */
public interface InvoiceHeadCoreService
{

    /**
     * 创建发票抬头
     * @param receiptInfo 
     * @return true/false
     */
    public boolean addInvoiceHead(ReceiptInfo receiptInfo) throws Exception;

    /**
     * 删除发票抬头
     * @param receiptId
     * @return true/false
     */
    public boolean deleteInvoiceHead(String receiptId) throws Exception;

    /**
     * 编辑发票抬头
     * @param receiptInfo
     * @return true/false
     */
    public boolean updateInvoiceHead(ReceiptInfo receiptInfo) throws Exception;

}

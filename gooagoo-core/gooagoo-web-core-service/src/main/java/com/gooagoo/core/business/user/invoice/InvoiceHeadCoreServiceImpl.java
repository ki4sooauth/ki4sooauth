package com.gooagoo.core.business.user.invoice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.invoice.InvoiceHeadCoreService;
import com.gooagoo.api.generator.core.user.ReceiptInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.ReceiptInfo;

@Service
public class InvoiceHeadCoreServiceImpl implements InvoiceHeadCoreService
{

    @Autowired
    ReceiptInfoGeneratorCoreService receiptInfoGeneratorCoreService;

    /* (non-Javadoc)
     * @see com.gooagoo.api.business.core.user.personal.invoice.ManageInvoiceHeadCoreService#addInvoiceHead(com.gooagoo.entity.generator.user.ReceiptInfo)
     */
    @Override
    public boolean addInvoiceHead(ReceiptInfo receiptInfo) throws Exception
    {
        receiptInfo.setCreateTime(new Date());
        receiptInfo.setIsDel("N");
        if (!this.receiptInfoGeneratorCoreService.insertSelective(receiptInfo))
        {
            GooagooLog.info("删除发票抬头：删除发票抬头（" + receiptInfo.toString() + "）失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteInvoiceHead(String receiptId) throws Exception
    {
        if (!this.receiptInfoGeneratorCoreService.deleteByPrimaryKey(receiptId))
        {
            GooagooLog.info("删除发票抬头：删除发票抬头（" + receiptId + "）失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInvoiceHead(ReceiptInfo receiptInfo) throws Exception
    {
        if (!this.receiptInfoGeneratorCoreService.updateByPrimaryKeySelective(receiptInfo))
        {
            GooagooLog.info("编辑发票抬头：编辑发票抬头（" + receiptInfo.toString() + "）失败");
            return false;
        }
        return true;
    }

}

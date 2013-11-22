package com.gooagoo.api.business.query.user.invoice;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.generator.user.ReceiptInfo;

public class TestInvoiceQueryService
{

    public InvoiceQueryService invoiceQueryService;

    @Before
    public void testBefore()
    {
        this.invoiceQueryService = ApplicationContextUtils.getBean(InvoiceQueryService.class);
    }

    /**
     * gasm01
     * @throws Exception
     */
    @Test
    public void testFindInvoice() throws Exception
    {
        String scardno = "1000080000013000";
        String userId = "00017R6DOQJO43O6P0007VEIISX8Q016";
        List<ReceiptInfo> receiptInfos = this.invoiceQueryService.findInvoice(scardno, userId);
        Assert.assertNotNull("查询会员发票抬头常用信息失败", receiptInfos); //目前发票抬头的表数据是空的
    }

}

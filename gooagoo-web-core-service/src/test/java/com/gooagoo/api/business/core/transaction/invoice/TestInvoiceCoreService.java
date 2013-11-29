package com.gooagoo.api.business.core.transaction.invoice;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.entity.generator.bill.BillInvoiceLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestInvoiceCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public InvoiceCoreService invoiceCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * gasm02,mobe02
     * @throws Exception
     */
    @Test
    public void testAddInvoice() throws Exception
    {
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setOrderId("2013100000003303");
        billInvoiceLog.setUserId("01822RBQ22JSDMA085QBV8EIISWR0JGT");
        billInvoiceLog.setInvoicedType("0");
        billInvoiceLog.setInvoicedTile("add");
        billInvoiceLog.setInvoicedItem("明细");
        Assert.isTrue(this.invoiceCoreService.AddInvoice(billInvoiceLog), "用户根据账单信息申请开发票失败");
    }

    /**
     * GTSC30:转发器上传打印发票确认
     */
    @Test
    public void testConfirmOpenInvoice() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String orderId = "2013100000002003";
        Assert.isTrue(this.invoiceCoreService.confirmOpenInvoice(shopEntityId, orderId), "转发器上传打印发票确认失败");
    }

}

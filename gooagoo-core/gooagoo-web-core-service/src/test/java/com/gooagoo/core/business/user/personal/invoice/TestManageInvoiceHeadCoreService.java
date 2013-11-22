package com.gooagoo.core.business.user.personal.invoice;

import java.util.Date;

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

import com.gooagoo.api.business.core.user.invoice.InvoiceHeadCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.user.ReceiptInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestManageInvoiceHeadCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    InvoiceHeadCoreService invoiceHeadCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testAddInvoiceHead() throws Exception
    {
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setReceiptId("00017VGIRAKG8MRJC6GDR8Z5O9YBD78C");
        receiptInfo.setUserId(UUID.getUUID());
        receiptInfo.setCompanyName("北京购阿购技术服务有限公司");
        receiptInfo.setIsDefault("Y");
        receiptInfo.setIsDel("N");
        receiptInfo.setCreateTime(new Date());
        boolean isSucceed = this.invoiceHeadCoreService.addInvoiceHead(receiptInfo);
        Assert.isTrue(isSucceed, "添加发票抬头失败");
    }

    @Test
    public void testDeleteInvoiceHead() throws Exception
    {
        boolean isSucceed = this.invoiceHeadCoreService.deleteInvoiceHead("00017VGIRAKG8MRJC6GDR8Z5O9YBD78C");
        Assert.isTrue(isSucceed, "删除发票抬头失败");
    }

    @Test
    public void testUpdateInvoiceHead() throws Exception
    {
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setReceiptId("00017VGIRAKG8MRJC6GDR8Z5O9YBD78C");
        receiptInfo.setIsDefault("N");
        boolean isSucceed = this.invoiceHeadCoreService.updateInvoiceHead(receiptInfo);
        Assert.isTrue(isSucceed, "编辑发票抬头失败");
    }
}

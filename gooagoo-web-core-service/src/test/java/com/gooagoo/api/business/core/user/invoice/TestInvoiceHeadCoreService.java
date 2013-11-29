package com.gooagoo.api.business.core.user.invoice;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestInvoiceHeadCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public InvoiceHeadCoreService invoiceHeadCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 创建发票抬头
     * @throws Exception
     */
    @Test
    public void testAddInvoiceHead() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除发票抬头
     * @throws Exception
     */
    @Test
    public void testDeleteInvoiceHead() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑发票抬头
     * @throws Exception
     */
    @Test
    public void testUpdateInvoiceHead() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

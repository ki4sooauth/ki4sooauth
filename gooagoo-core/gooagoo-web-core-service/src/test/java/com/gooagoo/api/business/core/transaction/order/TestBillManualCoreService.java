package com.gooagoo.api.business.core.transaction.order;

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
public class TestBillManualCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public BillManualCoreService billManualCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增手工账单
     * @throws Exception
     */
    @Test
    public void testAddBillManual() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑手工账单
     * @throws Exception
     */
    @Test
    public void testUpdateBillManual() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除手工账单
     * @throws Exception
     */
    @Test
    public void testDeleteBillManual() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

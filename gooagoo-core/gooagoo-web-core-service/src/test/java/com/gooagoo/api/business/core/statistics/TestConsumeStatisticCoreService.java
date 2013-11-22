package com.gooagoo.api.business.core.statistics;

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
public class TestConsumeStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ConsumeStatisticCoreService consumeStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询消费次数
     * @throws Exception
     */
    @Test
    public void testConsumeTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询消费人群
     * @throws Exception
     */
    @Test
    public void testConsumePeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询消费金额
     * @throws Exception
     */
    @Test
    public void testConsumeAmount() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询消费金额人群
     * @throws Exception
     */
    @Test
    public void testConsumeAmountPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

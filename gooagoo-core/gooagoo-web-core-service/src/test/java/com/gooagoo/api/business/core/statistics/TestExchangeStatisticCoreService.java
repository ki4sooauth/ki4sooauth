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
public class TestExchangeStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ExchangeStatisticCoreService exchangeStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询优惠凭证兑换次数
     * @throws Exception
     */
    @Test
    public void testCouponExchangeTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证兑换人群
     * @throws Exception
     */
    @Test
    public void testCouponExchangePeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

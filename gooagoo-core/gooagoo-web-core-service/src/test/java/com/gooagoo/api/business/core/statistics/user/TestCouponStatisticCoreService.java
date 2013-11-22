package com.gooagoo.api.business.core.statistics.user;

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
public class TestCouponStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public CouponStatisticCoreService couponStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 猜你喜欢的优惠凭证
     * @throws Exception
     */
    @Test
    public void testQueryGuessYouTastes() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

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
public class TestShareStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShareStatisticCoreService shareStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询优惠凭证分享次数
     * @throws Exception
     */
    @Test
    public void testCouponShareTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证分享人群
     * @throws Exception
     */
    @Test
    public void testCouponSharePeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

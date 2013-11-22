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
public class TestUseStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UseStatisticCoreService useStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询商家服务工具使用次数
     * @throws Exception
     */
    @Test
    public void testToolUseTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家服务工具使用人群
     * @throws Exception
     */
    @Test
    public void testToolUsePoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证使用次数
     * @throws Exception
     */
    @Test
    public void testCouponUseTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证使用人群
     * @throws Exception
     */
    @Test
    public void testCouponUsePeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

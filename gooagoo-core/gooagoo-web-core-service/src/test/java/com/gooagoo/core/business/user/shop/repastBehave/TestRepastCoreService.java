package com.gooagoo.core.business.user.shop.repastBehave;

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

import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestRepastCoreService extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    UserOrderCoreService userOrderCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testBandDeskAndOrder() throws Exception
    {
        boolean isSucceed = this.userOrderCoreService.bindTable("00017TBK0U74GO2T600064EIISQNK01G", "999", "111台");
        Assert.isTrue(isSucceed, "绑定桌号、订单号、用户id失败");
    }
}

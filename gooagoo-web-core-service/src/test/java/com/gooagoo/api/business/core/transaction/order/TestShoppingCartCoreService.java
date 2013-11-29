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
public class TestShoppingCartCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShoppingCartCoreService shoppingCartCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 将指定账单中的商品重新加入购物车
     * @throws Exception
     */
    @Test
    public void testAnewAddShoppingCart() throws Exception
    {
        String userId = "188OI85MQMRUV300A1BAQJMC178G37AM";
        String orderId = "2000000000000001";
        Assert.isTrue(this.shoppingCartCoreService.anewAddShoppingCart(userId, orderId), "将指定账单中的商品重新加入购物车失败");
    }

}

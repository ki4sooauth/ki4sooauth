package com.gooagoo.api.business.core.user.shoppingplan;

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
public class TestShoppingPlanCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShoppingPlanCoreService shoppingPlanCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增购物清单
     * @throws Exception
     */
    @Test
    public void testAddShoppingPlan() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑购物清单
     * @throws Exception
     */
    @Test
    public void testUpdateShoppingPlan() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除购物清单
     * @throws Exception
     */
    @Test
    public void testDeleteShoppingPlan() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除购物清单商品
     * @throws Exception
     */
    @Test
    public void testDeleteShoppingPlanGoods() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 加入购物清单
     * @throws Exception
     */
    @Test
    public void testAddShoppingPlanGoods() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

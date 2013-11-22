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

import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanBusiness;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShoppingPlanSynCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShoppingPlanSynCoreService shoppingPlanSynCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 计划列表与服务器同步（单条）
     * @throws Exception
     */
    @Test
    public void testGetSingleUserShoppingplan() throws Exception
    {
        String userId = "";
        ShoppingplanBusiness shoppingplanBusiness4Json = new ShoppingplanBusiness();
        shoppingplanBusiness4Json.setShoppinglistid("1111111111");
        shoppingplanBusiness4Json.setCtimestamp("2013-01-01 12:00:00");
        shoppingplanBusiness4Json.setPreshoppingtime("2013-08-08 12:00:00");
        String userShoppingplanGoods = JsonUtils.toJson(shoppingplanBusiness4Json);
        //        ShoppingplanBusiness shoppingplanBusiness = this.shoppingPlanSynCoreService.getSingleUserShoppingplan(userId, userShoppingplanGoods);
        //        Assert.notNull(shoppingplanBusiness, "计划列表与服务器同步（单条）失败");
    }

    /**
     * 购物清单批量同步第二步
     * @throws Exception
     */
    @Test
    public void testShoppingPlanSynStepB() throws Exception
    {

        Assert.isTrue(true, "");
    }

}

package com.gooagoo.core.business.user.personal.shoppingPlan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanSynCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepB;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShoppingPlanSynCoreService extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    ShoppingPlanSynCoreService shoppingPlanSynCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testAppFeedback()
    {
        try
        {
            List<ShoppingPlanDetailStepB> shoppingPlanDetailList = new ArrayList<ShoppingPlanDetailStepB>();
            ShoppingPlanDetailStepB ShoppingPlanDetail = new ShoppingPlanDetailStepB();
            UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
            String uuid = UUID.getUUID();
            userShoppingPlan.setShoppingListId(uuid.substring(0, 30));
            userShoppingPlan.setUserId(uuid);
            userShoppingPlan.setInfoSource("m");
            userShoppingPlan.setPreShoppingTime(new Date());
            userShoppingPlan.setTitle("titile");
            ShoppingPlanDetail.setUserShoppingPlan(userShoppingPlan);
            shoppingPlanDetailList.add(ShoppingPlanDetail);
            List<Map<String, String>> list = this.shoppingPlanSynCoreService.shoppingPlanSynStepB(shoppingPlanDetailList);
            System.out.println(list.toString());
        }
        catch (Exception e)
        {
            Assert.isTrue(false, "同步购物清单失败:" + e);
        }
    }
}

package com.gooagoo.api.business.query.user.shoppingPlan;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.user.shoppingplan.ShoppingPlanQueryService;
import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestShoppingPlanQueryService
{

    public ShoppingPlanQueryService shoppingPlanQueryService;

    @Before
    public void testBefore()
    {
        this.shoppingPlanQueryService = ApplicationContextUtils.getBean(ShoppingPlanQueryService.class);
    }

    /**
     * 购物清单批量同步第一步
     * @throws Exception
     */
    @Test
    public void testShoppingPlanSynStepA() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 购物清单列表（分页）
     * @throws Exception
     */
    @Test
    public void testFindShoppingPlanList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 购物清单商品列表
     * @throws Exception
     */
    @Test
    public void testFindShoppingPlanGoodsList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 购物清单商品类型列表
     * @throws Exception
     */
    @Test
    public void testFindShoppingPlanGoodsTypeList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

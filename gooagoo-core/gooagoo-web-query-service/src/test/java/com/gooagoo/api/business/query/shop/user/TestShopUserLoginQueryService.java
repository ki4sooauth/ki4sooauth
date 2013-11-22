package com.gooagoo.api.business.query.shop.user;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopUserLoginQueryService
{

    public ShopUserLoginQueryService shopUserLoginQueryService;

    @Before
    public void testBefore()
    {
        this.shopUserLoginQueryService = ApplicationContextUtils.getBean(ShopUserLoginQueryService.class);
    }

    /**
     * 商家用户登录
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 获取用户登录信息
     * @throws Exception
     */
    @Test
    public void testQueryShopDetailInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 获取店员助理对讲机用户列表
     * @throws Exception
     */
    @Test
    public void testQueryShopUserInfos() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

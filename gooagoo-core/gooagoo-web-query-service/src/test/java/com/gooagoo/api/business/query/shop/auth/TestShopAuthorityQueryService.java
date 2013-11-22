package com.gooagoo.api.business.query.shop.auth;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.google.gson.Gson;

public class TestShopAuthorityQueryService
{

    public ShopAuthorityQueryService shopAuthorityQueryService;

    @Before
    public void testBefore()
    {
        this.shopAuthorityQueryService = ApplicationContextUtils.getBean(ShopAuthorityQueryService.class);
    }

    /**
     * 获取商家权限
     * @throws Exception
     */
    @Test
    public void testGetShopAuthorities() throws Exception
    {
        List<ShopAuthority> list = this.shopAuthorityQueryService.getShopAuthorities("00017Q3EG198TUUV50000HFYOBYEH00F");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("获取商家权限", list);
    }

    /**
     * 获取商家用户（店员）权限
     * @throws Exception
     */
    @Test
    public void testGetShopUserAuthorities() throws Exception
    {
        List<ShopAuth> list = this.shopAuthorityQueryService.getShopUserAuthorities("00017Q3EG198TUUV50000HFYOBYEH00F", "3@3.com", "N");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("获取商家用户（店员）权限", list);
    }

    /**
     * 获取商家用户（店员）权限
     * @throws Exception
     */
    @Test
    public void testGetShopUserLoginAuthorities() throws Exception
    {
        List<ShopAuth> list = this.shopAuthorityQueryService.getShopUserLoginAuthorities("00017Q3EG198TUUV50000HFYOBYEH00F", "3@3.com", "Y");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("获取商家用户（店员）权限", list);
    }
}

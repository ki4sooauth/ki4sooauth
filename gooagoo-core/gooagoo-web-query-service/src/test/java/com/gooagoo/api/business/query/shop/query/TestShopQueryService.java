package com.gooagoo.api.business.query.shop.query;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.google.gson.Gson;

public class TestShopQueryService
{

    public ShopQueryService shopQueryService;
    public ShopUserInfoGeneratorQueryService shopUserInfoGeneratorQueryService;
    public ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Before
    public void testBefore()
    {
        this.shopQueryService = ApplicationContextUtils.getBean(ShopQueryService.class);
        this.shopUserInfoGeneratorQueryService = ApplicationContextUtils.getBean(ShopUserInfoGeneratorQueryService.class);
        this.shopInfoGeneratorQueryService = ApplicationContextUtils.getBean(ShopInfoGeneratorQueryService.class);
    }

    /**
     * 查询商家信息
     * @throws Exception
     */
    @Test
    public void testFindShopInfo() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 获取商家的详细信息（登录）
     * @throws Exception
     */
    @Test
    public void testGetShopLoginInfo() throws Exception
    {
        ShopUserInfo shopUserInfo = this.shopUserInfoGeneratorQueryService.selectByPrimaryKey("1@s.com");
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopUserInfo.getShopId());
        ShopLoginInfo obj = this.shopQueryService.getShopLoginInfo(shopInfo, shopUserInfo);
        if (obj != null)
        {
            System.out.println(new Gson().toJson(obj));
        }
        Assert.assertNotNull("获取商家的详细信息（登录）", obj);
    }

    /**
     * 获取商家页面文字字典表
     * @throws Exception
     */
    @Test
    public void testGetShopInterfaceNamesByShopType() throws Exception
    {
        Map<String, String> list = this.shopQueryService.getShopInterfaceNamesByShopType("1");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("获取商家页面文字字典表", list);
    }

}

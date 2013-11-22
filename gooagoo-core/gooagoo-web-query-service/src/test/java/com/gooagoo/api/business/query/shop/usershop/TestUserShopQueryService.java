package com.gooagoo.api.business.query.shop.usershop;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.api.business.query.shop.query.UserShopQueryService;
import com.gooagoo.entity.business.shop.ShopInfoBusiness;

public class TestUserShopQueryService
{

    public UserShopQueryService userShopQueryService;

    @Before
    public void testBefore()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userShopQueryService = applicationContext.getBean(UserShopQueryService.class);
    }

    @Test
    public void testFindUserShopList() throws Exception
    {
        String keyword = null;
        String shoptypeId = null;
        String pageId = null;
        String pageType = null;
        Integer pageSize = null;
        List<ShopInfoBusiness> shopInfoBusinessList = this.userShopQueryService.findUserShopList(keyword, shoptypeId, pageId, pageType, pageSize);
        Assert.assertNotNull("查询商家列表失败", shopInfoBusinessList);
    }
}

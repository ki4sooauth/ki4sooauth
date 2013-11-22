package com.gooagoo.api.business.query.shop.query;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.shop.ShopInfoBusiness;

public class TestUserShopQueryService
{

    public UserShopQueryService userShopQueryService;

    @Before
    public void testBefore()
    {
        this.userShopQueryService = ApplicationContextUtils.getBean(UserShopQueryService.class);
    }

    /**
     * 查询我的商家列表（分页、排序）
     * @throws Exception
     */
    @Test
    public void testFindUserShopList() throws Exception
    {
        String keyword = null;
        String shoptypeId = null;
        String pageId = null;
        String pageType = null;
        Integer pageSize = null;
        List<ShopInfoBusiness> shopInfoBusinessList = this.userShopQueryService.findUserShopList(keyword, shoptypeId, pageId, pageType, pageSize);
        Assert.assertTrue("查询我的商家列表失败", CollectionUtils.isNotEmpty(shopInfoBusinessList));
    }

    /**
     * 查询我的商家列表（个人中心）
     * @throws Exception
     */
    @Test
    public void testFindMyShopList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

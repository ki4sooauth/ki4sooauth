package com.gooagoo.api.business.query.marketing.cryout;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.ShopDetailForPlace;

public class TestCryoutPlaceQueryService
{

    public CryoutPlaceQueryService cryoutPlaceQueryService;

    @Before
    public void testBefore()
    {
        this.cryoutPlaceQueryService = ApplicationContextUtils.getBean(CryoutPlaceQueryService.class);
    }

    /**
     * 吆喝广场侧边栏分类
     * @throws Exception
     */
    @Test
    public void testFindCryoutPlaceMenu() throws Exception
    {
        List<FirstMenu> cryoutPlaceMenu = this.cryoutPlaceQueryService.findCryoutPlaceMenu();
        Assert.assertTrue("查询吆喝广场侧边栏分类失败", CollectionUtils.isNotEmpty(cryoutPlaceMenu));
    }

    /**
     * mobc03
     * @throws Exception
     */
    @Test
    public void testFindCryoutPlaceList() throws Exception
    {
        String keyword = null;
        String typeCode = "C4";
        Integer pageIndex = null;
        Integer pageSize = null;
        List<ShopDetailForPlace> shopDetailForPlaceList = this.cryoutPlaceQueryService.findCryoutPlaceList(keyword, typeCode, pageIndex, pageSize);
        Assert.assertTrue("查询吆喝广场商家列表失败", CollectionUtils.isNotEmpty(shopDetailForPlaceList));
    }

    /**
     * 吆喝广场商家详情查询
     * @throws Exception
     */
    @Test
    public void testFindCryoutPlaceDetail() throws Exception
    {
        String shopId = "00017P275QB2GE0B900057bj43j9p012";
        ShopDetailForPlace shopDetailForPlace = this.cryoutPlaceQueryService.findCryoutPlaceDetail(shopId);
        Assert.assertNotNull("查询吆喝广场商家详情失败", shopDetailForPlace);
    }

}

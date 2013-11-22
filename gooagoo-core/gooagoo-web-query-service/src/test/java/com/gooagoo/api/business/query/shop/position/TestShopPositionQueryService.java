package com.gooagoo.api.business.query.shop.position;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.shop.MainAreaBusiness;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.google.gson.Gson;

public class TestShopPositionQueryService
{

    public ShopPositionQueryService shopPositionQueryService;

    @Before
    public void testBefore()
    {
        this.shopPositionQueryService = ApplicationContextUtils.getBean(ShopPositionQueryService.class);
    }

    /**
     * 根据父类查询所有子类位置列表
     * @throws Exception
     */
    @Test
    public void testFindShopPositionListByParent() throws Exception
    {
        List<ShopPosition> list = this.shopPositionQueryService.findShopPositionListByParent("00017Q3EG198TUUV50000HFYOBYEH00F", "0001818MUQ53IV7MN0ORE6BJ444KG7NS", "-1");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("根据父类查询所有子类位置列表", list);
    }

    /**
     * 查询商家区域人数
     * @throws Exception
     */
    @Test
    public void testFindShopPositionNumberOfPeople() throws Exception
    {
        String shopEntityId = "01822UK2PV0226F07GRNHMEIISWR2K8D";
        String positionId = null;//"018231OPL6IJARO02VLL2BEIISWR2TKG"
        List<MainAreaBusiness> mainAreaBusinessList = this.shopPositionQueryService.findShopPositionNumberOfPeople(shopEntityId, positionId);
        Assert.assertTrue("查询商家区域人数失败", CollectionUtils.isNotEmpty(mainAreaBusinessList));
    }
}

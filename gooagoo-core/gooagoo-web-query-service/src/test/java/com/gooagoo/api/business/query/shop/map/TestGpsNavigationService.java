package com.gooagoo.api.business.query.shop.map;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.shop.map.MappositionlistBusiness;

public class TestGpsNavigationService
{

    public GpsNavigationService gpsNavigationService;

    @Before
    public void testBefore()
    {
        this.gpsNavigationService = ApplicationContextUtils.getBean(GpsNavigationService.class);
    }

    /**
     * 接口MOBI02:位置查询（根据“关键字”查询当前商场内商家或商品位置）
     * @throws Exception
     */
    @Test
    public void testGetShopOrGoodsPositionOfMap() throws Exception
    {
        String shopEntityId = "01822UK2PV0226F07GRNHMEIISWR2K8D";
        String keyWord = null;
        List<MappositionlistBusiness> list = this.gpsNavigationService.getShopOrGoodsPositionOfMap(shopEntityId, keyWord);
        Assert.assertTrue("根据“关键字”查询当前商场内商家或商品位置失败", CollectionUtils.isNotEmpty(list));
    }

}

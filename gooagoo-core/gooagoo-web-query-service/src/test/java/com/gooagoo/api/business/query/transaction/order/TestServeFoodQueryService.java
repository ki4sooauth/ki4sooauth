package com.gooagoo.api.business.query.transaction.order;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestServeFoodQueryService
{

    public ServeFoodQueryService serveFoodQueryService;

    @Before
    public void testBefore()
    {
        this.serveFoodQueryService = ApplicationContextUtils.getBean(ServeFoodQueryService.class);
    }

    /**
     * gtsc15:商家查询用户起菜请求
     */
    @Test
    public void testFindOrderDish() throws Exception
    {
        String mac = "00:00:00:00:00:fe";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String ctimestamp = null;
        List<Map<String, String>> list = this.serveFoodQueryService.findOrderDish(mac, shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询用户起菜请求失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gtsc16:商家查询用户催菜请求
     */
    @Test
    public void testFindHurryDish() throws Exception
    {
        String mac = "00:00:00:00:00:fe";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String ctimestamp = null;
        List<Map<String, String>> list = this.serveFoodQueryService.findHurryDish(mac, shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询用户起菜请求失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gtsc17:商家查询用户缓菜请求
     */
    @Test
    public void testFindSlowDish() throws Exception
    {
        String mac = "00:00:00:00:00:fe";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String ctimestamp = null;
        List<Map<String, String>> list = this.serveFoodQueryService.findSlowDish(mac, shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询用户起菜请求失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gtsc27:商家查询勾挑请求
     */
    @Test
    public void testFindServe() throws Exception
    {
        String mac = "";
        String shopEntityId = "";
        String ctimestamp = null;
        List<Map<String, String>> list = this.serveFoodQueryService.findServe(mac, shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询用户起菜请求失败", CollectionUtils.isNotEmpty(list));
    }
}

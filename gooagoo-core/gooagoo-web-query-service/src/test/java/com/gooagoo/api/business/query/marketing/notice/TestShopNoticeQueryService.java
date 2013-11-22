package com.gooagoo.api.business.query.marketing.notice;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopNoticeQueryService
{

    public ShopNoticeQueryService shopNoticeQueryService;

    @Before
    public void testBefore()
    {
        this.shopNoticeQueryService = ApplicationContextUtils.getBean(ShopNoticeQueryService.class);
    }

    /**
     * 6.7.6. 查询通知列表（分页）
     * @throws Exception
     */
    @Test
    public void testFindShopNoticeList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

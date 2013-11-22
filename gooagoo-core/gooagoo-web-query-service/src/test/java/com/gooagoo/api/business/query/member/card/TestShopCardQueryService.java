package com.gooagoo.api.business.query.member.card;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopCardQueryService
{

    public ShopCardQueryService shopCardQueryService;

    @Before
    public void testBefore()
    {
        this.shopCardQueryService = ApplicationContextUtils.getBean(ShopCardQueryService.class);
    }

    /**
     * 5.3.1. 会员卡列表查询
     * @throws Exception
     */
    @Test
    public void testFindMemberCardList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 5.3.5. 查看会员卡详细信息
     * @throws Exception
     */
    @Test
    public void testFindMemberCardDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

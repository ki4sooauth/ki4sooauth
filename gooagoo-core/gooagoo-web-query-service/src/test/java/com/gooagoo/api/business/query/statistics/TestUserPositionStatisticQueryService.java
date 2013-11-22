package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestUserPositionStatisticQueryService
{

    public UserPositionStatisticQueryService userPositionStatisticQueryService;

    @Before
    public void testBefore()
    {
        this.userPositionStatisticQueryService = ApplicationContextUtils.getBean(UserPositionStatisticQueryService.class);
    }

    /**
     * 商家关注用户
     * @throws Exception
     */
    @Test
    public void testFindUserPositionInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

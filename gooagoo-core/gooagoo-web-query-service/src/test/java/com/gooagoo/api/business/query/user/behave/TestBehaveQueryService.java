package com.gooagoo.api.business.query.user.behave;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestBehaveQueryService
{

    public BehaveQueryService behaveQueryService;

    @Before
    public void testBefore()
    {
        this.behaveQueryService = ApplicationContextUtils.getBean(BehaveQueryService.class);
    }

    /**
     * 用户行为列表查询
     * @throws Exception
     */
    @Test
    public void testFindUserBehaveList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

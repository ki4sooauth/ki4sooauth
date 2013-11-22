package com.gooagoo.api.business.query.user.query;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestUserQueryService
{

    public UserQueryService userQueryService;

    @Before
    public void testBefore()
    {
        this.userQueryService = ApplicationContextUtils.getBean(UserQueryService.class);
    }

    /**
     * 查询个人信息
     * @throws Exception
     */
    @Test
    public void testFindUserInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

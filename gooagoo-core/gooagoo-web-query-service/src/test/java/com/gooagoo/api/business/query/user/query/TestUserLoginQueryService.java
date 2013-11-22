package com.gooagoo.api.business.query.user.query;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestUserLoginQueryService
{

    public UserLoginQueryService userLoginQueryService;

    @Before
    public void testBefore()
    {
        this.userLoginQueryService = ApplicationContextUtils.getBean(UserLoginQueryService.class);
    }

    /**
     * 校验手机用户是否登录
     * @throws Exception
     */
    @Test
    public void testCheckLoginStatus() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

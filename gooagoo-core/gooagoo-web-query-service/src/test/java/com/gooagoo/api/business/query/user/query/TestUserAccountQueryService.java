package com.gooagoo.api.business.query.user.query;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestUserAccountQueryService
{

    public UserAccountQueryService userAccountQueryService;

    @Before
    public void testBefore()
    {
        this.userAccountQueryService = ApplicationContextUtils.getBean(UserAccountQueryService.class);
    }

    /**
     * 根据用户帐号类型和用户帐号获取用户userid
     * @throws Exception
     */
    @Test
    public void testQueryUserIdFromUserAccount() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 根据用户userid获取用户电子邮箱
     * @throws Exception
     */
    @Test
    public void testQueryEmailFromUserId() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 根据用户userid获取用户手机号码
     * @throws Exception
     */
    @Test
    public void testQueryMobileFromUserId() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 根据用户userid获取用户手机mac地址
     * @throws Exception
     */
    @Test
    public void testQueryMacFromUserId() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 获取用户登录信息
     * @throws Exception
     */
    @Test
    public void testQueryUserDetailInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

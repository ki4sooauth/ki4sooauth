package com.gooagoo.api.business.query.user.query;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestUserActiveCodeQueryService
{

    public UserActiveCodeQueryService userActiveCodeQueryService;

    @Before
    public void testBefore()
    {
        this.userActiveCodeQueryService = ApplicationContextUtils.getBean(UserActiveCodeQueryService.class);
    }

    /**
     * 适用于个人用户找回密码
     * @throws Exception
     */
    @Test
    public void testCheckEmailActiveCode() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 适用于个人用户绑定手机时的身份验证
     * @throws Exception
     */
    @Test
    public void testCheckActiveCodeForBindMobile() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 校验手机验证码
     * @throws Exception
     */
    @Test
    public void testCheckMobileActiveCode() throws Exception
    {
        String mobile = "15711367072";
        String activeCode = "009139";
        Assert.assertTrue("校验手机验证码失败", this.userActiveCodeQueryService.checkMobileActiveCode(activeCode, mobile));
    }

    /**
     * 校验验证码
     * @throws Exception
     */
    @Test
    public void testCheckActiveCode() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

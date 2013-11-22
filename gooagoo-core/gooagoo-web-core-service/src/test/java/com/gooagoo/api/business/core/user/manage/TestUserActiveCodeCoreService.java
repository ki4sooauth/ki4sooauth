package com.gooagoo.api.business.core.user.manage;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestUserActiveCodeCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserActiveCodeCoreService userActiveCodeCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 适用于个人用户找回密码
     * @throws Exception
     */
    @Test
    public void testGetEmailActiveCode() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 适用于个人用户绑定手机时的身份验证
     * @throws Exception
     */
    @Test
    public void testGetEmailActiveCodeForBindMobile() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 适用于个人用户绑定邮箱时的绑定确认
     * @throws Exception
     */
    @Test
    public void testGetEmailActiveCodeForBindEmail() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 获取手机验证码
     * @throws Exception
     */
    @Test
    public void testGetMobileActiveCode() throws Exception
    {
        String mobile = "15711367072";
        String activeCode = this.userActiveCodeCoreService.getMobileActiveCode(mobile);
        Assert.isTrue(StringUtils.hasText(activeCode), "获取手机验证码失败");
    }

    /**
     * 适用于个人用户找回密码
     * @throws Exception
     */
    @Test
    public void testUpdateMobileActiveCode() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 获取验证码
     * @throws Exception
     */
    @Test
    public void testGetActiveCode() throws Exception
    {

        Assert.isTrue(true, "");
    }

}

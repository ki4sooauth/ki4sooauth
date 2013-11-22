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

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestUserRegisterCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserRegisterCoreService userRegisterCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 个人用户注册
     * @throws Exception
     */
    @Test
    public void testRegister() throws Exception
    {
        String activeCode = "18727556NAVJH70GNT4BI4FP2E4F00F9";
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("809317419@qq.com");
        userInfo.setPassword("123456");
        userInfo.setUserType("M");
        UserProfile userProfile = null;
        UserMobileInfo userMobileInfo = null;
        Assert.isTrue(this.userRegisterCoreService.register(activeCode, userInfo, userProfile, userMobileInfo), "用户注册失败");
    }

    /**
     * 个人用户账户激活
     * @throws Exception
     */
    @Test
    public void testActive() throws Exception
    {

        Assert.isTrue(true, "");
    }

}

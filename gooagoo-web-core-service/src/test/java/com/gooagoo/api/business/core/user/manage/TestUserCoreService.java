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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestUserCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserCoreService userCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 修改个人信息
     * @throws Exception
     */
    @Test
    public void testUpdateUserInfo() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * * 修改头像
     * @throws Exception
     */
    @Test
    public void testUpdateUserHead() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * * 修改用户辅助信息
     * @throws Exception
     */
    @Test
    public void testUpdateUserProfile() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 修改用户名
     * @throws Exception
     */
    @Test
    public void testUpdateUserAccount() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 适用于用户绑定邮箱地址
     * @throws Exception
     */
    @Test
    public void testUpdateEmail() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 适用于用户绑定手机号码
     * @throws Exception
     */
    @Test
    public void testUpdateMobile() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

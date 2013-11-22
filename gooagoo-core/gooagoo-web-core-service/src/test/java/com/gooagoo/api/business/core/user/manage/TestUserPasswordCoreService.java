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
public class TestUserPasswordCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserPasswordCoreService userPasswordCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 重置密码
     * @throws Exception
     */
    @Test
    public void testResetPassword() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 修改密码
     * @throws Exception
     */
    @Test
    public void testUpdatePassword() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

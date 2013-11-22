package com.gooagoo.api.business.core.user.cache;

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
public class TestUserCacheCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserCacheCoreService userCacheCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 根据mac查UserId
     * @throws Exception
     */
    @Test
    public void testFindUserIdByMac() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询用户信息
     * @throws Exception
     */
    @Test
    public void testFindUserInfo() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

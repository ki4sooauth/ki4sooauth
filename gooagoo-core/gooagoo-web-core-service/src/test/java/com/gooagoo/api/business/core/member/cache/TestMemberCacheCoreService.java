package com.gooagoo.api.business.core.member.cache;

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
public class TestMemberCacheCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MemberCacheCoreService memberCacheCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @throws Exception
     */
    @Test
    public void testFindMembeInfo() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @throws Exception
     */
    @Test
    public void testFindMembeInfoByScardno() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

package com.gooagoo.api.business.core.statistics;

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
public class TestMemberStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MemberStatisticCoreService memberStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 商家关注用户
     * @throws Exception
     */
    @Test
    public void testFindAttention() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 商家会员用户
     * @throws Exception
     */
    @Test
    public void testFindMember() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

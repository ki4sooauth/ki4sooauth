package com.gooagoo.api.business.core.system.user.enterprise;

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
public class TestMerchantStatusCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MerchantStatusCoreService merchantStatusCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 编辑商家状态和审核备注
     * @throws Exception
     */
    @Test
    public void testUpdateMerchantStatus() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

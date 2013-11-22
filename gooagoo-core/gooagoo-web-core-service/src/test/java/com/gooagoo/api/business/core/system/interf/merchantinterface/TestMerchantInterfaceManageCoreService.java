package com.gooagoo.api.business.core.system.interf.merchantinterface;

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
public class TestMerchantInterfaceManageCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MerchantInterfaceManageCoreService merchantInterfaceManageCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 分配商家接口地址（输入域名）
     * @throws Exception
     */
    @Test
    public void testAllotInterface() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑商家接口地址信息
     * @throws Exception
     */
    @Test
    public void testUpdateInterface() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

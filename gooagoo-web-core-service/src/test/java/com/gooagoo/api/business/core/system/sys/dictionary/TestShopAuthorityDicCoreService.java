package com.gooagoo.api.business.core.system.sys.dictionary;

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
public class TestShopAuthorityDicCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopAuthorityDicCoreService shopAuthorityDicCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增商家管理权限
     * @throws Exception
     */
    @Test
    public void testAddShopAuthorityDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑商家管理权限
     * @throws Exception
     */
    @Test
    public void testUpdateShopAuthorityDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除商家管理权限
     * @throws Exception
     */
    @Test
    public void testDelShopAuthorityDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

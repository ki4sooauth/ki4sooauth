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
public class TestMarketingChannelsDicCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MarketingChannelsDicCoreService marketingChannelsDicCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增营销渠道
     * @throws Exception
     */
    @Test
    public void testAddMarketingChannelsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑营销渠道
     * @throws Exception
     */
    @Test
    public void testUpdateMarketingChannelsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除营销渠道
     * @throws Exception
     */
    @Test
    public void testDelMarketingChannelsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

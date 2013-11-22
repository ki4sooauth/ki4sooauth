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
public class TestTipsDicCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TipsDicCoreService tipsDicCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增提示信息
     * @throws Exception
     */
    @Test
    public void testAddTipsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑提示信息
     * @throws Exception
     */
    @Test
    public void testUpdateTipsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除提示信息
     * @throws Exception
     */
    @Test
    public void testDelTipsDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

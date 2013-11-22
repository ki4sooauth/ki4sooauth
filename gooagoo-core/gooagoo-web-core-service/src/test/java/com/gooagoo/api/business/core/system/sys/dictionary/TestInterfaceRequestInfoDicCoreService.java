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
public class TestInterfaceRequestInfoDicCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public InterfaceRequestInfoDicCoreService interfaceRequestInfoDicCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增接口请求参数信息
     * @throws Exception
     */
    @Test
    public void testAddInterfaceRequestInfoDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑接口请求参数信息
     * @throws Exception
     */
    @Test
    public void testUpdateInterfaceRequestInfoDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除接口请求参数信息
     * @throws Exception
     */
    @Test
    public void testDelInterfaceRequestInfoDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

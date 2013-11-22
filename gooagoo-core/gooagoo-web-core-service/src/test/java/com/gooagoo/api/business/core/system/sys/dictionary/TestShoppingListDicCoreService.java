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
public class TestShoppingListDicCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShoppingListDicCoreService shoppingListDicCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增购物清单商品类型
     * @throws Exception
     */
    @Test
    public void testAddShoppingListDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑购物清单商品类型
     * @throws Exception
     */
    @Test
    public void testUpdateShoppingListDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除购物清单商品类型
     * @throws Exception
     */
    @Test
    public void testDelShoppingListDic() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

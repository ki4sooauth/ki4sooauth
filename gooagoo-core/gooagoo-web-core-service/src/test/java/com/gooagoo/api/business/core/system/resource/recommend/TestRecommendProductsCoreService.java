package com.gooagoo.api.business.core.system.resource.recommend;

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
public class TestRecommendProductsCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public RecommendProductsCoreService recommendProductsCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增推荐商品
     * @throws Exception
     */
    @Test
    public void testAddRecommendProducts() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除推荐商品
     * @throws Exception
     */
    @Test
    public void testDelRecommendProducts() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑推荐商品
     * @throws Exception
     */
    @Test
    public void testUpdateRecommendProducts() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

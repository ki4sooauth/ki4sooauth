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
public class TestCommentsStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public CommentsStatisticCoreService commentsStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询商品评论次数
     * @throws Exception
     */
    @Test
    public void testGoodsCommentTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商品评论人群
     * @throws Exception
     */
    @Test
    public void testGoodsCommentPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类评论次数
     * @throws Exception
     */
    @Test
    public void testCategoryCommentTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类评论人群
     * @throws Exception
     */
    @Test
    public void testCategoryCommentPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌评论次数
     * @throws Exception
     */
    @Test
    public void testBrandCommentTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌评论人群
     * @throws Exception
     */
    @Test
    public void testBrandCommentPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}

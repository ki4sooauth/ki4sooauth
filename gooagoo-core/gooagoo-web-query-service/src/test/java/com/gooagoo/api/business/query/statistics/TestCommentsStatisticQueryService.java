package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.query.business.statistics.CommentsStatisticQueryServiceImpl;

public class TestCommentsStatisticQueryService
{

    public CommentsStatisticQueryService commentsStatisticService;

    @Before
    public void testBefore()
    {
        //this.commentsStatisticService = ApplicationContextUtils.getBean(CommentsStatisticQueryService.class);
    }

    /**
     * 查询商品评论次数
     * @throws Exception
     */
    @Test
    public void testGoodsCommentTimes() throws Exception
    {
        CommentsStatisticQueryService c = new CommentsStatisticQueryServiceImpl();

        int times = c.goodsCommentTimes("01822MAPVKNP054085QBQVEIISWR0JGT", "6920907809909", "D", "A", new Date(), "1");

        System.out.println(times);
    }

    /**
     * 查询商品评论人群
     * @throws Exception
     */
    @Test
    public void testGoodsCommentPeople() throws Exception
    {
        CommentsStatisticQueryService c = new CommentsStatisticQueryServiceImpl();
        List<String> list = c.goodsCommentPeople("01822MAPVKNP054085QBQVEIISWR0JGT", "6920907809909", "D", "A", new Date(), "1");
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询品类评论次数
     * @throws Exception
     */
    @Test
    public void testCategoryCommentTimes() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询品类评论人群
     * @throws Exception
     */
    @Test
    public void testCategoryCommentPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询品牌评论次数
     * @throws Exception
     */
    @Test
    public void testBrandCommentTimes() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询品牌评论人群
     * @throws Exception
     */
    @Test
    public void testBrandCommentPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

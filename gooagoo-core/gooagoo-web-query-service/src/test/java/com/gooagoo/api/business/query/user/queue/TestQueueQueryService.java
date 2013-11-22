package com.gooagoo.api.business.query.user.queue;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestQueueQueryService
{

    public QueueQueryService queueQueryService;

    @Before
    public void testBefore()
    {
        this.queueQueryService = ApplicationContextUtils.getBean(QueueQueryService.class);
    }

    /**
     * 刷新排号状态
     * @throws Exception
     */
    @Test
    public void testRefreshQueueNo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 获取排号记录
     * @throws Exception
     */
    @Test
    public void testFindQueueRecord() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 销号提醒（店员助理接口 gasj05）
     * @throws Exception
     */
    @Test
    public void testRemoveQueueNo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 排号提醒（店员助理接口 gasj02）
     * @throws Exception
     */
    @Test
    public void testGetQueueNo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

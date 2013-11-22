package com.gooagoo.api.business.query.shop.tool;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestToolQueryService
{

    public ToolQueryService toolQueryService;

    @Before
    public void testBefore()
    {
        this.toolQueryService = ApplicationContextUtils.getBean(ToolQueryService.class);
    }

    /**
     * 已发布服务工具列表查询
     * @throws Exception
     */
    @Test
    public void testFindPublishTool() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 待审核服务工具列表查询
     * @throws Exception
     */
    @Test
    public void testFindNoReviewedTool() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 服务工具详细
     * @throws Exception
     */
    @Test
    public void testFindToolDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

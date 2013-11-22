package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestQueryParametersQueryService
{

    public QueryParametersQueryService queryParametersService;

    @Before
    public void testBefore()
    {
        this.queryParametersService = ApplicationContextUtils.getBean(QueryParametersQueryService.class);
    }

    /**
     * 保存查询参数
     * @throws Exception
     */
    @Test
    public void testSaveQueryParameters() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询商家定义过的查询
     * @throws Exception
     */
    @Test
    public void testFindQueryParameters() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询商家定义过的查询
     * @throws Exception
     */
    @Test
    public void testMemberStatisticService() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

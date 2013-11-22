package com.gooagoo.api.business.query.shop.cache;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestTableCacheQueryService
{

    public TableCacheQueryService tableCacheQueryService;

    @Before
    public void testBefore()
    {
        this.tableCacheQueryService = ApplicationContextUtils.getBean(TableCacheQueryService.class);
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfoByType() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfoByStatus() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

package com.gooagoo.api.business.query.marketing.navigate;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestNavigateQueryService
{

    public NavigateQueryService navigateQueryService;

    @Before
    public void testBefore()
    {
        this.navigateQueryService = ApplicationContextUtils.getBean(NavigateQueryService.class);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindActivityInMap() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 6.8.2. 位置查询（根据“关键字”查询实体店编号或商品编号）
     * @throws Exception
     */
    @Test
    public void testFindPosition() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testNavigateByCoordinate() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 6.8.4. 导航（起点{x,y}，实体店编号或商品编号）
     * @throws Exception
     */
    @Test
    public void testNavigateByPosition() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindShopListInMap() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

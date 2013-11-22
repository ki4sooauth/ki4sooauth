package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestTableStatisticQueryService
{

    public TableStatisticQueryService tableStatisticQueryService;

    @Before
    public void testBefore()
    {
        this.tableStatisticQueryService = ApplicationContextUtils.getBean(TableStatisticQueryService.class);
    }

    /**
     * 查询实体店餐桌上座率
     * @throws Exception
     */
    @Test
    public void testFindTableAttendance() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

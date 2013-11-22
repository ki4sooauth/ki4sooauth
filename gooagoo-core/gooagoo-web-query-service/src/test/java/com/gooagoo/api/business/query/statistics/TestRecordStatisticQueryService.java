package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestRecordStatisticQueryService
{

    public RecordStatisticQueryService recordStatisticService;

    @Before
    public void testBefore()
    {
        this.recordStatisticService = ApplicationContextUtils.getBean(RecordStatisticQueryService.class);
    }

    /**
     * 获取会员特征统计数据
     * @throws Exception
     */
    @Test
    public void testMemberFeatureStatistic() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 获取会员特征统计数据
     * @throws Exception
     */
    @Test
    public void testMemberStatisticService() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

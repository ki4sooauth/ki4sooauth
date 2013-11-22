package com.gooagoo.api.business.query.statistics.user;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestActivityStatisticQueryService
{

    public ActivityStatisticQueryService activityStatisticService;

    @Before
    public void testBefore()
    {
        this.activityStatisticService = ApplicationContextUtils.getBean(ActivityStatisticQueryService.class);
    }

    /**
     * 猜你喜欢的活动
     * @throws Exception
     */
    @Test
    public void testQueryGuessYouTastes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

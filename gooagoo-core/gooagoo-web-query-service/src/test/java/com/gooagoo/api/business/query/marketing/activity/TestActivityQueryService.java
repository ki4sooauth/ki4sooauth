package com.gooagoo.api.business.query.marketing.activity;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.marketing.ActivityDetail;
import com.gooagoo.entity.business.marketing.activity.ActivitylistBusiness;

public class TestActivityQueryService
{

    public ActivityQueryService activityQueryService;

    @Before
    public void testBefore()
    {
        this.activityQueryService = ApplicationContextUtils.getBean(ActivityQueryService.class);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindActivity() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 活动详情
     * @throws Exception
     */
    @Test
    public void testFindActivityDetail() throws Exception
    {
        String activityId = "00017R5PUAQI043MH0037AEIISX8Q016";
        ActivityDetail activityDetail = this.activityQueryService.findActivityDetail(activityId);
        Assert.assertNotNull("查询活动详情失败", activityDetail);
    }

    /**
     * mobd03
     * @throws Exception
     */
    @Test
    public void testGetMarketingActivityInfo() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * mobd04
     * @throws Exception
     */
    @Test
    public void testGetActivitylistInfo() throws Exception
    {
        Date startdate = TimeUtils.convertStringToDate("2012-11-01 01:00:00");
        Date enddate = TimeUtils.convertStringToDate("2013-11-01 01:00:00");
        List<ActivitylistBusiness> activitylistBusinessList = this.activityQueryService.getActivitylistInfo(startdate, enddate, null, null);
        Assert.assertTrue("获取活动列表信息失败", CollectionUtils.isNotEmpty(activitylistBusinessList));
    }

    /**
     * 通过主键获取活动基本信息（包括活动目的、内容、描述、模板数据）
     * @throws Exception
     */
    @Test
    public void testGetMarketingActivityInfoById() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 根据条件查询总记录数
     * @throws Exception
     */
    @Test
    public void testCountMarketingActivityInfo() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 根据条件查询活动基本信息（包括活动目的、内容、描述、模板数据）
     * @throws Exception
     */
    @Test
    public void testSelectMarketingActivityInfoByExample() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

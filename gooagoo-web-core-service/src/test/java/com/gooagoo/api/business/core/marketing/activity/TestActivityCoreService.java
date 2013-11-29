package com.gooagoo.api.business.core.marketing.activity;

import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.dao.generator.marketing.MarketingActivityMapper;
import com.gooagoo.entity.generator.marketing.MarketingActivity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestActivityCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ActivityCoreService activityCoreService;
    @Autowired
    public MarketingActivityMapper marketingActivityMapper;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.2.4. 创建活动
     * @throws Exception
     */
    @Test
    public void testAddActivity() throws Exception
    {
        MarketingActivity activity = new MarketingActivity();
        activity.setActivityId("3");
        activity.setActivityName("test11");
        activity.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        activity.setContent("test");
        activity.setStartTime(new Date());
        activity.setEndTime(new Date());
        activity.setImgUrl("1");
        activity.setTitle("test");
        activity.setPurpose("test");
        activity.setDescription("test");
        boolean isSucceed = this.activityCoreService.addActivity(activity);
        Assert.isTrue(isSucceed, "添加活动");
    }

    /**
     * 6.2.5. 编辑活动
     * @throws Exception
     */
    @Test
    public void testUpdateActivity() throws Exception
    {
        MarketingActivity activity = new MarketingActivity();
        activity.setActivityId("2");
        activity.setActivityName("活动一");
        boolean isSucceed = this.activityCoreService.updateActivity(activity);
        Assert.isTrue(isSucceed, "修改活动");
    }

    /**
     * 6.2.6. 删除活动（删除活动规则、内容）
     * @throws Exception
     */
    @Test
    public void testDeleteActivity() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.activityCoreService.deleteActivity(id);
        Assert.isTrue(isSucceed, "删除活动");
    }

    /**
     * 6.2.10. 审核活动
     * @throws Exception
     */
    @Test
    public void testReviewedActivity() throws Exception
    {
        String id = "2";
        boolean isSucceed = this.activityCoreService.reviewedActivity(id, "Y", "");
        Assert.isTrue(isSucceed, "审核活动");
    }

    /**
     * 发布活动
     * @throws Exception
     */
    @Test
    public void testPublishActivity() throws Exception
    {
        /*
        MarketingActivityExample marketingActivityExample = new MarketingActivityExample();
        marketingActivityExample.createCriteria().andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        List<MarketingActivity> marketingActivityList = this.marketingActivityMapper.selectByExample(marketingActivityExample);
        Assert.isTrue(CollectionUtils.isNotEmpty(marketingActivityList), "批量发布活动失败");
        List<String> activityIdList = new ArrayList<String>();
        for (MarketingActivity activity : marketingActivityList)
        {
            activityIdList.add(activity.getActivityId());
        }
        MarketingActivity marketingActivity = new MarketingActivity();
        marketingActivity.setPublishStatus("A");
        marketingActivityExample = new MarketingActivityExample();
        marketingActivityExample.createCriteria().andActivityIdIn(activityIdList);
        Assert.isTrue(this.marketingActivityMapper.updateByExampleSelective(marketingActivity, marketingActivityExample) == activityIdList.size(), "批量更新活动发布状态失败");
        for (String activityId : activityIdList)
        {
            Assert.isTrue(this.activityCoreService.publishActivity(activityId), "生成活动静态页面失败[activityId=" + activityId + "]");
        }
        */
        String activityId = "188H1PHUOTFP4100A1BAQJA6SURK2S7P";
        Assert.isTrue(this.activityCoreService.publishActivity(activityId), "生成活动静态页面失败[activityId=" + activityId + "]");
    }

}

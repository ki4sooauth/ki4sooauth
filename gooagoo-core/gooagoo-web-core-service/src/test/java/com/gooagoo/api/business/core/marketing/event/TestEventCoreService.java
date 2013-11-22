package com.gooagoo.api.business.core.marketing.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestEventCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public EventCoreService eventCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.6.1. 创建事件
     * @throws Exception
     */
    @Test
    public void testAddEvent() throws Exception
    {
        MarketingEvent marketingEvent = new MarketingEvent();
        marketingEvent.setEventId("3");
        marketingEvent.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        marketingEvent.setActivityId("1");
        marketingEvent.setChannelLeaf("5");
        marketingEvent.setChannelRoot("5");
        marketingEvent.setEventName("test");
        marketingEvent.setEventTarget("test");
        marketingEvent.setTemplateData("");
        marketingEvent.setTemplateId("1");
        String[][] marketings = { { "C", "1" } };
        boolean isSucceed = this.eventCoreService.addEvent(marketingEvent, marketings);
        Assert.isTrue(isSucceed, "添加事件");
    }

    /**
     * 6.6.2. 编辑事件
     * @throws Exception
     */
    @Test
    public void testUpdateEvent() throws Exception
    {
        MarketingEvent marketingEvent = new MarketingEvent();
        marketingEvent.setEventId("1");
        marketingEvent.setEventName("test12");
        String[][] marketings = { { "C", "2" } };
        boolean isSucceed = this.eventCoreService.updateEvent(marketingEvent, marketings);
        Assert.isTrue(isSucceed, "修改事件");
    }

    /**
     * 6.6.3. 审核事件
     * @throws Exception
     */
    @Test
    public void testReviewedEvent() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.eventCoreService.reviewedEvent(id, "Y", "");
        Assert.isTrue(isSucceed, "审核事件");
    }

    /**
     * 6.6.4. 发布事件
     * @throws Exception
     */
    @Test
    public void testPublishEvent() throws Exception
    {
        String id = "183P62E2TJ1FDH2G8PEQCP2DL43J08KF";

        List<Account> userList = new ArrayList<Account>();
        Account acc = new Account();
        acc.setUserId("1");
        userList.add(acc);

        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setActivityId("1");
        ruleInfo.setStartTime(new Date());
        ruleInfo.setEndTime(new Date());
        ruleInfo.setIsPublishImmediately("Y");
        ruleInfo.setRuleActiveType("2");
        ruleInfo.setRuleId(com.gooagoo.common.utils.StringUtils.getUUID());
        ruleInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        ruleInfo.setCrowdType("0");

        RuleCondition ruleCondition = new RuleCondition();
        ruleCondition.setConditionType("H");
        ruleInfo.setRuleContent(new Gson().toJson(ruleCondition));

        boolean isSucceed = this.eventCoreService.publishEvent(id, "5", userList, ruleInfo);
        Assert.isTrue(isSucceed, "发布事件");
    }

    /**
     * 6.6.7. 删除事件
     * @throws Exception
     */
    @Test
    public void testDeleteEvent() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.eventCoreService.deleteEvent(id);
        Assert.isTrue(isSucceed, "删除事件");
    }

}

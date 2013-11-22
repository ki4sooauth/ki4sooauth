package com.gooagoo.api.business.core.marketing.rule;

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

import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestRuleInfoCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public RuleInfoCoreService ruleInfoCoreService;
    @Autowired
    private RuleInfoGeneratorCoreService ruleInfoGeneratorCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 删除规则信息
     * @throws Exception
     */
    @Test
    public void testDeleteRuleInfo() throws Exception
    {
        boolean isSucceed = this.ruleInfoCoreService.deleteRuleInfo("1");
        Assert.isTrue(isSucceed, "删除规则信息");
    }

    /**
     * 添加规则信息
     * @throws Exception
     */
    @Test
    public void testAddRuleInfo() throws Exception
    {
        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setRuleId("5");
        ruleInfo.setRuleName("test11");
        ruleInfo.setActualPublishTime(new Date());
        ruleInfo.setRuleType("0");
        ruleInfo.setObjectId("1");

        ruleInfo.setActivityId("1");
        ruleInfo.setStartTime(new Date());
        ruleInfo.setEndTime(new Date());
        ruleInfo.setIsPublishImmediately("Y");
        ruleInfo.setRuleActiveType("2");
        ruleInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        ruleInfo.setCrowdType("0");

        RuleCondition ruleCondition = new RuleCondition();
        ruleCondition.setConditionType("H");
        ruleInfo.setRuleContent(new Gson().toJson(ruleCondition));

        boolean isSucceed = this.ruleInfoCoreService.addRuleInfo(ruleInfo);
        Assert.isTrue(isSucceed, "添加规则信息");
    }

    /**
     * 修改规则信息
     * @throws Exception
     */
    @Test
    public void testUpdateRuleInfo() throws Exception
    {
        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setRuleId("1");
        ruleInfo.setRuleName("test12");
        boolean isSucceed = this.ruleInfoCoreService.updateRuleInfo(ruleInfo);
        Assert.isTrue(isSucceed, "修改规则信息");
    }

    /**
     * 审核规则信息
     * @throws Exception
     */
    @Test
    public void testReviewedRuleInfo() throws Exception
    {
        boolean isSucceed = this.ruleInfoCoreService.reviewedRuleInfo("1", "Y", "");
        Assert.isTrue(isSucceed, "审核规则信息");
    }

    /**
     * 发布规则信息(修改发布状态)
     * @throws Exception
     */
    @Test
    public void testPublishRuleInfo() throws Exception
    {
        RuleInfo ruleInfo = this.ruleInfoGeneratorCoreService.selectByPrimaryKey("2");
        boolean isSucceed = this.ruleInfoCoreService.publishRuleInfo(ruleInfo);
        Assert.isTrue(isSucceed, "发布规则信息(修改发布状态)");
    }
}

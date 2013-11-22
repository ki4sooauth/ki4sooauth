package com.gooagoo.api.business.core.marketing.rule;

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

import com.gooagoo.api.generator.core.marketing.RuleResultGeneratorCoreService;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestRuleResultCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public RuleResultCoreService ruleResultCoreService;
    @Autowired
    private RuleResultGeneratorCoreService ruleResultGeneratorCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 删除规则结果
     * @throws Exception
     */
    @Test
    public void testDeleteRuleResult() throws Exception
    {
        boolean isSucceed = this.ruleResultCoreService.deleteRuleResult("000181OJO7RQ2KEUD1C72PUAZV1B939K");
        Assert.isTrue(isSucceed, "删除规则结果");
    }

    /**
     * 添加规则结果
     * @throws Exception
     */
    @Test
    public void testAddRuleResult() throws Exception
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setRuleResultId("3");
        ruleResult.setActivityId("1");
        ruleResult.setRuleId("r1");
        ruleResult.setRuleResultType("2");
        ruleResult.setRuleResultValue("1");
        boolean isSucceed = this.ruleResultCoreService.addRuleResult(ruleResult);
        Assert.isTrue(isSucceed, "添加规则结果");
    }

    /**
     * 修改规则结果
     * @throws Exception
     */
    @Test
    public void testUpdateRuleResult() throws Exception
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setRuleResultId("000181OJO7RQ2KEUD1C72PUAZV1B939K");
        ruleResult.setRuleResultValue("2");
        boolean isSucceed = this.ruleResultCoreService.updateRuleResult(ruleResult);
        Assert.isTrue(isSucceed, "修改规则信息");
    }

    /**
     * 审核规则结果
     * @throws Exception
     */
    @Test
    public void testReviewedRuleResult() throws Exception
    {
        boolean isSucceed = this.ruleResultCoreService.reviewedRuleResult("000181OJO7RQ2KEUD1C72PUAZV1B939K", "Y", "");
        Assert.isTrue(isSucceed, "审核规则信息");
    }

    /**
     * 发布规则结果(修改发布状态)
     * @throws Exception
     */
    @Test
    public void testPublishRuleResult() throws Exception
    {
        RuleResult ruleResult = this.ruleResultGeneratorCoreService.selectByPrimaryKey("000181B916VTT7DQJJDUIDUAZV1B93AK");
        boolean isSucceed = this.ruleResultCoreService.publishRuleResult(ruleResult);
        Assert.isTrue(isSucceed, "发布规则信息(修改发布状态)");
    }

    /**
     * 删除规则结果和规则信息
     * @throws Exception
     */
    @Test
    public void testDeleteRuleResultAndInfo() throws Exception
    {
        String ruleResultId = "000181B916VTT7DQJJDUIDUAZV1B93AK";
        boolean isSucceed = this.ruleResultCoreService.deleteRuleResult(ruleResultId);
        Assert.isTrue(isSucceed, "删除规则结果和规则信息");
    }

    /**
     * 添加规则结果和规则信息
     * @throws Exception
     */
    @Test
    public void testAddRuleResultAndInfo() throws Exception
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setRuleResultId("ri3");
        ruleResult.setActivityId("1");
        ruleResult.setRuleId("ri3");
        ruleResult.setRuleResultType("2");
        ruleResult.setRuleResultValue("1");

        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setRuleId("ri3");
        ruleInfo.setRuleName("test11");
        ruleInfo.setActualPublishTime(new Date());
        ruleInfo.setRuleType("0");
        ruleInfo.setObjectId("ri3");

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

        boolean isSucceed = this.ruleResultCoreService.addRuleResultAndInfo(ruleResult, ruleInfo);
        Assert.isTrue(isSucceed, "添加规则结果和规则信息");
    }

    /**
     * 修改规则结果和规则信息
     * @throws Exception
     */
    @Test
    public void testUpdateRuleResultAndInfo() throws Exception
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setRuleResultId("000181B916VTT7DQJJDUIDUAZV1B93AK");
        ruleResult.setRuleId("000181B916VTT4AB4JDUICUAZV1B93AK");
        ruleResult.setRuleResultValue("2");

        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setRuleId("000181B916VTT4AB4JDUICUAZV1B93AK");
        ruleInfo.setObjectId("000181B916VTT7DQJJDUIDUAZV1B93AK");
        ruleInfo.setRuleName("test12");

        boolean isSucceed = this.ruleResultCoreService.updateRuleResultAndInfo(ruleResult, ruleInfo);
        Assert.isTrue(isSucceed, "修改规则结果和规则信息");
    }

    /**
     * 审核规则结果和规则信息
     * @throws Exception
     */
    @Test
    public void testReviewedRuleResultAndInfo() throws Exception
    {
        String ruleInfoId = "000181BOVDMBFA9SC0VMFLUAZV1B903C";
        boolean isSucceed = this.ruleResultCoreService.reviewedRuleResultAndInfo(ruleInfoId, "Y", "");
        Assert.isTrue(isSucceed, "审核规则结果和规则信息");
    }

    /**
     * 发布规则结果和规则信息
     * @throws Exception
     */
    @Test
    public void testPublishRuleResultAndInfo() throws Exception
    {
        String ruleInfoId = "000181B916VTT4AB4JDUICUAZV1B93AK";
        List<Account> userList = new ArrayList<Account>();
        Account acc = new Account();
        acc.setUserId("1");
        userList.add(acc);
        boolean isSucceed = this.ruleResultCoreService.publishRuleResultAndInfo(ruleInfoId, userList);
        Assert.isTrue(isSucceed, "发布规则结果和规则信息");
    }

}

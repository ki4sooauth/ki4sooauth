package com.gooagoo.api.business.core.marketing.shortmessage;

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
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShortMessageCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShortMessageCoreService shortMessageCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.5.1. 创建短信
     * @throws Exception
     */
    @Test
    public void testAddShortMessage() throws Exception
    {
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessageId("3");
        shortMessage.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shortMessage.setActivityId("1");
        shortMessage.setContent("test");
        shortMessage.setMessageTitle("test");
        boolean isSucceed = this.shortMessageCoreService.addShortMessage(shortMessage);
        Assert.isTrue(isSucceed, "添加短信");
    }

    /**
     * 6.5.2. 编辑短信
     * @throws Exception
     */
    @Test
    public void testUpdateShortMessage() throws Exception
    {
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessageId("1");
        shortMessage.setMessageTitle("test12");
        boolean isSucceed = this.shortMessageCoreService.updateShortMessage(shortMessage);
        Assert.isTrue(isSucceed, "修改短信");
    }

    /**
     * 6.5.3. 审核短信
     * @throws Exception
     */
    @Test
    public void testReviewedShortMessage() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.shortMessageCoreService.reviewedShortMessage(id, "Y", "");
        Assert.isTrue(isSucceed, "审核短信");
    }

    /**
     * 6.5.4.发布短信
     * @throws Exception
     */
    @Test
    public void testPublishShortMessage() throws Exception
    {
        String id = "2";

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

        boolean isSucceed = this.shortMessageCoreService.publishShortMessage(id, userList, ruleInfo);
        Assert.isTrue(isSucceed, "发布短信");
    }

    /**
     * 6.5.7. 删除短信
     * @throws Exception
     */
    @Test
    public void testDeleteShortMessage() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.shortMessageCoreService.deleteShortMessage(id);
        Assert.isTrue(isSucceed, "删除短信");
    }

}

package com.gooagoo.api.business.core.marketing.cryout;

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

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestCryoutCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public CryoutCoreService cryoutCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.4.1. 创建吆喝
     * @throws Exception
     */
    @Test
    public void testAddCryoutInfo() throws Exception
    {
        CryoutInfo cryoutInfo = new CryoutInfo();
        cryoutInfo.setCryoutInfoId("3");
        cryoutInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        cryoutInfo.setActivityId("1");
        cryoutInfo.setAuditNote("");
        cryoutInfo.setCryoutTextMobile("test");
        cryoutInfo.setCryoutTextWeb("test");
        cryoutInfo.setCryoutTitle("test");
        cryoutInfo.setCryoutType("L");
        cryoutInfo.setImg("");
        boolean isSucceed = this.cryoutCoreService.addCryoutInfo(cryoutInfo);
        Assert.isTrue(isSucceed, "添加吆喝");
    }

    /**
     * 6.4.2. 编辑吆喝
     * @throws Exception
     */
    @Test
    public void testUpdateCryoutInfo() throws Exception
    {
        CryoutInfo cryoutInfo = new CryoutInfo();
        cryoutInfo.setCryoutInfoId("00017P7G1OFQ9QGCG0004AJ4VOR9U012");
        cryoutInfo.setCryoutTitle("test12");
        boolean isSucceed = this.cryoutCoreService.updateCryoutInfo(cryoutInfo);
        Assert.isTrue(isSucceed, "修改吆喝");
    }

    /**
     * 6.4.3. 审核吆喝
     * @throws Exception
     */
    @Test
    public void testReviewedCryoutInfo() throws Exception
    {
        String id = "00017P7GV0LQ5L0UQ00064J4VOR9U012";
        boolean isSucceed = this.cryoutCoreService.reviewedCryoutInfo(id, "Y", "");
        Assert.isTrue(isSucceed, "审核吆喝");
    }

    /**
     * 6.4.4. 发布吆喝
     * @throws Exception
     */
    @Test
    public void testPublishCryoutInfo() throws Exception
    {
        String cryoutInfoId = "00017P2CO2SDLIF3M0000Ij4vor9u012";
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
        ruleInfo.setRuleId(UUID.getUUID());
        ruleInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        ruleInfo.setCrowdType("0");
        RuleCondition ruleCondition = new RuleCondition();
        ruleCondition.setConditionType("H");
        ruleInfo.setRuleContent(new Gson().toJson(ruleCondition));
        boolean isSucceed = this.cryoutCoreService.publishCryoutInfo(cryoutInfoId, userList, ruleInfo);
        Assert.isTrue(isSucceed, "发布吆喝");
    }

    /**
     * 6.4.7. 删除吆喝
     * @throws Exception
     */
    @Test
    public void testDeleteCryoutInfo() throws Exception
    {
        String id = "00017P7G1OFQ9QGCG0004AJ4VOR9U012";
        boolean isSucceed = this.cryoutCoreService.deleteCryoutInfo(id);
        Assert.isTrue(isSucceed, "删除吆喝");
    }

}

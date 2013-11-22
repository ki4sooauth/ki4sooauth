package com.gooagoo.api.business.core.marketing.notice;

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
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestNoticeCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public NoticeCoreService noticeCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.7.1. 创建通知
     * @throws Exception
     */
    @Test
    public void testAddNotice() throws Exception
    {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeInfoId("3");
        noticeInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        noticeInfo.setActivityId("1");
        noticeInfo.setAuditNote("");
        noticeInfo.setNoticeTextMobile("test");
        noticeInfo.setNoticeTextWeb("test");
        noticeInfo.setNoticeTitle("test");
        noticeInfo.setImg("");
        boolean isSucceed = this.noticeCoreService.addNotice(noticeInfo);
        Assert.isTrue(isSucceed, "添加通知");
    }

    /**
     * 6.7.2. 编辑通知
     * @throws Exception
     */
    @Test
    public void testUpdateNotice() throws Exception
    {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeInfoId("1");
        noticeInfo.setNoticeTitle("test12");
        boolean isSucceed = this.noticeCoreService.updateNotice(noticeInfo);
        Assert.isTrue(isSucceed, "修改通知");
    }

    /**
     * 6.7.3. 审核通知
     * @throws Exception
     */
    @Test
    public void testReviewedNotice() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.noticeCoreService.reviewedNotice(id, "Y", "");
        Assert.isTrue(isSucceed, "审核通知");
    }

    /**
     * 6.7.4. 发布通知
     * @throws Exception
     */
    @Test
    public void testPublishNotice() throws Exception
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

        boolean isSucceed = this.noticeCoreService.publishNotice(id, userList, ruleInfo);
        Assert.isTrue(isSucceed, "发布通知");
    }

    /**
     * 6.7.7. 删除通知
     * @throws Exception
     */
    @Test
    public void testDeleteNotice() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.noticeCoreService.deleteNotice(id);
        Assert.isTrue(isSucceed, "删除通知");
    }

}

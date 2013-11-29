package com.gooagoo.api.business.core.member.membercard;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestAuditMemberCardCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public AuditMemberCardCoreService auditMemberCardCoreService;

    @Override
    @Resource(name = "memberSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 5.5.5. 会员卡审核操作
     * @throws Exception
     */
    @Test
    public void testAuditMemberCard() throws Exception
    {
        String applicationId = "1888NLEQ2QSJNU0GNT4BI4FP2E1QGGEV";
        String status = "Y";
        String note = "test";
        Assert.isTrue(this.auditMemberCardCoreService.auditMemberCard(applicationId, status, note), "会员卡审核失败");
    }

    /**
     * 5.5.10. 物理卡转换审批操作
     * @throws Exception
     */
    @Test
    public void testAuditConvertPhysicalCard() throws Exception
    {
        String applicationId = "00HF2B1ETM2W37TH000001UAZV1A1002";
        String status = "N";
        String note = "test";
        Assert.isTrue(this.auditMemberCardCoreService.auditConvertPhysicalCard(applicationId, status, note), "物理卡转换审批失败");
    }

    /**
     * 5.5.13. 会员卡升级审批操作
     * @throws Exception
     */
    @Test
    public void testAuditMemberCardUpgrade() throws Exception
    {
        String cardUpInfoId = "1888O8P78BO2BK0GNT4BI4FPP84MG5ER";
        String status = "Y";
        String note = "满足升级条件、批准升级为沃尔玛购物广场高级金卡";
        Assert.isTrue(this.auditMemberCardCoreService.auditMemberCardUpgrade(cardUpInfoId, status, note), "会员卡升级审批失败");
    }

    /**
     * 5.5.16. 会员特批操作
     * @throws Exception
     */
    @Test
    public void testSpecialApprovalMemberCard() throws Exception
    {
        String shopId = "185EVK63KPRTKH00A1BAQJMCA2H349CC";
        String userId = "185JPQM4F8KPMB00A1BAQJMCHPSLC0AK";
        String newCardId = "187FQSURN45NL700A1BAQJMEJJIUPKGJ";
        String oldCardId = "185JSRKNH1G38Q00A1BAQJMEC05EOELE";
        Assert.isTrue(this.auditMemberCardCoreService.specialApprovalMemberCard(shopId, userId, newCardId, oldCardId), "会员特批失败");
    }

}

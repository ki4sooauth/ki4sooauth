package com.gooagoo.api.business.query.member.card;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestAuditCardQueryService
{

    public AuditCardQueryService auditCardQueryService;

    @Before
    public void testBefore()
    {
        this.auditCardQueryService = ApplicationContextUtils.getBean(AuditCardQueryService.class);
    }

    /**
     * 5.5.1. 商家查询全部会员卡审批列表
     * @throws Exception
     */
    @Test
    public void testFindAuditMemberCardList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 5.5.6. 全部物理卡转换审批列表查询
     * @throws Exception
     */
    @Test
    public void testFindConvertPhysicalCardList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 5.5.12. 会员卡升级审批列表查询
     * @throws Exception
     */
    @Test
    public void testFindMemberCardUpgradeList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

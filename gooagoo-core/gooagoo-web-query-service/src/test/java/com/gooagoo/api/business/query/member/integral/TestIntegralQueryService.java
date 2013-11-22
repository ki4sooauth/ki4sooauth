package com.gooagoo.api.business.query.member.integral;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestIntegralQueryService
{

    public IntegralQueryService integralQueryService;

    @Before
    public void testBefore()
    {
        this.integralQueryService = ApplicationContextUtils.getBean(IntegralQueryService.class);
    }

    /**
     * 5.1.7. 会员查询会员积分
     * @throws Exception
     */
    @Test
    public void testFindIntegral() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        String score = this.integralQueryService.findIntegral(userId, shopId);
        Assert.assertTrue("会员查询会员积分失败", StringUtils.isNotBlank(score));
    }

    /**
     * 查询兑换记录列表（分页、排序）
     * @throws Exception
     */
    @Test
    public void testFindIntegralExchange() throws Exception
    {
        Assert.assertNotNull("", "");
    }

}

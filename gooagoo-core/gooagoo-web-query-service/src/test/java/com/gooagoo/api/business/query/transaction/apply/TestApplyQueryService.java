package com.gooagoo.api.business.query.transaction.apply;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.transaction.OrderBusiness;

public class TestApplyQueryService
{

    public ApplyQueryService applyQueryService;

    @Before
    public void testBefore()
    {
        this.applyQueryService = ApplicationContextUtils.getBean(ApplyQueryService.class);
    }

    /**
     * gtsc01
     * @throws Exception
     */
    @Test
    public void testFindApplyBill() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gtsc14
     * @throws Exception
     */
    @Test
    public void testFindAddApplyInfo() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gtsc03:商家查询用户开发票申请信息
     * @throws Exception
     */
    @Test
    public void testFindApplyInvoiceList() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String ctimestamp = "2013-10-16 00:00:00";
        List<OrderBusiness> list = this.applyQueryService.findApplyInvoiceList(shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询用户开发票申请信息失败", CollectionUtils.isNotEmpty(list));
    }
}

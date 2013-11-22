package com.gooagoo.api.business.query.statistics;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.statistics.UserGroup;

public class TestCrowdOperationQueryService
{

    public CrowdOperationQueryService crowdOperationService;

    @Before
    public void testBefore()
    {
        this.crowdOperationService = ApplicationContextUtils.getBean(CrowdOperationQueryService.class);
    }

    /**
     * 保存人群
     * @throws Exception
     */
    @Test
    public void testSaveCrowd() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询商家己保存人群
     * @throws Exception
     */
    @Test
    public void testFindCrowd() throws Exception
    {
        List<UserGroup> list = this.crowdOperationService.findCrowd("testCorporation");
        System.out.println("testFindCrowd:" + list.size());
        for (UserGroup obj : list)
        {
            System.out.println(obj.getGroupId());
            System.out.println(obj.getGroupName());
            System.out.println(obj.getGroupDesc());
        }
    }

    /**
     * 查询图表中具体标签下的用户
     * @throws Exception
     */
    @Test
    public void testFindAccounts() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 根据人群ID查询人群列表
     * @throws Exception
     */
    @Test
    public void testGetAccountsByGroupID() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}

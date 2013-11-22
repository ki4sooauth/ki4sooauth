package com.gooagoo.api.business.query.member.query;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.member.MemberBaseInfoAdapter;
import com.gooagoo.entity.business.member.ShopMemberDetail;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.google.gson.Gson;

public class TestShopMemberQueryService
{

    public ShopMemberQueryService shopMemberQueryService;

    @Before
    public void testBefore()
    {
        this.shopMemberQueryService = ApplicationContextUtils.getBean(ShopMemberQueryService.class);
    }

    /**
     * 通过物理卡查询会员详细信息（包括会员基本信息、积分信息、会员卡基本信息、会员卡和用户关联信息）
     * @throws Exception
     */
    @Test
    public void testFindShopMemberDetailByPhyCardNo() throws Exception
    {
        ShopMemberDetail obj = this.shopMemberQueryService.findShopMemberDetailByPhyCardNo("00017Q3EG198TUUV50000HFYOBYEH00F", "100008000000DA10");
        if (obj != null)
        {
            System.out.println(new Gson().toJson(obj));
        }
        Assert.assertNotNull("通过物理卡查询会员详细信息（包括会员基本信息、积分信息、会员卡基本信息、会员卡和用户关联信息）", obj);
    }

    /**
     * 查询用户特征信息
     * @throws Exception
     */
    @Test
    public void testFindMemberFeatures() throws Exception
    {
        List<MemberFeatureInfo> list = this.shopMemberQueryService.findMemberFeatures("00017Q3EG198TUUV50000HFYOBYEH00F", "1");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("查询用户特征信息", list);
    }

    /**
     * 查询会员基本信息数量
     * @throws Exception
     */
    @Test
    public void testcountMemberBaseInfo() throws Exception
    {
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setShopId(null);
        memberBaseInfo.setPhyNo(null);
        memberBaseInfo.setName(null);
        Integer count = this.shopMemberQueryService.countMemberBaseInfo(memberBaseInfo);
        Assert.assertNotNull("查询会员基本信息数量失败", count);
    }

    /**
     * 查询会员基本信息
     * @throws Exception
     */
    @Test
    public void testfindMemberBaseInfo() throws Exception
    {
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setShopId(null);
        memberBaseInfo.setPhyNo(null);
        memberBaseInfo.setName(null);
        Integer pageIndex = null;
        Integer pageSize = null;
        List<MemberBaseInfoAdapter> list = this.shopMemberQueryService.findMemberBaseInfo(memberBaseInfo, pageIndex, pageSize);
        Assert.assertTrue("查询会员基本信息失败", CollectionUtils.isNotEmpty(list));
    }
}

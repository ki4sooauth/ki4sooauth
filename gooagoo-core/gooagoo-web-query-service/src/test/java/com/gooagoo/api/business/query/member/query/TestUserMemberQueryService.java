package com.gooagoo.api.business.query.member.query;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.member.MemberBaseInfoBusiness;
import com.gooagoo.entity.business.member.MemberInfoBusiness;

public class TestUserMemberQueryService
{

    public UserMemberQueryService userMemberQueryService;

    @Before
    public void testBefore()
    {
        this.userMemberQueryService = ApplicationContextUtils.getBean(UserMemberQueryService.class);
    }

    /**
     * 查询会员信息
     * @throws Exception
     */
    @Test
    public void testFindMemberInfo() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        String scardno = "";
        MemberInfoBusiness memberInfoBusiness = this.userMemberQueryService.findMemberInfo(userId, shopId, scardno);
        Assert.assertNotNull("查询会员信息失败", memberInfoBusiness);
    }

    /**
     * 会员特征管理列表查询
     * @throws Exception
     */
    @Test
    public void testFindMemberFeatureList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询会员特征信息
     * @throws Exception
     */
    @Test
    public void testFindMemberFeature() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gase01 店员查询店内区域会员列表
     * @throws Exception
     */
    @Test
    public void testFindMemberListInPosition() throws Exception
    {
        String shopId = "01822MAPVKNP054085QBQVEIISWR0JGT";
        String positionid = "018231OPL6IJARO02VLL2BEIISWR2TKG";
        Integer pageIndex = 1;
        Integer pageSize = 10;
        List<MemberBaseInfoBusiness> list = this.userMemberQueryService.findMemberListInPosition(shopId, positionid, pageIndex, pageSize);
        Assert.assertTrue("店员查询店内区域会员列表失败", CollectionUtils.isNotEmpty(list));
    }
}

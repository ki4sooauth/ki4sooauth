package com.gooagoo.api.business.core.member.usermember;

import java.util.ArrayList;
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

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestUserMemberCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserMemberCoreService userMemberCoreService;

    @Override
    @Resource(name = "memberSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 申请会员
     * @throws Exception
     */
    @Test
    public void testApplyMember() throws Exception
    {
        MemberApply memberApply = new MemberApply();
        memberApply.setUserId("1883FRM0MEJE5800A1BAQJMC3CLLDULQ");
        memberApply.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
        memberApply.setSource("W");
        memberApply.setName("王宇");
        memberApply.setSex("M");
        memberApply.setBirthday(TimeUtils.convertStringToDate("1989-06-03"));
        memberApply.setIdType("00");
        memberApply.setIdNo("130221198906030096");
        memberApply.setMobile("15011592429");
        Assert.isTrue(this.userMemberCoreService.applyMember(memberApply), "申请会员失败");
    }

    /**
     * 删除会员卡
     * @throws Exception
     */
    @Test
    public void testDeleteMember() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 物理卡转换申请
     * @throws Exception
     */
    @Test
    public void testApplyConvertPhysicalCard() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 会员修改会员信息
     * @throws Exception
     */
    @Test
    public void testUpdateMemberInfo() throws Exception
    {
        String userId = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setShopId("01822IAKR5SKU02085QBP2EIISWR0JGT");
        memberBaseInfo.setName("rose");
        memberBaseInfo.setSex("F");
        memberBaseInfo.setBirthday(TimeUtils.convertStringToDate("1988-08-22"));
        memberBaseInfo.setMobile("13667458041");
        memberBaseInfo.setTelephone("62332100");
        memberBaseInfo.setEmail("13667458041@126.com");
        memberBaseInfo.setPostcode("100000");
        memberBaseInfo.setAddress("北京市");
        List<MemberFeatureInfo> memberFeatureInfoList = new ArrayList<MemberFeatureInfo>();
        MemberFeatureInfo memberFeatureInfo = new MemberFeatureInfo();
        memberFeatureInfo.setFeatureCode("11");
        memberFeatureInfo.setFeatureValue("11");
        memberFeatureInfoList.add(memberFeatureInfo);
        Assert.isTrue(this.userMemberCoreService.updateMemberInfo(userId, memberBaseInfo, memberFeatureInfoList), "会员修改会员信息失败");
    }
}

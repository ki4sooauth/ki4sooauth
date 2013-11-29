package com.gooagoo.api.business.core.member.memberfeature;

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

import com.gooagoo.entity.generator.member.MemberFeature;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestMemberFeatureCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MemberFeatureCoreService memberFeatureCoreService;

    @Override
    @Resource(name = "memberSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 5.6.1.2. 新增会员特征
     * @throws Exception
     */
    @Test
    public void testAddMemberFeature() throws Exception
    {
        MemberFeature memberFeature = new MemberFeature();
        memberFeature.setId("1");
        memberFeature.setEnumValue("[1,2]");
        memberFeature.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        memberFeature.setTypeCode("test");
        memberFeature.setTypeName("test");
        boolean isSucceed = this.memberFeatureCoreService.addMemberFeature(memberFeature);
        Assert.isTrue(isSucceed, "新增会员特征");
    }

    /**
     * 5.6.1.3. 编辑会员特征
     * @throws Exception
     */
    @Test
    public void testUpdateMemberFeature() throws Exception
    {
        MemberFeature memberFeature = new MemberFeature();
        memberFeature.setId("00017T80O8PMPDGP100003BJ43JB0010");
        memberFeature.setTypeName("test12");
        boolean isSucceed = this.memberFeatureCoreService.updateMemberFeature(memberFeature);
        Assert.isTrue(isSucceed, "编辑会员特征");
    }

    /**
     * 5.6.1.4. 删除会员特征
     * @throws Exception
     */
    @Test
    public void testDeleteMemberFeature() throws Exception
    {
        boolean isSucceed = this.memberFeatureCoreService.deleteMemberFeature("00017T80O8PMPDGP100003BJ43JB0010");
        Assert.isTrue(isSucceed, "删除会员特征");
    }

    /**
     * 编辑会员特征值
     * @throws Exception
     */
    @Test
    public void testUpdateMemberFeatureInfos() throws Exception
    {
        String shopId = "00017Q3EG198TUUV50000HFYOBYEH00F";
        String userId = "1";
        String phyNo = "000000110121222";
        String scardNo = "1";
        List<String> featureCodes = new ArrayList<String>();
        featureCodes.add("104");
        featureCodes.add("103");
        List<String> featureValues = new ArrayList<String>();
        featureValues.add("165");
        featureValues.add("65");
        boolean isSucceed = this.memberFeatureCoreService.updateMemberFeatureInfos(shopId, userId, phyNo, scardNo, featureCodes, featureValues);
        Assert.isTrue(isSucceed, "编辑会员特征值");
    }
}

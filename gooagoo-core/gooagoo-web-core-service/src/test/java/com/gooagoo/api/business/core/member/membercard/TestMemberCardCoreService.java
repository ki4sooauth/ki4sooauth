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

import com.gooagoo.entity.generator.member.MemberCard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestMemberCardCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MemberCardCoreService memberCardCoreService;

    @Override
    @Resource(name = "memberSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 5.3.2. 商家新增会员卡
     * @throws Exception
     */
    @Test
    public void testAddMemberCard() throws Exception
    {
        MemberCard memberCard = new MemberCard();
        memberCard.setCardId("1");
        memberCard.setCardLvl("0");//1,2
        memberCard.setCardType2("0");
        memberCard.setCardName("test11");
        memberCard.setCardUrl("");
        memberCard.setDescription("");
        memberCard.setNeedApproval("N");
        memberCard.setNeedJifen(100);
        memberCard.setShopId("1");//00017Q3EG198TUUV50000HFYOBYEH00F
        memberCard.setUseLimited(100);
        boolean isSucceed = this.memberCardCoreService.addMemberCard(memberCard);
        Assert.isTrue(isSucceed, "商家新增会员卡");
    }

    /**
     * 5.3.3. 商家编辑会员卡
     * @throws Exception
     */
    @Test
    public void testUpdateMemberCard() throws Exception
    {
        MemberCard memberCard = new MemberCard();
        memberCard.setCardId("00017QH0A4A9PQJ0L0007GEIISX8Q5TP");
        memberCard.setCardLvl("0");//1,2
        memberCard.setCardType2("0");
        memberCard.setCardName("test11");
        memberCard.setCardUrl("");
        memberCard.setDescription("");
        memberCard.setNeedApproval("N");
        memberCard.setNeedJifen(100);
        memberCard.setShopId("1");//00017Q3EG198TUUV50000HFYOBYEH00F
        memberCard.setUseLimited(100);
        boolean isSucceed = this.memberCardCoreService.updateMemberCard(memberCard);
        Assert.isTrue(isSucceed, "商家编辑会员卡");
    }

    /**
     * 5.3.4. 商家删除会员卡
     * @throws Exception
     */
    @Test
    public void testDeleteMemberCard() throws Exception
    {
        boolean isSucceed = this.memberCardCoreService.deleteMemberCard("33");
        Assert.isTrue(isSucceed, "商家编辑会员卡");
    }

}

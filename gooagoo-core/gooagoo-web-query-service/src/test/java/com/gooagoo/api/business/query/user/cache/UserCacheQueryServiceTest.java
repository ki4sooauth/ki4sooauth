package com.gooagoo.api.business.query.user.cache;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.marketing.rule.NaturalAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;

public class UserCacheQueryServiceTest
{
    private UserCacheQueryService service;

    @Before
    public void setUp() throws Exception
    {
        service = ApplicationContextUtils.getBean(UserCacheQueryService.class);
    }

    public void testFindUserIdByMac()
    {
        fail("Not yet implemented"); // TODO
    }

    public void testFindUserInfo()
    {
        fail("Not yet implemented"); // TODO
    }

    //@Test
    public void testGetUserPropertyRecord() throws Exception
    {
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        String accountType = "0";
        String account = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";
        PropertyRecord propertyRecord = service.getUserPropertyRecord(shopId, accountType, account);
        System.out.println(propertyRecord.getAccountBaseInfo().getAge());
    }

    @Test
    public void testGetUserAccountsList() throws Exception
    {
        String shopId = "185EVK63KPRTKH00A1BAQJMCA2H349CC";

        HistoryCondition condition = new HistoryCondition();
        condition.setNaturalAttribute(testNatural()); //自然属性
        //condition.getList().add(testBill());  //帐单
        //condition.getList().add(tools());
        List<Account> accounts = service.getUserAccountsList(shopId, condition);
        for (Account account : accounts)
        {
            System.out.print("type:" + account.getAccountType());
            System.out.println(" No:" + account.getAccountNo());
        }
    }

    private ActionAttribute tools()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("A");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        attribute.setServerTools("0182A2F2KFU9S6K02VLL3TEIISWR2TKG");
        attribute.setMarketingGoods("6920907809909");
        attribute.setMarketingGoodsBrand("18");
        attribute.setMarketingGoodsCategory("4");
        return attribute;
    }

    private ActionAttribute browse()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("9");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        attribute.setActionSource("W");
        //attribute.setMarketingCoupon("0182A30R0LHP8DK02VLL3UEIISWR2TKG");
        //attribute.setMarketingActivity("0182AIEG0LNI34H0NCQU1KEIISWR2HCH");
        //attribute.setMarketingGoods("203004");
        attribute.setMarketingGoodsBrand("0017QBOSKOLFIJM500004SXUXJ1T001");
        //attribute.setMarketingGoodsCategory("444444");
        return attribute;
    }

    private ActionAttribute favorite()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("8");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        attribute.setActionSource("W");
        attribute.setMarketingCoupon("0182A30R0LHP8DK02VLL3UEIISWR2TKG");
        //attribute.setMarketingActivity("0182AIEG0LNI34H0NCQU1KEIISWR2HCH");
        //attribute.setMarketingGoods("203004");
        //attribute.setMarketingGoodsBrand("0017QBOSKOLFIJM500004SXUXJ1T001");
        //attribute.setMarketingGoodsCategory("444444");
        return attribute;
    }

    private ActionAttribute comment()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("6");

        attribute.setRelation("N");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        attribute.setActionSource("W");
        attribute.setMarketingGoods("112");
        return attribute;
    }

    private ActionAttribute applyPhy()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("5");

        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        //attribute.setTotalTimeMin(1);
        return attribute;
    }

    private ActionAttribute applyMember()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("4");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-31");
        //attribute.setTotalTimeMin(1);
        return attribute;
    }

    private ActionAttribute attention()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("3");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-30");
        //attribute.setTotalTimeMin(1);
        return attribute;
    }

    private ActionAttribute shop()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setPosition("1834LJ7RC4CV7P2G8PELDKNPHI688CUF");
        attribute.setActionType("1");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-30");
        //attribute.setTotalTimeMin(1);
        return attribute;
    }

    private ActionAttribute area()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setPosition("1834LJ7RC4CV7P2G8PELDKNPHI688CUF");
        attribute.setActionType("2");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-30");
        attribute.setTotalTimeMin(1);
        return attribute;
    }

    private ActionAttribute testBill()
    {
        ActionAttribute attribute = new ActionAttribute();
        attribute.setActionType("0");
        attribute.setDateStart("2013-08-27");
        attribute.setDateEnd("2013-08-30");
        attribute.setConsumeMoneyMin(90.0);
        attribute.setConsumeMoneyMax(100.0);
        attribute.setActionSource("M");
        attribute.setMarketingGoodsBrand("0001");
        attribute.setMarketingGoodsCategory("1");
        attribute.setTotalTimeMin(1);
        attribute.setMarketingCoupon("0182CLGDSLCTGFG00GKO30J4VOR9U4DC");
        return attribute;
    }

    private NaturalAttribute testNatural()
    {
        NaturalAttribute naturalAttribute = new NaturalAttribute();
        //naturalAttribute.setAccount("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        //naturalAttribute.setAccountType("0");
        /*naturalAttribute.setAgeStart(20);
        naturalAttribute.setAgeEnd(40);
        naturalAttribute.setBirthdayStart("07-26");
        naturalAttribute.setBirthdayEnd("07-29");
        naturalAttribute.setGrade("0182A8E3FD223I30I3TDLVEIISWR2GDJ,0182A8E3FD223I30I3TDLVEIISWR2GDG");

        MemberFeature feature = new MemberFeature();
        feature.setTypeCode("XL");
        feature.setEnumValue("本科");
        naturalAttribute.getMemberFeatureList().add(feature);*/
        return naturalAttribute;
    }

    public void testGetUserActionRecords() throws Exception
    {
        fail("Not yet implemented"); // TODO
    }

    public void testCountUserActionRecords()
    {
        fail("Not yet implemented"); // TODO
    }

}

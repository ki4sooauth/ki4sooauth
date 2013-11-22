package com.googoo.batch.dispatcher.cache.userShopSub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.entity.generator.member.MemberOfCard;

public class ForMyShopTest
{
    ForMyShop forMyShop = new ForMyShop();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testMessage()
    {
        List<MemberOfCard> members = new ArrayList<MemberOfCard>();
        MemberOfCard moc = new MemberOfCard();
        moc.setScardno("1000000000000210");
        moc.setPhyCardNo("1000000000000210");
        moc.setCardId("0182A8E3FD223I30I3TDLVEIISWR2GDJ");
        moc.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        moc.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        moc.setCardType2("1");
        moc.setIsDel("N");
        members.add(moc);
        forMyShop.message(members);
    }

}

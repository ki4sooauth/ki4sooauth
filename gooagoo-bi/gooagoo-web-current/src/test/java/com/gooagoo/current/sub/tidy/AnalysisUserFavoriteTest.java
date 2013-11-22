package com.gooagoo.current.sub.tidy;

import java.util.Date;

import org.junit.Before;

import com.gooagoo.entity.business.log.BehaveLog;

public class AnalysisUserFavoriteTest
{
    AnalysisUserFavorite analysisUserFavorite = new AnalysisUserFavorite();

    @Before
    public void setUp() throws Exception
    {
    }

    //@Test
    public void test()
    {
        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setCreateTime(new Date());
        behaveLog.setSource("W");
        //goods(behaveLog);
        //acitve(behaveLog);
        //coupon(behaveLog);
        analysisUserFavorite.message(behaveLog);
    }

    private void coupon(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm04");
        behaveLog.setObjectValue("0182A30R0LHP8DK02VLL3UEIISWR2TKG");
    }

    private void acitve(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm02");
        behaveLog.setObjectValue("0182AIEG0LNI34H0NCQU1KEIISWR2HCH");
    }

    private void goods(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm07");
        behaveLog.setObjectValue("0182AIJC5E0MJMO0NCQU1OEIISWR2HCH");
    }

}

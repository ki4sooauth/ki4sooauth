package com.gooagoo.current.sub.tidy;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.entity.business.log.BehaveLog;

public class BrowseActiveForAccountTest
{
    BrowseActiveForAccount browseActiveForAccount = new BrowseActiveForAccount();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822R97QK2FRDT085QBV2EIISWR0JGT");
        behaveLog.setObjectValue("0182AIEG0LNI34H0NCQU1KEIISWR2HCH"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("018237FSEHNVTOI005B2D4J4VOR9U6KK");
        behaveLog.setRemoteCode("gusm02");
        browseActiveForAccount.message(behaveLog);
    }

}

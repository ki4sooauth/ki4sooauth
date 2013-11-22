package com.gooagoo.current.sub.tidy;

import org.junit.Before;

import com.gooagoo.entity.business.log.BehaveLog;

public class AnalysisAttentionTest
{
    AnalysisAttention attention = new AnalysisAttention();

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
        behaveLog.setSource("M");
        attention.message(behaveLog);
    }

}

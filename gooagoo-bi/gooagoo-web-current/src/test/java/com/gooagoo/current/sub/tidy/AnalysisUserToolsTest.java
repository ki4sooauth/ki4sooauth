package com.gooagoo.current.sub.tidy;

import java.util.Date;

import org.junit.Before;

import com.gooagoo.entity.business.log.BehaveLog;

public class AnalysisUserToolsTest
{
    AnalysisUserTools analysisUserTools = new AnalysisUserTools();

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
        behaveLog.setObjectValue("0182A2F2KFU9S6K02VLL3TEIISWR2TKG");
        behaveLog.setDetail("{[\"018236S9FMAGOO202VLL3IEIISWR2TKG\",\"018237A6NN9JUJN02VLL3JEIISWR2TKG\"]}");
        analysisUserTools.message(behaveLog);
    }
}

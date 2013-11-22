package com.gooagoo.current.sub.tidy;

import java.util.Date;

import org.junit.Before;

import com.gooagoo.entity.business.log.BehaveLog;

public class AnalysisApplyPhysicsTest
{
    AnalysisApplyPhysics apply = new AnalysisApplyPhysics();

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
        behaveLog.setObjectValue("1000000000000210");
        apply.message(behaveLog);
    }

}

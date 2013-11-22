package com.gooagoo.current.sub.tidy;

import java.util.Date;

import org.junit.Before;

import com.gooagoo.entity.business.log.BehaveLog;

public class AnalysisUserCommentTest
{
    AnalysisUserComment analysisUserComment = new AnalysisUserComment();

    @Before
    public void setUp() throws Exception
    {
    }

    //@Test
    public void test()
    {
        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setCreateTime(new Date());
        behaveLog.setSource("W");
        behaveLog.setObjectValue("01822TIHISRNTBT07GRNHGEIISWR2K8D");
        analysisUserComment.message(behaveLog);
    }

}

package com.gooagoo.current.sub.tidy;

import org.junit.Before;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.bi.entity.position.Leave;

public class LeaveAreaTest
{
    LeaveArea leaveArea = new LeaveArea();

    @Before
    public void setUp() throws Exception
    {
    }

    //@Test
    public void test()
    {
        BehaviorAreaChange behavior = new BehaviorAreaChange();
        behavior.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behavior.setMacAddress("50:46:5D:56:D2:F9");

        Leave leave = new Leave();
        leave.setId("1834LJ7RC4CV7P2G8PELDKNPHI688CUF");
        leave.setStart(1377767563947L); //开始时间戳
        leave.setEnd(1387767563947L); //结束时间戳
        leave.setDuration(3); //时长(分钟)
        behavior.getOldArea().add(leave);
        behavior.getNewArea().add("1834LA0J6NRJHC2G8PELDKNPUB1IKM85");
        leaveArea.message(behavior);
    }

}

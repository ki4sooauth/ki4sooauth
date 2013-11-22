package com.gooagoo.current.sub.tidy;

import org.junit.Before;

import com.gooagoo.bi.entity.position.BehaviorLeaveShop;

public class LeaveShopTest
{
    LeaveShop leaveShop = new LeaveShop();

    @Before
    public void setUp() throws Exception
    {
    }

    //@Test
    public void test()
    {
        BehaviorLeaveShop behavior = new BehaviorLeaveShop();
        behavior.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behavior.setMacAddress("50:46:5D:56:D2:F9");
        behavior.setStart(1377767563947L);
        behavior.setEnd(1387767563947L);
        behavior.setDuration(1200);
        behavior.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        behavior.setEntityId("01822IE57DH111M085QBPFEIISWR0JGT");
        leaveShop.message(behavior);
    }
}

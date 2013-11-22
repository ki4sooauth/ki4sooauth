package com.gooagoo.current.sub.position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.bi.entity.position.BehaviorLeaveShop;

public class LeaveShopTest
{
    LeaveShop leaveShop = new LeaveShop();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
    }

    @After
    public void after()
    {
        BehaviorLeaveShop message = new BehaviorLeaveShop();
        leaveShop.message(message);
    }
}

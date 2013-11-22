package com.gooagoo.current.sub.position;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.bi.entity.position.Leave;

public class MacAreaTest
{
    MacArea macArea = new MacArea();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        BehaviorAreaChange position = new BehaviorAreaChange();
        position.setMacAddress("08:00:27:00:60:9c");
        position.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        position.setMember(true);
        position.getNewArea().add("183M35CJVN1LA82G8TELDKNPHI5VKCUF");
        position.getNewArea().add("183M35TH2N379Q2G8TELDKNPHI5D4CUF");
        position.getNewArea().add("183M36UQ8HVKTV2G8TELDKNPHJ3LGCUG");

        Leave leave = new Leave();
        leave.setId("183M36AKMSPS3M2G8TELDKNPHI4EKCUF");
        leave.setStart(1378368863941L); //开始时间戳
        leave.setEnd(1378368873941L); //结束时间戳
        leave.setDuration(1); //时长(分钟)
        position.getOldArea().add(leave);
        macArea.message(position);
    }

}

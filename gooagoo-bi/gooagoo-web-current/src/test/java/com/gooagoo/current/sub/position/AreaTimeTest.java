package com.gooagoo.current.sub.position;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;

public class AreaTimeTest
{
    AreaTime areaTime = new AreaTime();

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
        position.getNewArea().add("183M36AKMSPS3M2G8TELDKNPHI4EKCUF");
        position.getNewArea().add("183M36UQ8HVKTV2G8TELDKNPHJ3LGCUG");
        areaTime.message(position);
    }

}

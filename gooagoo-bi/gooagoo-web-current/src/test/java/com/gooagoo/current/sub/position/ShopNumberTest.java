package com.gooagoo.current.sub.position;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.bi.entity.position.BehaviorGeneral;

public class ShopNumberTest
{
    ShopNumber shopNumber = new ShopNumber();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        BehaviorGeneral position = new BehaviorGeneral();
        position.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        position.setEntityId("01822IE57DH111M085QBPFEIISWR0JGT");
        position.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        position.setMacAddress("08:00:27:00:60:9c");
        position.setMember(true);
        shopNumber.message(position);
    }

}

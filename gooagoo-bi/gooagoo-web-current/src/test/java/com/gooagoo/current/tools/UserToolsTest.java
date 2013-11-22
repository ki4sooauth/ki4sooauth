package com.gooagoo.current.tools;

import org.junit.Before;
import org.junit.Test;

public class UserToolsTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        boolean b = UserTools.isMember("01822N0IJLPA8N700C5V4PBJ43P1R6JA", "01822R97QK2FRDT085QBV2EIISWR0JGT");
        System.out.println(b);
    }
}

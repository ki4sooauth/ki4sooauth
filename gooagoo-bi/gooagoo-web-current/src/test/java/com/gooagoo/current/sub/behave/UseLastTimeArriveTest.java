package com.gooagoo.current.sub.behave;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.current.utils.SendMessageUtil;

public class UseLastTimeArriveTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();

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
        sendMessageUtil.close();
    }
}

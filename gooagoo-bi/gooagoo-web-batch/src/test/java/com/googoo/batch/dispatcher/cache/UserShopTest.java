package com.googoo.batch.dispatcher.cache;

import org.junit.Before;
import org.junit.Test;

public class UserShopTest
{
    UserShop userShop = new UserShop();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        userShop.run();
    }

}

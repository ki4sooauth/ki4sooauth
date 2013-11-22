package com.googoo.batch.dispatcher.everyMinutes;

import org.junit.Before;
import org.junit.Test;

public class NowInShopTest
{
    NowInShop nowInShop = new NowInShop();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        nowInShop.run();
    }

}

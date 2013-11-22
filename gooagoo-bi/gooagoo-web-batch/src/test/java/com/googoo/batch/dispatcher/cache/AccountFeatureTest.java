package com.googoo.batch.dispatcher.cache;

import org.junit.Before;
import org.junit.Test;


public class AccountFeatureTest
{
    AccountFeature feature = new AccountFeature();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        feature.run();
    }

}

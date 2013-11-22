package com.googoo.batch.dispatcher.analysis;

import org.junit.Test;

public class UserInfoGroupByAgeRangeTest
{

    @Test
    public void testRun()
    {
        UserInfoGroupByAgeRange batch = new UserInfoGroupByAgeRange();
        batch.run();
    }

}

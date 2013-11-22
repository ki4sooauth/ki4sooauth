package com.gooagoo.query.business.statistics;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class InteractiveQueryServiceImplTest
{
    InteractiveQueryService service = ApplicationContextUtils.getBean(InteractiveQueryService.class);

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        int num = service.findWebInterPeopleNum("01822IAKR5SKU02085QBP2EIISWR0JGT", "D", "N", new Date());
        System.out.println(num);
    }

}

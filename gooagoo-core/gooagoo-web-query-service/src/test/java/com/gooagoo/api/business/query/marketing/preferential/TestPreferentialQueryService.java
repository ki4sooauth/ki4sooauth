package com.gooagoo.api.business.query.marketing.preferential;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestPreferentialQueryService
{

    public PreferentialQueryService preferentialQueryService;

    @Before
    public void testBefore()
    {
        this.preferentialQueryService = ApplicationContextUtils.getBean(PreferentialQueryService.class);
    }

    /**
     * 品类优惠查询
     * @throws Exception
     */
    @Test
    public void testCategoryPreferential() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

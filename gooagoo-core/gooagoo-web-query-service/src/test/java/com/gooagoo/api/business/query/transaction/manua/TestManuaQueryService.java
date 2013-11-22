package com.gooagoo.api.business.query.transaction.manua;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestManuaQueryService
{

    public ManuaQueryService manuaQueryService;

    @Before
    public void testBefore()
    {
        this.manuaQueryService = ApplicationContextUtils.getBean(ManuaQueryService.class);
    }

    /**
     * 4.3.9. 手工账单列表（分页）
     * @throws Exception
     */
    @Test
    public void testFindBillManualList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

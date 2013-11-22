package com.gooagoo.api.business.query.marketing.analysis;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestNewGoodsQueryService
{

    public NewGoodsQueryService newGoodsQueryService;

    @Before
    public void testBefore()
    {
        this.newGoodsQueryService = ApplicationContextUtils.getBean(NewGoodsQueryService.class);
    }

    /**
     * 最新上架（分页，根据个人定制）redis
     * @throws Exception
     */
    @Test
    public void testNewGoods() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

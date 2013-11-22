package com.gooagoo.api.business.query.marketing.analysis;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestAnalysisTypeService
{

    public AnalysisTypeService analysisTypeService;

    @Before
    public void testBefore()
    {
        this.analysisTypeService = ApplicationContextUtils.getBean(AnalysisTypeService.class);
    }

    /**
     * 获取指定商家的统计类型列表
     * @throws Exception
     */
    @Test
    public void testGetAnalysisTypeList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}

package com.gooagoo.api.business.query.system.cms;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.exception.common.NullException;

public class TestSysCmsContentQueryService
{

    public SysCmsContentQueryService sysCmsContentQueryService;

    @Before
    public void testBefore()
    {
        this.sysCmsContentQueryService = ApplicationContextUtils.getBean(SysCmsContentQueryService.class);
    }

    /**
     * 获取手机虚拟商家、网站虚拟商家访问路径
     * @throws NullException
     */
    @Test
    public void testGetCmsContentUrl() throws Exception
    {
        String shopId = "01822R97QK2FRDT085QBV2EIISWR0JGT";
        String channelType = "M";
        String cmsContentUrl = this.sysCmsContentQueryService.getCmsContentUrl(shopId, channelType);
        Assert.assertNotNull("获取手机虚拟商家、网站虚拟商家访问路径失败", cmsContentUrl);
    }
}

package com.gooagoo.api.business.query.system.channel;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.google.gson.Gson;

public class TestMarketingChannelQueryService
{

    public MarketingChannelQueryService marketingChannelQueryService;

    @Before
    public void testBefore()
    {
        this.marketingChannelQueryService = ApplicationContextUtils.getBean(MarketingChannelQueryService.class);
    }

    /**
     * 根据父类查询所有子类渠道列表
     * @throws Exception
     */
    @Test
    public void testFindMarketingChannelListByParent() throws Exception
    {
        List<MarketingChannel> list = this.marketingChannelQueryService.findMarketingChannelListByParent("-1");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("根据父类查询所有子类渠道列表", list);
    }

}

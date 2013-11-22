package com.gooagoo.query.business.system.channel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.system.channel.MarketingChannelQueryService;
import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;

@Service
public class MarketingChannelQueryServiceImpl implements MarketingChannelQueryService
{
    @Autowired
    private MarketingChannelGeneratorQueryService marketingChannelGeneratorQueryService;

    @Override
    public List<MarketingChannel> findMarketingChannelListByParent(String parentId) throws Exception
    {
        List<MarketingChannel> list = new ArrayList<MarketingChannel>();
        this.treeMarketingChannel(list, parentId);
        return list;
    }

    /**
     * 通过父节点迭代查询子节点,并将子节点添加到集合中
     * @param marketingChannelList
     * @param parentId
     */
    private void treeMarketingChannel(List<MarketingChannel> marketingChannelList, String parentId)
    {
        if (!StringUtils.hasText(parentId))
        {
            return;
        }
        MarketingChannelExample marketingChannelExample = new MarketingChannelExample();
        marketingChannelExample.createCriteria().andIsDelEqualTo("N").andParentChannelCodeEqualTo(parentId);
        List<MarketingChannel> list = this.marketingChannelGeneratorQueryService.selectByExample(marketingChannelExample);
        if (list == null)
        {
            return;
        }
        for (Iterator<MarketingChannel> iterator = list.iterator(); iterator.hasNext();)
        {
            MarketingChannel marketingChannel = iterator.next();
            marketingChannelList.add(marketingChannel);
            this.treeMarketingChannel(marketingChannelList, marketingChannel.getChannelCode() + "");
        }
    }

}

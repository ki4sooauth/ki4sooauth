package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelKey;
import com.gooagoo.dao.generator.base.MarketingChannelMapper;

@Service
public class MarketingChannelGeneratorQueryServiceImpl implements MarketingChannelGeneratorQueryService
{

    @Autowired
    private MarketingChannelMapper marketingChannelMapper;

    @Override
    public Integer countByExample(MarketingChannelExample marketingChannelExample) 
    {
        return this.marketingChannelMapper.countByExample(marketingChannelExample);
    }

    @Override
    public List<MarketingChannel> selectByExample(MarketingChannelExample marketingChannelExample) 
    {
        return this.marketingChannelMapper.selectByExample(marketingChannelExample);
    }

    @Override
    public MarketingChannel selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        MarketingChannelKey marketingChannelKey = new MarketingChannelKey();
        marketingChannelKey.setIsDel("N");
        marketingChannelKey.setChannelCode(primaryKey);
        return this.marketingChannelMapper.selectByPrimaryKey(marketingChannelKey);
    }

    @Override
    public MarketingChannel selectByPrimaryKey(Integer primaryKey) 
    {
        MarketingChannelKey marketingChannelKey = new MarketingChannelKey();
        marketingChannelKey.setChannelCode(primaryKey);
        return this.marketingChannelMapper.selectByPrimaryKey(marketingChannelKey);
    }

}

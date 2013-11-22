package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.MarketingChannelGeneratorCoreService;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelKey;
import com.gooagoo.dao.generator.base.MarketingChannelMapper;

@Service
public class MarketingChannelGeneratorCoreServiceImpl implements MarketingChannelGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MarketingChannelExample marketingChannelExample) 
    {
        return this.marketingChannelMapper.deleteByExample(marketingChannelExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        MarketingChannelKey marketingChannelKey = new MarketingChannelKey();
        marketingChannelKey.setChannelCode(primaryKey);
        return this.marketingChannelMapper.deleteByPrimaryKey(marketingChannelKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingChannelExample marketingChannelExample) 
    {
        MarketingChannel marketingChannel = new MarketingChannel();
        marketingChannel.setIsDel("Y");
        return this.marketingChannelMapper.updateByExampleSelective(marketingChannel,marketingChannelExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        MarketingChannel marketingChannel = new MarketingChannel();
        marketingChannel.setChannelCode(primaryKey);
        marketingChannel.setIsDel("Y");
        return this.marketingChannelMapper.updateByPrimaryKeySelective(marketingChannel) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingChannel marketingChannel) 
    {
        return this.marketingChannelMapper.insertSelective(marketingChannel) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingChannel marketingChannel,MarketingChannelExample marketingChannelExample) 
    {
        return this.marketingChannelMapper.updateByExampleSelective(marketingChannel,marketingChannelExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingChannel marketingChannel) 
    {
        return this.marketingChannelMapper.updateByPrimaryKeySelective(marketingChannel) > 0 ? true : false;
    }

}

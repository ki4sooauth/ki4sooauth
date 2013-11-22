package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingItemLinkGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkKey;
import com.gooagoo.dao.generator.marketing.MarketingItemLinkMapper;

@Service
public class MarketingItemLinkGeneratorQueryServiceImpl implements MarketingItemLinkGeneratorQueryService
{

    @Autowired
    private MarketingItemLinkMapper marketingItemLinkMapper;

    @Override
    public Integer countByExample(MarketingItemLinkExample marketingItemLinkExample) 
    {
        return this.marketingItemLinkMapper.countByExample(marketingItemLinkExample);
    }

    @Override
    public List<MarketingItemLink> selectByExample(MarketingItemLinkExample marketingItemLinkExample) 
    {
        return this.marketingItemLinkMapper.selectByExample(marketingItemLinkExample);
    }

    @Override
    public MarketingItemLink selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingItemLinkKey marketingItemLinkKey = new MarketingItemLinkKey();
        marketingItemLinkKey.setIsDel("N");
        marketingItemLinkKey.setId(primaryKey);
        return this.marketingItemLinkMapper.selectByPrimaryKey(marketingItemLinkKey);
    }

    @Override
    public MarketingItemLink selectByPrimaryKey(String primaryKey) 
    {
        MarketingItemLinkKey marketingItemLinkKey = new MarketingItemLinkKey();
        marketingItemLinkKey.setId(primaryKey);
        return this.marketingItemLinkMapper.selectByPrimaryKey(marketingItemLinkKey);
    }

}

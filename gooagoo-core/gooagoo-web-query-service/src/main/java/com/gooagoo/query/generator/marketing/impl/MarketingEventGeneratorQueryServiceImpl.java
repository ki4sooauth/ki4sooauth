package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingEventKey;
import com.gooagoo.dao.generator.marketing.MarketingEventMapper;

@Service
public class MarketingEventGeneratorQueryServiceImpl implements MarketingEventGeneratorQueryService
{

    @Autowired
    private MarketingEventMapper marketingEventMapper;

    @Override
    public Integer countByExample(MarketingEventExample marketingEventExample) 
    {
        return this.marketingEventMapper.countByExample(marketingEventExample);
    }

    @Override
    public List<MarketingEvent> selectByExample(MarketingEventExample marketingEventExample) 
    {
        return this.marketingEventMapper.selectByExample(marketingEventExample);
    }

    @Override
    public MarketingEvent selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingEventKey marketingEventKey = new MarketingEventKey();
        marketingEventKey.setIsDel("N");
        marketingEventKey.setEventId(primaryKey);
        return this.marketingEventMapper.selectByPrimaryKey(marketingEventKey);
    }

    @Override
    public MarketingEvent selectByPrimaryKey(String primaryKey) 
    {
        MarketingEventKey marketingEventKey = new MarketingEventKey();
        marketingEventKey.setEventId(primaryKey);
        return this.marketingEventMapper.selectByPrimaryKey(marketingEventKey);
    }

}

package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingEventGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingEventKey;
import com.gooagoo.dao.generator.marketing.MarketingEventMapper;

@Service
public class MarketingEventGeneratorCoreServiceImpl implements MarketingEventGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MarketingEventExample marketingEventExample) 
    {
        return this.marketingEventMapper.deleteByExample(marketingEventExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingEventKey marketingEventKey = new MarketingEventKey();
        marketingEventKey.setEventId(primaryKey);
        return this.marketingEventMapper.deleteByPrimaryKey(marketingEventKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingEventExample marketingEventExample) 
    {
        MarketingEvent marketingEvent = new MarketingEvent();
        marketingEvent.setIsDel("Y");
        return this.marketingEventMapper.updateByExampleSelective(marketingEvent,marketingEventExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingEvent marketingEvent = new MarketingEvent();
        marketingEvent.setEventId(primaryKey);
        marketingEvent.setIsDel("Y");
        return this.marketingEventMapper.updateByPrimaryKeySelective(marketingEvent) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingEvent marketingEvent) 
    {
        return this.marketingEventMapper.insertSelective(marketingEvent) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingEvent marketingEvent,MarketingEventExample marketingEventExample) 
    {
        return this.marketingEventMapper.updateByExampleSelective(marketingEvent,marketingEventExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingEvent marketingEvent) 
    {
        return this.marketingEventMapper.updateByPrimaryKeySelective(marketingEvent) > 0 ? true : false;
    }

}

package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingItemLinkGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkKey;
import com.gooagoo.dao.generator.marketing.MarketingItemLinkMapper;

@Service
public class MarketingItemLinkGeneratorCoreServiceImpl implements MarketingItemLinkGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MarketingItemLinkExample marketingItemLinkExample) 
    {
        return this.marketingItemLinkMapper.deleteByExample(marketingItemLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingItemLinkKey marketingItemLinkKey = new MarketingItemLinkKey();
        marketingItemLinkKey.setId(primaryKey);
        return this.marketingItemLinkMapper.deleteByPrimaryKey(marketingItemLinkKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingItemLinkExample marketingItemLinkExample) 
    {
        MarketingItemLink marketingItemLink = new MarketingItemLink();
        marketingItemLink.setIsDel("Y");
        return this.marketingItemLinkMapper.updateByExampleSelective(marketingItemLink,marketingItemLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingItemLink marketingItemLink = new MarketingItemLink();
        marketingItemLink.setId(primaryKey);
        marketingItemLink.setIsDel("Y");
        return this.marketingItemLinkMapper.updateByPrimaryKeySelective(marketingItemLink) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingItemLink marketingItemLink) 
    {
        return this.marketingItemLinkMapper.insertSelective(marketingItemLink) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingItemLink marketingItemLink,MarketingItemLinkExample marketingItemLinkExample) 
    {
        return this.marketingItemLinkMapper.updateByExampleSelective(marketingItemLink,marketingItemLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingItemLink marketingItemLink) 
    {
        return this.marketingItemLinkMapper.updateByPrimaryKeySelective(marketingItemLink) > 0 ? true : false;
    }

}

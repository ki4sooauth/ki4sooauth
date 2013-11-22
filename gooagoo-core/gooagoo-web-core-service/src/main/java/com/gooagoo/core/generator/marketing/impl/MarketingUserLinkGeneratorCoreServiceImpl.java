package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkKey;
import com.gooagoo.dao.generator.marketing.MarketingUserLinkMapper;

@Service
public class MarketingUserLinkGeneratorCoreServiceImpl implements MarketingUserLinkGeneratorCoreService
{

    @Autowired
    private MarketingUserLinkMapper marketingUserLinkMapper;

    @Override
    public Integer countByExample(MarketingUserLinkExample marketingUserLinkExample) 
    {
        return this.marketingUserLinkMapper.countByExample(marketingUserLinkExample);
    }

    @Override
    public List<MarketingUserLink> selectByExample(MarketingUserLinkExample marketingUserLinkExample) 
    {
        return this.marketingUserLinkMapper.selectByExample(marketingUserLinkExample);
    }

    @Override
    public MarketingUserLink selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingUserLinkKey marketingUserLinkKey = new MarketingUserLinkKey();
        marketingUserLinkKey.setIsDel("N");
        marketingUserLinkKey.setId(primaryKey);
        return this.marketingUserLinkMapper.selectByPrimaryKey(marketingUserLinkKey);
    }

    @Override
    public MarketingUserLink selectByPrimaryKey(String primaryKey) 
    {
        MarketingUserLinkKey marketingUserLinkKey = new MarketingUserLinkKey();
        marketingUserLinkKey.setId(primaryKey);
        return this.marketingUserLinkMapper.selectByPrimaryKey(marketingUserLinkKey);
    }

    @Override
    public boolean physicalDeleteByExample(MarketingUserLinkExample marketingUserLinkExample) 
    {
        return this.marketingUserLinkMapper.deleteByExample(marketingUserLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingUserLinkKey marketingUserLinkKey = new MarketingUserLinkKey();
        marketingUserLinkKey.setId(primaryKey);
        return this.marketingUserLinkMapper.deleteByPrimaryKey(marketingUserLinkKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingUserLinkExample marketingUserLinkExample) 
    {
        MarketingUserLink marketingUserLink = new MarketingUserLink();
        marketingUserLink.setIsDel("Y");
        return this.marketingUserLinkMapper.updateByExampleSelective(marketingUserLink,marketingUserLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingUserLink marketingUserLink = new MarketingUserLink();
        marketingUserLink.setId(primaryKey);
        marketingUserLink.setIsDel("Y");
        return this.marketingUserLinkMapper.updateByPrimaryKeySelective(marketingUserLink) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingUserLink marketingUserLink) 
    {
        return this.marketingUserLinkMapper.insertSelective(marketingUserLink) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingUserLink marketingUserLink,MarketingUserLinkExample marketingUserLinkExample) 
    {
        return this.marketingUserLinkMapper.updateByExampleSelective(marketingUserLink,marketingUserLinkExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingUserLink marketingUserLink) 
    {
        return this.marketingUserLinkMapper.updateByPrimaryKeySelective(marketingUserLink) > 0 ? true : false;
    }

}

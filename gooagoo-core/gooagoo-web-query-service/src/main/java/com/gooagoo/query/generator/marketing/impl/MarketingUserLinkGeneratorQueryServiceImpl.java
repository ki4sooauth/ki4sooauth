package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkKey;
import com.gooagoo.dao.generator.marketing.MarketingUserLinkMapper;

@Service
public class MarketingUserLinkGeneratorQueryServiceImpl implements MarketingUserLinkGeneratorQueryService
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

}

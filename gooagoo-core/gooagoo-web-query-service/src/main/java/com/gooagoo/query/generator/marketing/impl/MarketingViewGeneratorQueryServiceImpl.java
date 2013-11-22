package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingViewGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.MarketingViewKey;
import com.gooagoo.dao.generator.marketing.MarketingViewMapper;

@Service
public class MarketingViewGeneratorQueryServiceImpl implements MarketingViewGeneratorQueryService
{

    @Autowired
    private MarketingViewMapper marketingViewMapper;

    @Override
    public Integer countByExample(MarketingViewExample marketingViewExample) 
    {
        return this.marketingViewMapper.countByExample(marketingViewExample);
    }

    @Override
    public List<MarketingView> selectByExample(MarketingViewExample marketingViewExample) 
    {
        return this.marketingViewMapper.selectByExample(marketingViewExample);
    }

    @Override
    public MarketingView selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingViewKey marketingViewKey = new MarketingViewKey();
        marketingViewKey.setIsDel("N");
        marketingViewKey.setId(primaryKey);
        return this.marketingViewMapper.selectByPrimaryKey(marketingViewKey);
    }

    @Override
    public MarketingView selectByPrimaryKey(String primaryKey) 
    {
        MarketingViewKey marketingViewKey = new MarketingViewKey();
        marketingViewKey.setId(primaryKey);
        return this.marketingViewMapper.selectByPrimaryKey(marketingViewKey);
    }

}

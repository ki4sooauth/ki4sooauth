package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityKey;
import com.gooagoo.dao.generator.marketing.MarketingActivityMapper;

@Service
public class MarketingActivityGeneratorQueryServiceImpl implements MarketingActivityGeneratorQueryService
{

    @Autowired
    private MarketingActivityMapper marketingActivityMapper;

    @Override
    public Integer countByExample(MarketingActivityExample marketingActivityExample) 
    {
        return this.marketingActivityMapper.countByExample(marketingActivityExample);
    }

    @Override
    public List<MarketingActivity> selectByExample(MarketingActivityExample marketingActivityExample) 
    {
        return this.marketingActivityMapper.selectByExample(marketingActivityExample);
    }

    @Override
    public MarketingActivity selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingActivityKey marketingActivityKey = new MarketingActivityKey();
        marketingActivityKey.setIsDel("N");
        marketingActivityKey.setActivityId(primaryKey);
        return this.marketingActivityMapper.selectByPrimaryKey(marketingActivityKey);
    }

    @Override
    public MarketingActivity selectByPrimaryKey(String primaryKey) 
    {
        MarketingActivityKey marketingActivityKey = new MarketingActivityKey();
        marketingActivityKey.setActivityId(primaryKey);
        return this.marketingActivityMapper.selectByPrimaryKey(marketingActivityKey);
    }

}

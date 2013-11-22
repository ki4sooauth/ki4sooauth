package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingActivityGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityKey;
import com.gooagoo.dao.generator.marketing.MarketingActivityMapper;

@Service
public class MarketingActivityGeneratorCoreServiceImpl implements MarketingActivityGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MarketingActivityExample marketingActivityExample) 
    {
        return this.marketingActivityMapper.deleteByExample(marketingActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingActivityKey marketingActivityKey = new MarketingActivityKey();
        marketingActivityKey.setActivityId(primaryKey);
        return this.marketingActivityMapper.deleteByPrimaryKey(marketingActivityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingActivityExample marketingActivityExample) 
    {
        MarketingActivity marketingActivity = new MarketingActivity();
        marketingActivity.setIsDel("Y");
        return this.marketingActivityMapper.updateByExampleSelective(marketingActivity,marketingActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingActivity marketingActivity = new MarketingActivity();
        marketingActivity.setActivityId(primaryKey);
        marketingActivity.setIsDel("Y");
        return this.marketingActivityMapper.updateByPrimaryKeySelective(marketingActivity) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingActivity marketingActivity) 
    {
        return this.marketingActivityMapper.insertSelective(marketingActivity) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingActivity marketingActivity,MarketingActivityExample marketingActivityExample) 
    {
        return this.marketingActivityMapper.updateByExampleSelective(marketingActivity,marketingActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingActivity marketingActivity) 
    {
        return this.marketingActivityMapper.updateByPrimaryKeySelective(marketingActivity) > 0 ? true : false;
    }

}

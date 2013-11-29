package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingViewGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.MarketingViewKey;
import com.gooagoo.dao.generator.marketing.MarketingViewMapper;

@Service
public class MarketingViewGeneratorCoreServiceImpl implements MarketingViewGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MarketingViewExample marketingViewExample) 
    {
        return this.marketingViewMapper.deleteByExample(marketingViewExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingViewKey marketingViewKey = new MarketingViewKey();
        marketingViewKey.setId(primaryKey);
        return this.marketingViewMapper.deleteByPrimaryKey(marketingViewKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingViewExample marketingViewExample) 
    {
        MarketingView marketingView = new MarketingView();
        marketingView.setIsDel("Y");
        return this.marketingViewMapper.updateByExampleSelective(marketingView,marketingViewExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingView marketingView = new MarketingView();
        marketingView.setId(primaryKey);
        marketingView.setIsDel("Y");
        return this.marketingViewMapper.updateByPrimaryKeySelective(marketingView) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingView marketingView) 
    {
        return this.marketingViewMapper.insertSelective(marketingView) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingView marketingView,MarketingViewExample marketingViewExample) 
    {
        return this.marketingViewMapper.updateByExampleSelective(marketingView,marketingViewExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingView marketingView) 
    {
        return this.marketingViewMapper.updateByPrimaryKeySelective(marketingView) > 0 ? true : false;
    }

}

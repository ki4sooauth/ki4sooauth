package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingQualityGoodsGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsKey;
import com.gooagoo.dao.generator.marketing.MarketingQualityGoodsMapper;

@Service
public class MarketingQualityGoodsGeneratorCoreServiceImpl implements MarketingQualityGoodsGeneratorCoreService
{

    @Autowired
    private MarketingQualityGoodsMapper marketingQualityGoodsMapper;

    @Override
    public Integer countByExample(MarketingQualityGoodsExample marketingQualityGoodsExample) 
    {
        return this.marketingQualityGoodsMapper.countByExample(marketingQualityGoodsExample);
    }

    @Override
    public List<MarketingQualityGoods> selectByExample(MarketingQualityGoodsExample marketingQualityGoodsExample) 
    {
        return this.marketingQualityGoodsMapper.selectByExample(marketingQualityGoodsExample);
    }

    @Override
    public MarketingQualityGoods selectUnDelByPrimaryKey(String primaryKey) 
    {
        MarketingQualityGoodsKey marketingQualityGoodsKey = new MarketingQualityGoodsKey();
        marketingQualityGoodsKey.setIsDel("N");
        marketingQualityGoodsKey.setId(primaryKey);
        return this.marketingQualityGoodsMapper.selectByPrimaryKey(marketingQualityGoodsKey);
    }

    @Override
    public MarketingQualityGoods selectByPrimaryKey(String primaryKey) 
    {
        MarketingQualityGoodsKey marketingQualityGoodsKey = new MarketingQualityGoodsKey();
        marketingQualityGoodsKey.setId(primaryKey);
        return this.marketingQualityGoodsMapper.selectByPrimaryKey(marketingQualityGoodsKey);
    }

    @Override
    public boolean physicalDeleteByExample(MarketingQualityGoodsExample marketingQualityGoodsExample) 
    {
        return this.marketingQualityGoodsMapper.deleteByExample(marketingQualityGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MarketingQualityGoodsKey marketingQualityGoodsKey = new MarketingQualityGoodsKey();
        marketingQualityGoodsKey.setId(primaryKey);
        return this.marketingQualityGoodsMapper.deleteByPrimaryKey(marketingQualityGoodsKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MarketingQualityGoodsExample marketingQualityGoodsExample) 
    {
        MarketingQualityGoods marketingQualityGoods = new MarketingQualityGoods();
        marketingQualityGoods.setIsDel("Y");
        return this.marketingQualityGoodsMapper.updateByExampleSelective(marketingQualityGoods,marketingQualityGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MarketingQualityGoods marketingQualityGoods = new MarketingQualityGoods();
        marketingQualityGoods.setId(primaryKey);
        marketingQualityGoods.setIsDel("Y");
        return this.marketingQualityGoodsMapper.updateByPrimaryKeySelective(marketingQualityGoods) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MarketingQualityGoods marketingQualityGoods) 
    {
        return this.marketingQualityGoodsMapper.insertSelective(marketingQualityGoods) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MarketingQualityGoods marketingQualityGoods,MarketingQualityGoodsExample marketingQualityGoodsExample) 
    {
        return this.marketingQualityGoodsMapper.updateByExampleSelective(marketingQualityGoods,marketingQualityGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingQualityGoods marketingQualityGoods) 
    {
        return this.marketingQualityGoodsMapper.updateByPrimaryKeySelective(marketingQualityGoods) > 0 ? true : false;
    }

}

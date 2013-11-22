package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.MarketingQualityGoodsGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsKey;
import com.gooagoo.dao.generator.marketing.MarketingQualityGoodsMapper;

@Service
public class MarketingQualityGoodsGeneratorQueryServiceImpl implements MarketingQualityGoodsGeneratorQueryService
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

}

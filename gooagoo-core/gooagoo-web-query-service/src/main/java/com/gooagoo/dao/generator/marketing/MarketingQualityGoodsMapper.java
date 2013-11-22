package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsKey;

public interface MarketingQualityGoodsMapper
{

    public Integer countByExample(MarketingQualityGoodsExample marketingQualityGoodsExample);

    public List<MarketingQualityGoods> selectByExample(MarketingQualityGoodsExample marketingQualityGoodsExample);

    public MarketingQualityGoods selectByPrimaryKey(MarketingQualityGoodsKey marketingQualityGoodsKey);

}

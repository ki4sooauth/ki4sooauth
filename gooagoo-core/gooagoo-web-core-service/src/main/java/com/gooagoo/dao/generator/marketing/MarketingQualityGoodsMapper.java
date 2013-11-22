package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsKey;

public interface MarketingQualityGoodsMapper
{

    public Integer countByExample(MarketingQualityGoodsExample marketingQualityGoodsExample);

    public List<MarketingQualityGoods> selectByExample(MarketingQualityGoodsExample marketingQualityGoodsExample);

    public MarketingQualityGoods selectByPrimaryKey(MarketingQualityGoodsKey marketingQualityGoodsKey);

    public Integer deleteByExample(MarketingQualityGoodsExample marketingQualityGoodsExample);

    public Integer deleteByPrimaryKey(MarketingQualityGoodsKey marketingQualityGoodsKey);

    public Integer insertSelective(MarketingQualityGoods marketingQualityGoods);

    public Integer updateAllByExample(@Param("record") MarketingQualityGoods marketingQualityGoods, @Param("example") MarketingQualityGoodsExample marketingQualityGoodsExample);

    public Integer updateByExampleSelective(@Param("record") MarketingQualityGoods marketingQualityGoods, @Param("example") MarketingQualityGoodsExample marketingQualityGoodsExample);

    public Integer updateByPrimaryKeySelective(MarketingQualityGoods marketingQualityGoods);

}

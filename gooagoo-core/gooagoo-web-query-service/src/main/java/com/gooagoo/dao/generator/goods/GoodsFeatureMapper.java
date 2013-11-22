package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureKey;

public interface GoodsFeatureMapper
{

    public Integer countByExample(GoodsFeatureExample goodsFeatureExample);

    public List<GoodsFeature> selectByExample(GoodsFeatureExample goodsFeatureExample);

    public GoodsFeature selectByPrimaryKey(GoodsFeatureKey goodsFeatureKey);

}

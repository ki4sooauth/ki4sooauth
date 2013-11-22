package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureKey;

public interface GoodsFeatureMapper
{

    public Integer countByExample(GoodsFeatureExample goodsFeatureExample);

    public List<GoodsFeature> selectByExample(GoodsFeatureExample goodsFeatureExample);

    public GoodsFeature selectByPrimaryKey(GoodsFeatureKey goodsFeatureKey);

    public Integer deleteByExample(GoodsFeatureExample goodsFeatureExample);

    public Integer deleteByPrimaryKey(GoodsFeatureKey goodsFeatureKey);

    public Integer insertSelective(GoodsFeature goodsFeature);

    public Integer updateAllByExample(@Param("record") GoodsFeature goodsFeature, @Param("example") GoodsFeatureExample goodsFeatureExample);

    public Integer updateByExampleSelective(@Param("record") GoodsFeature goodsFeature, @Param("example") GoodsFeatureExample goodsFeatureExample);

    public Integer updateByPrimaryKeySelective(GoodsFeature goodsFeature);

}

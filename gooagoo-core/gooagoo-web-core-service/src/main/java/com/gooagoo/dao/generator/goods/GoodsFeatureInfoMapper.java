package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoKey;

public interface GoodsFeatureInfoMapper
{

    public Integer countByExample(GoodsFeatureInfoExample goodsFeatureInfoExample);

    public List<GoodsFeatureInfo> selectByExample(GoodsFeatureInfoExample goodsFeatureInfoExample);

    public GoodsFeatureInfo selectByPrimaryKey(GoodsFeatureInfoKey goodsFeatureInfoKey);

    public Integer deleteByExample(GoodsFeatureInfoExample goodsFeatureInfoExample);

    public Integer deleteByPrimaryKey(GoodsFeatureInfoKey goodsFeatureInfoKey);

    public Integer insertSelective(GoodsFeatureInfo goodsFeatureInfo);

    public Integer updateAllByExample(@Param("record") GoodsFeatureInfo goodsFeatureInfo, @Param("example") GoodsFeatureInfoExample goodsFeatureInfoExample);

    public Integer updateByExampleSelective(@Param("record") GoodsFeatureInfo goodsFeatureInfo, @Param("example") GoodsFeatureInfoExample goodsFeatureInfoExample);

    public Integer updateByPrimaryKeySelective(GoodsFeatureInfo goodsFeatureInfo);

}

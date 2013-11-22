package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoKey;

public interface GoodsFeatureInfoMapper
{

    public Integer countByExample(GoodsFeatureInfoExample goodsFeatureInfoExample);

    public List<GoodsFeatureInfo> selectByExample(GoodsFeatureInfoExample goodsFeatureInfoExample);

    public GoodsFeatureInfo selectByPrimaryKey(GoodsFeatureInfoKey goodsFeatureInfoKey);

}

package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsFeatureGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureKey;
import com.gooagoo.dao.generator.goods.GoodsFeatureMapper;

@Service
public class GoodsFeatureGeneratorQueryServiceImpl implements GoodsFeatureGeneratorQueryService
{

    @Autowired
    private GoodsFeatureMapper goodsFeatureMapper;

    @Override
    public Integer countByExample(GoodsFeatureExample goodsFeatureExample) 
    {
        return this.goodsFeatureMapper.countByExample(goodsFeatureExample);
    }

    @Override
    public List<GoodsFeature> selectByExample(GoodsFeatureExample goodsFeatureExample) 
    {
        return this.goodsFeatureMapper.selectByExample(goodsFeatureExample);
    }

    @Override
    public GoodsFeature selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureKey goodsFeatureKey = new GoodsFeatureKey();
        goodsFeatureKey.setIsDel("N");
        goodsFeatureKey.setId(primaryKey);
        return this.goodsFeatureMapper.selectByPrimaryKey(goodsFeatureKey);
    }

    @Override
    public GoodsFeature selectByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureKey goodsFeatureKey = new GoodsFeatureKey();
        goodsFeatureKey.setId(primaryKey);
        return this.goodsFeatureMapper.selectByPrimaryKey(goodsFeatureKey);
    }

}

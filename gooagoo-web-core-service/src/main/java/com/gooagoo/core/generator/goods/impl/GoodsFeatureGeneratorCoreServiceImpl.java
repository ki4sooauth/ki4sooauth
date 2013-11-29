package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.goods.GoodsFeatureGeneratorCoreService;
import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureKey;
import com.gooagoo.dao.generator.goods.GoodsFeatureMapper;

@Service
public class GoodsFeatureGeneratorCoreServiceImpl implements GoodsFeatureGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(GoodsFeatureExample goodsFeatureExample) 
    {
        return this.goodsFeatureMapper.deleteByExample(goodsFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureKey goodsFeatureKey = new GoodsFeatureKey();
        goodsFeatureKey.setId(primaryKey);
        return this.goodsFeatureMapper.deleteByPrimaryKey(goodsFeatureKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(GoodsFeatureExample goodsFeatureExample) 
    {
        GoodsFeature goodsFeature = new GoodsFeature();
        goodsFeature.setIsDel("Y");
        return this.goodsFeatureMapper.updateByExampleSelective(goodsFeature,goodsFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        GoodsFeature goodsFeature = new GoodsFeature();
        goodsFeature.setId(primaryKey);
        goodsFeature.setIsDel("Y");
        return this.goodsFeatureMapper.updateByPrimaryKeySelective(goodsFeature) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(GoodsFeature goodsFeature) 
    {
        return this.goodsFeatureMapper.insertSelective(goodsFeature) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsFeature goodsFeature,GoodsFeatureExample goodsFeatureExample) 
    {
        return this.goodsFeatureMapper.updateByExampleSelective(goodsFeature,goodsFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsFeature goodsFeature) 
    {
        return this.goodsFeatureMapper.updateByPrimaryKeySelective(goodsFeature) > 0 ? true : false;
    }

}

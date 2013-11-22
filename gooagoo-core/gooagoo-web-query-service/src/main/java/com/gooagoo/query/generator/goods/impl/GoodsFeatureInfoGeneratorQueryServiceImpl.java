package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsFeatureInfoGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoKey;
import com.gooagoo.dao.generator.goods.GoodsFeatureInfoMapper;

@Service
public class GoodsFeatureInfoGeneratorQueryServiceImpl implements GoodsFeatureInfoGeneratorQueryService
{

    @Autowired
    private GoodsFeatureInfoMapper goodsFeatureInfoMapper;

    @Override
    public Integer countByExample(GoodsFeatureInfoExample goodsFeatureInfoExample) 
    {
        return this.goodsFeatureInfoMapper.countByExample(goodsFeatureInfoExample);
    }

    @Override
    public List<GoodsFeatureInfo> selectByExample(GoodsFeatureInfoExample goodsFeatureInfoExample) 
    {
        return this.goodsFeatureInfoMapper.selectByExample(goodsFeatureInfoExample);
    }

    @Override
    public GoodsFeatureInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureInfoKey goodsFeatureInfoKey = new GoodsFeatureInfoKey();
        goodsFeatureInfoKey.setIsDel("N");
        goodsFeatureInfoKey.setId(primaryKey);
        return this.goodsFeatureInfoMapper.selectByPrimaryKey(goodsFeatureInfoKey);
    }

    @Override
    public GoodsFeatureInfo selectByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureInfoKey goodsFeatureInfoKey = new GoodsFeatureInfoKey();
        goodsFeatureInfoKey.setId(primaryKey);
        return this.goodsFeatureInfoMapper.selectByPrimaryKey(goodsFeatureInfoKey);
    }

}

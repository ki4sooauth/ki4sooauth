package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.goods.GoodsFeatureInfoGeneratorCoreService;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoKey;
import com.gooagoo.dao.generator.goods.GoodsFeatureInfoMapper;

@Service
public class GoodsFeatureInfoGeneratorCoreServiceImpl implements GoodsFeatureInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(GoodsFeatureInfoExample goodsFeatureInfoExample) 
    {
        return this.goodsFeatureInfoMapper.deleteByExample(goodsFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureInfoKey goodsFeatureInfoKey = new GoodsFeatureInfoKey();
        goodsFeatureInfoKey.setId(primaryKey);
        return this.goodsFeatureInfoMapper.deleteByPrimaryKey(goodsFeatureInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(GoodsFeatureInfoExample goodsFeatureInfoExample) 
    {
        GoodsFeatureInfo goodsFeatureInfo = new GoodsFeatureInfo();
        goodsFeatureInfo.setIsDel("Y");
        return this.goodsFeatureInfoMapper.updateByExampleSelective(goodsFeatureInfo,goodsFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        GoodsFeatureInfo goodsFeatureInfo = new GoodsFeatureInfo();
        goodsFeatureInfo.setId(primaryKey);
        goodsFeatureInfo.setIsDel("Y");
        return this.goodsFeatureInfoMapper.updateByPrimaryKeySelective(goodsFeatureInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(GoodsFeatureInfo goodsFeatureInfo) 
    {
        return this.goodsFeatureInfoMapper.insertSelective(goodsFeatureInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsFeatureInfo goodsFeatureInfo,GoodsFeatureInfoExample goodsFeatureInfoExample) 
    {
        return this.goodsFeatureInfoMapper.updateByExampleSelective(goodsFeatureInfo,goodsFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsFeatureInfo goodsFeatureInfo) 
    {
        return this.goodsFeatureInfoMapper.updateByPrimaryKeySelective(goodsFeatureInfo) > 0 ? true : false;
    }

}

package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoKey;
import com.gooagoo.dao.generator.goods.GoodsBaseInfoMapper;

@Service
public class GoodsBaseInfoGeneratorQueryServiceImpl implements GoodsBaseInfoGeneratorQueryService
{

    @Autowired
    private GoodsBaseInfoMapper goodsBaseInfoMapper;

    @Override
    public Integer countByExample(GoodsBaseInfoExample goodsBaseInfoExample) 
    {
        return this.goodsBaseInfoMapper.countByExample(goodsBaseInfoExample);
    }

    @Override
    public List<GoodsBaseInfo> selectByExample(GoodsBaseInfoExample goodsBaseInfoExample) 
    {
        return this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
    }

    @Override
    public GoodsBaseInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsBaseInfoKey goodsBaseInfoKey = new GoodsBaseInfoKey();
        goodsBaseInfoKey.setIsDel("N");
        goodsBaseInfoKey.setGoodsId(primaryKey);
        return this.goodsBaseInfoMapper.selectByPrimaryKey(goodsBaseInfoKey);
    }

    @Override
    public GoodsBaseInfo selectByPrimaryKey(String primaryKey) 
    {
        GoodsBaseInfoKey goodsBaseInfoKey = new GoodsBaseInfoKey();
        goodsBaseInfoKey.setGoodsId(primaryKey);
        return this.goodsBaseInfoMapper.selectByPrimaryKey(goodsBaseInfoKey);
    }

}

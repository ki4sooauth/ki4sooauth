package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsCategoryKey;
import com.gooagoo.dao.generator.goods.GoodsCategoryMapper;

@Service
public class GoodsCategoryGeneratorQueryServiceImpl implements GoodsCategoryGeneratorQueryService
{

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public Integer countByExample(GoodsCategoryExample goodsCategoryExample) 
    {
        return this.goodsCategoryMapper.countByExample(goodsCategoryExample);
    }

    @Override
    public List<GoodsCategory> selectByExample(GoodsCategoryExample goodsCategoryExample) 
    {
        return this.goodsCategoryMapper.selectByExample(goodsCategoryExample);
    }

    @Override
    public GoodsCategory selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setIsDel("N");
        goodsCategoryKey.setId(primaryKey);
        return this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
    }

    @Override
    public GoodsCategory selectByPrimaryKey(String primaryKey) 
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setId(primaryKey);
        return this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
    }

}

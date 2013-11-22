package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandKey;
import com.gooagoo.dao.generator.goods.GoodsBrandMapper;

@Service
public class GoodsBrandGeneratorQueryServiceImpl implements GoodsBrandGeneratorQueryService
{

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;

    @Override
    public Integer countByExample(GoodsBrandExample goodsBrandExample) 
    {
        return this.goodsBrandMapper.countByExample(goodsBrandExample);
    }

    @Override
    public List<GoodsBrand> selectByExample(GoodsBrandExample goodsBrandExample) 
    {
        return this.goodsBrandMapper.selectByExample(goodsBrandExample);
    }

    @Override
    public GoodsBrand selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsBrandKey goodsBrandKey = new GoodsBrandKey();
        goodsBrandKey.setIsDel("N");
        goodsBrandKey.setId(primaryKey);
        return this.goodsBrandMapper.selectByPrimaryKey(goodsBrandKey);
    }

    @Override
    public GoodsBrand selectByPrimaryKey(String primaryKey) 
    {
        GoodsBrandKey goodsBrandKey = new GoodsBrandKey();
        goodsBrandKey.setId(primaryKey);
        return this.goodsBrandMapper.selectByPrimaryKey(goodsBrandKey);
    }

}

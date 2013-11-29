package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.goods.GoodsBrandGeneratorCoreService;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandKey;
import com.gooagoo.dao.generator.goods.GoodsBrandMapper;

@Service
public class GoodsBrandGeneratorCoreServiceImpl implements GoodsBrandGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(GoodsBrandExample goodsBrandExample) 
    {
        return this.goodsBrandMapper.deleteByExample(goodsBrandExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        GoodsBrandKey goodsBrandKey = new GoodsBrandKey();
        goodsBrandKey.setId(primaryKey);
        return this.goodsBrandMapper.deleteByPrimaryKey(goodsBrandKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(GoodsBrandExample goodsBrandExample) 
    {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setIsDel("Y");
        return this.goodsBrandMapper.updateByExampleSelective(goodsBrand,goodsBrandExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setId(primaryKey);
        goodsBrand.setIsDel("Y");
        return this.goodsBrandMapper.updateByPrimaryKeySelective(goodsBrand) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(GoodsBrand goodsBrand) 
    {
        return this.goodsBrandMapper.insertSelective(goodsBrand) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsBrand goodsBrand,GoodsBrandExample goodsBrandExample) 
    {
        return this.goodsBrandMapper.updateByExampleSelective(goodsBrand,goodsBrandExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsBrand goodsBrand) 
    {
        return this.goodsBrandMapper.updateByPrimaryKeySelective(goodsBrand) > 0 ? true : false;
    }

}

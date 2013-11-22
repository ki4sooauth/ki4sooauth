package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.NominateGoodsGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;
import com.gooagoo.entity.generator.sys.NominateGoodsKey;
import com.gooagoo.dao.generator.sys.NominateGoodsMapper;

@Service
public class NominateGoodsGeneratorCoreServiceImpl implements NominateGoodsGeneratorCoreService
{

    @Autowired
    private NominateGoodsMapper nominateGoodsMapper;

    @Override
    public Integer countByExample(NominateGoodsExample nominateGoodsExample) 
    {
        return this.nominateGoodsMapper.countByExample(nominateGoodsExample);
    }

    @Override
    public List<NominateGoods> selectByExample(NominateGoodsExample nominateGoodsExample) 
    {
        return this.nominateGoodsMapper.selectByExample(nominateGoodsExample);
    }

    @Override
    public NominateGoods selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateGoodsKey nominateGoodsKey = new NominateGoodsKey();
        nominateGoodsKey.setIsDel("N");
        nominateGoodsKey.setId(primaryKey);
        return this.nominateGoodsMapper.selectByPrimaryKey(nominateGoodsKey);
    }

    @Override
    public NominateGoods selectByPrimaryKey(String primaryKey) 
    {
        NominateGoodsKey nominateGoodsKey = new NominateGoodsKey();
        nominateGoodsKey.setId(primaryKey);
        return this.nominateGoodsMapper.selectByPrimaryKey(nominateGoodsKey);
    }

    @Override
    public boolean physicalDeleteByExample(NominateGoodsExample nominateGoodsExample) 
    {
        return this.nominateGoodsMapper.deleteByExample(nominateGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        NominateGoodsKey nominateGoodsKey = new NominateGoodsKey();
        nominateGoodsKey.setId(primaryKey);
        return this.nominateGoodsMapper.deleteByPrimaryKey(nominateGoodsKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(NominateGoodsExample nominateGoodsExample) 
    {
        NominateGoods nominateGoods = new NominateGoods();
        nominateGoods.setIsDel("Y");
        return this.nominateGoodsMapper.updateByExampleSelective(nominateGoods,nominateGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        NominateGoods nominateGoods = new NominateGoods();
        nominateGoods.setId(primaryKey);
        nominateGoods.setIsDel("Y");
        return this.nominateGoodsMapper.updateByPrimaryKeySelective(nominateGoods) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(NominateGoods nominateGoods) 
    {
        return this.nominateGoodsMapper.insertSelective(nominateGoods) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(NominateGoods nominateGoods,NominateGoodsExample nominateGoodsExample) 
    {
        return this.nominateGoodsMapper.updateByExampleSelective(nominateGoods,nominateGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(NominateGoods nominateGoods) 
    {
        return this.nominateGoodsMapper.updateByPrimaryKeySelective(nominateGoods) > 0 ? true : false;
    }

}

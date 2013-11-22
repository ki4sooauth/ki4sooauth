package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.NominateGoodsGeneratorQueryService;
import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;
import com.gooagoo.entity.generator.sys.NominateGoodsKey;
import com.gooagoo.dao.generator.sys.NominateGoodsMapper;

@Service
public class NominateGoodsGeneratorQueryServiceImpl implements NominateGoodsGeneratorQueryService
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

}

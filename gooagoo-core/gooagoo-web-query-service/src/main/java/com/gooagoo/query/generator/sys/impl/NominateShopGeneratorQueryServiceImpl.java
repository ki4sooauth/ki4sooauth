package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.NominateShopGeneratorQueryService;
import com.gooagoo.entity.generator.sys.NominateShop;
import com.gooagoo.entity.generator.sys.NominateShopExample;
import com.gooagoo.entity.generator.sys.NominateShopKey;
import com.gooagoo.dao.generator.sys.NominateShopMapper;

@Service
public class NominateShopGeneratorQueryServiceImpl implements NominateShopGeneratorQueryService
{

    @Autowired
    private NominateShopMapper nominateShopMapper;

    @Override
    public Integer countByExample(NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.countByExample(nominateShopExample);
    }

    @Override
    public List<NominateShop> selectByExample(NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.selectByExample(nominateShopExample);
    }

    @Override
    public NominateShop selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateShopKey nominateShopKey = new NominateShopKey();
        nominateShopKey.setIsDel("N");
        nominateShopKey.setId(primaryKey);
        return this.nominateShopMapper.selectByPrimaryKey(nominateShopKey);
    }

    @Override
    public NominateShop selectByPrimaryKey(String primaryKey) 
    {
        NominateShopKey nominateShopKey = new NominateShopKey();
        nominateShopKey.setId(primaryKey);
        return this.nominateShopMapper.selectByPrimaryKey(nominateShopKey);
    }

}

package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.GeneratrixInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.GeneratrixInfoExample;
import com.gooagoo.entity.generator.shop.GeneratrixInfoKey;
import com.gooagoo.dao.generator.shop.GeneratrixInfoMapper;

@Service
public class GeneratrixInfoGeneratorQueryServiceImpl implements GeneratrixInfoGeneratorQueryService
{

    @Autowired
    private GeneratrixInfoMapper generatrixInfoMapper;

    @Override
    public Integer countByExample(GeneratrixInfoExample generatrixInfoExample) 
    {
        return this.generatrixInfoMapper.countByExample(generatrixInfoExample);
    }

    @Override
    public List<GeneratrixInfo> selectByExample(GeneratrixInfoExample generatrixInfoExample) 
    {
        return this.generatrixInfoMapper.selectByExample(generatrixInfoExample);
    }

    @Override
    public GeneratrixInfo selectByPrimaryKey(String primaryKey) 
    {
        GeneratrixInfoKey generatrixInfoKey = new GeneratrixInfoKey();
        generatrixInfoKey.setGeneratrixId(primaryKey);
        return this.generatrixInfoMapper.selectByPrimaryKey(generatrixInfoKey);
    }

}

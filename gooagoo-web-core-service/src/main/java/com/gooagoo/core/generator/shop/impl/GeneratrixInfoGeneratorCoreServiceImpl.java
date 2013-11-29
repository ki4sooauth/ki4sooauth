package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.GeneratrixInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.GeneratrixInfoExample;
import com.gooagoo.entity.generator.shop.GeneratrixInfoKey;
import com.gooagoo.dao.generator.shop.GeneratrixInfoMapper;

@Service
public class GeneratrixInfoGeneratorCoreServiceImpl implements GeneratrixInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(GeneratrixInfoExample generatrixInfoExample) 
    {
        return this.generatrixInfoMapper.deleteByExample(generatrixInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        GeneratrixInfoKey generatrixInfoKey = new GeneratrixInfoKey();
        generatrixInfoKey.setGeneratrixId(primaryKey);
        return this.generatrixInfoMapper.deleteByPrimaryKey(generatrixInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(GeneratrixInfo generatrixInfo) 
    {
        return this.generatrixInfoMapper.insertSelective(generatrixInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GeneratrixInfo generatrixInfo,GeneratrixInfoExample generatrixInfoExample) 
    {
        return this.generatrixInfoMapper.updateByExampleSelective(generatrixInfo,generatrixInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GeneratrixInfo generatrixInfo) 
    {
        return this.generatrixInfoMapper.updateByPrimaryKeySelective(generatrixInfo) > 0 ? true : false;
    }

}

package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.InterfaceBaseInfoGeneratorQueryService;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoKey;
import com.gooagoo.dao.generator.sys.InterfaceBaseInfoMapper;

@Service
public class InterfaceBaseInfoGeneratorQueryServiceImpl implements InterfaceBaseInfoGeneratorQueryService
{

    @Autowired
    private InterfaceBaseInfoMapper interfaceBaseInfoMapper;

    @Override
    public Integer countByExample(InterfaceBaseInfoExample interfaceBaseInfoExample) 
    {
        return this.interfaceBaseInfoMapper.countByExample(interfaceBaseInfoExample);
    }

    @Override
    public List<InterfaceBaseInfo> selectByExample(InterfaceBaseInfoExample interfaceBaseInfoExample) 
    {
        return this.interfaceBaseInfoMapper.selectByExample(interfaceBaseInfoExample);
    }

    @Override
    public InterfaceBaseInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        InterfaceBaseInfoKey interfaceBaseInfoKey = new InterfaceBaseInfoKey();
        interfaceBaseInfoKey.setIsDel("N");
        interfaceBaseInfoKey.setICode(primaryKey);
        return this.interfaceBaseInfoMapper.selectByPrimaryKey(interfaceBaseInfoKey);
    }

    @Override
    public InterfaceBaseInfo selectByPrimaryKey(String primaryKey) 
    {
        InterfaceBaseInfoKey interfaceBaseInfoKey = new InterfaceBaseInfoKey();
        interfaceBaseInfoKey.setICode(primaryKey);
        return this.interfaceBaseInfoMapper.selectByPrimaryKey(interfaceBaseInfoKey);
    }

}

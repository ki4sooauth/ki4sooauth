package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.InterfaceRequestInfoGeneratorQueryService;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoKey;
import com.gooagoo.dao.generator.sys.InterfaceRequestInfoMapper;

@Service
public class InterfaceRequestInfoGeneratorQueryServiceImpl implements InterfaceRequestInfoGeneratorQueryService
{

    @Autowired
    private InterfaceRequestInfoMapper interfaceRequestInfoMapper;

    @Override
    public Integer countByExample(InterfaceRequestInfoExample interfaceRequestInfoExample) 
    {
        return this.interfaceRequestInfoMapper.countByExample(interfaceRequestInfoExample);
    }

    @Override
    public List<InterfaceRequestInfo> selectByExample(InterfaceRequestInfoExample interfaceRequestInfoExample) 
    {
        return this.interfaceRequestInfoMapper.selectByExample(interfaceRequestInfoExample);
    }

    @Override
    public InterfaceRequestInfo selectByPrimaryKey(Integer primaryKey) 
    {
        InterfaceRequestInfoKey interfaceRequestInfoKey = new InterfaceRequestInfoKey();
        interfaceRequestInfoKey.setId(primaryKey);
        return this.interfaceRequestInfoMapper.selectByPrimaryKey(interfaceRequestInfoKey);
    }

}

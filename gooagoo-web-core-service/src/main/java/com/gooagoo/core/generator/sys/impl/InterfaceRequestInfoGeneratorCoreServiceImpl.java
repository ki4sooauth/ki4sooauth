package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.InterfaceRequestInfoGeneratorCoreService;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoKey;
import com.gooagoo.dao.generator.sys.InterfaceRequestInfoMapper;

@Service
public class InterfaceRequestInfoGeneratorCoreServiceImpl implements InterfaceRequestInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(InterfaceRequestInfoExample interfaceRequestInfoExample) 
    {
        return this.interfaceRequestInfoMapper.deleteByExample(interfaceRequestInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        InterfaceRequestInfoKey interfaceRequestInfoKey = new InterfaceRequestInfoKey();
        interfaceRequestInfoKey.setId(primaryKey);
        return this.interfaceRequestInfoMapper.deleteByPrimaryKey(interfaceRequestInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(InterfaceRequestInfo interfaceRequestInfo) 
    {
        return this.interfaceRequestInfoMapper.insertSelective(interfaceRequestInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(InterfaceRequestInfo interfaceRequestInfo,InterfaceRequestInfoExample interfaceRequestInfoExample) 
    {
        return this.interfaceRequestInfoMapper.updateByExampleSelective(interfaceRequestInfo,interfaceRequestInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(InterfaceRequestInfo interfaceRequestInfo) 
    {
        return this.interfaceRequestInfoMapper.updateByPrimaryKeySelective(interfaceRequestInfo) > 0 ? true : false;
    }

}

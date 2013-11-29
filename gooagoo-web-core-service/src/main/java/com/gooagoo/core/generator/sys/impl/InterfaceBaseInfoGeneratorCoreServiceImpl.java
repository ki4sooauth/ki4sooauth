package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.InterfaceBaseInfoGeneratorCoreService;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoKey;
import com.gooagoo.dao.generator.sys.InterfaceBaseInfoMapper;

@Service
public class InterfaceBaseInfoGeneratorCoreServiceImpl implements InterfaceBaseInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(InterfaceBaseInfoExample interfaceBaseInfoExample) 
    {
        return this.interfaceBaseInfoMapper.deleteByExample(interfaceBaseInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        InterfaceBaseInfoKey interfaceBaseInfoKey = new InterfaceBaseInfoKey();
        interfaceBaseInfoKey.setICode(primaryKey);
        return this.interfaceBaseInfoMapper.deleteByPrimaryKey(interfaceBaseInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(InterfaceBaseInfoExample interfaceBaseInfoExample) 
    {
        InterfaceBaseInfo interfaceBaseInfo = new InterfaceBaseInfo();
        interfaceBaseInfo.setIsDel("Y");
        return this.interfaceBaseInfoMapper.updateByExampleSelective(interfaceBaseInfo,interfaceBaseInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        InterfaceBaseInfo interfaceBaseInfo = new InterfaceBaseInfo();
        interfaceBaseInfo.setICode(primaryKey);
        interfaceBaseInfo.setIsDel("Y");
        return this.interfaceBaseInfoMapper.updateByPrimaryKeySelective(interfaceBaseInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(InterfaceBaseInfo interfaceBaseInfo) 
    {
        return this.interfaceBaseInfoMapper.insertSelective(interfaceBaseInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(InterfaceBaseInfo interfaceBaseInfo,InterfaceBaseInfoExample interfaceBaseInfoExample) 
    {
        return this.interfaceBaseInfoMapper.updateByExampleSelective(interfaceBaseInfo,interfaceBaseInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(InterfaceBaseInfo interfaceBaseInfo) 
    {
        return this.interfaceBaseInfoMapper.updateByPrimaryKeySelective(interfaceBaseInfo) > 0 ? true : false;
    }

}

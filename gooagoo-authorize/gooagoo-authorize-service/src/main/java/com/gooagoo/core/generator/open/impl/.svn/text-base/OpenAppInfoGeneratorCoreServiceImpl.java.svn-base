package com.gooagoo.core.generator.open.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.open.OpenAppInfoGeneratorCoreService;
import com.gooagoo.dao.generator.open.OpenAppInfoMapper;
import com.gooagoo.entity.generator.open.OpenAppInfo;
import com.gooagoo.entity.generator.open.OpenAppInfoExample;
import com.gooagoo.entity.generator.open.OpenAppInfoKey;

@Service
public class OpenAppInfoGeneratorCoreServiceImpl implements OpenAppInfoGeneratorCoreService
{

    @Autowired
    private OpenAppInfoMapper openAppInfoMapper;

    @Override
    public Integer countByExample(OpenAppInfoExample openAppInfoExample)
    {
        return this.openAppInfoMapper.countByExample(openAppInfoExample);
    }

    @Override
    public List<OpenAppInfo> selectByExample(OpenAppInfoExample openAppInfoExample)
    {
        return this.openAppInfoMapper.selectByExample(openAppInfoExample);
    }

    @Override
    public OpenAppInfo selectByPrimaryKey(Integer primaryKey)
    {
        OpenAppInfoKey openAppInfoKey = new OpenAppInfoKey();
        openAppInfoKey.setAppKey(primaryKey);
        return this.openAppInfoMapper.selectByPrimaryKey(openAppInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(OpenAppInfoExample openAppInfoExample)
    {
        return this.openAppInfoMapper.deleteByExample(openAppInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey)
    {
        OpenAppInfoKey openAppInfoKey = new OpenAppInfoKey();
        openAppInfoKey.setAppKey(primaryKey);
        return this.openAppInfoMapper.deleteByPrimaryKey(openAppInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OpenAppInfo openAppInfo)
    {
        return this.openAppInfoMapper.insertSelective(openAppInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OpenAppInfo openAppInfo, OpenAppInfoExample openAppInfoExample)
    {
        return this.openAppInfoMapper.updateByExampleSelective(openAppInfo, openAppInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OpenAppInfo openAppInfo)
    {
        return this.openAppInfoMapper.updateByPrimaryKeySelective(openAppInfo) > 0 ? true : false;
    }

}

package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.SysConfigGeneratorCoreService;
import com.gooagoo.entity.generator.base.SysConfig;
import com.gooagoo.entity.generator.base.SysConfigExample;
import com.gooagoo.entity.generator.base.SysConfigKey;
import com.gooagoo.dao.generator.base.SysConfigMapper;

@Service
public class SysConfigGeneratorCoreServiceImpl implements SysConfigGeneratorCoreService
{

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public Integer countByExample(SysConfigExample sysConfigExample) 
    {
        return this.sysConfigMapper.countByExample(sysConfigExample);
    }

    @Override
    public List<SysConfig> selectByExample(SysConfigExample sysConfigExample) 
    {
        return this.sysConfigMapper.selectByExample(sysConfigExample);
    }

    @Override
    public SysConfig selectByPrimaryKey(Integer primaryKey) 
    {
        SysConfigKey sysConfigKey = new SysConfigKey();
        sysConfigKey.setId(primaryKey);
        return this.sysConfigMapper.selectByPrimaryKey(sysConfigKey);
    }

    @Override
    public boolean physicalDeleteByExample(SysConfigExample sysConfigExample) 
    {
        return this.sysConfigMapper.deleteByExample(sysConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        SysConfigKey sysConfigKey = new SysConfigKey();
        sysConfigKey.setId(primaryKey);
        return this.sysConfigMapper.deleteByPrimaryKey(sysConfigKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysConfig sysConfig) 
    {
        return this.sysConfigMapper.insertSelective(sysConfig) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysConfig sysConfig,SysConfigExample sysConfigExample) 
    {
        return this.sysConfigMapper.updateByExampleSelective(sysConfig,sysConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysConfig sysConfig) 
    {
        return this.sysConfigMapper.updateByPrimaryKeySelective(sysConfig) > 0 ? true : false;
    }

}

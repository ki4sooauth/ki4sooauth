package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.SysConfigGeneratorQueryService;
import com.gooagoo.entity.generator.base.SysConfig;
import com.gooagoo.entity.generator.base.SysConfigExample;
import com.gooagoo.entity.generator.base.SysConfigKey;
import com.gooagoo.dao.generator.base.SysConfigMapper;

@Service
public class SysConfigGeneratorQueryServiceImpl implements SysConfigGeneratorQueryService
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

}

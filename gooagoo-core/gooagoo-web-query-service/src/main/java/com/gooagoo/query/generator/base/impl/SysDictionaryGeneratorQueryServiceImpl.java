package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.SysDictionaryGeneratorQueryService;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.SysDictionaryKey;
import com.gooagoo.dao.generator.base.SysDictionaryMapper;

@Service
public class SysDictionaryGeneratorQueryServiceImpl implements SysDictionaryGeneratorQueryService
{

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public Integer countByExample(SysDictionaryExample sysDictionaryExample) 
    {
        return this.sysDictionaryMapper.countByExample(sysDictionaryExample);
    }

    @Override
    public List<SysDictionary> selectByExample(SysDictionaryExample sysDictionaryExample) 
    {
        return this.sysDictionaryMapper.selectByExample(sysDictionaryExample);
    }

    @Override
    public SysDictionary selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        SysDictionaryKey sysDictionaryKey = new SysDictionaryKey();
        sysDictionaryKey.setIsDel("N");
        sysDictionaryKey.setSysDictionaryId(primaryKey);
        return this.sysDictionaryMapper.selectByPrimaryKey(sysDictionaryKey);
    }

    @Override
    public SysDictionary selectByPrimaryKey(Integer primaryKey) 
    {
        SysDictionaryKey sysDictionaryKey = new SysDictionaryKey();
        sysDictionaryKey.setSysDictionaryId(primaryKey);
        return this.sysDictionaryMapper.selectByPrimaryKey(sysDictionaryKey);
    }

}

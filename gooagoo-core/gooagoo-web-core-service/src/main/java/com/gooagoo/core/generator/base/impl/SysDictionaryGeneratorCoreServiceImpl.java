package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.SysDictionaryGeneratorCoreService;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.SysDictionaryKey;
import com.gooagoo.dao.generator.base.SysDictionaryMapper;

@Service
public class SysDictionaryGeneratorCoreServiceImpl implements SysDictionaryGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(SysDictionaryExample sysDictionaryExample) 
    {
        return this.sysDictionaryMapper.deleteByExample(sysDictionaryExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        SysDictionaryKey sysDictionaryKey = new SysDictionaryKey();
        sysDictionaryKey.setSysDictionaryId(primaryKey);
        return this.sysDictionaryMapper.deleteByPrimaryKey(sysDictionaryKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysDictionaryExample sysDictionaryExample) 
    {
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setIsDel("Y");
        return this.sysDictionaryMapper.updateByExampleSelective(sysDictionary,sysDictionaryExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setSysDictionaryId(primaryKey);
        sysDictionary.setIsDel("Y");
        return this.sysDictionaryMapper.updateByPrimaryKeySelective(sysDictionary) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysDictionary sysDictionary) 
    {
        return this.sysDictionaryMapper.insertSelective(sysDictionary) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysDictionary sysDictionary,SysDictionaryExample sysDictionaryExample) 
    {
        return this.sysDictionaryMapper.updateByExampleSelective(sysDictionary,sysDictionaryExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysDictionary sysDictionary) 
    {
        return this.sysDictionaryMapper.updateByPrimaryKeySelective(sysDictionary) > 0 ? true : false;
    }

}

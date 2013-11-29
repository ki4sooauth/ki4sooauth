package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.SysDictionaryKey;

public interface SysDictionaryMapper
{

    public Integer countByExample(SysDictionaryExample sysDictionaryExample);

    public List<SysDictionary> selectByExample(SysDictionaryExample sysDictionaryExample);

    public SysDictionary selectByPrimaryKey(SysDictionaryKey sysDictionaryKey);

    public Integer deleteByExample(SysDictionaryExample sysDictionaryExample);

    public Integer deleteByPrimaryKey(SysDictionaryKey sysDictionaryKey);

    public Integer insertSelective(SysDictionary sysDictionary);

    public Integer updateAllByExample(@Param("record") SysDictionary sysDictionary, @Param("example") SysDictionaryExample sysDictionaryExample);

    public Integer updateByExampleSelective(@Param("record") SysDictionary sysDictionary, @Param("example") SysDictionaryExample sysDictionaryExample);

    public Integer updateByPrimaryKeySelective(SysDictionary sysDictionary);

}

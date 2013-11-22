package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.SysDictionaryKey;

public interface SysDictionaryMapper
{

    public Integer countByExample(SysDictionaryExample sysDictionaryExample);

    public List<SysDictionary> selectByExample(SysDictionaryExample sysDictionaryExample);

    public SysDictionary selectByPrimaryKey(SysDictionaryKey sysDictionaryKey);

}

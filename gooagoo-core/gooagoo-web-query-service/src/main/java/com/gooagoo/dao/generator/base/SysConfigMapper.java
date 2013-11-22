package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.SysConfig;
import com.gooagoo.entity.generator.base.SysConfigExample;
import com.gooagoo.entity.generator.base.SysConfigKey;

public interface SysConfigMapper
{

    public Integer countByExample(SysConfigExample sysConfigExample);

    public List<SysConfig> selectByExample(SysConfigExample sysConfigExample);

    public SysConfig selectByPrimaryKey(SysConfigKey sysConfigKey);

}

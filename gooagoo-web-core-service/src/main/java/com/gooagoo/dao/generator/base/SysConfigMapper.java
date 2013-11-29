package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.SysConfig;
import com.gooagoo.entity.generator.base.SysConfigExample;
import com.gooagoo.entity.generator.base.SysConfigKey;

public interface SysConfigMapper
{

    public Integer countByExample(SysConfigExample sysConfigExample);

    public List<SysConfig> selectByExample(SysConfigExample sysConfigExample);

    public SysConfig selectByPrimaryKey(SysConfigKey sysConfigKey);

    public Integer deleteByExample(SysConfigExample sysConfigExample);

    public Integer deleteByPrimaryKey(SysConfigKey sysConfigKey);

    public Integer insertSelective(SysConfig sysConfig);

    public Integer updateAllByExample(@Param("record") SysConfig sysConfig, @Param("example") SysConfigExample sysConfigExample);

    public Integer updateByExampleSelective(@Param("record") SysConfig sysConfig, @Param("example") SysConfigExample sysConfigExample);

    public Integer updateByPrimaryKeySelective(SysConfig sysConfig);

}

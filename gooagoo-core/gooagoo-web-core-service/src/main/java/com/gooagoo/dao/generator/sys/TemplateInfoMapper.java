package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoKey;

public interface TemplateInfoMapper
{

    public Integer countByExample(TemplateInfoExample templateInfoExample);

    public List<TemplateInfo> selectByExample(TemplateInfoExample templateInfoExample);

    public TemplateInfo selectByPrimaryKey(TemplateInfoKey templateInfoKey);

    public Integer deleteByExample(TemplateInfoExample templateInfoExample);

    public Integer deleteByPrimaryKey(TemplateInfoKey templateInfoKey);

    public Integer insertSelective(TemplateInfo templateInfo);

    public Integer updateAllByExample(@Param("record") TemplateInfo templateInfo, @Param("example") TemplateInfoExample templateInfoExample);

    public Integer updateByExampleSelective(@Param("record") TemplateInfo templateInfo, @Param("example") TemplateInfoExample templateInfoExample);

    public Integer updateByPrimaryKeySelective(TemplateInfo templateInfo);

}

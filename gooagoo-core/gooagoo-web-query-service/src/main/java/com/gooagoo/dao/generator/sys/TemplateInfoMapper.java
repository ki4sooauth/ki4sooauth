package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoKey;

public interface TemplateInfoMapper
{

    public Integer countByExample(TemplateInfoExample templateInfoExample);

    public List<TemplateInfo> selectByExample(TemplateInfoExample templateInfoExample);

    public TemplateInfo selectByPrimaryKey(TemplateInfoKey templateInfoKey);

}

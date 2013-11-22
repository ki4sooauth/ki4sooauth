package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.TemplateInfoGeneratorQueryService;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoKey;
import com.gooagoo.dao.generator.sys.TemplateInfoMapper;

@Service
public class TemplateInfoGeneratorQueryServiceImpl implements TemplateInfoGeneratorQueryService
{

    @Autowired
    private TemplateInfoMapper templateInfoMapper;

    @Override
    public Integer countByExample(TemplateInfoExample templateInfoExample) 
    {
        return this.templateInfoMapper.countByExample(templateInfoExample);
    }

    @Override
    public List<TemplateInfo> selectByExample(TemplateInfoExample templateInfoExample) 
    {
        return this.templateInfoMapper.selectByExample(templateInfoExample);
    }

    @Override
    public TemplateInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        TemplateInfoKey templateInfoKey = new TemplateInfoKey();
        templateInfoKey.setIsDel("N");
        templateInfoKey.setTemplateId(primaryKey);
        return this.templateInfoMapper.selectByPrimaryKey(templateInfoKey);
    }

    @Override
    public TemplateInfo selectByPrimaryKey(String primaryKey) 
    {
        TemplateInfoKey templateInfoKey = new TemplateInfoKey();
        templateInfoKey.setTemplateId(primaryKey);
        return this.templateInfoMapper.selectByPrimaryKey(templateInfoKey);
    }

}

package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.TemplateInfoGeneratorCoreService;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoKey;
import com.gooagoo.dao.generator.sys.TemplateInfoMapper;

@Service
public class TemplateInfoGeneratorCoreServiceImpl implements TemplateInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(TemplateInfoExample templateInfoExample) 
    {
        return this.templateInfoMapper.deleteByExample(templateInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        TemplateInfoKey templateInfoKey = new TemplateInfoKey();
        templateInfoKey.setTemplateId(primaryKey);
        return this.templateInfoMapper.deleteByPrimaryKey(templateInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(TemplateInfoExample templateInfoExample) 
    {
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.setIsDel("Y");
        return this.templateInfoMapper.updateByExampleSelective(templateInfo,templateInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.setTemplateId(primaryKey);
        templateInfo.setIsDel("Y");
        return this.templateInfoMapper.updateByPrimaryKeySelective(templateInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(TemplateInfo templateInfo) 
    {
        return this.templateInfoMapper.insertSelective(templateInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(TemplateInfo templateInfo,TemplateInfoExample templateInfoExample) 
    {
        return this.templateInfoMapper.updateByExampleSelective(templateInfo,templateInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(TemplateInfo templateInfo) 
    {
        return this.templateInfoMapper.updateByPrimaryKeySelective(templateInfo) > 0 ? true : false;
    }

}

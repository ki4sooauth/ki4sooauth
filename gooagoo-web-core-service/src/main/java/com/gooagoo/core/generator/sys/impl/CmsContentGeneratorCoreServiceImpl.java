package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.CmsContentGeneratorCoreService;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.entity.generator.sys.CmsContentKey;
import com.gooagoo.dao.generator.sys.CmsContentMapper;

@Service
public class CmsContentGeneratorCoreServiceImpl implements CmsContentGeneratorCoreService
{

    @Autowired
    private CmsContentMapper cmsContentMapper;

    @Override
    public Integer countByExample(CmsContentExample cmsContentExample) 
    {
        return this.cmsContentMapper.countByExample(cmsContentExample);
    }

    @Override
    public List<CmsContent> selectByExample(CmsContentExample cmsContentExample) 
    {
        return this.cmsContentMapper.selectByExample(cmsContentExample);
    }

    @Override
    public CmsContent selectUnDelByPrimaryKey(String primaryKey) 
    {
        CmsContentKey cmsContentKey = new CmsContentKey();
        cmsContentKey.setIsDel("N");
        cmsContentKey.setCmsContentId(primaryKey);
        return this.cmsContentMapper.selectByPrimaryKey(cmsContentKey);
    }

    @Override
    public CmsContent selectByPrimaryKey(String primaryKey) 
    {
        CmsContentKey cmsContentKey = new CmsContentKey();
        cmsContentKey.setCmsContentId(primaryKey);
        return this.cmsContentMapper.selectByPrimaryKey(cmsContentKey);
    }

    @Override
    public boolean physicalDeleteByExample(CmsContentExample cmsContentExample) 
    {
        return this.cmsContentMapper.deleteByExample(cmsContentExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        CmsContentKey cmsContentKey = new CmsContentKey();
        cmsContentKey.setCmsContentId(primaryKey);
        return this.cmsContentMapper.deleteByPrimaryKey(cmsContentKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(CmsContentExample cmsContentExample) 
    {
        CmsContent cmsContent = new CmsContent();
        cmsContent.setIsDel("Y");
        return this.cmsContentMapper.updateByExampleSelective(cmsContent,cmsContentExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        CmsContent cmsContent = new CmsContent();
        cmsContent.setCmsContentId(primaryKey);
        cmsContent.setIsDel("Y");
        return this.cmsContentMapper.updateByPrimaryKeySelective(cmsContent) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(CmsContent cmsContent) 
    {
        return this.cmsContentMapper.insertSelective(cmsContent) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(CmsContent cmsContent,CmsContentExample cmsContentExample) 
    {
        return this.cmsContentMapper.updateByExampleSelective(cmsContent,cmsContentExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CmsContent cmsContent) 
    {
        return this.cmsContentMapper.updateByPrimaryKeySelective(cmsContent) > 0 ? true : false;
    }

}

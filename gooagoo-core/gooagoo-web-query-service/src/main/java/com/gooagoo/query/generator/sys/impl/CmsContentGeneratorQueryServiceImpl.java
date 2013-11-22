package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.entity.generator.sys.CmsContentKey;
import com.gooagoo.dao.generator.sys.CmsContentMapper;

@Service
public class CmsContentGeneratorQueryServiceImpl implements CmsContentGeneratorQueryService
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

}

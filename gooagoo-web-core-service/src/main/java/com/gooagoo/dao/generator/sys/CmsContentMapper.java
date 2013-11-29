package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.entity.generator.sys.CmsContentKey;

public interface CmsContentMapper
{

    public Integer countByExample(CmsContentExample cmsContentExample);

    public List<CmsContent> selectByExample(CmsContentExample cmsContentExample);

    public CmsContent selectByPrimaryKey(CmsContentKey cmsContentKey);

    public Integer deleteByExample(CmsContentExample cmsContentExample);

    public Integer deleteByPrimaryKey(CmsContentKey cmsContentKey);

    public Integer insertSelective(CmsContent cmsContent);

    public Integer updateAllByExample(@Param("record") CmsContent cmsContent, @Param("example") CmsContentExample cmsContentExample);

    public Integer updateByExampleSelective(@Param("record") CmsContent cmsContent, @Param("example") CmsContentExample cmsContentExample);

    public Integer updateByPrimaryKeySelective(CmsContent cmsContent);

}

package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.entity.generator.sys.CmsContentKey;

public interface CmsContentMapper
{

    public Integer countByExample(CmsContentExample cmsContentExample);

    public List<CmsContent> selectByExample(CmsContentExample cmsContentExample);

    public CmsContent selectByPrimaryKey(CmsContentKey cmsContentKey);

}

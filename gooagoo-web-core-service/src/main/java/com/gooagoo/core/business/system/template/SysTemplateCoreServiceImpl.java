package com.gooagoo.core.business.system.template;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.template.SysTemplateCoreService;
import com.gooagoo.api.generator.core.sys.TemplateInfoGeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;

@Service
public class SysTemplateCoreServiceImpl implements SysTemplateCoreService
{

    @Autowired
    private TemplateInfoGeneratorCoreService templateInfoGeneratorCoreService;

    @Override
    public boolean addTemplateInfo(TemplateInfo templateInfo) throws Exception
    {
        templateInfo.setTemplateId(UUID.getUUID());
        templateInfo.setIsDel("N");
        return this.templateInfoGeneratorCoreService.insertSelective(templateInfo);
    }

    @Override
    public boolean updateTemplateInfo(TemplateInfo templateInfo) throws Exception
    {
        return this.templateInfoGeneratorCoreService.updateByPrimaryKeySelective(templateInfo);
    }

    @Override
    public boolean deleteTemplateInfo(String templateIds) throws Exception
    {
        if (StringUtils.isBlank(templateIds))
        {
            return false;
        }
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.setIsDel("Y");
        List<String> templateIdList = Arrays.asList(templateIds.split(","));
        TemplateInfoExample templateInfoExample = new TemplateInfoExample();
        templateInfoExample.createCriteria().andTemplateIdIn(templateIdList).andIsDelEqualTo("N");
        return this.templateInfoGeneratorCoreService.updateByExampleSelective(templateInfo, templateInfoExample);
    }

}

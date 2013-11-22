package com.gooagoo.api.business.core.system.template;

import com.gooagoo.entity.generator.sys.TemplateInfo;

/**
 * 模板管理-模板信息
 */
public interface SysTemplateCoreService
{

    /**
     * 新增模板信息
     * @param templateInfo 模板信息
     * @return
     * @throws Exception
     */
    public boolean addTemplateInfo(TemplateInfo templateInfo) throws Exception;

    /**
     * 修改模板信息
     * @param templateInfo 模板信息
     * @return
     * @throws Exception
     */
    public boolean updateTemplateInfo(TemplateInfo templateInfo) throws Exception;

    /**
     * 批量删除模板信息
     * @param templateIds 模板信息多个逗号分隔
     * @return
     * @throws Exception
     */
    public boolean deleteTemplateInfo(String templateIds) throws Exception;

}

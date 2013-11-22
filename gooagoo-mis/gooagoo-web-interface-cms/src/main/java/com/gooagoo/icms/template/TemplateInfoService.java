package com.gooagoo.icms.template;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooaoo.view.cms.MTemplateInfo;
import com.gooaoo.view.common.PageModel;

public interface TemplateInfoService
{
    /**
     * 获取模板信息列表 
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MTemplateInfo>> getTemplateInfoList(HttpServletRequest request) throws Exception;

    /**
     * 获取模板详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public MTemplateInfo getTemplateInfo(HttpServletRequest request) throws Exception;
}

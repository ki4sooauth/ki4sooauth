package com.gooagoo.igms.template.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.common.PageModel;
import com.gooagoo.view.gms.common.FNode;

public interface TemplateService
{
    /**
     * 模板列表（FNode.remarks保存模板数据Id）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FNode>> listTemplate(HttpServletRequest request) throws Exception;

}

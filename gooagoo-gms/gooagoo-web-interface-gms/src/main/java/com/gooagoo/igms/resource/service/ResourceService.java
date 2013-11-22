package com.gooagoo.igms.resource.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.view.gms.common.PageModel;

public interface ResourceService
{
    /**
     * 分页查询营销资源历史列表
     * @param entityInfo
     * @return
     */
    public TransData<PageModel<MarketingActivity>> pageEntity(HttpServletRequest request) throws Exception;

}

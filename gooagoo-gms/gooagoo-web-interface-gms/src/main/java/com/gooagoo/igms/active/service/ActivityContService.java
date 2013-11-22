package com.gooagoo.igms.active.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivityContent;

public interface ActivityContService
{
    /**
     * 查询活动内容信息列表
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<List<FActivityContent>> list(HttpServletRequest request) throws Exception;

    /**
     * 查询活动内容渠道列表
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<List<FNode>> listChannel(HttpServletRequest request) throws Exception;

    /**
     * 分页查询活动内容
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FActivityContent>> pageContent(HttpServletRequest request) throws Exception;
}

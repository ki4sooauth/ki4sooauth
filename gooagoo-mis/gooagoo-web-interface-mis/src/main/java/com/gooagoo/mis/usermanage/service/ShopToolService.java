package com.gooagoo.mis.usermanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.enterprise.MShopToolList;

public interface ShopToolService
{

    /**
     * 查询服务工具列表(分页)
     * @param serverToolRequest
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MShopToolList>> searchShopToolList(HttpServletRequest request) throws Exception;

    /**
     * 查询服务工具信息(详细)
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MShopToolList> getShopToolDetail(HttpServletRequest request) throws Exception;

    /**
     * 修改、删除服务工具
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 查询商家详情
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MShopInfo> searchServerToolShopDetail(HttpServletRequest request) throws Exception;

}

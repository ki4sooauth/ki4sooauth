package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FTranspcInfo;

public interface ITranspcInfoService
{
    /**
     * 查询转发器详细信息
     * @param request
     * @return
     */
    public TransData<FTranspcInfo> getTranspcInfo(HttpServletRequest request) throws Exception;

    /**
     * 分页查询转发器信息
     * @param request
     * @return
     */
    public TransData<PageModel<FTranspcInfo>> pageTranspcInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改转发器信息
     * @param request
     */
    public TransData<Object> updateTranspcInfo(HttpServletRequest request) throws Exception;

}

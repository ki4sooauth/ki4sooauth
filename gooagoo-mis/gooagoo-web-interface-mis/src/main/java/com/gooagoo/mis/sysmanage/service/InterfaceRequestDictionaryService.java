package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MInterfaceRequestInfo;

public interface InterfaceRequestDictionaryService
{

    /**
     * 添加接口请求参数信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> addInterfactRequest(HttpServletRequest request) throws Exception;

    /**
     * 修改接口请求参数信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> editInterfactRequest(HttpServletRequest request) throws Exception;

    /**
     * 删除接口请求参数信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> delInterfactRequest(HttpServletRequest request) throws Exception;

    /**
     * 查询接口请求参数信息表详细信息
     * @return
     * @throws Exception
     */
    public TransData<MInterfaceRequestInfo> findInterfactRequestDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询接口请求参数信息表数据
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MInterfaceRequestInfo>> findInterfactRequestAllDict(HttpServletRequest request) throws Exception;

    /**
     * 校验接口编码是否存在
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkIcode(HttpServletRequest request) throws Exception;

    /**
     * 批量新增接口请求参数信息表数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllInterfactRequestDetail(HttpServletRequest request) throws Exception;

}

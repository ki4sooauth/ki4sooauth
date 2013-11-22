package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MInterfaceBaseInfo;

public interface InterfaceBaseDictionaryService
{

    /**
     * 添加接口基础信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> addInterfactBase(HttpServletRequest request) throws Exception;

    /**
     * 修改接口基础信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> editInterfactBase(HttpServletRequest request) throws Exception;

    /**
     * 删除接口基础信息表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> delInterfactBase(HttpServletRequest request) throws Exception;

    /**
     * 查询接口基础信息表详细信息
     * @return
     * @throws Exception
     */
    public TransData<MInterfaceBaseInfo> findInterfactBaseDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询接口基础信息表数据
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MInterfaceBaseInfo>> findInterfactBaseAllDict(HttpServletRequest request) throws Exception;

    /**
     * 批量新增接口基础信息表数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllInterfactBaseDetail(HttpServletRequest request) throws Exception;
    
}

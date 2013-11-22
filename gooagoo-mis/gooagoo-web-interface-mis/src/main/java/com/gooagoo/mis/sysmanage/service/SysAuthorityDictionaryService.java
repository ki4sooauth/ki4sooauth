package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MSysAuthority;

public interface SysAuthorityDictionaryService
{

    /**
     * 添加后台管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> addSysAuthority(HttpServletRequest request) throws Exception;

    /**
     * 修改后台管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> editSysAuthority(HttpServletRequest request) throws Exception;

    /**
     * 删除后台管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> delSysAuthority(HttpServletRequest request) throws Exception;

    /**
     * 查询后台管理权限表详细信息
     * @return
     * @throws Exception
     */
    public TransData<MSysAuthority> findSysAuthorityDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询后台管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MSysAuthority>> findSysAuthorityAllDict(HttpServletRequest request) throws Exception;

    /**
     * 批量新增后台管理权限表数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllSysAuthority(HttpServletRequest request) throws Exception;
    
}

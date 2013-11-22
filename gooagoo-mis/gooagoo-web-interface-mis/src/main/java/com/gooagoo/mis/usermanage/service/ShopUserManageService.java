package com.gooagoo.mis.usermanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.mis.enterprise.MShopRole2;
import com.gooagoo.view.mis.enterprise.MShopUserRole2;

public interface ShopUserManageService
{
    /**
     * 查询商家用户详细
     * @param request
     * @return
     */
    public TransData<MShopUserRole2> queryShopUserManage(HttpServletRequest request) throws Exception;

    /**
     * 查询所有商家角色
     * @param request
     * @return
     */
    public TransData<List<MShopRole2>> queryAssignShopUserManange(HttpServletRequest request) throws Exception;

    /**
     * 分配商家用户角色
     * @param request
     * @return
     */
    public TransData<Object> sssignShopUserManange(HttpServletRequest request) throws Exception;
}

package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopAuthority;

public interface ShopAuthorityDictionaryService
{

    /**
     * 添加商家管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopAuthority(HttpServletRequest request) throws Exception;

    /**
     * 修改商家管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> editShopAuthority(HttpServletRequest request) throws Exception;

    /**
     * 删除商家管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopAuthority(HttpServletRequest request) throws Exception;

    /**
     * 查询商家管理权限表详细信息
     * @return
     * @throws Exception
     */
    public TransData<MShopAuthority> findShopAuthorityDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询商家管理权限表数据
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MShopAuthority>> findShopAuthorityAllDict(HttpServletRequest request) throws Exception;

    /**
     * 批量新增商家管理权限表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllShopAuthority(HttpServletRequest request) throws Exception;
    
}

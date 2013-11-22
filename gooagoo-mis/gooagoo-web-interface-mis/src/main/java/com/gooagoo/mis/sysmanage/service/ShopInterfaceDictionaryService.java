package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopInterfaceName;

public interface ShopInterfaceDictionaryService
{

    /**
     * 添加商家平台界面名称管理字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addShopInterfaceDic(HttpServletRequest request) throws Exception;

    /**
     * 修改商家平台界面名称管理字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editShopInterfaceDic(HttpServletRequest request) throws Exception;

    /**
     * 删除商家平台界面名称管理字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delShopInterfaceDic(HttpServletRequest request) throws Exception;

    /**
     * 查询商家平台界面名称管理字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MShopInterfaceName>> findShopInterfaceDict(HttpServletRequest request) throws Exception;

    /**
     * 查询商家平台界面名称管理字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MShopInterfaceName> findShopInterfaceDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增商家平台界面名称管理字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllShopInterface(HttpServletRequest request) throws Exception;
    
}

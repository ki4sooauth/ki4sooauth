package com.gooagoo.mis.interfmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.merchantInterface.MShopInterfaceInfo;

public interface InterfSysService
{

    /**
     * 创建活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 商家分配接口
     * @return
     */
    public boolean allotShopInterface(String shopId) throws Exception;

    /**
     * 查询商家接口信息列表
     * @param basicInfoRequest
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MShopInterfaceInfo>> searchShopInterfList(HttpServletRequest request) throws Exception;
}

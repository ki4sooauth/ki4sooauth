package com.gooagoo.mis.usermanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceWifisensor;

public interface ShopWifisensorService
{
    /**
     * 查询Wifisensor
     * @param shopId
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MDeviceWifisensor>> searchShopWifisensor(HttpServletRequest request) throws Exception;

    /**
     * 配置Wifisensor
     * @param shopId
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopWifisensor(HttpServletRequest request) throws Exception;

    /**
     * 删除Wifisensor
     * @param shopId
     * @param thransId
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopWifisensor(HttpServletRequest request) throws Exception;

    /**
     * 查询Wifisensor详细
     * @param shopId
     * @return
     * @throws Exception
     */
    public TransData<MDeviceWifisensor> searchShopWifisensorInfo(HttpServletRequest request) throws Exception;

    /**
     * 编辑Wifisensor
     * @param shopId
     * @param thransId
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopWifisensor(HttpServletRequest request) throws Exception;

}

package com.gooagoo.mis.usermanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceAssistant;

public interface ShopAssistantService
{

    /**
     * 查询商家店员助理
     * @param shopId
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MDeviceAssistant>> searchShopAssistant(HttpServletRequest request) throws Exception;

    /**
     * 配置商家店员助理
     * @param shopId
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopAssistant(HttpServletRequest request) throws Exception;

    /**
     * 删除商家店员助理
     * @param shopId
     * @param thransId
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopAssistant(HttpServletRequest request) throws Exception;

    /**
     * 查询商家店员助理详细
     * @param shopId
     * @return
     * @throws Exception
     */
    public TransData<MDeviceAssistant> searchShopAssistantInfo(HttpServletRequest request) throws Exception;

    /**
     * 编辑商家店员助理
     * @param shopId
     * @param thransId
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopAssistant(HttpServletRequest request) throws Exception;

}

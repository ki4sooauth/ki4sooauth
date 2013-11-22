package com.gooagoo.mis.usermanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceTransponder;

public interface TransponderService
{

    /**
     * 查询商家转发器
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MDeviceTransponder>> searchShopTranspc(HttpServletRequest request) throws Exception;

    /**
     * 配置商家转发器
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopTranspc(HttpServletRequest request) throws Exception;

    /**
     * 删除商家转发器
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopTranspc(HttpServletRequest request) throws Exception;

    /**
     * 查询商家转发器详细
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MDeviceTransponder> searchShopTranspcInfo(HttpServletRequest request) throws Exception;

    /**
     * 编辑商家转发器
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopTranspc(HttpServletRequest request) throws Exception;

}

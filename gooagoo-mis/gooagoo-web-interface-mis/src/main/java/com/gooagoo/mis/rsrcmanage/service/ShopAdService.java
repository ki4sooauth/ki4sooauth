package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MShopAd;

public interface ShopAdService
{
    /**
     * 查询所有广告位信息
     * @param request
     * @return
     */
    public TransData<PageModel<MShopAd>> queryAllShopAd(HttpServletRequest request) throws Exception;

    /**
     * 查询广告位信息详细
     * @param request
     * @return
     */
    public TransData<MShopAd> queryShopAd(HttpServletRequest request) throws Exception;

    /**
     * 新增广告位信息
     * @param request
     * @return
     */
    public TransData<Object> addShopAd(HttpServletRequest request) throws Exception;

    /**
     * 编辑广告位信息
     * @param request
     * @return
     */
    public TransData<Object> updateShopAd(HttpServletRequest request) throws Exception;

    /**
     * 删除广告位信息
     * @param request
     * @return
     */
    public TransData<Object> deleteShopAd(HttpServletRequest request) throws Exception;

}

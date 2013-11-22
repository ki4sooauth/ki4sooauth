package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.shopinfo.FShopInfo;

public interface IShopInfoService
{
    /**
     * 查询商家信息 
     * @param request
     * @return
     */
    public TransData<FShopInfo> getShopInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改商家昵称信息
     * @param request
     * @return
     */
    public TransData<Object> updateShopInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取商家登录信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<ShopLoginInfo> getLoginInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改营业状态
     * @param request
     * @return
     */
    public TransData<Object> updateNormalBusiness(HttpServletRequest request) throws Exception;

    /**
     * 修改商家基本信息（修改商家基本信息时，需要校验商家状态（锁定状态才能修改））
     * @param request
     * @return
     */
    public TransData<Object> updateShopInfos(HttpServletRequest request) throws Exception;

}

package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.shopinfo.FHeadPic;

public interface IHeadPicService
{
    /**
     * 获取头像信息
     * @param request
     * @return
     */
    public TransData<FHeadPic> getHeadPic(HttpServletRequest request) throws Exception;

    /**
     * 修改商店铺头像
     * @param request
     * @return
     */
    public TransData<Object> updateSHeadPic(HttpServletRequest request) throws Exception;

    /**
     * 修改账户头像
     * @param request
     * @return
     */
    public TransData<Object> updateUHeadPic(HttpServletRequest request) throws Exception;

}

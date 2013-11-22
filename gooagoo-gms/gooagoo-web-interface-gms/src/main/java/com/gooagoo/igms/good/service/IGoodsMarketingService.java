package com.gooagoo.igms.good.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.good.FGoodsMarketing;

public interface IGoodsMarketingService
{

    /**
     * 添加商品营销信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addGoodsMarkeringInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除商品营销信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delGoodsMarkeringInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改商品营销信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateGoodsMarkeringInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取商品营销信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FGoodsMarketing> getGoodsMarketingInfo(HttpServletRequest request) throws Exception;

}

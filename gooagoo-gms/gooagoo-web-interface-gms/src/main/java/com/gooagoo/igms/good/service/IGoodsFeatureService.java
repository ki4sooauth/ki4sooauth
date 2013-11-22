package com.gooagoo.igms.good.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsFeature;

public interface IGoodsFeatureService
{

    /**
     * 添加商品特征项信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addGoodsFeature(HttpServletRequest request) throws Exception;

    /**
     * 删除商品特征项信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delGoodsFeature(HttpServletRequest request) throws Exception;

    /**
     * 修改商品特征项信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateGoodsFeature(HttpServletRequest request) throws Exception;

    /**
     * 获取商品特征项信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FGoodsFeature> getGoodsFeature(HttpServletRequest request) throws Exception;

    /**
     * 获取商品特征项信息列
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FGoodsFeature>> getGoodsFeatureList(HttpServletRequest request) throws Exception;
}

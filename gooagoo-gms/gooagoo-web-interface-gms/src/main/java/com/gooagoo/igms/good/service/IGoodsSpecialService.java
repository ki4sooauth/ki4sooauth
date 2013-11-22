package com.gooagoo.igms.good.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.good.FGoodsSpecial;

public interface IGoodsSpecialService
{

    /**
     * 添加商品特征信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addGoodsSpecialInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除商品特征信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delGoodsSpecialInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改商品特征信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateGoodsSpecialInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取商品特征信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FGoodsSpecial> getGoodsSpecialInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取商品特征信息列
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FGoodsSpecial>> getGoodsSpecialInfoList(HttpServletRequest request) throws Exception;
}

package com.gooagoo.igms.good.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;

public interface IGoodsService
{
    /**
     * 添加商品信息
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<String> addGoods(HttpServletRequest request) throws Exception;

    /** 
     * 修改商品信息
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<Object> updateGoods(HttpServletRequest request) throws Exception;

    /**
     * 删除商品信息
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<Object> delGoods(HttpServletRequest request) throws Exception;

    /** 
     * 根据商品Id查询商品信息
     * @param goodsId
     * @return
     * @throws Exception 
     */
    public TransData<FGoods> getGoods(HttpServletRequest request) throws Exception;

    /**
     * 获取商品信息的分页数列
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FGoods>> getGoodsPage(HttpServletRequest request) throws Exception;

    /**
     * 验证商品序列号是否唯一
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<List<FGoods>> goodsSerialIsExist(HttpServletRequest request) throws Exception;

    /**
     * 验证商品单品序列号是否唯一
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<List<FGoods>> itemSerialIsExist(HttpServletRequest request) throws Exception;

    /**
     * 传入一列商品主键，获取一列商品信息
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<List<FGoods>> getGoodsList(HttpServletRequest request) throws Exception;

    /**
     * 审核商品
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> reviewedGoods(HttpServletRequest request) throws Exception;

    /**
     * 发布商品
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> publishGoods(HttpServletRequest request) throws Exception;

}

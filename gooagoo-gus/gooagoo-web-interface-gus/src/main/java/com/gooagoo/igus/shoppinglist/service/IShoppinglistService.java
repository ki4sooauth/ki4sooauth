package com.gooagoo.igus.shoppinglist.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IShoppinglistService {

	/**
     * 添加购物清单
     * @param addShoppingList
     * @return
     */
    public TransData<Object> addShoppinglist(HttpServletRequest request);

    /**
     * 获取购物清单列表
     * @param request
     * @return
     */
    public TransData<Object> getShoppinglistList(HttpServletRequest request);

    /**
     * 获取购物清单详情
     * @param request
     * @return
     */
    public TransData<Object> getShoppinglistInfo(HttpServletRequest request);

    /**
     * 查询购物清单商品
     * @param request
     * @return
     */
    public TransData<Object> getShoppinglistGoods(HttpServletRequest request);

    /**
     * 获取购物清单商品类型列表
     * @param request
     * @return
     */
    public TransData<Object> getShoppinglistGoodsTypeList(HttpServletRequest request);

    /**
     *  加入购物清单
     * @param request
     * @return
     */
    public TransData<Object> addToShoppinglist(HttpServletRequest request);

    /**
     * 删除购物清单商品
     * @param request
     * @return
     */
    public TransData<Object> deleteShoppinglistGoods(HttpServletRequest request);

    /**
     *  编辑购物清单
     * @param request
     * @return
     */
    public TransData<Object> updateShoppinglist(HttpServletRequest request);

    /**
     * 删除物清单
     * @param request
     * @return
     */
    public TransData<Object> deleteShoppinglist(HttpServletRequest request);
}

package com.gooagoo.igus.shoppinglist.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface IPurchasedGoodsService
{

	/**
	 * 查询已购商品列表
	 * @param request
	 * @return
	 */
    public TransData<Object> getPurchasedGoodsList(HttpServletRequest request);
    
    /**
     *  加入购物清单
     * @param request
     * @return
     */
    public TransData<Object> addToShoppinglist(HttpServletRequest request);
    
    

}

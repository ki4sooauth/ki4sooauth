package com.gooagoo.igus.bill.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface IElectricBillService
{

    /**
     * 获取电子账单列表
     * @param request
     * @return
     */
    public TransData<Object> getElectricBillList(HttpServletRequest request);

    /**
     * 收藏商品
     * @param request
     * @return
     */
    public TransData<Object> favoriteGoods(HttpServletRequest request);

    /**
     * 加入购物清单
     * @param request
     * @return
     */
    public TransData<Object> addToShoppinglist(HttpServletRequest request);

    /**
     * 评论商品
     * @param request
     * @return
     */
    public TransData<Object> commentGoods(HttpServletRequest request);

    /**
     * 删除电子账单
     * @param request
     * @return
     */
    public TransData<Object> deleteElectricBill(HttpServletRequest request);


    /**
     * 获取电子账单详细
     * @param request
     * @return
     */
    public TransData<Object> getElectricBillDetail(HttpServletRequest request);

}

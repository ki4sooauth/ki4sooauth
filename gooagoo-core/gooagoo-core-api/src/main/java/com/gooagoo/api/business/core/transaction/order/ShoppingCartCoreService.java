package com.gooagoo.api.business.core.transaction.order;

import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.exception.business.bill.AlreadyAddShoppingCartException;

/**
 * 购物车管理
 */
public interface ShoppingCartCoreService
{

    /**
     * 添加购物车信息
     * @param shoppingCart
     * @return 购物车已存在此商品Y,购物车不存在此商品N
     * @throws AlreadyAddShoppingCartException 已添加购物车异常
     */
    public String addShoppingCart(ShoppingCart shoppingCart) throws Exception;

    /**
     * 编辑购物车信息
     * @param shoppingCart
     * @return
     * @throws Exception
     */
    public boolean editeShoppingCart(ShoppingCart shoppingCart) throws Exception;

    /**
     * 批量删除购物车信息(软删)
     * @param ids 购物车主键编号(多个逗号分隔)
     * @return
     * @throws Exception
     */
    public boolean batchDeleteShoppingCart(String ids) throws Exception;

}

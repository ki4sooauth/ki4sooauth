package com.gooagoo.api.business.query.transaction.order;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShoppingCart;

/**
 * 购物车管理
 */
public interface ShoppingCartQueryService
{

    /**
     * 查询用户在指定实体店的购物车信息
     * @param userId 用户编号
     * @param shopEntityId 实体店编号
     * @return
     * @throws Exception
     */
    public List<ShoppingCart> findShoppingCart(String userId, String shopEntityId) throws Exception;
}

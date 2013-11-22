package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobn04.transform.QueryGoodsOfShoppingCartRoot;

/**
 * 手机购物车服务
 */
public interface ShoppingCartMobileService
{

    /**
     * MOBN01:添加商品到购物车
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param goodsId 商品编号
     * @param shopId 商家编号
     * @param shopEnityId 实体店编号
     * @param goodsNum 商品数量
     * @return Y-表示添加的商品已经在购物车中存在 N-表示添加的商品不在购物车中
     * @throws Exception
     */
    public String addGoodsToShoppingCart(String userId, String sessionId, String goodsId, String shopId, String shopEnityId, String goodsNum) throws Exception;

    /**
     * MOBN02:编辑购物车中商品信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shoppingCartId 购物车编号,多个以逗号分隔,uuid,购物车表主键
     * @param goodsNum 商品数量
     * @return
     * @throws Exception
     */
    public void editGoodsOfShoppingCart(String userId, String sessionId, String shoppingCartId, String goodsNum) throws Exception;

    /**
     * MOBN03:删除购物车中的商品信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shoppingCartId 购物车编号,多个以逗号分隔,uuid,购物车表主键
     * @return
     * @throws Exception
     */
    public void delGoodsOfShoppingCartRoot(String userId, String sessionId, String shoppingCartId) throws Exception;

    /**
     * MOBN04:查询购物车中的商品信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopEnityId 实体店编号
     * @return
     * @throws Exception
     */
    public QueryGoodsOfShoppingCartRoot queryGoodsOfShoppingCart(String userId, String sessionId, String shopEnityId) throws Exception;

}

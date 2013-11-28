package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobn04.transform.QueryGoodsOfShoppingCartRoot;
import com.gooagoo.mobile.entity.mobn05.transform.PurchaseGoodsRankRoot;

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
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public QueryGoodsOfShoppingCartRoot queryGoodsOfShoppingCart(String userId, String sessionId, String shopEnityId, String shopId) throws Exception;

    /**
     * MOBN05:查询用户购过商品次数排行
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopEnityId 实体店编号
     * @return
     * @throws Exception
     */
    public PurchaseGoodsRankRoot purchaseGoodsRankRoot(String userId, String sessionId, String shopEnityId) throws Exception;

    /**
     * MOBN06:将指定账单中的商品重新加入购物车
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderid 订单编号
     * @return
     * @throws Exception
     */
    public void againBuyRoot(String userId, String sessionId, String orderId) throws Exception;

}

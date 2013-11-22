package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.transaction.order.ShoppingCartCoreService;
import com.gooagoo.api.business.query.transaction.order.ShoppingCartQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ShoppingCartMobileService;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobn04.transform.Goodsinfolist;
import com.gooagoo.mobile.entity.mobn04.transform.QueryGoodsOfShoppingCartRoot;

@Service
public class ShoppingCartMobileServiceImpl implements ShoppingCartMobileService
{
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private ShoppingCartCoreService shoppingCartCoreService;
    @Autowired
    private ShoppingCartQueryService shoppingCartQueryService;

    @Override
    public String addGoodsToShoppingCart(String userId, String sessionId, String goodsId, String shopId, String shopEnityId, String goodsNum) throws Exception
    {
        GooagooLog.info("addGoodsToShoppingCart-->入参:userId=" + userId + ",sessionId=" + sessionId + ",goodsId=" + goodsId + ",shopId=" + shopId + ",shopEnityId=" + shopEnityId + ",goodsNum=" + goodsNum);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setGoodsId(goodsId);
        shoppingCart.setShopId(shopId);
        shoppingCart.setShopEntityId(shopEnityId);
        shoppingCart.setGoodsNum(Integer.valueOf(goodsNum));
        return this.shoppingCartCoreService.addShoppingCart(shoppingCart);
    }

    @Override
    public void editGoodsOfShoppingCart(String userId, String sessionId, String shoppingCartId, String goodsNum) throws Exception
    {
        GooagooLog.info("editGoodsOfShoppingCart-->入参:userId=" + userId + ",sessionId=" + sessionId + ",goodsNum=" + goodsNum + ",shoppingCartId=" + shoppingCartId);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setGoodsNum(Integer.valueOf(goodsNum));
        shoppingCart.setId(shoppingCartId);
        if (!this.shoppingCartCoreService.editeShoppingCart(shoppingCart))
        {
            GooagooLog.warn("编辑购物车中的商品失败");
            throw new MessageException(MessageConst.MOBILE_SHOPPINGCART_EDIT_GOODS_FAIL);
        }
    }

    @Override
    public void delGoodsOfShoppingCartRoot(String userId, String sessionId, String shoppingCartId) throws Exception
    {
        GooagooLog.info("delGoodsOfShoppingCartRoot-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shoppingCartId=" + shoppingCartId);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        if (!this.shoppingCartCoreService.batchDeleteShoppingCart(shoppingCartId))
        {
            GooagooLog.warn("删除购物车中的商品失败");
            throw new MessageException(MessageConst.MOBILE_SHOPPINGCART_DEL_GOODS_FAIL);
        }
    }

    @Override
    public QueryGoodsOfShoppingCartRoot queryGoodsOfShoppingCart(String userId, String sessionId, String shopEnityId) throws Exception
    {
        GooagooLog.info("queryGoodsOfShoppingCart-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEnityId=" + shopEnityId);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        List<ShoppingCart> shoppingCartList = this.shoppingCartQueryService.findShoppingCart(userId, shopEnityId);
        List<Goodsinfolist> goodsinfolist = null;
        if (CollectionUtils.isNotEmpty(shoppingCartList))
        {
            goodsinfolist = new ArrayList<Goodsinfolist>();
            for (ShoppingCart t : shoppingCartList)
            {
                Goodsinfolist goodsinfo = new Goodsinfolist();
                goodsinfo.setGoodsid(t.getGoodsId());
                goodsinfo.setGoodsimg(t.getGoodsImg());
                goodsinfo.setGoodsname(t.getGoodsName());
                goodsinfo.setItemserial(t.getItemSerial());
                goodsinfo.setPrice(t.getPrice() != null ? t.getPrice().toString() : "0.00");
                goodsinfo.setShopenityid(t.getShopEntityId());
                goodsinfo.setShopid(t.getShopId());
                goodsinfo.setShoppingcartid(t.getId());
                goodsinfo.setIntroduceurl(UrlUtils.getGoodsMobileUrl(t.getGoodsId()));
                goodsinfo.setGoodsnum(t.getGoodsNum() != null ? String.valueOf(t.getGoodsNum()) : "0");
                goodsinfo.setGoodsmarketingurl("http://event.gooagoo.com/189B29FMEKBL4L00A1BAQJMEPLUP20K2.htm");//192.168.3.204
                //goodsinfo.setGoodsmarketingurl("http://event.gooagoo.com/189B2HI8KFI4H300A1BAQJA6N5NDK9LV.html");//192.168.7.204
                goodsinfolist.add(goodsinfo);
            }
        }
        QueryGoodsOfShoppingCartRoot root = new QueryGoodsOfShoppingCartRoot();
        root.setGoodsinfolist(goodsinfolist);
        return root;
    }
}

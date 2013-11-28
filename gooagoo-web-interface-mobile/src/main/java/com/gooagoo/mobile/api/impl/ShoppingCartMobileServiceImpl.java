package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.order.ShoppingCartCoreService;
import com.gooagoo.api.business.query.transaction.order.ShoppingCartQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.transaction.BoughtgoodsrankinfoBusiness;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ShoppingCartMobileService;
import com.gooagoo.mobile.common.HttpClientUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.common.UrlConst;
import com.gooagoo.mobile.entity.mobn04.transform.Goodsinfolist;
import com.gooagoo.mobile.entity.mobn04.transform.QueryGoodsOfShoppingCartRoot;
import com.gooagoo.mobile.entity.mobn05.transform.Boughtgoodsrankinfo;
import com.gooagoo.mobile.entity.mobn05.transform.PurchaseGoodsRankRoot;

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
    public QueryGoodsOfShoppingCartRoot queryGoodsOfShoppingCart(String userId, String sessionId, String shopEnityId, String shopId) throws Exception
    {
        GooagooLog.info("queryGoodsOfShoppingCart-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEnityId=" + shopEnityId + ",shopId=" + shopId);
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
                String marketingUrl = this.getMarketingUrl(shopId, userId, t.getGoodsId());
                goodsinfo.setGoodsmarketingurl(StringUtils.hasText(marketingUrl) ? marketingUrl : "");
                goodsinfolist.add(goodsinfo);
            }
        }
        QueryGoodsOfShoppingCartRoot root = new QueryGoodsOfShoppingCartRoot();
        root.setGoodsinfolist(goodsinfolist);
        return root;
    }

    /**
     * 获取商品营销url (惠信息来源)
     * @param shopId 商品编号
     * @param userId 用户编号
     * @param goodsId 商品编号
     * @return
     * @throws Exception
     */
    private String getMarketingUrl(String shopId, String userId, String goodsId) throws Exception
    {
        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId(shopId);
        behaveLog.setUserId(userId);
        behaveLog.setBehaveType("A");
        behaveLog.setBehaveTime(new Date());
        behaveLog.setObjectValue("18");
        behaveLog.setDetail(goodsId);
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
        message.setUuid(UUID.getUUID());
        message.setBehaveType("A");
        message.setBehaveCode("mobh06");
        message.setFlag(true);
        message.setSource("1");//手机
        message.setContent(behaveLog);
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("behave", JsonUtils.toJson(message)));
        return HttpClientUtils.HttpPost(UrlConst.ANALYSIS_URL, paramlist);
    }

    @Override
    public PurchaseGoodsRankRoot purchaseGoodsRankRoot(String userId, String sessionId, String shopEnityId) throws Exception
    {
        GooagooLog.info("purchaseGoodsRankRoot-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEnityId=" + shopEnityId);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        List<BoughtgoodsrankinfoBusiness> infoList = this.shoppingCartQueryService.PurchaseGoodsRank(userId, shopEnityId, null, null);
        List<Boughtgoodsrankinfo> boughtgoodsrankinfoList = null;
        if (CollectionUtils.isNotEmpty(infoList))
        {
            boughtgoodsrankinfoList = new ArrayList<Boughtgoodsrankinfo>();
            for (BoughtgoodsrankinfoBusiness t : infoList)
            {
                Boughtgoodsrankinfo boughtgoodsrankinfo = new Boughtgoodsrankinfo();
                boughtgoodsrankinfo.setGoodsid(t.getGoodsid());
                boughtgoodsrankinfo.setGoodsimg(t.getGoodsimg());
                boughtgoodsrankinfo.setGoodsname(t.getGoodsname());
                boughtgoodsrankinfo.setIntroduceurl(UrlUtils.getGoodsMobileUrl(t.getGoodsid()));
                boughtgoodsrankinfo.setPrice(t.getPrice());
                boughtgoodsrankinfo.setBuycount(t.getBuyCount());//购过次数排行
                boughtgoodsrankinfo.setShopentityid(t.getShopentityid());
                boughtgoodsrankinfo.setShopname(t.getShopname());
                boughtgoodsrankinfoList.add(boughtgoodsrankinfo);
            }
        }

        PurchaseGoodsRankRoot root = new PurchaseGoodsRankRoot();
        root.setBoughtgoodsrankinfo(boughtgoodsrankinfoList);
        return root;
    }

    @Override
    public void againBuyRoot(String userId, String sessionId, String orderId) throws Exception
    {
        GooagooLog.info("againBuyRoot-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId);
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        if (!this.shoppingCartCoreService.anewAddShoppingCart(userId, orderId))
        {
            GooagooLog.info("对结账的订单中的所有商品再次购买，把购买过的商品加入到购物车中失败");
            throw new GooagooException("对结账的订单中的所有商品再次购买，把购买过的商品加入到购物车中失败");
        }
    }
}

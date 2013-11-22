package com.gooagoo.igus.cryout.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.business.query.marketing.cryout.CryoutQueryService;
import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfo;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.cryout.service.ICryoutPlazaService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.common.Image;
import com.gooagoo.view.gus.web.cryout.UCryout;
import com.gooagoo.view.gus.web.cryout.UCryoutInfo;
import com.google.gson.Gson;

@Service("iCryoutPlazaService")
public class ICryoutPlazaServiceImpl implements ICryoutPlazaService
{

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private CryoutQueryService cryoutQueryService;

    @Autowired
    private SysCmsContentQueryService sysCmsContentQueryService;

    @Override
    @BehaveAnnotation(InterGusConstants.CRYOUT_CRYOUTPLAZA_GETCRYOUTLIST)
    public TransData<Object> getCryoutList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String pageId = ServletRequestUtils.getStringParameter(request, "pageId");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            String pageType = ServletRequestUtils.getStringParameter(request, "pageType");
            if (StringUtils.isBlank(shopId))
            {
                shopId = null;
            }
            if (StringUtils.isBlank(pageId))
            {
                pageId = null;
            }
            ShopCryoutInfoBusiness shopCryoutInfoBusiness = this.cryoutQueryService.findCryoutList("W", userId, shopId, "A", null, pageId, pageType, pageSize, "");
            if (shopCryoutInfoBusiness == null || CollectionUtils.isEmpty(shopCryoutInfoBusiness.getShopCryoutInfoList()))
            {
                GooagooLog.info("获取吆喝列表：没有查到吆喝信息");
                return new TransData<Object>(true, MessageConst.CRYOUT_ICRYOUT_GETCRYOUTLIST_NOTEXIST, null);
            }
            UCryoutInfo ucryoutInfo = new UCryoutInfo();
            List<UCryout> ucryoutList = new ArrayList<UCryout>();
            for (ShopCryoutInfo shopCryoutInfo : shopCryoutInfoBusiness.getShopCryoutInfoList())
            {
                try
                {
                    UCryout ucryout = new UCryout();
                    String shopVisitUrl = this.sysCmsContentQueryService.getCmsContentUrl(shopCryoutInfo.getShopid(), "W");
                    String visitUrl = null;
                    Image cryoutImage = null;
                    if ("C".equals(shopCryoutInfo.getMarketinglinktype()) || "A".equals(shopCryoutInfo.getMarketinglinktype()) || "G".equals(shopCryoutInfo.getMarketinglinktype()))
                    {
                        if ("C".equals(shopCryoutInfo.getMarketinglinktype()))
                        {
                            visitUrl = UrlUtils.getCouponUrl(shopCryoutInfo.getMarketinglinkid(), shopCryoutInfo.getCryoutid());
                        }
                        else if ("A".equals(shopCryoutInfo.getMarketinglinktype()))
                        {
                            visitUrl = UrlUtils.getActiveUrl(shopCryoutInfo.getMarketinglinkid(), shopCryoutInfo.getCryoutid());
                        }
                        else if ("G".equals(shopCryoutInfo.getMarketinglinktype()))
                        {
                            visitUrl = UrlUtils.getGoodsUrl(shopCryoutInfo.getMarketinglinkid(), shopCryoutInfo.getCryoutid());
                        }
                        cryoutImage = FormatDataUtils.formatImageInfo(shopCryoutInfo.getOriginalpic());
                    }
                    ucryout.setHeadPic(FormatDataUtils.formatImageInfo(shopCryoutInfo.getLogo().split(",")[0]));
                    ucryout.setCryoutId(shopCryoutInfo.getCryoutid());
                    ucryout.setCryoutContent(shopCryoutInfo.getCryouttextweb());
                    ucryout.setShopId(shopCryoutInfo.getShopid());
                    ucryout.setPageId(shopCryoutInfo.getPageId());
                    ucryout.setShopName(shopCryoutInfo.getShopname());
                    ucryout.setCryoutImage(cryoutImage);
                    ucryout.setShopVisitUrl(shopVisitUrl);
                    ucryout.setCryoutTitle(shopCryoutInfo.getCryouttitle());
                    ucryout.setCryoutContentType(shopCryoutInfo.getMarketinglinktype());
                    ucryout.setCryoutContentTypeId(shopCryoutInfo.getMarketinglinkid());
                    ucryout.setContentVisitUrl(visitUrl);
                    ucryout.setCryoutTime(TimeUtils.convertStringToDate(shopCryoutInfo.getPushTime()));
                    ucryout.setUserLinkId(shopCryoutInfo.getCryoutUserId());
                    ucryoutList.add(ucryout);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取吆喝列表：组装单个吆喝信息异常", e);
                }
            }
            ucryoutInfo.setCryoutList(ucryoutList);
            ucryoutInfo.setCryoutType("1");
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucryoutInfo);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取吆喝列表：获取吆喝列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.CRYOUT_CRYOUTPLAZA_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            ShoppingPlanGoods goodlist = new ShoppingPlanGoods();
            goodlist.setGoodsId(ServletRequestUtils.getStringParameter(request, "goodsId"));
            goodlist.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            goodlist.setShopName(ServletRequestUtils.getStringParameter(request, "shopName"));
            shoppingPlanGoodsList.add(goodlist);
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("吆喝商品加入购物清单：吆喝商品加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
                return new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_SUCCESS, null);
        }
        catch (NoShoppingPlanException e)
        {
            GooagooLog.error("吆喝商品加入购物清单：没有数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("吆喝商品加入购物清单：吆喝商品加入购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String marketingId = ServletRequestUtils.getStringParameter(request, "cryoutInfoId");
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setInfoUrl(UrlUtils.getGoodsUrl(goodsId, marketingId));
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏吆喝关联商品：收藏吆喝关联商品失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏吆喝关联商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏吆喝关联商品：收藏吆喝关联商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEACTIVE)
    public TransData<Object> favoriteActive(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String marketingId = ServletRequestUtils.getStringParameter(request, "cryoutInfoId");
            String activeId = ServletRequestUtils.getStringParameter(request, "activityId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setInfoUrl(UrlUtils.getActiveUrl(activeId, marketingId));
            favoriteInfo.setInfoType("A");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏吆喝关联活动：收藏吆喝关联活动失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEACTIVITY_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏吆喝关联活动：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏吆喝关联活动：收藏吆喝关联活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITECOUPON)
    public TransData<Object> favoriteCoupon(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String marketingId = ServletRequestUtils.getStringParameter(request, "cryoutInfoId");
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");
            favoriteInfo.setInfoUrl(UrlUtils.getCouponUrl(couponId, marketingId));
            favoriteInfo.setInfoType("C");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏吆喝关联优惠凭证：收藏吆喝关联优惠凭证失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏吆喝关联优惠凭证：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("收藏商品：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("收藏商品：已超过用户拥有优惠券最大个数异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏吆喝关联优惠凭证：收藏吆喝关联优惠凭证异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }

        return transData;
    }

}

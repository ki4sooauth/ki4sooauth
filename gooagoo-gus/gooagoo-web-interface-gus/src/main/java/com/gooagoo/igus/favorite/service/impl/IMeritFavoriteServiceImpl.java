package com.gooagoo.igus.favorite.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.query.user.favorite.FavoritePlaceQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.user.FavoritePlace;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.igus.favorite.service.IMeritFavoriteService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.favorite.UFavoritePlaceActivity;
import com.gooagoo.view.gus.web.favorite.UFavoritePlaceCoupon;
import com.gooagoo.view.gus.web.favorite.UFavoritePlaceGoods;

@Service("iMeritFavoriteService")
public class IMeritFavoriteServiceImpl implements IMeritFavoriteService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private FavoritePlaceQueryService favoritePlaceQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITEGOODSLIST)
    public TransData<Object> getMeritFavoriteGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
            List<FavoritePlace> favoritePlaceList = this.favoritePlaceQueryService.findFavoritePlace(userId, null, null, null, "G", pageIndex, pageSize);
            if (CollectionUtils.isEmpty(favoritePlaceList))
            {
                GooagooLog.info("查询值得收藏商品列表：查询值得收藏商品为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IMERITFAVORITE_NOTEXIST, null);
            }
            List<UFavoritePlaceGoods> ufavoritePlaceGoodsList = new ArrayList<UFavoritePlaceGoods>();
            for (FavoritePlace favoritePlace : favoritePlaceList)
            {
                try
                {
                    UFavoritePlaceGoods ufavoritePlaceGoods = new UFavoritePlaceGoods();
                    ufavoritePlaceGoods.setGoodsId(favoritePlace.getObjId());
                    ufavoritePlaceGoods.setGoodsName(favoritePlace.getObjName());
                    ufavoritePlaceGoods.setGoodsimg(FormatDataUtils.formatImageInfo(favoritePlace.getObjImg()));
                    ufavoritePlaceGoods.setShopId(favoritePlace.getShopId());
                    ufavoritePlaceGoods.setShopName(favoritePlace.getShopName());
                    ufavoritePlaceGoods.setGoodsUrl(UrlUtils.getGoodsUrl(favoritePlace.getObjId()));
                    ufavoritePlaceGoodsList.add(ufavoritePlaceGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询值得收藏商品列表：组装单个商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ufavoritePlaceGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询值得收藏商品列表:查询可收藏商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITEACTIVITYLIST)
    public TransData<Object> getMeritFavoriteActivityList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
            List<FavoritePlace> favoritePlaceList = this.favoritePlaceQueryService.findFavoritePlace(userId, null, null, null, "A", pageIndex, pageSize);
            if (CollectionUtils.isEmpty(favoritePlaceList))
            {
                GooagooLog.info("查询值得收藏活动列表：查询值得收藏活动为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IMERITFAVORITE_NOTEXIST, null);
            }
            List<UFavoritePlaceActivity> ufavoritePlaceActivityList = new ArrayList<UFavoritePlaceActivity>();
            for (FavoritePlace favoritePlace : favoritePlaceList)
            {
                try
                {
                    UFavoritePlaceActivity ufavoritePlaceActivity = new UFavoritePlaceActivity();
                    ufavoritePlaceActivity.setActivityId(favoritePlace.getObjId());
                    ufavoritePlaceActivity.setActivityName(favoritePlace.getObjName());
                    ufavoritePlaceActivity.setImgUrl(FormatDataUtils.formatImageInfo(favoritePlace.getObjImg()));
                    ufavoritePlaceActivity.setShopId(favoritePlace.getShopId());
                    ufavoritePlaceActivity.setShopName(favoritePlace.getShopName());
                    ufavoritePlaceActivity.setActivityUrl(UrlUtils.getActiveUrl(favoritePlace.getObjId()));
                    ufavoritePlaceActivityList.add(ufavoritePlaceActivity);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询值得收藏活动列表：组装单个活动信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ufavoritePlaceActivityList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询值得收藏活动列表:查询可收藏活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITECOUPONLIST)
    public TransData<Object> getMeritfavoriteCouponList(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
            List<FavoritePlace> favoritePlaceList = this.favoritePlaceQueryService.findFavoritePlace(userId, null, null, null, "C", pageIndex, pageSize);
            if (CollectionUtils.isEmpty(favoritePlaceList))
            {
                GooagooLog.info("查询值得收藏优惠凭证列表：查询值得收藏优惠凭证为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IMERITFAVORITE_NOTEXIST, null);
            }
            List<UFavoritePlaceCoupon> ufavoritePlaceCouponList = new ArrayList<UFavoritePlaceCoupon>();
            for (FavoritePlace favoritePlace : favoritePlaceList)
            {
                try
                {
                    UFavoritePlaceCoupon ufavoritePlaceCoupon = new UFavoritePlaceCoupon();
                    ufavoritePlaceCoupon.setCouponId(favoritePlace.getObjId());
                    ufavoritePlaceCoupon.setCouponName(favoritePlace.getObjName());
                    ufavoritePlaceCoupon.setCouponimg(FormatDataUtils.formatImageInfo(favoritePlace.getObjImg()));
                    ufavoritePlaceCoupon.setShopId(favoritePlace.getShopId());
                    ufavoritePlaceCoupon.setShopName(favoritePlace.getShopName());
                    ufavoritePlaceCoupon.setCouponUrl(UrlUtils.getCouponUrl(favoritePlace.getObjId()));
                    ufavoritePlaceCouponList.add(ufavoritePlaceCoupon);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询值得收藏优惠凭证列表：组装单个优惠凭证信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ufavoritePlaceCouponList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询值得收藏优惠凭证列表:查询可收藏优惠凭证异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @BehaveAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setObjectId(goodsId);
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏商品：收藏商品失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }

        catch (Exception e)
        {
            GooagooLog.error("收藏商品:收藏商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEACTIVITY)
    public TransData<Object> favoriteActivity(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activityId = ServletRequestUtils.getStringParameter(request, "activityId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setObjectId(activityId);
            favoriteInfo.setInfoType("A");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏活动：收藏活动失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEACTIVITY_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏活动：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏活动:收藏活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
        }
        return transData;

    }

    @Override
    @BehaveAnnotation(InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITECOUPON)
    public TransData<Object> favoriteCoupon(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setObjectId(couponId);
            favoriteInfo.setInfoType("C");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏优惠凭证：收藏优惠凭证失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏优惠凭证：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("收藏优惠凭证：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("收藏优惠凭证：已超过用户拥有优惠券最大个数异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_PASSUSERNUM, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏优惠凭证:收藏优惠凭证异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }
        return transData;

    }

}

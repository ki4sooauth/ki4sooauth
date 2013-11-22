package com.gooagoo.igus.coupon.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
import com.gooagoo.entity.business.user.FavoritePlace;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.igus.coupon.service.ICouponService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.coupon.UCoupon;

@Service("iCouponService")
public class ICouponServiceImpl implements ICouponService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private FavoritePlaceQueryService favoritePlaceQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COUPON_GETCOUPONLIST)
    public TransData<Object> getCouponList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            if (StringUtils.isBlank(shopId))
            {
                shopId = null;
            }
            String couponType = ServletRequestUtils.getStringParameter(request, "couponType");
            if (StringUtils.isBlank(couponType))
            {
                couponType = null;
            }
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            List<FavoritePlace> favoritePlacelist = this.favoritePlaceQueryService.findFavoritePlace(userId, shopId, couponType, null, "C", pageIndex, pageSize);
            if (CollectionUtils.isEmpty(favoritePlacelist))
            {
                GooagooLog.info("获取优惠凭证列表：没有查到优惠凭证信息");
                return new TransData<Object>(true, MessageConst.COUPON_ICOUPON_GETCOUPONLIST_NOTEXIST, null);
            }
            List<UCoupon> ucouponList = new ArrayList<UCoupon>();
            for (FavoritePlace favoritePlace : favoritePlacelist)
            {
                try
                {
                    UCoupon ucoupon = new UCoupon();
                    ucoupon.setCouponId(favoritePlace.getObjId());
                    ucoupon.setCouponName(favoritePlace.getObjName());
                    ucoupon.setCouponUrl(FormatDataUtils.formatImageInfo(favoritePlace.getObjImg()));
                    ucoupon.setShopId(favoritePlace.getShopId());
                    ucoupon.setShopName(favoritePlace.getShopName());
                    ucoupon.setVisitUrl(favoritePlace.getLinkUrl());
                    ucouponList.add(ucoupon);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取优惠凭证列表：组装单个优惠凭证信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucouponList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取优惠凭证列表：获取优惠凭证列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.COUPON_FAVORITECOUPON)
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
                GooagooLog.info("收藏优惠信息：收藏优惠失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error("收藏优惠信息：操作失败异常", e);
            transData = new TransData<Object>(false, MessageConst.MOBILE_IMOBILEMERCHANT_GETCOUPONDATA_NOTEXIST, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("收藏优惠信息：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("收藏优惠信息：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏优惠信息：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏优惠信息：收藏失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }
        return transData;
    }
}

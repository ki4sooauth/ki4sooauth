package com.gooagoo.igus.merchant.mobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.query.goods.statistical.StatisticalQueryService;
import com.gooagoo.api.business.query.marketing.coupon.CouponQueryService;
import com.gooagoo.api.business.query.marketing.shopintegral.ShopIntegralQueryService;
import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CommentsStatisticQueryService;
import com.gooagoo.api.business.query.user.comment.CommentQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.cache.AreaCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;
import com.gooagoo.entity.business.marketing.CouponDetail;
import com.gooagoo.entity.business.marketing.TradeRequest;
import com.gooagoo.entity.business.marketing.TradeResponse;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.exception.business.integral.IntegralNotEnoughException;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.igus.merchant.mobile.service.IMobileMerchantService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.merchant.mobile.UActive;
import com.gooagoo.view.gus.web.merchant.mobile.UComment;
import com.gooagoo.view.gus.web.merchant.mobile.UConsigeeInfo;
import com.gooagoo.view.gus.web.merchant.mobile.UCoupon;
import com.gooagoo.view.gus.web.merchant.mobile.UGoods;
import com.gooagoo.view.gus.web.merchant.mobile.UMall;
import com.gooagoo.view.gus.web.merchant.mobile.UPositionMarketingRank;

@Service("iMobileMerchantService")
public class IMobileMerchantServiceImpl implements IMobileMerchantService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private IntegralCoreService integralCoreService;

    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoService;

    @Autowired
    private CommentQueryService commentQueryService;

    @Autowired
    private ShopIntegralQueryService shopIntegralQueryService;

    @Autowired
    private StatisticalQueryService statisticalQueryService;

    @Autowired
    private CouponQueryService couponQueryService;

    @Autowired
    private FavoriteQueryService favoriteQueryService;

    @Autowired
    private DeliveryAddressCoreService deliveryAddressCoreService;

    @Autowired
    private CollectStatisticQueryService collectStatisticQueryService;

    @Autowired
    private CommentsStatisticQueryService commentsStatisticQueryService;

    @Autowired
    private IntegralQueryService integralQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETACTIVEDATA)
    public TransData<Object> getActiveData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");//用户ID
            String activeId = ServletRequestUtils.getStringParameter(request, "activeId");//活动ID
            UActive uactive = new UActive();
            if (StringUtils.isBlank(userId))
            {
                uactive.setFavorite(false);
            }
            else
            {
                FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
                favoriteInfoExample.createCriteria().andUserIdEqualTo(userId).andInfoTypeEqualTo("A").andObjectIdEqualTo(activeId).andIsDelEqualTo("N");
                uactive.setFavorite(this.favoriteQueryService.findFavoriteListCount(favoriteInfoExample) == 0 ? false : true);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uactive);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端活动展示需要的数据：获取手机端活动展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_MOBILE_FAVORITEACTIVE)
    public TransData<Object> favoriteActive(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");
            String activeId = ServletRequestUtils.getStringParameter(request, "activeId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(activeId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getActiveMobileUrl(activeId, marketingId));
            }
            favoriteInfo.setInfoType("A");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("M");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理手机端收藏活动：收藏活动（" + favoriteInfo.toString() + "）失败");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEACTIVITY_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理手机端收藏活动：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理手机端收藏活动：处理手机端收藏活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETCOUPONDATA)
    public TransData<Object> getCouponData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");//优惠凭证ID
            String shopIntegralId = ServletRequestUtils.getStringParameter(request, "shopIntegralId");//积分营销ID
            Integer couponCollectTimes = this.collectStatisticQueryService.couponCollectTimes(couponId, "A", null, null, null, null);
            CouponDetail couponDetail = this.couponQueryService.findCouponDetail(couponId);
            ShopIntegral shopIntegral = null;
            if ("0".equals(couponDetail.getCoupon().getCouponChannle()))
            {
                shopIntegral = this.integralQueryService.findConvertShopIntegral(shopIntegralId, couponId);
            }
            UCoupon ucoupon = new UCoupon();
            ucoupon.setCouponStockNum(couponDetail.getCouponReserveNum());
            ucoupon.setPopularity(couponCollectTimes);
            if (shopIntegral != null)
            {
                ucoupon.setShopIntegralId(shopIntegral.getShopIntegralId());
                ucoupon.setConvertIntegralValue(shopIntegral.getTradeIntegralValue());
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucoupon);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端优惠凭证展示需要的数据：获取手机端优惠凭证展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_MOBILE_FAVORITECOUPON)
    public TransData<Object> favoriteCoupon(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(couponId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getCouponMobileUrl(couponId, marketingId));
            }
            favoriteInfo.setInfoType("C");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("M");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理手机端收藏优惠凭证：收藏优惠凭证（" + favoriteInfo.toString() + "）失败");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理手机端收藏优惠凭证：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("处理手机端收藏优惠凭证：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("处理手机端收藏优惠凭证：已超过用户拥有优惠券最大个数异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理手机端收藏优惠凭证：处理手机端收藏优惠凭证异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETGOODSDATA)
    public TransData<Object> getGoodsData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");//用户ID
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");//商品ID
            String shopIntegralId = ServletRequestUtils.getStringParameter(request, "shopIntegralId");
            ShopIntegral shopIntegral = null;
            if (StringUtils.isNotBlank(shopIntegralId))
            {
                shopIntegral = this.integralQueryService.findConvertShopIntegral(shopIntegralId, goodsId);
            }
            UGoods ugoods = new UGoods();
            ugoods.setGoodsCommentLevel(this.commentsStatisticQueryService.getGoodsGrade(goodsId));
            if (shopIntegral != null)
            {
                ugoods.setShopIntegralId(shopIntegral.getShopIntegralId());
                ugoods.setConvertIntegralValue(shopIntegral.getTradeIntegralValue());
            }
            else
            {
                if (StringUtils.isBlank(userId))
                {
                    ugoods.setFavorite(false);
                }
                else
                {
                    FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
                    favoriteInfoExample.createCriteria().andUserIdEqualTo(userId).andInfoTypeEqualTo("G").andObjectIdEqualTo(goodsId).andIsDelEqualTo("N");
                    ugoods.setFavorite(this.favoriteQueryService.findFavoriteListCount(favoriteInfoExample) == 0 ? false : true);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ugoods);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端商品展示需要的数据：获取手机端商品展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETGOODSCOMMENTLIST)
    public TransData<Object> getGoodsCommentList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");//商品ID
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            UserCommentExample queryCondition = new UserCommentExample();
            queryCondition.createCriteria().andGoodsIdEqualTo(goodsId).andIsDelEqualTo("N").andIsAuditingEqualTo("P");
            queryCondition.setPage(pageIndex, pageSize);
            queryCondition.setOrderByClause("create_time DESC");
            List<UserCommentDetail> userCommentDetailList = this.commentQueryService.findUserCommentList(queryCondition);
            if (CollectionUtils.isEmpty(userCommentDetailList))
            {
                GooagooLog.info("获取手机端商品评论列表:没有查到手机端商品评论列表");
                return new TransData<Object>(true, MessageConst.WEB_IWEBMERCHANT_GETGOODSCOMMENTLIST_NOTEXIST, null);
            }
            List<UComment> ucommentList = new ArrayList<UComment>();
            for (UserCommentDetail userCommentDetail : userCommentDetailList)
            {
                try
                {
                    UComment ucomment = new UComment();
                    if (userCommentDetail.getUserAccount() != null)
                    {
                        ucomment.setNickName(FormatDataUtils.formatAccount(userCommentDetail.getUserAccount()));
                    }
                    else if (userCommentDetail.getUserEmail() != null)
                    {
                        ucomment.setNickName(FormatDataUtils.formatEmail(userCommentDetail.getUserEmail()));
                    }
                    else if (userCommentDetail.getUserMobile() != null)
                    {
                        ucomment.setNickName(FormatDataUtils.formatMobile(userCommentDetail.getUserMobile()));
                    }
                    ucomment.setLevel(userCommentDetail.getCommentLevel());
                    ucomment.setContent(userCommentDetail.getContent());
                    ucomment.setTime(TimeUtils.convertDateToString(userCommentDetail.getCommentTime(), "yyyy-MM-dd HH:mm"));
                    ucommentList.add(ucomment);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取手机端商品评论列表：组装单个评论信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucommentList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端商品评论列表：获取手机端商品评论列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_MOBILE_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(goodsId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getGoodsMobileUrl(goodsId, marketingId));
            }
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("M");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理手机端收藏商品：收藏商品（" + favoriteInfo.toString() + "）失败");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理手机端收藏商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理手机端收藏商品：处理手机端收藏商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETINTEGRALMALLLIST)
    public TransData<Object> getIntegralMallData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");//用户ID
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 4);
            TradeRequest tradeRequest = new TradeRequest();
            tradeRequest.setUserId(userId);
            tradeRequest.setShopId(shopId);
            tradeRequest.setPageIndex(pageIndex);
            tradeRequest.setPageSize(pageSize);
            List<TradeResponse> tradeResponseList = this.shopIntegralQueryService.findTradeList(tradeRequest);
            if (CollectionUtils.isEmpty(tradeResponseList))
            {
                GooagooLog.info("获取手机端积分商城展示需要的数据：没有查到手机端积分商城展示需要的数据");
                return new TransData<Object>(true, MessageConst.MOBILE_IMOBILEMERCHANT_GETINTEGRALMALLDATA_NOTEXIST, null);
            }
            List<UMall> umallList = new ArrayList<UMall>();
            for (TradeResponse tradeResponse : tradeResponseList)
            {
                try
                {
                    UMall umall = new UMall();
                    umall.setType(tradeResponse.getType());
                    umall.setTypeId(tradeResponse.getTypeId());
                    umall.setTypeName(tradeResponse.getTypeName());
                    umall.setTypeImage(FormatDataUtils.formatImageInfo(tradeResponse.getTypeImageUrl()));
                    if ("G".equals(tradeResponse.getType()))
                    {
                        umall.setTypeVisitUrl(UrlUtils.getGoodsUrl(tradeResponse.getTypeId()));
                    }
                    else if ("C".equals(tradeResponse.getType()))
                    {
                        umall.setTypeVisitUrl(UrlUtils.getCouponUrl(tradeResponse.getTypeId()));
                    }
                    umall.setShopIntegralId(tradeResponse.getShopIntegralId());
                    umall.setConvertIntegralValue(tradeResponse.getConvertIntegralValue());
                    umallList.add(umall);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取手机端积分商城展示需要的数据：组装单个兑换物信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, umallList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端积分商城展示需要的数据：获取手机端积分商城展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_MOBILE_INTEGRALCONVERT)
    public TransData<Object> integralConvert(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            ShopIntegralConvert shopIntegralConvert = ServletUtils.objectMethod(ShopIntegralConvert.class, request);
            if ("G".equals(shopIntegralConvert.getIntegralTradeType()))
            {
                ConsigneeInfo consigneeInfo = ServletUtils.objectMethod(ConsigneeInfo.class, request);
                if (StringUtils.isBlank(consigneeInfo.getConsigneeId()))
                {
                    consigneeInfo.setConsigneeId(UUID.getUUID());
                    if (!this.deliveryAddressCoreService.addDeliveryAddress(consigneeInfo))
                    {
                        GooagooLog.info("处理手机端积分兑换：新增收货地址失败（" + consigneeInfo.toString() + "）");
                        return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, null);
                    }
                }
                shopIntegralConvert.setConsigneeId(consigneeInfo.getConsigneeId());
            }
            shopIntegralConvert.setInfoSource("M");
            if (!this.integralCoreService.integralExchangeGoods(shopIntegralConvert))
            {
                GooagooLog.info("处理手机端积分兑换：积分兑换失败（" + shopIntegralConvert.toString() + "）");
                return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.MALL_IMALL_INTEGRALCONVERT_SUCCESS, null);
        }
        catch (IntegralNotEnoughException e)
        {
            GooagooLog.error("处理手机端积分兑换：积分不足异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT__LACKOFINTEGRATION, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理手机端积分兑换：处理手机端积分兑换异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETPOSITIONMARKETINGRANK)
    public TransData<Object> getPositionMarketingRank(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String positionId = ServletRequestUtils.getStringParameter(request, "positionId");//位置ID
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
            List<GoodsSalesRanking> goodsSalesRankingsList = this.statisticalQueryService.salesRanking(null, null, null, positionId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(goodsSalesRankingsList))
            {
                GooagooLog.info("获取手机端区域商品销量排行:没有查到区域（" + positionId + "）商品销量排行");
                return new TransData<Object>(true, MessageConst.MOBILE_IMOBILEMERCHANT_GETPOSITIONMARKETINGPANK_NOTEXIST, null);
            }
            List<UPositionMarketingRank> upositionMarketingRankList = new ArrayList<UPositionMarketingRank>();
            for (GoodsSalesRanking goodsSalesRanking : goodsSalesRankingsList)
            {
                try
                {
                    UPositionMarketingRank upositionMarketingRank = new UPositionMarketingRank();
                    upositionMarketingRank.setGoodsName(goodsSalesRanking.getGoodsName());
                    upositionMarketingRank.setPositionName(goodsSalesRanking.getPositionName());
                    upositionMarketingRank.setGoodsPrice(FormatDataUtils.formatGoodsPrice(Double.valueOf(goodsSalesRanking.getGoodsPrice())));
                    upositionMarketingRank.setSales(Integer.parseInt(goodsSalesRanking.getSales()));
                    upositionMarketingRank.setGoodsVisitUrl(UrlUtils.getGoodsUrl(goodsSalesRanking.getGoodsId()));
                    upositionMarketingRankList.add(upositionMarketingRank);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取手机端区域商品销量排行：组装商品销量信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, upositionMarketingRankList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端区域商品销量排行：获取手机端区域商品销量排行异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_MOBILE_GETCONSIGNEEINFO)
    public TransData<Object> getConsigneeInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, "userId");
            ConsigneeInfoExample consInfoExample = new ConsigneeInfoExample();
            consInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoService.selectByExample(consInfoExample);
            if (CollectionUtils.isEmpty(consigneeInfoList))
            {
                GooagooLog.info("获取手机端的收货人信息（得到地址）:没有查到手机端的收货人信息");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            List<UConsigeeInfo> uconsigeeInfoList = new ArrayList<UConsigeeInfo>();
            for (ConsigneeInfo consigneeInfo : consigneeInfoList)
            {
                try
                {
                    UConsigeeInfo uconsigeeInfo = new UConsigeeInfo();
                    uconsigeeInfo.setAddress(consigneeInfo.getAddress());
                    uconsigeeInfo.setUserId(consigneeInfo.getUserId());
                    uconsigeeInfo.setTelephone(consigneeInfo.getTelephone());
                    uconsigeeInfo.setConsigneeId(consigneeInfo.getConsigneeId());
                    uconsigeeInfo.setConsigneeName(consigneeInfo.getConsigneeName());
                    uconsigeeInfo.setIsDefault(consigneeInfo.getIsDefault());
                    uconsigeeInfo.setPhone(consigneeInfo.getPhone());
                    uconsigeeInfo.setPostCode(consigneeInfo.getPostCode());
                    uconsigeeInfo.setAreaId(consigneeInfo.getArea());
                    uconsigeeInfo.setAreaName(AreaCache.getSelf(consigneeInfo.getArea()));
                    uconsigeeInfo.setCityId(consigneeInfo.getCity());
                    uconsigeeInfo.setCityName(AreaCache.getSelf(consigneeInfo.getCity()));
                    uconsigeeInfo.setProvinceId(consigneeInfo.getProvince());
                    uconsigeeInfo.setProvinceName(AreaCache.getSelf(consigneeInfo.getProvince()));
                    uconsigeeInfoList.add(uconsigeeInfo);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取手机端的收货人信息（得到地址）：组装单个收货地址信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uconsigeeInfoList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取手机端的收货人信息（得到地址）：获取收货人信息异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}

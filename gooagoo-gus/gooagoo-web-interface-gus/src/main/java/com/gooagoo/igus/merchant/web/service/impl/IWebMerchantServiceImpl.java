package com.gooagoo.igus.merchant.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.business.core.statistics.BuyStatisticCoreService;
import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.business.query.marketing.coupon.CouponQueryService;
import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CommentsStatisticQueryService;
import com.gooagoo.api.business.query.user.comment.CommentQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.cache.AreaCache;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.CouponDetail;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.exception.business.integral.IntegralNotEnoughException;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.merchant.web.service.IWebMerchantService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.comment.UComment;
import com.gooagoo.view.gus.web.merchant.web.UActive;
import com.gooagoo.view.gus.web.merchant.web.UConsigeeInfo;
import com.gooagoo.view.gus.web.merchant.web.UCoupon;
import com.gooagoo.view.gus.web.merchant.web.UGoods;
import com.google.gson.Gson;

@Service("iWebMerchantService")
public class IWebMerchantServiceImpl implements IWebMerchantService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private IntegralCoreService integralCoreService;

    @Autowired
    private CommentQueryService commentQueryService;

    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoService;

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

    @Autowired
    private BuyStatisticCoreService buyStatisticCoreService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_GETACTIVEDATA)
    public TransData<Object> getActiveData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
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
            GooagooLog.error("获取网站端活动展示需要的数据：获取网站端活动展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_WEB_FAVORITEACTIVE)
    public TransData<Object> favoriteActive(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activeId = ServletRequestUtils.getStringParameter(request, "activeId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(activeId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getActiveUrl(activeId, marketingId));
            }
            favoriteInfo.setInfoType("A");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理网站端收藏活动：收藏活动失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEACTIVITY_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理网站端收藏活动：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理网站端收藏活动：处理网站端收藏活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_GETCOUPONDATA)
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
            GooagooLog.error("获取网站端优惠凭证展示需要的数据：获取网站端优惠凭证展示需要的数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_WEB_FAVORITECOUPON)
    public TransData<Object> favoriteCoupon(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(couponId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getCouponUrl(couponId, marketingId));
            }
            favoriteInfo.setInfoType("C");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理网站端收藏优惠凭证：收藏优惠凭证失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理网站端收藏优惠凭证：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("处理网站端收藏优惠凭证：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("处理网站端收藏优惠凭证：已超过用户拥有优惠券最大个数异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理网站端收藏优惠凭证：处理网站端收藏优惠凭证异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_GETGOODSDATA)
    public TransData<Object> getGoodsData(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");//商品ID
            String shopIntegralId = ServletRequestUtils.getStringParameter(request, "shopIntegralId");//积分营销ID
            GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
            ShopIntegral shopIntegral = null;
            if (StringUtils.isNotBlank(shopIntegralId))
            {
                shopIntegral = this.integralQueryService.findConvertShopIntegral(shopIntegralId, goodsId);
            }
            UGoods ugoods = new UGoods();
            ugoods.setGoodsCommentLevel(this.commentsStatisticQueryService.getGoodsGrade(goodsId));
            ugoods.setDayPopularity(this.buyStatisticCoreService.goodsBuyTimes(goodsBaseInfo.getShopId(), goodsBaseInfo.getItemSerial(), "D", "A", new Date()));
            ugoods.setWeekPopularity(this.buyStatisticCoreService.goodsBuyTimes(goodsBaseInfo.getShopId(), goodsBaseInfo.getItemSerial(), "W", "A", new Date()));
            if (shopIntegral != null)
            {
                ugoods.setShopIntegralId(shopIntegral.getShopIntegralId());
                ugoods.setConvertIntegralValue(shopIntegral.getTradeIntegralValue());
            }
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

            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ugoods);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取网站端商品展示需要的基本数据：获取网站端商品展示需要的基本数据异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_GETGOODSCOMMENTDATA)
    public TransData<Object> getGoodsCommentList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");//商品ID
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");//商品ID
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");//商品ID
            UserCommentExample uCommentExample = new UserCommentExample();
            uCommentExample.createCriteria().andIsAuditingEqualTo("P").andIsDelEqualTo("N").andGoodsIdEqualTo(goodsId);
            uCommentExample.setOrderByClause("create_time desc");
            uCommentExample.setPage(pageIndex, pageSize);
            List<UserCommentDetail> userCommentDetailList = this.commentQueryService.findUserCommentList(uCommentExample);
            if (CollectionUtils.isEmpty(userCommentDetailList))
            {
                GooagooLog.info("获取网站端商品评论列:没有查到网站端商品评论列表");
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
                        ucomment.setUserNickName(FormatDataUtils.formatAccount(userCommentDetail.getUserAccount()));
                    }
                    else if (userCommentDetail.getUserEmail() != null)
                    {
                        ucomment.setUserNickName(FormatDataUtils.formatEmail(userCommentDetail.getUserEmail()));
                    }
                    else if (userCommentDetail.getUserMobile() != null)
                    {
                        ucomment.setUserNickName(FormatDataUtils.formatMobile(userCommentDetail.getUserMobile()));
                    }
                    ucomment.setUserHeadPic(FormatDataUtils.formatImageInfo(userCommentDetail.getUserHeadPic()));
                    ucomment.setCommentLevel(userCommentDetail.getCommentLevel());
                    ucomment.setContent(userCommentDetail.getContent());
                    ucomment.setSource(SysdictionaryCache.get("info_source", userCommentDetail.getSource()));
                    ucomment.setCommentTime(TimeUtils.convertDateToString(userCommentDetail.getCommentTime(), "yyyy年MM月dd日 HH:mm"));
                    ucommentList.add(ucomment);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取网站端商品评论列表：组装单个评论信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucommentList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取网站端商品评论列表：获取网站端商品评论列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_WEB_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            if (StringUtils.isBlank(marketingId))
            {
                favoriteInfo.setObjectId(goodsId);
            }
            else
            {
                favoriteInfo.setInfoUrl(UrlUtils.getGoodsUrl(goodsId, marketingId));
            }
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("处理网站端收藏商品：收藏商品失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("处理网站端收藏商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理网站端收藏商品：处理网站端收藏商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String[] goodsIds = ServletRequestUtils.getStringParameter(request, "goodsIdStr").split(",");//商品ID
            String[] goodsNames = java.net.URLDecoder.decode(ServletRequestUtils.getStringParameter(request, "goodsNameStr"), "UTF-8").split(",");//商品名称
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");//商家ID
            String shopName = java.net.URLDecoder.decode(ServletRequestUtils.getStringParameter(request, "shopName"), "UTF-8");//商家名称
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            for (int i = 0; i < goodsIds.length; i++)
            {
                ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
                shoppingPlanGoods.setGoodsId(goodsIds[i]);
                shoppingPlanGoods.setGoodsName(goodsNames[i]);
                shoppingPlanGoods.setShopId(shopId);
                shoppingPlanGoods.setShopName(shopName);
                shoppingPlanGoodsList.add(shoppingPlanGoods);
            }
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("处理网站端商品加入购物清单：加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
                return new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_SUCCESS, null);
        }
        catch (NoShoppingPlanException e)
        {
            GooagooLog.error("处理网站端商品加入购物清单：没有数据", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理网站端商品加入购物清单：处理网站端商品加入购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MERCHANT_WEB_GETSHIPPINGADDRESSLIST)
    public TransData<Object> getShippingAddressList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //传递userId执行查询 
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            ConsigneeInfoExample consInfoExample = new ConsigneeInfoExample();
            consInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoService.selectByExample(consInfoExample);
            if (CollectionUtils.isEmpty(consigneeInfoList))
            {
                GooagooLog.info("查询用户收货地址列表：没有查到该用户的收货地址");
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
                    GooagooLog.error("查询用户收货地址列表：组装单个收货地址信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uconsigeeInfoList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询用户收货地址列表:查询用户收货地址列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MERCHANT_WEB_INTEGRALCONVERT)
    public TransData<Object> integralConvert(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        String consigneeId = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
            ShopIntegralConvert shopIntegralConvert = ServletUtils.objectMethod(ShopIntegralConvert.class, request);
            if ("G".equals(shopIntegralConvert.getIntegralTradeType()))
            {
                ConsigneeInfo consigneeInfo = ServletUtils.objectMethod(ConsigneeInfo.class, request);
                consigneeInfo.setUserId(userId);
                if (StringUtils.isBlank(consigneeInfo.getConsigneeId()))
                {
                    consigneeInfo.setConsigneeId(UUID.getUUID());
                    if (!this.deliveryAddressCoreService.addDeliveryAddress(consigneeInfo))
                    {
                        GooagooLog.info("处理网站端积分兑换：新增收货地址失败（" + consigneeInfo.toString() + "）");
                        return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, null);
                    }
                }
                consigneeId = consigneeInfo.getConsigneeId();
                shopIntegralConvert.setConsigneeId(consigneeInfo.getConsigneeId());
            }
            shopIntegralConvert.setUserId(userId);
            shopIntegralConvert.setInfoSource("W");
            if (!this.integralCoreService.integralExchangeGoods(shopIntegralConvert))
            {
                GooagooLog.info("处理网站端积分兑换：积分兑换失败（" + shopIntegralConvert.toString() + "）");
                return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, consigneeId);
            }
            transData = new TransData<Object>(true, MessageConst.MALL_IMALL_INTEGRALCONVERT_SUCCESS, consigneeId);
        }
        catch (IntegralNotEnoughException e)
        {
            GooagooLog.error("处理网站端积分兑换：积分不足异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT__LACKOFINTEGRATION, consigneeId);
        }
        catch (Exception e)
        {
            GooagooLog.error("处理网站端积分兑换：处理积分兑换异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, consigneeId);
        }

        return transData;
    }

}

package com.gooagoo.igus.notice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.core.user.notice.UserNoticeCoreService;
import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.business.query.marketing.notice.NoticeQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.NoticeInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.notice.service.INoticeService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.notice.UNoticeInfo;
import com.google.gson.Gson;

@Service("iNoticeService")
public class INoticeServiceImpl implements INoticeService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private NoticeQueryService noticeQueryService;

    @Autowired
    private UserNoticeCoreService userNoticeCoreService;

    @Override
    @BehaveAnnotation(InterGusConstants.NOTICE_GETNOTICELIST)
    public TransData<Object> getNoticeList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String startPushTime = ServletRequestUtils.getStringParameter(request, "start");
            String endPushTime = ServletRequestUtils.getStringParameter(request, "end");
            String pageId = ServletRequestUtils.getStringParameter(request, "pageId", null);
            String pageType = ServletRequestUtils.getStringParameter(request, "pageType", "P");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 3);
            if (StringUtils.isBlank(pageId))
            {
                pageId = null;
            }
            if (StringUtils.isBlank(shopId))
            {
                shopId = null;
            }
            List<NoticeInfoBusiness> noticeInfoBusinessList = this.noticeQueryService.findNoticeList("W", userId, shopId, startPushTime, endPushTime, pageId, pageType, pageSize);
            if (CollectionUtils.isEmpty(noticeInfoBusinessList))
            {
                GooagooLog.info("获取通知列表:没有查到通知类表信息");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            List<UNoticeInfo> unoticeInfoList = new ArrayList<UNoticeInfo>();
            for (NoticeInfoBusiness noticeInfoBusiness : noticeInfoBusinessList)
            {
                try
                {
                    UNoticeInfo unoticeInfo = new UNoticeInfo();
                    unoticeInfo.setPageId(noticeInfoBusiness.getPageId());
                    unoticeInfo.setContentWeb(noticeInfoBusiness.getNoticeTextWeb());
                    unoticeInfo.setShopId(noticeInfoBusiness.getShopId());
                    unoticeInfo.setThumbnailPic(FormatDataUtils.formatImageInfo(noticeInfoBusiness.getImg()));
                    unoticeInfo.setPushTime(TimeUtils.convertStringToDate(noticeInfoBusiness.getPushTime()));
                    unoticeInfo.setTitle(noticeInfoBusiness.getNoticeTitle());
                    unoticeInfo.setNoticeId(noticeInfoBusiness.getNoticeInfoId());
                    unoticeInfo.setId(noticeInfoBusiness.getMarketingUserLinkId());
                    unoticeInfo.setInfoType(noticeInfoBusiness.getMarketingLinkType());
                    unoticeInfo.setObjectId(noticeInfoBusiness.getMarketingLinkId());
                    unoticeInfo.setShopName(noticeInfoBusiness.getShopName());
                    if ("G".equals(noticeInfoBusiness.getMarketingLinkType()))
                    {
                        unoticeInfo.setPicHerf(UrlUtils.getGoodsUrl(noticeInfoBusiness.getMarketingLinkId(), noticeInfoBusiness.getNoticeInfoId()));
                    }
                    else if ("A".equals(noticeInfoBusiness.getMarketingLinkType()))
                    {
                        unoticeInfo.setPicHerf(UrlUtils.getActiveUrl(noticeInfoBusiness.getMarketingLinkId(), noticeInfoBusiness.getNoticeInfoId()));
                    }
                    else if ("C".equals(noticeInfoBusiness.getMarketingLinkType()))
                    {
                        unoticeInfo.setPicHerf(UrlUtils.getCouponUrl(noticeInfoBusiness.getMarketingLinkId(), noticeInfoBusiness.getNoticeInfoId()));
                    }
                    unoticeInfoList.add(unoticeInfo);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取通知列表：组装单个通知信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, unoticeInfoList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取通知列表：查询通知失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.NOTICE_DELETENOTICELIST)
    public TransData<Object> deleteNotice(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String ids = ServletRequestUtils.getStringParameter(request, "id");
            if (!this.userNoticeCoreService.deleteNotice(ids))
            {
                GooagooLog.info("获取通知列表：删除通知失败（" + ids + "）");
                return new TransData<Object>(false, MessageConst.NOTICE_INOTICE_DELETENOTICE_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.NOTICE_INOTICE_DELETENOTICE_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除通知：删除通知异常", e);
            transData = new TransData<Object>(false, MessageConst.NOTICE_INOTICE_DELETENOTICE_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.NOTICE_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        String userId = null;
        try
        {
            userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            String noticeInfoId = ServletRequestUtils.getStringParameter(request, "noticeInfoId");
            String infoUrl = UrlUtils.getGoodsUrl(goodsId, noticeInfoId);
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setInfoUrl(infoUrl);
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏通知的商品：收藏商品失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏通知的商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏通知的商品：收藏失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.NOTICE_FAVORITEACTIVE)
    public TransData<Object> favoriteActive(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        String userId = null;
        try
        {
            userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activityId = ServletRequestUtils.getStringParameter(request, "activityId");
            String noticeInfoId = ServletRequestUtils.getStringParameter(request, "noticeInfoId");
            String infoUrl = UrlUtils.getActiveUrl(activityId, noticeInfoId);
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setInfoUrl(infoUrl);
            favoriteInfo.setInfoType("A");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏通知活动：收藏活动失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEACTIVITY_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏通知活动：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏通知活动：收藏失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEACTIVITY_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.NOTICE_FAVORITECOUPON)
    public TransData<Object> favoriteCoupon(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        String userId = null;
        try
        {
            userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String couponId = ServletRequestUtils.getStringParameter(request, "couponId");
            String noticeInfoId = ServletRequestUtils.getStringParameter(request, "noticeInfoId");
            String infoUrl = UrlUtils.getCouponUrl(couponId, noticeInfoId);
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setInfoUrl(infoUrl);
            favoriteInfo.setUserId(userId);
            favoriteInfo.setInfoType("C");
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏通知优惠凭证：收藏优惠凭证失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITECOUPON_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏通知优惠凭证：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (CouponExhaustiveException e)
        {
            GooagooLog.error("收藏通知优惠凭证：优惠券收藏数量超过商家发行数量异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            GooagooLog.error("收藏通知优惠凭证：已超过用户拥有优惠券最大个数异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_UNSTORE_MORE_MAX, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏通知优惠凭证：收藏失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITECOUPON_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.NOTICE_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {

            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            ShoppingPlanGoods goodlist = new ShoppingPlanGoods();
            goodlist.setGoodsId(ServletRequestUtils.getStringParameter(request, "marketingLinkId"));
            goodlist.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            goodlist.setShopName(ServletRequestUtils.getStringParameter(request, "shopName"));
            shoppingPlanGoodsList.add(goodlist);
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("通知加入购物清单：加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
                return new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_SUCCESS, null);
        }
        catch (NoShoppingPlanException e)
        {
            GooagooLog.error("通知加入购物清单：没有数据", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("通知加入购物清单：加入购物清单失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }

        return transData;
    }

}

package com.gooagoo.igus.favorite.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample.Criteria;
import com.gooagoo.igus.favorite.service.IFavoriteService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.favorite.UFavoriteActivity;
import com.gooagoo.view.gus.web.favorite.UFavoriteCoupon;
import com.gooagoo.view.gus.web.favorite.UFavoriteGoods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "iFavoriteService")
public class IFavoriteServiceImpl implements IFavoriteService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private FavoriteQueryService favoriteQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_FAVORITE_GETFAVORITEGOODSLIST)
    public TransData<Object> getFavoriteGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            PageModel<UFavoriteGoods> pageModel = new PageModel<UFavoriteGoods>();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            Date startDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "startDate"));
            Date endDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "endDate"));
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 5);
            FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
            Criteria criteria = favoriteInfoExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andIsDelEqualTo("N").andInfoTypeEqualTo("G").andCreateTimeBetween(startDate, endDate);
            if (StringUtils.isNotBlank(shopId))
            {
                criteria.andShopIdEqualTo(shopId);
            }
            int count = this.favoriteQueryService.findFavoriteListCount(favoriteInfoExample);
            favoriteInfoExample.setOrderByClause("create_time desc");
            favoriteInfoExample.setPage(pageIndex, pageSize);
            List<FavoriteInfoDetail> favoriteInfoDetailList = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);
            if (CollectionUtils.isEmpty(favoriteInfoDetailList))
            {
                GooagooLog.info("查询已收藏商品列表：查询收藏商品为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IFAVOITE_GET_NOTEXIST, null);
            }
            List<UFavoriteGoods> ufavoriteGoodsList = new ArrayList<UFavoriteGoods>();
            for (FavoriteInfoDetail favoriteInfoDetail : favoriteInfoDetailList)
            {
                UFavoriteGoods ufavoriteGoods = new UFavoriteGoods();
                ufavoriteGoods.setFavoriteId(favoriteInfoDetail.getFavoriteInfo().getFavoriteId());
                ufavoriteGoods.setGoodsId(favoriteInfoDetail.getGoodsBaseInfo().getGoodsId());
                ufavoriteGoods.setGoodsName(favoriteInfoDetail.getGoodsBaseInfo().getGoodsName());
                ufavoriteGoods.setShopName(favoriteInfoDetail.getShopInfo().getShopName());
                ufavoriteGoods.setGoodsPrice(FormatDataUtils.formatGoodsPrice(favoriteInfoDetail.getGoodsBaseInfo().getPrice()));
                if (favoriteInfoDetail.getGoodsMarketingInfo() != null)
                {
                    ufavoriteGoods.setAddress(favoriteInfoDetail.getGoodsMarketingInfo().getAddress());
                    if (StringUtils.isNotBlank(favoriteInfoDetail.getGoodsMarketingInfo().getGoodsImg()))
                    {
                        List<String> imgs = new Gson().fromJson(favoriteInfoDetail.getGoodsMarketingInfo().getGoodsImg(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        ufavoriteGoods.setImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                }
                try
                {
                    ufavoriteGoods.setGoodsUrl(UrlUtils.getGoodsUrl(favoriteInfoDetail.getGoodsBaseInfo().getGoodsId()));
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询已收藏商品列表：生成商品（" + favoriteInfoDetail.getGoodsBaseInfo().getGoodsId() + "）访问链接异常", e);
                }
                ufavoriteGoods.setFavoriteTime(favoriteInfoDetail.getFavoriteInfo().getCreateTime());
                ufavoriteGoodsList.add(ufavoriteGoods);
            }
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(ufavoriteGoodsList);
            pageModel.setCount(count);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询已收藏商品列表:查询已收藏商品列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_FAVORITE_GETFAVORITEACTIVITYLIST)
    public TransData<Object> getFavotiteActivityList(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            PageModel<UFavoriteActivity> pageModel = new PageModel<UFavoriteActivity>();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            Date startDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "startDate"));
            Date endDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "endDate"));
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 5);
            FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
            Criteria criteria = favoriteInfoExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andIsDelEqualTo("N").andInfoTypeEqualTo("A").andCreateTimeBetween(startDate, endDate);
            if (StringUtils.isNotBlank(shopId))
            {
                criteria.andShopIdEqualTo(shopId);
            }
            int count = this.favoriteQueryService.findFavoriteListCount(favoriteInfoExample);
            favoriteInfoExample.setOrderByClause("create_time desc");
            favoriteInfoExample.setPage(pageIndex, pageSize);
            List<FavoriteInfoDetail> favoriteInfoDetailList = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);
            if (CollectionUtils.isEmpty(favoriteInfoDetailList))
            {
                GooagooLog.info("查询已收藏活动列表：查询收藏活动为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IFAVOITE_GET_NOTEXIST, null);
            }
            List<UFavoriteActivity> ufavoriteActivityList = new ArrayList<UFavoriteActivity>();
            for (FavoriteInfoDetail favoriteInfoDetail : favoriteInfoDetailList)
            {
                UFavoriteActivity ufavoriteActivity = new UFavoriteActivity();
                ufavoriteActivity.setFavoriteId(favoriteInfoDetail.getFavoriteInfo().getFavoriteId());
                ufavoriteActivity.setActivityId(favoriteInfoDetail.getMarketingActivity().getActivityId());
                ufavoriteActivity.setShopName(favoriteInfoDetail.getShopInfo().getShopName());
                ufavoriteActivity.setActivityName(favoriteInfoDetail.getMarketingActivity().getActivityName());
                ufavoriteActivity.setActivityContent(favoriteInfoDetail.getMarketingActivity().getContent());
                ufavoriteActivity.setActivityTitle(favoriteInfoDetail.getMarketingActivity().getTitle());
                ufavoriteActivity.setActivityStartTime(TimeUtils.convertDateToString(favoriteInfoDetail.getMarketingActivity().getStartTime(), "yyyy年MM月dd日"));
                ufavoriteActivity.setActivityEndTime(TimeUtils.convertDateToString(favoriteInfoDetail.getMarketingActivity().getEndTime(), "yyyy年MM月dd日"));
                ufavoriteActivity.setImage(FormatDataUtils.formatImageInfo(favoriteInfoDetail.getMarketingActivity().getImgUrl()));
                try
                {
                    ufavoriteActivity.setActivityUrl(UrlUtils.getActiveUrl(favoriteInfoDetail.getMarketingActivity().getActivityId()));
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询已收藏活动列表：生成活动（" + favoriteInfoDetail.getMarketingActivity().getActivityId() + "）访问链接异常", e);
                }
                ufavoriteActivity.setFavoriteTime(favoriteInfoDetail.getFavoriteInfo().getCreateTime());
                ufavoriteActivityList.add(ufavoriteActivity);
            }
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(ufavoriteActivityList);
            pageModel.setCount(count);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询已收藏活动列表:查询用户收藏的活动异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_FAVORITE_GETFAVORITECOUPONLIST)
    public TransData<Object> getFavoriteCouponList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            PageModel<UFavoriteCoupon> pageModel = new PageModel<UFavoriteCoupon>();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            Date startDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "startDate"));
            Date endDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "endDate"));
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 5);
            FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
            Criteria criteria = favoriteInfoExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andIsDelEqualTo("N").andInfoTypeEqualTo("C").andCreateTimeBetween(startDate, endDate);
            if (StringUtils.isNotBlank(shopId))
            {
                criteria.andShopIdEqualTo(shopId);
            }
            int count = this.favoriteQueryService.findFavoriteListCount(favoriteInfoExample);
            favoriteInfoExample.setOrderByClause("create_time desc");
            favoriteInfoExample.setPage(pageIndex, pageSize);
            List<FavoriteInfoDetail> favoriteInfoDetailList = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);
            if (CollectionUtils.isEmpty(favoriteInfoDetailList))
            {
                GooagooLog.info("查询已收藏优惠凭证列表：查询收藏优惠凭证为空");
                return new TransData<Object>(true, MessageConst.FAVORITE_IFAVOITE_GET_NOTEXIST, null);
            }
            List<UFavoriteCoupon> ufavoriteCouponList = new ArrayList<UFavoriteCoupon>();
            for (FavoriteInfoDetail favoriteInfoDetail : favoriteInfoDetailList)
            {
                UFavoriteCoupon ufavoriteCoupon = new UFavoriteCoupon();
                ufavoriteCoupon.setFavoriteId(favoriteInfoDetail.getFavoriteInfo().getFavoriteId());
                ufavoriteCoupon.setCouponId(favoriteInfoDetail.getCoupon().getCouponId());
                ufavoriteCoupon.setShopName(favoriteInfoDetail.getShopInfo().getShopName());
                ufavoriteCoupon.setCouponName(favoriteInfoDetail.getCoupon().getCouponName());
                ufavoriteCoupon.setCouponValue(FormatDataUtils.formatCouponValue(favoriteInfoDetail.getCoupon().getCouponType(), favoriteInfoDetail.getCoupon().getCouponValue()));
                ufavoriteCoupon.setCouponContent(favoriteInfoDetail.getCoupon().getCouponContent());
                ufavoriteCoupon.setCouponStartTime(favoriteInfoDetail.getCoupon().getUseStartTime());
                ufavoriteCoupon.setCouponEndTime(favoriteInfoDetail.getCoupon().getUseEndTime());
                ufavoriteCoupon.setImage(FormatDataUtils.formatImageInfo(favoriteInfoDetail.getCoupon().getCouponUrl()));
                ufavoriteCoupon.setCouponType(SysdictionaryCache.get("coupon_type", favoriteInfoDetail.getCoupon().getCouponType()));
                try
                {
                    ufavoriteCoupon.setCouponUrl(UrlUtils.getCouponUrl(favoriteInfoDetail.getCoupon().getCouponId()));
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询已收藏优惠凭证列表:生成优惠凭证（" + favoriteInfoDetail.getCoupon().getCouponId() + "）访问链接异常", e);
                }
                ufavoriteCoupon.setCouponStatus(SysdictionaryCache.get("coupon_status", favoriteInfoDetail.getFavoriteInfo().getCouponStatus()));
                ufavoriteCoupon.setFavoriteTime(favoriteInfoDetail.getFavoriteInfo().getCreateTime());
                ufavoriteCouponList.add(ufavoriteCoupon);
            }

            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(ufavoriteCouponList);
            pageModel.setCount(count);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询已收藏优惠凭证列表:查询用户收藏优惠卷异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.FAVORITE_FAVORITE_DELETEFAVORITE)
    public TransData<Object> deleteFavorite(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String favoriteIds = ServletRequestUtils.getStringParameter(request, "favoriteIds");
            if (!this.favoriteCoreService.deleteFavorite(favoriteIds))
            {
                GooagooLog.info("取消收藏：取消收藏失败（" + favoriteIds + "）");
                return new TransData<Object>(false, MessageConst.FAVORITE_IFAVOITE_DELETEFAVORITE_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.FAVORITE_IFAVOITE_DELETEFAVORITE_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("取消收藏:取消收藏信息异常", e);
            transData = new TransData<Object>(false, MessageConst.FAVORITE_IFAVOITE_DELETEFAVORITE_FAIL, null);
        }
        return transData;
    }

}

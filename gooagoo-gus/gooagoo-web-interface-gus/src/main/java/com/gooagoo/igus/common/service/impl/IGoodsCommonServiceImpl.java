package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.analysis.GuessYouLikeQueryService;
import com.gooagoo.api.business.query.marketing.analysis.HotCommentQueryService;
import com.gooagoo.api.business.query.marketing.analysis.HotSellersQueryService;
import com.gooagoo.api.business.query.marketing.analysis.NewGoodsQueryService;
import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeGoods;
import com.gooagoo.entity.business.marketing.analysis.HotCommentGoods;
import com.gooagoo.entity.business.marketing.analysis.HotSellerGoods;
import com.gooagoo.entity.business.marketing.analysis.NewGoods;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.igus.common.service.IGoodsCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UGuessYouLikeGoods;
import com.gooagoo.view.gus.web.common.UHotCommentGoods;
import com.gooagoo.view.gus.web.common.UHotSellerGoods;
import com.gooagoo.view.gus.web.common.UNewGoods;
import com.gooagoo.view.gus.web.common.URecommendGoods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("iGoodsCommonService")
public class IGoodsCommonServiceImpl implements IGoodsCommonService
{

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Autowired
    private GuessYouLikeQueryService guessYouLikeQueryService;

    @Autowired
    private HotSellersQueryService hotSellersQueryService;

    @Autowired
    private HotCommentQueryService hotCommentQueryService;

    @Autowired
    private NewGoodsQueryService newGoodsQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_GOODSCOMMON_GETHOTSALEGOODSLIST)
    public TransData<Object> getHotSaleGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取热卖商品列表
            List<HotSellerGoods> hotSellerGoodsList = this.hotSellersQueryService.hotSeller(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(hotSellerGoodsList))
            {
                GooagooLog.info("热卖商品列表：未获取到满足条件的热卖商品列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UHotSellerGoods> uhotSellerGoodsList = new ArrayList<UHotSellerGoods>();
            for (HotSellerGoods hotSellerGoods : hotSellerGoodsList)
            {
                try
                {
                    UHotSellerGoods uhotSellerGoods = new UHotSellerGoods();
                    uhotSellerGoods.setGoodsId(hotSellerGoods.getGoodsId());
                    uhotSellerGoods.setGoodsName(hotSellerGoods.getGoodsName());
                    uhotSellerGoods.setGoodsVisitUrl(UrlUtils.getGoodsUrl(hotSellerGoods.getGoodsId()));
                    if (StringUtils.isNotBlank(hotSellerGoods.getGoodsImageUrl()))
                    {
                        List<String> imgs = new Gson().fromJson(hotSellerGoods.getGoodsImageUrl(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        uhotSellerGoods.setGoodsImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                    uhotSellerGoods.setShopId(hotSellerGoods.getShopId());
                    uhotSellerGoods.setShopName(hotSellerGoods.getShopName());
                    uhotSellerGoodsList.add(uhotSellerGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("热卖商品列表：组装单个商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uhotSellerGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("热卖商品列表:获取热卖商品列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_GOODSCOMMON_GETHOTCOMMENTGOODSLIST)
    public TransData<Object> getHotCommentGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取热评商品列表
            List<HotCommentGoods> hotCommentGoodsList = this.hotCommentQueryService.hotComment(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(hotCommentGoodsList))
            {
                GooagooLog.info("热评商品列表：未获取到满足条件的热评商品列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UHotCommentGoods> uhotCommentGoodsList = new ArrayList<UHotCommentGoods>();
            for (HotCommentGoods hotCommentGoods : hotCommentGoodsList)
            {
                try
                {
                    UHotCommentGoods uhotCommentGoods = new UHotCommentGoods();
                    uhotCommentGoods.setGoodsId(hotCommentGoods.getGoodsId());
                    uhotCommentGoods.setGoodsName(hotCommentGoods.getGoodsName());
                    uhotCommentGoods.setGoodsVisitUrl(UrlUtils.getGoodsUrl(hotCommentGoods.getGoodsId()));
                    if (StringUtils.isNotBlank(hotCommentGoods.getGoodsImageUrl()))
                    {
                        List<String> imgs = new Gson().fromJson(hotCommentGoods.getGoodsImageUrl(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        uhotCommentGoods.setGoodsImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                    uhotCommentGoods.setShopId(hotCommentGoods.getShopId());
                    uhotCommentGoods.setShopName(hotCommentGoods.getShopName());
                    uhotCommentGoodsList.add(uhotCommentGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("热评商品列表：组装单个商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uhotCommentGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("热评商品列表:获取热评商品列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_GOODSCOMMON_GETNEWESTGOODSLIST)
    public TransData<Object> getNewestGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取最新商品列表
            List<NewGoods> NewGoodsList = this.newGoodsQueryService.newGoods(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(NewGoodsList))
            {
                GooagooLog.info("最新商品列表：未获取到满足条件的最新商品列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UNewGoods> unewGoodsList = new ArrayList<UNewGoods>();
            for (NewGoods newGoods : NewGoodsList)
            {
                try
                {
                    UNewGoods unewGoods = new UNewGoods();
                    unewGoods.setGoodsId(newGoods.getGoodsId());
                    unewGoods.setGoodsName(newGoods.getGoodsName());
                    unewGoods.setGoodsVisitUrl(UrlUtils.getGoodsUrl(newGoods.getGoodsId()));
                    if (StringUtils.isNotBlank(newGoods.getGoodsImageUrl()))
                    {
                        List<String> imgs = new Gson().fromJson(newGoods.getGoodsImageUrl(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        unewGoods.setGoodsImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                    unewGoods.setShopId(newGoods.getShopId());
                    unewGoods.setShopName(newGoods.getShopName());
                    unewGoodsList.add(unewGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("最新商品列表：组装单个商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, unewGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("最新商品列表:获取最新商品列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_GOODSCOMMON_GETGUESSLIKEGOODSLIST)
    public TransData<Object> getGuessLiskGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            if (pageIndex >= 2)
            {
                pageIndex = 1;
            }
            //1、获取猜您喜欢列表
            List<GuessYouLikeGoods> guessYouLikeGoodsList = this.guessYouLikeQueryService.guessYouLikeGoods(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(guessYouLikeGoodsList))
            {
                GooagooLog.info("猜您喜欢：未获取到满足条件的猜您喜欢商品列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UGuessYouLikeGoods> uguessYouLikeGoodsList = new ArrayList<UGuessYouLikeGoods>();
            for (GuessYouLikeGoods guessYouLikeGoods : guessYouLikeGoodsList)
            {
                try
                {
                    UGuessYouLikeGoods uguessYouLikeGoods = new UGuessYouLikeGoods();
                    uguessYouLikeGoods.setGoodsId(guessYouLikeGoods.getGoodsId());
                    uguessYouLikeGoods.setGoodsName(guessYouLikeGoods.getGoodsName());
                    uguessYouLikeGoods.setGoodsVisitUrl(UrlUtils.getGoodsUrl(guessYouLikeGoods.getGoodsId()));
                    if (StringUtils.isNotBlank(guessYouLikeGoods.getGoodsImageUrl()))
                    {
                        List<String> imgs = new Gson().fromJson(guessYouLikeGoods.getGoodsImageUrl(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        uguessYouLikeGoods.setGoodsImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                    uguessYouLikeGoods.setShopId(guessYouLikeGoods.getShopId());
                    uguessYouLikeGoods.setShopName(guessYouLikeGoods.getShopName());
                    uguessYouLikeGoodsList.add(uguessYouLikeGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("猜您喜欢：组装单个商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uguessYouLikeGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("猜您喜欢:获取猜您喜欢异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_GOODSCOMMON_GETRECOMMENDATIONGOODSLIST)
    public TransData<Object> getRecommendationGoodsList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取推荐商品列表
            List<RecommendBusiness> nominateGoodsList = this.recommendQueryService.recommendGoods(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(nominateGoodsList))
            {
                GooagooLog.info("推荐商品列表：未获取到满足条件的推荐商品列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<URecommendGoods> urecommendGoodsList = new ArrayList<URecommendGoods>();
            for (RecommendBusiness nominateGoods : nominateGoodsList)
            {
                URecommendGoods urecommendGoods = new URecommendGoods();
                urecommendGoods.setGoodsId(nominateGoods.getInfoId());
                urecommendGoods.setGoodsName(nominateGoods.getInfotitle());
                try
                {
                    urecommendGoods.setGoodsVisitUrl(UrlUtils.getGoodsUrl(nominateGoods.getInfoId()));
                    urecommendGoods.setGoodsImage(FormatDataUtils.formatImageInfo(nominateGoods.getInfoImgUrl().split(",")[0]));
                }
                catch (Exception e)
                {
                    GooagooLog.error("推荐商品列表：生成活动（" + nominateGoods.getInfoId() + "）访问地址异常", e);
                }
                urecommendGoodsList.add(urecommendGoods);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, urecommendGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("推荐商品列表:获取推荐商品列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}

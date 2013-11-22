package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.analysis.GuessYouLikeQueryService;
import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeCoupon;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.igus.common.service.ICouponCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UGuessYouLikeCoupon;
import com.gooagoo.view.gus.web.common.URecommendCoupon;

@Service("iCouponCommonService")
public class ICouponCommonServiceImpl implements ICouponCommonService
{

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Autowired
    private GuessYouLikeQueryService guessYouLikeQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_COUPONCOMMON_GETGUESSLIKEACOUPONLIST)
    public TransData<Object> getGuessLiskCouponList(HttpServletRequest request)
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
            Map<String, List<GuessYouLikeCoupon>> guessYouLikeCouponMap = this.guessYouLikeQueryService.guessYouLikeCoupon(userId, pageIndex, pageSize);
            List<GuessYouLikeCoupon> guessYouLikeCouponList = guessYouLikeCouponMap.get("1");
            if (CollectionUtils.isEmpty(guessYouLikeCouponList))
            {
                GooagooLog.info("猜您喜欢：未获取到满足条件的猜您喜欢优惠凭证列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UGuessYouLikeCoupon> uguessYouLikeCouponList = new ArrayList<UGuessYouLikeCoupon>();
            for (GuessYouLikeCoupon guessYouLikeCoupon : guessYouLikeCouponList)
            {
                try
                {
                    UGuessYouLikeCoupon uguessYouLikeCoupon = new UGuessYouLikeCoupon();
                    uguessYouLikeCoupon.setCouponId(guessYouLikeCoupon.getCouponId());
                    uguessYouLikeCoupon.setCouponName(guessYouLikeCoupon.getCouponName());
                    uguessYouLikeCoupon.setCouponVisitUrl(UrlUtils.getCouponUrl(guessYouLikeCoupon.getCouponId()));
                    uguessYouLikeCoupon.setCouponImage(FormatDataUtils.formatImageInfo(guessYouLikeCoupon.getCouponImageUrl()));
                    uguessYouLikeCoupon.setShopId(guessYouLikeCoupon.getShopId());
                    uguessYouLikeCoupon.setShopName(guessYouLikeCoupon.getShopName());
                    uguessYouLikeCouponList.add(uguessYouLikeCoupon);
                }
                catch (Exception e)
                {
                    GooagooLog.error("猜您喜欢：组装单个优惠凭证信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uguessYouLikeCouponList);
        }
        catch (Exception e)
        {
            GooagooLog.error("猜您喜欢:获取猜您喜欢异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_COUPONCOMMON_GETRECOMMENDATIONCOUPONLIST)
    public TransData<Object> getRecommendationCouponList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取推荐优惠凭证列表
            List<RecommendBusiness> nominateCouponList = this.recommendQueryService.recommendCoupon(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(nominateCouponList))
            {
                GooagooLog.info("推荐优惠凭证列表：未获取到满足条件的推荐优惠凭证列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<URecommendCoupon> urecommendCouponList = new ArrayList<URecommendCoupon>();
            for (RecommendBusiness nominateCoupon : nominateCouponList)
            {
                try
                {
                    URecommendCoupon urecommendCoupon = new URecommendCoupon();
                    urecommendCoupon.setCouponId(nominateCoupon.getInfoId());
                    urecommendCoupon.setCouponName(nominateCoupon.getInfotitle());
                    urecommendCoupon.setCouponVisitUrl(UrlUtils.getCouponUrl(nominateCoupon.getInfoId()));
                    urecommendCoupon.setCouponImage(FormatDataUtils.formatImageInfo(nominateCoupon.getInfoImgUrl()));
                    urecommendCouponList.add(urecommendCoupon);
                }
                catch (Exception e)
                {
                    GooagooLog.error("推荐优惠凭证列表：组装单个优惠凭证信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, urecommendCouponList);
        }
        catch (Exception e)
        {
            GooagooLog.error("推荐优惠凭证列表:获取推荐优惠凭证列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }
}

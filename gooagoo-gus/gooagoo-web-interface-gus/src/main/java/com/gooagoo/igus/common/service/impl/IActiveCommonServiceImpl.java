package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeActivity;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.igus.common.service.IActiveCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UGuessYouLikeActivity;
import com.gooagoo.view.gus.web.common.URecommendActive;

@Service("iActiveCommonService")
public class IActiveCommonServiceImpl implements IActiveCommonService
{

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Autowired
    private GuessYouLikeQueryService guessYouLikeQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_ACTIVECOMMON_GETGUESSLIKEACTIVELIST)
    public TransData<Object> getGuessLiskActiveList(HttpServletRequest request)
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
            List<GuessYouLikeActivity> guessYouLikeActivityList = this.guessYouLikeQueryService.guessYouLikeActivity(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(guessYouLikeActivityList))
            {
                GooagooLog.info("猜您喜欢：未获取到满足条件的猜您喜欢活动列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UGuessYouLikeActivity> uguessYouLikeActivityList = new ArrayList<UGuessYouLikeActivity>();
            for (GuessYouLikeActivity guessYouLikeActivity : guessYouLikeActivityList)
            {
                try
                {
                    UGuessYouLikeActivity uguessYouLikeActivity = new UGuessYouLikeActivity();
                    uguessYouLikeActivity.setActivityId(guessYouLikeActivity.getActivityId());
                    uguessYouLikeActivity.setActivityName(guessYouLikeActivity.getActivityName());
                    uguessYouLikeActivity.setActivityVisitUrl(UrlUtils.getActiveUrl(guessYouLikeActivity.getActivityId()));
                    uguessYouLikeActivity.setActivityImage(FormatDataUtils.formatImageInfo(guessYouLikeActivity.getActivityImageUrl()));
                    uguessYouLikeActivity.setShopId(guessYouLikeActivity.getShopId());
                    uguessYouLikeActivity.setShopName(guessYouLikeActivity.getShopName());
                    uguessYouLikeActivityList.add(uguessYouLikeActivity);
                }
                catch (Exception e)
                {
                    GooagooLog.error("猜您喜欢：组装单个活动信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uguessYouLikeActivityList);
        }
        catch (Exception e)
        {
            GooagooLog.error("猜您喜欢:获取猜您喜欢异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_ACTIVECOMMON_GETRECOMMENDATIONACTIVITYLIST)
    public TransData<Object> getRecommendationActivityList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取推荐活动列表
            List<RecommendBusiness> nominateActivityList = this.recommendQueryService.recommendActivity(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(nominateActivityList))
            {
                GooagooLog.info("推荐活动列表：未获取到满足条件的推荐活动列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<URecommendActive> urecommendActiveList = new ArrayList<URecommendActive>();
            for (RecommendBusiness nominateActivity : nominateActivityList)
            {
                try
                {
                    URecommendActive urecommendActive = new URecommendActive();
                    urecommendActive.setActiveId(nominateActivity.getInfoId());
                    urecommendActive.setActiveName(nominateActivity.getInfotitle());
                    urecommendActive.setActiveVisitUrl(UrlUtils.getActiveUrl(nominateActivity.getInfoId()));
                    urecommendActive.setActiveImage(FormatDataUtils.formatImageInfo(nominateActivity.getInfoImgUrl()));
                    urecommendActiveList.add(urecommendActive);
                }
                catch (Exception e)
                {
                    GooagooLog.error("推荐活动列表：组装单个活动信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, urecommendActiveList);
        }
        catch (Exception e)
        {
            GooagooLog.error("推荐活动列表:获取推荐活动列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}

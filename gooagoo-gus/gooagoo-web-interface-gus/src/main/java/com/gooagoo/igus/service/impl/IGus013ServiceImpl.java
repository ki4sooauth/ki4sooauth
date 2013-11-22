package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UActivity;

/**
 * 获取推荐活动列表
 * @author SPZ
 *
 */
@Service("igus013Service")
public class IGus013ServiceImpl implements IGusService
{

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            List<RecommendBusiness> nominateActivityList = this.recommendQueryService.recommendActivity(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(nominateActivityList))
            {
                GooagooLog.error("获取推荐活动列表：未获取到满足条件的推荐活动列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UActivity> uactivityList = new ArrayList<UActivity>();
            for (RecommendBusiness nominateActivity : nominateActivityList)
            {
                UActivity uactivity = new UActivity();
                uactivity.setActivityId(nominateActivity.getInfoId());
                uactivity.setActivityName(nominateActivity.getInfotitle());
                uactivity.setActivityLink(UrlUtils.getActiveUrl(nominateActivity.getInfoId()));
                uactivity.setActivityImage(FormatDataUtils.formatImageInfo(nominateActivity.getInfoImgUrl()));
                uactivityList.add(uactivity);
            }
            transData = new TransData<Object>(true, null, uactivityList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取推荐活动列表：获取推荐活动列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}

package com.gooagoo.igms.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

public class ReleaseUtil
{
    /**
     * 获取发布条件内容
     * @param request
     * @return
     * @throws Exception
     */
    public static FRuleInfo getRuleInfo(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", null);
        String expectPublishTime = ServletRequestUtils.getStringParameter(request, "expectPublishTime", null);
        FRuleCondition ruleCondition = GMSServiceUtil.getFRuleCondition(request);
        FRuleInfo ruleInfo = ServletUtils.objectMethod(FRuleInfo.class, request);

        if (org.springframework.util.StringUtils.hasText(expectPublishTime))
        {
            ruleInfo.setExpectPublishTime(TimeUtils.convertStringToDate(expectPublishTime + ":00"));
        }
        ruleInfo.setCrowdType(ruleCondition.getConditionType());

        String ruleContent = new Gson().toJson(ruleCondition);

        ruleInfo.setShopId(shopId);
        ruleInfo.setRuleContent(ruleContent);
        ruleInfo.setEndTime(GMSUtil.getMidNight(ruleInfo.getEndTime()));

        ruleInfo.setPublishStatus("P");
        ruleInfo.setIsDel("N");

        if (ruleId == null || ruleId == "")
        {
            ruleInfo.setRuleId(StringUtils.getUUID());
        }

        return ruleInfo;
    }
}

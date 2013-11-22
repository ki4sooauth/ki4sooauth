package com.gooagoo.gstatus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivity;

@Controller
@RequestMapping("/activity")
public class ActivityAction
{
    /**
     * 跳转活动状态页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String activeIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        request.setAttribute("relateType", "A");
        request.setAttribute("dataType", "MS");

        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FActivity> pm = respObj.getData();

        if (null != pm && null != pm.getResult() && !pm.getResult().isEmpty())
        {
            request.setAttribute("parentId", pm.getResult().get(0).getActivityId());
            request.setAttribute("parentName", pm.getResult().get(0).getActivityName());
        }
        StatisUtil.getEntityInfo(request);
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag","activity");
        return "status/activity/activeStatus";
    }
}

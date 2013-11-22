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
import com.gooagoo.view.gms.notice.FNotice;

@Controller
@RequestMapping("/notice")
public class NoticeAction
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
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	request.setAttribute("relateType", "N");
        request.setAttribute("dataType", "MS");
    	TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FNotice> pm = respObj.getData();
        if (null != pm && null != pm.getResult() && !pm.getResult().isEmpty())
        {   
        	request.setAttribute("parentId", pm.getResult().get(0).getNoticeInfoId());
        	request.setAttribute("parentName", pm.getResult().get(0).getNoticeTitle());
        }
        StatisUtil.getEntityInfo(request);
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag","notice");
        return "status/notice/noticeStatus";
    }
}

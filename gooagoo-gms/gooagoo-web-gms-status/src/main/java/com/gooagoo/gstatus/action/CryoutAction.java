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
import com.gooagoo.view.gms.cryout.FCryout;

@Controller
@RequestMapping("/cryout")
public class CryoutAction {
	/**
	 * 跳转活动状态页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

			request.setAttribute("relateType", "M");
			request.setAttribute("dataType", "MS");
			TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
			PageModel<FCryout> pm = respObj.getData();
			if (null != pm && null != pm.getResult() && !pm.getResult().isEmpty()) {
				request.setAttribute("parentId", pm.getResult().get(0).getCryoutInfoId());
				request.setAttribute("parentName", pm.getResult().get(0).getCryoutTitle());
			}
		StatisUtil.getEntityInfo(request);
		GMSUtil.getWebUrlByAuthorityId(request,"12");
		request.setAttribute("pageFlag", "cryout");
		return "status/cryout/cryoutStatus";
	}
}

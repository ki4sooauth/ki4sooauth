package com.gooagoo.gresource.auction.action;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.resource.AdBidInfoView;
import com.gooagoo.view.gms.resource.AdView;
import com.google.gson.Gson;

@Controller
@RequestMapping("/auction")
public class AuctionAction extends BaseAction implements ServletContextAware {

	private ServletContext servletContext;
     
	@RequestMapping(params = "method=toIndex")
	public String goIndex(HttpServletRequest request, HttpServletResponse response) {
		return "webResource/index";
	}
	
	
	@RequestMapping(params = "method=auction")
	public void auction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<Object> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_AUCTION, request, Object.class);		
		String resultCode = respObj.getHead().getResultCode();
		String resultName = ExceptionCache.get(resultCode);
		if (!StringUtils.hasText(resultName)) {
			GooagooLog.info("获取提示信息名称为空，resultName=" + resultName + ",resultCode=" + resultCode);
			resultName = resultCode;
		}
		GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);
		Object data = respObj.getData();
		if (data instanceof String) {
			rv.setExtend((String) data);
		}
		if (rv.getSuccess()) {
			double biddAmount = ServletRequestUtils.getDoubleParameter(request, "bidAmount", 0D);
			String biddingNo = ServletRequestUtils.getStringParameter(request, "biddingNo", "");
			String shopName = GMSUtil.getShopLoginInfoByWeb(request).getShopAndUserInfo().getShopName();
			pushMsg(biddAmount, biddingNo,shopName);
		}
		request.setAttribute("auctionResult",rv.getSuccess());
		ServletUtils.writeHtml(new Gson().toJson(rv), response);
	}

	@RequestMapping(params = "method=findAllAd")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findAllAd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<List> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_FIND_AD, request, List.class);
		List<AdView> adList = transData.getData();
		ServletUtils.writeHtml(new Gson().toJson(adList), response);
	}

	@RequestMapping(params = "method=findAdBidInfo")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAdBidInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<List> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_GET_AD_BID_INFO, request, List.class);
		List<AdBidInfoView> adBidInfoList = transData.getData();
		Date dbTimeByWeb = GMSServiceUtil.getDBTimeByWeb(request);
		request.setAttribute("adBidTime",new Gson().toJson(adBidInfoList));
		request.setAttribute("dbTime", dbTimeByWeb.getTime());
		request.setAttribute("adBidInfoList", adBidInfoList);
		return "webResource/auction/common/bidInfos";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@SuppressWarnings({ "rawtypes" })
	private void pushMsg(Double amount, String biddingNo,String shopName) {
		ServerContext serverContext = ServerContextFactory.get(this.servletContext);
		Collection scriptSessions = serverContext.getAllScriptSessions();
		Util util = new Util(scriptSessions);
		util.addFunctionCall("updateInfo", amount, biddingNo,shopName);
	}
}

package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.gmember.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.FMemberBaseInfo;
import com.gooagoo.view.gms.member.UserStatusView;
import com.google.gson.Gson;

@Controller
@RequestMapping("/userState")
public class UserStateAction {
	/**
	 * 用户状态主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=index")
	public String userStateIndex(HttpServletRequest request, HttpServletResponse response) {
        
		ShopLoginInfo shopLoginInfoByWeb = GMSUtil.getShopLoginInfoByWeb(request);
		request.setAttribute("shopInfo",shopLoginInfoByWeb);
		return "crm/userState/userState";
	}


	/**
	 * 查询用户状态信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "method=userRecordData")
	public void userRecordData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String> recordData = new HashMap<String, String>();
		String storeTheUser = "0";
		String storeTheMember = "0";
		String mobileInteractiveMember = "0";
		String webInteractiveMember = "0";
		String newMembers = "0";
		String potentialMember = "0";
		String webPotentialMember = "0";
		String mobilePotentialMember = "0";
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		TransData<List> dataList = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_RIGHT_MENU_DATA, request, List.class);
		if (dataList != null && !CollectionUtils.isEmpty(dataList.getData())) {
			List<?> rData = dataList.getData();
			storeTheUser = String.valueOf(rData.get(0));
			storeTheMember = String.valueOf(rData.get(1));
			mobileInteractiveMember = String.valueOf(rData.get(2));
			webInteractiveMember = String.valueOf(rData.get(3));
			newMembers = String.valueOf(rData.get(4));
			potentialMember = String.valueOf(rData.get(5));
			webPotentialMember = String.valueOf(rData.get(6));
			mobilePotentialMember = String.valueOf(rData.get(7));
		}else{
			GooagooLog.warn("获取CPM右则菜单数据错误");
		}
		// 店内用户
		recordData.put("storeTheUser", storeTheUser);
		// 店内会员
		recordData.put("storeTheMember", storeTheMember);
		// 手机潜在会员
		recordData.put("mobileInteractiveMember", mobileInteractiveMember);
		// web潜在会员
		recordData.put("webInteractiveMember", webInteractiveMember);
		// 新增会员信息
		recordData.put("newMembers", newMembers);
		// 店内潜在会员数
		recordData.put("potentialMember", potentialMember);
		// web互动会员
		recordData.put("webPotentialMember", webPotentialMember);
		// 手机互动会员
		recordData.put("mobilePotentialMember", mobilePotentialMember);
		String data = new Gson().toJson(recordData);
		ServletUtils.writeString(data, response);
	}

	/**
	 * 用户历史实时状态详细信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=findUserStatusList")
	public String findUserStatusList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TransData<PageModel> tpm = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_CRM_GET_USERSTATUS_USERINFO_PAGE, request, PageModel.class);
		PageModel<UserStatusView> pm = tpm.getData();
		request.setAttribute("pageModel", pm);
		request.setAttribute("page_cur", pm.getPageIndex());
		request.setAttribute("page_start", pm.getPageStart(5));
		request.setAttribute("page_end", pm.getPageEnd(5));
		return "crm/userState/table";
	}

	/**
	 * 跳转用户列表信息首页
	 * @param requestT
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=toUserListIndex")
	public String toTableIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "crm/userState/userListIndex";
	}

	/**
	 * 查询新增会员信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=searchNewMember")
	public String searchNewMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("cTimeStamp_FE", TimeUtils.getCurrentDate() + " 00:00:00");
		request.setAttribute("cTimeStamp_TE", TimeUtils.getCurrentDate() + " 23:59:59");
		request.setAttribute("orderBy", "c_time_stamp desc");
		TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_MEMSPECIALPAGE, request, PageModel.class);
		PageModel<FMemberBaseInfo> pm = respObj.getData();
		request.setAttribute("pageModel", pm);
		request.setAttribute("page_cur", pm.getPageIndex());
		request.setAttribute("page_start", pm.getPageStart(5));
		request.setAttribute("page_end", pm.getPageEnd(5));
		return "crm/userState/newMemberTable";
	}
	

	/**
	 * 保存用户状态人群信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=saveCrowdForUserState")
	public void saveCrowdForUserState(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_CRM_SAVE_CROWD_FOR_USERSTATE, request, response);
	}
	
	/**
	 * 跳转保存用户群首页
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=toSaveCrowdIndex")
	public String toSaveCrowdIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  return "crm/userState/saveCrowdIndex";	
	}
	
	
	/**
	 * 获取当前时刻图表数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getCurrentChart")
	public void getCurrentChart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		TransData<Integer> userStateTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERSTATE_GET_CURRENT_DATA_FOR_CHART, request, Integer.class);
		String result="";
		if(userStateTransData!=null){
			 result = new Gson().toJson(userStateTransData.getData());	
		}
		ServletUtils.writeHtml(result, response);
	}
	
	
	/**
	 * 获取当前小时当前天图表数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getCurrentHourAndDayData")
	@SuppressWarnings("rawtypes")
	public void getCurrentHourAndDayDataForChart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		TransData<List> userStateTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERSTATE_GET_CURRENT_HOUR_AND_DAY_DATA_FOR_CHART, request, List.class);
		String result="";
		if(userStateTransData!=null){
			 result = new Gson().toJson(userStateTransData.getData());	
		}
		ServletUtils.writeHtml(result, response);
	}
	
	
	/**
	 * 获取历史指定时间图表数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "method=getHisDataForChart")
	public void getHisDataForChart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置不发送消息
	    request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
	    
		boolean isReadFile = ServletRequestUtils.getBooleanParameter(request, "isReadFile", true);
		String result = "";
		if(isReadFile){
			List<String> fileList = new ArrayList<String>(0);
			List<String> fileUrls = StatisUtil.getFileUrl(request);
			for (String url : fileUrls) {
			   String fileStr = HttpClientUtils.loadFileStringByUrl(url);
			   fileList.add(StringUtils.isNotBlank(fileStr)?fileStr:"");
			}
			result = new Gson().toJson(fileList);
		}else{
			TransData<List> pointList = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_DYNAMIC_POINT_DATA, request, List.class);
			if(pointList!=null && !CollectionUtils.isEmpty(pointList.getData())){
				result = new Gson().toJson(pointList.getData());	
			}
		}
		ServletUtils.writeHtml(result, response);
	}
}

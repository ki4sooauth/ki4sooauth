package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.CrowdInfoVo;
import com.gooagoo.view.gms.crm.FCRMMemberBaseInfo;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/statistical")
public class StatisticalAction extends BaseAction {

	/**
	 * 获取用户常用细分统计图表数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getCommonlyUsedStatisticalData")
	public void getCommonlyUsedStatisticalData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		TransData<FhighChartVo> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_COMMONLY_USED_STATISTICAL_DATA, request, FhighChartVo.class);
		FhighChartVo data = transfer.getData();
		String content = new Gson().toJson(data);
		ServletUtils.writeHtml(content, response);
	}

	/**
	 * 获取用户自定义统计分类统计数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=customQueryStatistics")
	public void customQueryStatistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		TransData<FhighChartVo> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_CUSTOM_QUERY_STATISTICS, request, FhighChartVo.class);
		FhighChartVo data = transfer.getData();
		String content = new Gson().toJson(data);
		ServletUtils.writeHtml(content, response);
	}

	/**
	 * 保存用户信息人群
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "method=saveCrowdInfo")
	public void saveCrowdInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_CRM_SAVE_CROWD_INFO, request, response);
	}

	/**
	 * 获取保存的人群信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=findCrowdInfo")
	public void findCrowdInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TransData<List> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_FIND_CROWDINFO, request, List.class);
		List<CrowdInfoVo> crowdList = transfer.getData();
		request.setAttribute("crowdList", crowdList);
	}

	/**
	 * 保存用户自定义统计类型（条件）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "method=saveCustomStatisticCondition")
	public void saveCustomStatisticCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_CRM_SAVE_CUSTOM_STATISTIC_CONDITION, request, response);
	}
	
	
    /**
     * 跳转用户详细信息列表（用户常档案统计）
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=toUserListIndex")
    public String toUserListIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "crm/userRecord/userListIndex";
    }
	
	/**
	 * 获取用户详细息列表（图点击事件）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=getUserList")
	public String getUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERSTATE_PAGE, request, PageModel.class);
		PageModel<FCRMMemberBaseInfo> pm = respObj.getData();
		request.setAttribute("pm", pm);
		request.setAttribute("page_cur", pm.getPageIndex());
		request.setAttribute("page_start", pm.getPageStart(5));
		request.setAttribute("page_end", pm.getPageEnd(5));
		return "crm/userRecord/userList";
	}
	
	
	 /**
     * 跳转用户人群保存页
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=toSaveCrowdIndex")
    public String toSaveCrowdIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "crm/userRecord/saveCrowdIndex";
    }
    
    
    /**
     * 获取用户自定义查询条件统计图(己保存的自定义统计条件，对应用户常用细分，自定义统计查询)
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=getHasSavedQueryConditionChart")
    public void getHasSavedQueryConditionChart(HttpServletRequest request, HttpServletResponse response) throws IOException
    {   
    	//设置不发送消息
    	request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
    	TransData<FhighChartVo> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_HAS_SAVE_QUERY_CONDITION_CHART, request, FhighChartVo.class);
		FhighChartVo data = transfer.getData();
		String content = new Gson().toJson(data);
		ServletUtils.writeHtml(content, response);
    }
    
    
    /**
	 * 获取用户自定义查询条件详细息列表（图点击事件）(己保存的自定义统计条件，对应用户常用细分，自定义统计查询)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=findQCUserList")
	public String findHasSavedQConUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERSTATE_PAGE, request, PageModel.class);
		PageModel<FCRMMemberBaseInfo> pm = respObj.getData();
		request.setAttribute("pm", pm);
		request.setAttribute("page_cur", pm.getPageIndex());
		request.setAttribute("page_start", pm.getPageStart(5));
		request.setAttribute("page_end", pm.getPageEnd(5));
		return "crm/userRecord/userList";
	}
	
	 /**
		 * 保存自定义用户统计类型用户信息(己保存的自定义统计条件，对应用户常用细分，自定义统计查询)
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(params = "method=saveQCUserCrowd")
		public void saveHasSavedQCCrowd(HttpServletRequest request, HttpServletResponse response) throws Exception {
			GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_CRM_SAVE_CROWD_INFO, request, response);
		}
	

}

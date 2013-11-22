package com.gooagoo.gstatus.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.gstatus.util.StatisUtil;
import com.google.gson.Gson;

/**
 * 获得实时数据
 * 
 */
@Controller
@RequestMapping("statis")
public class MStatisticsAction {
	/**
	 * 获得实时数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "method=getChartData")
	public void getChartData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String hisOrCurr = ServletRequestUtils.getStringParameter(request, "hisOrCurr", "C");
		boolean isReadFile = ServletRequestUtils.getBooleanParameter(request,"isReadFile", true);
		boolean isUpdate = ServletRequestUtils.getBooleanParameter(request,"isUpdate", false);
		
		String result = "";
		//设置不发送消息
		request.setAttribute(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH);
		
		if ("C".equals(hisOrCurr)) {
			if(isUpdate){
				TransData<List> data = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_STATUS_GET_DYNAMIC_POINT_DATA , request, List.class);
				result = new Gson().toJson(data.getData());
			}else{
				TransData<String> data = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_CRM_FIND_CURRENT_STATUS, request, String.class);
				result = data.getData();
			}
		}else{
			if(isReadFile){
				String fileUrl = StatisUtil.getFileUrl(request);
				result = HttpClientUtils.loadFileStringByUrl(fileUrl);
				if(StringUtils.isBlank(result)){
				  GooagooLog.debug("营销状态获取文件数据错误");	
				  result="";
				}
			}else{
				TransData<List> data = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_STATUS_GET_DYNAMIC_POINT_DATA , request, List.class);
				result = new Gson().toJson(data.getData());
			}
		}
		ServletUtils.writeHtml(result, response);
	}
	
	
}

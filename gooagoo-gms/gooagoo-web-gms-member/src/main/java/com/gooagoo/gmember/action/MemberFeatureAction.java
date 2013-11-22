package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.google.gson.Gson;

@Controller
@RequestMapping("/memberFeature")
public class MemberFeatureAction extends BaseAction {
	
	/**
	 * 查询会员特征信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "method=findMemberFeature")
	public String findMemberFeature(HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("rawtypes")
		TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
		List<FMemberFeature> fmemberFeatureList = null;
		if(respObj!=null && !CollectionUtils.isEmpty(respObj.getData())){
		fmemberFeatureList = respObj.getData();
        for (FMemberFeature fm : fmemberFeatureList)
        {
            String value = fm.getEnumValue();
			List<String> list = new Gson().fromJson(value, List.class);
            for (int i = 0; list != null && i < list.size(); i++)
            {
                if (i == 0)
                {
                    value = list.get(i);
                }
                else
                {
                    value += " " + list.get(i);
                }
            }
            fm.setEnumValue(value);
        }
        }
		request.setAttribute("result", fmemberFeatureList);
		return "crm/userRecord/memberFeature";
	}
	
	
	/**
	 * 会员特征-新增页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=toAddForm")
	public String addMemberFeatureForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "crm/userRecord/addMemberFeature";
	}

	/**
	 * 会员特征-新增操作
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addMemberFeature")
	public void addMemberFeature(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_ADD_SPECIAL, request, response);
	}

	/**
	 * 会员特征-编辑页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "method=toUpdateForm")
	public String updateMemberFeatureForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
		List<FMemberFeature> fmemberFeatureList = respObj.getData();
		FMemberFeature memberFeature = new FMemberFeature();
		for (FMemberFeature fm : fmemberFeatureList) {
			if (request.getParameter("id").toString().equals(fm.getId())) {
				String value = fm.getEnumValue();
				List<String> list = new Gson().fromJson(value, List.class);
				for (int i = 0; list != null && i < list.size(); i++) {
					if (i == 0) {
						value = list.get(i);
					} else {
						value += " " + list.get(i);
					}
				}
				fm.setEnumValue(value);
				memberFeature = fm;
				break;
			}
		}
		request.setAttribute("memberFeature", memberFeature);
		return "crm/userRecord/updateMemberFeature";
	}

	/**
	 * 会员特征-编辑操作
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updateMemberFeature")
	public void updateMemberFeature(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_DEL_SPECIAL, request, response);
	}

	/**
	 * 会员特征-删除操作
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "method=deleteMemberFeature")
	public void deleteMemberFeature(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_UPDATE_SPECIAL, request, response);
	}
	
	
	/**
	 * 修改会员特征信息时获取会员特征值
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getMemberFeatureValues")
	public void getMemberFeatureValues(HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("rawtypes")
		TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
        Map<String,List<String>> featureMap = new HashMap<String, List<String>>();
        @SuppressWarnings("unchecked")
		List<FMemberFeature> fmemberFeatureList = respObj.getData();
        for (FMemberFeature fm : fmemberFeatureList)
        {
            String value = fm.getEnumValue();
            @SuppressWarnings("unchecked")
			List<String> featureList = new Gson().fromJson(value, List.class);
            featureMap.put(fm.getTypeCode(), featureList);
        }
        String json = new Gson().toJson(featureMap);
        ServletUtils.writeHtml(json, response);
	}
}

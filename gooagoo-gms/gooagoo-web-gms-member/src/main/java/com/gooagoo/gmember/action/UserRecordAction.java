package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.freemarker.UserSearchFtlUtil;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.account.UserView;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.CrowdInfoVo;
import com.gooagoo.view.gms.crm.FActionRecord;
import com.gooagoo.view.gms.crm.FConsumeRecord;
import com.gooagoo.view.gms.crm.FIntegralRecord;
import com.gooagoo.view.gms.crm.FPropertyRecord;
import com.gooagoo.view.gms.crm.QueryConditionVo;
import com.gooagoo.view.gms.crm.StatisticsTypeVo;
import com.gooagoo.view.gms.crm.UserRecordLeftMenuVo;
import com.gooagoo.view.gms.member.FMemberCard;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.google.gson.Gson;

@Controller
@RequestMapping("/userRecord")
public class UserRecordAction extends BaseAction {

	/**
	 * 用户档案主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "crm/userRecord/index";
	}

	/**
	 * 用户档案主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=userRecord")
	public String userRecord(HttpServletRequest request, HttpServletResponse response) {
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		request.setAttribute("accountId", accountId);
		request.setAttribute("accountType", accountType);
		
		TransData<UserRecordLeftMenuVo> transData = GMSHttpUtils.transfer(InterGmsConstants.GET_USERINFO_FOR_RECORD_PAGE_LEFT_MENU, request, UserRecordLeftMenuVo.class);
		if(transData!= null){
		   UserRecordLeftMenuVo menu = transData.getData();
		   request.setAttribute("menu", menu);	
		}else{
		   GooagooLog.debug("用户状态（用户详细信息面页）获取左侧菜单数据错误");
		}
		return "crm/userRecord/userRecord";
	}

	/**
	 * 基于筛选条件，查询用户档案信息列
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=forTable")
	public String userRecordsSearchForTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TransData<PageModel> userRecorddTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERRECORD_SIFT, request, PageModel.class);
		PageModel<UserView> pm = userRecorddTransData.getData();
		GooagooLog.debug("CPM查询用户档案信息列返回信息pm：" + pm);
		if (pm != null) {
			Map<String, String> map = SysdictionaryCache.get("user_type");
			request.setAttribute("userTypes", map);
			request.setAttribute("pageModel", pm);
			request.setAttribute("page_cur", pm.getPageIndex());
			request.setAttribute("page_start", pm.getPageStart(5));
			request.setAttribute("page_end", pm.getPageEnd(5));
		}
		return "crm/userRecord/table";

	}

	/**
	 * 获取用户属性信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getAttrRecord")
	public String getAttrRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TransData<FPropertyRecord> propertyRecorData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_PROPERTY_RECORD, request, FPropertyRecord.class);
		FPropertyRecord propertyRecord = propertyRecorData.getData();
		if (null != propertyRecord && propertyRecord.getAccountBaseInfo() != null) {
			String string = SysdictionaryCache.get("idtype", propertyRecord.getAccountBaseInfo().getIdType());
			propertyRecord.getAccountBaseInfo().setIdTypeCn(string);
		}
		request.setAttribute("propertyRecord", propertyRecord);
		return "crm/userRecord/attributeRecord";
	}

	/**
	 * 获取用户属性信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "method=features")
	public void getfeatures(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TransData<List> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
		List<FMemberFeature> fmemberFeatures = transData.getData();
		String json = new Gson().toJson(fmemberFeatures);
		ServletUtils.writeHtml(json, response);
	}

	/**
	 * 获取用户行为信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getBehaviourRecord")
	public String getBehaviourRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		@SuppressWarnings("rawtypes")
		TransData<PageModel> actionRecordData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_ACTION_RECORD, request, PageModel.class);
		@SuppressWarnings("unchecked")
		PageModel<FActionRecord> pm = actionRecordData.getData();
		request.setAttribute("pageModel", pm);
		if (null != pm) {
			List<FActionRecord> result = pm.getResult();
			for (FActionRecord fActionRecord : result) {
				String strt = SysdictionaryCache.get("behave_type", fActionRecord.getActionType());
				String strs = SysdictionaryCache.get("behave_source", fActionRecord.getSource());
				fActionRecord.setActionType(StringUtils.isBlank(strt) ? "其他" : strt);
				fActionRecord.setSource(StringUtils.isBlank(strs) ? "其他" : strs);
			}
			request.setAttribute("page_cur", pm.getPageIndex());
			request.setAttribute("page_start", pm.getPageStart(5));
			request.setAttribute("page_end", pm.getPageEnd(5));
		}
		return "crm/userRecord/behaviourRecord";
	}

	/**
	 * 获取消费行为信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getConsumeRecord")
	public String getConsumeRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		@SuppressWarnings("rawtypes")
		TransData<PageModel> consumeRecordData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_CONSOME_RECORD, request, PageModel.class);
		@SuppressWarnings("unchecked")
		PageModel<FConsumeRecord> pm = consumeRecordData.getData();
		request.setAttribute("pageModel", pm);
		if (null != pm) {
			request.setAttribute("page_cur", pm.getPageIndex());
			request.setAttribute("page_start", pm.getPageStart(5));
			request.setAttribute("page_end", pm.getPageEnd(5));
		}
		return "crm/userRecord/consumeRecord";
	}

	/**
	 * 获取积分档案信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "method=getScoreRecord")
	public String getBillDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		@SuppressWarnings("rawtypes")
		TransData<PageModel> consumeRecordData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_CONSOME_DETAIL, request, PageModel.class);
		@SuppressWarnings("unchecked")
		PageModel<FIntegralRecord> list = consumeRecordData.getData();
		if (null != list) {
			for (FIntegralRecord integ : list.getResult()) {
				String interString = SysdictionaryCache.get("integral_source", integ.getIntegralSource());
				integ.setIntegralSource(interString);
			}
			request.setAttribute("pageModel", list);
			request.setAttribute("page_cur", list.getPageIndex());
			request.setAttribute("page_start", list.getPageStart(5));
			request.setAttribute("page_end", list.getPageEnd(5));
		}
		return "crm/userRecord/integralRecord";
	}

	/**
	 * 跳转页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=toPage")
	public String toSearchMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = ServletRequestUtils.getStringParameter(request, "flag", "");
		if (flag.equals("toSearchMember")) {
			String userPropertyContentOnHistory = UserSearchFtlUtil.getUserPropertyContentOnHistory(request, new FHistoryCondition());
			request.setAttribute("condition", userPropertyContentOnHistory);
			return "crm/userRecord/searchMember";
		} else if (flag.equals("toOverAllStatus")) {
			try {
				List<String> list = new ArrayList<String>();
				list.add("T");
				list.add("S");
				getInitData(request, list);
			} catch (Exception e) {
				GooagooLog.error("跳转用户常用细分面页错误", e);
			}
			return "crm/userRecord/overallStatus";
		} else if (flag.equals("toUserStatus")) {
			return "crm/userRecord/userDepthDivisions";
		} else if (flag.equals("toSearchMemberStatistic")) {
			List<String> list = new ArrayList<String>();
			list.add("T");
			list.add("P");
			getInitData(request, list);
			String userPropertyContentOnHistory = UserSearchFtlUtil.getUserPropertyContentOnHistory(request, new FHistoryCondition());
			request.setAttribute("condition", userPropertyContentOnHistory);
			return "crm/userRecord/searchMemberStatistic";
		} else if (flag.equals("toMemberFeature")) {
			return "redirect:memberFeature.do?method=findMemberFeature";
		}
		return "";
	}

	/**
	 * 更新会员特征值
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "method=updateSpecoal")
	public void updateMemberSpecoal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_UPDATE_SPECIAL_VALUE, request, response);
	}

	// 获取页面初使化数据
	@SuppressWarnings("rawtypes")
	private void getInitData(HttpServletRequest request, List<String> list) {
		if (list.contains("F")) {
			// 获取会员特征
			TransData<List> fmemberFeaturesTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
			List<FMemberFeature> fmemberFeatures = fmemberFeaturesTransData.getData();
			if (CollectionUtils.isNotEmpty(fmemberFeatures)) {
				for (FMemberFeature fMemberFeature : fmemberFeatures) {
					String enumValue = fMemberFeature.getEnumValue();
					fMemberFeature.setValuelist(new Gson().fromJson(enumValue, List.class));
				}
			}
			request.setAttribute("fmemberFeatures", fmemberFeatures);
		}

		if (list.contains("C")) {
			// 获取会员卡列表
			TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_PAGE, request, List.class);
			List<FMemberCard> cardList = respObj.getData();
			request.setAttribute("cardList", cardList);
		}

		if (list.contains("T")) {
			// 获取统计类型
			TransData<List> respStatistic = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_GET_STATISTICS_TYPE, request, List.class);
			List<StatisticsTypeVo> typeList = respStatistic.getData();
			request.setAttribute("typeList", typeList);
		}

		if (list.contains("S")) {
			// 获取自定义统计条件
			TransData<List> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_FIND_CUSTOM_STATISTIC_CONDITION, request, List.class);
			List<QueryConditionVo> conList = transfer.getData();
			request.setAttribute("queryCondition", conList);
		}
		
		if (list.contains("P")) {
			// 获取自定义统计条件
			TransData<List> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_FIND_CROWDINFO, request, List.class);
			List<CrowdInfoVo> crowdList = transfer.getData();
			request.setAttribute("crowdList", crowdList);
		}
		
		if (list.contains("D")) {
			// 获取字典表数据
			String[] arr = { "publish_status", "user_type", "sex", "idtype", "behave_type", "rule_type", "rule_result_type", "rule_active_type", "info_source", "week_type", "relation_type" };
			for (int i = 0; i < arr.length; i++) {
				Map<String, String> map = new TreeMap<String, String>();
				if (SysdictionaryCache.get(arr[i]) != null) {
					map.putAll(SysdictionaryCache.get(arr[i]));
					request.setAttribute(arr[i], map);
				}
			}
		}
	}

}

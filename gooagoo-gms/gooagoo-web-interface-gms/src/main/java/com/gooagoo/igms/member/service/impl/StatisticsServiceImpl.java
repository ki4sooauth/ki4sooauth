package com.gooagoo.igms.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.analysis.AnalysisTypeService;
import com.gooagoo.api.business.query.statistics.CrowdOperationQueryService;
import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.api.business.query.statistics.QueryParametersQueryService;
import com.gooagoo.api.business.query.statistics.RecordStatisticQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.statistics.ShopPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.marketing.analysis.AnalysisType;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.marketing.rule.NaturalAttribute;
import com.gooagoo.entity.business.statistics.BasicQueryParameters;
import com.gooagoo.entity.business.statistics.ChartVo;
import com.gooagoo.entity.business.statistics.UserGroup;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.property.AccountBaseInfo;
import com.gooagoo.entity.business.user.account.property.AccountTypeInfo;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.igms.cache.GMSCache;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.member.service.StatisticsService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.CrowdInfoVo;
import com.gooagoo.view.gms.crm.FCRMMemberBaseInfo;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.QueryConditionVo;
import com.gooagoo.view.gms.crm.StatisticsTypeVo;
import com.gooagoo.view.gms.crm.YDataVo;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.gooagoo.view.gms.rule.FNaturalAttribute;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

@Service("cpmStatisticsService")
public class StatisticsServiceImpl implements StatisticsService {
	@Autowired
	private UserCacheQueryService userCacheQueryService;
	@Autowired
	private RecordStatisticQueryService recordStatisticService;

	@Autowired
	private ShopPeopleStatisticsQueryService shopPeopleStatisticsService;
	@Autowired
	private CrowdOperationQueryService crowdOperationService;

	@Autowired
	private AnalysisTypeService analysisTypeService;
	@Autowired
	private QueryParametersQueryService queryParametersService;
	@Autowired
	private ShopLoginService shopLoginService;
	@Autowired
	private InteractiveQueryService interactiveQueryService;
	@Autowired
	private ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsQueryService;
	
	private static final String SYSTEMIC="S"; //统计类型(系统的)
	private static final String CUSTOM="C";  //统计类型(用户自定义的)

	@Override
	public TransData<List<StatisticsTypeVo>> getStatisticsType(HttpServletRequest request) throws Exception {
		List<StatisticsTypeVo> typeList = new ArrayList<StatisticsTypeVo>(0);
		String shopIdByInterface = GmsInterfaceUtil.getShopIdByInterface(request);
		GooagooLog.debug("crm获取统计类型传入参数为：" + shopIdByInterface);
		List<AnalysisType> analysisTypeList = analysisTypeService.getAnalysisTypeList(shopIdByInterface);
		GooagooLog.debug("crm获取统计类型返回信息为：" + new Gson().toJson(analysisTypeList));
		StatisticsTypeVo statisticsTypeVo = null;
		for (AnalysisType analysisType : analysisTypeList) {
			statisticsTypeVo = new StatisticsTypeVo();
			statisticsTypeVo.setCode(analysisType.getTypeCode());
			String typeCode = analysisType.isCustom() ? CUSTOM : SYSTEMIC;
			statisticsTypeVo.setCodeType(typeCode);
			statisticsTypeVo.setName(analysisType.getTypeName());
			typeList.add(statisticsTypeVo);
		}
		return GMSUtil.toTransData(true, null, typeList);
	}

	@Override
	public TransData<FhighChartVo> getCustomStatisticsFigureData(HttpServletRequest request) throws Exception {
		String chartName = ServletRequestUtils.getStringParameter(request, "chartName", ""); // 图表名称
		String statisType = ServletRequestUtils.getStringParameter(request, "statisticType", "");
		HistoryCondition historyCondition = this.getHistoryCondition(request);
		GooagooLog.debug("自定义查询统计接收参数：【statisticType】:" + statisType + "【historyCondition】：" + new Gson().toJson(historyCondition));
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
		List<Account> userAccounts = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);
		GooagooLog.debug("自定义查询统计跟据历史条件查询人群返回结果为：" + new Gson().toJson(userAccounts));

		// 將历史条件查出的人群放入缓存中
		String cacheKey = shopId + "_" + new Gson().toJson(historyCondition);
		GMSCache.putCache(cacheKey, userAccounts);

		String[] split = statisType.split("_");
		ChartVo chartVo = null;
		if (CUSTOM.equals(split[0])) {
			chartVo = this.recordStatisticService.memberFeatureStatistic(shopId, userAccounts, split[1]);
		} else if (SYSTEMIC.equals(split[0])) {
			chartVo = this.recordStatisticService.memberStatisticService(shopId, userAccounts, split[1]);
		} else {
			GooagooLog.warn("自定义查询统时，统计类型错误");
		}
		GooagooLog.debug("自定义查询统计用历史条件查询人群和统计类型匹配返回结果：" + new Gson().toJson(chartVo));

		FhighChartVo fhighChartVo = new FhighChartVo();
		fhighChartVo.setTableName(chartName);
		fhighChartVo.setUnit("人");
		fhighChartVo.setyName("人数");
		fhighChartVo.setxData(chartVo.getxData());
		Map<String, List<Long>> getyData = chartVo.getyData();
		Set<Entry<String, List<Long>>> entrySet = getyData.entrySet();
		YDataVo dataVo = null;
		for (Entry<String, List<Long>> entry : entrySet) {
			dataVo = new YDataVo();
			dataVo.setName(entry.getKey());
			List<Long> value = entry.getValue();
			for (Long data : value) {
				dataVo.getData().add(Integer.parseInt(data.toString()));
			}
			fhighChartVo.getyDataVos().add(dataVo);
		}
		return GMSUtil.toTransData(true, null, fhighChartVo);
	}

	@Override
	public TransData<FhighChartVo> getCommonlyUsedStatisticalData(HttpServletRequest request) throws Exception {
		String chartName = ServletRequestUtils.getStringParameter(request, "chartName", ""); // 图表名称
		String sampleType = ServletRequestUtils.getStringParameter(request, "sampleType", ""); // 样本类型
		String statisType = ServletRequestUtils.getStringParameter(request, "statisticsType", ""); // 统计类型
		GooagooLog.debug("常用用户细分统计接收参数：【sampleType】:" + sampleType + "【statisType】：" + statisType);
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
		
		List<Account> accountList = this.getAccountList(request,sampleType); 
		
		String cacheKey = shopId + "_" + sampleType + "_" + statisType;
		GMSCache.putCache(cacheKey, accountList);
		String[] split = statisType.split("_");
		ChartVo chartVo = null;
		if (CUSTOM.equals(split[0])) {
			chartVo = this.recordStatisticService.memberFeatureStatistic(shopId, accountList, split[1]);
		} else if (SYSTEMIC.equals(split[0])) {
			chartVo = this.recordStatisticService.memberStatisticService(shopId, accountList, split[1]);
		} else {
			GooagooLog.warn("自定义查询统时，统计类型错误");
		}
		GooagooLog.debug("常用用户细分统计用人群和统计类型匹配返回结果：" + new Gson().toJson(chartVo));
		FhighChartVo fhighChartVo = new FhighChartVo();
		fhighChartVo.setTableName(chartName);
		fhighChartVo.setUnit("人");
		fhighChartVo.setyName("人数");
		fhighChartVo.setxData(chartVo.getxData());
		Map<String, List<Long>> getyData = chartVo.getyData();
		Set<Entry<String, List<Long>>> entrySet = getyData.entrySet();
		YDataVo dataVo = null;
		for (Entry<String, List<Long>> entry : entrySet) {
			dataVo = new YDataVo();
			dataVo.setName(entry.getKey());
			List<Long> value = entry.getValue();
			for (Long data : value) {
			  dataVo.getData().add(Integer.parseInt(data.toString()));
			}
			fhighChartVo.getyDataVos().add(dataVo);
		}
		return GMSUtil.toTransData(true, null, fhighChartVo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public TransData<Object> saveCrowd(HttpServletRequest request) throws Exception {
		String crowdName = ServletRequestUtils.getStringParameter(request, "groupName", "");
		String crowdDesc = ServletRequestUtils.getStringParameter(request, "crowdDesc", "");
		String label = ServletRequestUtils.getStringParameter(request, "label", "");
		String sFlag = ServletRequestUtils.getStringParameter(request, "sFlag", ""); //统计模块
		String statisticType = ServletRequestUtils.getStringParameter(request, "statisType", "");
		String sample = ServletRequestUtils.getStringParameter(request, "sample", "");
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
		String cacheKey="";
		// 自定义统计分类查询
		HistoryCondition historyCondition = null;
		if ("S".equals(sFlag)) {
			historyCondition = this.getHistoryCondition(request);
			cacheKey = shopId + "_" + new Gson().toJson(historyCondition);
		} else if ("Q".equals(sFlag)) { //
			historyCondition = this.queryParametersService.getHistoryCondition(statisticType);
			cacheKey = shopId + "_" + new Gson().toJson(historyCondition);
		} else if ("C".equals(sFlag)) {
			cacheKey = shopId + "_" + sample + "_" + statisticType;
		}
		List<Account> accountList = null;
		accountList = (List<Account>) GMSCache.getCache(cacheKey);
		if (CollectionUtils.isEmpty(accountList)) {
			if ("S".equals(sFlag) || "Q".equals(sFlag)) {
				accountList = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);
			}else{
				accountList = this.getAccountList(request, sample);
			}
		}
		
		boolean isCustom = false;
		String ayalysisType = "";
		//如果为自定义统计条件查询isCustom，ayalysisType 两个值从返回的historyCondition对象中取
		if("Q".equals(sFlag)){
			isCustom = historyCondition.isCustom();
			ayalysisType = historyCondition.getStatisticsType();
		}else{
			String[] split = statisticType.split("_");
			isCustom = CUSTOM.equals(split[0]) ? true : false;
			ayalysisType = split[1];
		}
		GooagooLog.debug("保存用户细分前查询要保存的人群传入参数为：【crowdName】：" + crowdName + "【crowdDesc】：" + crowdDesc + "【key】：" + label + "【accountList】:" + new Gson().toJson(accountList));

		List<Account> findAccounts = this.crowdOperationService.findAccounts(shopId, isCustom, ayalysisType, accountList, label);

		GooagooLog.debug("保存用户细分传入参数为：【shopId】" + shopId + "【crowdName】：" + crowdName + "【crowdDesc】：" + crowdDesc + "【findAccounts】：" + findAccounts);

		boolean saveCrowd = this.crowdOperationService.saveCrowd(shopId, crowdName, crowdDesc, findAccounts);

		return GMSUtil.getBooleanResult(saveCrowd, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
	}

	@Override
	public TransData<List<CrowdInfoVo>> getCrowdList(HttpServletRequest request) throws Exception {
		String shopIdByInterface = GmsInterfaceUtil.getShopIdByInterface(request);
		GooagooLog.debug("调用查询已保存用户人群传入参数为：【shopId】:" + shopIdByInterface);
		List<UserGroup> findCrowd = this.crowdOperationService.findCrowd(shopIdByInterface);
		GooagooLog.debug("调用查询已保存用户人群返回结果为：【findCrowd】:" + new Gson().toJson(findCrowd));
		List<CrowdInfoVo> crowdList = new ArrayList<CrowdInfoVo>(0);
		CrowdInfoVo infoVo = null;
		for (UserGroup userGroup : findCrowd) {
			infoVo = new CrowdInfoVo();
			infoVo.setCrowdId(userGroup.getGroupId());
			infoVo.setCrowdName(userGroup.getGroupName());
			infoVo.setCrowdDesc(userGroup.getGroupDesc());
			crowdList.add(infoVo);
		}

		return GMSUtil.toTransData(true, null, crowdList);
	}

	@Override
	public TransData<Object> saveCustomStatisticCondition(HttpServletRequest request) throws Exception {
		String queryName = ServletRequestUtils.getStringParameter(request, "queryName", "");
		String statisticType = ServletRequestUtils.getStringParameter(request, "statisticType", "");
		HistoryCondition historyCondition = this.getHistoryCondition(request);
		String[] split = statisticType.split("_");
		boolean isCustom = CUSTOM.equals(split[0]) ? true : false;
		String ayalysisType = split[1];
		String shopIdByInterface = GmsInterfaceUtil.getShopIdByInterface(request);
		GooagooLog.debug("调用保存用户查询条件接口传入参数：【shopId】:" + shopIdByInterface + "【ayalysisType】:" + ayalysisType + "【isCustom】:" + isCustom + "【queryName】:" + queryName + "【historyCondition】:"
				+ new Gson().toJson(historyCondition));
		boolean saveQueryParameters = this.queryParametersService.saveQueryParameters(shopIdByInterface, ayalysisType, isCustom, queryName, "123", historyCondition);
		GooagooLog.debug("调用保存用户查询条件接口返回值为：" + saveQueryParameters);
		return GMSUtil.getBooleanResult(saveQueryParameters, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
	}

	@Override
	public TransData<List<QueryConditionVo>> findCustomStatisticCondition(HttpServletRequest request) throws Exception {
		String shopIdByInterface = GmsInterfaceUtil.getShopIdByInterface(request);
		GooagooLog.debug("调用查询自定统统计类型（条件）接口传入参数：【shopId】:" + shopIdByInterface);
		List<BasicQueryParameters> findQueryParameters = this.queryParametersService.findQueryParameters(shopIdByInterface);
		GooagooLog.debug("调用查询自定统统计类型（条件）接口返回结果：【findQueryParameters】:" + new Gson().toJson(findQueryParameters));
		List<QueryConditionVo> queryConditionVoList = new ArrayList<QueryConditionVo>(0);
		QueryConditionVo queryConditionVo = null;
		for (BasicQueryParameters basicQueryParameters : findQueryParameters) {
			queryConditionVo = new QueryConditionVo();
			queryConditionVo.setQueryId(basicQueryParameters.get_id());
			queryConditionVo.setQueryName(basicQueryParameters.getQueryName());
			queryConditionVo.setQueryDesc(basicQueryParameters.getQueryDesc());
			queryConditionVoList.add(queryConditionVo);
		}
		return GMSUtil.toTransData(true, null, queryConditionVoList);
	}

	@Override
	@SuppressWarnings("unchecked")
	public TransData<PageModel<FCRMMemberBaseInfo>> findUserDetailList(HttpServletRequest request) throws Exception {
		PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
		String label = ServletRequestUtils.getStringParameter(request, "label", "");
		String statisticType = ServletRequestUtils.getStringParameter(request, "statisticType", "");
		String sample = ServletRequestUtils.getStringParameter(request, "sample", "");
		String sflag = ServletRequestUtils.getStringParameter(request, "flag", "");
		String mac = ServletRequestUtils.getStringParameter(request, "mac", "");
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
		String cacheKey = "";
		// 自定义统计分类查询
		HistoryCondition historyCondition = null;
		if ("S".equals(sflag)) {
			historyCondition = this.getHistoryCondition(request);
			cacheKey = shopId + "_" + new Gson().toJson(historyCondition);
		} else if ("Q".equals(sflag)) { //
			historyCondition = this.queryParametersService.getHistoryCondition(statisticType);
			cacheKey = shopId + "_" + new Gson().toJson(historyCondition);
		} else if ("C".equals(sflag)) {
			cacheKey = shopId + "_" + sample + "_" + statisticType;
		}
		List<Account> accountList = null;
		accountList = (List<Account>) GMSCache.getCache(cacheKey);
		if (CollectionUtils.isEmpty(accountList)) {
			if ("S".equals(sflag) || "Q".equals(sflag)) {
				accountList = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);
			}else{
				accountList = this.getAccountList(request, sample);
			}
		}
           
		
		boolean isCustom = false;
		String ayalysisType = "";
		//如果为自定义统计条件查询isCustom，ayalysisType 两个值从返回的historyCondition对象中取
		if("Q".equals(sflag)){
			isCustom = historyCondition.isCustom();
			ayalysisType = historyCondition.getStatisticsType();
		}else{
			String[] split = statisticType.split("_");
			isCustom = CUSTOM.equals(split[0]) ? true : false;
			ayalysisType = split[1];
		}
		
		ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
		String key = new StringBuffer(shopLoginInfo.getShopAndUserInfo().getUserId()).append(statisticType).toString();
		List<Account> findAccounts = (List<Account>) GMSCache.getCache(key);
		if (CollectionUtils.isEmpty(findAccounts)) {
			GooagooLog.debug("查询人群列表时调用获取人群帐号和帐号类型传入参数：【label】：" + label + "【accountList】:" + new Gson().toJson(accountList));
			findAccounts = this.crowdOperationService.findAccounts(shopId, isCustom, ayalysisType, accountList, label);
			GMSCache.putCache(key, findAccounts);
			GooagooLog.debug("查询人群列表时调用获取人群帐号和帐号类型反回结果：【findAccounts】：" + new Gson().toJson(findAccounts));
		}
		PageModel<FCRMMemberBaseInfo> pageModel = new PageModel<FCRMMemberBaseInfo>();
		boolean flag = CollectionUtils.isEmpty(findAccounts);
		pageModel.setCount(flag ? 0 : findAccounts.size());
		pageModel.setPageIndex(condition.getPageIndex());
		pageModel.setPageSize(condition.getPageSize());
		FCRMMemberBaseInfo fcrmMemberBaseInfo = null;
		if (!flag) {
			if (StringUtils.isNotBlank(mac)) {
				findAccounts = this.queryAccountInfoByMac(accountList, mac, shopId);
			}
			List<Account> subList = findAccounts.subList(StatisticsUtil.getFromIndex(pageModel.getIndex(), pageModel.getPageSize(), pageModel.getCount()),
					StatisticsUtil.getToIndex(pageModel.getIndex(), pageModel.getPageSize(), pageModel.getCount()));
			for (Account account2 : subList) {
				fcrmMemberBaseInfo = new FCRMMemberBaseInfo();
				PropertyRecord userPropertyRecord = this.userCacheQueryService
						.getUserPropertyRecord(shopLoginInfo.getShopAndUserInfo().getShopId(), account2.getAccountType(), account2.getAccountNo());
				if (userPropertyRecord != null && userPropertyRecord.getAccountBaseInfo() != null) {
					AccountBaseInfo accountBaseInfo = userPropertyRecord.getAccountBaseInfo();
					fcrmMemberBaseInfo.setAddress(accountBaseInfo.getAddress());
					fcrmMemberBaseInfo.setBirthday(accountBaseInfo.getBirthday());
					fcrmMemberBaseInfo.setEmail(accountBaseInfo.getEmail());
					fcrmMemberBaseInfo.setIdNo(accountBaseInfo.getIdNo());
					fcrmMemberBaseInfo.setIdType(accountBaseInfo.getIdType());
					fcrmMemberBaseInfo.setTelephone(accountBaseInfo.getTelephone());
					fcrmMemberBaseInfo.setName(accountBaseInfo.getName());
					fcrmMemberBaseInfo.setPostcode(accountBaseInfo.getPostCode());
					fcrmMemberBaseInfo.setSex(accountBaseInfo.getSex());
				}
				if (userPropertyRecord != null && userPropertyRecord.getAccountTypeInfo() != null) {
					AccountTypeInfo accountTypeInfo = userPropertyRecord.getAccountTypeInfo();
					fcrmMemberBaseInfo.setGooagooId(accountTypeInfo.getGooagooId());
					fcrmMemberBaseInfo.setMac(accountTypeInfo.getMac());
					fcrmMemberBaseInfo.setMobile(accountTypeInfo.getMobile());
					fcrmMemberBaseInfo.setPhyNo(accountTypeInfo.getPhyCardNo());
				}
				pageModel.getResult().add(fcrmMemberBaseInfo);
			}
		}
		return GMSUtil.toTransData(true, null, pageModel);
	}

	@Override
	public TransData<FhighChartVo> getHasSavedQueryConditionChart(HttpServletRequest request) throws Exception {

		String chartName = ServletRequestUtils.getStringParameter(request, "chartName", "");
		String queryId = ServletRequestUtils.getStringParameter(request, "statisticsType", "");
		GooagooLog.debug("获取自定义统计类型图表数据：根据保存历史条件id获取条件时：传入参数【queryId】：" + queryId);
		HistoryCondition historyCondition = this.queryParametersService.getHistoryCondition(queryId);
		GooagooLog.debug("获取自定义统计类型图表数据：根据保存历史条件id获取条件时：返回结果【historyCondition】：" + new Gson().toJson(historyCondition));
		String shopIdByInterface = GmsInterfaceUtil.getShopIdByInterface(request);
		List<Account> userAccounts = this.userCacheQueryService.getUserAccountsList(shopIdByInterface, historyCondition);
		GooagooLog.debug("自定义查询统计跟据历史条件查询人群返回结果为：" + new Gson().toJson(userAccounts));
		String statisticsType = historyCondition.getStatisticsType();
		boolean isCustom = historyCondition.isCustom();
		// 將历史条件查出的人群放入缓存中
		String cacheKey = shopIdByInterface + "_" + new Gson().toJson(historyCondition);
		GMSCache.putCache(cacheKey, userAccounts);
		ChartVo chartVo = null;
		if (isCustom) {
			chartVo = this.recordStatisticService.memberFeatureStatistic(shopIdByInterface, userAccounts, statisticsType);
		} else if (!isCustom) {
			chartVo = this.recordStatisticService.memberStatisticService(shopIdByInterface, userAccounts, statisticsType);
		} else {
			GooagooLog.warn("自定义查询统时，统计类型错误");
		}
		GooagooLog.debug("获取自定义统计类型图表数据:自定义查询统计用历史条件查询人群和统计类型匹配返回结果：" + new Gson().toJson(chartVo));

		FhighChartVo fhighChartVo = new FhighChartVo();
		fhighChartVo.setTableName(chartName);
		fhighChartVo.setUnit("人");
		fhighChartVo.setyName("人数");
		fhighChartVo.setxData(chartVo.getxData());
		Map<String, List<Long>> getyData = chartVo.getyData();
		Set<Entry<String, List<Long>>> entrySet = getyData.entrySet();
		YDataVo dataVo = null;
		for (Entry<String, List<Long>> entry : entrySet) {
			dataVo = new YDataVo();
			dataVo.setName(entry.getKey());
			List<Long> value = entry.getValue();
			for (Long data : value) {
				dataVo.getData().add(Integer.parseInt(data.toString()));
			}
			fhighChartVo.getyDataVos().add(dataVo);
		}
		return GMSUtil.toTransData(true, null, fhighChartVo);
	}
    
	

	private RuleInfo covertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException {
		RuleInfo ruleInfo = new RuleInfo();
		if (fRuleInfo != null) {
			EntityTools.copyValue(fRuleInfo, ruleInfo);
		}
		return ruleInfo;
	}

	private HistoryCondition covertToHistoryCondition(FHistoryCondition hCondition) throws IllegalArgumentException, IllegalAccessException {
		HistoryCondition historyCondition = new HistoryCondition();
		NaturalAttribute naturalAttribute = new NaturalAttribute();
		List<ActionAttribute> list = new ArrayList<ActionAttribute>();

		FNaturalAttribute fNaturalAttribute = hCondition.getNaturalAttribute();
		List<FActionAttribute> fList = hCondition.getList();

		for (FActionAttribute fActionAttribute : fList) {
			list.add(this.covertToActionAttribute(fActionAttribute));
		}

		if (fNaturalAttribute != null) {
			EntityTools.copyValue(fNaturalAttribute, naturalAttribute);
		}

		historyCondition.setCrowdId(hCondition.getCrowdId());
		historyCondition.setCrowdName(hCondition.getCrowdName());
		historyCondition.setNaturalAttribute(naturalAttribute);
		historyCondition.setList(list);

		return historyCondition;
	}

	private ActionAttribute covertToActionAttribute(FActionAttribute fActionAttribute) throws IllegalArgumentException, IllegalAccessException {
		ActionAttribute actionAttribute = new ActionAttribute();

		if (fActionAttribute != null) {
			EntityTools.copyValue(fActionAttribute, actionAttribute);
		}
		return actionAttribute;
	}

	private HistoryCondition getHistoryCondition(HttpServletRequest request) throws Exception {
		FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);
		String[] features = ServletRequestUtils.getStringParameters(request, "feature");
		RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);
		String ruleJson = ruleInfo.getRuleContent();
		FRuleCondition ruleCondition = new Gson().fromJson(ruleJson, FRuleCondition.class);
		FHistoryCondition hCondition = ruleCondition.getHistoryCondition();
		HistoryCondition historyCondition = this.covertToHistoryCondition(hCondition);

		// 设置会员特征查询条件
		if (features != null && features.length > 0) {
			NaturalAttribute naturalAttribute = historyCondition.getNaturalAttribute();
			MemberFeature memberFeature = null;
			for (String feature : features) {
				if (StringUtils.isNotBlank(feature)) {
					memberFeature = new MemberFeature();
					String[] codeValue = feature.split("_");
					memberFeature = new MemberFeature();
					memberFeature.setTypeCode(codeValue[0]);
					memberFeature.setEnumValue(codeValue[1]);
					naturalAttribute.getMemberFeatureList().add(memberFeature);
				}
			}
		}
		return historyCondition;
	}

	/**
	 * 跟据mac地址过滤用户信息
	 * 
	 * @param accountList
	 * @param mac
	 * @param shopId
	 * @return
	 * @throws Exception
	 */
	private List<Account> queryAccountInfoByMac(List<Account> accountList, String mac, String shopId) throws Exception {
		List<Account> newAccountList = new ArrayList<Account>(0);
		for (Account acc : accountList) {
			PropertyRecord userPropertyRecord = this.userCacheQueryService.getUserPropertyRecord(shopId, acc.getAccountType(), acc.getAccountNo());
			if (userPropertyRecord != null && userPropertyRecord.getAccountTypeInfo() != null && mac.contains(userPropertyRecord.getAccountTypeInfo().getMac())) {
				newAccountList.add(acc);
			}
		}

		return newAccountList;
	}
	
	
	 /**
	  * 常用用户细分（自定义统计类型）获取人群信息
	  * @param request
	  * @param sampleType
	  * @return
	  * @throws Exception
	  */
	 private  List<Account> getAccountList(HttpServletRequest request,String sampleType) throws Exception{
		ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
		String shopId = shopLoginInfo.getShopAndUserInfo().getShopId();
		boolean isEntityUser = false;
		if("N".equals(shopLoginInfo.getShopAndUserInfo().getUserIsShopAccount())){
			isEntityUser = true;
		}
		List<String> userInfoList = null;
		if("ALL_USER".equals(sampleType)){
			if(isEntityUser){
				userInfoList = this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeople(shopLoginInfo.getShopAndUserInfo().getUserShopEntityId(), null,"A", new Date());
			}else{
				userInfoList = this.shopPeopleStatisticsService.findShopPeople(shopId, "A", new Date());
			}
		}else if("IN_STORE_USER".equals(sampleType)){
			if(isEntityUser){
				userInfoList = this.shopEntityPeopleStatisticsQueryService.findEntityPeople(shopLoginInfo.getShopAndUserInfo().getUserShopEntityId(), "A");
			}else{
				userInfoList = this.shopPeopleStatisticsService.findArriveShopPeople(shopId, null, "A", new Date());
			}
		}else if("IN_STORE_MEMBER".equals(sampleType)){
			if(isEntityUser){
				userInfoList = this.shopEntityPeopleStatisticsQueryService.findEntityPeople(shopLoginInfo.getShopAndUserInfo().getUserShopEntityId(), "M");
			}else{
				userInfoList = this.shopPeopleStatisticsService.findArriveShopPeople(shopId, null, "M", new Date());
			}
			
		}else if("PHONE_INTERACTION_MEMBER".equals(sampleType)){
			userInfoList = this.interactiveQueryService.findPhoneInterPeople(shopId, null, "M", new Date());
		}else if("WEB_INTERACTION_USER".equals(sampleType)){
			userInfoList = this.interactiveQueryService.findWebInterPeople(shopId, null, "A", new Date());
		}else if("WEB_INTERACTION_MEMBER".equals(sampleType)){
			userInfoList = this.interactiveQueryService.findWebInterPeople(shopId, null, "M", new Date());
		}else if("NEW_USER".equals(sampleType)){
			userInfoList = this.shopPeopleStatisticsService.findShopAddPeople(shopId , "A", new Date(0),new Date());
		}else if("NEW_MEMBER".equals(sampleType)){
			userInfoList = this.shopPeopleStatisticsService.findShopAddPeople(shopId, "M", new Date(0),new Date());
		}
		
		GooagooLog.debug("常用用户细分统计跟据样本查询人群反回结果：" + new Gson().toJson(userInfoList));
		List<Account> accountList = new ArrayList<Account>(0);
		Account account = null;
		for (String info : userInfoList) {
			account = new Account();
			String[] split = info.split("_");
			if ("0".equals(split[0])) {
				account.setUserId(split[1]);
			} else if ("2".equals(split[0])) {
				account.setIp(split[1]);
			} else if ("3".equals(split[0])) {
				account.setMac(split[1]);
			} else if ("7".equals(split[0])) {
				account.setPhyCardNo(split[1]);
			}
			accountList.add(account);
		}
		
		return accountList;
	}
	

}

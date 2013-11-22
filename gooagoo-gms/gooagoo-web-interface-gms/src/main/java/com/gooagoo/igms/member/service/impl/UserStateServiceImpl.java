package com.gooagoo.igms.member.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.statistics.CrowdOperationQueryService;
import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.statistics.ShopPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.property.AccountBaseInfo;
import com.gooagoo.entity.business.user.account.property.AccountTypeInfo;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.igms.member.service.UserStateService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FCRMMemberBaseInfo;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.YDataVo;
import com.gooagoo.view.gms.member.StateParams;

@Service("userStateService")
public class UserStateServiceImpl implements UserStateService {

	@Autowired
	private ShopPeopleStatisticsQueryService shopPeopleStatisticsService;
	@Autowired
	private ShopLoginService shopLoginService;

	@Autowired
	private InteractiveQueryService interactiveService;

	@Autowired
	private UserCacheQueryService userCacheQueryService;

	@Autowired
	private CrowdOperationQueryService crowdOperationService;
	@Autowired
	private ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsQueryService;

	/**
	 * 保存用户状态人群信息
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public TransData<Object> saveCrowdForUserState(HttpServletRequest request) throws Exception {
		String crowdName = ServletRequestUtils.getStringParameter(request, "crowdName", "");
		String crowdDesc = ServletRequestUtils.getStringParameter(request, "crowdDesc", "");
		StateParams stateParams = ServletUtils.objectMethod(StateParams.class, request);
		String shopId = this.shopLoginService.getShopLoginInfo(request).getShopAndUserInfo().getShopId();
		ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
		List<String> dataList = null;
		switch (Integer.parseInt(stateParams.getsType())) {
		
		case 1: // 获取店内人数列表
			dataList = this.getInStorePeople(shopId, stateParams);
			break;
		case 2: // 获取到店人数列表
			dataList = this.getArriveStorePeople(shopId, stateParams);
			break;
		case 3: //新增用户人数列表
			dataList = this.getNewUserPeople(shopId,stateParams);
			break;
		case 4: //手机互动
			dataList = this.getPhoneInteractionPeople(shopId,stateParams);
		    break;	
		
		case 5: //网店互动
			dataList = this.getWebInteractionPeople(shopId,stateParams);
		    break;	    
		}
		List<Account> accountList = new ArrayList<Account>(0);
		Account account = null;
		for (String info : dataList) {
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
		boolean saveCrowd = crowdOperationService.saveCrowd(shopLoginInfo.getShopAndUserInfo().getShopId(), crowdName, crowdDesc, accountList);
		return GMSUtil.getBooleanResult(saveCrowd, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
	}

	@Override
	public TransData<PageModel<FCRMMemberBaseInfo>> getUserStatusDetailList(HttpServletRequest request) throws Exception {

		String shopId = this.shopLoginService.getShopLoginInfo(request).getShopAndUserInfo().getShopId();
		PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
		StateParams stateParams = ServletUtils.objectMethod(StateParams.class, request);
		ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
		List<String> dataList = null;
		switch (Integer.parseInt(stateParams.getsType())) {
		
		case 1: // 获取店内人数列表
			dataList = this.getInStorePeople(shopId, stateParams);
			break;
		case 2: // 获取到店人数列表
			dataList = this.getArriveStorePeople(shopId,stateParams);
			break;
		case 3: //新增用户人数列表
			dataList = this.getNewUserPeople(shopId,stateParams);
			break;
		case 4: //手机互动
			dataList = this.getPhoneInteractionPeople(shopId,stateParams);
		    break;	
		
		case 5: //网店互动
			dataList = this.getWebInteractionPeople(shopId,stateParams);
		    break;	    

		}
		 boolean isEmpty = CollectionUtils.isEmpty(dataList);
		 PageModel<FCRMMemberBaseInfo> pageModel = new PageModel<FCRMMemberBaseInfo>();
		 pageModel.setCount(isEmpty ? 0 : dataList.size());
		 pageModel.setPageIndex(pageCondition.getPageIndex());
		 pageModel.setPageSize(pageCondition.getPageSize());
		 if (!isEmpty) {
			   //按mac地址过滤用户帐号信息	 
			 if(StringUtils.isNotBlank(stateParams.getMac())){
				   dataList= this.queryAccountInfoByMac(dataList, stateParams.getMac(),shopId); 		 
			 }  	 
			 List<String> subList = dataList.subList(StatisticsUtil.getFromIndex(pageModel.getIndex(),
			 pageModel.getPageSize(), dataList.size()),
			 StatisticsUtil.getToIndex(pageModel.getIndex(),
			 pageModel.getPageSize(), dataList.size()));
			 FCRMMemberBaseInfo fcrmMemberBaseInfo = null;
			 for (String str : subList) {
			 fcrmMemberBaseInfo = new FCRMMemberBaseInfo();
			 String[] strArray = str.split("_");
			 PropertyRecord userPropertyRecord = this.userCacheQueryService.getUserPropertyRecord(shopLoginInfo.getShopAndUserInfo().getShopId(), strArray[0], strArray[1]);
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
    
	
	/**
	 * 获取网站互动人员列表
	 * @param shopId
	 * @param userType
	 * @param column
	 * @param dateType
	 * @return
	 */
	private List<String> getWebInteractionPeople(String shopId, StateParams stateParams) {
		List<String> peopleList = null;
		if ("C".equals(stateParams.getHisOrCurr())) {
			peopleList = this.interactiveService.findWebInterPeople(shopId, stateParams.getTimeType(), stateParams.getUserType(), new Date());		
		} else {
			peopleList = this.interactiveService.findWebInterPeople(shopId, stateParams.getTimeType(), stateParams.getUserType(), getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal()));		
		}
		return peopleList;
		
	}
    
	/**
	 * 获取手机互动人员列表
	 * @param shopId
	 * @param userType
	 * @param column
	 * @param dateType
	 * @return
	 */
	private List<String> getPhoneInteractionPeople(String shopId, StateParams stateParams) {
		List<String> peopleList = null;
		if ("C".equals(stateParams.getHisOrCurr())) {
			peopleList = this.interactiveService.findPhoneInterPeople(shopId, stateParams.getColumn(), stateParams.getUserType(), new Date());		
		} else {
			peopleList = this.interactiveService.findPhoneInterPeople(shopId, stateParams.getTimeType(), stateParams.getUserType(), getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal()));		
		}
		return peopleList;
	}

	/**
	 * 获取新增用户列表
	 * @param shopId
	 * @param column
	 * @param dateType
	 * @param dateType2 
	 * @return
	 * @throws Exception 
	 */
	private List<String> getNewUserPeople(String shopId, StateParams stateParams) throws Exception {
		List<String> peopleList = null;
		if ("C".equals(stateParams.getHisOrCurr())) {
			peopleList = this.shopPeopleStatisticsService.findShopAddPeople(shopId, stateParams.getUserType(), getStartDate(stateParams.getHisOrCurr(), stateParams.getTimeType(),new Date()), new Date());		
		} else {
			Date queryDate = getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal());
			peopleList = this.shopPeopleStatisticsService.findShopAddPeople(shopId, stateParams.getUserType(),getStartDate(stateParams.getHisOrCurr(), stateParams.getTimeType(), queryDate),queryDate);		
		}
		return peopleList;
	}

	private FhighChartVo getPhoneInteractionTimes(String shopId, String userType) {
		String[] timeType = { "H", "D" }; // 时间类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setUnit("次");
		chartVo.setyName("次数");
		chartVo.setTableName("手机互动次数");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = this.interactiveService.findPhoneInterTimes(shopId, type, userType, new Date());
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	/**
	 * 获取到达人数列表
	 * 
	 * @param shopId
	 * @param entityId
	 * @param areaId
	 * @param userType
	 * @param column
	 * @param dateType
	 * @return
	 */
	private List<String> getArriveStorePeople(String shopId, StateParams stateParams) {
		List<String> peopleList = null;
		if ("C".equals(stateParams.getHisOrCurr())) {
			if (org.apache.commons.lang.StringUtils.isBlank(stateParams.getEntityId())) {
				peopleList = this.shopPeopleStatisticsService.findArriveShopPeople(shopId, stateParams.getTimeType(), stateParams.getUserType(), new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotBlank(stateParams.getEntityId())) {
				peopleList = this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeople(stateParams.getEntityId(), stateParams.getTimeType(), stateParams.getUserType(), new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotBlank(stateParams.getAreaId())) {
				peopleList = this.shopEntityPeopleStatisticsQueryService.findArriveEntityAreaPeople(stateParams.getAreaId(), stateParams.getTimeType(), stateParams.getUserType(), new Date());
			}
		} else {
			if (org.apache.commons.lang.StringUtils.isBlank(stateParams.getEntityId())) {
				peopleList = this.shopPeopleStatisticsService.findArriveShopPeople(shopId, stateParams.getTimeType(), stateParams.getUserType(),getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal()));
			} else if (org.apache.commons.lang.StringUtils.isNotBlank(stateParams.getEntityId())) {
				peopleList = this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeople(stateParams.getEntityId(), stateParams.getTimeType(), stateParams.getUserType(), getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal()));
			} else if (org.apache.commons.lang.StringUtils.isNotBlank(stateParams.getAreaId())) {
				peopleList = this.shopEntityPeopleStatisticsQueryService.findArriveEntityAreaPeople(stateParams.getAreaId(), stateParams.getTimeType(), stateParams.getUserType(), getQueryDate(stateParams.getHisOrCurr(), stateParams.getColumn(),stateParams.getTimeType(),stateParams.getTimeVal()));
			}
		}

		return peopleList;
	}

	/**
	 * 获取店内人员列表
	 * 
	 * @param shopId
	 * @param entityId
	 * @param areaId
	 * @param userType
	 * @return
	 */
	private List<String> getInStorePeople(String shopId, StateParams stateParams) {
		List<String> peopleList = null;
		if (org.apache.commons.lang.StringUtils.isBlank(stateParams.getEntityId())) {
			peopleList = this.shopPeopleStatisticsService.findAllEntityPeople(shopId, stateParams.getUserType());
		} else if (org.apache.commons.lang.StringUtils.isNotEmpty(stateParams.getEntityId())) {
			peopleList = this.shopEntityPeopleStatisticsQueryService.findEntityPeople(stateParams.getEntityId(), stateParams.getUserType());
		} else if (org.apache.commons.lang.StringUtils.isNotEmpty(stateParams.getAreaId())) {
			peopleList = this.shopEntityPeopleStatisticsQueryService.findEntityAreaPeople(stateParams.getAreaId(), stateParams.getUserType());
		}
		return peopleList;
	}

    
	private static Date getQueryDate(String currOrHis, String column, String timeType, String queryDate)
    {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        try
        {
            if ("H".equals(currOrHis))
            {
                if ("D".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate));
                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(column));
                }
                else if ("W".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate));
                }
                else if ("M".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate + "-01"));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(column));
                }
                else if ("Y".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate + "-01-01"));
                    calendar.set(Calendar.MONTH, (Integer.parseInt(column) - 1));
                }
                else
                {
                    calendar.set(Calendar.YEAR, Integer.parseInt(column));
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("cpm查询人员列表时，获取时间错误", e);
        }
        return calendar.getTime();
    }

	@Override
	public TransData<Integer> getCurrentDataForChart(HttpServletRequest request) throws Exception {

		String userType = ServletRequestUtils.getStringParameter(request, "userType", "A");
		String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
		String areaId = ServletRequestUtils.getStringParameter(request, "areaId", "");
		int num = 0;
		if (org.apache.commons.lang.StringUtils.isBlank(shopEntityId)) {
			String shopId = this.shopLoginService.getShopLoginInfo(request).getShopAndUserInfo().getShopId();
			num = this.shopPeopleStatisticsService.findAllEntityPeopleNum(shopId, userType);
		} else if (org.apache.commons.lang.StringUtils.isNotEmpty(shopEntityId)) {
			num = this.shopEntityPeopleStatisticsQueryService.findEntityPeopleNum(shopEntityId, userType);
		} else if (org.apache.commons.lang.StringUtils.isNotEmpty(areaId)) {
			num = this.shopEntityPeopleStatisticsQueryService.findEntityAreaPeopleNum(areaId, userType);
		}
		return GMSUtil.toTransData(true, null, num);
	}

	@Override
	public TransData<List<FhighChartVo>> getCurrentHourAndDayDataForChart(HttpServletRequest request) throws Exception {

		StateParams stateParams = ServletUtils.objectMethod(StateParams.class, request);
		String shopId = this.shopLoginService.getShopLoginInfo(request).getShopAndUserInfo().getShopId();
		List<FhighChartVo> fhighChartVos = new ArrayList<FhighChartVo>(0);
		FhighChartVo arriveUserNum = null;
		FhighChartVo arriveUserTimes = null;
		if ("2".equals(stateParams.getsType())) {
			arriveUserNum = this.getArriveUserNum(shopId,stateParams.getEntityId() , stateParams.getAreaId(), stateParams.getUserType());
			arriveUserTimes = this.getArriveUserTimes(shopId, stateParams.getEntityId(), stateParams.getAreaId(), stateParams.getUserType());
		} else if ("3".equals(stateParams.getsType())) {
			arriveUserNum = this.getNewUserNum(shopId, stateParams.getUserType());
		} else if ("4".equals(stateParams.getsType())) {
			arriveUserNum = this.getPhoneInteractionNum(shopId, stateParams.getUserType());
			arriveUserTimes = this.getPhoneInteractionTimes(shopId, stateParams.getUserType());
		} else if ("5".equals(stateParams.getsType())) {
			arriveUserNum = this.getWebInteractionNum(shopId, stateParams.getUserType());
			arriveUserTimes = this.getWebInteractionTimes(shopId, stateParams.getUserType());
		}
		fhighChartVos.add(arriveUserNum);
		if (arriveUserTimes != null) {
			fhighChartVos.add(arriveUserTimes);
		}
		return GMSUtil.toTransData(true, null, fhighChartVos);
	}

	private FhighChartVo getArriveUserNum(String shopId, String shopEntityId, String areaId, String userType) {
		String[] timeType = { "H", "D" }; // 时间 类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setUnit("人");
		chartVo.setyName("人数");
		chartVo.setTableName("到店人数统计");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = 0;
			if (org.apache.commons.lang.StringUtils.isBlank(shopEntityId)) {
				num = this.shopPeopleStatisticsService.findArriveShopPeopleNum(shopId, type, userType, new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotEmpty(shopEntityId)) {
				num = this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeopleNum(shopEntityId, type, userType, new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotEmpty(areaId)) {
				num = this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeopleNum(shopEntityId, type, userType, new Date());
			}
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	private FhighChartVo getArriveUserTimes(String shopId, String shopEntityId, String areaId, String userType) {
		String[] timeType = { "H", "D" }; // 时间 类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setTableName("到店人次统计");
		chartVo.setUnit("次");
		chartVo.setyName("次数");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = 0;
			if (org.apache.commons.lang.StringUtils.isBlank(shopEntityId)) {
				num = this.shopPeopleStatisticsService.findArriveShopTimes(shopId, type, userType, new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotEmpty(shopEntityId)) {
				num = this.shopEntityPeopleStatisticsQueryService.findArriveEntityTimes(shopEntityId, type, userType, new Date());
			} else if (org.apache.commons.lang.StringUtils.isNotEmpty(areaId)) {
				num = this.shopEntityPeopleStatisticsQueryService.findArriveEntityAreaTimes(shopEntityId, type, userType, new Date());
			}
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	private FhighChartVo getPhoneInteractionNum(String shopId, String userType) {
		String[] timeType = { "H", "D" }; // 时间类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setTableName("手机互动人数");
		chartVo.setUnit("人");
		chartVo.setyName("人数");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = this.interactiveService.findPhoneInterPeopleNum(shopId, type, userType, new Date());
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	private FhighChartVo getWebInteractionNum(String shopId, String userType) {
		String[] timeType = { "H", "D" }; // 时间类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setTableName("web互动人数");
		chartVo.setyName("人数");
		chartVo.setUnit("人");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = this.interactiveService.findWebInterPeopleNum(shopId, type, userType, new Date());
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	private FhighChartVo getWebInteractionTimes(String shopId, String userType) {
		String[] timeType = { "H", "D" }; // 时间类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setTableName("web互动次数");
		chartVo.setyName("次数");
		chartVo.setUnit("次");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = this.interactiveService.findWebInterTimes(shopId, type, userType, new Date());
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	private FhighChartVo getNewUserNum(String shopId, String userType) {
		String[] timeType = { "H", "D", "W", "M" }; // 时间类型
		FhighChartVo chartVo = new FhighChartVo();
		chartVo.setTableName("新增用户");
		chartVo.setyName("人数");
		chartVo.setUnit("人");
		chartVo.getxData().add("当前小时");
		chartVo.getxData().add("当天");
		chartVo.getxData().add("当周");
		chartVo.getxData().add("当月");
		YDataVo dataVo = new YDataVo();
		for (String type : timeType) {
			int num = this.interactiveService.findWebInterTimes(shopId, type, userType, new Date());
			dataVo.getData().add(num);
		}
		chartVo.getyDataVos().add(dataVo);
		return chartVo;
	}

	@Override
	public TransData<List<List<Integer>>> getDynamicPointData(HttpServletRequest request) throws Exception {
	    StateParams sp = ServletUtils.objectMethod(StateParams.class, request);
	    List<Date> dateList = calQueryTime(sp);
	    String timeType = "D".equals(sp.getTimeType())?"H":"M".equals(sp.getTimeType())?"D":"Y".equals(sp.getTimeType())?"M":"";
	    List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
	    List<Integer> data = null;
	    for (Date date : dateList) {
		    data = new ArrayList<Integer>();
		    int result = 0;
		    if ("2".equals(sp.getsType())) { //到店用户
			    	if("N".equals(sp.getNumOrTimes()))
			    	{
			    	   if(StringUtils.isNotBlank(sp.getAreaId())){
			    		   result =  this.shopEntityPeopleStatisticsQueryService.findArriveEntityAreaPeopleNum(sp.getAreaId(), timeType, sp.getUserType(), date);
			    	   }else if(StringUtils.isNotBlank(sp.getEntityId())){
			    		   result =  this.shopEntityPeopleStatisticsQueryService.findArriveEntityPeopleNum(sp.getEntityId(), timeType, sp.getUserType(), date);
			    	   }else{
			    		   result =  this.shopPeopleStatisticsService.findArriveShopPeopleNum(sp.getShopId(), sp.getTimeType(), timeType, date);
			    	   }	
			    	}else{
			    	  if(StringUtils.isNotBlank(sp.getAreaId())){
			    		  result = this.shopEntityPeopleStatisticsQueryService.findArriveEntityAreaTimes(sp.getAreaId(), timeType, sp.getUserType(), date);
				      }else if(StringUtils.isNotBlank(sp.getEntityId())){
				    	  result = this.shopEntityPeopleStatisticsQueryService.findArriveEntityTimes(sp.getEntityId(), timeType, sp.getUserType(), date);   
				      }else{
				    	  result = this.shopPeopleStatisticsService.findArriveShopTimes(sp.getShopId(), sp.getTimeType(), sp.getUserType(), date);	   
				      }		
			    	}
			} else if ("3".equals(sp.getsType())) {
			     result = this.shopPeopleStatisticsService.findShopAddPeopleNum(sp.getShopId(), sp.getUserType(), TimeUtils.getZeroHourOfDate(date),date);
			} else if ("4".equals(sp.getsType())) {
				 result = this.interactiveService.findPhoneInterPeopleNum(sp.getShopId(), timeType, sp.getUserType(), date);
			} else if ("5".equals(sp.getsType())) {
				result = this.interactiveService.findWebInterPeopleNum(sp.getShopId(), timeType, sp.getUserType(), date);
			}
		    data.add(result);
	    	dataList.add(data);
		}
		return GMSUtil.toTransData(true, null, dataList);
	}
	
	
	
	/**
     * cmp（按指定日期查询），获取最后一个点数据查询时间
     * 
     * @param parameters
     * @return
     */
    private static List<Date> calQueryTime(StateParams parameters)
    {
        String column = parameters.getColumn();
        List<Date> dateList = null;
        try
        {
            String timeTypeVal = parameters.getTimeVal();
            dateList = new ArrayList<Date>();
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            if ("D".equals(timeTypeVal))
            {
                if (calendar.get(Calendar.HOUR_OF_DAY) == Integer.parseInt(column))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(column) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
                    }
                }
            }
            else if ("M".equals(timeTypeVal))
            {
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(column));
                if (cal.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                    }
                }

            }
            else if ("Y".equals(timeTypeVal))
            {
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                calendar.set(Calendar.MONTH, (Integer.parseInt(column) - 1));
                if (cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
                    }
                }
            }
            else
            {
                dateList.add(null);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("cmp（按指定日期查询），获取最后一个点数据查询时间错误", e);
        }
        return dateList;
    }
	
	private List<String> queryAccountInfoByMac(List<String> accountList, String mac,String shopId) throws Exception{
	    List<String> newAccountList = new ArrayList<String>(0);
		for (String str : accountList) {
			String[] strArray = str.split("_");
			PropertyRecord userPropertyRecord = this.userCacheQueryService.getUserPropertyRecord(shopId, strArray[0], strArray[1]);
			if(userPropertyRecord!=null && userPropertyRecord.getAccountTypeInfo()!=null && mac.contains(userPropertyRecord.getAccountTypeInfo().getMac()))
			{
				newAccountList.add(str);
			}
		}
		
		return newAccountList;
	}
	
	
	
	public static Date getStartDate(String hisOrCurr,String timeType,Date timeValue) throws Exception{
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		if("C".equals(hisOrCurr)){
		  if("H".equals(timeType)){
			 calendar.set(Calendar.MINUTE,0); 
			 calendar.set(Calendar.SECOND,0); 
		  }else if("D".equals(timeType)){
			 calendar.setTime(TimeUtils.getZeroHourOfDate(new Date())); 
		  }else if("W".equals(timeType)){
			 calendar.setTime(TimeUtils.getMondayOfDate()); 
		  }else if("M".equals(timeType)){
		     calendar.setTime(TimeUtils.getFirstDayOfMonth()); 
		  }else if("Y".equals(timeType)){
			 calendar.setTime(TimeUtils.getFirstDayOfYear()); 
		  }
		}else{
			calendar.setTime(timeValue);
			if("H".equals(timeType)){
				 calendar.set(Calendar.MINUTE,0); 
				 calendar.set(Calendar.SECOND,0); 
			  }else if("D".equals(timeType)){
				  calendar.set(Calendar.HOUR_OF_DAY,0); 
				  calendar.set(Calendar.MINUTE,0); 
				  calendar.set(Calendar.SECOND,0);
			  }else if("M".equals(timeType)){
				  calendar.set(Calendar.DAY_OF_MONTH,0); 
				  calendar.set(Calendar.HOUR_OF_DAY,0); 
				  calendar.set(Calendar.MINUTE,0); 
				  calendar.set(Calendar.SECOND,0);
			  }else if("Y".equals(timeType)){
				  calendar.set(Calendar.MONTH,0); 
				  calendar.set(Calendar.DAY_OF_MONTH,0); 
				  calendar.set(Calendar.HOUR_OF_DAY,0); 
				  calendar.set(Calendar.MINUTE,0); 
				  calendar.set(Calendar.SECOND,0);
			  }
		}
		return calendar.getTime();
	}
	
}

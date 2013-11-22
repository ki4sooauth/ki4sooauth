package com.gooagoo.igms.member.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.member.MemberInfoBusiness;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.member.service.IUserRecordService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FAccountBaseInfo;
import com.gooagoo.view.gms.crm.FAccountTypeInfo;
import com.gooagoo.view.gms.crm.FActionRecord;
import com.gooagoo.view.gms.crm.FConsumeRecord;
import com.gooagoo.view.gms.crm.FConsumeRecordDetail;
import com.gooagoo.view.gms.crm.FIntegralRecord;
import com.gooagoo.view.gms.crm.FMemberFeatureInfo;
import com.gooagoo.view.gms.crm.FPropertyRecord;
import com.gooagoo.view.gms.crm.UserRecordLeftMenuVo;

@Service(value = "userRecordService")
public class IUserRecordServiceImpl implements IUserRecordService {
	@Autowired
	private UserCacheQueryService userCacheQueryService;
	@Autowired
	private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;

	@Autowired
	private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
	@Autowired
	private OrderPicGeneratorQueryService orderPicGeneratorQueryService;
	@Autowired
	private IntegralDetailInfoGeneratorQueryService integralDetailInfoGeneratorQueryService;
	@Autowired
	private UserInfoGeneratorQueryService userInfoGeneratorQueryService;
	@Autowired
	private MemberFeatureGeneratorQueryService memberFeatureGeneratorQueryService;
	@Autowired
	private ShopLoginService shopLoginService;
	@Autowired
	private UserMemberQueryService userMemberQueryService;
	@Autowired
	private MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;
	@Autowired
	private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;


	@Override
	public TransData<FPropertyRecord> getPropertyRecord(HttpServletRequest request) throws Exception {
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

		PropertyRecord userPropertyRecord = this.userCacheQueryService.getUserPropertyRecord(shopId, accountType, accountId);
		FPropertyRecord fPropertyRecord = new FPropertyRecord();
		// 转换用户账号基本信息
		if (userPropertyRecord != null && userPropertyRecord.getAccountBaseInfo() != null) {
			FAccountBaseInfo fAccountBaseInfo = new FAccountBaseInfo();
			BeanUtils.copyProperties(userPropertyRecord.getAccountBaseInfo(), fAccountBaseInfo, new String[] { "age" });
			if (userPropertyRecord.getAccountBaseInfo().getAge() != null) {
				fAccountBaseInfo.setAge(userPropertyRecord.getAccountBaseInfo().getAge());
			}
			fPropertyRecord.setAccountBaseInfo(fAccountBaseInfo);
		}
		// 转换用户账号类型信息（用户标识）
		if (userPropertyRecord != null && userPropertyRecord.getAccountTypeInfo() != null) {
			FAccountTypeInfo fAccountTypeInfo = new FAccountTypeInfo();
			BeanUtils.copyProperties(userPropertyRecord.getAccountTypeInfo(), fAccountTypeInfo);
			fPropertyRecord.setAccountTypeInfo(fAccountTypeInfo);
		}


		MemberFeatureExample memberFeatureExample = new MemberFeatureExample();
		com.gooagoo.entity.generator.member.MemberFeatureExample.Criteria createCriteria = memberFeatureExample.createCriteria();
		createCriteria.andShopIdEqualTo(shopId).andIsDelEqualTo(GMSConstant.NO);
		List<MemberFeature> MemberFeatureList = this.memberFeatureGeneratorQueryService.selectByExample(memberFeatureExample);
		// 转化用户特征信息
		FMemberFeatureInfo fmemberFeatureInfo = null;
		for (MemberFeature memberFeature : MemberFeatureList) {
			fmemberFeatureInfo = new FMemberFeatureInfo();
			fmemberFeatureInfo.setFeatureCode(memberFeature.getTypeCode());
			fmemberFeatureInfo.setFeatureName(memberFeature.getTypeName());
			if (userPropertyRecord != null && !CollectionUtils.isEmpty(userPropertyRecord.getMemberFeatureInfoList())) {
				for (MemberFeatureInfo memberFeatureInfo : userPropertyRecord.getMemberFeatureInfoList()) {
					if (memberFeature.getTypeCode().equals(memberFeatureInfo.getFeatureCode())) {
						fmemberFeatureInfo.setFeatureValue(memberFeatureInfo.getFeatureValue());
					}
				}
			}
			fPropertyRecord.getMemberFeatureInfoList().add(fmemberFeatureInfo);
		}
		return GMSUtil.toTransData(true, "", fPropertyRecord);
	}

	@Override
	public TransData<PageModel<FActionRecord>> getActionRecord(HttpServletRequest request) throws Exception {
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

		PageModel<FActionRecord> pageModel = new PageModel<FActionRecord>();
		pageModel.setPageIndex(pageCondition.getPageIndex());
		pageModel.setPageSize(pageCondition.getPageSize());
		Integer count = this.userCacheQueryService.countUserActionRecords(shopId, accountType, accountId);
		boolean isEmpty = count ==null;
		pageModel.setCount(isEmpty ? 0 : count);
		if (!isEmpty) {
			List<ActionRecord> userActionRecords = this.userCacheQueryService.getUserActionRecords(shopId, accountType, accountId, pageModel.getPageIndex(), pageModel.getPageSize());
			// 分页获取数据并转换成页面对象
			FActionRecord factionRecord = null;
			for (ActionRecord actionRecord : userActionRecords) {
				factionRecord = new FActionRecord();
				factionRecord.setAccountType(actionRecord.getAccountType());
				factionRecord.setActionDesc("");
				factionRecord.setActionTime(actionRecord.getTimestamp());
				factionRecord.setActionType(actionRecord.getBehaveType());
				factionRecord.setIpAddress(actionRecord.getIp());
				factionRecord.setSource(actionRecord.getSource());
				factionRecord.setUserName(actionRecord.getAccountNo());
				pageModel.getResult().add(factionRecord);
			}
		}
		return GMSUtil.toTransData(true, null, pageModel);
	}

	@Override
	public TransData<PageModel<FConsumeRecord>> getConsumeRecord(HttpServletRequest request) throws Exception {
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
		PageModel<FConsumeRecord> pageModel = new PageModel<FConsumeRecord>();
		pageModel.setPageIndex(pageCondition.getPageIndex());
		pageModel.setPageSize(pageCondition.getPageSize());
		pageModel.setCount(0);
		if (StringUtils.hasText(accountId) && StringUtils.hasText(accountType)) {
			ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
			OrderInfoExample orderInfoExample = new OrderInfoExample();
			Criteria criteria = orderInfoExample.createCriteria().andIsDelEqualTo("N").andBillTypeEqualTo("3");
			if(GMSConstant.ACCOUNTTYPE_USERID.equals(accountType)){
				criteria.andUserIdEqualTo(accountId);	
			}else if(GMSConstant.ACCOUNTTYPE_MAC.equals(accountType)){
				criteria.andMacEqualTo(accountId);
			}else if(GMSConstant.ACCOUNTTYPE_PHY_CARD_NO.equals(accountType)){
				 MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
				 memberOfCardExample.createCriteria().andIsDelEqualTo(GMSConstant.NO).andShopIdEqualTo(shopLoginInfo.getShopAndUserInfo().getShopId()).andPhyCardNoEqualTo(accountId);
			     List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
			     if(CollectionUtils.isEmpty(memberOfCardList)){
			    	 return GMSUtil.toTransData(true, null, pageModel);
			     }else{
			    	 criteria.andScardNoEqualTo(memberOfCardList.get(0).getScardno());
			     }
			}else{
				GooagooLog.warn("cpm查询用户消费档案获，不支持的帐号类型："+accountType);
				return GMSUtil.toTransData(true, null, pageModel);
			}
				
			String userShopEntityId = shopLoginInfo.getShopAndUserInfo().getUserShopEntityId();
			if(org.apache.commons.lang.StringUtils.isNotBlank(userShopEntityId)){
				criteria.andShopEntityIdEqualTo(userShopEntityId);
			}
			criteria.andShopIdEqualTo(shopLoginInfo.getShopAndUserInfo().getShopId());
			Integer count = this.orderInfoGeneratorQueryService.countByExample(orderInfoExample);
			if (count > 0) {
				pageModel.setCount(count);
				orderInfoExample.setPage(pageModel.getPageIndex(), pageModel.getPageSize());
				// 查询订单
				List<OrderInfo> billInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
				// 分页获取数据并转换成页面对象
				FConsumeRecord fconsumeRecord = null;
				for (OrderInfo orderInfo : billInfoList) {
					fconsumeRecord = new FConsumeRecord();
					fconsumeRecord.setOrderNo(orderInfo.getOrderId());
					fconsumeRecord.setPayMoney(orderInfo.getPayPrice());
					fconsumeRecord.setPayTime(orderInfo.getRequestTime());
					OrderPicExample orderPicExample = new OrderPicExample();
					orderPicExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId()).andPicTypeEqualTo("1");
					orderPicExample.setDistinct(true);
					// 获取订单图片
					List<OrderPic> orderPicList = this.orderPicGeneratorQueryService.selectByExample(orderPicExample);
					if (!CollectionUtils.isEmpty(orderPicList)) {
						fconsumeRecord.setBillImg(orderPicList.get(0).getPicUrl());
					}
					OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
					com.gooagoo.entity.generator.bill.OrderDetailInfoExample.Criteria createCriteria = orderDetailInfoExample.createCriteria();
					createCriteria.andOrderIdEqualTo(orderInfo.getOrderId());
					// 获取订单明细
					List<OrderDetailInfo> orderDetailList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
					FConsumeRecordDetail consumeRecordDetail = null;
					for (OrderDetailInfo orderDetailInfo : orderDetailList) {
						consumeRecordDetail = new FConsumeRecordDetail();
						consumeRecordDetail.setGoodsName(orderDetailInfo.getGoodsName());
						consumeRecordDetail.setGoodsNum(orderDetailInfo.getGoodsNum());
						consumeRecordDetail.setGoodsPrice(orderDetailInfo.getPayPrice());
						consumeRecordDetail.setTotalPrice(orderDetailInfo.getTotalPrice());
						fconsumeRecord.getConsumeRecordDetailList().add(consumeRecordDetail);
					}
					pageModel.getResult().add(fconsumeRecord);
				}
			}
		}
		return GMSUtil.toTransData(true, null, pageModel);
	}

	@Override
	public TransData<PageModel<FIntegralRecord>> getIntegralRecord(HttpServletRequest request) throws Exception {
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

		PageModel<FIntegralRecord> pageModel = new PageModel<FIntegralRecord>();
		pageModel.setPageIndex(pageCondition.getPageIndex());
		pageModel.setPageSize(pageCondition.getPageSize());
		pageModel.setCount(0);
		if (GMSConstant.ACCOUNTTYPE_USERID.equals(accountType)) {
			IntegralDetailInfoExample integralDetailInfoExample = new IntegralDetailInfoExample();
			integralDetailInfoExample.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(accountId).andIsDelEqualTo("N");
			Integer count = this.integralDetailInfoGeneratorQueryService.countByExample(integralDetailInfoExample);
			if (count > 0) {
				pageModel.setCount(count);
				integralDetailInfoExample.setPage(pageModel.getPageIndex(), pageModel.getPageSize());
				List<IntegralDetailInfo> integralDetailInfoList = this.integralDetailInfoGeneratorQueryService.selectByExample(integralDetailInfoExample);
				FIntegralRecord fintegralRecord = null;
				for (IntegralDetailInfo integralDetailInfo : integralDetailInfoList) {
					fintegralRecord = new FIntegralRecord();
					fintegralRecord.setCreateTime(integralDetailInfo.getIntegralCreateTime());
					fintegralRecord.setIntegralNumber(integralDetailInfo.getIntegralNumber());
					fintegralRecord.setIntegralSource(integralDetailInfo.getIntegralSource());
					fintegralRecord.setNote(integralDetailInfo.getNote());
					UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(integralDetailInfo.getUserId());
					if (userInfo != null) {
						fintegralRecord.setUserName(userInfo.getAccount());
					}
					pageModel.getResult().add(fintegralRecord);
				}
			}
		}

		return GMSUtil.toTransData(true, null, pageModel);
	}


	@Override
	public TransData<UserRecordLeftMenuVo> getUserInfoForUserRecordDetailPageLeftMenu(HttpServletRequest request) throws Exception {

		String accountType = ServletRequestUtils.getStringParameter(request, "accountType", "");
		String accountId = ServletRequestUtils.getStringParameter(request, "accountId", "");
		String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
		UserRecordLeftMenuVo leftMenuVo = new UserRecordLeftMenuVo();

		if (GMSConstant.ACCOUNTTYPE_USERID.equals(accountType)) {
			MemberInfoBusiness findMemberInfo = this.userMemberQueryService.findMemberInfo(accountId, shopId, null);
			if (findMemberInfo != null) {
				leftMenuVo.setAccount(accountId);
				leftMenuVo.setEmail(findMemberInfo.getEmail());
				leftMenuVo.setIntegral(findMemberInfo.getUseableIntegralNumber());
				leftMenuVo.setMemberLevel(findMemberInfo.getCardName());
				leftMenuVo.setName(findMemberInfo.getName());
				leftMenuVo.setHeadImg(findMemberInfo.getHeadPic());
			}
		} else if (GMSConstant.ACCOUNTTYPE_PHY_CARD_NO.equals(accountType)) {
			MemberBaseInfoExample baseInfoExample = new MemberBaseInfoExample();
			com.gooagoo.entity.generator.member.MemberBaseInfoExample.Criteria criteria = baseInfoExample.createCriteria();
			criteria.andShopIdEqualTo(shopId).andPhyNoEqualTo(accountId);
			// criteria.andIsDelEqualTo(GMSConstant.NO);//统计用户能查询出已删除的用户
			List<MemberBaseInfo> memberBaseInfoList = this.memberBaseInfoGeneratorQueryService.selectByExample(baseInfoExample);
			if (!CollectionUtils.isEmpty(memberBaseInfoList)) {
				leftMenuVo.setEmail(memberBaseInfoList.get(0).getEmail());
				leftMenuVo.setName(memberBaseInfoList.get(0).getName());
				leftMenuVo.setMemberLevel(memberBaseInfoList.get(0).getPhyName());
				leftMenuVo.setPhyNo(memberBaseInfoList.get(0).getPhyNo());
			}

		} else if (GMSConstant.ACCOUNTTYPE_MAC.equals(accountType)) {
			leftMenuVo.setMac(accountId);
		}

		if (leftMenuVo != null && !StringUtils.hasText(leftMenuVo.getHeadImg())) {
			String baseUrl = GmsConfigCache.get(GMSConstant.HTML_URL_HEAD_KEY);
			leftMenuVo.setHeadImg(baseUrl + "/passport/images/deflogo.png");
		}

		return GMSUtil.toTransData(true, null, leftMenuVo);
	}

}

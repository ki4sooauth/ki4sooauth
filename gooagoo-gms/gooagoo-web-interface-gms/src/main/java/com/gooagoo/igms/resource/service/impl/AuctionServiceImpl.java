package com.gooagoo.igms.resource.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.api.business.core.system.bid.SysShopBidCoreService;
import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopAdGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopBidGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageExample.Criteria;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.exception.business.shop.ShopAdDeletedOrNotExistException;
import com.gooagoo.exception.business.shop.ShopBidAmountLackException;
import com.gooagoo.exception.business.shop.ShopBidTimeInvalidException;
import com.gooagoo.igms.resource.service.AuctionService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.resource.AdBidInfoView;
import com.gooagoo.view.gms.resource.AdView;

@Service("auctionService")
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private ShopAdGeneratorQueryService shopAdGeneratorQueryService;

	@Autowired
	private ShopBidGeneratorQueryService shopBidGeneratorQueryService;
	@Autowired
	private AdsManageGeneratorQueryService adsManageGeneratorQueryService;
	@Autowired
	private SysShopBidCoreService sysBhopBidCoreService;
	@Autowired
	private ShopLoginService shopLoginService;

	@Autowired
	private SystemBusinessCoreService systemBusinessCoreService;

	@Override
	public TransData<Object> auction(HttpServletRequest request) throws Exception {
		String biddingNo = ServletRequestUtils.getStringParameter(request, "biddingNo", "");
		String adCode = ServletRequestUtils.getStringParameter(request, "adCode", "");
		double bidAmount = ServletRequestUtils.getDoubleParameter(request, "bidAmount", 0);
		ShopBidExample shopBidExample = new ShopBidExample();
		shopBidExample.createCriteria().andIsDelEqualTo("N").andAdCodeEqualTo(adCode).andBidIdEqualTo(biddingNo);
		shopBidExample.setOrderByClause("bid_amount DESC");
		List<ShopBid> shopBidList = this.shopBidGeneratorQueryService.selectByExample(shopBidExample);
		AdsManage adsManage = this.adsManageGeneratorQueryService.selectByPrimaryKey(biddingNo);
		boolean isSuccess = false;
		Date dbTime = this.systemBusinessCoreService.getCoreSysCurrentTime();
		
		if (adsManage==null) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPAD_DELETED_OR_NOT_EXIST);
		}
		if ((adsManage.getBidEndTime().before(dbTime)) ||(adsManage.getBidStartTime().after(dbTime))) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPBID_TIME_INVALID);
		}
		if ((!CollectionUtils.isEmpty(shopBidList) && shopBidList.get(0).getBidAmount() >= bidAmount) || (adsManage.getStartingPrice() > bidAmount)) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPBID_AMOUNT_LACK);
		}
		ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
		ShopBid shopBid = new ShopBid();
		shopBid.setAdCode(adCode);
		shopBid.setBidAmount(bidAmount);
		shopBid.setBidId(biddingNo);
		shopBid.setId(UUID.getUUID());
		shopBid.setOperator(shopLoginInfo.getShopAndUserInfo().getUserId());
		shopBid.setShopId(shopLoginInfo.getShopAndUserInfo().getShopId());
		shopBid.setShopName(shopLoginInfo.getShopAndUserInfo().getShopName());
		try {
			isSuccess = this.sysBhopBidCoreService.shopBidding(shopBid);
		} catch (ShopAdDeletedOrNotExistException e) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPAD_DELETED_OR_NOT_EXIST, shopBid.getId());
		} catch (ShopBidTimeInvalidException e) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPBID_TIME_INVALID, shopBid.getId());
		} catch (ShopBidAmountLackException e) {
			return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_SHOPBID_AMOUNT_LACK, shopBid.getId());
		}
		return GMSUtil.getBooleanResult(isSuccess, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopBid.getId());
	}

	@Override
	public TransData<List<AdView>> findAllAd(HttpServletRequest request) throws Exception {
		ShopAdExample adExample = new ShopAdExample();
		adExample.createCriteria().andIsDelEqualTo("N");
		List<ShopAd> adList = this.shopAdGeneratorQueryService.selectByExample(adExample);
		List<AdView> adViews = new ArrayList<AdView>();
		AdView adView = null;
		if (!CollectionUtils.isEmpty(adList)) {
			for (ShopAd ad : adList) {
				adView = new AdView();
				BeanUtils.copyProperties(ad, adView);
				adViews.add(adView);
			}
		}
		return GMSUtil.toTransData(true, null, adViews);
	}

	@Override
	public TransData<List<AdBidInfoView>> getAdBidInfo(HttpServletRequest request) throws Exception {
		String adCode = ServletRequestUtils.getStringParameter(request, "adCode", "");
		AdsManageExample adsManageExample = new AdsManageExample();
		Criteria criteria = adsManageExample.createCriteria();
		criteria.andAdCodeEqualTo(adCode).andIsDelEqualTo("N");
		criteria.andStateEqualTo("1");
		List<AdsManage> adsManageList = this.adsManageGeneratorQueryService.selectByExample(adsManageExample);
		List<AdBidInfoView> adBidInfoList = new ArrayList<AdBidInfoView>();
		if (!CollectionUtils.isEmpty(adsManageList)) {
			AdBidInfoView adBidInfoView = null;
			for (AdsManage adsManage : adsManageList) {
				adBidInfoView = new AdBidInfoView();
				adBidInfoView.setAdCode(adsManage.getAdCode());
				adBidInfoView.setBidEndTime(adsManage.getBidEndTime());
				adBidInfoView.setBidId(adsManage.getBidId());
				adBidInfoView.setBidStartTime(adsManage.getBidStartTime());
				adBidInfoView.setEffectEndDate(adsManage.getEffectEndDate());
				adBidInfoView.setEffectEndTime(adsManage.getEffectEndTime().toString());
				adBidInfoView.setEffectStartDate(adsManage.getEffectStartDate());
				adBidInfoView.setEffectStartTime(adsManage.getEffectStartTime().toString());
				adBidInfoView.setIncrease(adsManage.getIncrease());
				adBidInfoView.setStartingPrice(adsManage.getStartingPrice());
				// 查询当前最高出价
				ShopBidExample shopBidExample = new ShopBidExample();
				shopBidExample.setOrderByClause("bid_amount desc");
				shopBidExample.createCriteria().andAdCodeEqualTo(adCode).andBidIdEqualTo(adsManage.getBidId());
				List<ShopBid> shopBidList = this.shopBidGeneratorQueryService.selectByExample(shopBidExample);
				if (!CollectionUtils.isEmpty(shopBidList)) {
					adBidInfoView.setMaxBidAmount(shopBidList.get(0).getBidAmount());
					adBidInfoView.setShopName(shopBidList.get(0).getShopName());
				}
				adBidInfoList.add(adBidInfoView);
			}
		}
		return GMSUtil.toTransData(true, null, adBidInfoList);
	}
}

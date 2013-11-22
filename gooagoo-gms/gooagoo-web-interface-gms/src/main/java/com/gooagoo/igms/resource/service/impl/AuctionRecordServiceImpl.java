package com.gooagoo.igms.resource.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.system.bid.SysShopBidQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.system.bid.BidDetailInfo;
import com.gooagoo.entity.business.system.bid.BidDetailInfoBusiness;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.resource.service.AuctionRecordService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.resource.AllBiddingRecordView;
import com.gooagoo.view.gms.resource.ShopBiddingRecordView;
import com.gooagoo.view.gms.resource.WinBiddingRecordView;

@Service("auctionRecordService")
public class AuctionRecordServiceImpl implements AuctionRecordService
{
    @Autowired
    private SysShopBidQueryService sysShopBidQueryService;

    @Override
    public TransData<PageModel<AllBiddingRecordView>> pageAllBiddingRecord(HttpServletRequest request) throws Exception
    {
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        PageModel<AllBiddingRecordView> pageModel = new PageModel<AllBiddingRecordView>();
        pageModel.setPageIndex(condition.getPageIndex());
        pageModel.setPageSize(condition.getPageSize());
        pageModel.setCount(0);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        BidDetailInfoBusiness findShopBidHistory = this.sysShopBidQueryService.findShopBidHistory(shopId, condition.getPageIndex(), condition.getPageSize());
        if (findShopBidHistory != null && !CollectionUtils.isEmpty(findShopBidHistory.getBidDetailInfoList()))
        {
            pageModel.setCount(Integer.parseInt(findShopBidHistory.getCount()));
            AllBiddingRecordView allBiddingRecordView = null;
            for (BidDetailInfo bidDetailInfo : findShopBidHistory.getBidDetailInfoList())
            {
                allBiddingRecordView = new AllBiddingRecordView();
                ShopAd shopAd = bidDetailInfo.getShopAd();
                ShopBid shopBid = bidDetailInfo.getShopBid();
                AdsManage adsManage = bidDetailInfo.getAdsManage();
                if (shopAd != null)
                {
                    allBiddingRecordView.setAdDescription(shopAd.getAdDescription());
                    allBiddingRecordView.setAdName(shopAd.getAdName());
                    allBiddingRecordView.setInPage(SysdictionaryCache.get("ad_type", shopAd.getAdType()));
                }
                if (shopBid != null)
                {
                    allBiddingRecordView.setBidAmount(shopBid.getBidAmount());
                    allBiddingRecordView.setShopName(shopBid.getShopName());
                    allBiddingRecordView.setBidDate(shopBid.getCreateTime());
                }
                if (adsManage != null)
                {
                    allBiddingRecordView.setBiddingNo(adsManage.getBidId());
                    allBiddingRecordView.setBiddingEndTime(adsManage.getBidEndTime());
                    allBiddingRecordView.setBiddingStartTime(adsManage.getBidStartTime());
                    allBiddingRecordView.setEffectEndDate(adsManage.getEffectEndDate());
                    allBiddingRecordView.setEffectEndTime(adsManage.getEffectEndTime().toString());
                    allBiddingRecordView.setEffectStartDate(adsManage.getEffectStartDate());
                    allBiddingRecordView.setEffectStartTime(adsManage.getEffectStartTime().toString());
                }
                if (adsManage != null && shopBid != null)
                {
                    if ("1".equals(adsManage.getState()) && org.apache.commons.lang.StringUtils.isBlank(adsManage.getId()))
                    {
                        allBiddingRecordView.setResult("竞拍结果处理中");
                    }
                    else if (org.apache.commons.lang.StringUtils.isNotBlank(adsManage.getId()) && adsManage.getId().equals(shopBid.getId()))
                    {
                        String result = adsManage.getState();
                        result = SysdictionaryCache.get("advertisement_status", result);
                        allBiddingRecordView.setResult(result);
                    }
                    else
                    {
                        allBiddingRecordView.setResult("竞拍失败");
                    }
                }
                pageModel.getResult().add(allBiddingRecordView);
            }
        }

        return GMSUtil.toTransData(true, null, pageModel);
    }

    @Override
    public TransData<PageModel<WinBiddingRecordView>> pageWinBiddingRecord(HttpServletRequest request) throws Exception
    {
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        String adCode = ServletRequestUtils.getStringParameter(request, "adCode", "");
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        PageModel<WinBiddingRecordView> pageModel = new PageModel<WinBiddingRecordView>();
        pageModel.setPageIndex(condition.getPageIndex());
        pageModel.setPageSize(condition.getPageSize());
        pageModel.setCount(0);
        BidDetailInfoBusiness findAdBidHistory = this.sysShopBidQueryService.findAdBidHistory(adCode, "A", shopId, condition.getPageIndex(), condition.getPageSize());
        WinBiddingRecordView biddingRecordView = null;
        if (findAdBidHistory != null && !CollectionUtils.isEmpty(findAdBidHistory.getBidDetailInfoList()))
        {
            pageModel.setCount(Integer.parseInt(findAdBidHistory.getCount()));
            for (BidDetailInfo bidDetailInfo : findAdBidHistory.getBidDetailInfoList())
            {
                biddingRecordView = new WinBiddingRecordView();
                ShopAd shopAd = bidDetailInfo.getShopAd();
                ShopBid shopBid = bidDetailInfo.getShopBid();
                AdsManage adsManage = bidDetailInfo.getAdsManage();
                if (shopAd != null)
                {
                    biddingRecordView.setAdDescription(shopAd.getAdDescription());
                    biddingRecordView.setAdName(shopAd.getAdName());
                }
                if (shopBid != null)
                {
                    biddingRecordView.setBidAmount(shopBid.getBidAmount());
                    biddingRecordView.setShopName(shopBid.getShopName());
                    biddingRecordView.setBidDate(shopBid.getCreateTime());
                }
                if (adsManage != null)
                {
                    biddingRecordView.setBiddingEndTime(adsManage.getBidEndTime());
                    biddingRecordView.setBiddingNo(adsManage.getBidId());
                    biddingRecordView.setBiddingStartTime(adsManage.getBidStartTime());
                    biddingRecordView.setClickRate(Integer.parseInt(bidDetailInfo.getClickNums()));
                    biddingRecordView.setEffectEndDate(adsManage.getEffectEndDate());
                    biddingRecordView.setEffectEndTime(adsManage.getEffectEndTime().toString());
                    biddingRecordView.setEffectStartDate(adsManage.getEffectStartDate());
                    biddingRecordView.setEffectStartTime(adsManage.getEffectEndTime().toString());
                }
                if (adsManage != null && shopBid != null)
                {
                    if ("1".equals(adsManage.getState()) && org.apache.commons.lang.StringUtils.isBlank(adsManage.getId()))
                    {
                        biddingRecordView.setResult("竞拍结果处理中");
                    }
                    else if (org.apache.commons.lang.StringUtils.isNotBlank(adsManage.getId()) && adsManage.getId().equals(shopBid.getId()))
                    {
                        String result = adsManage.getState();
                        result = SysdictionaryCache.get("advertisement_status", result);
                        biddingRecordView.setResult(result);
                    }
                    else
                    {
                        biddingRecordView.setResult("竞拍失败");
                    }
                }
                pageModel.getResult().add(biddingRecordView);
            }
        }

        return GMSUtil.toTransData(true, null, pageModel);
    }

    @Override
    public TransData<PageModel<ShopBiddingRecordView>> pageShopBiddingRecord(HttpServletRequest request) throws Exception
    {
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        String adCode = ServletRequestUtils.getStringParameter(request, "adCode", "");
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        PageModel<ShopBiddingRecordView> pageModel = new PageModel<ShopBiddingRecordView>();
        pageModel.setPageIndex(condition.getPageIndex());
        pageModel.setPageSize(condition.getPageSize());
        pageModel.setCount(0);
        BidDetailInfoBusiness findAdBidHistory = this.sysShopBidQueryService.findAdBidHistory(adCode, "S", shopId, condition.getPageIndex(), condition.getPageSize());
        if (findAdBidHistory != null && !CollectionUtils.isEmpty(findAdBidHistory.getBidDetailInfoList()))
        {
            pageModel.setCount(Integer.parseInt(findAdBidHistory.getCount()));
            ShopBiddingRecordView shopBiddingRecordView = null;
            for (BidDetailInfo bidDetailInfo : findAdBidHistory.getBidDetailInfoList())
            {
                shopBiddingRecordView = new ShopBiddingRecordView();
                ShopAd shopAd = bidDetailInfo.getShopAd();
                ShopBid shopBid = bidDetailInfo.getShopBid();
                AdsManage adsManage = bidDetailInfo.getAdsManage();
                if (shopAd != null)
                {
                    shopBiddingRecordView.setAdDescription(shopAd.getAdDescription());
                    shopBiddingRecordView.setAdName(shopAd.getAdName());
                }
                if (shopBid != null)
                {
                    shopBiddingRecordView.setBidAmount(shopBid.getBidAmount());
                    shopBiddingRecordView.setBiddingTime(shopBid.getCreateTime());
                    shopBiddingRecordView.setBidDate(shopBid.getCreateTime());
                }
                if (adsManage != null)
                {
                    shopBiddingRecordView.setBiddingEndTime(adsManage.getBidEndTime());
                    shopBiddingRecordView.setBiddingStartTime(adsManage.getBidStartTime());
                    shopBiddingRecordView.setBiddingNo(adsManage.getBidId());
                    shopBiddingRecordView.setEffectEndDate(adsManage.getEffectEndDate());
                    shopBiddingRecordView.setEffectEndTime(adsManage.getEffectEndTime().toString());
                    shopBiddingRecordView.setEffectStartDate(adsManage.getEffectStartDate());
                    shopBiddingRecordView.setEffectStartTime(adsManage.getEffectStartTime().toString());
                }
                if (adsManage != null && shopBid != null)
                {
                    if ("1".equals(adsManage.getState()) && org.apache.commons.lang.StringUtils.isBlank(adsManage.getId()))
                    {
                        shopBiddingRecordView.setResult("竞拍结果处理中");
                    }
                    else if (org.apache.commons.lang.StringUtils.isNotBlank(adsManage.getId()) && adsManage.getId().equals(shopBid.getId()))
                    {
                        String result = adsManage.getState();
                        result = SysdictionaryCache.get("advertisement_status", result);
                        shopBiddingRecordView.setResult(result);
                    }
                    else
                    {
                        shopBiddingRecordView.setResult("竞拍失败");
                    }
                }
                pageModel.getResult().add(shopBiddingRecordView);
            }
        }
        return GMSUtil.toTransData(true, null, pageModel);
    }

}

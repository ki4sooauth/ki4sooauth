package com.gooagoo.query.business.system.bid;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.statistics.AdClickRateQueryService;
import com.gooagoo.api.business.query.system.bid.SysShopBidQueryService;
import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopAdGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopBidGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.sys.bid.ShopBidAdapterMapper;
import com.gooagoo.entity.business.system.bid.BidDetailInfo;
import com.gooagoo.entity.business.system.bid.BidDetailInfoBusiness;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageExample.Criteria;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;

@Service
public class SysShopBidQueryServiceImpl implements SysShopBidQueryService
{

    @Autowired
    private AdsManageGeneratorQueryService adsManageGeneratorQueryService;
    @Autowired
    private ShopAdGeneratorQueryService shopAdGeneratorQueryService;
    @Autowired
    private ShopBidGeneratorQueryService shopBidGeneratorQueryService;
    @Autowired
    private ShopBidAdapterMapper shopBidAdapterMapper;
    @Autowired
    private AdClickRateQueryService adClickRateQueryService;

    @Override
    public BidDetailInfoBusiness findAdBidHistory(String adCode, String type, String shopId, Integer pageIndex, Integer pageSize) throws Exception
    {
        BidDetailInfoBusiness bidDetailInfoBusiness = null;
        AdsManageExample adsManageExample = new AdsManageExample();
        Criteria criteria = adsManageExample.createCriteria();
        criteria.andAdCodeEqualTo(adCode).andIsDelEqualTo("N");
        if ("A".equals(type))
        {
            criteria.andWinnerShooIdIsNotNull();
        }
        Integer count = this.adsManageGeneratorQueryService.countByExample(adsManageExample);//总条数
        if (count > 0)
        {
            bidDetailInfoBusiness = new BidDetailInfoBusiness();
            List<BidDetailInfo> bidDetailInfoList = new ArrayList<BidDetailInfo>();
            bidDetailInfoBusiness.setCount(count.toString());
            if (pageIndex != null && pageSize != null)
            {
                adsManageExample.setPage(pageIndex, pageSize);
            }
            List<AdsManage> adsManageList = this.adsManageGeneratorQueryService.selectByExample(adsManageExample);
            for (AdsManage adsManage : adsManageList)
            {
                BidDetailInfo bidDetailInfo = new BidDetailInfo();
                //redis获取点击次数
                bidDetailInfo.setClickNums(this.adClickRateQueryService.clickRate(shopId, adsManage.getBidId()).toString());
                bidDetailInfo.setAdsManage(adsManage);//竞拍信息
                bidDetailInfo.setShopAd(this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(adCode));//广告信息
                ShopBidExample shopBidExample = new ShopBidExample();
                if ("A".equals(type))//所有商家:竞拍数据对应的是竞拍成功的商家竞拍数据(由于竞拍管理中商家竞价自动编号不是实时更新、所以获取该竞拍编号竞拍金额最高的竞拍信息)
                {
                    shopBidExample.createCriteria().andBidIdEqualTo(adsManage.getBidId()).andIsDelEqualTo("N");
                    shopBidExample.setOrderByClause("bid_amount DESC");
                }
                else if ("S".equals(type))//登录商家:竞拍数据对应的是此商家竞拍的最高价数据
                {
                    shopBidExample.createCriteria().andBidIdEqualTo(adsManage.getBidId()).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
                    shopBidExample.setOrderByClause("bid_amount DESC");
                }
                else
                {
                    return null;
                }
                List<ShopBid> shopBidList = this.shopBidGeneratorQueryService.selectByExample(shopBidExample);
                if (CollectionUtils.isNotEmpty(shopBidList))
                {
                    bidDetailInfo.setShopBid(shopBidList.get(0));//商家竞拍信息
                }
                bidDetailInfoList.add(bidDetailInfo);
            }
            bidDetailInfoBusiness.setBidDetailInfoList(bidDetailInfoList);
        }
        return bidDetailInfoBusiness;
    }

    @Override
    public BidDetailInfoBusiness findShopBidHistory(String shopId, Integer pageIndex, Integer pageSize) throws Exception
    {
        BidDetailInfoBusiness bidDetailInfoBusiness = null;
        Integer count = this.shopBidAdapterMapper.countShopBidDetailInfoByShopId(shopId);
        if (count != null && count > 0)
        {
            bidDetailInfoBusiness = new BidDetailInfoBusiness();
            List<BidDetailInfo> bidDetailInfoList = new ArrayList<BidDetailInfo>();
            bidDetailInfoBusiness.setCount(count.toString());
            List<ShopBid> shopBidList = this.shopBidAdapterMapper.findShopBidDetailInfoByShopId(shopId, pageIndex, pageSize);
            for (ShopBid shopBid : shopBidList)
            {
                AdsManage adsManage = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(shopBid.getBidId());
                ShopAd shopAd = this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(shopBid.getAdCode());
                if (adsManage == null || shopAd == null)
                {
                    continue;
                }
                BidDetailInfo bidDetailInfo = new BidDetailInfo();
                bidDetailInfo.setShopBid(shopBid);
                bidDetailInfo.setAdsManage(adsManage);
                bidDetailInfo.setShopAd(shopAd);
                //redis获取点击次数
                bidDetailInfo.setClickNums(this.adClickRateQueryService.clickRate(shopId, bidDetailInfo.getShopBid().getBidId()).toString());

                bidDetailInfoList.add(bidDetailInfo);
            }
            bidDetailInfoBusiness.setBidDetailInfoList(bidDetailInfoList);
        }
        return bidDetailInfoBusiness;
    }

    @Override
    public AdsManage findAdvertsManage(String adcode) throws Exception
    {
        AdsManage adsManage = null;
        Date currentDate = TimeUtils.convertStringToDate(TimeUtils.getCurrentDate());//当前日期
        String currentTime = TimeUtils.getCurrentTime();//当前时间
        AdsManageExample adsManageExample = new AdsManageExample();
        adsManageExample.createCriteria().andAdCodeEqualTo(adcode).andIsDelEqualTo("N").andEffectStartDateLessThanOrEqualTo(currentDate).andEffectEndDateGreaterThanOrEqualTo(currentDate).andEffectStartTimeLessThanOrEqualTo(currentTime).andEffectEndTimeGreaterThanOrEqualTo(currentTime);
        List<AdsManage> adsManageList = this.adsManageGeneratorQueryService.selectByExample(adsManageExample);
        if (CollectionUtils.isNotEmpty(adsManageList))
        {
            adsManage = new AdsManage();
            return adsManageList.get(0);
        }
        ShopAd shopAd = this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(adcode);
        if (shopAd != null)
        {
            adsManage = new AdsManage();
            adsManage.setLinkUrl(shopAd.getLinkUrl());
            adsManage.setImgUrl(shopAd.getImgUrl());
            adsManage.setEffectStartTime(new Time(new Date().getTime()));
            adsManage.setEffectEndTime(new Time(new Date().getTime()));
        }
        return adsManage;
    }

    @Override
    public List<BidDetailInfo> findAllShopAd(AdsManageExample adsManageExample) throws Exception
    {
        List<BidDetailInfo> bidDetailInfoList = null;
        List<AdsManage> adsManageList = this.adsManageGeneratorQueryService.selectByExample(adsManageExample);
        if (CollectionUtils.isNotEmpty(adsManageList))
        {
            bidDetailInfoList = new ArrayList<BidDetailInfo>();
            for (AdsManage adsManage : adsManageList)
            {
                BidDetailInfo bidDetailInfo = new BidDetailInfo();
                bidDetailInfo.setAdsManage(adsManage);
                if (StringUtils.hasText(adsManage.getAdCode()))
                {
                    ShopAd shopAd = this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(adsManage.getAdCode());
                    if (shopAd != null)
                    {
                        bidDetailInfo.setShopAd(shopAd);
                    }
                }
                bidDetailInfoList.add(bidDetailInfo);
            }
        }
        return bidDetailInfoList;
    }

}

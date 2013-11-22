package com.gooagoo.core.business.system.bid;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.business.core.system.bid.SysShopBidCoreService;
import com.gooagoo.api.generator.core.sys.AdsManageGeneratorCoreService;
import com.gooagoo.api.generator.core.sys.ShopBidGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.dao.business.sys.SystemBusinessMapper;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.exception.business.shop.ShopAdDeletedOrNotExistException;
import com.gooagoo.exception.business.shop.ShopBidAmountLackException;
import com.gooagoo.exception.business.shop.ShopBidTimeInvalidException;

public class SysShopBidCoreServiceImpl implements SysShopBidCoreService
{

    @Autowired
    private ShopBidGeneratorCoreService shopBidGeneratorCoreService;
    @Autowired
    private AdsManageGeneratorCoreService adsManageGeneratorCoreService;
    @Autowired
    private SystemBusinessMapper systemBusinessMapper;

    @Override
    public boolean shopBidding(ShopBid shopBid) throws Exception
    {
        AdsManage adsManage = this.adsManageGeneratorCoreService.selectUnDelByPrimaryKey(shopBid.getBidId());
        if (adsManage == null)
        {
            GooagooLog.info("广告位管理不存在或已删除异常[bidId=" + shopBid.getBidId() + "]");
            throw new ShopAdDeletedOrNotExistException("广告位管理不存在或已删除异常[bidId=" + shopBid.getBidId() + "]");
        }
        Date currentTime = this.systemBusinessMapper.getCurrentTime();
        if (adsManage.getBidStartTime().compareTo(currentTime) > 0 || adsManage.getBidEndTime().compareTo(currentTime) < 0)
        {
            GooagooLog.info("竞拍时间未到或已结束[bidId=" + shopBid.getBidId() + "]");
            throw new ShopBidTimeInvalidException("竞拍时间未到或已结束[bidId=" + shopBid.getBidId() + "]");

        }
        ShopBidExample shopBidExample = new ShopBidExample();
        shopBidExample.createCriteria().andBidIdEqualTo(shopBid.getBidId()).andIsDelEqualTo("N");
        shopBidExample.setOrderByClause("bid_amount DESC");
        List<ShopBid> shopBidList = this.shopBidGeneratorCoreService.selectByExample(shopBidExample);
        if (CollectionUtils.isNotEmpty(shopBidList))
        {
            Double maxBidAmount = shopBidList.get(0).getBidAmount();
            //竞拍金额必须大于最高已竞拍金额
            if (shopBid.getBidAmount() <= maxBidAmount)
            {
                GooagooLog.info("商家竞拍金额[" + shopBid.getBidAmount() + "] 小于或等于最高已竞拍金额[" + maxBidAmount + "]");
                throw new ShopBidAmountLackException("商家竞拍金额[" + shopBid.getBidAmount() + "] 小于或等于最高已竞拍金额[" + maxBidAmount + "]");
            }
        }
        shopBid.setIsDel("N");
        return this.shopBidGeneratorCoreService.insertSelective(shopBid);
    }

    @Override
    public boolean addAdsManage(AdsManage adsManage) throws Exception
    {
        adsManage.setBidId(UUID.getUUID());
        adsManage.setIsDel("N");
        return this.adsManageGeneratorCoreService.insertSelective(adsManage);
    }

    @Override
    public boolean updateAdsManage(AdsManage adsManage) throws Exception
    {
        return this.adsManageGeneratorCoreService.updateByPrimaryKeySelective(adsManage);
    }

    @Override
    public boolean updateAdsManageState(String bidIds, String state) throws Exception
    {
        //参数效验
        if (StringUtils.isEmpty(bidIds) || StringUtils.isEmpty(state))
        {
            return false;
        }
        List<String> bidIdList = Arrays.asList(bidIds.split(","));
        AdsManageExample adsManageExample = new AdsManageExample();
        adsManageExample.createCriteria().andBidIdIn(bidIdList).andIsDelEqualTo("N");
        AdsManage adsManage = new AdsManage();
        adsManage.setState(state);
        return this.adsManageGeneratorCoreService.updateByExampleSelective(adsManage, adsManageExample);
    }

    @Override
    public boolean deleteAdsManage(String bidIds) throws Exception
    {
        List<String> bidIdList = Arrays.asList(bidIds.split(","));
        AdsManageExample adsManageExample = new AdsManageExample();
        adsManageExample.createCriteria().andBidIdIn(bidIdList).andIsDelEqualTo("N");
        AdsManage adsManage = new AdsManage();
        adsManage.setIsDel("Y");
        return this.adsManageGeneratorCoreService.updateByExampleSelective(adsManage, adsManageExample);
    }

    @Override
    public boolean batchShopBid(AdsManage adsManage) throws Exception
    {
        if (!"1".equals(adsManage.getState()))
        {
            GooagooLog.info("广告位状态非发布-1[bidId=" + adsManage.getBidId() + "、state=" + adsManage.getState() + "]");
            return false;
        }
        Date currentTime = new Date();
        if (currentTime.before(adsManage.getBidEndTime()))
        {
            GooagooLog.info("当前竞拍未结束[bidId=" + adsManage.getBidId() + "]");
            return false;
        }
        ShopBidExample shopBidExample = new ShopBidExample();
        shopBidExample.createCriteria().andBidIdEqualTo(adsManage.getBidId()).andIsDelEqualTo("N");
        shopBidExample.setOrderByClause("bid_amount DESC");
        List<ShopBid> shopBidList = this.shopBidGeneratorCoreService.selectByExample(shopBidExample);
        if (CollectionUtils.isEmpty(shopBidList))
        {
            GooagooLog.error("查询商家竞拍信息为空[bidId=" + adsManage.getBidId() + "]", null);
            return false;
        }
        ShopBid winnerShopBid = shopBidList.get(0);//得标商家竞拍信息
        adsManage.setId(winnerShopBid.getId());
        adsManage.setWinnerShooId(winnerShopBid.getShopId());
        adsManage.setWinnerShooName(winnerShopBid.getShopName());
        adsManage.setBidAmount(winnerShopBid.getBidAmount());
        adsManage.setState("2");//状态改为已拍-2
        return this.adsManageGeneratorCoreService.updateByPrimaryKeySelective(adsManage);
    }
}

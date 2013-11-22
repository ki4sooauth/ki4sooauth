package com.gooagoo.igus.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.system.bid.SysShopBidQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UAdvertisement;

/**
 * 获取广告信息
 * @author SPZ
 *
 */
@Service("igus021Service")
public class IGus021ServiceImpl implements IGusService
{

    @Autowired
    private SysShopBidQueryService sysShopBidQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String adCode = ServletRequestUtils.getStringParameter(request, "adCode");
            AdsManage adsManage = this.sysShopBidQueryService.findAdvertsManage(adCode);
            if (adsManage == null)
            {
                GooagooLog.error("获取广告信息：广告位（" + adCode + "）没有广告信息", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            UAdvertisement uadvertisement = new UAdvertisement();
            uadvertisement.setBidId(adsManage.getBidId());
            uadvertisement.setImgUrl(adsManage.getImgUrl());
            uadvertisement.setLinkUrl(adsManage.getLinkUrl());
            uadvertisement.setShopId(adsManage.getWinnerShooId());
            transData = new TransData<Object>(true, null, uadvertisement);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取广告信息：获取广告信息异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}

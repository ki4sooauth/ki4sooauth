package com.gooagoo.igus.common.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.system.bid.SysShopBidQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.igus.common.service.IAdCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UAdInfo;

@Service("iAdCommonService")
public class IAdCommonServiceImpl implements IAdCommonService
{

    @Autowired
    private SysShopBidQueryService sysShopBidQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_ADCOMMON_GETADINFO)
    public TransData<Object> getAdInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String adCode = ServletRequestUtils.getStringParameter(request, "adCode");
            AdsManage adsManage = this.sysShopBidQueryService.findAdvertsManage(adCode);
            if (adsManage == null)
            {
                GooagooLog.info("查询广告信息：广告位（" + adCode + "）无广告信息");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            UAdInfo uadInfo = new UAdInfo();
            uadInfo.setBidId(adsManage.getBidId());
            uadInfo.setImgUrl(adsManage.getImgUrl());
            uadInfo.setLinkUrl(adsManage.getLinkUrl());
            uadInfo.setShopId(adsManage.getWinnerShooId());
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uadInfo);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询广告信息：查询广告信息异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}

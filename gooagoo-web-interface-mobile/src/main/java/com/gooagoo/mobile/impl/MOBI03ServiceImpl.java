package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.GpsNavigationMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobi03.transform.NavigationARoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBI03:用户地图导航接口A
 * 导航（起点{x,y}，终点{x,y}） 
 * 
 */

@Service("mobi03")
public class MOBI03ServiceImpl implements ImobileService
{

    @Autowired
    private GpsNavigationMobileService gpsNavigationMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        NavigationARoot root = new NavigationARoot();
        root.setResult("false");
        try
        {
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobi03"));
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String smapId = parameter.getString("smapid");
            String emapId = parameter.getString("emapid");
            Double spx = parameter.getDouble("spx");
            Double spy = parameter.getDouble("spy");
            Double epx = parameter.getDouble("epx");
            Double epy = parameter.getDouble("epy");

            if (!StringUtils.hasText(smapId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SMAPID_IS_NULL);
            }
            if (!StringUtils.hasText(emapId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_EMAPID_IS_NULL);
            }
            if (spx == null)
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SPX_IS_NULL);
            }
            if (spy == null)
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SPY_IS_NULL);
            }
            if (epx == null)
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_EPX_IS_NULL);
            }
            if (epy == null)
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_EPY_IS_NULL);
            }
            root = this.gpsNavigationMobileService.getNavigationOfStartToEnd(smapId, spx, spy, emapId, epx, epy);
            root.setResult("true");
            root.setMsg("获取地图导航信息成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

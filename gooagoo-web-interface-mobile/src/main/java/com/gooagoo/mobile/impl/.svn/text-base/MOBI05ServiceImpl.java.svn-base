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
import com.gooagoo.mobile.entity.mobi05.transform.ShopListRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBI05:地图内商家信息列表
 * 
 * */

@Service("mobi05")
public class MOBI05ServiceImpl implements ImobileService
{

    @Autowired
    private GpsNavigationMobileService gpsNavigationMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ShopListRoot root = new ShopListRoot();
        root.setResult("false");
        try
        {
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobi05"));
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mapId = parameter.getString("mapid");
            if (!StringUtils.hasText(mapId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAPID_IS_NULL);
            }
            root = this.gpsNavigationMobileService.getShopListInfoInMap(mapId);
            root.setResult("true");
            root.setMsg("获取地图商家信息成功");
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

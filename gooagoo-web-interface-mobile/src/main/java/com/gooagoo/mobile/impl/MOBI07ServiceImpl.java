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
import com.gooagoo.mobile.entity.mobi07.transform.DownloadMapRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * mobi07 : 获取地图下载地址
 **/

@Service("mobi07")
public class MOBI07ServiceImpl implements ImobileService
{
    @Autowired
    private GpsNavigationMobileService gpsNavigationMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        DownloadMapRoot root = new DownloadMapRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobi07"));
            String mapId = parameter.getString("mapid");
            if (!StringUtils.hasText(mapId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAPID_IS_NULL);
            }
            root = this.gpsNavigationMobileService.downloadMapInfo(mapId);
            root.setResult("true");
            root.setMsg("获取地图下载地址成功 ");
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

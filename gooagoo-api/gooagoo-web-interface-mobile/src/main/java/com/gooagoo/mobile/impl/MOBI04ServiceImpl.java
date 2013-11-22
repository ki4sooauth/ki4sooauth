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
import com.gooagoo.mobile.entity.mobi04.transform.NavigationBRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBI04:用户地图导航接口B
 * 导航（起点{x,y}，实体店编号或商品编号）
 *  
 * */

@Service("mobi04")
public class MOBI04ServiceImpl implements ImobileService
{
    @Autowired
    private GpsNavigationMobileService gpsNavigationMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        NavigationBRoot root = new NavigationBRoot();
        root.setResult("false");
        try
        {
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobi04"));
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String sMapId = parameter.getString("smapid");
            String eMapId = parameter.getString("emapid");
            Double spx = parameter.getDouble("spx");
            Double spy = parameter.getDouble("spy");
            String type = parameter.getString("type");
            String objId = parameter.getString("objid");

            if (!StringUtils.hasText(sMapId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SMAPID_IS_NULL);
            }
            if (!StringUtils.hasText(eMapId))
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
            if (!StringUtils.hasText(type))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SEARCH_IS_NULL);
            }
            if (!StringUtils.hasText(objId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_OBJID_IS_NULL);
            }
            root = this.gpsNavigationMobileService.getNavigationOfMap(sMapId, spx, spy, eMapId, objId, type);
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

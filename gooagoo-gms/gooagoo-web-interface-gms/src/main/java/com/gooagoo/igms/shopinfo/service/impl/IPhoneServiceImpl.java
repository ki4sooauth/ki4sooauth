package com.gooagoo.igms.shopinfo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.igms.shopinfo.service.IPhoneService;

@Service("iphoneService")
public class IPhoneServiceImpl implements IPhoneService
{

    @Override
    @Deprecated
    public TransData<Object> bindPhone(HttpServletRequest request) throws Exception
    {
        //        String oldPhone = ServletRequestUtils.getStringParameter(request, "oldPhone", "");
        //        String newPhone = ServletRequestUtils.getStringParameter(request, "newPhone", "");
        //        GmsLoginInfo gmsLoginInfo = GMSUtil.getShopInfo(request);
        //        boolean flag = this.coreShopInfoService.bindMobile(gmsLoginInfo.getShopId(), oldPhone, newPhone);
        //        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_SHOPINFO_BASE_BINDMOBILE_SUCCESS, MessageConst.GMS_SHOPINFO_BASE_BINDMOBILE_FAIL);
        return null;
    }

}

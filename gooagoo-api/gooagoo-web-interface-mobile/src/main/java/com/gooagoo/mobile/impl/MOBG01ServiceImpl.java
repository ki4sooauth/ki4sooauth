package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.BaseInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobg01.transform.BaseInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBG01:基本信息接口
 */
@Service("mobg01")
public class MOBG01ServiceImpl implements ImobileService
{

    @Autowired
    private BaseInfoMobileService baseInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        BaseInfoRoot root = new BaseInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);

            String type = parameter.getString("type");
            String containcode = parameter.getString("containcode");
            String shopEntityId = parameter.getString("entityposition");
            String syninfo = parameter.getString("syninfo");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobg01"));

            if (!StringUtils.hasText(type))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SYNINFO_WAY_IS_NULL);
            }
            if (type.toString().equals("1") && !StringUtils.hasText(syninfo))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_WAY_IS_1_SYNINFO_IS_NULL);
            }
            if (type.toString().equals("2") && !StringUtils.hasText(shopEntityId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_WAY_IS_2_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(containcode))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CONTAINCODE_IS_NULL);
            }

            root = this.baseInfoMobileService.getShopBaseInfo(type, shopEntityId, syninfo, containcode);
            root.setResult("true");
            root.setMsg("同步商家基本信息成功");

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

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf11.transform.UpdateAppInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 检查更新gooagoo APP最新版本
 */
@Service("mobf11")
public class MOBF11ServiceImpl implements ImobileService
{
    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        UpdateAppInfoRoot root = new UpdateAppInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String versioncode = parameter.getString("versioncode");
            String mobiletype = parameter.getString("mobiletype");
            String appcode = parameter.getString("appcode");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf11"));
            if (!StringUtils.hasText(appcode))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_APPCODE_IS_NULL);
            }
            if (!StringUtils.hasText(versioncode))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MVER_IS_NULL);
            }
            if (!StringUtils.hasText(mobiletype))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MTYPE_IS_NULL);
            }
            root = this.infoSetMobileService.getUpdateAppInfo(appcode, versioncode, mobiletype);
            root.setResult("true");
            root.setMsg("检查更新gooagoo APP最新版本成功");
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

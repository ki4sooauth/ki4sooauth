package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf09.transform.GetVerifycodeRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口 MOBF09 : 用户注册(手机号-获取短信验证码)
 * */

@Service("mobf09")
public class MOBF09ServiceImpl implements ImobileService
{

    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetVerifycodeRoot root = new GetVerifycodeRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String phone = parameter.getString("phone");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf09"));

            if (!StringUtils.hasText(phone))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHONE_IS_NULL);
            }

            this.infoSetMobileService.getPhoneVerifycode(phone);
            root.setResult("true");
            root.setMsg("获取短信验证码成功");
        }
        catch (OperateFailException e)
        {//获取短信验证码失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_GET_SHORTMESSAGE_VERIFYCODE_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
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

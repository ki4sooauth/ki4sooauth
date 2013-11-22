package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.PubUtils;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.user.EmailFormatErrorException;
import com.gooagoo.exception.business.user.PasswordFormatErrorException;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf10.transform.CheckVerifycodeRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口 MOBF10 : 用户注册(手机号-输入短信验证码)
 * */

@Service("mobf10")
public class MOBF10ServiceImpl implements ImobileService
{

    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String phone = parameter.getString("phone");
            String password = parameter.getString("password");
            String verifycode = parameter.getString("verifycode");
            String mac = parameter.getString("mac");
            String mver = parameter.getString("mver");
            String regIp = PubUtils.getIpAddr(request);

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf10"));//打印log

            if (!StringUtils.hasText(phone))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHONE_IS_NULL);
            }
            if (!StringUtils.hasText(password))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PASSWORD_IS_NULL);
            }
            if (!StringUtils.hasText(verifycode))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_VERIFYCODE_IS_NULL);
            }

            this.infoSetMobileService.checkVerifycode(phone, password, verifycode, mac, mver, regIp);
            root.setResult("true");
            root.setMsg("注册成功");
        }
        catch (EmailFormatErrorException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_PHONE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PasswordFormatErrorException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_REGIST_PASSWORD_LENGTH_BETWEEN_6_AND_20;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AccountAlreadyExistsException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_PHONE_ALREADY_REGISTER;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_REGIST_FAIL;
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

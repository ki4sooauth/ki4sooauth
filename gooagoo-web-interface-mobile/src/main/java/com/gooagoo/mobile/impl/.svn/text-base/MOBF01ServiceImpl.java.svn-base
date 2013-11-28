package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotActiveException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf01.transform.MemberLoginRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBF01:用户登陆
 * @param 
 */
@Service("mobf01")
public class MOBF01ServiceImpl implements ImobileService
{

    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MemberLoginRoot root = new MemberLoginRoot();
        root.setResult("false");
        root.setLogin(null);
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String mver = parameter.getString("mver");
            String iphonetoken = parameter.getString("iphonetoken");
            //必填
            String account = parameter.getString("account");
            String password = parameter.getString("password");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf01"));

            if (!StringUtils.hasText(account))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ACCOUNT_IS_NULL);
            }
            if (!StringUtils.hasText(password))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PASSWORD_IS_NULL);
            }
            root = this.infoSetMobileService.userLogin(account, password, mac, mver, iphonetoken);

            root.setResult("true");
            root.setMsg("登录成功");
        }
        catch (AccountNotExistException e)
        {//用户账号不存在
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_ACCOUNT_NOT_EXIST;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PasswordIncorrectException e)
        {//用户账号密码不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_ACCOUNT_PASSWORD_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AccountNotActiveException e)
        {//用户帐号未激活
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_ACCOUNT_NOT_ACTIVE;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AccountIsLockedException e)
        {//用户帐号状态已锁定
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_ACCOUNT_IS_LOCKED;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {//登录失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_LOGIN_FAIL;
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

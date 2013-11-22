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
import com.gooagoo.mobile.entity.mobf03.transform.MemberRegisterRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * 
 * MOBF03:用户注册
 *
 */
@Service("mobf03")
public class MOBF03ServiceImpl implements ImobileService
{

    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MemberRegisterRoot root = new MemberRegisterRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String mver = parameter.getString("mver");
            String regIp = PubUtils.getIpAddr(request);//注册ip地址
            //必填
            String email = parameter.getString("email");
            String password = parameter.getString("password");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf03"));

            if (!StringUtils.hasText(email))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_EMAIL_IS_NULL);
            }
            if (!StringUtils.hasText(password))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PASSWORD_IS_NULL);
            }
            this.infoSetMobileService.userRegister(email, password, mac, mver, regIp);
            root.setResult("true");
            root.setMsg("注册成功,请查收邮件,激活后登录");
        }
        catch (PasswordFormatErrorException e)
        {//密码长度只能在6-20个字符之间
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_REGIST_PASSWORD_LENGTH_BETWEEN_6_AND_20;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (EmailFormatErrorException e)
        {//邮箱格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_REGIST_EMAIL_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AccountAlreadyExistsException e)
        {//邮箱已被注册
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_USEREMAIL_ALREADY_REGISTER;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {//注册失败
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

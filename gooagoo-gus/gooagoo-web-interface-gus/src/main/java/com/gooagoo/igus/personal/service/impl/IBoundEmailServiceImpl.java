package com.gooagoo.igus.personal.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserActiveCodeCoreService;
import com.gooagoo.api.business.core.user.manage.UserCoreService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileCodeGeneratorQueryService;
import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.EmailContentUtils;
import com.gooagoo.common.gus.utils.MobileContentUtils;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.igus.personal.service.IBoundEmailService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iBoundEmailService")
public class IBoundEmailServiceImpl implements IBoundEmailService
{

    @Autowired
    private UserActiveCodeCoreService userActiveCodeCoreService;

    @Autowired
    private UserInfoGeneratorQueryService userInfoService;

    @Autowired
    private UserCoreService userCoreService;

    @Autowired
    private JmsTemplate mobileTemplate;

    @Autowired
    private ActiveMQQueue mobileDestination;

    @Autowired
    private JmsTemplate emailTemplate;

    @Autowired
    private ActiveMQQueue emailDestination;

    @Autowired
    private UserMobileCodeGeneratorQueryService codeGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDEMAIL_EMAILEXIST)
    public TransData<Object> emailExist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String account = ServletRequestUtils.getStringParameter(request, "emailName");
            if (StringUtils.isBlank(account))
            {
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_EMAILEXIST_ISNULL, null);
            }
            if (!DataPatternUtils.chechEmail(account))
            {
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_EMAILEXIST_ERROR, null);
            }
            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andEmailEqualTo(account);
            List<UserInfo> userInfoList = this.userInfoService.selectByExample(userInfoExample);
            if (CollectionUtils.isNotEmpty(userInfoList))
            {
                GooagooLog.info("邮箱是否存在：邮箱已存在（" + account + "）");
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_EMAILEXIST_EXIST, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDEMAIL_EMAILEXIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("邮箱是否存在：验证用户是否存在异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_EMAILEXIST_EXIST, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDEMAIL_SENDEMAIL)
    public TransData<Object> sendEmail(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String email = ServletRequestUtils.getStringParameter(request, "emailName");
            String code = ServletRequestUtils.getStringParameter(request, "messageCode");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activeCode = this.userActiveCodeCoreService.getEmailActiveCodeForBindEmail(userId, email, code);
            if (StringUtils.isBlank(activeCode))
            {
                GooagooLog.info("发送邮件(验证邮箱和短信验证码)：获取邮箱校验码失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_SENDEMAIL_FAIL, null);
            }
            try
            {
                if (DataPatternUtils.chechEmail(email))
                {
                    JmsUtils.send(this.emailTemplate, this.emailDestination, EmailContentUtils.userBoundEmail(email, activeCode));
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("发送邮件(验证邮箱和短信验证码)：邮件发送异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDEMAIL_SENDEMAIL_SUCCESS, null);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error("发送邮件(验证邮箱和短信验证码)：短信验证码不正确", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_SENDEMAIL_MESSAGE, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("发送邮件(验证邮箱和短信验证码)：发送邮件异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_SENDEMAIL_FAIL, null);
        }

        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDEMAIL_BOUNDEMAIL)
    public TransData<Object> boundEmail(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activeCode = ServletRequestUtils.getStringParameter(request, "code");
            String email = ServletRequestUtils.getStringParameter(request, "e");
            DesUtils desUtil = new DesUtils("fetchurl");
            email = desUtil.decrypt(email);
            String key = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            if (!this.userCoreService.updateEmail(key, userId, email, activeCode))
            {
                GooagooLog.info("绑定邮箱账号：绑定邮箱账号失败");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_BOUNDEMAIL_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDEMAIL_BOUNDEMAIL_SUCCESS, true);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error("绑定邮箱账号：操作失败异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_BOUNDEMAIL_FAIL, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("绑定邮箱账号：用户账号激活异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_BOUNDEMAIL_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDEMAIL_GETMESSAGECODE)
    public TransData<Object> getMessageCode(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String messageCode = null;
            String mobile = ServletRequestUtils.getStringParameter(request, "telephone");
            UserMobileCodeExample codeExample = new UserMobileCodeExample();
            codeExample.createCriteria().andMobileEqualTo(mobile).andIsDelEqualTo("N").andIsUsedEqualTo("N");
            codeExample.setOrderByClause("create_time desc");
            List<UserMobileCode> userMobileCodeList = this.codeGeneratorQueryService.selectByExample(codeExample);
            if (CollectionUtils.isNotEmpty(userMobileCodeList))
            {
                Date newDate = TimeUtils.dateAdd(5, userMobileCodeList.get(0).getCreateTime(), 2);
                if (newDate.after(new Date()))
                {
                    GooagooLog.info("获取短信验证码：手机（" + mobile + "）还有有效的短信验证码");
                    return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_GETMESSAGECODE_ERROR, null);
                }
            }
            messageCode = this.userActiveCodeCoreService.getMobileActiveCode(mobile);
            try
            {
                if (DataPatternUtils.checkMobilePhone(mobile))
                {
                    JmsUtils.send(this.mobileTemplate, this.mobileDestination, MobileContentUtils.userIdentityForBoundEmail(mobile, messageCode));
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("获取短信验证码：短信验证码发送异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDEMAIL_GETMESSAGECODE_SUCCESS, messageCode);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取短信验证码：获取短信验证码异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDEMAIL_GETMESSAGECODE_FAIL, null);
        }

        return transData;
    }

}

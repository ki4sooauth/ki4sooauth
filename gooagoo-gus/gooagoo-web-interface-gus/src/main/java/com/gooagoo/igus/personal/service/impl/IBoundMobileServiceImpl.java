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
import com.gooagoo.api.business.query.user.query.UserActiveCodeQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileCodeGeneratorQueryService;
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
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.igus.personal.service.IBoundMobileService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iBoundMobileService")
public class IBoundMobileServiceImpl implements IBoundMobileService
{

    @Autowired
    private UserActiveCodeCoreService userActiveCodeCoreService;

    @Autowired
    private UserActiveCodeQueryService userActiveCodeQueryService;

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
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDMOBILE_MOBILEEXIST)
    public TransData<Object> mobileExist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String account = ServletRequestUtils.getStringParameter(request, "phone");
            if (StringUtils.isBlank(account))
            {
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_MOBILEEXIST_ISNULL, null);
            }
            if (!DataPatternUtils.checkMobilePhone(account))
            {
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_MOBILEEXIST_ERROR, null);
            }
            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andMobileEqualTo(account);
            List<UserInfo> userInfo = this.userInfoService.selectByExample(userInfoExample);
            if (CollectionUtils.isNotEmpty(userInfo))
            {
                GooagooLog.info("手机号码是否存在：手机号码已存在（" + account + "）");
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_MOBILEEXIST_EXIST, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDMOBILE_MOBILEEXIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("手机号码是否存在：验证用户是否存在异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_MOBILEEXIST_EXIST, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDMOBILE_SENDEMAIL)
    public TransData<Object> sendEmail(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String email = ServletRequestUtils.getStringParameter(request, "email");
            String mobile = ServletRequestUtils.getStringParameter(request, "mobile");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String activeCode = this.userActiveCodeCoreService.getEmailActiveCodeForBindMobile(userId, email, mobile);
            if (StringUtils.isBlank(activeCode))
            {
                GooagooLog.info("发送邮件（验证邮箱和短信验证码）：获取邮箱校验码失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_SENDEMAIL_FAIL, null);
            }
            try
            {
                if (DataPatternUtils.chechEmail(email))
                {
                    JmsUtils.send(this.emailTemplate, this.emailDestination, EmailContentUtils.userIdentityForBoundMobile(email, activeCode, mobile));
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("发送邮件（验证邮箱和短信验证码）：邮件发送异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDMOBILE_SENDEMAIL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("发送邮件（验证邮箱和短信验证码）：发送邮件失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_SENDEMAIL_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDMOBILE_EMAILAUTHENTICATION)
    public TransData<Object> emailAuthentication(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String activeCode = ServletRequestUtils.getStringParameter(request, "code");
            String mobile = ServletRequestUtils.getStringParameter(request, "m");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            if (!this.userActiveCodeQueryService.checkActiveCodeForBindMobile(userId, activeCode))
            {
                GooagooLog.info("邮箱验证身份：邮箱验证身份失败（" + activeCode + "," + mobile + "）");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_EMAILAUTHENTICATION_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDMOBILE_EMAILAUTHENTICATION_SUCCESS, mobile);
        }
        catch (Exception e)
        {
            GooagooLog.error("邮箱验证身份：邮箱验证身份异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_EMAILAUTHENTICATION_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDMOBILE_GETMESSAGECODE)
    public TransData<Object> getMessageCode(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String messageCode = null;
            String mobile = ServletRequestUtils.getStringParameter(request, "mobile");
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
                    JmsUtils.send(this.mobileTemplate, this.mobileDestination, MobileContentUtils.userBoundMobileMessage(mobile, messageCode));
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("获取短信验证码：短信验证码发送异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDMOBILE_GETMESSAGECODE_SUCCESS, messageCode);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取短信验证码：获取短信验证码异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_GETMESSAGECODE_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_BOUNDMOBILE_BOUNDMOBILE)
    public TransData<Object> boundMobile(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String mobileActiveCode = ServletRequestUtils.getStringParameter(request, "code");
            String mobile = ServletRequestUtils.getStringParameter(request, "mobile");
            String activeCode = ServletRequestUtils.getStringParameter(request, "activeCode");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String key = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            if (!this.userCoreService.updateMobile(key, userId, mobile, mobileActiveCode, activeCode))
            {
                GooagooLog.info("绑定手机号码：绑定手机号码失败");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_BOUNDMOBILE_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IBOUNDMOBILE_BOUNDMOBILE_SUCCESS, null);
        }
        catch (NoDataException e)
        {
            GooagooLog.error("绑定手机号码：短信验证码不正确", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_SENDEMAIL_MESSAGE, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("绑定手机号码：手机绑定失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IBOUNDMOBILE_BOUNDMOBILE_FAIL, null);
        }

        return transData;
    }

}

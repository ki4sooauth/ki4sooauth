package com.gooagoo.igus.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.cache.PassportConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.LogUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.log.GusClientInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 消息处理工具
 * @author GOOAGOO
 *
 */
@Aspect
@Component
public class MessageUtils
{

    @Autowired
    private JmsTemplate behaveMessageTemplate;

    @Autowired
    private ActiveMQQueue behaveMessageDestination;

    @Autowired
    private UserAccountQueryService userAccountQueryService;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private HttpServletRequest request;//请求参数

    private TransData<Object> response;//响应数据

    private GooagooMessage<BehaveLog> gooagooMessage;//消息

    private BehaveLog behaveLog;//消息日志

    @SuppressWarnings("unchecked")
    @AfterReturning(pointcut = "execution(@MessageAnnotation public * com.gooagoo.igus..*.*(..))&& (args(input))", returning = "output")
    public void doBehaveMessage(JoinPoint joinPoint, Object input, Object output)
    {
        try
        {
            //1、转换拦截到方法的入参与出参
            this.request = (HttpServletRequest) input;
            this.response = (TransData<Object>) output;
            //2、获取拦截到方法的annotation值类型
            String methodName = joinPoint.getSignature().getName();
            MessageAnnotation messageAnnotation = joinPoint.getTarget().getClass().getDeclaredMethod(methodName, HttpServletRequest.class).getAnnotation(MessageAnnotation.class);
            //3、获取登录信息
            PersonalLoginInfo personalLoginInfo = this.userAccountQueryService.queryPersonalLoginInfo(ServletRequestUtils.getStringParameter(this.request, Constants.USER_LOGIN_TOKEN), "W", Integer.valueOf(PassportConfigCache.get("userTimeOut")));
            //4、组装消息日志默认值
            this.gooagooMessage = new GooagooMessage<BehaveLog>();
            this.gooagooMessage.setUuid(UUID.getUUID());
            this.gooagooMessage.setSource("3");
            this.gooagooMessage.setBehaveCode(messageAnnotation.value());
            this.gooagooMessage.setFlag(this.response.getHead().isSuccess());
            this.behaveLog = new BehaveLog();
            this.behaveLog.setBehaveId(this.gooagooMessage.getUuid());
            this.behaveLog.setUserId(ServletRequestUtils.getStringParameter(this.request, Constants.USER_LOGIN_USERID));
            if (personalLoginInfo != null)
            {
                GusClientInfo gusClientInfo = gson.fromJson(personalLoginInfo.getClientInfoJson(), GusClientInfo.class);
                this.behaveLog.setAccount(personalLoginInfo.getPersonalInfo().getAccount());
                this.behaveLog.setIpAddress(gusClientInfo.getIpAddress());
                this.behaveLog.setScreenResolution(gusClientInfo.getScreenResolution());
                this.behaveLog.setBrowserType(gusClientInfo.getBrowserType());
                this.behaveLog.setSystemType(gusClientInfo.getSystemType());
                this.behaveLog.setLanguage(gusClientInfo.getLanguage());
            }
            this.behaveLog.setSource("3");
            this.behaveLog.setBehaveTime(new Date());
            this.behaveLog.setOperateResult(this.response.getHead().isSuccess() ? "Y" : "N");
            this.behaveLog.setRemoteCode(messageAnnotation.value());
            this.behaveLog.setDetail(LogUtils.getOperateContent(this.request, this.response));
            //5、定制化组装行为日志数据
            this.setMessage(this.request, this.response, messageAnnotation);
            this.gooagooMessage.setContent(this.behaveLog);
            GooagooLog.debug("用户消息处理工具：拦截到的方法【" + methodName + "】与对应接口【" + messageAnnotation.value() + "】，消息内容【" + gson.toJson(this.gooagooMessage) + "】");
            //6、发送消息
            JmsUtils.send(this.behaveMessageTemplate, this.behaveMessageDestination, this.gooagooMessage);
        }
        catch (Exception e)
        {
            GooagooLog.error("用户行为消息处理工具：处理用户行为消息异常", e);
        }

    }

    /**
     * 定制化组装行为日志数据
     * @param request
     * @param response
     * @param messageAnnotation
     */
    private void setMessage(HttpServletRequest request, TransData<Object> response, MessageAnnotation messageAnnotation) throws Exception
    {
        //1.1、定制化组装手机虚拟商家行为日志
        this.setMobileMerchantPlazaMessage(this.request, this.response, messageAnnotation);
    }

    /**
     * 定制化组装手机虚拟商家行为日志
     * @param request
     * @param response
     * @param messageAnnotation
     */
    private void setMobileMerchantPlazaMessage(HttpServletRequest request, TransData<Object> response, MessageAnnotation messageAnnotation) throws Exception
    {
        String[] interfaces = { InterGusConstants.MERCHANT_MOBILE_GETACTIVEDATA, InterGusConstants.MERCHANT_MOBILE_FAVORITEACTIVE, InterGusConstants.MERCHANT_MOBILE_GETCOUPONDATA, InterGusConstants.MERCHANT_MOBILE_FAVORITECOUPON, InterGusConstants.MERCHANT_MOBILE_GETGOODSDATA, InterGusConstants.MERCHANT_MOBILE_GETGOODSCOMMENTLIST, InterGusConstants.MERCHANT_MOBILE_FAVORITEGOODS, InterGusConstants.MERCHANT_MOBILE_GETINTEGRALMALLLIST, InterGusConstants.MERCHANT_MOBILE_INTEGRALCONVERT, InterGusConstants.MERCHANT_MOBILE_GETPOSITIONMARKETINGRANK, InterGusConstants.MERCHANT_MOBILE_GETCONSIGNEEINFO };
        for (int i = 0; i < interfaces.length; i++)
        {
            if (interfaces[i].equals(messageAnnotation.value()))
            {
                this.gooagooMessage.setSource("1");
                this.behaveLog.setUserId(ServletRequestUtils.getStringParameter(request, "userId"));
                this.behaveLog.setMacAddress(ServletRequestUtils.getStringParameter(request, "mac"));
                this.behaveLog.setSource("1");
            }
        }
    }

}

package com.gooagoo.igus.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.gooagoo.view.gus.web.cryout.UCryout;
import com.gooagoo.view.gus.web.cryout.UCryoutInfo;
import com.gooagoo.view.gus.web.notice.UNoticeInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 用户行为处理工具
 * @author GOOAGOO
 *
 */
@Aspect
@Component
public class BehaveUtils
{

    @Autowired
    private JmsTemplate behaveMessageTemplate;

    @Autowired
    private ActiveMQQueue behaveMessageDestination;

    @Autowired
    private UserAccountQueryService userAccountQueryService;

    private HttpServletRequest request;//请求参数

    private TransData<Object> response;//响应数据

    private List<GooagooMessage<BehaveLog>> gooagooMessageList;

    private GooagooMessage<BehaveLog> gooagooMessage;//行为消息

    private BehaveLog behaveLog;//行为日志

    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private final Type type = new TypeToken<GooagooMessage<BehaveLog>>()
    {
    }.getType();

    @SuppressWarnings("unchecked")
    @AfterReturning(pointcut = "execution(@BehaveAnnotation public * com.gooagoo.igus..*.*(..))&& (args(input))", returning = "output")
    public void doBehaveMessage(JoinPoint joinPoint, Object input, Object output)
    {
        try
        {
            //1、转换拦截到方法的入参与出参
            this.request = (HttpServletRequest) input;
            this.response = (TransData<Object>) output;
            //2、获取拦截到方法的annotation值类型
            String methodName = joinPoint.getSignature().getName();
            BehaveAnnotation behaveAnnotation = joinPoint.getTarget().getClass().getDeclaredMethod(methodName, HttpServletRequest.class).getAnnotation(BehaveAnnotation.class);
            //3、获取登录信息
            PersonalLoginInfo personalLoginInfo = this.userAccountQueryService.queryPersonalLoginInfo(ServletRequestUtils.getStringParameter(this.request, Constants.USER_LOGIN_TOKEN), "W", Integer.valueOf(PassportConfigCache.get("userTimeOut")));
            //4、组装行为日志默认值
            this.gooagooMessageList = new ArrayList<GooagooMessage<BehaveLog>>();
            this.gooagooMessage = new GooagooMessage<BehaveLog>();
            this.gooagooMessage.setUuid(UUID.getUUID());
            this.gooagooMessage.setSource("3");
            this.gooagooMessage.setBehaveCode(behaveAnnotation.value());
            this.gooagooMessage.setFlag(this.response.getHead().isSuccess());
            this.behaveLog = new BehaveLog();
            this.behaveLog.setBehaveId(this.gooagooMessage.getUuid());
            this.behaveLog.setUserId(ServletRequestUtils.getStringParameter(this.request, Constants.USER_LOGIN_USERID));
            if (personalLoginInfo != null)
            {
                GusClientInfo gusClientInfo = this.gson.fromJson(personalLoginInfo.getClientInfoJson(), GusClientInfo.class);
                this.behaveLog.setAccount(personalLoginInfo.getPersonalInfo().getAccount());
                this.behaveLog.setIpAddress(gusClientInfo.getIpAddress());
                this.behaveLog.setMacAddress(personalLoginInfo.getPersonalMobileInfo().getMacAddress());
                this.behaveLog.setScreenResolution(gusClientInfo.getScreenResolution());
                this.behaveLog.setBrowserType(gusClientInfo.getBrowserType());
                this.behaveLog.setSystemType(gusClientInfo.getSystemType());
                this.behaveLog.setLanguage(gusClientInfo.getLanguage());
            }
            this.behaveLog.setSource("3");
            this.behaveLog.setBehaveTime(new Date());
            this.behaveLog.setOperateResult(this.response.getHead().isSuccess() ? "Y" : "N");
            this.behaveLog.setRemoteCode(behaveAnnotation.value());
            this.behaveLog.setDetail(LogUtils.getOperateContent(this.request, this.response));
            //5、定制化组装行为日志数据
            this.setMessage(this.request, this.response, behaveAnnotation);
            //6、发送消息
            for (int i = 0; i < this.gooagooMessageList.size(); i++)
            {
                GooagooLog.debug("用户行为消息处理工具：拦截到的方法【" + methodName + "】与对应接口【" + behaveAnnotation.value() + "】，消息内容【" + gson.toJson(this.gooagooMessageList.get(i)) + "】");
                JmsUtils.send(this.behaveMessageTemplate, this.behaveMessageDestination, this.gooagooMessageList.get(i));
            }
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
     * @param behaveAnnotation
     */
    private void setMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        //1.1、定制化组装吆喝行为日志
        this.setCryoutMessage(this.request, this.response, behaveAnnotation);
        //1.2、定制化组装吆喝广场行为日志
        this.setCryoutPlazaMessage(this.request, this.response, behaveAnnotation);
        //1.3、定制化组装网站虚拟商家行为日志
        this.setWebMerchantPlazaMessage(this.request, this.response, behaveAnnotation);
        //1.4、定制化组装手机虚拟商家行为日志
        this.setMobileMerchantPlazaMessage(this.request, this.response, behaveAnnotation);
        //1.5、定制化组装我的商家行为日志
        this.setShopMessage(this.request, this.response, behaveAnnotation);
        //1.6、定制化组装商家通知行为日志
        this.setNoticeMessage(this.request, this.response, behaveAnnotation);
        //1.7、定制化组装收藏广场行为日志
        this.setFavoritePlazaMessage(this.request, this.response, behaveAnnotation);
        //1.8、定制化组装账单行为日志
        this.setBillMessage(this.request, this.response, behaveAnnotation);
        //1.9、定制化组装优惠凭证行为日志
        this.setCouponMessage(this.request, this.response, behaveAnnotation);
        //2.0、定制化组装积分商城行为日志
        this.setMallMessage(this.request, this.response, behaveAnnotation);
    }

    /**
     * 定制化组装吆喝行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setCryoutMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.CRYOUT_CRYOUT_ATTENTION.equals(behaveAnnotation.value()))
        {
            //1.1、吆喝：关注商家
            this.gooagooMessage.setBehaveType("3");
            this.behaveLog.setBehaveType("3");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "shopName"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUT_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.2、吆喝：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUT_FAVORITEACTIVE.equals(behaveAnnotation.value()))
        {
            //1.3、吆喝：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activityId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activityName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUT_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.4、吆喝：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUT_GETCRYOUTLIST.equals(behaveAnnotation.value()))
        {
            //1.5、吆喝：浏览吆喝
            this.gooagooMessage.setBehaveType("9");
            this.behaveLog.setBehaveType("9");
            if (this.response.getHead().isSuccess())
            {
                List<UCryout> ucryoutList = ((UCryoutInfo) this.response.getData()).getCryoutList();
                for (int i = 0; i < ucryoutList.size(); i++)
                {
                    UCryout ucryout = ucryoutList.get(i);
                    this.gooagooMessage.setUuid(UUID.getUUID());
                    this.behaveLog.setBehaveId(this.gooagooMessage.getUuid());
                    this.behaveLog.setObjectValue(ucryout.getCryoutId());
                    this.behaveLog.setObjectType("Y");
                    this.behaveLog.setShopId(ucryout.getShopId());
                    this.gooagooMessage.setContent(this.behaveLog);
                    GooagooMessage<BehaveLog> gooagooMessage = this.gson.fromJson(this.gson.toJson(this.gooagooMessage, this.type), this.type);
                    this.gooagooMessageList.add(gooagooMessage);
                }
            }
            else
            {
                this.gooagooMessageList.add(this.gooagooMessage);
            }
        }
    }

    /**
     * 定制化组装吆喝广场行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setCryoutPlazaMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.1、吆喝广场：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEACTIVE.equals(behaveAnnotation.value()))
        {
            //1.2、吆喝广场：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activityId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activityName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.3、吆喝广场：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "cryoutInfoId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.CRYOUT_CRYOUTPLAZA_GETCRYOUTLIST.equals(behaveAnnotation.value()))
        {
            //1.4、吆喝广场：浏览吆喝
            this.gooagooMessage.setBehaveType("9");
            this.behaveLog.setBehaveType("9");
            if (this.response.getHead().isSuccess())
            {
                List<UCryout> ucryoutList = ((UCryoutInfo) this.response.getData()).getCryoutList();
                for (int i = 0; i < ucryoutList.size(); i++)
                {
                    UCryout ucryout = ucryoutList.get(i);
                    this.gooagooMessage.setUuid(UUID.getUUID());
                    this.behaveLog.setBehaveId(this.gooagooMessage.getUuid());
                    this.behaveLog.setObjectValue(ucryout.getCryoutId());
                    this.behaveLog.setObjectType("Y");
                    this.behaveLog.setShopId(ucryout.getShopId());
                    this.gooagooMessage.setContent(this.behaveLog);
                    GooagooMessage<BehaveLog> gooagooMessage = this.gson.fromJson(this.gson.toJson(this.gooagooMessage, this.type), this.type);
                    this.gooagooMessageList.add(gooagooMessage);
                }
            }
            else
            {
                this.gooagooMessageList.add(this.gooagooMessage);
            }
        }
    }

    /**
     * 定制化组装网站虚拟商家行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setWebMerchantPlazaMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.MERCHANT_WEB_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.1、网站虚拟商家：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_WEB_FAVORITEACTIVE.equals(behaveAnnotation.value()))
        {
            //1.2、网站虚拟商家：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activeId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activeName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_WEB_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.3、网站虚拟商家：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_WEB_INTEGRALCONVERT.equals(behaveAnnotation.value()))
        {
            //1.4、网站虚拟商家：积分兑换
            this.gooagooMessage.setBehaveType("C");
            this.behaveLog.setBehaveType("C");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopIntegralId"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

    /**
     * 定制化组装手机虚拟商家行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setMobileMerchantPlazaMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.MERCHANT_MOBILE_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.1、手机虚拟商家：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_MOBILE_FAVORITEACTIVE.equals(behaveAnnotation.value()))
        {
            //1.2、手机虚拟商家：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activeId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activeName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_MOBILE_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.3、手机虚拟商家：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource(ServletRequestUtils.getStringParameter(request, "marketingId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.MERCHANT_MOBILE_INTEGRALCONVERT.equals(behaveAnnotation.value()))
        {
            //1.4、手机虚拟商家：积分兑换
            this.gooagooMessage.setBehaveType("C");
            this.behaveLog.setBehaveType("C");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopIntegralId"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else
        {
            return;
        }
        this.gooagooMessage.setSource("1");
        this.behaveLog.setUserId(ServletRequestUtils.getStringParameter(request, "userId"));
        this.behaveLog.setMacAddress(ServletRequestUtils.getStringParameter(request, "mac"));
        this.behaveLog.setSource("1");
    }

    /**
     * 定制化组装我的商家行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setShopMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.SHOP_PHYCARDCONVERTAPPLY.equals(behaveAnnotation.value()))
        {
            //1.1、我的商家：物理卡转换
            this.gooagooMessage.setBehaveType("5");
            this.behaveLog.setBehaveType("5");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "shopName"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.SHOP_MEMBERAPPLY.equals(behaveAnnotation.value()))
        {
            //1.2、我的商家：申请会员卡
            this.gooagooMessage.setBehaveType("4");
            this.behaveLog.setBehaveType("4");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "shopName"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.SHOP_ATTENTION.equals(behaveAnnotation.value()))
        {
            //1.3、我的商家：关注商家
            this.gooagooMessage.setBehaveType("3");
            this.behaveLog.setBehaveType("3");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "shopName"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

    /**
     * 定制化组装商家通知行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    @SuppressWarnings("unchecked")
    private void setNoticeMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.NOTICE_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.1、商家通知：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource("noticeInfoId");
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.NOTICE_FAVORITEACTIVE.equals(behaveAnnotation.value()))
        {
            //1.2、商家通知：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activityId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activityName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource("noticeInfoId");
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.NOTICE_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.3、商家通知：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.behaveLog.setObjectSource("noticeInfoId");
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.NOTICE_GETNOTICELIST.equals(behaveAnnotation.value()))
        {
            //1.4、商家通知：浏览通知
            this.gooagooMessage.setBehaveType("9");
            this.behaveLog.setBehaveType("9");
            if (this.response.getHead().isSuccess())
            {
                List<UNoticeInfo> unoticeInfoList = (List<UNoticeInfo>) this.response.getData();
                for (int i = 0; i < unoticeInfoList.size(); i++)
                {
                    UNoticeInfo unoticeInfo = unoticeInfoList.get(i);
                    this.gooagooMessage.setUuid(UUID.getUUID());
                    this.behaveLog.setBehaveId(this.gooagooMessage.getUuid());
                    this.behaveLog.setObjectValue(unoticeInfo.getNoticeId());
                    this.behaveLog.setObjectType("N");
                    this.behaveLog.setShopId(unoticeInfo.getShopId());
                    this.gooagooMessage.setContent(this.behaveLog);
                    GooagooMessage<BehaveLog> gooagooMessage = this.gson.fromJson(this.gson.toJson(this.gooagooMessage, this.type), this.type);
                    this.gooagooMessageList.add(gooagooMessage);
                }
            }
            else
            {
                this.gooagooMessageList.add(this.gooagooMessage);
            }
        }
    }

    /**
     * 定制化组装收藏广场行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setFavoritePlazaMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.1、收藏广场：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEACTIVITY.equals(behaveAnnotation.value()))
        {
            //1.2、收藏广场：收藏活动
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "activityId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "activityName"));
            this.behaveLog.setObjectType("A");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.3、收藏广场：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

    /**
     * 定制化组装账单行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setBillMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.BILL_ELECTRICBILL_FAVORITEGOODS.equals(behaveAnnotation.value()))
        {
            //1.1、账单：收藏商品
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setObjectType("G");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
        else if (InterGusConstants.BILL_ELECTRICBILL_COMMENTGOODS.equals(behaveAnnotation.value()))
        {
            //1.2、账单：评论商品
            this.gooagooMessage.setBehaveType("6");
            this.behaveLog.setBehaveType("6");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "goodsId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "goodsName"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

    /**
     * 定制化组装优惠凭证行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     */
    private void setCouponMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.COUPON_FAVORITECOUPON.equals(behaveAnnotation.value()))
        {
            //1.1、优惠凭证：收藏优惠凭证
            this.gooagooMessage.setBehaveType("8");
            this.behaveLog.setBehaveType("8");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "couponId"));
            this.behaveLog.setObjectName(ServletRequestUtils.getStringParameter(request, "couponName"));
            this.behaveLog.setObjectType("C");
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

    /**
     * 定制化组装积分商城行为日志
     * @param request
     * @param response
     * @param behaveAnnotation
     * @throws Exception 
     */
    private void setMallMessage(HttpServletRequest request, TransData<Object> response, BehaveAnnotation behaveAnnotation) throws Exception
    {
        if (InterGusConstants.MALL_MALL_INTEGRALCONVERT.equals(behaveAnnotation.value()))
        {
            //1.1、积分商城：积分兑换
            this.gooagooMessage.setBehaveType("C");
            this.behaveLog.setBehaveType("C");
            this.behaveLog.setObjectValue(ServletRequestUtils.getStringParameter(request, "shopIntegralId"));
            this.behaveLog.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            this.gooagooMessage.setContent(this.behaveLog);
            this.gooagooMessageList.add(this.gooagooMessage);
        }
    }

}

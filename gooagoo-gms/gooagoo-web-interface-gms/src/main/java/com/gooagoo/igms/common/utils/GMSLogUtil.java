package com.gooagoo.igms.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.cache.entity.InterfaceBaseInfo;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.LogUtils;
import com.gooagoo.common.utils.PubUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;

public class GMSLogUtil
{

    /**
     * GMS写日志
     * @param JmsTemplate
     * @param ActiveMQQueue
     * @param request
     * @param transData
     * @param isOk 是否成功
     * @param moduleId 操作类型，对应权限表中的权限ID
     * @param content 日志描述内容
     */
    public static void sendGMSLog(HttpServletRequest request, TransData<Object> transData)
    {
        try
        {
            String interfaceCode = transData.getHead().getTradeCode();
            //调用接口类型为批跑的不记录日志
            String interfaceType = ServletRequestUtils.getStringParameter(request, GMSConstant.INTERFACE_TYPE_REQUEST_KEY, "");
            if (GMSConstant.INTERFACE_TYPE_BATCH.equals(interfaceType))
            {
                GooagooLog.debug("过滤不需要发送消息的请求类型:GMS.INTERFACE.TYPE=" + interfaceType + ",interfaceCode=" + interfaceCode);
                return;
            }
            JmsTemplate template = SpringBeanUtils.getBean("jmsTemplate", JmsTemplate.class);
            ActiveMQQueue destination = SpringBeanUtils.getBean("destination", ActiveMQQueue.class);
            ShopLoginService shopLoginService = SpringBeanUtils.getBean("shopLoginService", ShopLoginService.class);
            ShopLoginInfo shopLoginInfo = shopLoginService.getShopLoginInfo(request);

            boolean isOk = transData.getHead().isSuccess();
            String content = LogUtils.getOperateContent(request, transData);
            String shopId = shopLoginInfo.getShopAndUserInfo().getShopId();
            String accountId = shopLoginInfo.getShopAndUserInfo().getUserId();
            if (!StringUtils.hasText(accountId))
            {
                accountId = shopId;
            }
            //获取操作对象编码
            String objectCode = transData.getOperateId();
            if (!StringUtils.hasText(objectCode))
            {
                objectCode = ServletRequestUtils.getStringParameter(request, "objectCode", "");
            }
            Object data = transData.getData();
            if (!StringUtils.hasText(objectCode) && data instanceof String)
            {
                objectCode = (String) transData.getData();
            }
            String behaveType = "";
            InterfaceBaseInfo ic = InterfaceCache.get(objectCode);
            if (ic != null)
            {
                behaveType = ic.getBehaveType();
            }
            //过滤不需要发送消息的商家行为类型
            String fiterBehaveType = GmsConfigCache.get(GMSConstant.SHOP_LOG_FILTER_BEHAVE_TYPE_KEY);
            if (behaveType != null && fiterBehaveType != null && ("," + fiterBehaveType + ",").indexOf("," + behaveType + ",") > -1)
            {
                GooagooLog.debug("过滤不需要发送消息的商家行为类型:behaveType=" + behaveType + ",fiterBehaveType=" + fiterBehaveType);
                return;
            }
            String uuid = com.gooagoo.common.utils.StringUtils.getUUID();
            ShopLog log = new ShopLog();
            log.setLogId(uuid);
            log.setObjectCode(objectCode);
            log.setOperateSource("S");
            log.setShopId(shopId);
            log.setAccountId(accountId);
            log.setRemoteCode(interfaceCode);
            log.setDetail(content);
            if (isOk)
            {
                log.setOperateResult("Y");
            }
            else
            {
                log.setOperateResult("N");
            }
            log.setOperateIp(PubUtils.getIpAddr(request));
            log.setShopBehaveType(behaveType);

            GooagooMessage<ShopLog> message = new GooagooMessage<ShopLog>();
            message.setUuid(uuid);
            message.setBehaveCode(interfaceCode);
            message.setBehaveType(behaveType);
            message.setContent(log);
            message.setFlag(isOk);
            message.setSource("7");

            JmsUtils.send(template, destination, message);
        }
        catch (Exception e)
        {
            GooagooLog.error("GMS写日志失败", e);
        }

    };

}

package com.gooagoo.gas.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.cache.entity.InterfaceBaseInfo;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.LogUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.google.gson.Gson;

public class BehaveUtil
{
    public static Map<String, String> behaveValue;//接口对应object_value存放map

    /**
     * igas写日志
     * @param JmsTemplate
     * @param ActiveMQQueue
     * @param request
     * @param transData
     * @param operateResult 是否成功
     * @param content 日志描述内容
     */
    public static void sendShopLog(HttpServletRequest request, GasTransData gasTransData)
    {
        try
        {
            String behaveCode = ServletRequestUtils.getStringParameter(request, "itype", null);//接口编号
            //入参
            @SuppressWarnings("unchecked")
            Map<String, String[]> map = request.getParameterMap();//请求
            Map<String, String> parameterMap = new HashMap<String, String>();
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext())//将请求参数封装到map中
            {
                String key = it.next();
                String[] obj = map.get(key);
                if (checkNullOrEmpty(obj))
                {
                    parameterMap.put(key.trim().toUpperCase(), obj[0].trim());
                }
            }
            //返回结果
            Map<?, ?> detailsMap = new Gson().fromJson(gasTransData.getResultJson(), Map.class);

            ShopLog shopLog = new ShopLog();
            shopLog.setLogId(UUID.getUUID());
            shopLog.setShopId(parameterMap.get("SHOPID"));
            //子帐号编号，如果来源是管理系统或者店员助理，则为具体的子帐号，如果来源是转发器，则为转发器的mac地址
            shopLog.setAccountId(parameterMap.get("SHOPUSERID"));
            shopLog.setOperateSource("A");//（T-转发器，A-店员助理）
            shopLog.setRemoteCode(behaveCode);
            InterfaceBaseInfo interfaceBaseInfo = InterfaceCache.get(behaveCode);
            String shopBehaveType = null;
            if (interfaceBaseInfo != null)
            {
                shopBehaveType = interfaceBaseInfo.getBehaveType();
            }
            shopLog.setShopBehaveType(shopBehaveType);
            shopLog.setDetail(LogUtils.getOperateContent(request, gasTransData.getResultJson()));
            if ("true".equals(detailsMap.get("result")))
            {
                shopLog.setOperateResult("Y");
            }
            if ("false".equals(detailsMap.get("result")))
            {
                shopLog.setOperateResult("N");
            }
            //设置ObjectCode值
            setObjectCode(shopLog, behaveCode, parameterMap, detailsMap, gasTransData);

            shopLog.setOperateIp(parameterMap.get("MAC"));//操作IP（S-管理系统）或mac地址（T-转发器，A-店员助理）
            shopLog.setCreateTime(new Date());
            GooagooMessage<ShopLog> message = new GooagooMessage<ShopLog>();
            message.setUuid(shopLog.getLogId());
            message.setBehaveCode(behaveCode);
            message.setBehaveType(shopBehaveType);
            message.setContent(shopLog);
            message.setFlag("true".equals(detailsMap.get("result").toString()) ? true : false);
            message.setSource("6");//操作来源，1-手机 5-转发器 6-店员助理
            GooagooLog.debug("igas(message)开始向ActiveMQQueue中发送日志：【" + new Gson().toJson(message) + "】");
            JmsTemplate template = SpringBeanUtils.getBean("gasTemplate", JmsTemplate.class);
            ActiveMQQueue destination = SpringBeanUtils.getBean("gasDestination", ActiveMQQueue.class);

            JmsUtils.send(template, destination, message);
            GooagooLog.debug("igas(message)成功向ActiveMQQueue中发送日志：【" + new Gson().toJson(message) + "】");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            GooagooLog.error("igas写日志失败", e);
        }
    }

    /**
     * 设置ObjectCode的值
     * @param behaveLog 行为日志对象
     * @param behaveCode 接口编码
     * @param parameterMap 接口入参map
     * @param outPut 接口返回报文map
     * @throws Exception 
     */
    public static void setObjectCode(ShopLog shopLog, String behaveCode, Map<String, String> parameterMap, Map<?, ?> outPut, GasTransData gasTransData) throws Exception
    {
        if (behaveValue == null)
        {
            setBehaveMap();
        }
        //获取object的来源
        String behaveValuekey = behaveValue.get(behaveCode);
        //设置objectvalue
        if (StringUtils.hasText(behaveValuekey))
        {
            shopLog.setObjectCode(parameterMap.get(behaveValuekey));
        }
        else if ("gasc05".equals(behaveCode) || "gasl03".equals(behaveCode))
        {//接口gasc05:店员帮助用户提交用户订单（零售业） \ 接口gasl03:店员帮用户提交点餐单（餐饮业）--orderid
            shopLog.setObjectCode(gasTransData.getObjectId());
        }
    }

    /**
     * 配置每个接口对应的ShopLog.setObjectCode的值(能直接从接口入参中获取的objecvalue)
     */
    public static void setBehaveMap()
    {
        behaveValue = new HashMap<String, String>();
        behaveValue.put("gasc06", "SCARDNO");//接口gasc06:用户通过店员助理刷卡
        behaveValue.put("gasl05", "ORDERID");//接口gasl05:店员帮用户提交结账申请
    }

    /**
     * 空值判断
     * $null 返回false  List size()=0 返回false  Map size()=0 返回false  Object[] 会递归判断有null或空集合返回false
     * checkNullOrEmpty
     * InterfaceUtils
     * @param Object ob
     * @param ob
     * @return boolean 非空true  空值 false
     */
    public static boolean checkNullOrEmpty(Object ob)
    {
        if (ob == null)
        {
            return false;
        }
        if (ob instanceof List)
        {
            if (((List<?>) ob).size() == 0)
            {
                return false;
            }
        }
        if (ob instanceof Map)
        {
            if (((Map<?, ?>) ob).size() == 0)
            {
                return false;
            }
        }
        else if (ob instanceof String)
        {
            if ("".equals(ob))
            {
                return false;
            }
        }
        else if (ob instanceof Object[])
        {
            if (((Object[]) ob).length == 0)
            {
                return false;

            }
            for (Object object : (Object[]) ob)
            {
                if (checkNullOrEmpty(object))
                {
                    ;
                }
                else
                {
                    return false;
                }
            }
        }

        return true;
    }
}

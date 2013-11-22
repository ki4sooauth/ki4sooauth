package com.gooagoo.mobile.common;

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

import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidDetailGeneratorQueryService;
import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.cache.entity.InterfaceBaseInfo;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.LogUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.user.MobilePushInfoBusiness;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.google.gson.Gson;

public class BehaveUtil
{
    public static Map<String, String> behaveValue;

    /**
     * imobile写日志
     * @param JmsTemplate
     * @param ActiveMQQueue
     * @param request
     * @param transData
     * @param operateResult 是否成功
     * @param content 日志描述内容
     */
    public void sendLog(HttpServletRequest request, MobileTransData mobileTransData)
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
            Map<?, ?> detailsMap = new Gson().fromJson(mobileTransData.getResultJson(), Map.class);
            BehaveLog behaveLog = new BehaveLog();

            behaveLog.setBehaveId(UUID.getUUID());//行为编号，UUID

            behaveLog.setMacAddress(parameterMap.get("MAC"));
            behaveLog.setEcAccount(parameterMap.get("ECACCOUNT"));
            behaveLog.setScardno(parameterMap.get("SCARDNO"));
            behaveLog.setSource("1");//手机

            UserCacheQueryService userCacheQueryService = (UserCacheQueryService) SpringBeanUtils.getBean("userCacheQueryServiceClient");
            //手机
            MobilePushInfoBusiness mobilePushInfo = userCacheQueryService.findUserMobileInfoByMacAddress(behaveLog.getMacAddress());
            if (mobilePushInfo != null)
            {
                behaveLog.setUserId(mobilePushInfo.getUserId());
                behaveLog.setGooagooID(mobilePushInfo.getGooagooID());
                behaveLog.setIpAddress(mobilePushInfo.getIpAddress());
                behaveLog.setHostName(mobilePushInfo.getHostName());
                behaveLog.setMobile(mobilePushInfo.getPhone());
                behaveLog.setPhoneType(mobilePushInfo.getPhoneType());
                behaveLog.setSystemType(mobilePushInfo.getSystemType());
                behaveLog.setBrowserType(mobilePushInfo.getBrowserType());
                behaveLog.setLanguage(mobilePushInfo.getLanguage());
                behaveLog.setScreenResolution(mobilePushInfo.getScreenResolution());
                behaveLog.setScreenColor(mobilePushInfo.getScreenColor());
            }

            //position长度为8时，查询商家lid信息
            ShopLidDetailGeneratorQueryService shopLidDetailGeneratorQueryService = (ShopLidDetailGeneratorQueryService) SpringBeanUtils.getBean("shopLidDetailGeneratorQueryServiceClient");
            if (behaveLog.getPositionId() != null && behaveLog.getPositionId().length() == 8)
            {
                ShopLidDetail shopLidDetail = shopLidDetailGeneratorQueryService.selectByPrimaryKey(behaveLog.getPositionId());
                behaveLog.setPositionId(shopLidDetail != null ? shopLidDetail.getPositionId() : "");
            }

            InterfaceBaseInfo interfaceBaseInfo = InterfaceCache.get(behaveCode);
            String behaveType = null;
            if (interfaceBaseInfo != null)
            {
                behaveType = interfaceBaseInfo.getBehaveType();
            }

            behaveLog.setBehaveType(behaveType);

            if ("true".equals(detailsMap.get("result")))
            {
                behaveLog.setOperateResult("Y");
            }
            if ("false".equals(detailsMap.get("result")))
            {
                behaveLog.setOperateResult("N");
            }

            //设置objectValue的值
            this.setObjectValue(behaveLog, behaveCode, parameterMap, detailsMap);

            behaveLog.setRemoteCode(behaveCode);
            behaveLog.setShopId(parameterMap.get("SHOPID"));
            behaveLog.setShopEntityId(parameterMap.get("SHOPENTITYID"));
            behaveLog.setDetail(LogUtils.getOperateContent(request, mobileTransData.getResultJson()));
            behaveLog.setBehaveTime(new Date());
            behaveLog.setCreateTime(new Date());

            GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
            message.setUuid(behaveLog.getBehaveId());
            message.setBehaveCode(behaveCode);
            message.setBehaveType(behaveType);
            message.setContent(behaveLog);
            message.setFlag("true".equals(detailsMap.get("result").toString()) ? true : false);
            message.setSource("1");//操作来源，1-手机 5-转发器 6-店员助理

            GooagooLog.debug("imobile(message)开始向ActiveMQQueue中发送日志：【" + new Gson().toJson(message) + "】");
            JmsTemplate template = SpringBeanUtils.getBean("mobileTemplate", JmsTemplate.class);
            ActiveMQQueue destination = SpringBeanUtils.getBean("mobileDestination", ActiveMQQueue.class);

            JmsUtils.send(template, destination, message);
            GooagooLog.debug("imobile(message)成功向ActiveMQQueue中发送日志：【" + new Gson().toJson(message) + "】");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            GooagooLog.error("imobile写日志失败", e);
        }
    }

    /**
     * 设置ObjectValue的值
     * @param behaveLog 行为日志对象
     * @param behaveCode 接口编码
     * @param parameterMap 接口入参map
     * @param outPut 接口返回报文map
     * @throws Exception 
     */
    private void setObjectValue(BehaveLog behaveLog, String behaveCode, Map<String, String> parameterMap, Map<?, ?> outPut) throws Exception
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
            if (behaveCode.contains("mobh"))
            {//营销触发接口
                behaveLog.setObjectValue(behaveValuekey);
            }
            else
            {
                behaveLog.setObjectValue(parameterMap.get(behaveValuekey));
            }
        }
        else if ("mobb02".equals(behaveCode))
        {//接口 mobb02 : 添加收藏
            if (StringUtils.hasText(parameterMap.get("SHOPADID")))
            {//收藏信息编号不为空
                behaveLog.setObjectValue(parameterMap.get("SHOPADID"));
            }
            else if (StringUtils.hasText(parameterMap.get("ADURL")))
            {//收藏信息url
                String favoriateStr[] = ToolsUtils.analysisFavoriteUrl(parameterMap.get("ADURL"));
                behaveLog.setObjectValue(favoriateStr[1]);
            }
        }
        else if ("mobe05".equals(behaveCode))
        {//接口 mobb09 : 用户关注商家
            behaveLog.setObjectValue(JsonUtils.json2Map(outPut.get("submitOrderForm").toString()).get("orderid"));
        }
    }

    /**
     * 配置每个接口对应的BehaveLog.behaveValue的赋值(能直接从接口入参中获取的objecvalue)
     */
    public static void setBehaveMap()
    {
        behaveValue = new HashMap<String, String>();
        behaveValue.put("moba02", "INFOID");//删除（手机接口）
        behaveValue.put("moba10", "SHOPID");//接口 moba10 : 用户申请电子会员卡
        behaveValue.put("moba11", "SHOPID");//接口 moba11 : 用户申请实体卡电子化
        behaveValue.put("mobb09", "SHOPID");//接口 mobb09 : 用户关注商家
        behaveValue.put("mobe06", "ORDERID");//接口 mobe06 : 结帐申请
        behaveValue.put("mobe09", "ITEMSERIAL");//接口 mobe09 : 通过扫码获取商品信息
        behaveValue.put("mobe11", "GOODSID");//接口 mobe11 : 用户评论商品
        behaveValue.put("mobh01", "11");//接口 mobh01 : 滑动刷卡(11)
        behaveValue.put("mobh02", "13");//接口 mobh02 : 查看菜谱(13)
        behaveValue.put("mobh03", "14");//接口 mobh03 : 查看已点菜品(15)
        behaveValue.put("mobh04", "15");//接口 mobh04 : 查看菜单(14)
        behaveValue.put("mobh05", "16");//接口 mobh05 : 申请结账(16)
        behaveValue.put("mobh06", "18");//接口 mobh06 : 扫描商品(18)
        behaveValue.put("mobh07", "19");//接口 mobh07 : 查看购物车(19)
        behaveValue.put("mobh08", "21");//接口 mobh08 : 进入购物匹配(21)
        behaveValue.put("mobh10", "23");//接口 mobh10 : 查看账单(23)
        behaveValue.put("mobh11", "24");//接口 mobh11 : 申请开发票(24)
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

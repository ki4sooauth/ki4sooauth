package com.gooagoo.icms.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.TimeUtils;
import com.gooaoo.view.common.MZTreeNode;

public class CMSUtil
{

    public static void initZTreeClick(String type, List<MZTreeNode> trees)
    {
        if (type == null)
        {
            type = "";
        }
        for (MZTreeNode tree : trees)
        {
            tree.setClick("selectNode('" + type + "','" + tree.getId() + "','" + tree.getName() + "');");
        }
    }

    /**
     * 将新对象中不为null的字段值更新到原对象-只支持一层属性的更新
     * @param oldObj原对象
     * @param newObj新对象
     * @return 
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object freshObject(Object oldObj, Object newObj) throws IllegalArgumentException, IllegalAccessException
    {
        if (oldObj != null && newObj != null)
        {
            Field[] fields = newObj.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                field.setAccessible(true);
                Object value = field.get(newObj);
                if (value != null && !Modifier.isFinal(field.getModifiers()))
                {
                    field.set(oldObj, value);
                }
            }
        }
        return newObj;
    }

    /**
     * 创建TransData对象
     * @param success 是否成功
     * @param resultCode  默认错误编码（例如删除操作没有抛异常，但返回结果为false时所需要制定的错误编码）
     * @param data
     * @return
     * @throws Exception
     */
    public static <T> TransData<T> toTransData(Boolean success, String resultCode, T data) throws Exception
    {
        return new TransData<T>(success, resultCode, data);
    }

    /**
     * 创建TransData对象
     * @param success 是否成功
     * @param resultCode  默认错误编码（例如删除操作没有抛异常，但返回结果为false时所需要制定的错误编码）
     * @param data
     * @param operateId 操作对象ID
     * @return
     * @throws Exception
     */
    public static <T> TransData<T> toTransData(Boolean success, String resultCode, T data, String operateId) throws Exception
    {
        return new TransData<T>(success, resultCode, data, operateId);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<Object>(result, rc, null);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC, String operateId)
    {
        return getBooleanAndExtendResult(result, successRC, failRC, null, operateId);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @param data 交易内容信息
     * @param operateId 操作对象ID
     * @return
     */
    public static <T> TransData<T> getBooleanAndExtendResult(Boolean result, String successRC, String failRC, T data, String operateId)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<T>(result, rc, data, operateId);
    }

    /**
     * 获取登录者的所属商家，实体店信息
     * @param id
     * @param userType
     * @return map key"userId":放用户id,key"shopId":商家Id,key"entityId":所属实体店id
     * @throws Exception 
    
    public static Map<String, String> getLogInfo(HttpServletRequest request) throws Exception
    {

        String shopId = ServletRequestUtils.getStringParameter(request, Constants.CAS_FILTER_SHOP, "");
        String shopType = ServletRequestUtils.getStringParameter(request, Constants.CAS_FILTER_SHOPT, "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        Map<String, String> map = new HashMap<String, String>();
        if (MisConstant.USERTYPE.equals(shopType))
        {
            QueryShopUserInfoService query = (QueryShopUserInfoService) SpringBeanUtils.getBean("queryShopUserInfoServiceClient");
            //ShopUserInfoGeneratorQueryService query = (ShopUserInfoGeneratorQueryService) SpringBeanUtils.getBean("queryShopUserInfoServiceClient");
            
            FShopUserInfo userInfo = query.getShopUserInfo(shopId);
            map.put(MisConstant.USERID, userInfo.getUserId());
            map.put(MisConstant.SHOPID, userInfo.getShopId());
            map.put(MisConstant.ENTITYID, userInfo.getShopEntityId());
        }
        else if (MisConstant.SHOPTYPE.equals(shopType))
        {
            map.put(MisConstant.USERID, "");
            map.put(MisConstant.SHOPID, shopId);
            map.put(MisConstant.ENTITYID, shopEntityId);
        }
        return map;
    }
    */
    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") != -1)
        {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip.trim();
    };

    /**
     * 将时间设置凌晨0时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getEarlyMorning(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 00:00:00";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }

    /**
     * 将时间设置成晚上24时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getMidNight(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 23:59:59";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }
}

package com.gooagoo.mis.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.view.general.GAjax;
import com.gooagoo.view.mis.dictionaryManage.MSysDictionary;
import com.google.gson.Gson;

/**
 * 后台管理系统工具类
 * @author Administrator
 *
 */
public class MisUtils
{

    /**
     * action中ajax调用方法（返回布尔类型公用调用）
     * @param interfaceCode
     * @param request
     * @param response
     * @throws Exception
     */
    public static void ajaxSubmit(String interfaceCode, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> respObj = HttpUtilsMis.transferMis(interfaceCode, request, Object.class);

        String resultCode = respObj.getHead().getResultCode();
        String resultName = (String) ExceptionCache.get(resultCode);
        GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);

        String result = new Gson().toJson(rv);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * action中ajax调用方法（返回查询数据）
     * @param interfaceCode
     * @param request
     * @param response
     * @throws Exception
     */
    public static void ajaxSubmitData(String interfaceCode, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> respObj = HttpUtilsMis.transferMis(interfaceCode, request, Object.class);

        Object obj = respObj.getData();
        String result = new Gson().toJson(obj);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 将数据转换为指定实体类对象
     * @param excelInfo 需要转换的数据（只支持一次转换）
     * @param obj 返回的实体类对象
     * @return
     * @throws Exception
     */
    public static Object converObject(Map<String, String> excelInfo, Object obj) throws Exception
    {
        if (excelInfo.size() > 0)
        {
            Class<? extends Object> objClass = obj.getClass();
            for (Map.Entry<String, String> m : excelInfo.entrySet())
            {
                String name = m.getKey();
                if (!("sheetNum".equals(name) || "rowNum".equals(name)))
                {
                    try
                    {
                        Field field = objClass.getDeclaredField(name);
                        field.setAccessible(true);
                        Class<? extends Object> classType = field.getType();
                        String type = classType.getCanonicalName();
                        try
                        {
                            if (StringUtils.hasText(m.getValue()) && ("java.util.Date".equals(type) || "Date".equals(type)))
                            {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date date = sdf.parse(m.getValue());
                                field.set(obj, date);
                            }
                            else if (StringUtils.hasText(m.getValue()) && ("java.lang.Integer".equals(type) || "Integer".equals(type)))
                            {
                                if (StringUtils.hasText(m.getValue()))
                                {
                                    Integer inte = Integer.parseInt(m.getValue());
                                    field.set(obj, inte);
                                }
                            }
                            else if ("java.lang.Double".equals(type) || "Double".equals(type))
                            {
                                if (StringUtils.hasText(m.getValue()))
                                {
                                    Double inte = Double.parseDouble(m.getValue());
                                    field.set(obj, inte);
                                }
                                else
                                {
                                    field.set(obj, "0.00");
                                }
                            }
                            else if (StringUtils.hasText(m.getValue()))
                            {
                                field.set(obj, m.getValue());
                            }
                            field.setAccessible(true);
                        }
                        catch (Exception e)
                        {
                            throw new GooagooException("转换" + type + "类型错误");
                        }
                    }
                    catch (Exception e)
                    {
                        throw new GooagooException(name + "在实体类中不存在");
                    }
                }
            }
        }
        return obj;
    }

    /**
     * 查询通用字典表信息
     * 1.支持多个字典类型查询
     * 2.查询结果为List并且存放在对应字典类型中
     * @param dictionaryType 通用字典英文名称
     * @param request
     * @param response
     */
    @SuppressWarnings("rawtypes")
    public static void queryData(String[] dictionaryType, HttpServletRequest request, HttpServletResponse response)
    {
        for (int i = 0; i < dictionaryType.length; i++)
        {
            request.setAttribute("dictionaryType", dictionaryType[i]);
            TransData<List> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALL_NOTPAGE, request, List.class);
            request.setAttribute(dictionaryType[i], resObj.getData());
        }
    }

    /**
     * 查询通用字典表信息
     * 1.支持多个字典类型查询
     * 2.支持多个条件进行查询
     * 3.查询结果为List并且存放在对应字典类型中
     * 4.每个字典类型都对应同一个条件进行查询
     * @param dictionaryType 通用字典英文名称
     * @param condition 查询条件（若查询条件为english_name，则该值可以支持多个逗号分隔的字符串）
     * @param obj
     * @param request
     * @param response
     */
    @SuppressWarnings("rawtypes")
    public static void queryDataCondition(String[] dictionaryType, MSysDictionary condition, Object obj, HttpServletRequest request, HttpServletResponse response)
    {
        for (int i = 0; i < dictionaryType.length; i++)
        {
            request.setAttribute("dictionaryType", dictionaryType[i]);
            if (condition != null)
            {
                Class<?> objClass = condition.getClass();
                Field[] fields = objClass.getDeclaredFields();
                try
                {
                    for (int j = 0; j < fields.length; j++)
                    {
                        String name = fields[j].getName();
                        if (!"serialVersionUID".equals(name))
                        {
                            Field f = objClass.getDeclaredField(name);
                            f.setAccessible(true);
                            Object value = f.get(condition);
                            if (value != null && !"".equals(value))
                            {
                                request.setAttribute(name, value.toString());
                            }
                            f.setAccessible(false);
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            TransData<List> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALL_NOTPAGE, request, List.class);
            request.setAttribute(dictionaryType[i], resObj.getData());
        }
    }

    /**
     * Ajax方式查询通用字典表信息
     * 1.支持多个字典类型查询
     * @param dictionaryType 通用字典英文名称
     * @param request
     * @param response
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
    public static void queryDataAjax(String[] dictionaryType, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, List> mapList = new HashMap<String, List>();
        for (int i = 0; i < dictionaryType.length; i++)
        {
            List typeList = new ArrayList();
            if (StringUtils.hasText(dictionaryType[i]))
            {
                request.setAttribute("dictionaryType", dictionaryType[i]);
                TransData<List> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALL_NOTPAGE, request, List.class);
                typeList = (List) resObj.getData();
            }
            mapList.put(dictionaryType[i], typeList);
        }
        String result = new Gson().toJson(mapList);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * Ajax方式查询通用字典表信息
     * 1.支持多个字典类型查询
     * 2.支持多个条件进行查询
     * 3.查询结果为List并且存放在对应字典类型中
     * 4.每个字典类型都对应同一个条件进行查询
     * @param dictionaryType 通用字典英文名称
     * @param condition 查询条件（若查询条件为english_name，则该值可以支持多个逗号分隔的字符串）
     * @param obj
     * @param request
     * @param response
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void queryDataAjaxCondition(String[] dictionaryType, MSysDictionary condition, Object obj, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, List> mapList = new HashMap<String, List>();
        for (int i = 0; i < dictionaryType.length; i++)
        {
            List typeList = new ArrayList();
            if (StringUtils.hasText(dictionaryType[i]))
            {
                request.setAttribute("dictionaryType", dictionaryType[i]);
                if (condition != null)
                {
                    Class<?> objClass = condition.getClass();
                    Field[] fields = objClass.getDeclaredFields();
                    try
                    {
                        for (int j = 0; j < fields.length; j++)
                        {
                            String name = fields[j].getName();
                            if (!"serialVersionUID".equals(name))
                            {
                                Field f = objClass.getDeclaredField(name);
                                f.setAccessible(true);
                                Object value = f.get(condition);
                                if (value != null && !"".equals(value))
                                {
                                    request.setAttribute(name, value.toString());
                                }
                                f.setAccessible(false);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                TransData<List> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALL_NOTPAGE, request, List.class);
                typeList = (List) resObj.getData();
            }
            mapList.put(dictionaryType[i], typeList);
        }
        String result = new Gson().toJson(mapList);
        ServletUtils.writeHtml(result, response);
    }
}

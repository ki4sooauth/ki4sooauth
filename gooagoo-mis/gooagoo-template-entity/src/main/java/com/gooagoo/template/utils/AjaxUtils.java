package com.gooagoo.template.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.casclient.log.CasLog;
import com.gooagoo.casclient.utils.HttpFilterUtils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.shop.ShopAndUserInfo;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.template.entity.GAjax;
import com.google.gson.Gson;

public class AjaxUtils
{
    /**
     * AJAX跨域访问向页面返回数据
     * @param result
     * @param request
     * @param response
     * @throws IOException
     */

    public static void doService(String result, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
        out.println(jsonpCallback + "(" + result + ")");//返回jsonp格式数据  
        out.flush();
        out.close();
    }

    /**
     * http客户端请求
     * @param code 接口编码
     * @param request
     * @param dataClass T->class
     * @throws IOException
     */
    public static <T> TransData<T> httpClientRequest(String code, HttpServletRequest request, Class<T> dataClass)
    {
        return AJAXHttpUtils.transfer(code, request, dataClass);
    }

    /**
     * action中ajax调用方法（返回布尔类型公用调用）
     * @param interfaceCode
     * @param request
     * @param response
     * @throws Exception
     */
    public static void ajaxSubmit(String interfaceCode, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> respObj = httpClientRequest(interfaceCode, request, Object.class);

        String resultCode = respObj.getHead().getResultCode();
        String resultName = ExceptionCache.get(resultCode);
        if (!StringUtils.hasText(resultName))
        {
            GooagooLog.info("获取提示信息名称为空，resultName=" + resultName + ",resultCode=" + resultCode);
            resultName = resultCode;
        }
        GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);

        Object data = respObj.getData();
        if (data instanceof String)
        {
            rv.setExtend((String) data);
        }
        String result = new Gson().toJson(rv);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 获取当前登录用户所属系统及用户ID（shop：商家，mis：后台，personal：个人，longinInfo[0]：登录用户，longinInfo[1]：登录用户ID）
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static String[] queryLoginUserType(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String[] longinInfo = new String[] { "", "" };
        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            String cookieName = cookie.getName();
            //商家
            if ("com.gooagoo.passpart.sso.token.name.shop".equals(cookieName))
            {
                token = cookie.getValue();
                longinInfo[0] = "shop";
                break;
            }
            //mis后台
            else if ("com.gooagoo.passpart.sso.token.name.mis".equals(cookieName))
            {
                token = cookie.getValue();
                longinInfo[0] = "mis";
                break;
            }
            //个人
            else if ("com.gooagoo.passpart.sso.token.name.personal".equals(cookieName))
            {
                longinInfo[0] = "personal";
                break;
            }
        }
        if (!org.apache.commons.lang.StringUtils.isBlank(token))
        {
            if ("shop".equals(longinInfo[0]))
            {
                Object obj = HttpFilterUtils.transferObj("http://ipassport.goo.com/iLoginInfo/getShopLoginInfo", token);
                if (obj != null)
                {
                    longinInfo[1] = ((ShopLoginInfo) obj).getShopAndUserInfo().getShopId();
                }
                else
                {
                    CasLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
                }
            }
            else if ("mis".equals(longinInfo[0]))
            {
                Object obj = HttpFilterUtils.transferObj("http://ipassport.goo.com/iLoginInfo/getMisLoginInfo", token);
                if (obj != null)
                {
                    longinInfo[1] = ((MisLoginInfo) obj).getLoginId();
                }
                else
                {
                    CasLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
                }
            }
            else if ("personal".equals(longinInfo[0]))
            {
                Object obj = HttpFilterUtils.transferObj("http://ipassport.goo.com/iLoginInfo/getPersonalLoginInfo", token);
                if (obj != null)
                {
                    longinInfo[1] = ((PersonalLoginInfo) obj).getPersonalInfo().getUserId();
                }
                else
                {
                    CasLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
                }
            }
        }
        return longinInfo;
    }
    
    /**
     * 获取当前登录用户为商家时的商家对象
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static ShopAndUserInfo queryLoginUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            String cookieName = cookie.getName();
            if ("com.gooagoo.passpart.sso.token.name.shop".equals(cookieName))
            {
                token = cookie.getValue();
                break;
            }
        }
        if (org.apache.commons.lang.StringUtils.isBlank(token))
        {
            return null;
        }
        Object obj = HttpFilterUtils.transferObj("http://ipassport.goo.com/iLoginInfo/getShopLoginInfo", token);
        if (obj != null)
        {
            return ((ShopLoginInfo) obj).getShopAndUserInfo();
        }
        else
        {
            CasLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
        }
        return null;
    }
}

package com.gooagoo.mis.util;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.casclient.log.CasLog;
import com.gooagoo.casclient.utils.HttpFilterUtils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.shop.ShopAndUserInfo;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.template.constants.InterTplConstants;
import com.gooagoo.template.entity.FTemplateInfo;
import com.gooagoo.template.utils.AjaxUtils;

/**
 * 模版系统-web-emplate项目工具类
 * @author Administrator
 *
 */
public class TemplateUtils
{
    /**
     * 生成页面form表单
     * @param info 模版信息（修改页面需要传值，新增页面不需要）
     * @return
     */
    public static void initForm(FTemplateInfo info, HttpServletRequest request)
    {
        String templateType = ServletRequestUtils.getStringParameter(request, "template_type", "");
        String cont = "<div class=\"control-group\">" + "<label class=\"control-label\">模板名称:</label>" + "<div class=\"controls\">";
        if (info != null && !"".equals(info))
        {
            cont += "<input type=\"text\" id=\"templateName\" name=\"templateName\" value=\"" + info.getTemplateName() + "\">" + "<input type=\"hidden\" id=\"templateId\" name=\"templateId\" value=\"" + info.getTemplateId() + "\">";
        }
        else
        {
            cont += "<input type=\"text\" id=\"templateName\" name=\"templateName\">";
        }
        cont += "<input type=\"hidden\" id=\"templateType\" name=\"templateType\" value=\"" + templateType + "\"></div></div><div class=\"control-group\">" + "<label class=\"control-label\">模板费用:</label>" + "<div class=\"controls\">";
        if (info != null && !"".equals(info))
        {
            cont += "<input type=\"text\" id=\"price\" name=\"price\" value=\"" + info.getPrice() + "\">";
        }
        else
        {
            cont += "<input type=\"text\" id=\"price\" name=\"price\">";
        }
        cont += "</div></div><div class=\"control-group\">" + "<label class=\"control-label\">渠道:</label>" + "<div class=\"controls\">" + "<select name=\"channelCode\" id=\"channelCode\">" + "<option value=\"\">--请选择--</option>";
        if ("M".equals(templateType))
        {
            if (info != null && !"".equals(info))
            {
                if ("Q".equals(info.getChannelCode()))
                {
                    cont += "<option value=\"Q\" selected=\"selected\">购好奇</option>";
                }
                else
                {
                    cont += "<option value=\"Q\">购好奇</option>";
                }
                if ("M".equals(info.getChannelCode()))
                {
                    cont += "<option value=\"M\" selected=\"selected\">手机服务</option>";
                }
                else
                {
                    cont += "<option value=\"M\">手机服务</option>";
                }
                if ("S".equals(info.getChannelCode()))
                {
                    cont += "<option value=\"S\" selected=\"selected\">内容模板</option>";
                }
                else
                {
                    cont += "<option value=\"S\">内容模板</option>";
                }
            }
            else
            {
                cont += "<option value=\"Q\">购好奇</option>" + "<option value=\"M\">手机服务</option>" + "<option value=\"S\">内容模板</option>";
            }
        }
        else if ("W".equals(templateType))
        {
            if (info != null && !"".equals(info))
            {
                if ("E".equals(info.getChannelCode()))
                {
                    cont += "<option value=\"E\" selected=\"selected\">邮件</option>";
                }
                else
                {
                    cont += "<option value=\"E\">邮件</option>";
                }
                if ("S".equals(info.getChannelCode()))
                {
                    cont += "<option value=\"S\" selected=\"selected\">内容模板</option>";
                }
                else
                {
                    cont += "<option value=\"S\">内容模板</option>";
                }
            }
            else
            {
                cont += "<option value=\"E\">邮件</option>" + "<option value=\"S\">内容模板</option>";
            }
        }
        //        request.setAttribute("dictionaryType", "channel_code");
        //        TransData<List> resObj = AjaxUtils.httpClientRequest(InterTplConstants.I_GET_TEMPLATE_SYSDICTINFO, request, List.class);
        //        List<MSysDictionary> sysList = resObj.getData();
        //        if (sysList != null && sysList.size() > 0)
        //        {
        //            if (info != null && "".equals(info))
        //            {
        //                for (MSysDictionary sys : sysList)
        //                {
        //                    if (info.getChannelCode().equals(sys.getEnglishName()))
        //                    {
        //                        cont += "<option value=\"" + sys.getEnglishName() + "\" selected=\"selected\">" + sys.getChineseName() + "</option>";
        //                    }
        //                    else
        //                    {
        //                        cont += "<option value=\"" + sys.getEnglishName() + "\">" + sys.getChineseName() + "</option>";
        //                    }
        //                }
        //            }
        //            else
        //            {
        //                for (MSysDictionary sys : sysList)
        //                {
        //                    cont += "<option value=\"" + sys.getEnglishName() + "\">" + sys.getChineseName() + "</option>";
        //                }
        //            }
        //        }
        //        else
        //        {
        //            cont += "<option value=\"E\">邮件</option>" + "<option value=\"Q\">购好奇</option>" + "<option value=\"M\">手机服务</option>" + "<option value=\"G\">商品</option>" + "<option value=\"A\">营销活动</option>" + "<option value=\"C\">优惠凭证</option>" + "<option value=\"S\">内容模板</option>";
        //        }
        cont += "</select></div></div>" + "<div class=\"control-group\">" + "<label class=\"control-label\">授权方式:</label>" + "<div class=\"controls\">" + "<select name=\"authorization\" id=\"authorization\">" + "<option value=\"\">--请选择--</option>";
        if (info != null && !"".equals(info))
        {
            if ("R".equals(info.getAuthorization()))
            {
                cont += "<option value=\"R\" selected=\"selected\">仅限使用</option>";
            }
            else
            {
                cont += "<option value=\"R\">仅限使用</option>";
            }
            if ("W".equals(info.getAuthorization()))
            {
                cont += "<option value=\"W\" selected=\"selected\">可修改</option>";
            }
            else
            {
                cont += "<option value=\"W\">可修改</option>";
            }
        }
        else
        {
            cont += "<option value=\"R\">仅限使用</option>" + "<option value=\"W\">可修改</option>";
        }
        cont += "</select></div></div>" + "<div class=\"control-group\">" + "<label class=\"control-label\">模板描述:</label>" + "<div class=\"controls\">";
        if (info != null && !"".equals(info))
        {
            cont += "<textarea rows=\"\" cols=\"\" name=\"templateDescription\">" + info.getTemplateDescription() + "</textarea>";
        }
        else
        {
            cont += "<textarea rows=\"\" cols=\"\" name=\"templateDescription\"></textarea>";
        }
        cont += "</div></div>";
        request.setAttribute("cont", cont);

    }

    /**
     * 查询通用字典表信息
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static HttpServletRequest queryData(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("dictionaryType", "channel_code");
        TransData<List> resObj1 = AjaxUtils.httpClientRequest(InterTplConstants.I_GET_TEMPLATE_SYSDICTINFO, request, List.class);
        request.setAttribute("channel_code", resObj1.getData());

        request.setAttribute("dictionaryType", "info_source");
        TransData<List> resObj2 = AjaxUtils.httpClientRequest(InterTplConstants.I_GET_TEMPLATE_SYSDICTINFO, request, List.class);
        request.setAttribute("template_type", resObj2.getData());
        return request;
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

    /**
     * 判断当前登录用户权限
     * @param request
     * @param response
     */
    @SuppressWarnings("unchecked")
    public static void queryLoginAuths(HttpServletRequest request, HttpServletResponse response)
    {
        boolean isType = true;
        boolean isAuth = false;
        if ("P".equals(request.getAttribute("loginType")))
        {
            isType = false;
        }
        else
        {
            List<ShopAuth> shop_login_auths = (List<ShopAuth>) request.getAttribute("shop_login_auths");
            if (shop_login_auths != null && shop_login_auths.size() > 0)
            {
                isAuth = true;
            }
        }
        request.setAttribute("isType", isType);
        request.setAttribute("isAuth", isAuth);
    }
}

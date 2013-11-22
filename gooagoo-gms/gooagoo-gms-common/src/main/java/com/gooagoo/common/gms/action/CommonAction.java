package com.gooagoo.common.gms.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSAuthUtil;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/common")
public class CommonAction extends BaseAction
{

    /**
     * 获取二维码
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException 
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(params = "method=getTwoCode")
    public void getTwoCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, UnsupportedEncodingException
    {
        String content = ServletRequestUtils.getStringParameter(request, "content");
        String size = ServletRequestUtils.getStringParameter(request, "size", "5");

        GMSUtil.forwardTwoCode(response, content, size);
    }

    /**
     * 获取二维码(二维码内容为对象在手机端的访问地址)
     * @param request
     *  type[A-活动，E-事件，C-优惠凭证，G-商品]
     *  id 对象id
     * @param response
     * @return
     * @throws Exception 
     * @throws ServletRequestBindingException 
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(params = "method=getTwoCodeById")
    public void getTwoCodeById(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String id = ServletRequestUtils.getStringParameter(request, "id");
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");
        String size = ServletRequestUtils.getStringParameter(request, "size", "5");

        String content = GMSServiceUtil.getVisitUrl(type, id, marketingId);

        GMSUtil.forwardTwoCode(response, content, size);
    }

    /**
     * 获取二维码(二维码内容为对象在手机端的访问地址),跳转到页面
     * @param request
     *  type[A-活动，E-事件，C-优惠凭证，G-商品]
     *  id 对象id
     * @param response
     * @return
     * @throws Exception 
     * @throws ServletRequestBindingException 
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(params = "method=getTwoCodeByIdToPage")
    public String getTwoCodeByIdToPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String id = ServletRequestUtils.getStringParameter(request, "id");
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");

        String content = GMSServiceUtil.getVisitUrl(type, id, marketingId);

        request.setAttribute("content", content);

        return "/twocode/index";
    }

    /**
     * 获取商家下行为列表
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=getShopActionList")
    public void getShopActionList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Map> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_BEHAVE_LIST, request, Map.class);
        Map<String, String> behaveMap = respObj.getData();
        String result = new Gson().toJson(behaveMap);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 跳转到用户权限的第一个子节点权限菜单（web应用）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=toFirstChild")
    public String toFirstChild(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String defaultUrl = GMSServiceUtil.getDefaultDirectUrlByNoAuth();
        if (StringUtils.hasText(defaultUrl))
        {
            defaultUrl = "redirect:" + defaultUrl;
        }
        else
        {
            defaultUrl = null;
        }

        String code = ServletRequestUtils.getStringParameter(request, "AC", "");
        ShopLoginInfo shopLoginInfo = GMSUtil.getShopLoginInfoByWeb(request);

        String url = GMSAuthUtil.getFirstUserAuthUrlByParentCode(code, shopLoginInfo);
        if (!org.springframework.util.StringUtils.hasText(url))
        {
            return defaultUrl;
        }
        return "redirect:" + url;
    }
}

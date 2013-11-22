package com.gooagoo.mis.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.ConstantsMis;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.mis.util.RedisUtilMis;
import com.gooagoo.view.general.GAjax;
import com.gooagoo.view.mis.common.MMisLoginInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/login")
public class LoginAction extends BaseAction
{

    /**
     * 头部页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=head")
    public String head(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "-1");
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        return "/head";
    }

    /**
     * 底部页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=foot")
    public String foot(HttpServletRequest request, HttpServletResponse response)
    {
        return "/foot";
    }

    /**
     * 欢迎页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=welcome")
    public String welcome(HttpServletRequest request, HttpServletResponse response)
    {
        return "/welcome";
    }

    /**
     * 左侧面板页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=leftPanel")
    public String leftPanel(HttpServletRequest request, HttpServletResponse response)
    {
        return "/leftPanel";
    }

    /**
     * 主页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showmain")
    public String showmain(HttpServletRequest request, HttpServletResponse response)
    {
        return "/main";
    }

    /**
     * 登录验证
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=checkLogin")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GAjax gAjax = new GAjax(false);
        try
        {
            String code = ServletRequestUtils.getStringParameter(request, "randimg", UUID.getUUID());
            String sessionCode = RedisUtilMis.getVerifyCode(request);
            if (code.equalsIgnoreCase(sessionCode))
            {
                TransData<MMisLoginInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSUSER_LOGIN, request, MMisLoginInfo.class);
                if (respObj.getHead().isSuccess())
                {
                    RedisUtilMis.setMisLoginInfo(respObj.getData(), response);
                    gAjax.setSuccess(true);
                }
                else
                {
                    String errMessage = ExceptionCache.get(respObj.getHead().getResultCode());
                    gAjax.setMessage(errMessage);
                }
            }
            else
            {
                RedisUtilMis.delVerifyCode(request, response);
                String errMessage = ExceptionCache.get(MisMessageConst.MIS_LOGINL_VERIFY_CODE_ERROR);
                gAjax.setMessage(errMessage);
            }
        }
        catch (Exception e)
        {
            String errMessage = ExceptionCache.get(MisMessageConst.SYS_TRY_AGAIN);
            gAjax.setMessage(errMessage);
        }

        String result = new Gson().toJson(gAjax);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 登录成功首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=loginSuccess")
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response)
    {
        return "/index";
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=exitLogin")
    public String exitLogin(HttpServletRequest request, HttpServletResponse response)
    {
        RedisUtilMis.delMisLoginInfo(request, response);
        return "/login/login";
    }

    /**
     * 修改密码页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showModifyPwd")
    public String showModifyPwd(HttpServletRequest request, HttpServletResponse response)
    {
        return "/login/updatePassword";
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @throws Exception 
     */
    @SuppressWarnings("unused")
    @RequestMapping(params = "method=modifyPwd")
    public void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisLoginInfo info = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute("mis_login_id", info.getLoginId());
        TransData<String> respObj1 = HttpUtilsMis.transferMis(MisInterConstants.MIS_USER_LOGIN_INFO, request, String.class);
        if (!respObj1.getHead().isSuccess())
        {
            String errMessage = ExceptionCache.get(respObj1.getHead().getResultCode());
        }
        request.setAttribute("mis_login_auths", request.getAttribute(ConstantsMis.MIS_LOGIN_ID));
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SYSUSER_MODIFYPWD, request, response);
    }

}

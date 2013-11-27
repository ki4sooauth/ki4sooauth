package com.gooagoo.authzserver.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;

@Controller
@RequestMapping("/authorize")
public class AuthzserverAction extends BaseAction
{

    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = " method = ologin")
    public String requestCode(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        /* try
         {

             *//**
               * 1.校验参数
               * 2.页面授权
               * 3.保存授权信息
               * 4.
               */
        /*

        //dynamically recognize an OAuth profile based on request characteristic (params,
        // method, content type etc.), perform validation
        OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);

        //                        validateRedirectionURI(oauthRequest)

        //build OAuth response
        UUIDValueGenerator vg = new UUIDValueGenerator();
        OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(vg);
        OAuthResponse resp = OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND).setCode(oauthIssuerImpl.authorizationCode()).location("").buildQueryMessage();

        response.sendRedirect(resp.getLocationUri());

        //if something goes wrong
        }
        catch (OAuthProblemException ex)
        {
        final OAuthResponse resp = OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND).error(ex).location("").buildQueryMessage();

        response.sendRedirect(resp.getLocationUri());
        }
        */
        return "ologin";
    }

    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "login";
    }

    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=qlogin")
    public String responseCode(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "qlogin";

    }
}

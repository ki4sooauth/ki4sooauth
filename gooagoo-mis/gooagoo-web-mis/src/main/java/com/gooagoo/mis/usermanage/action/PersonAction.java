package com.gooagoo.mis.usermanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;

@Controller
@RequestMapping("/person")
public class PersonAction extends BaseAction
{

    /**
     * 主页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showmain")
    public String showmain(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/main";
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
        request.setAttribute("parentId", "3");//菜单权限
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        return "/usermanage/leftPanel";
    }

    /**
     * 展示个人用户首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "30101");//菜单权限

        return "/usermanage/person/search/index";
    }

    /**
     * 展示用户基本信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showPersonDetail")
    public String showPersonDetail(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/person/detail/basicInfo";
    }

    /**
     * 展示用户留言页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showMessage")
    public String showMessage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/person/detail/message";
    }

    /**
     * 展示用户评论页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showArgument")
    public String showArgument(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/person/detail/argument";
    }

    /**
     * 冻结用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=freezeUser")
    public void freezeUser(HttpServletRequest request, HttpServletResponse response)
    {

    }

    /**
     * 解冻用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=unFreezeUser")
    public void unFreezeUser(HttpServletRequest request, HttpServletResponse response)
    {

    }

}

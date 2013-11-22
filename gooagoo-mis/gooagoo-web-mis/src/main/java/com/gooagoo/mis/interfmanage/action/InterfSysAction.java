package com.gooagoo.mis.interfmanage.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;

@Controller
@RequestMapping("/interfsys")
public class InterfSysAction extends BaseAction
{

    /**
     * 接口展示首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "40102");//菜单权限

        return "/interfmanage/sys/index";
    }

    /**
     * 显示添加页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showCreate")
    public String showCreate(HttpServletRequest request, HttpServletResponse response)
    {
        return "/interfmanage/sys/add";
    }

    /**
     * 新增接口信息
     * @param request
     * @param response
     * @throws IOException 
     */
    @RequestMapping(params = "method=addInterface")
    public void addInterface(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

    }

    /**
     * 编辑接口信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=editInterface")
    public void editInterface(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

    }

    /**
     * 显示编辑页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showUpdate")
    public String showUpdate(HttpServletRequest request, HttpServletResponse response)
    {
        return "/interfmanage/sys/update";
    }

    /**
     * 删除接口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=delInterface")
    public void delInterface(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

    }

}

package com.gooagoo.mis.rsrcmanage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.mis.channelManage.MChannel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.google.gson.Gson;

@Controller
@RequestMapping("/channel")
public class ChannelAction extends BaseAction
{

    /**
     * 添加渠道页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showAddChannel")
    public String showAddChannel(HttpServletRequest request, HttpServletResponse response)
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//渠道Id
        request.setAttribute("channelCode", channelCode);
        return "/rsrcmanage/channel/create/add";
    }

    /**
     * 编辑渠道页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showEditChannel")
    public String showEditChannel(HttpServletRequest request, HttpServletResponse response)
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//渠道Id
        request.setAttribute("channelCode", channelCode);
        String channelName = ServletRequestUtils.getStringParameter(request, "channelName", "");//渠道Id
        request.setAttribute("channelName", channelName);
        return "/rsrcmanage/channel/update/edit";
    }

    /**
     * 渠道排序页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showSortChannel")
    public String showSortChannel(HttpServletRequest request, HttpServletResponse response)
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//渠道Id
        request.setAttribute("channelCode", channelCode);
        return "/rsrcmanage/channel/sort/sort";
    }

    /**
     * 添加渠道
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveChannel")
    public void saveChannel(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "2020101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_CHANNEL_ADD, request, response);
    }

    /**
     * 编辑渠道
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateChannel")
    public void updateChannel(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "2020102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_CHANNEL_UPD, request, response);
    }

    /**
     * 删除渠道
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delChannel")
    public void delChannel(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        //request.setAttribute("moduleId", "302010701");//权限Id
        //request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_CHANNEL_DEL, request, response);
    }

    /**
     * 保存重新排序的渠道
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=sortChannel")
    public void sortChannel(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "2020103");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_CHANNEL_SORT, request, response);
    }

    /**
     * 查询渠道首页
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showChannelList")
    public String showChannelList(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_CHANNEL_SEARCHALL_TOP, request, List.class);
        List<MChannel> mChannelList = respObj.getData();

        request.setAttribute("mChannelList", mChannelList);

        request.setAttribute("parentId2", "20201");//菜单权限
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        return "/rsrcmanage/channel/search/index";
    }

    /**
     * 渠道列表信息
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchchannelList")
    public void searchchannelList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //记录日志
        request.setAttribute("parentId2", "20201");//菜单权限
        request.setAttribute("moduleId", "20201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_CHANNEL_SEARCHALL, request, List.class);
        List<MZTreeNode> nodes = respObj.getData();
        ServletUtils.writeHtml(new Gson().toJson(nodes), response);
        //return "/rsrcmanage/channel/search/content";
    }
}

package com.gooagoo.gmap.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;

/**
 * 
 * svg文件信息
 *
 */
@Controller
@RequestMapping("svg")
public class SvgAction extends BaseAction
{
    /**
     * 新建svg文件页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addSvg")
    public String addSvg(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String shopEntityId = request.getParameter("shopEntityId");
        String mapId = request.getParameter("mapId");

        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("mapId", mapId);

        return "/svg/addSvg";
    }

    /**
     * 新建地图操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addSvgDo")
    public void addSvgDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.uploadFile(request);
        GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SVG_MAP_SAVE_SVG, request, Boolean.class);
        response.sendRedirect("map.do?method=index");
    }

    /**
     * 修改svg文件页面
     * @param request
     * @return
     */
    @RequestMapping(params = "method=updateSvg")
    public String updateSvg(HttpServletRequest request, HttpServletResponse response)
    {

        String mapId = request.getParameter("mapId");
        String shopEntityId = request.getParameter("shopEntityId");

        request.setAttribute("mapId", mapId);
        request.setAttribute("shopEntityId", shopEntityId);

        return "svg/updateSvg";
    }

    /**
     * 修改svg文件操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateSvgDo")
    public void updateSvgDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.uploadFile(request);
        GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SVG_MAP_UPDATE_SVG_FILE, request, Object.class);

        response.sendRedirect("map.do?method=index");
    }

    private void uploadFile(HttpServletRequest request) throws IOException
    {

        String str = "";
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("svgFile");
        str = new String(file.getBytes());

        request.setAttribute("svgStr", str);
    }
}

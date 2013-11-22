package com.gooagoo.gmap.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.map.FAreaMapInfo;
import com.google.gson.Gson;

/**
 * 区域地图
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/map")
public class AreaMapAction
{
    /**
     * 区域地图首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "/map/map_index";
    }

    /**
     * 区域地图列表信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_AREAMAP_PAGE, request, PageModel.class);

        PageModel<FAreaMapInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
            GooagooLog.debug("区域地图信息列表:" + new Gson().toJson(pm));
        }
        return "/map/map_list";
    }

    /**
     * 添加页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=formA")
    public String formA(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "/map/map_edit";
    }

    /**
     * 添加区域地图
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取svg的xml代码
        this.uploadFile(request);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_AREAMAP_ADD, request, response);
    }

    /**
     * 修改页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=formU")
    public String formU(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FAreaMapInfo> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_AREAMAP_DETAIL, request, FAreaMapInfo.class);
        FAreaMapInfo areaMapInfo = respObj.getData();

        request.setAttribute("areaMapInfo", areaMapInfo);
        return "/map/map_edit";
    }

    /**
     * 修改区域地图
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String urlSvg = request.getParameter("urlSvg_page");
        if (!StringUtils.hasText(urlSvg))
        {
            GMSUtil.ajaxResult(false, MessageConst.GMS_OPERATE_FAIL, response);
        }
        else
        {
            request.setAttribute("filePath", urlSvg);

            List<CommonsMultipartFile> commonsMultipartFileList = GMSHttpUtils.getCommonsMultipartFileList(request);
            if (commonsMultipartFileList != null && commonsMultipartFileList.size() > 0)
            {
                this.uploadFile(request);
                request.setAttribute("isReUploadFile", "Y");
            }
            else
            {
                request.setAttribute("urlSvg", urlSvg);
            }

            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_AREAMAP_UPDATE, request, response);
        }
    }

    /**
     * 删除区域地图
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_AREAMAP_DELETE, request, response);
    }

    private void uploadFile(HttpServletRequest request) throws IOException
    {
        request.setAttribute("module", "map");
        String uploadFilePath = UploadConfigCache.getFileUploadUrl();

        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }
        String pathUrl = HttpUploadUtils.uploadByFile(uploadFilePath, request);
        request.setAttribute("urlSvg", pathUrl);
    }

    /**
     * 显示地图
     * @param request
     * @param response
     * @return
     * @throws DocumentException 
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException
    {
        // svg文件内容
        TransData<Object> result = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_AREAMAP_DETAIL, request, Object.class);
        FAreaMapInfo mapInfo = (FAreaMapInfo) result.getData();
        String svg = "";
        if (mapInfo != null)
        {
            String svgUrl = mapInfo.getUrlSvg();
            svg = HttpClientUtils.loadFileStringByUrl(svgUrl);
        }
        request.setAttribute("svg", svg);

        // 提示层信息 
        //        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_SVG_SHOP_INFO_LAYER, request, List.class);
        //        List<SvgAreaTip> layers = respObj.getData();
        String str = "";
        //        if (layers != null)
        //        {
        //            str = GmapUtil.getDivContent(layers);
        //        }
        request.setAttribute("divContent", str);

        return "test";
    }

}

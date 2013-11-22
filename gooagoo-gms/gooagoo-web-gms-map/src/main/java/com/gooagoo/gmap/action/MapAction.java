package com.gooagoo.gmap.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.map.FAreaInfo;
import com.gooagoo.view.gms.map.FAreaMapInfo;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.google.gson.Gson;

/**
 * 地图信息
 * 
 */
@Controller
@RequestMapping("/map_old")
public class MapAction extends BaseAction
{
    /**
     * 主页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> svgInfoData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_SHOP_SVG_INFO, request, List.class);
        List<FAreaMapInfo> shopSvgInfo = svgInfoData.getData();
        request.setAttribute("maps", shopSvgInfo);

        return "index";
    }

    /**
     * 新建地图页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addMap")
    public String addMap(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        return "/map/addMap";
    }

    /**
     * 新建地图页面操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addMapDo")
    public void addMapDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_ADD_MAP, request, response);
    }

    /**
     * 删除地图
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=delMap")
    public void delMap(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_DEL_MAP, request, response);
    }

    /**
     * 修改地图信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateMap")
    public String updateMap(HttpServletRequest request, HttpServletResponse response)
    {
        // 实体店数据
        TransData<FShopEntityInfo> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_ENTITY_INFO, request, FShopEntityInfo.class);
        FShopEntityInfo shopEntityInfo = transData.getData();
        String shopEntityId = request.getParameter("shopEntityId");
        request.setAttribute("shopEntityId", shopEntityId);
        if (shopEntityInfo != null)
        {
            request.setAttribute("shopEntityName", shopEntityInfo.getShopEntityName());
        }

        // 地图数据
        TransData<Object> result = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_MAP, request, Object.class);
        FAreaMapInfo mapInfo = (FAreaMapInfo) result.getData();
        request.setAttribute("svgInfo", mapInfo);

        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");
        request.setAttribute("mapId", mapId);

        return "map/updateMap";
    }

    /**
     * 修改地图信息操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateMapDo")
    public void updateMapDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_UPDATE_MAP, request, response);
    }

    /**
     * 发布地图
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=release")
    public void release(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("release", "true");
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_UPDATE_MAP, request, response);
    }

    /**
     * 验证所有的区域是否都关联上位置
     * @param request
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=checkAreaIsRelation")
    public void checkAreaIsRelation(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> data = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SVG_MAP_GET_SVG_AREAS, request, List.class);
        List<FAreaInfo> areaInfos = data.getData();
        List<String> ids = new ArrayList<String>();
        for (FAreaInfo a : areaInfos)
        {
            if (a.getPositionId() == null)
            {
                ids.add(a.getSvgTagId());
            }
        }
        Gson gson = new Gson();
        String content = gson.toJson(ids);
        ServletUtils.writeHtml(content, response);
    }

    /**
     * 初始地图信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=initMap")
    public void initMap(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_INIT_GRIPINFO, request, response);
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
        TransData<Object> result = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_SHOP_SVG_INFO, request, Object.class);
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

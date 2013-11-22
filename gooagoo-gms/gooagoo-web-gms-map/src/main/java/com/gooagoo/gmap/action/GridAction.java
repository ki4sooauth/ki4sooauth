package com.gooagoo.gmap.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.GmapUtil;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gmap.utils.GridUtil;
import com.gooagoo.view.gms.map.FAreaMapInfo;

/**
 * 地图信息
 * 
 */
@Controller
@RequestMapping("/grid")
public class GridAction extends BaseAction
{
    /**
     * 网格首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");
        // 地图数据
        TransData<Object> result = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_AREAMAP_DETAIL, request, Object.class);
        FAreaMapInfo mapInfo = (FAreaMapInfo) result.getData();
        //        FAreaMapInfo mapInfo = new FAreaMapInfo();
        //        mapInfo.setMapRealHeight(1000);
        //        mapInfo.setMapRealWidth(800);
        //        mapInfo.setRatioGrid(10.0);
        //        mapInfo.setUrlSvg("http://html.gooagoo.com/gms/gmap/html/test.svg");
        //        mapInfo.setMapId("1");

        int xGridNum = GmapUtil.getGridNum(mapInfo.getMapRealWidth(), mapInfo.getRatioGrid());
        int yGridNum = GmapUtil.getGridNum(mapInfo.getMapRealHeight(), mapInfo.getRatioGrid());
        int gridUnitPix = GmapUtil.getGridUnitPix();
        int gridWidth = GmapUtil.getGridValue(mapInfo.getMapRealWidth(), mapInfo.getRatioGrid(), gridUnitPix);
        int gridHeight = GmapUtil.getGridValue(mapInfo.getMapRealHeight(), mapInfo.getRatioGrid(), gridUnitPix);
        String positionId = mapInfo.getPositionId();
        String shopEntityId = mapInfo.getShopEntityId();
        String svgContent = HttpClientUtils.loadFileStringByUrl(mapInfo.getUrlSvg());

        String gridInfo = "[]";
        if (StringUtils.hasText(mapInfo.getGridInfo()))
        {
            gridInfo = HttpClientUtils.loadFileStringByUrl(mapInfo.getGridInfo());
            gridInfo = gridInfo.trim();
        }
        if (!StringUtils.hasText(gridInfo))
        {
            gridInfo = "[]";
        }

        request.setAttribute("gridInfo", gridInfo);
        request.setAttribute("gridWidth", gridWidth);
        request.setAttribute("gridHeight", gridHeight);
        request.setAttribute("gridUnit", gridUnitPix);
        request.setAttribute("svgContent", svgContent);
        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("positionId", positionId);
        request.setAttribute("mapId", mapId);
        request.setAttribute("filePath", mapInfo.getGridInfo());
        request.setAttribute("xGridNum", xGridNum);
        request.setAttribute("yGridNum", yGridNum);
        return "grid/index";
    }

    /**
     * 网格属性编辑页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=formGrid")
    public String formGrid(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");

        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("positionId", positionId);

        return "grid/grid_form";
    }

    /**
     * 保存网格信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        try
        {
            GridUtil.initGridData(request);
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_INIT_GRIPINFO, request, response);
        }
        catch (MessageException e)
        {
            GMSUtil.ajaxResult(false, e.getMessage(), response);
        }
        catch (Exception e)
        {
            GMSUtil.ajaxResult(false, MessageConst.GMS_OPERATE_FAIL, response);
        }
    }

}

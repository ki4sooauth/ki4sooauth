package com.gooagoo.gmap.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.view.gms.map.FAreaInfo;
import com.gooagoo.view.gms.map.FAreaMapInfo;
import com.google.gson.Gson;

/**
 * 
 * 地图区域和商家信息的关联
 *
 */
@Controller
@RequestMapping("rela")
public class RelaAction extends BaseAction
{
    /**
     * 修改地图区域和商家信息的关联关系 页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        // 获取svg文件
        TransData<Object> result = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_MAP, request, Object.class);
        FAreaMapInfo mapInfo = (FAreaMapInfo) result.getData();
        if (mapInfo != null)
        {
            String svgUrl = mapInfo.getUrlSvg();
            String svgStr = HttpClientUtils.loadFileStringByUrl(svgUrl);
            request.setAttribute("svg", svgStr);
            request.setAttribute("mapId", mapInfo.getMapId());
        }
        // 获取区域信息
        TransData<List> result2 = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SVG_MAP_GET_SVG_AREAS, request, List.class);
        List<FAreaInfo> list = result2.getData();

        String content = new Gson().toJson(list);

        request.setAttribute("list", content);

        return "/rela/relaMap";
    }

    /**
     * 修改地图区域和商家信息的关联关系  操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateDo")
    public void updateDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // areaId, positionId  传入参数
        // 修改area info 表
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SVG_MAP_UPDATE_AREAINFO, request, response);
    }
}

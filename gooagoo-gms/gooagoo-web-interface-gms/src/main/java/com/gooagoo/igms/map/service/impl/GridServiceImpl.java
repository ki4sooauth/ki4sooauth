package com.gooagoo.igms.map.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.map.MapCoreService;
import com.gooagoo.api.business.query.shop.map.MapQueryService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.GmapUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.exception.MessageException;
import com.gooagoo.igms.map.service.GridService;
import com.google.gson.Gson;

@Service("gridService")
public class GridServiceImpl implements GridService
{
    @Autowired
    private MapCoreService mapCoreService;
    @Autowired
    private MapQueryService mapQueryService;
    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;

    @Override
    public TransData<Object> initGridInfo(HttpServletRequest request) throws Exception
    {
        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");
        String gridUrl = ServletRequestUtils.getStringParameter(request, "gridUrl", "");

        AreaPara ap = new AreaPara();
        ap.setMapId(mapId);
        ap.setGridInfo(gridUrl);

        boolean result = this.mapCoreService.updateMap(ap);

        if (!result)
        {
            GooagooLog.warn("更新地图中的网格信息失败，mapId=" + mapId + ",gridUrl=" + gridUrl);
            return GMSUtil.getBooleanResult(false, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        }

        AreaPara areaPara = this.areaParaGeneratorQueryService.selectByPrimaryKey(mapId);
        int xGridNum = GmapUtil.getGridNum(areaPara.getMapRealWidth(), areaPara.getRatioGrid());

        Map<String, List<String>> positionMap = this.getPositionMap(request);
        List<String> outsideGridList = this.getOutsideGridList(request);

        this.mapCoreService.addMapCache(mapId, xGridNum, positionMap, outsideGridList);

        return GMSUtil.getBooleanResult(true, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Map<String, String>> getGridInfo(HttpServletRequest request) throws Exception
    {
        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");

        Map<String, String> map = this.mapQueryService.findPositionFromMap(mapId);

        return new TransData<Map<String, String>>(true, MessageConst.GMS_OPERATE_SUCCESS, map);
    }

    /**
     * 获取位置（区域）关联网格数据
     * @param request
     * @return
     * @throws Exception
     */
    private Map<String, List<String>> getPositionMap(HttpServletRequest request) throws Exception
    {
        Map<String, List<String>> positionMap = new HashMap<String, List<String>>();
        String position = request.getParameter("grid_position");
        String gridErrInfo = "网格数据不正确";
        if (!StringUtils.hasText(position))
        {
            throw new MessageException(gridErrInfo);
        }

        Map<String, String> pMap = new Gson().fromJson(position, Map.class);
        for (Iterator<String> iterator = pMap.keySet().iterator(); iterator.hasNext();)
        {
            String k = iterator.next();
            String v = pMap.get(k);
            String[] gridArr = v.split(",");
            List<String> l = Arrays.asList(gridArr);
            positionMap.put(k, l);
        }

        return positionMap;
    }

    /**
     * 获取室外的位置（区域）编号
     * @param request
     * @return
     * @throws Exception
     */
    private List<String> getOutsideGridList(HttpServletRequest request) throws Exception
    {
        List<String> outsideGridList = null;
        String outdoor = request.getParameter("grid_outdoor");
        if (!StringUtils.hasText(outdoor))
        {
            return new ArrayList<String>();
        }
        outsideGridList = new Gson().fromJson(outdoor, List.class);

        return outsideGridList;
    }
}

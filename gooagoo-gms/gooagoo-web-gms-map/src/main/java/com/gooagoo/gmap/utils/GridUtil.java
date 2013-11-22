package com.gooagoo.gmap.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GmapUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.google.gson.Gson;

public class GridUtil
{
    /**
     * 初始化网格数据
     * @param request
     * @throws Exception
     */
    public static void initGridData(HttpServletRequest request) throws Exception
    {
        String[] grids = request.getParameterValues("grid_info");
        int xGridNum = ServletRequestUtils.getIntParameter(request, "xGridNum", 0);
        int yGridNum = ServletRequestUtils.getIntParameter(request, "yGridNum", 0);
        int gridCount = xGridNum * yGridNum;
        if (gridCount == 0 || grids == null || grids.length == 0)
        {
            GooagooLog.warn("网格数据不正确,gridInfo=" + grids == null ? "null" : new Gson().toJson(grids) + ",xGridNum=" + xGridNum + ",yGridNum=" + yGridNum);
            throw new MessageException(MessageConst.GMS_OPERATE_FAIL);
        }

        int[] gridFlag = new int[gridCount];
        Map<String, String> gridPositionMap = new HashMap<String, String>();
        List<String> outdoorList = new ArrayList<String>();
        int gridUnitPix = GmapUtil.getGridUnitPix();
        for (int i = 0; i < grids.length; i++)
        {
            String grid = grids[i];
            String[] gridInfo = grid.split("_");//x1_y1_x2_y2_positionId_gridProperty_positionName
            if (gridInfo.length != 7)
            {
                GooagooLog.warn("网格数据不正确,grid=" + grid + "gridInfo=" + new Gson().toJson(grids));
                throw new MessageException(MessageConst.GMS_OPERATE_FAIL);
            }
            initGridPositionValue(gridPositionMap, gridFlag, Integer.parseInt(gridInfo[0]), Integer.parseInt(gridInfo[1]), Integer.parseInt(gridInfo[2]), Integer.parseInt(gridInfo[3]), xGridNum, gridUnitPix, gridInfo[4]);
            if ("0".equals(gridInfo[5]))
            {
                initGridOutdoorValue(outdoorList, Integer.parseInt(gridInfo[0]), Integer.parseInt(gridInfo[1]), Integer.parseInt(gridInfo[2]), Integer.parseInt(gridInfo[3]), xGridNum, gridUnitPix);
            }
        }

        int index = getNullGridIndex(request, gridFlag);
        if (index != -1)
        {
            GooagooLog.warn("网格数据不全,缺失网格编号=" + index + "gridInfo=" + new Gson().toJson(grids));
            throw new MessageException(MessageConst.GMS_GRID_DATA_NOT_ENOUGH);
        }

        String gridUrl = getGridAreaContentUrl(request);
        request.setAttribute("gridUrl", gridUrl);

        request.setAttribute("grid_position", new Gson().toJson(gridPositionMap));
        request.setAttribute("grid_outdoor", new Gson().toJson(outdoorList));
    }

    /**
     * 将网格原始数据写入文件上传到服务器
     * @param request
     * @return
     * @throws MessageException
     */
    private static String getGridAreaContentUrl(HttpServletRequest request) throws MessageException
    {
        String fileName = ServletRequestUtils.getStringParameter(request, "mapId", null);
        String filePath = ServletRequestUtils.getStringParameter(request, "filePath", "");
        String[] grids = request.getParameterValues("grid_info");
        if (grids == null || grids.length == 0 || !StringUtils.hasText(fileName))
        {
            return "";
        }
        fileName += ".html";

        String content = new Gson().toJson(grids);

        String url = GMSHttpUtils.uploadFileByString("map", filePath, content, fileName);

        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("上传地图网格信息失败：mapId=" + fileName);
            throw new MessageException(MessageConst.GMS_OPERATE_FAIL);
        }
        return url;
    }

    /**
     * 初始化网格的位置信息
     * @param gridPositions
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param xGridNum
     * @param positionId
     * @throws MessageException
     */
    private static void initGridPositionValue(Map<String, String> gridPositionMap, int[] gridFlag, int x1, int y1, int x2, int y2, int xGridNum, int gridUnitPix, String positionId) throws MessageException
    {
        int xg1 = x1 / gridUnitPix;
        int xg2 = x2 / gridUnitPix;
        int yg1 = y1 / gridUnitPix;
        int yg2 = y2 / gridUnitPix;

        for (int i = yg1; i < yg2; i++)
        {
            for (int j = xg1; j < xg2; j++)
            {
                int gridId = GmapUtil.getGridId(j, i, xGridNum);
                if (gridId >= gridFlag.length)
                {
                    GooagooLog.warn("网格坐标越界，gridId=" + gridId + ",area=(" + x1 + "" + y1 + "" + x2 + "" + y2 + "),positionId=" + positionId + "，gridLength=" + gridFlag.length);
                    throw new MessageException(MessageConst.GMS_OPERATE_FAIL);
                }
                int v = gridFlag[gridId];
                if (v == 1)
                {
                    GooagooLog.warn("重叠网格，gridId=" + gridId + ",area=(" + x1 + "" + y1 + "" + x2 + "" + y2 + "),positionId=" + positionId);
                    throw new MessageException(MessageConst.GMS_GRID_DATA_OVERLAY);
                }
                gridFlag[gridId] = 1;
                String pGrid = gridPositionMap.get(positionId);
                if (StringUtils.hasText(pGrid))
                {
                    pGrid += "," + gridId;
                }
                else
                {
                    pGrid = "" + gridId;
                }
                gridPositionMap.put(positionId, pGrid);
            }
        }
    }

    /**
     * 初始化室外网格信息
     * @param outdoorList
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param xGridNum
     * @throws MessageException
     */
    private static void initGridOutdoorValue(List<String> outdoorList, int x1, int y1, int x2, int y2, int xGridNum, int gridUnitPix) throws MessageException
    {
        int xg1 = x1 / gridUnitPix;
        int xg2 = x2 / gridUnitPix;
        int yg1 = y1 / gridUnitPix;
        int yg2 = y2 / gridUnitPix;

        for (int i = yg1; i < yg2; i++)
        {
            for (int j = xg1; j < xg2; j++)
            {
                int gridId = GmapUtil.getGridId(j, i, xGridNum);
                outdoorList.add(gridId + "");
            }
        }
    }

    /**
     * 将网格位置信息放入request中
     * @param request
     * @param gridPositions
     * @return
     */
    private static int getNullGridIndex(HttpServletRequest request, int[] gridFlag)
    {
        int index = -1;
        for (int i = 0; i < gridFlag.length; i++)
        {
            if (gridFlag[i] != 1)
            {
                return i;
            }
        }
        return index;
    }

}

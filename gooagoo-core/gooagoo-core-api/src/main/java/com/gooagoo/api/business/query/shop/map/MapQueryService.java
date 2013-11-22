package com.gooagoo.api.business.query.shop.map;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.shop.map.SvgAreaTip;

public interface MapQueryService
{

    /**
     * 添加或更新 网格坐标信息 缓存数据
     * @param gridMap 网格坐标信息 map
     * @return Ture/False
     * @throws Exception
     */
    public boolean addOrUpdateGridCoordinateInfoCacheData(Map<String, Map<String, String>> gridMap) throws Exception;

    /**
     * 通过地图编码查询地图区域上的提示信息列表
     * @param mapId
     * @return
     * @throws Exception
     */
    public List<SvgAreaTip> findMapAreaTips(String mapId) throws Exception;

    /**
     * 通过位置id查询网格
     * @param positionId
     * @return
     * @throws Exception
     */
    public List<String> findGridFromPosition(String positionId) throws Exception;

    /**
     * 通过mapId查询位置
     * @param mapId
     * @return
     * @throws Exception
     */
    public Map<String, String> findPositionFromMap(String mapId) throws Exception;

}

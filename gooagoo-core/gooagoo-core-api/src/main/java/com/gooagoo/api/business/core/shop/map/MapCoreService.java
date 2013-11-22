package com.gooagoo.api.business.core.shop.map;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.user.AreaParaDetail;
import com.gooagoo.entity.generator.shop.AreaPara;

/**
 * 地图管理
 */
public interface MapCoreService
{

    /**
     * 添加地图网格信息（缓存）
     * @param mapId 地图编号
     * @param xGridNum 地图真实宽度/网格坐标系比例
     * @param positionMap Map<位置编号, List<网格>>
     * @param outsideGridList List<网格>
     * @throws Exception
     */
    public void addMapCache(String mapId, int xGridNum, Map<String, List<String>> positionMap, List<String> outsideGridList) throws Exception;

    /****
     * 添加地图信息
     * @param areaPara
     * @return true/false
     * @throws Exception
     */

    public boolean addMap(AreaPara areaPara) throws Exception;

    /*****
     * 添加地图详细信息
     * @param areaParaDetail
     * @return true/false
     * @throws Exception
     */
    public boolean addMapDetail(AreaParaDetail areaParaDetail) throws Exception;

    /******
     * 编辑地图信息
     * @param areaPara
     * @return true/false
     * @throws Exception
     */
    public boolean updateMap(AreaPara areaPara) throws Exception;

    /*****
     * 编辑地图详细信息
     * @param areaParaDetail
     * @return true/false
     * @throws Exception
     */
    public boolean updateMapDetail(AreaParaDetail areaParaDetail) throws Exception;

    /****
     * 删除地图信息
     * @param mapId
     * @return true/false
     * @throws Exception
     */
    public boolean deleteMap(String mapId) throws Exception;

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

package com.gooagoo.api.business.query.shop.map;

import java.util.List;

import com.gooagoo.entity.business.shop.map.MapactivitylistBusiness;
import com.gooagoo.entity.business.shop.map.MappositionlistBusiness;
import com.gooagoo.entity.business.shop.map.NavigationlistBusiness;
import com.gooagoo.entity.business.shop.map.ShopListlistsBusiness;

public interface GpsNavigationService
{
    /**
     * 接口MOBI01:全局活动
     * 查询当前地图范围内全部商家活动。
     * @param mapId 地图编号
     * @return
     * @throws Exception
     */
    public List<MapactivitylistBusiness> getGlobalShopActityInfoOfMap(String mapId) throws Exception;

    /**
     * 接口MOBI02:位置查询（根据“关键字”查询当前商场内商家或商品位置）
     * @param shopEntityId 实体店编号
     * @param keyWord 查询关键字,可能是商家名称，也有可能是商品名称
     * @return
     * @throws Exception
     */
    public List<MappositionlistBusiness> getShopOrGoodsPositionOfMap(String shopEntityId, String keyWord) throws Exception;

    /**
     * 接口MOBI03:导航（起点{X,Y}，终点{X,Y}）
     * 获取起到到终点坐标的导航信息
     * @param sMapId 起点mapid
     * @param spx 起点x坐标
     * @param spy 起点y坐标
     * @param eMapId 终点mapid
     * @param epx 终点x坐标
     * @param epy 终点y坐标
     * @return
     * @throws Exception
     */
    public List<NavigationlistBusiness> getNavigationOfStartToEnd(String smapId, Double beginPx, Double beginPy, String emapId, Double endPx, Double endPy) throws Exception;

    /**
     * 接口MOBI04:导航（起点{X,Y}，实体店编号或商品编号）
     * 获取起点坐标到实体店或某商品位置的地图导航信息
     * @param sMapId 起点mapid
     * @param spx 起点x坐标
     * @param spy 起点y坐标
     * @param eMapId 终点mapid
     * @param objId 实体店编号或商品编号
     * @param type 类型,S-商家，G-商品
     * @return
     * @throws Exception
     */
    public List<NavigationlistBusiness> getNavigationOfMap(String smapId, Double beginPx, Double beginPy, String emapId, String objid, String type) throws Exception;

    /**
     * 接口MOBI05：获取地图内商家列表
     * @param mapId 地图编号
     * @return
     * @throws Exception
     */
    public List<ShopListlistsBusiness> getShopListInfoInMap(String mapId) throws Exception;
}

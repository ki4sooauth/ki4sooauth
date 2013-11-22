package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobi01.transform.MapActivityRoot;
import com.gooagoo.mobile.entity.mobi02.transform.MapPositionRoot;
import com.gooagoo.mobile.entity.mobi03.transform.NavigationARoot;
import com.gooagoo.mobile.entity.mobi04.transform.NavigationBRoot;
import com.gooagoo.mobile.entity.mobi05.transform.ShopListRoot;

/**
 * 手机地图定位导航相关接口
 */
public interface GpsNavigationMobileService
{
    /**
     * 接口MOBI01:全局活动
     * 查询当前地图范围内全部商家活动。
     * @param mapId 地图编号
     * @return
     * @throws Exception
     */
    public MapActivityRoot getGlobalShopActityInfoOfMap(String mapId) throws Exception;

    /**
     * 接口MOBI02:位置查询（根据“关键字”查询当前商场内商家或商品位置）
     * @param shopEntityId 实体店编号
     * @param keyWord 查询关键字,可能是商家名称，也有可能是商品名称
     * @return
     * @throws Exception
     */
    public MapPositionRoot getShopOrGoodsPositionOfMap(String shopEntityId, String keyWord) throws Exception;

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
    public NavigationARoot getNavigationOfStartToEnd(String sMapId, Double spx, Double spy, String eMapId, Double epx, Double epy) throws Exception;

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
    public NavigationBRoot getNavigationOfMap(String sMapId, Double spx, Double spy, String eMapId, String objId, String type) throws Exception;

    /**
     * 接口MOBI05：获取地图内商家列表
     * @param mapId 地图编号
     * @return
     * @throws Exception
     */
    public ShopListRoot getShopListInfoInMap(String mapId) throws Exception;
}

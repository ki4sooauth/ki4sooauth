package com.gooagoo.query.business.shop.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.gooagoo.api.business.query.shop.cache.ShopEntityCacheQueryService;
import com.gooagoo.api.business.query.shop.map.GpsNavigationService;
import com.gooagoo.api.business.query.shop.map.MapQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.SectionLineInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.utils.MapCoordinatesUtils;
import com.gooagoo.common.utils.SvgMapUtils;
import com.gooagoo.entity.business.shop.map.Line;
import com.gooagoo.entity.business.shop.map.MapactivitylistBusiness;
import com.gooagoo.entity.business.shop.map.MappositionlistBusiness;
import com.gooagoo.entity.business.shop.map.NavigationlistBusiness;
import com.gooagoo.entity.business.shop.map.Point;
import com.gooagoo.entity.business.shop.map.ShopListlistsBusiness;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;

@Service
public class GpsNavigationServiceImpl implements GpsNavigationService
{

    @Autowired
    private SectionLineInfoGeneratorQueryService sectionLineInfoGeneratorQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private MapQueryService mapQueryService;
    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;
    @Autowired
    private ShopEntityCacheQueryService shopEntityCacheQueryService;

    @Override
    public List<MapactivitylistBusiness> getGlobalShopActityInfoOfMap(String mapId) throws Exception
    {
        List<MapactivitylistBusiness> reList = new ArrayList<MapactivitylistBusiness>();

        //        //1.查询区域信息
        //        AreaInfoExample example = new AreaInfoExample();
        //        Criteria criteria = example.createCriteria();
        //        criteria.andMapIdEqualTo(mapId);
        //        criteria.andIsDelEqualTo("N");
        //        List<AreaInfo> areaInfos = this.areaInfoGeneratorQueryService.selectByExample(example);
        //        for (AreaInfo e : areaInfos)
        //        {
        //            // 区域关联商家,区域不是最大区域
        //            if (e.getPositionId() != null && !e.getSvgTagId().equals("main"))
        //            {
        //                //2.根据区域编号，查询区域位置信息
        //                ShopPosition position = this.shopPositionGeneratorQueryService.selectByPrimaryKey(e.getPositionId());
        //                if (position == null)
        //                {
        //                    continue;
        //                }
        //
        //                //3.根据区域位置信息获取商家编号，然后通过商家编号查询商家活动信息
        //                // 同一个商家，取第一个活动信息
        //                MarketingActivityExample exam = new MarketingActivityExample();
        //                com.gooagoo.entity.generator.marketing.MarketingActivityExample.Criteria cri = exam.createCriteria();
        //                cri.andShopIdEqualTo(position.getShopId());
        //                cri.andIsDelEqualTo("N");
        //                List<MarketingActivity> activities = this.marketingActivityGeneratorQueryService.selectByExample(exam);
        //
        //                if (activities.size() > 0)
        //                {
        //                    MarketingActivity ac = activities.get(0);
        //
        //                    MapactivitylistBusiness activity = new MapactivitylistBusiness();
        //                    activity.setPx(String.valueOf(e.getPx()));
        //                    activity.setPy(String.valueOf(e.getPy()));
        //                    activity.setName(ac.getActivityName());
        //                    activity.setUrl(UrlUtils.getActiveUrl(ac.getActivityId()));
        //
        //                    reList.add(activity);
        //                }
        //            }
        //        }
        //
        //        // TODO 零时处理，多活动时，只展示一个
        //        MapactivitylistBusiness list = null;
        //        for (MapactivitylistBusiness e : reList)
        //        {
        //            if (e.getPy().equals("442.0"))
        //            {
        //                list = e;
        //            }
        //        }
        //        reList.clear();
        //        reList.add(list);

        return reList;
    }

    @Override
    public List<MappositionlistBusiness> getShopOrGoodsPositionOfMap(String shopEntityId, String keyWord) throws Exception
    {
        if (StringUtils.isBlank(keyWord))
        {
            keyWord = "";
        }

        //获取实体店位置信息
        List<MappositionlistBusiness> shopMappositionlistBusinessList = this.getMapPositionLingShopPosition(shopEntityId, keyWord);
        //获取商品位置信息
        List<MappositionlistBusiness> goodsMappositionlistBusinessList = this.getMapPositionLinkGoodsMarketingInfo(shopEntityId, keyWord);
        //封装数据
        List<MappositionlistBusiness> mappositionlistBusinessList = new ArrayList<MappositionlistBusiness>();
        if (CollectionUtils.isNotEmpty(shopMappositionlistBusinessList))
        {
            mappositionlistBusinessList.addAll(shopMappositionlistBusinessList);
        }
        if (CollectionUtils.isNotEmpty(goodsMappositionlistBusinessList))
        {
            mappositionlistBusinessList.addAll(goodsMappositionlistBusinessList);
        }
        return mappositionlistBusinessList;
    }

    /**
     * 获取商家位置信息
     * @param shopEntityId  实体店编号
     * @param keyWord 关键字，按位置名称模糊查询
     * @return
     * @throws Exception
     */
    private List<MappositionlistBusiness> getMapPositionLingShopPosition(String shopEntityId, String keyWord) throws Exception
    {
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        shopPositionExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andPositionNameLike("%" + keyWord + "%").andIsDelEqualTo("N");
        List<ShopPosition> shopPositionList = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
        List<MappositionlistBusiness> mappositionlistBusinessList = null;
        if (CollectionUtils.isNotEmpty(shopPositionList))
        {
            mappositionlistBusinessList = new ArrayList<MappositionlistBusiness>();
            for (ShopPosition shopPosition : shopPositionList)
            {
                MappositionlistBusiness temp = new MappositionlistBusiness();
                temp.setObjid(shopEntityId);//实体店编号
                //查询实体店信息
                Map<String, String> shopEntityInfoMap = this.shopEntityCacheQueryService.findShopEntityInfo(shopEntityId);
                temp.setObjname(shopEntityInfoMap != null && shopEntityInfoMap.size() > 0 ? shopEntityInfoMap.get("shopEntityName") : "");//实体店名称
                temp.setType("S");//S-商家，G-商品
                temp.setPositionId(shopPosition.getPositionId());//位置编号
                //查询地图信息
                AreaPara areaPara = this.getMapIdFromAreaPara(shopEntityId, shopPosition.getPositionId());
                if (areaPara != null)
                {//有对应地图信息
                    temp.setMapid(areaPara.getMapId());
                    //通过位置id查询网格
                    List<String> coordinates = this.mapQueryService.findGridFromPosition(shopPosition.getPositionId());
                    //获取网格的x\y坐标
                    Double[] locations = MapCoordinatesUtils.getSvgCentralCoordinate(coordinates, areaPara.getRatioGrid(), areaPara.getRatioSvg());
                    if (locations != null && locations.length > 0)
                    {
                        temp.setPx(String.valueOf(locations[0]));
                        temp.setPy(String.valueOf(locations[1]));
                    }
                    else
                    {//无对应坐标
                        temp.setPx(null);
                        temp.setPy(null);
                    }
                    mappositionlistBusinessList.add(temp);
                }
            }

        }
        return mappositionlistBusinessList;
    }

    /**
     * 获取营销商品的位置坐标信息
     * @param shopEntityId  实体店编号
     * @param keyWord 关键字，按商品名称模糊查询
     * @return
     * @throws Exception
     */
    private List<MappositionlistBusiness> getMapPositionLinkGoodsMarketingInfo(String shopEntityId, String keyWord) throws Exception
    {
        //1.查询商品营销信息
        GoodsMarketingInfoExample goodsMarketingInfoExample = new GoodsMarketingInfoExample();
        goodsMarketingInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        List<GoodsMarketingInfo> goodsMarketingInfoList = this.goodsMarketingInfoGeneratorQueryService.selectByExample(goodsMarketingInfoExample);
        List<String> goodsIds = null;
        List<MappositionlistBusiness> resultMappositionlistBusinessList = null;
        if (CollectionUtils.isNotEmpty(goodsMarketingInfoList))
        {
            goodsIds = new ArrayList<String>();
            for (GoodsMarketingInfo goodsMarketingInfo : goodsMarketingInfoList)
            {
                goodsIds.add(goodsMarketingInfo.getGoodsId());
            }
            //2.查询商品基本信息，名称模糊查询
            GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
            goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andGoodsIdIn(goodsIds).andIsDelEqualTo("N").andGoodsNameLike("%" + keyWord + "%");
            List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
            if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
            {
                resultMappositionlistBusinessList = new ArrayList<MappositionlistBusiness>();
                for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
                {
                    for (GoodsMarketingInfo goodsMarketingInfo : goodsMarketingInfoList)
                    {
                        if (goodsBaseInfo.getGoodsId().equals(goodsMarketingInfo.getGoodsId()))
                        {
                            MappositionlistBusiness temp = new MappositionlistBusiness();
                            temp.setObjid(goodsBaseInfo.getGoodsId());
                            temp.setObjname(goodsBaseInfo.getGoodsName());
                            temp.setType("G");
                            AreaPara areaPara = this.getMapIdFromAreaPara(shopEntityId, goodsMarketingInfo.getPositionId());
                            if (areaPara != null)
                            {//有对应地图信息
                                temp.setMapid(areaPara.getMapId());
                                //通过位置id查询网格
                                List<String> coordinates = this.mapQueryService.findGridFromPosition(goodsMarketingInfo.getPositionId());
                                //获取网格的x\y坐标
                                Double[] locations = MapCoordinatesUtils.getSvgCentralCoordinate(coordinates, areaPara.getRatioGrid(), areaPara.getRatioSvg());
                                if (locations != null && locations.length > 0)
                                {
                                    temp.setPx(String.valueOf(locations[0]));
                                    temp.setPy(String.valueOf(locations[1]));
                                }
                                else
                                {//无对应坐标
                                    temp.setPx(null);
                                    temp.setPy(null);
                                }

                                resultMappositionlistBusinessList.add(temp);
                            }
                            break;
                        }
                    }
                }
            }

        }

        return resultMappositionlistBusinessList;
    }

    /**
     * 获取地图参数信息
     * @param shopEnityId 实体店编号
     * @param positionId 位置编号
     * @return
     * @throws Exception
     */
    private AreaPara getMapIdFromAreaPara(String shopEnityId, String positionId) throws Exception
    {
        AreaParaExample areaParaExample = new AreaParaExample();
        areaParaExample.createCriteria().andShopEntityIdEqualTo(shopEnityId).andPositionIdEqualTo(positionId).andIsDelEqualTo("N");
        List<AreaPara> areaParaList = this.areaParaGeneratorQueryService.selectByExample(areaParaExample);
        return CollectionUtils.isNotEmpty(areaParaList) ? areaParaList.get(0) : null;
    }

    @Override
    public List<NavigationlistBusiness> getNavigationOfStartToEnd(String smapId, Double beginPx, Double beginPy, String emapId, Double endPx, Double endPy) throws Exception
    {
        // smapId == emapId
        String mapId = smapId;
        // 起点
        Point startPoint = new Point();
        startPoint.setXp(beginPx);
        startPoint.setYp(beginPy);
        /**
         * 获得分线段对象列
         */
        SectionLineInfoExample example = new SectionLineInfoExample();
        example.createCriteria().andMapIdEqualTo(mapId);
        List<SectionLineInfo> sectionLineInfos = this.sectionLineInfoGeneratorQueryService.selectByExample(example);
        List<Line> lines = SvgMapUtils.getLines(sectionLineInfos);
        /**
         * 获得起点坐标
         */
        Map<String, Object> beginMap = SvgMapUtils.getBeginPoint(startPoint, sectionLineInfos);
        Point beginPoint = (Point) beginMap.get("beginPoint");
        /**
         * 获得终点坐标
         */
        Point endPoint = new Point();
        endPoint.setXp(endPx);
        endPoint.setYp(endPy);
        //                AreaInfoExample exam = new AreaInfoExample();
        //                exam.createCriteria().andMapIdEqualTo(mapId).andPxEqualTo(String.valueOf(endPx)).andPyEqualTo(String.valueOf(endPy)).andIsDelEqualTo("N");
        //                List<AreaInfo> areaInfos = this.areaInfoGeneratorQueryService.selectByExample(exam);
        //                List<MapElementInfo> reList = this.getDoors(areaInfos.get(0).getAreaId());
        //                Point endPoint = null;
        //                if (reList.size() > 0)
        //                {
        //                    Point r = new Point();
        //                    r.setXp(reList.get(0).getPx());
        //                    r.setYp(reList.get(0).getPy());
        //                    endPoint = r;
        //                }
        //                else
        //                {
        //                    Point r = new Point();
        //                    r.setXp(endPx);
        //                    r.setYp(endPy);
        //                    endPoint = r;
        //                }
        /**
         * 导航
         */
        List<List<String>> idsList = SvgMapUtils.navigation(lines, beginPoint, endPoint);

        List<String> reLines = SvgMapUtils.getShortLine(beginMap, idsList, sectionLineInfos);

        //封装导航信息
        List<NavigationlistBusiness> navigationlistBusinessList = null;
        if (CollectionUtils.isNotEmpty(reLines))
        {
            navigationlistBusinessList = new ArrayList<NavigationlistBusiness>();
            for (String e : reLines)
            {
                NavigationlistBusiness tempNavigationlistBusiness = new NavigationlistBusiness();
                tempNavigationlistBusiness.setSvgstr(e);
                navigationlistBusinessList.add(tempNavigationlistBusiness);
            }
        }

        return navigationlistBusinessList;
    }

    @Override
    public List<NavigationlistBusiness> getNavigationOfMap(String smapId, Double beginPx, Double beginPy, String emapId, String objid, String type) throws Exception
    {

        // smapId == emapId
        String mapId = smapId;
        Point startPoint = new Point();
        startPoint.setXp(beginPx);
        startPoint.setYp(beginPy);
        /**
         * 获得分线段对象列
         */
        SectionLineInfoExample example = new SectionLineInfoExample();
        example.createCriteria().andMapIdEqualTo(mapId);
        List<SectionLineInfo> sectionLineInfos = this.sectionLineInfoGeneratorQueryService.selectByExample(example);
        List<Line> lines = SvgMapUtils.getLines(sectionLineInfos);
        /**
         * 获得终点坐标
         */
        //        // 实体店编号
        //        String shopEntityId = this.getShopEntityId(objid, type);
        //        // 终点坐标
        //        Point endPoint = this.getEndPoint(shopEntityId, mapId);
        String positionId = this.getShopOrGoodsPositonId(objid, type);//获取position_id 传入参数objid:商家编号或商品编号
        Point endPoint = this.getEndPoint(positionId, emapId);//获取终点坐标
        /**
         * 获得起点坐标
         */
        Point beginPoint = new Point();
        Map<String, Object> beginMap = SvgMapUtils.getBeginPoint(startPoint, sectionLineInfos);
        beginPoint = (Point) beginMap.get("beginPoint");
        /**                                           
         * 导航
         */
        List<List<String>> idsList = SvgMapUtils.navigation(lines, beginPoint, endPoint);

        List<String> reList = SvgMapUtils.getShortLine(beginMap, idsList, sectionLineInfos);

        //封装导航信息
        List<NavigationlistBusiness> navigationlistBusinessList = null;
        if (CollectionUtils.isNotEmpty(reList))
        {
            navigationlistBusinessList = new ArrayList<NavigationlistBusiness>();
            for (String e : reList)
            {
                NavigationlistBusiness tempNavigationlistBusiness = new NavigationlistBusiness();
                tempNavigationlistBusiness.setSvgstr(e);
                navigationlistBusinessList.add(tempNavigationlistBusiness);
            }
        }

        return navigationlistBusinessList;
    }

    /**
     * 获取终点的坐标
     * @param positionId 商品或商家的position_id
     * @return 商品或商家在svg图上的点坐标
     * @throws Exception 
     */
    private Point getEndPoint(String positionId, String mapId) throws Exception
    {
        Point endPoint = new Point();
        List<String> gridCoordinates = this.mapQueryService.findGridFromPosition(positionId);//从redis中取区域里面的坐标，很多坐标
        //网格坐标转成svg坐标
        AreaPara areaPara = this.areaParaGeneratorQueryService.selectByPrimaryKey(mapId);
        Double[] svgCoordinate = MapCoordinatesUtils.getSvgCentralCoordinate(gridCoordinates, areaPara.getRatioGrid(), areaPara.getRatioSvg());
        if (svgCoordinate.length > 1)
        {
            endPoint.setXp(svgCoordinate[0]);
            endPoint.setYp(svgCoordinate[1]);
        }
        return endPoint;
    }

    /**
     * 获取商家或商品的位置编号
     * @param objid
     * @param type
     */
    private String getShopOrGoodsPositonId(String objId, String type)
    {
        String positionId = null;
        if ("S".equals(type))//类型为S表示是商家
        {
            positionId = objId;
        }
        else if ("G".equals(type))//G表示是商品
        {
            GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(objId);//通过商品编号得到商品对象
            if (goodsMarketingInfo != null)
            {
                positionId = goodsMarketingInfo.getPositionId();//取得商品位置编号
            }
        }
        return positionId;
    }

    @Override
    public List<ShopListlistsBusiness> getShopListInfoInMap(String mapId) throws Exception
    {
        //1.根据地图编号查询地图区域信息
        //        AreaInfoExample example = new AreaInfoExample();
        //        Criteria criteria = example.createCriteria();
        //        criteria.andMapIdEqualTo(mapId);
        //        criteria.andIsDelEqualTo("N");
        //        List<AreaInfo> areaInfos = this.areaInfoGeneratorQueryService.selectByExample(example);
        List<ShopListlistsBusiness> reList = null;
        //        if (CollectionUtils.isNotEmpty(areaInfos))
        //        {
        //            reList = new ArrayList<ShopListlistsBusiness>();
        //            for (AreaInfo e : areaInfos)
        //            {
        //                ShopListlistsBusiness shopList = new ShopListlistsBusiness();
        //                shopList.setPx(String.valueOf(e.getPx()));
        //                shopList.setPy(String.valueOf(e.getPy()));
        //                shopList.setMapid(mapId);
        //                shopList.setSvgid(e.getSvgTagId());
        //                // 排除最大的区域
        //                if (shopList.getSvgid().equals("main"))
        //                {
        //                    continue;
        //                }
        //                //2.查询商家位置信息
        //                ShopPosition position = this.shopPositionGeneratorQueryService.selectByPrimaryKey(e.getPositionId());
        //                if (position == null)
        //                {
        //                    continue;
        //                }
        //                //3.查询实体店信息
        //                ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(position.getShopEntityId());
        //                //4.查询商家信息
        //                ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(position.getShopId());
        //
        //                if (shopEntityInfo != null && shopInfo != null)
        //                {
        //                    shopList.setShopentityid(shopEntityInfo.getShopEntityId());
        //                    shopList.setShopid(shopEntityInfo.getShopId());
        //                    shopList.setShopentityname(shopEntityInfo.getShopEntityName() + "-" + position.getPositionName());
        //                    ShopType shopType = this.shopCacheQueryService.findShopCategory(String.valueOf(shopInfo.getShopTypeRoot()));
        //                    if (shopType == null)
        //                    {
        //                        shopList.setShoptyperootid(String.valueOf(shopInfo.getShopTypeRoot()));
        //                        ShopType tempShopType = this.shopCacheQueryService.findShopCategory(shopInfo.getShopTypeRoot().toString());
        //                        shopList.setShoptyperootname(tempShopType.getShopTypeName());
        //                    }
        //                    else
        //                    {
        //                        shopList.setShoptyperootid(String.valueOf(shopType.getShopTypeId()));
        //                        shopList.setShoptyperootname(shopType.getShopTypeName());
        //                    }
        //                }
        //                else
        //                {
        //                    continue;
        //                }
        //                reList.add(shopList);
        //            }
        //        }
        return reList;
    }

    /**
     * 获得实体店id
     * @param id 实体店编号或商品编号
     * @param type s-实体店 G-商品
     * @return
     * @throws FetchviewException 
     */
    public String getShopEntityId(String id, String type)
    {
        String shopEntityId = "";
        // 实体店
        if (type.equals("S"))
        {
            shopEntityId = id;
        }
        // 商品
        else if (type.equals("G"))
        {
            GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(id);
            if (goodsBaseInfo != null)
            {
                shopEntityId = goodsBaseInfo.getShopEntityId();
            }
        }
        return shopEntityId;
    }

    //    /**
    //     * 获得终点
    //     * TODO 先取一个
    //     * @param shopId
    //     * @param mapId
    //     * @return
    //     * @throws ShopException
    //     */
    //    public Point getEndPoint(String shopEntityId, String mapId)
    //    {

    //        ShopPositionExample example = new ShopPositionExample();
    //        com.gooagoo.entity.generator.shop.ShopPositionExample.Criteria criteria = example.createCriteria();
    //        criteria.andShopEntityIdEqualTo(shopEntityId);
    //        criteria.andIsDelEqualTo("N");
    //        List<ShopPosition> shopPositions = this.shopPositionGeneratorQueryService.selectByExample(example);
    //
    //        AreaInfoExample exam = new AreaInfoExample();
    //        com.gooagoo.entity.generator.shop.AreaInfoExample.Criteria cri = exam.createCriteria();
    //        cri.andMapIdEqualTo(mapId);
    //        cri.andIsDelEqualTo("N");
    //
    //        List<AreaInfo> areaInfos = this.areaInfoGeneratorQueryService.selectByExample(exam);
    //
    //        String areaId = "";
    //        for (ShopPosition e : shopPositions)
    //        {
    //            for (AreaInfo info : areaInfos)
    //            {
    //                if (e.getPositionId().equals(info.getPositionId()))
    //                {
    //                    areaId = info.getAreaId();
    //                }
    //            }
    //        }
    //
    //        if (areaId.isEmpty())
    //        {
    //            return null;
    //        }
    //        else
    //        {
    //            List<MapElementInfo> reList = this.getDoors(areaId);
    //            if (reList.size() > 0)
    //            {
    //                Point r = new Point();
    //                r.setXp(reList.get(0).getPx());
    //                r.setYp(reList.get(0).getPy());
    //                return r;
    //            }
    //            else
    //            {
    //                // TODO 系统获取默认 名的点坐标
    //        return null;
    //            }
    //        }
    //    }

    //    public List<MapElementInfo> getDoors(String areaId)
    //    {
    //        String doorTag = "1";
    //        MapElementInfoExample example = new MapElementInfoExample();
    //        example.createCriteria().andAreaIdEqualTo(areaId).andElementTypeEqualTo(doorTag).andIsDelEqualTo("N");
    //        return this.mapElementInfoGeneratorQueryService.selectByExample(example);
    //    }
}

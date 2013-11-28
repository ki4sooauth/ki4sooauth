package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.map.GpsNavigationService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.shop.map.MapactivitylistBusiness;
import com.gooagoo.entity.business.shop.map.MappositionlistBusiness;
import com.gooagoo.entity.business.shop.map.NavigationlistBusiness;
import com.gooagoo.entity.business.shop.map.ShopListlistsBusiness;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.mobile.api.GpsNavigationMobileService;
import com.gooagoo.mobile.entity.mobi01.transform.MapActivityRoot;
import com.gooagoo.mobile.entity.mobi01.transform.Mapactivitylists;
import com.gooagoo.mobile.entity.mobi02.transform.MapPositionRoot;
import com.gooagoo.mobile.entity.mobi02.transform.Mappositionlists;
import com.gooagoo.mobile.entity.mobi03.transform.NavigationARoot;
import com.gooagoo.mobile.entity.mobi03.transform.Navigationtopoint;
import com.gooagoo.mobile.entity.mobi04.transform.NavigationBRoot;
import com.gooagoo.mobile.entity.mobi04.transform.Navigationtoshoporgoods;
import com.gooagoo.mobile.entity.mobi05.transform.ShopListRoot;
import com.gooagoo.mobile.entity.mobi05.transform.ShopListlists;
import com.gooagoo.mobile.entity.mobi07.transform.DownloadMapRoot;
import com.gooagoo.mobile.entity.mobi07.transform.Downloadinfo;

@Service
public class GpsNavigationMobileServiceImpl implements GpsNavigationMobileService
{
    @Autowired
    private GpsNavigationService gpsNavigationService;
    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;

    @Override
    public MapActivityRoot getGlobalShopActityInfoOfMap(String mapId) throws Exception
    {
        GooagooLog.info("getShopOrGoodsPositionOfMap-->入参为：【mapId=" + mapId + "】");
        List<MapactivitylistBusiness> mapactivitylistBusinessList = this.gpsNavigationService.getGlobalShopActityInfoOfMap(mapId);
        List<Mapactivitylists> mapactivitylists = null;
        if (CollectionUtils.isNotEmpty(mapactivitylistBusinessList))
        {
            mapactivitylists = new ArrayList<Mapactivitylists>();
            for (MapactivitylistBusiness mapactivitylistBusiness : mapactivitylistBusinessList)
            {
                Mapactivitylists tempMapactivitylist = new Mapactivitylists();
                tempMapactivitylist.setName(mapactivitylistBusiness.getName());
                tempMapactivitylist.setPx(mapactivitylistBusiness.getPx());
                tempMapactivitylist.setPy(mapactivitylistBusiness.getPy());
                tempMapactivitylist.setUrl(mapactivitylistBusiness.getUrl());
                mapactivitylists.add(tempMapactivitylist);
            }
        }
        MapActivityRoot root = new MapActivityRoot();
        root.setMapactivitylists(mapactivitylists);
        return root;
    }

    @Override
    public MapPositionRoot getShopOrGoodsPositionOfMap(String shopEntityId, String keyWord) throws Exception
    {
        GooagooLog.info("getShopOrGoodsPositionOfMap-->入参为：【shopEntityId=" + shopEntityId + ",keyWord=" + keyWord);
        List<MappositionlistBusiness> mappositionlistBusinessList = this.gpsNavigationService.getShopOrGoodsPositionOfMap(shopEntityId, keyWord);
        List<Mappositionlists> mappositionlists = null;
        if (CollectionUtils.isNotEmpty(mappositionlistBusinessList))
        {
            mappositionlists = new ArrayList<Mappositionlists>();
            for (MappositionlistBusiness mappositionlistBusiness : mappositionlistBusinessList)
            {

                Mappositionlists tempMappositionlist = new Mappositionlists();
                tempMappositionlist.setObjid(mappositionlistBusiness.getObjid());
                tempMappositionlist.setObjname(mappositionlistBusiness.getObjname());
                tempMappositionlist.setMapid(mappositionlistBusiness.getMapid());
                tempMappositionlist.setPx(mappositionlistBusiness.getPx());
                tempMappositionlist.setPy(mappositionlistBusiness.getPy());
                tempMappositionlist.setType(mappositionlistBusiness.getType());
                mappositionlists.add(tempMappositionlist);
            }

        }
        MapPositionRoot root = new MapPositionRoot();
        root.setMappositionlists(mappositionlists);
        return root;
    }

    @Override
    public NavigationARoot getNavigationOfStartToEnd(String sMapId, Double spx, Double spy, String eMapId, Double epx, Double epy) throws Exception
    {
        GooagooLog.info("getNavigationOfStartToEnd-->入参为：【sMapId=" + sMapId + ",spx=" + spx + ",spy" + spy + ",eMapId" + eMapId + ",epx" + epx + ",epy" + epy);
        List<NavigationlistBusiness> info = this.gpsNavigationService.getNavigationOfStartToEnd(sMapId, spx, spy, eMapId, epx, epy);
        List<Navigationtopoint> navigationlists = null;
        if (CollectionUtils.isNotEmpty(info))
        {
            navigationlists = new ArrayList<Navigationtopoint>();
            for (NavigationlistBusiness t : info)
            {
                Navigationtopoint navigation = new Navigationtopoint();
                navigation.setSvgstr(t.getSvgstr());
                navigationlists.add(navigation);
            }
        }
        NavigationARoot root = new NavigationARoot();
        root.setNavigationtopoint(navigationlists);
        return root;
    }

    @Override
    public NavigationBRoot getNavigationOfMap(String sMapId, Double spx, Double spy, String eMapId, String objId, String type) throws Exception
    {
        GooagooLog.info("getNavigationOfMap-->入参为：【sMapId=" + sMapId + ",spx=" + spx + ",spy" + spy + ",eMapId" + eMapId + ",objId" + objId + ",type" + type);
        List<NavigationlistBusiness> info = this.gpsNavigationService.getNavigationOfMap(sMapId, spx, spy, eMapId, objId, type);
        List<Navigationtoshoporgoods> navigationlists = null;
        if (CollectionUtils.isNotEmpty(info))
        {
            navigationlists = new ArrayList<Navigationtoshoporgoods>();
            for (NavigationlistBusiness t : info)
            {
                Navigationtoshoporgoods navigation = new Navigationtoshoporgoods();
                navigation.setSvgstr(t.getSvgstr());
                navigationlists.add(navigation);
            }
        }
        NavigationBRoot root = new NavigationBRoot();
        root.setNavigationtoshoporgoods(navigationlists);
        return root;
    }

    @Override
    public ShopListRoot getShopListInfoInMap(String mapId) throws Exception
    {
        GooagooLog.info("getShopListInfoInMap-->入参为：【mapId=" + mapId);
        List<ShopListlistsBusiness> info = this.gpsNavigationService.getShopListInfoInMap(mapId);
        List<ShopListlists> shopListlists = null;
        if (CollectionUtils.isNotEmpty(info))
        {
            shopListlists = new ArrayList<ShopListlists>();
            for (ShopListlistsBusiness t : info)
            {
                ShopListlists shopList = new ShopListlists();
                shopList.setMapid(t.getMapid());
                shopList.setPx(t.getPx());
                shopList.setPy(t.getPy());
                shopList.setShopentityid(t.getShopentityid());
                shopList.setShopentityname(t.getShopentityname());
                shopList.setShopid(t.getShopid());
                shopList.setSvgid(t.getSvgid());
                shopList.setShoptyperootid(t.getShoptyperootid());
                shopList.setShoptyperootname(t.getShoptyperootname());
                shopListlists.add(shopList);
            }
        }
        ShopListRoot root = new ShopListRoot();
        root.setShopListlists(shopListlists);
        return root;
    }

    @Override
    public DownloadMapRoot downloadMapInfo(String mapId) throws Exception
    {
        AreaPara areaPara = this.areaParaGeneratorQueryService.selectUnDelByPrimaryKey(mapId);
        DownloadMapRoot root = new DownloadMapRoot();
        Downloadinfo downloadinfo = new Downloadinfo();
        downloadinfo.setDownloadurl(areaPara != null ? areaPara.getUrlHtml() : "");
        root.setDownloadinfo(downloadinfo);
        return root;
    }
}

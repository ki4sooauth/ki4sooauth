package com.gooagoo.igus.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.shop.map.MapQueryService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.MapCoordinatesUtils;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UNavigation;
import com.google.gson.Gson;

/**
 * 获取地图导航数据（暂时废弃）
 * @author SPZ
 *
 */
@Service("igus002Service")
public class IGus002ServiceImpl implements IGusService
{

    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;

    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;

    @Autowired
    private MapQueryService mapQueryService;

    private ShopPosition shopPosition;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String poisitionId = ServletRequestUtils.getStringParameter(request, "positionId");
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId");
            AreaPara areaPara = this.getAreaPara(poisitionId, shopId, shopEntityId);
            if (areaPara == null)
            {
                GooagooLog.error("获取地图导航数据：位置（poisitionId=" + poisitionId + "&shopId=" + shopId + "&shopEntityId=" + shopEntityId + "）没有对应地图信息", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            GooagooLog.debug("获取地图导航数据：位置（poisitionId=" + poisitionId + "&shopId=" + shopId + "&shopEntityId=" + shopEntityId + "）对应地图信息（" + areaPara.toString() + "）");
            List<String> gridList = this.mapQueryService.findGridFromPosition(poisitionId);
            if (CollectionUtils.isEmpty(gridList))
            {
                GooagooLog.error("获取地图导航数据：位置（poisitionId=" + poisitionId + "&shopId=" + shopId + "&shopEntityId=" + shopEntityId + "）没有对应网格数据", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            GooagooLog.debug("获取地图导航数据：位置（poisitionId=" + poisitionId + "&shopId=" + shopId + "&shopEntityId=" + shopEntityId + "）对应网格数据（" + new Gson().toJson(gridList) + "）");
            String[] gridXY = gridList.get(0).split(",");
            Double[] coordinateXY = MapCoordinatesUtils.GridToSvg(Integer.valueOf(gridXY[0]), Integer.valueOf(gridXY[1]), areaPara.getRatioGrid(), areaPara.getRatioSvg());
            UNavigation unavigation = new UNavigation();
            unavigation.setMapId(areaPara.getMapId());
            unavigation.setX(coordinateXY[0]);
            unavigation.setY(coordinateXY[1]);
            unavigation.setShopId(shopId);
            unavigation.setShopEntityId(shopEntityId);
            unavigation.setPositionName(this.shopPosition.getPositionName());
            transData = new TransData<Object>(true, null, unavigation);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取地图导航数据：获取地图导航数据异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

    /**
     * 获取位置对应地图信息
     * @param poisitionId
     * @param shopId
     * @param shopEntityId
     * @return
     */
    private AreaPara getAreaPara(String poisitionId, String shopId, String shopEntityId)
    {
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        shopPositionExample.createCriteria().andPositionIdEqualTo(poisitionId).andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        List<ShopPosition> shopPositionList = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
        if (CollectionUtils.isEmpty(shopPositionList))
        {
            return null;
        }
        ShopPosition shopPosition = shopPositionList.get(0);
        AreaParaExample areaParaExample = new AreaParaExample();
        areaParaExample.createCriteria().andPositionIdEqualTo(poisitionId).andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        List<AreaPara> areaParaList = this.areaParaGeneratorQueryService.selectByExample(areaParaExample);
        if (CollectionUtils.isEmpty(areaParaList))
        {
            if ("-1".equals(shopPosition.getParentPositionId()))
            {
                return null;
            }
            return this.getAreaPara(shopPosition.getParentPositionId(), shopId, shopEntityId);
        }
        this.shopPosition = shopPosition;
        return areaParaList.get(0);
    }

}

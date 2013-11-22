package com.gooagoo.position.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.DeviceWifisensorGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidDetailGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.position.constants.DeviceType;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.position.log.PositionEngineLog;
import com.gooagoo.position.utils.HessianBeanUtils;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisStringDao;

public class AreaCache
{
    private static ShopLidDetailGeneratorQueryService lidQuery = HessianBeanUtils.getBean(ShopLidDetailGeneratorQueryService.class);
    private static ShopPositionGeneratorQueryService positionService = HessianBeanUtils.getBean(ShopPositionGeneratorQueryService.class);
    private static DeviceWifisensorGeneratorQueryService wifisensorService = HessianBeanUtils.getBean(DeviceWifisensorGeneratorQueryService.class);
    private static AreaParaGeneratorQueryService areaParaService = HessianBeanUtils.getBean(AreaParaGeneratorQueryService.class);

    /**
     * 网格
     * @param mapId
     * @param x
     * @param y
     * @return
     */
    public static Map<String, String> gridCoordinateInfo(String mapId, double x, double y)
    {
        String px = (int) Math.floor(x) + "";
        String py = (int) Math.floor(y) + "";
        RedisHashDao hashDao = new RedisHashDao(RedisConstants.business_grid);
        Map<String, String> result = hashDao.get(mapId + "_" + px + "_" + py);
        return result;
    }

    /**
     * 取得
     * @param mapId
     * @return
     */
    public static Map<String, String> mapInfo(String mapId)
    {
        RedisHashDao hashDao = new RedisHashDao(RedisConstants.business_map);
        Map<String, String> map = hashDao.get("M_" + mapId);
        if (map == null || map.keySet().size() == 0)
        {
            AreaPara areaPara = areaParaService.selectUnDelByPrimaryKey(mapId);
            if (areaPara != null)
            {
                map = new HashMap<String, String>();
                map.put("shopId", areaPara.getShopId());
                map.put("shopEntityId", areaPara.getShopEntityId());
                map.put("mapRealHeight", areaPara.getMapRealHeight().toString());
                map.put("mapRealWidth", areaPara.getMapRealWidth().toString());
                map.put("ratioLocation", areaPara.getRatioLocation().toString());
                map.put("ratioGrid", areaPara.getRatioGrid().toString());
                map.put("ratioSvg", areaPara.getRatioSvg().toString());
                hashDao.set("M_" + mapId, map);
            }
        }
        return map;
    }

    /**
     * 通过设备地址取得所属地图编号
     * @param device
     * @param type
     * @return
     */
    public static String getMapId(String device, char type)
    {
        RedisStringDao redisStringDao = new RedisStringDao(RedisConstants.business_map);
        String mapId = null;
        if (DeviceType.SOUND == type)//声波设备
        {
            mapId = redisStringDao.get("L_" + device);
            if (!StringUtils.hasText(mapId))
            {
                mapId = getMapIdFromLid(device);
                if (StringUtils.hasText(mapId))
                {
                    redisStringDao.set("L_" + device, mapId);
                }
                else
                {
                    PositionEngineLog.info("声波设备无法匹配地图 设备编号:" + device);
                }
            }
        }
        else
        {
            mapId = redisStringDao.get("W_" + device);
            if (!StringUtils.hasText(mapId))
            {
                mapId = getMapIdFromWifi(device);
                if (StringUtils.hasText(mapId))
                {
                    redisStringDao.set("W_" + device, mapId);
                }
                else
                {
                    PositionEngineLog.info("WifiSensor无法匹配地图 设备MAC:" + device);
                }
            }
        }
        return mapId;
    }

    private static String getMapIdFromWifi(String device)
    {
        String mapId = null;
        DeviceWifisensorExample example = new DeviceWifisensorExample();
        example.createCriteria().andDeviceMacEqualTo(device).andIsDelEqualTo("N");
        List<DeviceWifisensor> wifisensors = wifisensorService.selectByExample(example);
        if (wifisensors != null && wifisensors.size() != 0)
        {
            String positionId = wifisensors.get(0).getPositionId();
            mapId = getMapIdFromPosition(positionId);
            if (!StringUtils.hasText(mapId))
            {
                mapId = getMapIdFromParentPosition(positionId);
            }
        }
        return mapId;
    }

    /**
     * 根据lid查询地图id
     * @param device
     * @return
     */
    private static String getMapIdFromLid(String device)
    {
        String mapId = null;
        ShopLidDetail lidDetails = lidQuery.selectUnDelByPrimaryKey(device);
        if (lidDetails != null)
        {
            String positionId = lidDetails.getPositionId();
            if (StringUtils.hasText(positionId))
            {
                mapId = getMapIdFromPosition(positionId);
                if (!StringUtils.hasText(mapId))
                {
                    mapId = getMapIdFromParentPosition(positionId);
                }
            }
        }
        return mapId;
    }

    private static String getMapIdFromPosition(String positionId)
    {
        String mapId = null;
        ShopPosition shop = positionService.selectUnDelByPrimaryKey(positionId);
        AreaParaExample areaParaExample = new AreaParaExample();
        areaParaExample.createCriteria().andShopIdEqualTo(shop.getShopId()).andShopEntityIdEqualTo(shop.getShopEntityId()).andIsDelEqualTo("N");
        List<AreaPara> areas = areaParaService.selectByExample(areaParaExample);
        if (areas != null)
        {
            if (areas.size() == 1)
            {
                mapId = areas.get(0).getMapId();
            }
            else
            {
                String parPositionId = getMapIdFromParentPosition(positionId);
                for (AreaPara areaPara : areas)
                {
                    if (parPositionId.equals(areaPara.getPositionId()) || parPositionId == areaPara.getPositionId())
                    {
                        mapId = areaPara.getMapId();
                        break;
                    }
                }
            }
        }
        return mapId;
    }

    private static String getMapIdFromParentPosition(String positionId)
    {
        String mapId = null;

        ShopPosition position = positionService.selectUnDelByPrimaryKey(positionId);
        mapId = getMapIdFromPosition(position.getPositionId());
        if (StringUtils.hasText(mapId) || "-1".equals(position.getPositionId()))
        {
            return mapId;
        }
        else
        {
            return getMapIdFromParentPosition(position.getParentPositionId());
        }
    }
}

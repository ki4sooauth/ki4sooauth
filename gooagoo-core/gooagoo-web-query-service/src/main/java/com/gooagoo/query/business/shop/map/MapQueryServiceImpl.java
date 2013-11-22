package com.gooagoo.query.business.shop.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.map.MapQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.shop.map.SvgAreaTip;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class MapQueryServiceImpl implements MapQueryService
{
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Override
    public boolean addOrUpdateGridCoordinateInfoCacheData(Map<String, Map<String, String>> gridMap) throws Exception
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_grid);
        Iterator<String> iterator = gridMap.keySet().iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            redisHashDao.set(key, gridMap.get(key));
        }
        return true;
    }

    @Override
    public List<SvgAreaTip> findMapAreaTips(String mapId) throws Exception
    {
        List<SvgAreaTip> tipList = new ArrayList<SvgAreaTip>();
        //        AreaInfoExample areaInfoExample = new AreaInfoExample();
        //        areaInfoExample.createCriteria().andIsDelEqualTo("N").andMapIdEqualTo(mapId);
        //        List<AreaInfo> areaList = this.areaInfoGeneratorQueryService.selectByExample(areaInfoExample);
        //        if (areaList == null || areaList.size() == 0)
        //        {
        //            return tipList;
        //        }
        //        Map<String, Object> cacheMap = new HashMap<String, Object>();
        //        for (Iterator<AreaInfo> iterator = areaList.iterator(); iterator.hasNext();)
        //        {
        //            AreaInfo areaInfo = iterator.next();
        //            SvgAreaTip tip = new SvgAreaTip();
        //            tip.setSvgTagId(areaInfo.getSvgTagId());
        //            tip.setAreaPx(areaInfo.getPx());
        //            tip.setAreaPy(areaInfo.getPy());
        //
        //            String positionId = areaInfo.getPositionId();
        //            this.freshMapEntityInfo(tip, positionId, cacheMap);
        //
        //            tipList.add(tip);
        //        }
        return tipList;
    }

    @Override
    public List<String> findGridFromPosition(String positionId) throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.business_grid);
        Set<String> set = sortedSetDao.get(positionId, 0, -1);
        return new ArrayList<String>(set);
    }

    @Override
    public Map<String, String> findPositionFromMap(String mapId) throws Exception
    {
        RedisHashDao RedisHashDao = new RedisHashDao(RedisServerConstants.business_grid);
        return RedisHashDao.get(mapId);
    }

}

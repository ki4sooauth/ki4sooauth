package com.gooagoo.core.business.shop.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.map.MapCoreService;
import com.gooagoo.api.generator.core.shop.AreaParaGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.GeneratrixInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.SectionLineInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.user.AreaParaDetail;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.GeneratrixInfoExample;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.google.gson.Gson;

@Service
public class MapCoreServiceImpl implements MapCoreService
{

    @Autowired
    private AreaParaGeneratorCoreService areaParaGeneratorCoreService;
    @Autowired
    private GeneratrixInfoGeneratorCoreService generatrixInfoGeneratorCoreService;
    @Autowired
    private SectionLineInfoGeneratorCoreService sectionLineInfoGeneratorCoreService;

    @Override
    public boolean addMap(AreaPara areaPara) throws Exception
    {
        areaPara.setIsDel("N");
        return this.areaParaGeneratorCoreService.insertSelective(areaPara);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addMapDetail(AreaParaDetail areaParaDetail) throws Exception
    {
        this.addAreaParaDetail(areaParaDetail);
        return true;
    }

    @Override
    public boolean updateMap(AreaPara areaPara) throws Exception
    {
        return this.areaParaGeneratorCoreService.updateByPrimaryKeySelective(areaPara);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateMapDetail(AreaParaDetail areaParaDetail) throws Exception
    {
        //获取mapId
        String mapId = null;
        if (!StringUtils.hasText(mapId) && areaParaDetail.getGeneratrixInfos().size() > 0)
        {
            mapId = areaParaDetail.getGeneratrixInfos().get(0).getMapId();
        }
        if (!StringUtils.hasText(mapId) && areaParaDetail.getSectionLineInfos().size() > 0)
        {
            mapId = areaParaDetail.getSectionLineInfos().get(0).getMapId();
        }
        if (!StringUtils.hasText(mapId))
        {
            GooagooLog.warn("更新地图详细信息时，获取地图id失败：obj=" + new Gson().toJson(areaParaDetail));
            return false;
        }
        //删除旧信息
        this.deleteAreaParaDetailByMapId(mapId);
        //创建新信息
        this.addAreaParaDetail(areaParaDetail);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteMap(String mapId) throws Exception
    {
        boolean res = this.areaParaGeneratorCoreService.deleteByPrimaryKey(mapId);
        if (!res)
        {
            GooagooLog.warn("删除地图信息失败：mapId=" + mapId);
            return false;
        }

        this.deleteAreaParaDetailByMapId(mapId);

        return true;
    }

    /**
     * 根据地图Id删除地图相关详细信息
     * @param mapId
     * @throws OperateFailException
     */
    private void deleteAreaParaDetailByMapId(String mapId) throws OperateFailException
    {
        GeneratrixInfoExample generatrixInfoExample = new GeneratrixInfoExample();
        generatrixInfoExample.createCriteria().andMapIdEqualTo(mapId);
        if (this.generatrixInfoGeneratorCoreService.countByExample(generatrixInfoExample) > 0)
        {
            if (!this.generatrixInfoGeneratorCoreService.physicalDeleteByExample(generatrixInfoExample))
            {
                GooagooLog.warn("删除generatrixInfo失败：mapId=" + mapId);
                throw new OperateFailException("删除动线信息失败");
            }
        }

        SectionLineInfoExample sectionLineInfoExample = new SectionLineInfoExample();
        sectionLineInfoExample.createCriteria().andMapIdEqualTo(mapId);
        if (this.sectionLineInfoGeneratorCoreService.countByExample(sectionLineInfoExample) > 0)
        {
            if (!this.sectionLineInfoGeneratorCoreService.physicalDeleteByExample(sectionLineInfoExample))
            {
                GooagooLog.warn("删除sectionLineInfo失败：mapId=" + mapId);
                throw new OperateFailException("删除分段线路信息失败");
            }
        }
    }

    /**
     * 添加地图相关详细信息
     * @param areaParaDetail
     * @throws OperateFailException
     */
    private void addAreaParaDetail(AreaParaDetail areaParaDetail) throws OperateFailException
    {
        List<GeneratrixInfo> generatrixInfos = areaParaDetail.getGeneratrixInfos();
        List<SectionLineInfo> sectionLineInfos = areaParaDetail.getSectionLineInfos();
        for (Iterator<GeneratrixInfo> iterator = generatrixInfos.iterator(); iterator.hasNext();)
        {
            GeneratrixInfo generatrixInfo = iterator.next();
            //            generatrixInfo.setIsDel("N");
            boolean res = this.generatrixInfoGeneratorCoreService.insertSelective(generatrixInfo);
            if (!res)
            {
                GooagooLog.warn("添加generatrixInfo失败：obj=" + new Gson().toJson(generatrixInfo));
                throw new OperateFailException("添加动线信息失败");
            }
        }
        for (Iterator<SectionLineInfo> iterator = sectionLineInfos.iterator(); iterator.hasNext();)
        {
            SectionLineInfo sectionLineInfo = iterator.next();
            //            sectionLineInfo.setIsDel("N");
            boolean res = this.sectionLineInfoGeneratorCoreService.insertSelective(sectionLineInfo);
            if (!res)
            {
                GooagooLog.warn("添加sectionLineInfo失败：obj=" + new Gson().toJson(sectionLineInfo));
                throw new OperateFailException("添加分段线路信息失败");
            }
        }
    }

    /**
     * 添加地图网格信息（缓存）
     * @param mapId 地图编号
     * @param xGridNum 地图真实宽度/网格坐标系比例
     * @param positionMap Map<位置编号, List<网格>>
     * @param outsideGridList List<网格>
     * @throws Exception
     */
    @Override
    public void addMapCache(String mapId, int xGridNum, Map<String, List<String>> positionMap, List<String> outsideGridList) throws Exception
    {
        //网格属性，0-室外，1-室内
        Set<String> outside = new HashSet<String>(outsideGridList);
        RedisHashDao RedisHashDao = new RedisHashDao(RedisServerConstants.business_grid);
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.business_grid);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.business_grid);
        //Map<位置编号, Map<网格,网格属性>>
        Map<String, String> positionhm = new HashMap<String, String>();
        for (Map.Entry<String, List<String>> entry : positionMap.entrySet())
        {
            redisDatabase.del(entry.getKey());
            StringBuffer gridInfo = new StringBuffer();
            for (String grid : entry.getValue())
            {
                int x = Integer.parseInt(grid) % xGridNum;
                int y = Integer.parseInt(grid) / xGridNum;
                String sideType = outside.contains(grid) ? "0" : "1";//网格属性0-室外1-室内
                //key：地图编号_X_Y;value：位置编号_网格属性
                Map<String, String> hm = new HashMap<String, String>();
                hm.put("positionId", entry.getKey());//位置编号
                hm.put("gridAttribute", sideType);
                RedisHashDao.set(mapId + "_" + String.valueOf(x) + "_" + String.valueOf(y), hm);
                //key：位置编号;value：x,y,x,y......
                sortedSetDao.put(entry.getKey(), 1, String.valueOf(x) + "," + String.valueOf(y));
                gridInfo.append(String.valueOf(x) + "_" + String.valueOf(y) + "_" + sideType + ",");
            }
            if (StringUtils.hasText(gridInfo))
            {//去掉最后一个逗号
                gridInfo.deleteCharAt(gridInfo.length() - 1);
            }
            positionhm.put(entry.getKey(), gridInfo.toString());
        }
        //key：mapId;value：Map<位置编号,x_y_网格属性,x_y_网格属性......>
        RedisHashDao.set(mapId, positionhm);
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
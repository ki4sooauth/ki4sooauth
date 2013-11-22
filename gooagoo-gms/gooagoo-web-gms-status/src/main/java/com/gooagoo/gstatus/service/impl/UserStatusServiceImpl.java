package com.gooagoo.gstatus.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.gstatus.service.UserStatusService;
import com.gooagoo.view.gms.crm.FUserDetail;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.YDataVo;

@Service("userStatusService")
public class UserStatusServiceImpl implements UserStatusService
{

    @Override
    public void save(String tokon, String time, String name, String desc)
    {
        //RedisObjectDao objectDao = new RedisObjectDao(RedisServerConstants.login_gms);
        //GmsLoginInfo gmsLoginInfo = objectDao.getGenerics(tokon, GmsLoginInfo.class);
        String redisKey = null;
        if (time.length() < 3)
        {
            //redisKey = "001_" + gmsLoginInfo.getShopId() + "_" + time;
        }
        else
        {
            // redisKey = "002_" + gmsLoginInfo.getShopId() + "_" + time;
        }
        FUserDetail detail = new FUserDetail();
        detail.setId(redisKey);
        detail.setName(name);
        detail.setDesc(desc);
        //gmsLoginInfo.getDetailList().add(detail);
        // objectDao.set(tokon, gmsLoginInfo);
    }

    @Override
    public FhighChartVo memberStatus(String statisticType, String tableName, String shopId, String serName)
    {
        FhighChartVo vo = new FhighChartVo();
        vo.setTableName(tableName);
        vo.setyName("人");
        vo.setUnit("人");
        List<String> xData = new ArrayList<String>();
        List<Integer> data = new ArrayList<Integer>();

        //RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_relevantUser);
        //RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_relevantUser);
        //Set<String> keys = database.keys("003_" + shopId + "*");
        List<String> listKeys = new ArrayList<String>();
        //listKeys.addAll(keys);
        Collections.sort(listKeys);
        String time = null;
        for (String key : listKeys)
        {
            time = key.split("_")[2];
            xData.add(time + "时");
            //data.add((int) sortedSetDao.zcard(key));
        }
        vo.setxData(xData);
        YDataVo yDate = new YDataVo();
        yDate.setData(data);
        yDate.setName(serName);
        vo.getyDataVos().add(yDate);
        return vo;
    }

    @Override
    public List<Long[]> memberHistory(String statisticType, String shopId)
    {
        List<Long[]> result = new ArrayList<Long[]>();
        //RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_relevantUser);
        //RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_relevantUser);
        // Set<String> keys = database.keys("004_" + shopId + "*");
        List<String> listKeys = new ArrayList<String>();
        //listKeys.addAll(keys);
        Collections.sort(listKeys);
        String time = null;
        for (String key : listKeys)
        {
            time = key.split("_")[2];
            //result.add(new Long[] { Long.parseLong(time), sortedSetDao.zcard(key) });
        }
        return result;
    }

    @Override
    public FhighChartVo unMemberStatus(String statisticType, String tableName, String shopId, String serName)
    {
        FhighChartVo vo = new FhighChartVo();
        vo.setTableName(tableName);
        vo.setyName("人");
        vo.setUnit("人");
        List<String> xData = new ArrayList<String>();
        List<Integer> data = new ArrayList<Integer>();

        // RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_relevantUser);
        //RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_relevantUser);
        //Set<String> keys = database.keys("001_" + shopId + "*");
        List<String> listKeys = new ArrayList<String>();
        //listKeys.addAll(keys);
        Collections.sort(listKeys);
        String time = null;
        for (String key : listKeys)
        {
            time = key.split("_")[2];
            xData.add(time + "时");
            // data.add((int) sortedSetDao.zcard(key));
        }
        vo.setxData(xData);
        YDataVo yDate = new YDataVo();
        yDate.setName(serName);
        yDate.setData(data);
        vo.getyDataVos().add(yDate);
        return vo;
    }

    @Override
    public List<Long[]> unMemberHistory(String statisticType, String shopId)
    {
        List<Long[]> result = new ArrayList<Long[]>();
        // RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_relevantUser);
        // RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_relevantUser);
        //Set<String> keys = database.keys("002_" + shopId + "*");
        List<String> listKeys = new ArrayList<String>();
        // listKeys.addAll(keys);
        Collections.sort(listKeys);
        String time = null;
        for (String key : listKeys)
        {
            time = key.split("_")[2];
            //  result.add(new Long[] { Long.parseLong(time), sortedSetDao.zcard(key) });
        }
        return result;
    }
}

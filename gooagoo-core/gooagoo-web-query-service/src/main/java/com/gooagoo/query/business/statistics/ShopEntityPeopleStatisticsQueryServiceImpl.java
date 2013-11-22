package com.gooagoo.query.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.query.business.statistics.common.ShopCommonOperate;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class ShopEntityPeopleStatisticsQueryServiceImpl implements ShopEntityPeopleStatisticsQueryService
{
    @Override
    public int findEntityPeopleNum(String shopEntityId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentNum(shopEntityId, userType, dao);
    }

    @Override
    public List<String> findEntityPeople(String shopEntityId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentPeople(shopEntityId, userType, dao);
    }

    @Override
    public int findEntityAreaPeopleNum(String areaId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentNum(areaId, userType, dao);
    }

    @Override
    public List<String> findEntityAreaPeople(String areaId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentPeople(areaId, userType, dao);
    }

    @Override
    public int findArriveEntityPeopleNum(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getNum(shopEntityId, dateType, userType, dateTime);
    }

    @Override
    public int findArriveEntityTimes(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getTimes(shopEntityId, dateType, userType, dateTime);
    }

    @Override
    public List<String> findArriveEntityPeople(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getPeople(shopEntityId, dateType, userType, dateTime);
    }

    @Override
    public int findArriveEntityAreaPeopleNum(String areaId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getNum(areaId, dateType, userType, dateTime);
    }

    @Override
    public int findArriveEntityAreaTimes(String areaId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getTimes(areaId, dateType, userType, dateTime);
    }

    @Override
    public List<String> findArriveEntityAreaPeople(String areaId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getPeople(areaId, dateType, userType, dateTime);
    }

}

package com.gooagoo.core.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.statistics.ShopPeopleStatisticsCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.core.business.statistics.common.utils.ShopCommonOperate;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class ShopPeopleStatisticsCoreServiceImpl implements ShopPeopleStatisticsCoreService
{

    @Override
    public int findAllEntityPeopleNum(String shopId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentNum(shopId, userType, dao);
    }

    @Override
    public List<String> findAllEntityPeople(String shopId, String userType)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        return ShopCommonOperate.getCurrentPeople(shopId, userType, dao);
    }

    @Override
    public int findArriveShopPeopleNum(String shopId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getNum(shopId, dateType, userType, dateTime);
    }

    @Override
    public int findArriveShopTimes(String shopId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getTimes(shopId, dateType, userType, dateTime);
    }

    @Override
    public List<String> findArriveShopPeople(String shopId, String dateType, String userType, Date dateTime)
    {
        return ShopCommonOperate.getPeople(shopId, dateType, userType, dateTime);
    }

    @Override
    public int findShopAddPeopleNum(String shopId, String userType, Date startTime, Date endTime)
    {
        return ShopCommonOperate.getMemberNum(shopId, userType, startTime, endTime);
    }

    @Override
    public List<String> findShopAddPeople(String shopId, String userType, Date startTime, Date endTime)
    {
        return ShopCommonOperate.getMemberPeople(shopId, userType, startTime, endTime);
    }

    @Override
    public int findShopUserNum(String shopId, String userType, Date dateTime)
    {
        return ShopCommonOperate.getMemberNum(shopId, userType, new Date(0), dateTime);
    }

    @Override
    public List<String> findShopPeople(String shopId, String userType, Date dateTime)
    {
        return ShopCommonOperate.getMemberPeople(shopId, userType, new Date(0), dateTime);
    }

}

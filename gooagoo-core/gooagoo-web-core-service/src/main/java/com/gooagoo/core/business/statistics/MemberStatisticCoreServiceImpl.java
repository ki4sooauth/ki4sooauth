package com.gooagoo.core.business.statistics;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.statistics.MemberStatisticCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.core.business.statistics.common.utils.Page;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class MemberStatisticCoreServiceImpl implements MemberStatisticCoreService
{

    @Override
    public Set<String> findAttention(String shopId, String Source, Integer pageIndex, Integer pageSize) throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_attention);
        Page page = new Page(pageIndex, pageSize);
        return sortedSetDao.getDesc(shopId + "_" + Source, page.getStart(), page.getEnd());

    }

    @Override
    public Set<String> findMember(String shopId, Integer pageIndex, Integer pageSize) throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_member);
        Page page = new Page(pageIndex, pageSize);
        return sortedSetDao.getDesc(shopId + "_M", page.getStart(), page.getEnd());
    }

    @Override
    public Integer countAttention(String shopId, String Source) throws Exception
    {
        RedisDatabase sortedSetDao = new RedisDatabase(RedisServerConstants.statistics_attention);
        return sortedSetDao.count().intValue();
    }

    @Override
    public Integer countMember(String shopId) throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_member);
        return new Long(sortedSetDao.zcard(shopId + "_M")).intValue();
    }

}

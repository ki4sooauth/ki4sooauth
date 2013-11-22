package com.gooagoo.query.business.marketing.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.cache.CryoutCacheQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 从缓存中查询吆喝相关信息
 */
@Service
public class CryoutCacheQueryServiceImpl implements CryoutCacheQueryService
{

    @Autowired
    MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;

    @Override
    public List<String> findUserCryout(String userId, int pageIndex, int pageMax) throws Exception
    {
        int start = (pageIndex - 1) * pageMax;
        int end = (pageIndex - 1) * pageMax + pageMax - 1;
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_cryout);
        List<String> result = new ArrayList<String>(dao.getDesc(userId, start, end));
        if (result == null || result.size() == 0)
        {
            this.initCache(userId);
            result = new ArrayList<String>(dao.getDesc(userId, start, end));
        }
        return result;
    }

    public void initCache(String userId)
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_cryout);
        int page = 1;
        int pageSize = 1000;
        MarketingUserLinkExample example = new MarketingUserLinkExample();
        example.createCriteria().andAccountTypeEqualTo("0").andAccountEqualTo(userId);
        while (true)
        {
            example.setPage(page, pageSize);
            List<MarketingUserLink> links = this.marketingUserLinkGeneratorQueryService.selectByExample(example);
            for (MarketingUserLink marketingUserLink : links)
            {
                dao.put(userId, marketingUserLink.getCTimeStamp().getTime(), marketingUserLink.getMarketingId());
            }
            page++;
            if (pageSize > links.size())
            {
                break;
            }
        }
    }
}

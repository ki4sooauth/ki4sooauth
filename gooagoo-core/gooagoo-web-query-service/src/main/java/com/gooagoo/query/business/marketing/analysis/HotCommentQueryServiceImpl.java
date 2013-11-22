package com.gooagoo.query.business.marketing.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.analysis.HotCommentQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.marketing.analysis.HotCommentGoods;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class HotCommentQueryServiceImpl implements HotCommentQueryService
{

    @Override
    public List<HotCommentGoods> hotComment(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        // TODO Auto-generated method stub
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        Set<String> desc = dao.getDesc("hotComment", pageIndex * pageSize, pageIndex * pageSize + pageIndex);
        List<HotCommentGoods> result = new ArrayList<HotCommentGoods>();
        for (String s : desc)
        {
            HotCommentGoods goods = new HotCommentGoods();
            goods.setShopId(s);
            result.add(goods);
        }
        return result;
    }
}

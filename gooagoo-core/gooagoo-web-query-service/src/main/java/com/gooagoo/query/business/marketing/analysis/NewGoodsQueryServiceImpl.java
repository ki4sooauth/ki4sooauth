package com.gooagoo.query.business.marketing.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.analysis.NewGoodsQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.marketing.analysis.NewGoods;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class NewGoodsQueryServiceImpl implements NewGoodsQueryService
{

    @Override
    public List<NewGoods> newGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        Set<String> set = dao.getDesc("newGoods", pageIndex * pageSize, pageIndex * pageSize + pageIndex);
        List<NewGoods> result = new ArrayList<NewGoods>();
        for (String s : set)
        {
            NewGoods goods = new NewGoods();
            goods.setShopId(s);
            result.add(goods);
        }

        return result;
    }
}

package com.gooagoo.query.business.marketing.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.analysis.HotSellersQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.marketing.analysis.HotSellerGoods;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class HotSellersQueryServiceImpl implements HotSellersQueryService
{

    @Override
    public List<HotSellerGoods> hotSeller(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        Set<String> desc = dao.getDesc("hotSale", pageIndex * pageSize, pageIndex * pageSize + pageIndex);
        List<HotSellerGoods> result = new ArrayList<HotSellerGoods>();
        for (String s : desc)
        {
            HotSellerGoods goods = new HotSellerGoods();
            goods.setShopId(s);
            result.add(goods);
        }
        return result;
    }
}

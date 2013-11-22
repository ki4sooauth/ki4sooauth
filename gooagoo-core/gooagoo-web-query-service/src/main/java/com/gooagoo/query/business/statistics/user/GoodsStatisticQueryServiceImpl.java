package com.gooagoo.query.business.statistics.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.user.GoodsStatisticQueryService;
import com.gooagoo.entity.business.goods.CrossGoods;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class GoodsStatisticQueryServiceImpl implements GoodsStatisticQueryService
{

    @Override
    public List<CrossGoods> queryGuessYouTastes(String account) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CrossGoods> queryHotComments() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CrossGoods> queryHotSales() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double findCommentNum(String key, String goodsId) throws Exception
    {
        RedisSortedSetDao redisSortedSetDao = new RedisSortedSetDao("statistics_hot");
        return redisSortedSetDao.getScore(key, goodsId);
    }
}

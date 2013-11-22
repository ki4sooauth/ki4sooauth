package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.statistics.BuyStatisticQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.query.business.statistics.common.GoodsCommonOperate;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class BuyStatisticQueryServiceImpl implements BuyStatisticQueryService
{
    @Autowired
    GoodsCacheQueryService goodsCacheQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Override
    public int goodsBuyTimes(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsSerialTimes(shopId + "_" + goodsSerialNo, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public List<String> goodsBuyPeople(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsSerialPoeple(shopId + "_" + goodsSerialNo, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public int categoryBuyTimes(String shopId, String categoryId, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsCategoryTimes(shopId + "_" + categoryId, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public List<String> categoryBuyPeople(String shopId, String categoryId, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsCategoryPoeple(shopId + "_" + categoryId, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public int brandBuyTimes(String shopId, String brandId, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsBrandTimes(shopId + "_" + brandId, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public List<String> brandBuyPeople(String shopId, String brandId, String dateType, String userType, Date dateTime)
    {
        return GoodsCommonOperate.goodsBrandPoeple(shopId + "_" + brandId, "P", dateType, userType, null, null, dateTime);
    }

    @Override
    public List<GoodsSalesRanking> areaSalesRanking(String positionId)
    {
        List<GoodsSalesRanking> result = new ArrayList<GoodsSalesRanking>();
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        Set<String> set = dao.getDesc(positionId, 0, 9);
        for (String s : set)
        {
            Map<String, String> goods = this.goodsCacheQueryService.findGoodsInfo(s);
            GoodsSalesRanking salesRanking = new GoodsSalesRanking();
            salesRanking.setGoodsId(s);
            salesRanking.setSales(String.valueOf(dao.getScore(positionId, s).intValue()));
            salesRanking.setCategoryLeafId(goods.get("goodsCategoryLeafId"));
            salesRanking.setCategoryLeafName(goods.get("goodsCategoryLeafName"));
            salesRanking.setGoodsName(goods.get("goodsName"));//商品名称
            salesRanking.setGoodsImg(goods.get("goodsImg"));//商品图片url
            salesRanking.setGoodsPrice(goods.get("price"));//商品价格
            salesRanking.setPositionName(goods.get("positionName"));//位置名称
            result.add(salesRanking);
        }
        return result;
    }

    @Override
    public List<GoodsSalesRanking> categorySalesRanking(String categoryId)
    {
        List<GoodsSalesRanking> result = new ArrayList<GoodsSalesRanking>();
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_categorySale);
        Set<String> set = dao.getDesc(categoryId, 0, 9);
        for (String s : set)
        {
            Map<String, String> goods = this.goodsCacheQueryService.findGoodsInfo(s);
            GoodsSalesRanking salesRanking = new GoodsSalesRanking();
            salesRanking.setGoodsId(s);
            salesRanking.setSales(String.valueOf(dao.getScore(categoryId, s).intValue()));
            salesRanking.setCategoryLeafId(goods.get("goodsCategoryLeafId"));
            salesRanking.setCategoryLeafName(goods.get("goodsCategoryLeafName"));
            salesRanking.setGoodsName(goods.get("goodsName"));//商品名称
            salesRanking.setGoodsImg(goods.get("goodsImg"));//商品图片url
            salesRanking.setGoodsPrice(goods.get("price"));//商品价格
            salesRanking.setPositionName(goods.get("positionName"));//位置名称
            result.add(salesRanking);
        }
        return result;
    }

    @Override
    @Deprecated
    public List<GoodsSalesRanking> salesRanking(String positionId, Integer pageIndex, Integer pageSize)
    {
        List<GoodsSalesRanking> result = new ArrayList<GoodsSalesRanking>();

        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_position);

        Set<String> set = sortedSetDao.getDesc(positionId, pageIndex, pageIndex + pageSize);
        for (String value : set)
        {
            GoodsSalesRanking salesRanking = new GoodsSalesRanking();
            salesRanking.setGoodsId(value);
            salesRanking.setSales(sortedSetDao.getScore(positionId, value).toString());
            //商品名称，商品价格
            GoodsBaseInfo goods = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(value);
            salesRanking.setGoodsName(goods.getGoodsName());
            salesRanking.setGoodsPrice(goods.getPrice().toString());
            goods = null;
            //位置名称
            Map<String, String> goodsInfo = redisHashDao.get(value);
            salesRanking.setPositionName(goodsInfo.get("name"));
            goodsInfo = null;

            result.add(salesRanking);
        }

        return result;
    }

    @Override
    public Set<String> consumptionNum(String shopId_D)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GoodsSalesRanking findSalesByGoodsId(String goodsId)
    {
        GoodsSalesRanking salesRanking = new GoodsSalesRanking();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        Double score = sortedSetDao.getScore("hotSale", goodsId);
        Map<String, String> goods = this.goodsCacheQueryService.findGoodsInfo(goodsId);
        salesRanking.setGoodsId(goodsId);//商品编号，UUID
        salesRanking.setPositionName(goods.get("positionName"));//位置名称
        salesRanking.setGoodsName(goods.get("goodsName"));//商品名称
        salesRanking.setCategoryLeafId(goods.get("goodsCategoryLeafId"));//品类编号（叶节点）
        salesRanking.setCategoryLeafName(goods.get("goodsCategoryLeafName"));//品类名称（叶节点）
        salesRanking.setGoodsImg(goods.get("goodsImg"));//商品图片url
        salesRanking.setGoodsPrice(goods.get("price"));//商品价格
        salesRanking.setSales(String.valueOf(score.intValue()));//销量
        return salesRanking;
    }
}

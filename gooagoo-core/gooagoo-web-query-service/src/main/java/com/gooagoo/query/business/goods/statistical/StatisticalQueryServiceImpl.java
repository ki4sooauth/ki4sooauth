package com.gooagoo.query.business.goods.statistical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.statistical.StatisticalQueryService;
import com.gooagoo.api.business.query.statistics.BuyStatisticQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.goods.GoodsProtectedQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.dao.business.goods.info.GoodsInfoAdapterMapper;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class StatisticalQueryServiceImpl implements StatisticalQueryService
{

    @Autowired
    private BuyStatisticQueryService buyStatisticQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private GoodsProtectedQueryService goodsProtectedQueryService;
    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;
    @Autowired
    private GoodsInfoAdapterMapper goodsInfoAdapterMapper;

    @Override
    public Integer purchasedGoods(String userId, String shopId, Date begin, Date end, String goodsName) throws Exception
    {
        return null;
        //        return this.orderInfoBusinessMapper.countPurchasedGoods(userId, shopId, begin, end, goodsName);
    }

    /**
     * 获取已购商品商家信息
     * @param shopInfoMap
     * @param shopId
     * @return
     */
    private ShopInfo getPurchasedShopInfo(Map<String, ShopInfo> shopInfoMap, String shopId)
    {
        ShopInfo shopInfo = shopInfoMap.get(shopId);
        if (shopInfo == null)
        {
            shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopId);
            if (shopInfo == null)
            {
                return null;
            }
            shopInfoMap.put(shopId, shopInfo);
        }

        return shopInfo;
    }

    @Override
    public List<GoodsSalesRanking> salesRanking(String shopId, String categoryId, String keyword, String positionId, Integer pageIndex, Integer pageSize) throws Exception
    {
        if (pageIndex != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        List<GoodsSalesRanking> goodsSalesRankingList = null;
        String shopEntityId = this.shopProtectedQueryService.getShopEntity(shopId, null);
        List<String> categoryIdList = this.goodsProtectedQueryService.findGoodsCategoryListByParent(shopEntityId, categoryId);
        List<String> goodsIdList = this.goodsInfoAdapterMapper.findGoodsInfoByCategory(shopId, keyword, positionId, categoryIdList, pageIndex, pageSize);
        if (CollectionUtils.isNotEmpty(goodsIdList))
        {
            goodsSalesRankingList = new ArrayList<GoodsSalesRanking>();
            for (String goodsId : goodsIdList)
            {
                GoodsSalesRanking goodsSalesRanking = this.buyStatisticQueryService.findSalesByGoodsId(goodsId);
                if (goodsSalesRanking != null)
                {
                    goodsSalesRankingList.add(goodsSalesRanking);
                }
            }
        }
        //根据销量排序
        this.bubblingOrderGoodsSalesRankingList(goodsSalesRankingList);
        return goodsSalesRankingList;
    }

    /**
     * 根据销量冒泡排序品类销售排行列表
     */
    private void bubblingOrderGoodsSalesRankingList(List<GoodsSalesRanking> goodsSalesRankingList)
    {
        if (CollectionUtils.isNotEmpty(goodsSalesRankingList))
        {
            for (int x = 0; x < goodsSalesRankingList.size() - 1; x++)
            {
                for (int y = x + 1; y < goodsSalesRankingList.size(); y++)
                {
                    GoodsSalesRanking frontGoodsSalesRanking = goodsSalesRankingList.get(x);
                    GoodsSalesRanking behindGoodsSalesRanking = goodsSalesRankingList.get(y);
                    if (StringUtils.hasText(frontGoodsSalesRanking.getSales()) && StringUtils.hasText(behindGoodsSalesRanking.getSales()) && Integer.parseInt(frontGoodsSalesRanking.getSales()) < Integer.parseInt(behindGoodsSalesRanking.getSales()))
                    {
                        GoodsSalesRanking item = frontGoodsSalesRanking;
                        goodsSalesRankingList.set(x, behindGoodsSalesRanking);
                        goodsSalesRankingList.set(y, item);
                    }
                }
            }
        }
    }
}

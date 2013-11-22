package com.gooagoo.query.business.marketing.shopintegral;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.shopintegral.ShopIntegralQueryService;
import com.gooagoo.api.business.query.statistics.ExchangeStatisticQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.TradeRequest;
import com.gooagoo.entity.business.marketing.TradeResponse;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample.Criteria;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;

@Service
public class ShopIntegralQueryServiceImpl implements ShopIntegralQueryService
{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private ShopIntegralGeneratorQueryService shopIntegralGeneratorQueryService;
    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private ExchangeStatisticQueryService exchangeStatisticQueryService;

    @Override
    @SuppressWarnings("unchecked")
    public List<TradeResponse> findTradeList(TradeRequest tradeRequest) throws Exception
    {
        //1、校验用户编号
        if (StringUtils.isBlank(tradeRequest.getUserId()))
        {
            GooagooLog.info("兑换物品列表（分页、排序）：用户编号（" + tradeRequest.getUserId() + "）为空");
            return new ArrayList<TradeResponse>();
        }
        //2、获取查询兑换物品需要的商家限制条件
        Map<String, Object> shopData = this.getShopDataForTrade(tradeRequest.getShopId());
        if (shopData == null)
        {
            return new ArrayList<TradeResponse>();
        }
        Map<String, ShopInfo> shopInfoMap = (Map<String, ShopInfo>) shopData.get("shopInfoMap");
        List<String> shopIdList = (List<String>) shopData.get("shopIdList");
        //3、获取满足条件的兑换物品
        List<ShopIntegral> shopIntegralList = this.getShopIntegralList(tradeRequest, shopIdList);
        if (shopIntegralList == null)
        {
            return new ArrayList<TradeResponse>();
        }
        //4、组装返回数据
        Map<String, Integer> integralInfoMap = new HashMap<String, Integer>();
        List<TradeResponse> tradeResponseList = new ArrayList<TradeResponse>();
        for (ShopIntegral shopIntegral : shopIntegralList)
        {
            TradeResponse tradeResponse = new TradeResponse();
            if ("C".equals(shopIntegral.getIntegralTradeType()))
            {
                //4.1、获取优惠凭证兑换信息
                tradeResponse = this.getCouponTradeList(tradeResponse, shopIntegral.getIntegralTradeId());
            }
            else if ("G".equals(shopIntegral.getIntegralTradeType()))
            {
                //4.2、获取商品兑换信息
                tradeResponse = this.getGoodsTradeList(tradeResponse, shopIntegral.getIntegralTradeId());
            }
            if (tradeResponse == null)
            {
                continue;
            }
            //4.3、获取用户在商家中的可用积分
            Integer useableIntegralNumber = integralInfoMap.get(tradeRequest.getUserId() + "_" + shopIntegral.getShopId());
            if (useableIntegralNumber == null)
            {
                tradeResponse.setUseableIntegralNumber(this.getUseableIntegralNumber(tradeRequest.getUserId(), shopIntegral.getShopId()));
                integralInfoMap.put(tradeRequest.getUserId() + "_" + shopIntegral.getShopId(), tradeResponse.getUseableIntegralNumber());
            }
            else
            {
                tradeResponse.setUseableIntegralNumber(useableIntegralNumber);
            }
            //优惠凭证被兑换次数
            tradeResponse.setConvertCount(this.exchangeStatisticQueryService.marketingTimes(shopIntegral.getShopIntegralId()));
            tradeResponse.setShopId(shopIntegral.getShopId());
            tradeResponse.setShopName(shopInfoMap.get(shopIntegral.getShopId()).getShopName());
            tradeResponse.setType(shopIntegral.getIntegralTradeType());
            tradeResponse.setTypeId(shopIntegral.getIntegralTradeId());
            tradeResponse.setShopIntegralId(shopIntegral.getShopIntegralId());
            tradeResponse.setConvertIntegralValue(shopIntegral.getTradeIntegralValue());
            tradeResponseList.add(tradeResponse);
        }

        return tradeResponseList;
    }

    @Override
    public boolean findShopIntegralConvert(String parameter) throws Exception
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean findIntegralSpecialApproval(String parameter) throws Exception
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 获取查询兑换物品需要的商家限制条件
     * @param shopId
     * @return
     */
    private Map<String, Object> getShopDataForTrade(String shopId)
    {
        Map<String, ShopInfo> shopInfoMap = new HashMap<String, ShopInfo>();
        List<String> shopIdList = new ArrayList<String>();
        if (StringUtils.isBlank(shopId))
        {
            ShopInfoExample queryCondition = new ShopInfoExample();
            queryCondition.createCriteria().andShopStatusEqualTo("U").andIsDelEqualTo("N");
            List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(shopInfoList))
            {
                GooagooLog.info("获取查询兑换物品需要的商家限制条件：未有正常营业的商家");
                return null;
            }
            for (ShopInfo shopInfo : shopInfoList)
            {
                shopInfoMap.put(shopInfo.getShopId(), shopInfo);
                shopIdList.add(shopInfo.getShopId());
            }
        }
        else
        {
            ShopInfoExample queryCondition = new ShopInfoExample();
            queryCondition.createCriteria().andShopIdEqualTo(shopId).andShopStatusEqualTo("U").andIsDelEqualTo("N");
            List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(shopInfoList))
            {
                GooagooLog.info("获取查询兑换物品需要的商家限制条件：商家（" + shopId + "）非正常营业的商家");
                return null;
            }
            for (ShopInfo shopInfo : shopInfoList)
            {
                shopInfoMap.put(shopInfo.getShopId(), shopInfo);
                shopIdList.add(shopInfo.getShopId());
            }
        }
        Map<String, Object> shopData = new HashMap<String, Object>();
        shopData.put("shopInfoMap", shopInfoMap);
        shopData.put("shopIdList", shopIdList);

        return shopData;
    }

    /**
     * 获取满足条件的兑换物品
     * @param tradeRequest
     * @param shopIdList
     * @return
     */
    private List<ShopIntegral> getShopIntegralList(TradeRequest tradeRequest, List<String> shopIdList)
    {
        Date currentTime = new Date();
        ShopIntegralExample queryCondition = new ShopIntegralExample();
        Criteria criteria = queryCondition.createCriteria().andShopIdIn(shopIdList).andIsDelEqualTo("N");
        if (tradeRequest.getType() != null)
        {
            criteria.andIntegralTradeTypeEqualTo(tradeRequest.getType());
        }
        if (tradeRequest.getIntegralValueMin() != null)
        {
            criteria.andTradeIntegralValueGreaterThanOrEqualTo(tradeRequest.getIntegralValueMin());
        }
        if (tradeRequest.getIntegralValueMax() != null)
        {
            criteria.andTradeIntegralValueLessThanOrEqualTo(tradeRequest.getIntegralValueMax());
        }
        criteria.andTradeStartTimeLessThanOrEqualTo(currentTime).andTradeEndTimeGreaterThanOrEqualTo(currentTime);
        queryCondition.setPage(tradeRequest.getPageIndex(), tradeRequest.getPageSize());
        queryCondition.setOrderByClause(tradeRequest.getOrderByClause());
        List<ShopIntegral> shopIntegralList = this.shopIntegralGeneratorQueryService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(shopIntegralList))
        {
            GooagooLog.info("获取满足条件的兑换物品：未查询到满足条件的兑换物品");
            return null;
        }

        return shopIntegralList;
    }

    /**
     * 获取优惠凭证兑换信息
     * @param tradeResponse
     * @param couponId
     * @return
     */
    private TradeResponse getCouponTradeList(TradeResponse tradeResponse, String couponId)
    {
        Coupon coupon = this.couponGeneratorQueryService.selectByPrimaryKey(couponId);
        if (coupon == null)
        {
            GooagooLog.info("获取优惠凭证兑换信息：优惠凭证（" + couponId + "）不存在或已被删除");
            return null;
        }
        tradeResponse.setTypeName(coupon.getCouponName());
        tradeResponse.setTypeImageUrl(coupon.getCouponUrl());

        return tradeResponse;
    }

    /**
     * 获取商品兑换信息
     * @param tradeResponse
     * @param goodsId
     * @return
     */
    private TradeResponse getGoodsTradeList(TradeResponse tradeResponse, String goodsId)
    {
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null)
        {
            GooagooLog.info("获取商品兑换信息：商品（" + goodsId + "）不存在或已被删除");
            return null;
        }
        tradeResponse.setTypeName(goodsBaseInfo.getGoodsName());
        GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
        if (goodsMarketingInfo != null && goodsMarketingInfo.getGoodsImg() != null)
        {
            tradeResponse.setTypeImageUrl(goodsMarketingInfo.getGoodsImg().split(",")[0]);
        }

        return tradeResponse;
    }

    /**
     * 获取用户在商家中的可用积分
     * @param userId
     * @param shopId
     * @return
     */
    private Integer getUseableIntegralNumber(String userId, String shopId)
    {
        IntegralInfoExample queryCondition = new IntegralInfoExample();
        queryCondition.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<IntegralInfo> integralInfoList = this.integralInfoGeneratorQueryService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(integralInfoList) || integralInfoList.size() != 1)
        {
            GooagooLog.info("获取用户在商家中的可用积分：用户（" + userId + "）在商家（" + shopId + "）中的积分不存在或存在异常");
            return 0;
        }

        return integralInfoList.get(0).getUseableIntegralNumber();
    }

}

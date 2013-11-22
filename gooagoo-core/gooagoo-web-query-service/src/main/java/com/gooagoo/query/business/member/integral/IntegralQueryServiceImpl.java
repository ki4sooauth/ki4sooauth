package com.gooagoo.query.business.member.integral;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralConvertGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.member.IntegralConvertDetail;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample.Criteria;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.exception.common.NullException;

@Service
public class IntegralQueryServiceImpl implements IntegralQueryService
{

    @Autowired
    IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;
    @Autowired
    private ShopIntegralConvertGeneratorQueryService shopIntegralConvertGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoGeneratorQueryService;
    @Autowired
    private ShopIntegralGeneratorQueryService shopIntegralGeneratorQueryService;

    @Override
    public String findIntegral(String userId, String shopId) throws Exception
    {
        IntegralInfoExample integralInfoExample = new IntegralInfoExample();
        integralInfoExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId);
        List<IntegralInfo> integralInfoList = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
        if (CollectionUtils.isNotEmpty(integralInfoList))
        {
            Integer useableIntegralNumber = integralInfoList.get(0).getUseableIntegralNumber();
            return useableIntegralNumber != null ? useableIntegralNumber.toString() : null;
        }
        return null;
    }

    @Override
    public List<IntegralConvertDetail> findIntegralExchange(String userId, String shopId, Date startConvertTime, Date endConvertTime, String integralTradeType, Integer pageIndex, Integer pageSize, String orderBy) throws Exception
    {
        //1、校验用户编号
        if (StringUtils.isBlank(userId))
        {
            GooagooLog.info("查询兑换记录列表（分页、排序）：用户编号（" + userId + "）为空");
            throw new NullException("用户编号（" + userId + "）为空");
        }
        //2、获取满足条件的兑换记录
        List<ShopIntegralConvert> shopIntegralConvertList = this.getShopIntegralConvertList(userId, shopId, startConvertTime, endConvertTime, integralTradeType, pageIndex, pageSize, orderBy);
        if (CollectionUtils.isEmpty(shopIntegralConvertList))
        {
            return null;
        }
        //3、组装返回数据
        List<IntegralConvertDetail> integralConvertDetailList = new ArrayList<IntegralConvertDetail>();
        Map<String, ShopInfo> shopInfoMap = new HashMap<String, ShopInfo>();
        Map<String, GoodsBaseInfo> goodsBaseInfoMap = new HashMap<String, GoodsBaseInfo>();
        Map<String, GoodsMarketingInfo> goodsMarketingInfoMap = new HashMap<String, GoodsMarketingInfo>();
        Map<String, Coupon> couponMap = new HashMap<String, Coupon>();
        Map<String, ConsigneeInfo> consigneeInfoMap = new HashMap<String, ConsigneeInfo>();
        for (ShopIntegralConvert shopIntegralConvert : shopIntegralConvertList)
        {
            //3.1、获取商家信息
            ShopInfo shopInfo = shopInfoMap.get(shopIntegralConvert.getShopId());
            if (shopInfo == null)
            {
                shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopIntegralConvert.getShopId());
                if (shopInfo == null)
                {
                    GooagooLog.info("查询兑换记录列表（分页、排序）：商家（" + shopIntegralConvert.getShopId() + "）不存在");
                    continue;
                }
                shopInfoMap.put(shopIntegralConvert.getShopId(), shopInfo);
            }
            //3.2、获取收货地址、商品基本信息、商品营销信息、优惠凭证信息
            ConsigneeInfo consigneeInfo = null;
            GoodsBaseInfo goodsBaseInfo = null;
            GoodsMarketingInfo goodsMarketingInfo = null;
            Coupon coupon = null;
            if ("G".equals(shopIntegralConvert.getIntegralTradeType()))
            {
                consigneeInfo = consigneeInfoMap.get(shopIntegralConvert.getConsigneeId());
                if (consigneeInfo == null)
                {
                    consigneeInfo = this.consigneeInfoGeneratorQueryService.selectByPrimaryKey(shopIntegralConvert.getConsigneeId());
                    if (consigneeInfo == null)
                    {
                        GooagooLog.info("查询兑换记录列表（分页、排序）：收货地址（" + shopIntegralConvert.getConsigneeId() + "）不存在");
                        continue;
                    }
                    consigneeInfoMap.put(shopIntegralConvert.getConsigneeId(), consigneeInfo);
                }
                goodsBaseInfo = goodsBaseInfoMap.get(shopIntegralConvert.getIntegralTradeId());
                if (goodsBaseInfo == null)
                {
                    goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(shopIntegralConvert.getIntegralTradeId());
                    if (goodsBaseInfo == null)
                    {
                        GooagooLog.info("查询兑换记录列表（分页、排序）：商品基本信息（" + shopIntegralConvert.getIntegralTradeId() + "）不存在");
                        continue;
                    }
                    goodsBaseInfoMap.put(shopIntegralConvert.getIntegralTradeId(), goodsBaseInfo);
                }
                goodsMarketingInfo = goodsMarketingInfoMap.get(shopIntegralConvert.getIntegralTradeId());
                if (goodsMarketingInfo == null)
                {
                    goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(shopIntegralConvert.getIntegralTradeId());
                    if (goodsMarketingInfo == null)
                    {
                        GooagooLog.info("查询兑换记录列表（分页、排序）：商品营销信息（" + shopIntegralConvert.getIntegralTradeId() + "）不存在");
                    }
                    else
                    {
                        goodsMarketingInfoMap.put(shopIntegralConvert.getIntegralTradeId(), goodsMarketingInfo);
                    }
                }
            }
            else
            {
                coupon = couponMap.get(shopIntegralConvert.getIntegralTradeId());
                if (coupon == null)
                {
                    coupon = this.couponGeneratorQueryService.selectByPrimaryKey(shopIntegralConvert.getIntegralTradeId());
                    if (coupon == null)
                    {
                        GooagooLog.info("查询兑换记录列表（分页、排序）：优惠凭证信息（" + shopIntegralConvert.getIntegralTradeId() + "）不存在");
                        continue;
                    }
                    couponMap.put(shopIntegralConvert.getIntegralTradeId(), coupon);
                }
            }
            //3.3、组装数据
            IntegralConvertDetail integralConvertDetail = new IntegralConvertDetail();
            integralConvertDetail.setShopIntegralConvert(shopIntegralConvert);
            integralConvertDetail.setShopInfo(shopInfo);
            integralConvertDetail.setGoodsBaseInfo(goodsBaseInfo);
            integralConvertDetail.setGoodsMarketingInfo(goodsMarketingInfo);
            integralConvertDetail.setCoupon(coupon);
            integralConvertDetail.setConsigneeInfo(consigneeInfo);
            integralConvertDetailList.add(integralConvertDetail);
        }

        return integralConvertDetailList;
    }

    @Override
    public ShopIntegral findConvertShopIntegral(String shopIntegralId, String integralTradeId) throws Exception
    {
        ShopIntegralExample shopIntegralExample = new ShopIntegralExample();
        if (StringUtils.isNotBlank(shopIntegralId))
        {
            shopIntegralExample.createCriteria().andShopIntegralIdEqualTo(shopIntegralId).andIsDelEqualTo("N");
        }
        else
        {
            Date currentTime = new Date();
            shopIntegralExample.createCriteria().andIntegralTradeIdEqualTo(integralTradeId).andTradeStartTimeLessThanOrEqualTo(currentTime).andTradeEndTimeGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N");
        }
        shopIntegralExample.setOrderByClause("c_time_stamp DESC");
        List<ShopIntegral> shopIntegralList = this.shopIntegralGeneratorQueryService.selectByExample(shopIntegralExample);
        return CollectionUtils.isNotEmpty(shopIntegralList) ? shopIntegralList.get(0) : null;
    }

    /**
     * 获取满足条件的兑换记录
     * @param userId
     * @param shopId
     * @param startConvertTime
     * @param endConvertTime
     * @param integralTradeType
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @return
     */
    private List<ShopIntegralConvert> getShopIntegralConvertList(String userId, String shopId, Date startConvertTime, Date endConvertTime, String integralTradeType, Integer pageIndex, Integer pageSize, String orderBy)
    {
        ShopIntegralConvertExample queryCondition = new ShopIntegralConvertExample();
        Criteria criteria = queryCondition.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.isNotBlank(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        if (StringUtils.isBlank(integralTradeType))
        {
            List<String> integralTradeTypeList = new ArrayList<String>();
            integralTradeTypeList.add("C");
            integralTradeTypeList.add("G");
            criteria.andIntegralTradeTypeIn(integralTradeTypeList);
        }
        else
        {
            criteria.andIntegralTradeTypeEqualTo(integralTradeType);
        }
        if (startConvertTime != null)
        {
            criteria.andConvertTimeGreaterThanOrEqualTo(startConvertTime);
        }
        if (endConvertTime != null)
        {
            criteria.andConvertTimeLessThanOrEqualTo(endConvertTime);
        }
        criteria.andIsDelEqualTo("N");
        queryCondition.setPage(pageIndex, pageSize);
        queryCondition.setOrderByClause(orderBy);
        List<ShopIntegralConvert> shopIntegralConvertList = this.shopIntegralConvertGeneratorQueryService.selectByExample(queryCondition);

        return shopIntegralConvertList;
    }

}

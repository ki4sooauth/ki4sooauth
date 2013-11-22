package com.gooagoo.igms.marketing.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.marketing.service.IntegralService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FShopIntegral;
import com.google.gson.Gson;

@Service(value = "integralService")
public class IntegralServiceImpl implements IntegralService
{

    @Autowired
    private IntegralCoreService integralCoreService;
    @Autowired
    private ShopIntegralGeneratorQueryService shopIntegralGeneratorQueryService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;

    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        FShopIntegral integralConvert = ServletUtils.objectMethod(FShopIntegral.class, request);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        integralConvert.setId(com.gooagoo.common.utils.StringUtils.getUUID());
        integralConvert.setShopId(shopId);

        //将时间设置成午夜12点
        Date ds = GMSUtil.getEarlyMorning(integralConvert.getConvertStartTime());
        Date de = GMSUtil.getMidNight(integralConvert.getConvertEndTime());
        integralConvert.setConvertStartTime(ds);
        integralConvert.setConvertEndTime(de);

        ShopIntegral shopIntegral = this.convertToIntegralInfo(integralConvert);
        shopIntegral.setCreateTime(new Date());
        boolean result = this.checkShopIntegral(shopIntegral);
        if (result)
        {
            result = this.integralCoreService.addIntegralExchange(shopIntegral);
        }

        TransData<Object> data = GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);

        data.setData(shopIntegral.getShopIntegralId());

        return data;
    }

    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        FShopIntegral integralConvert = ServletUtils.objectMethod(FShopIntegral.class, request);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        integralConvert.setShopId(shopId);
        //将时间设置成午夜12点
        Date ds = GMSUtil.getEarlyMorning(integralConvert.getConvertStartTime());
        Date de = GMSUtil.getMidNight(integralConvert.getConvertEndTime());
        integralConvert.setConvertStartTime(ds);
        integralConvert.setConvertEndTime(de);

        ShopIntegral shopIntegral = this.convertToIntegralInfo(integralConvert);
        boolean result = this.checkShopIntegral(shopIntegral);
        if (result)
        {
            result = this.integralCoreService.updateIntegralExchange(shopIntegral);
        }

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.integralCoreService.deleteIntegralExchange(id);
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<FShopIntegral> getIntegralConvert(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "integralId", "");

        ShopIntegral shopIntegral = this.shopIntegralGeneratorQueryService.selectByPrimaryKey(id);

        FShopIntegral fs = this.convertFShopIntegral(shopIntegral);

        return new TransData<FShopIntegral>(true, MessageConst.GMS_OPERATE_SUCCESS, fs);
    }

    @Override
    public TransData<PageModel<FShopIntegral>> pageIntegralConvert(HttpServletRequest request) throws Exception
    {
        FShopIntegral integralConvert = ServletUtils.objectMethod(FShopIntegral.class, request);
        String startConvert = ServletRequestUtils.getStringParameter(request, "startConvert", "");
        String endConvert = ServletRequestUtils.getStringParameter(request, "endConvert", "");
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        integralConvert.setShopId(shopId);
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        if (condition.getPageSize() == 0)
        {
            condition.setPageSize(10);
        }
        PageModel<FShopIntegral> pm = new PageModel<FShopIntegral>();
        pm.setPageIndex(condition.getPageIndex());
        pm.setPageSize(condition.getPageSize());
        ShopIntegralExample example = new ShopIntegralExample();
        example.setPage(pm.getIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");

        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);

        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(startConvert))
        {
            criteria.andTradeIntegralValueGreaterThanOrEqualTo(startConvert);
        }
        if (org.springframework.util.StringUtils.hasText(endConvert))
        {
            criteria.andTradeIntegralValueLessThanOrEqualTo(endConvert);
        }
        if (org.springframework.util.StringUtils.hasText(integralConvert.getConvertType()))
        {
            criteria.andIntegralTradeTypeEqualTo(integralConvert.getConvertType());
        }

        int count = this.shopIntegralGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<ShopIntegral> list = this.shopIntegralGeneratorQueryService.selectByExample(example);
            for (ShopIntegral s : list)
            {
                pm.getResult().add(this.convertFShopIntegral(s));
            }
        }

        return new TransData<PageModel<FShopIntegral>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    private FShopIntegral convertFShopIntegral(ShopIntegral shopIntegral)
    {
        FShopIntegral integralConvert = null;
        if (shopIntegral != null)
        {
            integralConvert = new FShopIntegral();
            integralConvert.setId(shopIntegral.getShopIntegralId());
            integralConvert.setShopId(shopIntegral.getShopId());
            integralConvert.setConvertType(shopIntegral.getIntegralTradeType());
            integralConvert.setConvertObjectId(shopIntegral.getIntegralTradeId());
            integralConvert.setConvertNums(shopIntegral.getConvertNums());
            integralConvert.setConvertValue(shopIntegral.getTradeIntegralValue());
            integralConvert.setConvertStartTime(shopIntegral.getTradeStartTime());
            integralConvert.setConvertEndTime(shopIntegral.getTradeEndTime());
            //1-商品
            if (integralConvert.getConvertType().equals("G") && org.springframework.util.StringUtils.hasText(integralConvert.getConvertObjectId()))
            {

                GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(integralConvert.getConvertObjectId());

                if (goodsBaseInfo != null)
                {
                    integralConvert.setConvertObjectName(goodsBaseInfo.getGoodsName());
                }

                //有些地方需要用图片URL
                GoodsMarketingInfo gm = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(integralConvert.getConvertObjectId());
                if (gm != null && org.springframework.util.StringUtils.hasText(gm.getGoodsImg()))
                {
                    List list = this.jsonToString(gm.getGoodsImg());
                    if (list.size() > 0)
                    {
                        integralConvert.setImgUrl(String.valueOf(list.get(0)));
                    }

                }
            }
            else
            {
                // 2-优惠凭证
                Coupon coupon = this.couponGeneratorQueryService.selectByPrimaryKey(integralConvert.getConvertObjectId());
                if (coupon != null)
                {
                    integralConvert.setConvertObjectName(coupon.getCouponName());
                }
            }
        }
        return integralConvert;
    }

    private ShopIntegral convertToIntegralInfo(FShopIntegral integralConvert)
    {
        ShopIntegral shopIntegral = null;
        if (integralConvert != null)
        {
            shopIntegral = new ShopIntegral();

            shopIntegral.setShopIntegralId(integralConvert.getId());
            shopIntegral.setShopId(integralConvert.getShopId());
            shopIntegral.setIntegralTradeId(integralConvert.getConvertObjectId());
            shopIntegral.setIntegralTradeType(integralConvert.getConvertType());
            shopIntegral.setTradeIntegralValue(integralConvert.getConvertValue());
            shopIntegral.setTradeStartTime(integralConvert.getConvertStartTime());
            shopIntegral.setTradeEndTime(integralConvert.getConvertEndTime());
            shopIntegral.setCTimeStamp(new Date());
            shopIntegral.setConvertNums(integralConvert.getConvertNums());
            shopIntegral.setIsDel("N");
        }
        return shopIntegral;
    }

    private boolean checkShopIntegral(ShopIntegral shopIntegral)
    {

        if (shopIntegral == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(shopIntegral.getShopIntegralId()) || shopIntegral.getShopIntegralId().length() != 32)
        {
            return false;
        }
        if (!this.checkInt(String.valueOf(shopIntegral.getTradeIntegralValue())))
        {
            return false;
        }

        if (!this.checkInt(String.valueOf(shopIntegral.getConvertNums())))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(String.valueOf(shopIntegral.getTradeStartTime())) || TimeUtils.dateDiff(3, shopIntegral.getTradeStartTime(), new Date()) > 0)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(String.valueOf(shopIntegral.getTradeEndTime())) || TimeUtils.dateDiff(3, shopIntegral.getTradeEndTime(), shopIntegral.getTradeStartTime()) > 0)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(shopIntegral.getIntegralTradeId()) || org.apache.commons.lang.StringUtils.isBlank(shopIntegral.getIntegralTradeType()))
        {
            return false;
        }
        return true;
    }

    private boolean checkInt(String str)
    {
        if (StringUtils.hasText(str))
        {
            return str.matches("^[0-9]*$");
        }
        else
        {
            return false;
        }
    }

    //json转list
    private List jsonToString(String str)
    {
        if (!org.springframework.util.StringUtils.hasText(str))
        {
            return null;
        }
        Gson gson = new Gson();
        List<String> list = gson.fromJson(str, List.class);

        return list;
    }
}

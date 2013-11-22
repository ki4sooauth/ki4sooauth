package com.gooagoo.igus.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.business.query.marketing.shopintegral.ShopIntegralQueryService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.cache.AreaCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.TradeRequest;
import com.gooagoo.entity.business.marketing.TradeResponse;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.exception.business.integral.IntegralNotEnoughException;
import com.gooagoo.igus.mall.service.IMallService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.mall.UConsigeeInfo;
import com.gooagoo.view.gus.web.mall.UShopIntegral;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("iMallService")
public class IMallServiceImpl implements IMallService
{

    @Autowired
    private IntegralCoreService integralCoreService;

    @Autowired
    private ShopIntegralQueryService shopIntegralQueryService;

    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoService;

    @Autowired
    private DeliveryAddressCoreService deliveryAddressCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.MALL_MALL_GETCONVERTTHINGLIST)
    public TransData<Object> getConvertThingList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String type = ServletRequestUtils.getStringParameter(request, "type");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", "c_time_stamp desc");
            TradeRequest tradeRequest = new TradeRequest();
            tradeRequest.setUserId(userId);
            tradeRequest.setShopId(shopId);
            tradeRequest.setType(type);
            tradeRequest.setPageIndex(pageIndex);
            tradeRequest.setPageSize(pageSize);
            tradeRequest.setOrderByClause(orderBy);
            List<TradeResponse> tradeResponseList = this.shopIntegralQueryService.findTradeList(tradeRequest);
            if (CollectionUtils.isEmpty(tradeResponseList))
            {
                GooagooLog.info("获取积分兑换物列表：查询积分兑换物列表为空");
                return new TransData<Object>(true, MessageConst.MOBILE_IMOBILEMERCHANT_GETINTEGRALMALLDATA_NOTEXIST, null);
            }
            List<UShopIntegral> ushopIntegralList = new ArrayList<UShopIntegral>();
            for (TradeResponse tradeResponse : tradeResponseList)
            {
                try
                {
                    UShopIntegral ushopIntegral = new UShopIntegral();
                    ushopIntegral.setShopId(tradeResponse.getShopId());
                    ushopIntegral.setShopName(tradeResponse.getShopName());
                    ushopIntegral.setType(tradeResponse.getType());
                    ushopIntegral.setTypeId(tradeResponse.getTypeId());
                    ushopIntegral.setTypeName(tradeResponse.getTypeName());
                    if ("G".equals(tradeResponse.getType()))
                    {
                        if (StringUtils.isNotBlank(tradeResponse.getTypeImageUrl()))
                        {
                            List<String> imgs = new Gson().fromJson(tradeResponse.getTypeImageUrl(), new TypeToken<List<String>>()
                            {
                            }.getType());
                            ushopIntegral.setTypeImageUrl(FormatDataUtils.formatImageInfo(imgs.get(0)));
                        }
                        ushopIntegral.setTypeVisitUrl(UrlUtils.getGoodsUrl(tradeResponse.getTypeId()));
                    }
                    else if ("C".equals(tradeResponse.getType()))
                    {
                        ushopIntegral.setTypeImageUrl(FormatDataUtils.formatImageInfo(tradeResponse.getTypeImageUrl()));
                        ushopIntegral.setTypeVisitUrl(UrlUtils.getCouponUrl(tradeResponse.getTypeId()));
                    }
                    ushopIntegral.setShopIntegralId(tradeResponse.getShopIntegralId());
                    ushopIntegral.setConvertIntegralValue(tradeResponse.getConvertIntegralValue());
                    ushopIntegral.setUseableIntegralNumber(tradeResponse.getUseableIntegralNumber());
                    ushopIntegral.setConvertCount(tradeResponse.getConvertCount());
                    ushopIntegralList.add(ushopIntegral);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取积分兑换物列表：组装单个积分兑换物信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushopIntegralList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取积分兑换物列表：获取积分兑换物列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.MALL_MALL_INTEGRALCONVERT)
    public TransData<Object> integralConvert(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        String consigneeId = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);//用户ID
            ShopIntegralConvert shopIntegralConvert = ServletUtils.objectMethod(ShopIntegralConvert.class, request);
            if ("G".equals(shopIntegralConvert.getIntegralTradeType()))
            {
                ConsigneeInfo consigneeInfo = ServletUtils.objectMethod(ConsigneeInfo.class, request);
                consigneeInfo.setUserId(userId);
                if (StringUtils.isBlank(consigneeInfo.getConsigneeId()))
                {
                    consigneeInfo.setConsigneeId(UUID.getUUID());
                    if (!this.deliveryAddressCoreService.addDeliveryAddress(consigneeInfo))
                    {
                        GooagooLog.info("积分兑换：新增收货地址失败（" + consigneeInfo.toString() + "）");
                        return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, null);
                    }
                }
                consigneeId = consigneeInfo.getConsigneeId();
                shopIntegralConvert.setConsigneeId(consigneeInfo.getConsigneeId());
            }
            shopIntegralConvert.setUserId(userId);
            shopIntegralConvert.setInfoSource("W");
            if (!this.integralCoreService.integralExchangeGoods(shopIntegralConvert))
            {
                GooagooLog.info("积分兑换：积分兑换失败（" + shopIntegralConvert.toString() + "）");
                return new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, consigneeId);
            }
            transData = new TransData<Object>(true, MessageConst.MALL_IMALL_INTEGRALCONVERT_SUCCESS, consigneeId);
        }
        catch (IntegralNotEnoughException e)
        {
            GooagooLog.error("积分兑换：积分不足异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT__LACKOFINTEGRATION, consigneeId);
        }
        catch (Exception e)
        {
            GooagooLog.error("积分兑换：处理积分兑换异常", e);
            transData = new TransData<Object>(false, MessageConst.MALL_IMALL_INTEGRALCONVERT_FAIL, consigneeId);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.MALL_MALL_GETSHIPPINGADDRESSLIST)
    public TransData<Object> getShippingAddressList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //传递userId执行查询 
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            ConsigneeInfoExample consInfoExample = new ConsigneeInfoExample();
            consInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoService.selectByExample(consInfoExample);
            if (CollectionUtils.isEmpty(consigneeInfoList))
            {
                GooagooLog.info("查询用户收货地址列表：没有查到该用户的收货地址");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            List<UConsigeeInfo> uconsigeeInfoList = new ArrayList<UConsigeeInfo>();
            for (ConsigneeInfo consigneeInfo : consigneeInfoList)
            {
                try
                {
                    UConsigeeInfo uconsigeeInfo = new UConsigeeInfo();
                    uconsigeeInfo.setAddress(consigneeInfo.getAddress());
                    uconsigeeInfo.setUserId(consigneeInfo.getUserId());
                    uconsigeeInfo.setTelephone(consigneeInfo.getTelephone());
                    uconsigeeInfo.setConsigneeId(consigneeInfo.getConsigneeId());
                    uconsigeeInfo.setConsigneeName(consigneeInfo.getConsigneeName());
                    uconsigeeInfo.setIsDefault(consigneeInfo.getIsDefault());
                    uconsigeeInfo.setPhone(consigneeInfo.getPhone());
                    uconsigeeInfo.setPostCode(consigneeInfo.getPostCode());
                    uconsigeeInfo.setAreaId(consigneeInfo.getArea());
                    uconsigeeInfo.setAreaName(AreaCache.getSelf(consigneeInfo.getArea()));
                    uconsigeeInfo.setCityId(consigneeInfo.getCity());
                    uconsigeeInfo.setCityName(AreaCache.getSelf(consigneeInfo.getCity()));
                    uconsigeeInfo.setProvinceId(consigneeInfo.getProvince());
                    uconsigeeInfo.setProvinceName(AreaCache.getSelf(consigneeInfo.getProvince()));
                    uconsigeeInfoList.add(uconsigeeInfo);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询用户收货地址列表：组装单个用户收货地址信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uconsigeeInfoList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询用户收货地址列表:查询用户收货地址列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

}

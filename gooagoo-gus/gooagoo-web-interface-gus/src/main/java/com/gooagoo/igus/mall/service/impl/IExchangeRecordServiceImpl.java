package com.gooagoo.igus.mall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.member.IntegralConvertDetail;
import com.gooagoo.igus.mall.service.IExchangeRecordService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.mall.UExchangeRecord;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("iExchangeRecordService")
public class IExchangeRecordServiceImpl implements IExchangeRecordService
{

    @Autowired
    private IntegralQueryService integralQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.MALL_EXCHANGERECORD_GETCONVERTRECORDLIST)
    public TransData<Object> getConvertRecordList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String startDateStr = ServletRequestUtils.getStringParameter(request, "startDate");
            String endDateStr = ServletRequestUtils.getStringParameter(request, "endDate");
            String type = ServletRequestUtils.getStringParameter(request, "type");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            Date startDate = null;
            if (StringUtils.isNotBlank(startDateStr))
            {
                startDate = TimeUtils.convertStringToDate(startDateStr);
            }
            Date endDate = null;
            if (StringUtils.isNotBlank(endDateStr))
            {
                endDate = TimeUtils.convertStringToDate(endDateStr);
            }
            List<IntegralConvertDetail> integralConvertDetailList = this.integralQueryService.findIntegralExchange(userId, shopId, startDate, endDate, type, pageIndex, pageSize, "convert_time desc");
            if (CollectionUtils.isEmpty(integralConvertDetailList))
            {
                GooagooLog.info("查询兑换记录列表:没有查到兑换记录");
                return new TransData<Object>(true, MessageConst.MALL_IMALL_INTEGRALCONVERT_NOTEXIST, null);
            }
            List<UExchangeRecord> uexchangeRecordList = new ArrayList<UExchangeRecord>();
            for (IntegralConvertDetail integralConvertDetail : integralConvertDetailList)
            {
                try
                {
                    UExchangeRecord uexchangeRecord = new UExchangeRecord();
                    uexchangeRecord.setExchangeTime(TimeUtils.convertDateToString(integralConvertDetail.getShopIntegralConvert().getConvertTime(), "yyyy-MM-dd HH:mm:ss"));
                    uexchangeRecord.setShopName(integralConvertDetail.getShopInfo().getShopName());
                    uexchangeRecord.setType(integralConvertDetail.getShopIntegralConvert().getIntegralTradeType());
                    uexchangeRecord.setIntegralValue(integralConvertDetail.getShopIntegralConvert().getTradeIntegralValue());
                    if ("G".equals(integralConvertDetail.getShopIntegralConvert().getIntegralTradeType()))
                    {
                        uexchangeRecord.setTypeName(integralConvertDetail.getGoodsBaseInfo().getGoodsName());
                        if (StringUtils.isNotBlank(integralConvertDetail.getGoodsMarketingInfo().getGoodsImg()))
                        {
                            List<String> imgs = new Gson().fromJson(integralConvertDetail.getGoodsMarketingInfo().getGoodsImg(), new TypeToken<List<String>>()
                            {
                            }.getType());
                            uexchangeRecord.setTypeImage(FormatDataUtils.formatImageInfo(imgs.get(0)));
                        }
                        uexchangeRecord.setDeliveryStatus(integralConvertDetail.getShopIntegralConvert().getDeliveryStatus());
                        uexchangeRecord.setConsigneeName(integralConvertDetail.getConsigneeInfo().getConsigneeName());
                        if (StringUtils.isBlank(integralConvertDetail.getConsigneeInfo().getPhone()))
                        {
                            uexchangeRecord.setConsigneePhone(integralConvertDetail.getConsigneeInfo().getTelephone());
                        }
                        else
                        {
                            uexchangeRecord.setConsigneePhone(integralConvertDetail.getConsigneeInfo().getPhone());
                        }
                        uexchangeRecord.setConsigneeAddress(integralConvertDetail.getConsigneeInfo().getAddress());
                        uexchangeRecord.setConsigneeZipCode(integralConvertDetail.getConsigneeInfo().getPostCode());
                        uexchangeRecord.setTypeVisitUrl(UrlUtils.getGoodsUrl(integralConvertDetail.getGoodsBaseInfo().getGoodsId()));
                    }
                    else
                    {
                        uexchangeRecord.setTypeName(integralConvertDetail.getCoupon().getCouponName());
                        uexchangeRecord.setTypeImage(FormatDataUtils.formatImageInfo(integralConvertDetail.getCoupon().getCouponUrl()));
                        uexchangeRecord.setTypeVisitUrl(UrlUtils.getCouponUrl(integralConvertDetail.getCoupon().getCouponId()));
                    }
                    uexchangeRecordList.add(uexchangeRecord);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询兑换记录列表：组装单个兑换记录信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uexchangeRecordList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询兑换记录列表:查询兑换记录列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

}

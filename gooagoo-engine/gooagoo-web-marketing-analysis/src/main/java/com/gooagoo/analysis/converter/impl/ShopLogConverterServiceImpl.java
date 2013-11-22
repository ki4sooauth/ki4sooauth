package com.gooagoo.analysis.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.converter.service.ConverterService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.exception.GooagooException;

@Service("shopLogConverterService")
public class ShopLogConverterServiceImpl implements ConverterService
{
    @Autowired
    private UserAccountQueryService userAccountQueryService;
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Override
    public List<Behave> getBehave(Object object) throws Exception
    {
        List<Behave> behaveList = new ArrayList<Behave>();
        ShopLog shopLog = (ShopLog) object;
        Behave behave = new Behave();
        behave.setShopId(shopLog.getShopId());
        behave.setObjectValue(shopLog.getObjectCode());
        behave.setRemoteCode(shopLog.getRemoteCode());
        behave.setBehaveType(shopLog.getShopBehaveType());
        if ("gtsc05".equals(shopLog.getRemoteCode()) || "gasl05".equals(shopLog.getRemoteCode()))
        {
            OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectByPrimaryKey(shopLog.getObjectCode());
            if (orderInfo != null && StringUtils.hasText(orderInfo.getUserId()))
            {
                String macAddress = this.userAccountQueryService.queryMacFromUserId(orderInfo.getUserId());
                behave.setMacAddress(macAddress);
            }
            else
            {
                GooagooLog.warn("封装mac地址异常，RemoteCode=" + shopLog.getRemoteCode() + ",shopId=" + shopLog.getShopId() + ";orderId=" + shopLog.getObjectCode());
                throw new GooagooException("封装mac地址异常，RemoteCode=" + shopLog.getRemoteCode() + ",shopId=" + shopLog.getShopId() + ";orderId=" + shopLog.getObjectCode());
            }
        }
        behave.setDetail(shopLog.getDetail());
        behave.setBehaveTime(shopLog.getCreateTime());
        behaveList.add(behave);
        return behaveList;
    }
}

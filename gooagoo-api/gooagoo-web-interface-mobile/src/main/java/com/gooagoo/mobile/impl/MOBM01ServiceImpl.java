package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.OrderTransactionMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobm01.transform.MobileOrderPayRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobm01")
public class MOBM01ServiceImpl implements ImobileService
{

    @Autowired
    private OrderTransactionMobileService orderTransactionMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MobileOrderPayRoot root = new MobileOrderPayRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String orderId = parameter.getString("orderid");
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobm01"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(orderId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERID_IS_NULL);
            }
            root = this.orderTransactionMobileService.mobileOrderPay(userId, sessionId, orderId);
            if ("0000".equals(root.getMsgcode()))
            {
                root.setResult("true");
                root.setMsg("获取交易流水号成功");
            }
            else
            {
                root.setResult("false");
            }

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

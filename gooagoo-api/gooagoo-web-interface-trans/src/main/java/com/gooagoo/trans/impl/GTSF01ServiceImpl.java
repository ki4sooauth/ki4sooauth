package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtse01.transform.OrderTransactionStatusRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsf01")
public class GTSF01ServiceImpl implements ItransService
{
    @Autowired
    private OrderCoreService orderCoreService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        OrderTransactionStatusRoot root = new OrderTransactionStatusRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String orderId = parameter.getString("orderid");
            String respCode = parameter.getString("respcode");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsf01"));
            //校验入参
            if (!StringUtils.hasText(orderId))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!this.orderCoreService.PlfNsynOrderPay(orderId) || !"0000".equals(respCode))
            {
                GooagooLog.warn("订单状态修改失败【orderId=" + orderId + ",respCode=" + respCode + "】");
                root.setResult("true");
                root.setMsg("订单交易状态修改失败");
            }
            else
            {
                root.setResult("false");
                root.setMsg("订单交易状态修改成功");
            }

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
        }
        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }

}

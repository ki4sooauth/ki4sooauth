package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderPayTransactionTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtse01.transform.OrderTransactionStatusRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtse01")
public class GTSE01ServiceImpl implements ItransService
{
    @Autowired
    private OrderPayTransactionTransService orderPayTransactionTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        OrderTransactionStatusRoot root = new OrderTransactionStatusRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String billNo = parameter.getString("billno");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtse01"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(billNo))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_BILLNO_IS_NULL);
            }
            root = this.orderPayTransactionTransService.getOrderTransactionStatusRoot(mac, billNo);
            root.setResult("true");
            root.setMsg("订单支付交易状态信息查询成功");
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

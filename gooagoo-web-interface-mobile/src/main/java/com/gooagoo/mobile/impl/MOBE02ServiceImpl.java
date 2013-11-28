package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.InvoiceAlreadyExistsException;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe02.transform.InvoiceRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE02:用户根据账单信息开发票接口
 */
@Service("mobe02")
public class MOBE02ServiceImpl implements ImobileService
{
    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        InvoiceRoot root = new InvoiceRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String orderid = parameter.getString("orderid");
            String invoicedtile = parameter.getString("invoicedtile");
            String invoiceditem = parameter.getString("invoiceditem");
            String invoicetype = parameter.getString("invoicedtype");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe02"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(invoicedtile))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_INVOICEDTITLE_IS_NULL);
            }
            if (!StringUtils.hasText(invoiceditem))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_INVOICEDITEM_IS_NULL);
            }
            if (!StringUtils.hasText(invoicetype))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_INVOICE_TYPE_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERID_IS_NULL);
            }
            this.consumeBillLinkOrderMobileService.applyOpenInvoice(userid, sessionid, orderid, invoicetype, invoicedtile, invoiceditem);
            root.setResult("true");
            root.setMsg("提交开发票申请成功");
        }
        catch (InvoiceAlreadyExistsException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_ALREADY_SUBMIT_OPEN_INVOICE_APPLY;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
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

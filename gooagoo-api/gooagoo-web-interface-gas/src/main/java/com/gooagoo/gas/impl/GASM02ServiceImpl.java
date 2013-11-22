package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.InvoiceAlreadyExistsException;
import com.gooagoo.gas.api.service.InvoiceLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasm02.transform.OpenInvoiceApplyRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasm02")
public class GASM02ServiceImpl implements IgasService
{
    @Autowired
    private InvoiceLinkGasService invoiceLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        OpenInvoiceApplyRoot root = new OpenInvoiceApplyRoot();
        root.setResult("false");
        root.setMsg(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String userid = parameter.getString("userid");
            String shopuserid = parameter.getString("shopuserid");
            String shopentityid = parameter.getString("shopentityid");
            String orderid = parameter.getString("orderid");
            String shopid = parameter.getString("shopid");
            String title = parameter.getString("title");
            String invoicedType = parameter.getString("invoicedtype");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasm02"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(title))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_INVOICE_TITLE_IS_NULL);
            }
            if (!StringUtils.hasText(invoicedType))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_INVOICE_TYPE_IS_NULL);
            }
            boolean bool = this.invoiceLinkGasService.submitOpenInvoiceApply(shopid, shopentityid, userid, title, invoicedType, orderid);
            if (bool)
            {
                root.setResult("true");
                root.setMsg("开发票申请成功");
            }
            else
            {
                root.setMsg("开发票申请失败");
            }

        }
        catch (InvoiceAlreadyExistsException e)
        {//发票已经提交过了
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_INVOICE_APLLY_ALREADY_SUBMIT;
            root.setMsgcode(err);
            err = ExceptionCache.get(err);
            root.setMsg(err);

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        GasTransData gasTransData = new GasTransData();
        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}

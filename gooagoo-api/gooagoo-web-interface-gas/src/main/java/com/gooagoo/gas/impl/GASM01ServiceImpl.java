package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.InvoiceLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasm01.transform.GetInvoiceTitlesRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasm01")
public class GASM01ServiceImpl implements IgasService
{
    @Autowired
    private InvoiceLinkGasService invoiceLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root.setResult("false");
        root.setMsg(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String userid = parameter.getString("userid");
            String shopentityid = parameter.getString("shopentityid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasm01"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }

            root = this.invoiceLinkGasService.queryInvoiceTitles(shopentityid, userid);
            root.setResult("true");
            root.setMsg("查询会员发票抬头信息成功");
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

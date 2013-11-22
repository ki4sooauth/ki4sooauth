package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.AlreadyApplyBillException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl04.transform.CheckDishFlagRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasl05")
public class GASL05ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopUserId = parameter.getString("shopuserid");
            String orderId = parameter.getString("orderid");
            String scardno = parameter.getString("scardno");
            String shopEntityId = parameter.getString("shopentityid");
            String couponId = parameter.getString("couponid");
            String shopId = parameter.getString("shopid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl05"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopUserId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(orderId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(scardno))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SCARDNO_IS_NULL);
            }
            if (!StringUtils.hasText(shopEntityId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            boolean queueCancel = this.orderLinkGasService.submitPayBillApply(orderId, shopId, shopEntityId, scardno, couponId);
            if (queueCancel)
            {
                root.setResult("true");
                root.setMsg("提交结账申请成功");
            }
            else
            {
                root.setMsg("提交结账申请失败");
            }

        }
        catch (AlreadyApplyBillException e)
        {//已经提交过结账申请
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_APLLY_ALREADY_SUBMIT;
            root.setMsg("提交结账申请失败");
            root.setMsgcode(err);
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }
        catch (GooagooException e)
        {//提交结账申请失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_ADD_APLLY_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }

        GasTransData gasTransData = new GasTransData();
        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}
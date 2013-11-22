package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.MemberServeGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasc05.transform.OrderRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * GASC05:产生订单
 */

@Service("gasc05")
public class GASC05ServiceImpl implements IgasService
{
    @Autowired
    private MemberServeGasService memberservegasservice;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GasTransData gasTransData = new GasTransData();
        OrderRoot root = new OrderRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String shopuserid = parameter.getString("shopuserid");
            String userId = parameter.getString("userid");
            String goodsInfo = parameter.getString("goodsinfo");
            String shopEntityId = parameter.getString("shopentityid");
            String takemethod = parameter.getString("takemethod");//提货方式,0-直接拿走、1-前台提货、2-送货上门
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasc05"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopEntityId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsInfo))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_GOODSINFO_IS_NULL);
            }
            if (!StringUtils.hasText(takemethod))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_TAKEMETHOD_IS_NULL);
            }
            String orderId = this.memberservegasservice.submitRetailOrder(userId, shopid, shopEntityId, goodsInfo, takemethod);

            gasTransData.setObjectId(orderId);//订单,用于shopLog的objectCode

            root.setResult("true");
            root.setMsg("提交订单成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}

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
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl04.transform.CheckDishFlagRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasl04")
public class GASL04ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root.setResult("false");
        root.setMsg(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String goodsInfo = parameter.getString("goodsinfo");
            String orderId = parameter.getString("orderid");
            String shopEntityId = parameter.getString("shopentityid");
            String tableName = parameter.getString("tablename");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl04"));
            if (!StringUtils.hasText(mac))
            {
                throw new GooagooException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsInfo))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_FOODSINFO_IS_NULL);
            }
            if (!StringUtils.hasText(orderId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ORDERID_IS_NULL);
            }
            boolean result = this.orderLinkGasService.markUpDish(orderId, shopEntityId, tableName, goodsInfo);
            if (result)
            {
                root.setMsg("已上菜品订单标记成功");
            }
            else
            {
                root.setMsg("已上菜品订单标记失败");
            }
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

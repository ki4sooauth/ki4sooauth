package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl09.transform.HurryGoodsRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 店员帮助用户缓菜
 */
@Service("gasl10")
public class GASL10ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        HurryGoodsRoot root = new HurryGoodsRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopUserId = parameter.getString("shopuserid");
            String shopId = parameter.getString("shopid");
            String orderid = parameter.getString("orderid");
            String shopentityid = parameter.getString("shopentityid");
            String tablename = parameter.getString("tablename");
            String goodsNum = parameter.getString("goodsnum");
            String itemSerial = parameter.getString("itemserial");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl10"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopUserId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(tablename))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_TABLENAME_IS_NULL);
            }
            this.orderLinkGasService.slowDish(shopentityid, orderid, tablename, itemSerial, goodsNum);
            root.setResult("true");
            root.setMsg("店员帮助用户缓菜成功");

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

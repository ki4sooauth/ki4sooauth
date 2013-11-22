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
import com.gooagoo.gas.api.service.MemberServeGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasc06.transform.SwipeCardRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasc06")
public class GASC06ServiceImpl implements IgasService
{
    @Autowired
    private MemberServeGasService memberservegasservice;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        SwipeCardRoot root = new SwipeCardRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String scardno = parameter.getString("scardno");
            String shopid = parameter.getString("shopid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasc06"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(scardno))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SCARDNO_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            boolean bool = this.memberservegasservice.swipeCardRoot(scardno, shopid);
            if (bool)
            {
                root.setResult("true");
                root.setMsg("刷卡成功");
            }
            else
            {
                root.setMsg("刷卡失败");
            }
        }
        catch (GooagooException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_CARD_NOT_PRESENT_SHOP_CARD;
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
        GasTransData gasTransData = new GasTransData();
        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}

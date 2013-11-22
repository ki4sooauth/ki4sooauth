package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderLinkTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc13.transform.QueryGoodsInfoRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsc13")
public class GTSC13ServiceImpl implements ItransService
{

    @Autowired
    private OrderLinkTransService orderLinkTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopentityid = parameter.getString("shopentityid");
            String shopid = parameter.getString("shopid");
            String scardno = parameter.getString("scardno");
            String itemserial = parameter.getString("itemserial");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasc01"));
            //入参校验
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(scardno))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SCARDNO_IS_NULL);
            }
            if (!StringUtils.hasText(itemserial))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_ITEMSERIAL_IS_NULL);
            }
            root = this.orderLinkTransService.getGoodsInfo(shopentityid, itemserial);
            root.setResult("true");
            root.setMsg("查询商品信息成功");

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }
        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }
}

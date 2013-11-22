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
import com.gooagoo.trans.entity.gtsc08.transform.CouponCheckRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsc08")
public class GTSC08ServiceImpl implements ItransService
{
    @Autowired
    private OrderLinkTransService orderLinkTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        CouponCheckRoot root = new CouponCheckRoot();
        root.setResult("false");
        try
        { //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String orderid = parameter.getString("orderid");
            String agreeyinfo = parameter.getString("agreeyinfo");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc08"));
            //入参校验
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(agreeyinfo))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_AGREETYPE_IS_NULL);
            }
            boolean result = this.orderLinkTransService.couponCheck(orderid, agreeyinfo);
            if (result)
            {
                root.setResult("true");
                root.setMsg("优惠凭证确认完毕");
            }
            else
            {
                root.setMsg("优惠凭证确认失败");
            }

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

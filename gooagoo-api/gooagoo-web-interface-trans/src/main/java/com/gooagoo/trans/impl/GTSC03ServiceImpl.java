package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderManageTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc03.transform.OpenInvoiceRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 接口：账单管理
 * 接口gtsc03:商家查询用户开发票申请信息
 * 查询需要同步到商家服务转发器上的结账申请信息
 * */

@Service("gtsc03")
public class GTSC03ServiceImpl implements ItransService
{
    @Autowired
    private OrderManageTransService orderManageTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        OpenInvoiceRoot root = new OpenInvoiceRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String ctimestamp = parameter.getString("ctimestamp");
            String shopentityid = parameter.getString("shopentityid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc03"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(ctimestamp))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_CTIMESTAMP_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            root = this.orderManageTransService.getOpenInvoiceApplyInfo(shopentityid, ctimestamp);
            root.setResult("true");
            root.setMsg("查询用户开发票申请信息成功");
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

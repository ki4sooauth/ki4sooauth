package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe01.transform.BillListgRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE01:用户获取账单信息接口
 */
@Service("mobe01")
public class MOBE01ServiceImpl implements ImobileService
{
    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        BillListgRoot root = new BillListgRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String orderId = parameter.getString("orderid");
            String pageType = parameter.getString("pagetype");
            String pageSize = parameter.getString("pagesize");
            String date = parameter.getString("date");
            String orderType = parameter.getString("ordertype");
            String cTimeStamp = parameter.getString("ctimestamp");
            String deliverystatus = parameter.getString("deliverystatus");//取货状态, Y-已取货、N-未取货
            String shopTypeId = parameter.getString("shoptypeid");//商家类型编号
            String shopId = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe01"));
            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(orderId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(pageType))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            if (!pageType.contains("P") && !pageType.contains("N"))
            {//分页类型不正确
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_ERROR);
            }
            root = this.consumeBillLinkOrderMobileService.getBillListOfGooagoo(userId, sessionId, shopId, cTimeStamp, orderId, pageType, pageSize, date, orderType, deliverystatus, shopTypeId);
            root.setResult("true");
            root.setMsg("用户获取账单信息成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

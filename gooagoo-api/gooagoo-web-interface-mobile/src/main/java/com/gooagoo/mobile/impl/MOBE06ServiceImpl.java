package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.AlreadyApplyBillException;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe06.transform.CheckoutRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE06:结帐申请接口
 */
@Service("mobe06")
@Transactional
public class MOBE06ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        CheckoutRoot root = new CheckoutRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String tableno2d = parameter.getString("tableno2d");
            String orderid = parameter.getString("orderid");
            String couponid = parameter.getString("couponid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe06"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(tableno2d))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TABLENO2D_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERID_IS_NULL);
            }
            this.consumeBillLinkOrderMobileService.payBillApply(userid, sessionid, tableno2d, orderid, shopid, couponid);
            root.setResult("true");
            root.setMsg("提交结帐申请成功");
        }
        catch (AlreadyApplyBillException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_ALREADY_SUBMIT_PAY_BILL_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GooagooException e)
        {//提交结账申请失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_SUBMIT_PAY_BILL_FAIL;
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

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

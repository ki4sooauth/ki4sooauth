package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.OrderNotExistsException;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe18.transform.BillAddRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE18:用户加菜申请
 */
@Service("mobe18")
public class MOBE18ServiceImpl implements ImobileService
{
    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        BillAddRoot root = new BillAddRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String goodsinfo = parameter.getString("goodsinfo");
            String tableno2d = parameter.getString("tableno2d");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe18"));
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
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(goodsinfo))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSINFO_IS_NULL);
            }

            boolean bool = this.consumeBillLinkOrderMobileService.billAddApply(userid, sessionid, mac, shopid, goodsinfo, tableno2d);
            if (bool)
            {
                root.setResult("true");
                root.setMsg("用户加菜申请成功");
            }
        }
        catch (OrderNotExistsException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_ALREADY_PAID_BILL_SUBMIT_BILL_AGAIN;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GooagooException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_SUBMIT_ADD_BILL_APPLY_FAIL;
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

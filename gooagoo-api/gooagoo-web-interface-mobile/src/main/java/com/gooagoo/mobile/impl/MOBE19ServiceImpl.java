package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.CardTopLinkDelMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba02.transform.DelUserMemberCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * 接口 mobe19 : 手机端用户账单接口 
 */

@Service("mobe19")
public class MOBE19ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkDelMobileService cardTopLinkDelMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String orderinfo = parameter.getString("orderinfo");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe19"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(orderinfo))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_BILLID_IS_NULL);
            }

            this.cardTopLinkDelMobileService.DelUserBill(userid, sessionid, orderinfo);
            root.setResult("true");
            root.setMsg("删除账单成功");

        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_DEL_BILL_FAIL;
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

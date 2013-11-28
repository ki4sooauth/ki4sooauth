package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ReceiptInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobp04.transform.AddReceiptInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobp04")
public class MOBP04ServiceImpl implements ImobileService
{

    @Autowired
    private ReceiptInfoMobileService receiptInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        AddReceiptInfoRoot root = new AddReceiptInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String companyname = parameter.getString("companyname");
            String isdefault = parameter.getString("isdefault");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobp04"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(companyname))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_COMPANYNAME_IS_NULL);
            }
            if (!StringUtils.hasText(isdefault))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ISDEFAULT_IS_NULL);
            }

            this.receiptInfoMobileService.addReceiptInfo(userId, sessionId, companyname, isdefault);
            root.setResult("true");
            root.setMsg("新增用户发票抬头信息成功");
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

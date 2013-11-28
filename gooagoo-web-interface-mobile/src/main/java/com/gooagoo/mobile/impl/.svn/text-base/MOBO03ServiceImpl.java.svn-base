package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ConsigneeInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobo03.transform.DelConsigneeInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobo03")
public class MOBO03ServiceImpl implements ImobileService
{

    @Autowired
    private ConsigneeInfoMobileService consigneeInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        DelConsigneeInfoRoot root = new DelConsigneeInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String consigneeid = parameter.getString("consigneeid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobo03"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(consigneeid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CONSIGNEEINFO_IS_NULL);
            }
            this.consigneeInfoMobileService.delConsigneeInfo(userId, sessionId, consigneeid);
            root.setResult("true");
            root.setMsg("删除收货人地址信息成功");
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

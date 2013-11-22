package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba06.transform.GetUserIntegralRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 
MOBA06:用户单独更新会员卡积分接口
 */
@Service("moba06")
public class MOBA06ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root.setResult("false");
        root.setUseableintegralnumber(null);
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String shopId = parameter.getString("shopid");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba06"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }

            String userIntegral = this.cardTopLinkUserMobileService.getUserIntegral(userId, sessionId, shopId);
            root.setUseableintegralnumber(StringUtils.hasText(userIntegral) ? userIntegral : "0");
            root.setResult("true");
            root.setMsg("查询用户积分成功");
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

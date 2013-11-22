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
import com.gooagoo.mobile.entity.moba04.transform.MembernoticeRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBA04:用户得到"通知"
 */
@Service("moba04")
public class MOBA04ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MembernoticeRoot root = new MembernoticeRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String pageSize = parameter.getString("pagesize");
            String pageId = parameter.getString("pageid");
            String pageType = parameter.getString("pagetype");
            String shopId = parameter.getString("shopid");
            String cTimeStamp = parameter.getString("ctimestamp");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba04"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(pageId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEID_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            if (!StringUtils.hasText(pageType))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_IS_NULL);
            }
            if (!pageType.contains("P") && !pageType.contains("N"))
            {//分页类型不正确
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_ERROR);
            }
            root = this.cardTopLinkUserMobileService.getUserReceiveNotice(userId, sessionId, cTimeStamp, shopId, pageId, pageType, pageSize);
            root.setResult("true");
            root.setMsg("查询用户接收到的通知成功");

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

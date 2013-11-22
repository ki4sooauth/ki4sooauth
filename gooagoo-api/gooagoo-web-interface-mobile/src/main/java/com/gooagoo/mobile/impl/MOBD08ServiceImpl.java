package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ShoppingPlanMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobd08.transform.ShoppingMatchActiveRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MODB08:购物匹配（主动）
 */
@Service("mobd08")
public class MOBD08ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingPlanMobileService shoppingPlanMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ShoppingMatchActiveRoot root = new ShoppingMatchActiveRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String keyword = parameter.getString("keyword");
            String mac = parameter.getString("mac");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobd08"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(keyword))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MATCH_KEYWORD_IS_NULL);
            }

            root = this.shoppingPlanMobileService.shoppingMatch(mac, userid, sessionid, keyword);
            root.setResult("true");
            root.setMsg("购物匹配成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            if (err == null || "".equals(err))
            {
                root.setMsg(e.getMessage());
                root.setMsgcode(e.getMessage());
            }
            else
            {
                root.setMsg(err);
                root.setMsgcode(e.getMessage());
            }
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

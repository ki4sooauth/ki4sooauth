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
import com.gooagoo.mobile.entity.mobe07.transform.GetOrderFormRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE07:通过桌号获取点菜单信息接口
 */
@Service("mobe07")
public class MOBE07ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetOrderFormRoot root = new GetOrderFormRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String tableno2d = parameter.getString("tableno2d");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe07"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(tableno2d))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TABLENO2D_IS_NULL);
            }
            root = this.consumeBillLinkOrderMobileService.getOrderByTableNo(userid, sessionid, tableno2d);
            root.setResult("true");
            root.setMsg("通过桌号获取点菜单信息成功 ");
        }
        catch (Exception e)
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

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
import com.gooagoo.mobile.entity.mobd02.transform.ShoppingMatchDetileRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobd02")
public class MOBD02ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingPlanMobileService shoppingPlanMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ShoppingMatchDetileRoot root = new ShoppingMatchDetileRoot();
        root.setResult("false");

        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String goodsid = parameter.getString("goodsid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobd02"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSID_IS_NULL);
            }

            root = this.shoppingPlanMobileService.getShoppingMatchInfo(userid, sessionid, goodsid);
            root.setResult("true");
            root.setMsg("查询用户“购物清单”中匹配商品的信息成功");
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

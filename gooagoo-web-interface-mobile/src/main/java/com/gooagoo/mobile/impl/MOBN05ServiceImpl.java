package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ShoppingCartMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobn05.transform.PurchaseGoodsRankRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobn05")
public class MOBN05ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingCartMobileService shoppingCartMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        PurchaseGoodsRankRoot root = new PurchaseGoodsRankRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String shopEnityId = parameter.getString("shopentityid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobn05"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopEnityId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            root = this.shoppingCartMobileService.purchaseGoodsRankRoot(userId, sessionId, shopEnityId);
            root.setResult("true");
            root.setMsg("查询用户已购商品次数排行信息成功");
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

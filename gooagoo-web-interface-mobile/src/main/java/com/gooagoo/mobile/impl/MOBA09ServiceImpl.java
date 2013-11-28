package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CardTopLinkShopMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba09.transform.ShopCardInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBA09:获取店铺的会员卡信息列表
 */
@Service("moba09")
public class MOBA09ServiceImpl implements ImobileService
{

    @Autowired
    private CardTopLinkShopMobileService cardTopLinkShopMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ShopCardInfoRoot root = new ShopCardInfoRoot();
        root.setResult("false");
        root.setShopcardinfo(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String shopid = parameter.getString("shopid");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba09"));

            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }

            root = this.cardTopLinkShopMobileService.getShopMemberCard(shopid);
            root.setResult("true");
            root.setMsg("获取店铺的会员卡信息列表成功");
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

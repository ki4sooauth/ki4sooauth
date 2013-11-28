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
import com.gooagoo.mobile.entity.moba08.transform.ShopListRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBA08:商家列表
 */
@Service("moba08")
public class MOBA08ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkShopMobileService cardTopLinkShopMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ShopListRoot root = new ShopListRoot();
        root.setResult("false");
        root.setShoplist(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String shopid = parameter.getString("shopid");
            String pagesize = parameter.getString("pagesize");
            String pageType = parameter.getString("pagetype");
            String shoptype = parameter.getString("shoptype");
            String keyword = parameter.getString("keyword");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba08"));

            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
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
            root = this.cardTopLinkShopMobileService.getShopList(shopid, pageType, pagesize, shoptype, keyword);
            root.setResult("true");
            root.setMsg("查询商家列表信息成功");
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

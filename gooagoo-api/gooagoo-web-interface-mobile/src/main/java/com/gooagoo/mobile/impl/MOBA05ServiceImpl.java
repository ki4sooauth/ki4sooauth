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
import com.gooagoo.mobile.entity.moba05.transform.RecommendShopRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 *   MOBA05:查询推荐商家信息
 */
@Service("moba05")
public class MOBA05ServiceImpl implements ImobileService
{

    @Autowired
    private CardTopLinkShopMobileService cardTopLinkShopMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        RecommendShopRoot root = new RecommendShopRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String pageIndex = parameter.getString("pageindex");
            String pageSize = parameter.getString("pagesize");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba05"));

            if (!StringUtils.hasText(pageIndex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }

            root = this.cardTopLinkShopMobileService.getRecommendShopInfo(userId, pageIndex, pageSize);
            root.setResult("true");
            root.setMsg("查询推荐商家信息成功");
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

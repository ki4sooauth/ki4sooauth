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
import com.gooagoo.mobile.entity.mobd03.transform.MarketingactivityRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobd03")
public class MOBD03ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingPlanMobileService shoppingPlanMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MarketingactivityRoot root = new MarketingactivityRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String type = parameter.getString("type");
            String date = parameter.getString("date");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobd03"));

            if (!StringUtils.hasText(type))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TYPE_IS_NULL);
            }
            if (!StringUtils.hasText(date))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_DATE_IS_NULL);
            }

            root = this.shoppingPlanMobileService.getMarketingactivity(type, date);
            root.setResult("true");
            root.setMsg("查询活动信息成功");
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

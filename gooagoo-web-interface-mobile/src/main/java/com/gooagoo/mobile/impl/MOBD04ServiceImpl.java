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
import com.gooagoo.mobile.entity.mobd04.transform.ActivitylistRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobd04")
public class MOBD04ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingPlanMobileService shoppingPlanMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ActivitylistRoot root = new ActivitylistRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String startdate = parameter.getString("startdate");
            String enddate = parameter.getString("enddate");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobd04"));

            if (!StringUtils.hasText(startdate))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_STARTDATE_IS_NULL);
            }
            if (!StringUtils.hasText(enddate))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ENDDATE_IS_NULL);
            }
            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.shoppingPlanMobileService.getActivityList(startdate, enddate, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询活动列表信息成功");
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

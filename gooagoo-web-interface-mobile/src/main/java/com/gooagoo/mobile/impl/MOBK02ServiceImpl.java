package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ExpenseCalendarMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobk02.transform.GetConsumeRecordByMonthRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 查询该月哪些天有：订单，账单，购物清单
 */
@Service("mobk02")
public class MOBK02ServiceImpl implements ImobileService
{
    @Autowired
    private ExpenseCalendarMobileService expenseCalendarMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetConsumeRecordByMonthRoot root = new GetConsumeRecordByMonthRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String mac = parameter.getString("mac");
            String date = parameter.getString("date");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobk02"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(date))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_DATE_IS_NULL);
            }
            root = this.expenseCalendarMobileService.getConsumeRecordByMonth(userid, sessionid, date);
            root.setResult("true");
            root.setMsg("按月份查询用户消费信息记录成功");
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

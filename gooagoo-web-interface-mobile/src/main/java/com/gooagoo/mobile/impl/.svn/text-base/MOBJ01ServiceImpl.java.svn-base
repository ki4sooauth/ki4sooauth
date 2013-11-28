package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.UserBehaveMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobj01.transform.UserbehaveRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 记录用户使用手机行为
 */
@Service("mobj01")
public class MOBJ01ServiceImpl implements ImobileService
{
    @Autowired
    private UserBehaveMobileService userBehaveMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        UserbehaveRoot root = new UserbehaveRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String behavior = parameter.getString("behavior");
            String userid = parameter.getString("userid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobj01"));
            if (!StringUtils.hasText(behavior))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_BEHAVIOR_IS_NULL);
            }
            this.userBehaveMobileService.recordUserbehave(userid, behavior);
            root.setResult("true");
            root.setMsg("记录用户使用手机行为成功");
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

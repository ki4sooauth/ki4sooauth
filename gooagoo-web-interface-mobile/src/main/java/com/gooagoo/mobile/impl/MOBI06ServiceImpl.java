package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobi06.transform.CollectLidInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBI06 : 更加lid获取营销触发信息
 **/

@Service("mobi06")
public class MOBI06ServiceImpl implements ImobileService
{

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        CollectLidInfoRoot root = new CollectLidInfoRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobi06"));
            String lid = parameter.getString("lid");
            String userid = parameter.getString("userid");
            if (!StringUtils.hasText(lid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_LID_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            root.setResult("true");
            root.setMsg("收集lid信息成功");
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

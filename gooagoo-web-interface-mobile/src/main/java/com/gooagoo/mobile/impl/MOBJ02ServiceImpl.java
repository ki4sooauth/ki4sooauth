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
import com.gooagoo.mobile.entity.mobj02.transform.UserUseToolRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 记录用户使用手机行为
 */
@Service("mobj02")
public class MOBJ02ServiceImpl implements ImobileService
{

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        UserUseToolRoot root = new UserUseToolRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String toolType = parameter.getString("tooltype");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobj02"));
            //校验入参
            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(toolType))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TOOLTYPE_IS_NULL);
            }
            root.setResult("true");
            root.setMsg("记录用户使用服务工具行为成功");
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

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf02.transform.PasswordForgetRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * MOBF02:用户忘记口令
 * 
 *
 */
@Service("mobf02")
public class MOBF02ServiceImpl implements ImobileService
{
    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {//获取传入参数,做非空校验
        PasswordForgetRoot root = new PasswordForgetRoot();
        root.setResult("false");

        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String email = parameter.getString("email");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf02"));

            if (!StringUtils.hasText(email))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_EMAIL_IS_NULL);
            }
            this.infoSetMobileService.userForgetPassword(email);

            root.setResult("true");
            root.setMsg("邮件已发送，请注意查收");
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

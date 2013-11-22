package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf04.transform.ChangePasswordRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/****
 * 
 * @author Administrator
 *
MOBF04:用户口令更改
 */
@Service("mobf04")
public class MOBF04ServiceImpl implements ImobileService
{

    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ChangePasswordRoot root = new ChangePasswordRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String newpassword = parameter.getString("newpassword");
            String password = parameter.getString("password");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf04"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(newpassword))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_NEWPASSWORD_IS_NULL);
            }
            if (!StringUtils.hasText(password))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PASSWORD_IS_NULL);
            }
            this.infoSetMobileService.changePassword(userId, sessionId, password, newpassword);
            root.setResult("true");
            root.setMsg("修改密码成功");
        }
        catch (FormatErrorException e)
        {//新密码长度只能在6-20位之间
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_PASSWORD_NEWPASS_LENGTH_BETWEEN_6_AND_20;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PasswordIncorrectException e)
        {//原始密码不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_ORG_PASSWORD_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {//修改密码失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_PASSWORD_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
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

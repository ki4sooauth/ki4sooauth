package com.gooagoo.igus.personal.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.password.UserSecurityCoreService;
import com.gooagoo.api.business.query.user.password.UserSecurityQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.business.user.SecurityCardAlreadyBindException;
import com.gooagoo.exception.business.user.SecurityCardIsNotExistException;
import com.gooagoo.igus.personal.service.ISecurityCardService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iSecurityCardService")
public class ISecurityCardServiceImpl implements ISecurityCardService
{

    @Autowired
    private UserSecurityCoreService userSecurityCoreService;

    @Autowired
    private UserSecurityQueryService userSecurityQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYCARD_GETUSERSECURITYCARD)
    public TransData<Object> getUserSecurityCard(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String serialNum = this.userSecurityQueryService.findUserBindedSecurityCard(userId);
            if (StringUtils.isBlank(serialNum))
            {
                GooagooLog.info("查询用户已绑定的密保卡：用户未绑定的密保卡");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_NOTEXIST, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, serialNum);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询用户已绑定的密保卡：查询用户已绑定的密保卡异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYCARD_SETUSERSECURITYCARD)
    public TransData<Object> setUserSecurityCard(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String serialNum = ServletRequestUtils.getStringParameter(request, "serialNum");
            String coordinateData = ServletRequestUtils.getStringParameter(request, "coordDate");
            String isBind = ServletRequestUtils.getStringParameter(request, "isBind");
            if (!this.userSecurityCoreService.bindSecurityCard(userId, serialNum, coordinateData, isBind))
            {
                GooagooLog.info("绑定密保卡：绑定密保卡（" + userId + "|" + serialNum + "|" + coordinateData + "）失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_SETUSERSECURITYCARD_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISECURITYCARDI_SETUSERSECURITYCARD_SUCCESS, null);
        }
        catch (SecurityCardIsNotExistException e)
        {
            GooagooLog.error("绑定密保卡：密保卡已绑定异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_NOTEXIST, null);
        }
        catch (SecurityCardAlreadyBindException e)
        {
            GooagooLog.error("绑定密保卡：密保卡已绑定异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("绑定密保卡：绑定密保卡异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_SETUSERSECURITYCARD_FALL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYCARD_DELETEUSERSECURITYCARD)
    public TransData<Object> deleteUserSecurityCard(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            if (!this.userSecurityCoreService.removeSecurityCard(userId))
            {
                GooagooLog.info("解除绑定的密保卡：解除用户（" + userId + "）绑定的密保卡失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_DEL_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISECURITYCARDI_DEL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("解除绑定的密保卡：解除绑定的密保卡异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYCARDI_DEL_FALL, null);
        }

        return transData;
    }

}

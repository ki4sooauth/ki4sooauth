package com.gooagoo.igus.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.password.UserSecurityCoreService;
import com.gooagoo.api.business.query.user.password.UserSecurityQueryService;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.igus.personal.service.ISecurityQuestionService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.personal.USysSecurityQuestion;
import com.gooagoo.view.gus.web.personal.UUserSecurityQuestion;

@Service("iSecurityQuestionService")
public class ISecurityQuestionServiceImpl implements ISecurityQuestionService
{

    @Autowired
    private UserAccountQueryService userAccountQueryService;

    @Autowired
    private UserSecurityQueryService userSecurityQueryService;

    @Autowired
    private UserSecurityCoreService userSecurityCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYQUESTION_GETUSERSECURITYQUESTION)
    public TransData<Object> getUserSecurityQuestion(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            List<UserSecurityQuestion> userSecurityQuestionList = this.userSecurityQueryService.findUserSecurityQuestion(userId);
            if (CollectionUtils.isEmpty(userSecurityQuestionList))
            {
                GooagooLog.info("查询用户已设置的密保问题：用户未设置的密保问题");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_GETUSERSECURITYQUESTION_NOTEXIST, null);
            }
            List<UUserSecurityQuestion> uUserSecurityQuestionList = new ArrayList<UUserSecurityQuestion>();
            for (UserSecurityQuestion userSecurityQuestion : userSecurityQuestionList)
            {
                UUserSecurityQuestion uUserSecurityQuestion = new UUserSecurityQuestion();
                uUserSecurityQuestion.setId(userSecurityQuestion.getId());
                uUserSecurityQuestion.setType(userSecurityQuestion.getType());
                uUserSecurityQuestion.setSysId(userSecurityQuestion.getSysId());
                uUserSecurityQuestion.setContent(userSecurityQuestion.getContent());
                uUserSecurityQuestion.setAnswer(userSecurityQuestion.getAnswer());
                uUserSecurityQuestionList.add(uUserSecurityQuestion);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uUserSecurityQuestionList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询用户已设置的密保问题：查询用户已设置的密保问题异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYQUESTION_CHECKUSERPASSWORD)
    public TransData<Object> checkUserPassword(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String password = ServletRequestUtils.getStringParameter(request, "password");
            if (!this.userAccountQueryService.checkUserIdentity(userId, password))
            {
                GooagooLog.info("验证用户密码：用户（" + userId + "）密码（" + password + "）不正确");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_CHECKUSERPASSWORD_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISECURITYQUESTION_CHECKUSERPASSWORD_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("验证用户密码：验证用户密码异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_CHECKUSERPASSWORD_FALL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYQUESTION_GETSYSSECURITYQUESTION)
    public TransData<Object> getSysSecurityQuestion(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            List<SysSecurityQuestion> sysSecurityQuestionList = this.userSecurityQueryService.findSysSecurityQuestion();
            if (CollectionUtils.isEmpty(sysSecurityQuestionList))
            {
                GooagooLog.info("查询系统内置密保问题：暂无系统内置密保问题");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_GETSYSECURITYQUESTION_NOTEXIST, null);
            }
            List<USysSecurityQuestion> uSysSecurityQuestionList = new ArrayList<USysSecurityQuestion>();
            for (SysSecurityQuestion sysSecurityQuestion : sysSecurityQuestionList)
            {
                USysSecurityQuestion uSysSecurityQuestion = new USysSecurityQuestion();
                uSysSecurityQuestion.setSysId(sysSecurityQuestion.getSysId());
                uSysSecurityQuestion.setContent(sysSecurityQuestion.getContent());
                uSysSecurityQuestionList.add(uSysSecurityQuestion);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uSysSecurityQuestionList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询系统内置密保问题：查询系统内置密保问题异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYQUESTION_SETUSERSECURITYQUESTION)
    public TransData<Object> setUserSecurityQuestion(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String id = ServletRequestUtils.getStringParameter(request, "id");
            String sysId = ServletRequestUtils.getStringParameter(request, "sysId");
            String content = ServletRequestUtils.getStringParameter(request, "content");
            String answer = ServletRequestUtils.getStringParameter(request, "answer");
            if (!this.userSecurityCoreService.setSecurityQuestion(userId, id, sysId, content, answer))
            {
                GooagooLog.info("设置密保问题：设置密保问题（" + userId + "|" + id + "|" + sysId + "|" + content + "|" + answer + "）失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_SETUSERSECURITYQUESTION_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISECURITYQUESTION_SETUSERSECURITYQUESTION_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置密保问题：设置密保问题异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_SETUSERSECURITYQUESTION_FALL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SECURITYQUESTION_DELETEUSERSECURITYQUESTION)
    public TransData<Object> deleteUserSecurityQuestion(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String id = ServletRequestUtils.getStringParameter(request, "id");
            if (!this.userSecurityCoreService.deleteSecurityQuestion(id))
            {
                GooagooLog.info("删除密保问题：删除密保问题（" + id + "）失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_DELETEUSERSECURITYQUESTION_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISECURITYQUESTION_DELETEUSERSECURITYQUESTION_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除密保问题：删除密保问题异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISECURITYQUESTION_DELETEUSERSECURITYQUESTION_FALL, null);
        }

        return transData;
    }

}

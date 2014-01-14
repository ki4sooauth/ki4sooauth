package com.gooagoo.authzserver.api.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gooagoo.api.generator.core.open.OauthCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.open.OpenAppInfoGeneratorCoreService;
import com.gooagoo.authzserver.api.CodeService;
import com.gooagoo.authzserver.entity.request.CodeRequest;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.auth.CodeResponse;
import com.gooagoo.entity.generator.open.OauthCode;
import com.gooagoo.entity.generator.open.OauthCodeExample;
import com.gooagoo.entity.generator.open.OpenAppInfo;

@Service
public class CodeServiceImpl implements CodeService
{
    @Autowired
    private OauthCodeGeneratorCoreService oauthCodeGeneratorCoreService;
    @Autowired
    private OpenAppInfoGeneratorCoreService openAppInfoGeneratorCoreService;

    //private final static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @SuppressWarnings("unused")
    @Override
    public CodeResponse getAuthzCode(CodeRequest codeRequest)
    {
        OpenAppInfo openAppInfo = this.openAppInfoGeneratorCoreService.selectByPrimaryKey(Integer.valueOf(codeRequest.getClientId()));
        if (openAppInfo == null)
        {
            GooagooLog.info("应用不合法");
        }
        OauthCodeExample oauthCodeExample = new OauthCodeExample();
        oauthCodeExample.createCriteria().andAppKeyEqualTo(codeRequest.getClientId());
        List<OauthCode> oauthCodeList = this.oauthCodeGeneratorCoreService.selectByExample(oauthCodeExample);
        if (CollectionUtils.isEmpty(oauthCodeList))
        {
            CodeResponse codeResponse = new CodeResponse();
            codeResponse.setAuthorizationcode(UUID.getUUID());
            Date d = new Date();
            Date expiresin = new Date(d.getTime() + 10 * 60 * 1000);
            codeResponse.setExpiresin(String.valueOf(expiresin.getTime()));
            if (codeResponse == null)
            {
                GooagooLog.info("codeResponse为空");
            }
            OauthCode oauthCodes = new OauthCode();
            oauthCodes.setAppKey(Integer.valueOf(codeRequest.getClientId()));
            oauthCodes.setCode(codeResponse.getAuthorizationcode());
            oauthCodes.setExpireTime(expiresin);
            this.oauthCodeGeneratorCoreService.insertSelective(oauthCodes);
            return codeResponse;
        }
        for (OauthCode oauthCode : oauthCodeList)
        {
            CodeResponse codeResponse = new CodeResponse();
            if (oauthCode.getExpireTime().getTime() - new Date().getTime() >= 0)
            {
                codeResponse.setAuthorizationcode(oauthCode.getCode());
                codeResponse.setExpiresin(String.valueOf(oauthCode.getExpireTime().getTime()));
                return codeResponse;
            }
            codeResponse.setAuthorizationcode(UUID.getUUID());
            Date d = new Date();
            Date expiresin = new Date(d.getTime() + 10 * 60 * 1000);
            codeResponse.setExpiresin(String.valueOf(expiresin.getTime()));
            if (codeResponse == null)
            {
                GooagooLog.info("codeResponse为空");
            }
            OauthCode oauthCodes = new OauthCode();
            oauthCodes.setAppKey(Integer.valueOf(codeRequest.getClientId()));
            oauthCodes.setCode(codeResponse.getAuthorizationcode());
            oauthCodes.setExpireTime(expiresin);
            this.oauthCodeGeneratorCoreService.updateByPrimaryKeySelective(oauthCodes);
            return codeResponse;
        }
        return null;
    }
}

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CardTopLinkShopMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba01.transform.UserMemberCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBA01:用户会员卡列表
 * */

@Service("moba01")
public class MOBA01ServiceImpl implements ImobileService
{

    @Autowired
    private CardTopLinkShopMobileService cardTopLinkShopMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        //返回Json封装类
        UserMemberCardRoot root = new UserMemberCardRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String cTimeStamp = parameter.getString("ctimestamp");
            String pageSize = parameter.getString("pagesize");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba01"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(cTimeStamp))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CTIMESTAMP_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }

            root = this.cardTopLinkShopMobileService.getUserMemberCard(userid, sessionid, cTimeStamp, pageSize);
            root.setResult("true");
            root.setMsg("获取用户会员卡列表信息成功");

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

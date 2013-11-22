package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.CardTopLinkDelMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba02.transform.DelUserMemberCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * 接口 mobb11 : 手机端删除用户收藏接口 
 */

@Service("mobb11")
public class MOBB11ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkDelMobileService cardTopLinkDelMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String favoriteid = parameter.getString("favoriteid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb11"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(favoriteid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_FAVORIATEID_IS_NULL);
            }

            this.cardTopLinkDelMobileService.DelUserFavoriate(userid, sessionid, favoriteid);
            root.setResult("true");
            root.setMsg("删除用户收藏成功");

        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_DEL_FAVORIATE_FAIL;
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

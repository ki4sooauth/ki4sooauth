package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.user.UserAlreadyApplyException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba11.transform.PhysicToElecCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBA11:用户申请实体卡电子化
 */
@Service("moba11")
public class MOBA11ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String phyno = parameter.getString("phyno");
            String mobile = parameter.getString("mobile");
            String idno = parameter.getString("idno");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba11"));

            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }

            if (!StringUtils.hasText(mobile) && !StringUtils.hasText(idno))
            {//mobile与idno二选一必填
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHONE_AND_IDNO_IS_NULL);
            }

            if (!StringUtils.hasText(phyno))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHYNO_IS_NULL);
            }

            this.cardTopLinkUserMobileService.physicToElecCard(userid, sessionid, shopid, mobile, idno, phyno);
            root.setResult("true");
            root.setMsg("申请实体卡电子化成功,请等待审核");
        }
        catch (UserAlreadyApplyException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_ALREADY_SUBMIT_APPLY;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_FAIL;
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

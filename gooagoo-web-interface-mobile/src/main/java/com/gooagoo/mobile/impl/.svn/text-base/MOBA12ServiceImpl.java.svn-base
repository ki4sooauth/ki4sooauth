package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.exception.business.card.GiveCardFailException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba12.transform.AgreeCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBA12:用户是否同意发卡
 */
@Service("moba12")
public class MOBA12ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        AgreeCardRoot root = new AgreeCardRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String cardid = parameter.getString("cardid");
            String cardtype = parameter.getString("cardtype");
            String isagree = parameter.getString("isagree");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba12"));

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
            if (!StringUtils.hasText(cardid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CARDID_IS_NULL);
            }
            if (!StringUtils.hasText(cardtype))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CARDTYPE_IS_NULL);
            }
            if (!StringUtils.hasText(isagree))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_IAGREE_IS_NULL);
            }

            if ("N".equals(isagree))
            {
                root.setMsg("取消发卡成功");
            }
            else
            {
                root = this.cardTopLinkUserMobileService.agreeGiveCard(userid, sessionid, shopid, cardid, cardtype, isagree);
                root.setMsg("发卡成功");
            }

            root.setResult("true");

        }
        catch (CardNotExistsException e)
        {//用户没有此卡
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_NOT_HAVE_THE_CARD;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (CardAlreadyExistsException e)
        {//用户已有此卡
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_ALREADY_HAVE_THE_CARD;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GiveCardFailException e)
        {//发卡失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_GIVE_CARD_FAIL;
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

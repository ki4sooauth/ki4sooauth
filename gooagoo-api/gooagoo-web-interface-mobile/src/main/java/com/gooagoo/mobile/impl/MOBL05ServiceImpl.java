package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.card.CardAlreadyOverdueException;
import com.gooagoo.exception.business.card.CardNotBelongShopException;
import com.gooagoo.exception.business.card.CardNotBelongUserException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.mobile.api.AudioMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobl04.transform.ApprovePlayInvoiceSoundRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobl05")
public class MOBL05ServiceImpl implements ImobileService
{

    @Autowired
    private AudioMobileService audioMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ApprovePlayInvoiceSoundRoot root = new ApprovePlayInvoiceSoundRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String scardno = parameter.getString("scardno");
            String userId = parameter.getString("userid");
            String shopId = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobl05"));

            if (!StringUtils.hasText(scardno))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SCARDNO_IS_NULL);
            }
            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            this.audioMobileService.approvePlayScardNoSound(scardno, userId, shopId);
            root.setResult("true");
            root.setMsg("允许用户播放会员卡音频 ");
        }
        catch (CardNotBelongUserException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_AUDIO_CARD_NOT_BELONG_USER;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (CardNotExistsException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_AUDIO_CARD_IS_NOT_EXIST;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (CardAlreadyOverdueException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_AUDIO_CARD_MEMBER_CARD_OVER_TIME;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (CardNotBelongShopException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_AUDIO_CARD_NOT_PRESENT_SHOP_CARD;
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

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.user.AddressFormatErrorException;
import com.gooagoo.exception.business.user.BirthdayFormatErrorException;
import com.gooagoo.exception.business.user.IdNoFormatErrorException;
import com.gooagoo.exception.business.user.NameFormatErrorException;
import com.gooagoo.exception.business.user.PhoneFormatErrorException;
import com.gooagoo.exception.business.user.PostCodeFormatErrorException;
import com.gooagoo.exception.business.user.SexFormatErrorException;
import com.gooagoo.exception.business.user.UserAlreadyApplyException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;
import com.gooagoo.exception.business.user.UserCanNotRepetitionApplyMemberException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba10.transform.ApplyCardRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/* 接口MOBA10 : 用户申请电子会员卡信息提交
 */
@Service("moba10")
public class MOBA10ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ApplyCardRoot root = new ApplyCardRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String realname = parameter.getString("realname");
            String mobile = parameter.getString("mobile");
            String idno = parameter.getString("idno");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba10"));

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
            if (!StringUtils.hasText(realname))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_REALNAME_IS_NULL);
            }
            if (!StringUtils.hasText(mobile) && !StringUtils.hasText(idno))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHONE_AND_IDNO_IS_NULL);
            }
            this.cardTopLinkUserMobileService.userApplyCard(request, userid, sessionid, shopid, realname);
            root.setResult("true");
            root.setMsg("申请电子会员卡成功,请等待审核");
        }
        catch (UserAlreadyApplyException e)
        {//用户已经提交商家会员卡申请
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_ALREADY_SUBMIT_APPLY;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (UserCanNotRepetitionApplyMemberException e)
        {//用户已经提交商家会员卡申请
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_ALREADY_SUBMIT_APPLY;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (UserAlreadyShopMemberException e)
        {//用户已经是商家会员卡
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_ALREADY_IS_SHOP_MEMBER;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (NameFormatErrorException e)
        {//姓名格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_NAME_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (SexFormatErrorException e)
        {//性别信息不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_SEX_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (IdNoFormatErrorException e)
        {//证件号码不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_IDNO_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (BirthdayFormatErrorException e)
        {//出生日期格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_BIRTHDAY_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PhoneFormatErrorException e)
        {//手机号码格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_PHONE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PostCodeFormatErrorException e)
        {//邮政编码格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_POSTCODE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AddressFormatErrorException e)
        {//详细地址格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_ADDRESS_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_FAIL;
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

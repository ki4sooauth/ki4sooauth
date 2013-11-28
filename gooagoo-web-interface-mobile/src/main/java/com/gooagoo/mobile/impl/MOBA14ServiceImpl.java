package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.member.MemberFeatureException;
import com.gooagoo.exception.business.user.AddressFormatErrorException;
import com.gooagoo.exception.business.user.BirthdayFormatErrorException;
import com.gooagoo.exception.business.user.EmailFormatErrorException;
import com.gooagoo.exception.business.user.IdNoFormatErrorException;
import com.gooagoo.exception.business.user.NameFormatErrorException;
import com.gooagoo.exception.business.user.PhoneFormatErrorException;
import com.gooagoo.exception.business.user.PostCodeFormatErrorException;
import com.gooagoo.exception.business.user.SexFormatErrorException;
import com.gooagoo.exception.business.user.TelephoneFormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba14.transform.UpdateMemberBaseInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBA14:修改会员信息
 */
@Service("moba14")
public class MOBA14ServiceImpl implements ImobileService
{
    @Autowired
    private CardTopLinkUserMobileService cardTopLinkUserMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String idtype = parameter.getString("idtype");
            String idno = parameter.getString("idno");
            String mobile = parameter.getString("mobile");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "moba14"));

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

            boolean bool = this.cardTopLinkUserMobileService.updateMemberBaseInfo(request, userid, sessionid, shopid, idtype, idno, mobile);
            if (bool)
            {
                root.setResult("true");
                root.setMsg("修改会员信息成功");
            }
        }
        catch (NullException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_IDTYPE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (MemberFeatureException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_MEMBER_FEATURE_INFO_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (EmailFormatErrorException e)
        {//邮箱格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_EMAIL_FORMATTER_ERROR;
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
        {//证件号码格式不正确
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
        catch (TelephoneFormatErrorException e)
        {//联系电话不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_TELPHONE_FORMATTER_ERROR;
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
            String err = MessageConst.MOBILE_CARDTOP_UPD_MEMBER_INFO_FAIL;
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

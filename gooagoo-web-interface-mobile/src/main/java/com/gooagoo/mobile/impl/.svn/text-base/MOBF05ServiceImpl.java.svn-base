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
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf05.transform.MemberChangeBaseInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * MOBF05:用户更改基本信息
 * @author Administrator
 *
 */

@Service("mobf05")
public class MOBF05ServiceImpl implements ImobileService
{
    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf04"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf05"));
            this.infoSetMobileService.userChangeBaseInfo(userId, sessionId, request);
            root.setResult("true");
            root.setMsg("用户更改基本信息成功");
        }
        catch (NullException e)
        {//该证件类型不存在
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_IDTYPE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (NameFormatErrorException e)
        {//姓名格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_NAME_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (SexFormatErrorException e)
        {//证件号码格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_SEX_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (IdNoFormatErrorException e)
        {//性别格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_IDNO_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (BirthdayFormatErrorException e)
        {//出生日期格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_BIRTHDAY_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PhoneFormatErrorException e)
        {//联系电话格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_PHONE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (PostCodeFormatErrorException e)
        {//邮政编码格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_POSTCODE_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AddressFormatErrorException e)
        {//详细地址格式不正确
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_ADDRESS_FORMATTER_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {//用户更改基本信息失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SET_UPD_BASEINFO_FAIL;
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

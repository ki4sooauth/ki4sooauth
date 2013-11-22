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
import com.gooagoo.mobile.api.ConsigneeInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobo02.transform.EditConsigneeInfoRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobo02")
public class MOBO02ServiceImpl implements ImobileService
{

    @Autowired
    private ConsigneeInfoMobileService consigneeInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        EditConsigneeInfoRoot root = new EditConsigneeInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String consigneeid = parameter.getString("consigneeid");
            String consigneename = parameter.getString("consigneename");
            String province = parameter.getString("province");
            String city = parameter.getString("city");
            String area = parameter.getString("area");
            String address = parameter.getString("address");
            String phone = parameter.getString("phone");//手机号码和联系电话,两者二选一必填
            String telephone = parameter.getString("telephone");
            String isdefault = parameter.getString("isdefault");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobo02"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(consigneeid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CONSIGNEEINFO_IS_NULL);
            }
            if (!StringUtils.hasText(consigneename))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CONSIGNEENAME_IS_NULL);
            }
            if (!StringUtils.hasText(province))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PROVINCE_IS_NULL);
            }
            if (!StringUtils.hasText(city))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CITY_IS_NULL);
            }
            if (!StringUtils.hasText(area))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_AREA_IS_NULL);
            }
            if (!StringUtils.hasText(address))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ADDRESS_IS_NULL);
            }
            if (!StringUtils.hasText(phone) || !StringUtils.hasText(telephone))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PHONE_AND_TELPHONE_IS_NULL);
            }
            if (!StringUtils.hasText(isdefault))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ISDEFAULT_IS_NULL);
            }
            this.consigneeInfoMobileService.editConsigneeInfo(userId, sessionId, parameter);
            root.setResult("true");
            root.setMsg("编辑用户收货地址信息 成功");
        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
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

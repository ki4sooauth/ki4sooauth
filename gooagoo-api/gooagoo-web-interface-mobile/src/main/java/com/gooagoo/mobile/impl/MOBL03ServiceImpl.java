package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.AudioMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobl03.transform.ApprovePlayVoucherSoundRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobl03")
public class MOBL03ServiceImpl implements ImobileService
{

    @Autowired
    private AudioMobileService audioMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ApprovePlayVoucherSoundRoot root = new ApprovePlayVoucherSoundRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String voucherId = parameter.getString("voucherid");
            String userId = parameter.getString("userid");
            String shopId = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobl03"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(voucherId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_VOUCHERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            this.audioMobileService.approvePlayVoucherSoundRoot(voucherId, userId, shopId);
            root.setResult("true");
            root.setMsg("允许用户播放提货凭证音频 ");
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

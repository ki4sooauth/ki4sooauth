package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf08.transform.GetGooagooIdRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口 MOBF08 : 获取gooagooid 
 * */

@Service("mobf08")
public class MOBF08ServiceImpl implements ImobileService
{
    @Autowired
    private InfoSetMobileService infoSetMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetGooagooIdRoot root = new GetGooagooIdRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String mId = parameter.getString("mid");
            String mVer = parameter.getString("mver");
            String mType = parameter.getString("mtype");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobf08"));

            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAC_IS_NULL);
            }

            String gooagooId = this.infoSetMobileService.getGooagooId(mac, mId, mVer, mType);
            if (StringUtils.hasText(gooagooId))
            {
                root.setMsg("获取gooagooid成功");
                root.setResult("true");
                root.setGooagooid(gooagooId);
            }
            else
            {
                root.setMsg("获取gooagooid失败");
            }

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

package com.gooagoo.mobile.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.common.HttpClientUtils;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.common.UrlConst;
import com.gooagoo.mobile.entity.mobh01.transform.ServiceTriggerMarketingRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * MOBH01: 刷卡
 * */

@Service("mobh01")
public class MOBH01ServiceImpl implements ImobileService
{
    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        ServiceTriggerMarketingRoot root = new ServiceTriggerMarketingRoot();
        root.setResult("false");
        root.setUrl(null);
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String shopid = parameter.getString("shopid");
            String userid = parameter.getString("userid");
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            BehaveLog behaveLog = new BehaveLog();
            behaveLog.setShopId(parameter.getString("shopid"));
            behaveLog.setUserId(parameter.getString("userid"));
            behaveLog.setBehaveType("A");
            behaveLog.setBehaveTime(new Date());
            behaveLog.setObjectValue("11");
            GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
            message.setUuid(UUID.getUUID());
            message.setBehaveType("A");
            message.setBehaveCode("mobh01");
            message.setFlag(true);
            message.setSource("1");//手机
            message.setContent(behaveLog);
            List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
            paramlist.add(new BasicNameValuePair("behave", JsonUtils.toJson(message)));
            String url = HttpClientUtils.HttpPost(UrlConst.ANALYSIS_URL, paramlist);
            if (!StringUtils.hasText(url))
            {
                throw new MessageException("营销地址不存在");
            }
            root.setUrl(url);
            root.setResult("true");
        }
        catch (Exception e)
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

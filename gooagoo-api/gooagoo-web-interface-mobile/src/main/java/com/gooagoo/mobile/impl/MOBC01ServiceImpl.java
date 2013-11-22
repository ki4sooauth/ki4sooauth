package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CryoutMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobc01.transform.CryoutListgRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobc01")
public class MOBC01ServiceImpl implements ImobileService
{
    @Autowired
    private CryoutMobileService cryoutMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        CryoutListgRoot root = new CryoutListgRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String pagetype = parameter.getString("pagetype");
            String type = parameter.getString("type");
            String pageId = parameter.getString("pageid");
            String gpsx = parameter.getString("gpsx");
            String gpsy = parameter.getString("gpsy");
            String pageSize = parameter.getString("pagesize");
            String infotype = parameter.getString("infotype");
            String userId = parameter.getString("userid");
            String cTimeStamp = parameter.getString("ctimestamp");
            String shopId = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobc01"));

            //当“type-查询吆喝类型”为“D-周边商家”时，gpsx维度，gpsy经度不能为空
            if (type.equals("D") && !StringUtils.hasText(gpsx))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASX_IS_NULL);
            }
            if (type.equals("D") && !StringUtils.hasText(gpsy))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASY_IS_NULL);
            }
            if (!StringUtils.hasText(type))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TYPE_IS_NULL);
            }
            if (!pagetype.contains("P") && !pagetype.contains("N"))
            {//分页类型不正确
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_ERROR);
            }
            root = this.cryoutMobileService.getCryoutListg(shopId, userId, pageId, pagetype, pageSize, type, gpsx, gpsy, infotype, cTimeStamp);
            root.setMsg("查询商家吆喝成功");
            root.setResult("true");
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

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
import com.gooagoo.mobile.entity.mobc03.transform.CryoutPlazaShopListRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobc03")
public class MOBC03ServiceImpl implements ImobileService
{
    @Autowired
    private CryoutMobileService cryoutMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        CryoutPlazaShopListRoot root = new CryoutPlazaShopListRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);

            String keyword = parameter.getString("keyword");
            String type = parameter.getString("type");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobc03"));

            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.cryoutMobileService.getCryoutPlazaShopList(keyword, type, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询吆喝广场商家列表成功");
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

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.mobile.api.CryoutMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobc07.transform.RecommendCryoutListRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobc07")
public class MOBC07ServiceImpl implements ImobileService
{
    @Autowired
    private CryoutMobileService cryoutMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        RecommendCryoutListRoot root = new RecommendCryoutListRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            root = this.cryoutMobileService.getRecommendCryoutList(userId);
            root.setResult("true");
            root.setMsg("查询系统吆喝成功");

        }
        catch (Exception e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_COMMON_SYSTEM_EXCEPTION;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CryoutMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.entity.mobc02.transform.CryoutPlazaRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobc02")
public class MOBC02ServiceImpl implements ImobileService
{

    @Autowired
    private CryoutMobileService cryoutMobileService;

    /**
     * 查询吆喝广场分类
     * @return
     * @throws UserException 
     */

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        CryoutPlazaRoot root = new CryoutPlazaRoot();
        root.setResult("false");
        try
        {
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobc02"));
            root = this.cryoutMobileService.getCryoutPlazaMenu();
            root.setResult("true");
            root.setMsg("查询吆喝广场侧边栏分类成功");
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

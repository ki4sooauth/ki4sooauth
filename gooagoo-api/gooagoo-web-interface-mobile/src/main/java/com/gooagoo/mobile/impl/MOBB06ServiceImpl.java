package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.FavoriateMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.entity.mobb06.transform.FavoritePlazaMenuRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口 mobb06 : 收藏广场列表侧边栏 
 */
@Service("mobb06")
public class MOBB06ServiceImpl implements ImobileService
{

    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        FavoritePlazaMenuRoot root = new FavoritePlazaMenuRoot();
        root.setResult("false");
        try
        {//获取传入参数,做非空校验
         //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb06"));
            root = this.favoriateMobileService.getFavoritePlazaMenu();
            root.setResult("true");
            root.setMsg("获取收藏广场列表侧边栏成功");
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

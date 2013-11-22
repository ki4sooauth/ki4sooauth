package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.SysConfigurationTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsa01.transform.SystemConfigurationRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 *接口GTSA01:系统初始化配置
 * 
 * */

@Service("gtsa01")
public class GTSA01ServiceImpl implements ItransService
{
    @Autowired
    private SysConfigurationTransService sysConfigurationTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            //记录入参日志
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsa01"));
            String mac = parameter.getString("mac");

            //必填入参校验
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }

            root = this.sysConfigurationTransService.getSysConfigurationInfo(mac);
            root.setResult("true");
            root.setMsg("系统初始化配置成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }

}

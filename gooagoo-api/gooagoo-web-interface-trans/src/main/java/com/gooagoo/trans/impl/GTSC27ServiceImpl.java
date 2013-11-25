package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.ServeDishOperateTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc27.transform.HookupRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 查询勾挑请求
 */
@Service("gtsc27")
public class GTSC27ServiceImpl implements ItransService
{
    @Autowired
    private ServeDishOperateTransService serveDishOperateTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        HookupRoot root = new HookupRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopentityid = parameter.getString("shopentityid");
            String ctimestamp = parameter.getString("ctimestamp");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc27"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(ctimestamp))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_CTIMESTAMP_IS_NULL);
            }
            root = this.serveDishOperateTransService.getHookupInfo(mac, shopentityid, ctimestamp);
            root.setResult("true");
            root.setMsg("查询勾挑请求成功");
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
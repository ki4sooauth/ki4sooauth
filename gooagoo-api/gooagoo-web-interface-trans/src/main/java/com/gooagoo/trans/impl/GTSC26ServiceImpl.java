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
import com.gooagoo.trans.entity.gtsc26.transform.EstimateListRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 查询沽清列表
 */
@Service("gtsc26")
public class GTSC26ServiceImpl implements ItransService
{
    @Autowired
    private ServeDishOperateTransService serveDishOperateTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        EstimateListRoot root = new EstimateListRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopentityid = parameter.getString("shopentityid");
            String ctimestamp = parameter.getString("shopentityid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc26"));
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
            this.serveDishOperateTransService.getEstimateListInfo(shopentityid, ctimestamp);
            root.setResult("true");
            root.setMsg("查询沽清列表成功");
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
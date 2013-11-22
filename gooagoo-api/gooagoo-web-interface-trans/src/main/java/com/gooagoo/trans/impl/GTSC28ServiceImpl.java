package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.TableManagerTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc28.transform.TableStateRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 查询房台汇总信息
 */
@Service("gtsc28")
public class GTSC28ServiceImpl implements ItransService
{
    @Autowired
    private TableManagerTransService tableManagerTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {

        TableStateRoot root = new TableStateRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopentityid = parameter.getString("shopentityid");
            String tablesinfo = parameter.getString("tablesinfo");
            String cTimeStamp = parameter.getString("cTimeStamp");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc28"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(tablesinfo))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_TABLESSTATUSINFO_IS_NULL);
            }
            this.tableManagerTransService.saveTableState(mac, shopentityid, cTimeStamp, tablesinfo);
            root.setResult("true");
            root.setMsg("上传房台汇总信息成功");
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
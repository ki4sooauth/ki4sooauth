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
import com.gooagoo.trans.entity.gtsc25.transform.BillDetailRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 查询账单明细
 */
@Service("gtsc25")
public class GTSC25ServiceImpl implements ItransService
{
    @Autowired
    private TableManagerTransService tableManagerTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        BillDetailRoot root = new BillDetailRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopEntityId = parameter.getString("shopentityid");
            String cTimeStamp = parameter.getString("shopentityid");
            String dataDetail = parameter.getString("datadetail");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc25"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopEntityId))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(cTimeStamp) && StringUtils.hasText(dataDetail))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_CTIMESTAMP_AND_DATADETAIL_IS_NULL);
            }
            this.tableManagerTransService.getbillDetailInfo(mac, shopEntityId, dataDetail, cTimeStamp);
            root.setResult("true");
            root.setMsg("上传博立协议账单明细成功");
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
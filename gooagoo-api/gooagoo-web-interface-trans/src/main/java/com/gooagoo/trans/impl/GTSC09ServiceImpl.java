package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderLinkTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc09.transform.GetAllDeskStatusRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

/**
 * 获取所有餐桌状态
 */
@Service("gtsc09")
public class GTSC09ServiceImpl implements ItransService
{
    @Autowired
    private OrderLinkTransService orderLinkTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String shopentityid = parameter.getString("shopentityid");
            String pageIndex = parameter.getString("pageindex");
            String pageSize = parameter.getString("pagesize");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc09"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(pageIndex))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.orderLinkTransService.getAllDeskStatus(shopentityid, pageIndex, pageSize);
            root.setResult("true");
            root.setMsg("查询所有餐桌状态成功");
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

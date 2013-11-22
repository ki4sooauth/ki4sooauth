package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.DeskLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasj09.transform.MergeTableRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 餐桌并台管理
 */
@Service("gasj09")
public class GASJ09ServiceImpl implements IgasService
{
    @Autowired
    private DeskLinkGasService deskLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        MergeTableRoot root = new MergeTableRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopUserId = parameter.getString("shopuserid");
            String shopentityid = parameter.getString("shopentityid");
            String tablenameto = parameter.getString("tablenameto");
            String tablenamefrom = parameter.getString("tablenamefrom");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasj09"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopUserId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(tablenameto))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_EXCHANGE_TO_TABLENAME_IS_NULL);
            }
            if (!StringUtils.hasText(tablenamefrom))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_EXCHANGE_FROM_TABLENAME_IS_NULL);
            }
            boolean mergeTableManage = this.deskLinkGasService.mergeTableManage(shopentityid, tablenameto, tablenamefrom);
            if (mergeTableManage)
            {
                root.setResult("true");
                root.setMsg("餐桌并台成功");
            }
            else
            {
                root.setMsg("餐桌并台失败");
            }

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        GasTransData gasTransData = new GasTransData();
        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}

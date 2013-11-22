package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.UserException;
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
import com.gooagoo.gas.entity.gasj05.transform.QueueCancelRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 现场销号
 */
@Service("gasj05")
public class GASJ05ServiceImpl implements IgasService
{
    @Autowired
    private DeskLinkGasService deskLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws UserException, Exception
    {
        QueueCancelRoot root = new QueueCancelRoot();
        root.setResult("false");
        root.setMsg(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String queueno = parameter.getString("queueno");
            String shopentityid = parameter.getString("shopentityid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasj05"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(queueno))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_QUEUE_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            boolean queueCancel = this.deskLinkGasService.queueCancel(shopentityid, queueno);
            if (!queueCancel)
            {
                throw new MessageException(MessageConst.GAS_QUEUE_DEL_FAIL);
            }
            root.setResult("true");
            root.setMsg("销号成功");
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

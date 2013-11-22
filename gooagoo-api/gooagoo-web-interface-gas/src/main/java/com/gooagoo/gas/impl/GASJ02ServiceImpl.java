package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.behave.AlreadyArrangedException;
import com.gooagoo.exception.business.behave.NotNeedArrangeException;
import com.gooagoo.gas.api.service.DeskLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasj02.transform.QueueRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasj02")
public class GASJ02ServiceImpl implements IgasService
{
    @Autowired
    private DeskLinkGasService deskLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        QueueRoot root = new QueueRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String tabletypecode = parameter.getString("tabletypecode");
            String scardno = parameter.getString("scardno");
            String shopuserid = parameter.getString("shopuserid");
            String queuenums = parameter.getString("queuenums");
            String shopid = parameter.getString("shopid");
            String shopentityid = parameter.getString("shopentityid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasj02"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(tabletypecode))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_DESKTYPE_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(queuenums))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_QUEUENUMS_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            root = this.deskLinkGasService.userQueue(shopid, shopentityid, scardno, tabletypecode, queuenums);
            root.setResult("true");
            root.setMsg("排号成功");

        }
        catch (AlreadyArrangedException e)
        {//用户已经排过号
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_QUEUE_ALREADY_ARRANG;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (NotNeedArrangeException e)
        {//餐桌已够用无需排号
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_QUEUE_DESK_FULFIL_USE;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
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

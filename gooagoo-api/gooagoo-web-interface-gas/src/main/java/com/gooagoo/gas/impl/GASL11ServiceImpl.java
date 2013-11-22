package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl11.transform.UpdatePeopleNumsRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 修改台头
 */
@Service("gasl11")
public class GASL11ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        UpdatePeopleNumsRoot root = new UpdatePeopleNumsRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopUserId = parameter.getString("shopuserid");
            String shopentityid = parameter.getString("shopentityid");
            String tablename = parameter.getString("tablename");
            String peoplenums = parameter.getString("peoplenums");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl11"));
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
            if (!StringUtils.hasText(tablename))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_TABLENAME_IS_NULL);
            }
            if (!StringUtils.hasText(peoplenums))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PEOPLENUMS_IS_NULL);
            }
            this.orderLinkGasService.updatePeopleNums(shopentityid, tablename, peoplenums);
            root.setResult("true");
            root.setMsg("修改台头成功");

        }
        catch (OperateFailException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_UPD_HAVA_DINNER_INFO_FAIL;
            root.setMsgcode(err);
            err = ExceptionCache.get(err);
            root.setMsg(err);
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

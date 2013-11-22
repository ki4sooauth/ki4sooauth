package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl02.transform.GetAllBillRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasl02")
public class GASL02ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GetAllBillRoot root = new GetAllBillRoot();
        root.setResult("false");
        root.setDesklist(null);
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String tablename = parameter.getString("tablename");
            String shopentityid = parameter.getString("shopentityid");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl02"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.orderLinkGasService.queryHaveDinnerStatus(shopentityid, tablename, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询已开台餐桌的用餐状态信息成功");
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

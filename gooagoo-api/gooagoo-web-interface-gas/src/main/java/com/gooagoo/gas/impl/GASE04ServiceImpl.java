package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.MemberStatusGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gase04.transform.UserBillDetailRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * MOBA01:用户会员卡列表
 */

@Service("gase04")
public class GASE04ServiceImpl implements IgasService
{
    @Autowired
    private MemberStatusGasService memberStatusGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        UserBillDetailRoot root = new UserBillDetailRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String orderid = parameter.getString("orderid");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gase04"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.memberStatusGasService.queryConsumeTrackDetails(orderid, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询用户在本商家的消费记录明细成功");
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

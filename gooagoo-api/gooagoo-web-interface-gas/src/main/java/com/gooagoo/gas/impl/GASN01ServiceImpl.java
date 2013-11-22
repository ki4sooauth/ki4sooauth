package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.SysConfigurationGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasn01.transform.FindShopBaseInfoRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 查询商家基本信息同步接口
 */
public class GASN01ServiceImpl implements IgasService
{
    @Autowired
    private SysConfigurationGasService sysConfigurationGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        FindShopBaseInfoRoot root = new FindShopBaseInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopUserId = parameter.getString("shopuserid");
            String shopid = parameter.getString("shopid");
            String goodsid = parameter.getString("goodsid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasn01"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopUserId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            root = this.sysConfigurationGasService.findShopBaseInfo(shopid, goodsid);
            root.setResult("true");
            root.setMsg("餐桌换台成功");
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

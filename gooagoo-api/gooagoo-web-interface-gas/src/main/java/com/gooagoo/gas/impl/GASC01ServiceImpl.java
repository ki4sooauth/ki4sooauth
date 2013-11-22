package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.MemberServeGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasc01.transform.QueryGoodsInfoRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 接口gasc01:店员根据自定义序列号查询商品信息
 */

@Service("gasc01")
public class GASC01ServiceImpl implements IgasService
{
    @Autowired
    private MemberServeGasService memberservegasservice;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            //店员助理mac
            String mac = parameter.getString("mac");
            //店员登录帐号
            String shopuserid = parameter.getString("shopuserid");
            //自定义序列号
            String itemserial = parameter.getString("itemserial");
            //实体店编号
            String shopEntityid = parameter.getString("shopentityid");
            //商家编号
            String shopId = parameter.getString("shopid");

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasc01"));

            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(itemserial))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_ITEMSERIAL_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopEntityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            root = this.memberservegasservice.queryGoodsInfo(shopEntityid, itemserial);
            root.setResult("true");
            root.setMsg("店员根据自定义序列号查询商品信息成功");
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

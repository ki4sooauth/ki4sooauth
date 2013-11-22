package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.GoodsGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasd01.transform.CategoryRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 接口gasd01:商家的品类查询
 */

@Service("gasd01")
public class GASD01ServiceImpl implements IgasService
{
    @Autowired
    private GoodsGasService goodsGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        CategoryRoot root = new CategoryRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String shopentityid = parameter.getString("shopentityid");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");
            //记录入参日志
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasd01"));

            //入参非空校验
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
            root = this.goodsGasService.queryGoodsCategoryInfo(shopentityid, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("商家的商品品类查询成功");
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

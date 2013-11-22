package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.DishLinkService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gask01.transform.GetFoodByIdRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 接口gask01:按名称编号查询菜品
 */
@Service("gask01")
public class GASK01ServiceImpl implements IgasService
{

    @Autowired
    private DishLinkService dishLinkService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GetFoodByIdRoot root = new GetFoodByIdRoot();
        root.setResult("false");
        root.setFoodinfolist(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gask01"));
            String mac = parameter.getString("mac");//店员助理MAC地址
            String shopUserId = parameter.getString("shopuserid");//店员登录账号
            String foodsName = parameter.getString("foodname");//菜品名称或者编号（菜名）
            String shopentityid = parameter.getString("shopentityid");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");

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
            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGESIZE_IS_NULL);
            }
            root = this.dishLinkService.queryFoodsInfoByIdOrName(shopentityid, foodsName, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("按名称编号查询菜品信息成功");
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

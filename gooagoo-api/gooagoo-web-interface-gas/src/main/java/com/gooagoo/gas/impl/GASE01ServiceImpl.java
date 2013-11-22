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
import com.gooagoo.gas.entity.gase01.transform.UserListRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 店里所有会员列表查询
 */
@Service("gase01")
public class GASE01ServiceImpl implements IgasService
{
    @Autowired
    private MemberStatusGasService memberStatusGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        UserListRoot root = new UserListRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String positionid = parameter.getString("positionid");
            String pageindex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");
            String shopid = parameter.getString("shopid");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gase01"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(positionid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_POSITIONID_IS_NULL);
            }
            if (!StringUtils.hasText(pageindex))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PAGESIZE_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            root = this.memberStatusGasService.queryShopInsideMemberInfo(shopid, positionid, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询店里会员信息列表成功");
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

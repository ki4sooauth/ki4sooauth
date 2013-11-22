package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.MemberServeGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasc03.transform.UserBaseInfoRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * GASC03:会员卡基本信息查询
 */

@Service("gasc03")
public class GASC03ServiceImpl implements IgasService
{
    @Autowired
    private MemberServeGasService memberservegasservice;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopuserid = parameter.getString("shopuserid");
            String scardno = parameter.getString("scardno");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasc03"));
            if (!StringUtils.hasText(mac))
            {
                throw new GooagooException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new GooagooException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(scardno))
            {
                throw new GooagooException(MessageConst.GAS_PARAMETER_SCARDNO_IS_NULL);
            }
            root = this.memberservegasservice.queryMemberBaseInfo(scardno);
            root.setResult("true");
            root.setMsg("查询会员信息成功");

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

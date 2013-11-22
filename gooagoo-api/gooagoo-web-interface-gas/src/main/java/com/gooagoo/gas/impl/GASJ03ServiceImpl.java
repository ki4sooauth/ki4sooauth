package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.DeskLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasj03.transform.DeskStatusDetailRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 查询餐桌状态及详情
 */
@Service("gasj03")
public class GASJ03ServiceImpl implements IgasService
{
    @Autowired
    private DeskLinkGasService deskLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root.setResult("false");
        root.setDesklist(null);
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);

            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasj03"));

            String mac = parameter.getString("mac");//店员助理MAC地址
            String shopUserId = parameter.getString("shopuserid");//店员登录账号
            String shopentityid = parameter.getString("shopentityid");
            String tabletypecode = parameter.getString("tabletypecode");//餐桌类型
            String tableName = parameter.getString("tablename");//餐桌号
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
            root = this.deskLinkGasService.queryDeskStatusDetails(shopentityid, tabletypecode, tableName, pageindex, pagesize);
            root.setResult("true");
            root.setMsg("查询餐桌状态详情成功");

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

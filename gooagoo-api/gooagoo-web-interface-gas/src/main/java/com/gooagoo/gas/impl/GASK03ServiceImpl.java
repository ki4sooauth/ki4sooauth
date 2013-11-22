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
import com.gooagoo.gas.entity.gask03.transform.GetCategoryByDeskNoRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 接口gask03:根据菜品类别查询
 */
@Service("gask03")
public class GASK03ServiceImpl implements IgasService
{
    @Autowired
    private DishLinkService dishLinkService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GetCategoryByDeskNoRoot root = new GetCategoryByDeskNoRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gask03"));
            String mac = parameter.getString("mac");//店员助理MAC地址
            String shopUserId = parameter.getString("shopuserid");//店员登录账号
            String categoryid = parameter.getString("categoryid");//菜品类别id
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
            if (!StringUtils.hasText(categoryid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_FOOD_CATEGORYID_IS_NULL);
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
            root = this.dishLinkService.queryFoodsInfoByCategory(shopentityid, categoryid, pageindex, pagesize);
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

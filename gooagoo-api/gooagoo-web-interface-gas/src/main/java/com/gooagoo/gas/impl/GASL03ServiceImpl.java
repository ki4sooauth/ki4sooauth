package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.OrderAlreadyExistsException;
import com.gooagoo.exception.business.shop.TableNotExistException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasl03.transform.SubmitOrderRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

@Service("gasl03")
public class GASL03ServiceImpl implements IgasService
{
    @Autowired
    private OrderLinkGasService orderLinkGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        GasTransData gasTransData = new GasTransData();
        SubmitOrderRoot root = new SubmitOrderRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String shopuserid = parameter.getString("shopuserid");
            String tablename = parameter.getString("tablename");
            String dietlist = parameter.getString("dietlist");
            String goodsinfo = parameter.getString("goodsinfo");
            String shopentityid = parameter.getString("shopentityid");
            String dishway = parameter.getString("dishway");//起菜方式
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasl03"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(tablename))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_TABLENAME_IS_NULL);
            }
            if (!StringUtils.hasText(goodsinfo))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_DESKJSON_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            String orderId = this.orderLinkGasService.commitCateringOrder(shopid, shopentityid, tablename, goodsinfo, dishway);
            gasTransData.setObjectId(orderId);//订单,用于shopLog的objectCode
            root.setResult("true");
            root.setMsg("点餐订单提交成功");
        }
        catch (OrderAlreadyExistsException e)
        {//餐桌已被占用，请更换餐桌再提交订单
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_TABLE_IS_USE_PLEASE_CHANGE;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (TableNotExistException e)
        {//餐桌不存在
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_BILL_TABLENAME_IS_NOT_EXIST;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}

package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderManageTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc05.transform.UploadBillRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsc05")
public class GTSC05ServiceImpl implements ItransService
{
    @Autowired
    private OrderManageTransService orderManageTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        GtsTransData gtsTransData = new GtsTransData();
        UploadBillRoot root = new UploadBillRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String shopentityid = parameter.getString("shopentityid");
            String data = parameter.getString("data");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc05"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(data))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_BILL_IS_NULL);
            }
            String orderId = this.orderManageTransService.uploadShopBill(mac, data, shopid, shopentityid);
            root.setResult("true");
            root.setMsg("商家账单数据上传成功");
            gtsTransData.setObjectId(orderId);

        }
        catch (GooagooException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.TRANS_BILL_UPLOAD_SHOP_BILL_DATA_FAIL;
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

        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }
}

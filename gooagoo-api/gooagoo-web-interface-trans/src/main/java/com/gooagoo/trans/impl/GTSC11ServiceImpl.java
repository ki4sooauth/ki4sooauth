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
import com.gooagoo.trans.api.OrderLinkTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc11.transform.SwipeCardRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsc11")
public class GTSC11ServiceImpl implements ItransService
{
    @Autowired
    private OrderLinkTransService orderLinkTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        SwipeCardRoot root = new SwipeCardRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String scardno = parameter.getString("scardno");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsc11"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(scardno))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SCARDNO_IS_NULL);
            }
            root = this.orderLinkTransService.swipeCard(scardno, shopid);
            root.setMsg("刷卡成功");
            root.setResult("true");
        }
        catch (GooagooException e)
        {//不是本店会员卡
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.TRANS_BILL_CARD_NOT_PRESENT_SHOP_CARD;
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

        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }

}

package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.ShoppingCartMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobn02.transform.EditGoodsOfShoppingCartRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobn02")
public class MOBN02ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingCartMobileService shoppingCartMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        EditGoodsOfShoppingCartRoot root = new EditGoodsOfShoppingCartRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String shopentityid = parameter.getString("shopentityid");
            String shoppingcartid = parameter.getString("shoppingcartid");
            String goodsnum = parameter.getString("goodsnum");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobn02"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }

            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(shoppingcartid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPPINGCHARTID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsnum))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSNUM_IS_NULL);
            }

            this.shoppingCartMobileService.editGoodsOfShoppingCart(userId, sessionId, shoppingcartid, goodsnum);
            root.setResult("true");
            root.setMsg("编辑购物车中的商品成功");
        }
        catch (OperateFailException e)
        {//编辑商品异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SHOPPINGCART_EDIT_GOODS_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(e.getMessage());
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }

}

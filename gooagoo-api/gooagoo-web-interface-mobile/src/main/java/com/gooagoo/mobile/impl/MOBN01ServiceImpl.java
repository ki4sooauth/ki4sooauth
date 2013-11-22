package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.AlreadyAddShoppingCartException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.ShoppingCartMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobn01.transform.AddGoodsToShoppingCartRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobn01")
public class MOBN01ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingCartMobileService shoppingCartMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {

        AddGoodsToShoppingCartRoot root = new AddGoodsToShoppingCartRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String shopentityid = parameter.getString("shopentityid");
            String goodsid = parameter.getString("goodsid");
            String goodsnum = parameter.getString("goodsnum");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobn01"));

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
            if (!StringUtils.hasText(goodsid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsnum))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSNUM_IS_NULL);
            }
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(userId);
            shoppingCart.setShopId(shopid);
            shoppingCart.setShopEntityId(shopentityid);
            shoppingCart.setGoodsId(goodsid);
            shoppingCart.setGoodsNum(Integer.valueOf(goodsnum));
            String existflag = this.shoppingCartMobileService.addGoodsToShoppingCart(userId, sessionId, goodsid, shopid, shopentityid, goodsnum);
            root.setResult("true");
            root.setMsg("添加商品到购物车成功");
            root.setExistflag(existflag);

        }
        catch (AlreadyAddShoppingCartException e)
        {//调用接口异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SHOPPINGCART_CALL_API_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(e.getMessage());
        }
        catch (OperateFailException e)
        {//添加商品异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SHOPPINGCART_ADD_GOODS_FAIL;
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

package com.gooagoo.igus.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.transaction.order.ShoppingCartCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.igus.service.IGusService;

/**
 * 加入购物车
 * @author SPZ
 *
 */
@Service("igus003Service")
public class IGus003ServiceImpl implements IGusService
{

    @Autowired
    private ShoppingCartCoreService shoppingCartCoreService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            ShoppingCart shoppingCart = ServletUtils.objectMethod(ShoppingCart.class, request);
            shoppingCart.setUserId(userId);
            String result = this.shoppingCartCoreService.addShoppingCart(shoppingCart);
            if (!("Y".equals(result) || "N".equals(result)))
            {
                GooagooLog.error("加入购物车：加入购物车（userId=" + shoppingCart.getUserId() + "&shopId=" + shoppingCart.getShopId() + "&shopEntityId=" + shoppingCart.getShopEntityId() + "&goodsId=" + shoppingCart.getGoodsId() + "&goodsNum=" + shoppingCart.getGoodsNum() + "）失败", null);
                return new TransData<Object>(false, MessageConst.SHOPPINGCART_ERROR, null);//TODO 加入购物车失败
            }
            transData = new TransData<Object>(true, MessageConst.SHOPPINGCART_RIGHT, null);//TODO 加入购物车成功
        }
        catch (Exception e)
        {
            GooagooLog.error("加入购物车：加入购物车异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_SYSTEM_EXCEPTION, null);//TODO 系统异常
        }
        return transData;
    }

}

package com.gooagoo.igms.shopinfo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.user.ShopUserLoginQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;

@Service(value = "shopLoginService")
public class ShopLoginServiceImpl implements ShopLoginService
{
    @Autowired
    private ShopUserLoginQueryService shopUserLoginQueryService;

    @Override
    public ShopLoginInfo getShopLoginInfo(String token)
    {
        ShopLoginInfo shopDetailInfo = null;
        try
        {
            shopDetailInfo = this.shopUserLoginQueryService.queryShopDetailInfo(token, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家登录信息失败，token=" + token, e);
            shopDetailInfo = null;
        }
        return shopDetailInfo;
    }

    @Override
    public ShopLoginInfo getShopLoginInfo(HttpServletRequest request) throws Exception
    {
        String token = GmsInterfaceUtil.getShopLoginTokenByInterface(request);
        return this.getShopLoginInfo(token);
    }

}

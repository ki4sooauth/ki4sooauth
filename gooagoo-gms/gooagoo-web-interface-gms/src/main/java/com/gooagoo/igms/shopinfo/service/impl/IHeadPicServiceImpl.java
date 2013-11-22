package com.gooagoo.igms.shopinfo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.shopinfo.ShopInfoCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IHeadPicService;
import com.gooagoo.igms.shopinfo.service.IShopInfoCacheService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.shopinfo.FHeadPic;
import com.gooagoo.view.gms.shopinfo.FShopInfo;

@Service("iheadPicService")
public class IHeadPicServiceImpl implements IHeadPicService
{

    @Autowired
    private ShopInfoCoreService shopInfoCoreService;
    @Autowired
    private IShopInfoCacheService iShopInfoCacheService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<FHeadPic> getHeadPic(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        FShopInfo fShopInfo = this.iShopInfoCacheService.getFShopInfo(shopInfo.getShopAndUserInfo().getShopId());
        FHeadPic headPic = new FHeadPic();
        String string[] = fShopInfo.getLogo().split(",");
        String temp = string[0].trim();
        headPic.setSuImg(temp);
        if (!temp.isEmpty())
        {
            String t[] = temp.split(".");
            if (t.length == 2)
            {
                temp = t[0] + "_s" + t[1];
            }
        }
        headPic.setSuSmallImg(temp);

        temp = string[1].trim();
        headPic.setShImg(temp);
        if (!temp.isEmpty())
        {
            String t[] = temp.split(",");
            if (t.length == 2)
            {
                temp = t[0] + "_s" + t[1];
            }
        }
        headPic.setShSmallImg(temp);
        return GMSUtil.toTransData(true, null, headPic);
    }

    @Override
    public TransData<Object> updateSHeadPic(HttpServletRequest request) throws Exception
    {
        String suImg = ServletRequestUtils.getStringParameter(request, "suImg", "");
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String token = GmsInterfaceUtil.getShopLoginTokenByInterface(request);
        boolean flag = this.shopInfoCoreService.updateShopLogo(shopInfo.getShopAndUserInfo().getShopId(), suImg, token);

        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }

    @Override
    public TransData<Object> updateUHeadPic(HttpServletRequest request) throws Exception
    {
        String shImg = ServletRequestUtils.getStringParameter(request, "shImg", "");
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String token = GmsInterfaceUtil.getShopLoginTokenByInterface(request);
        boolean flag = this.shopInfoCoreService.updateShopHead(shopInfo.getShopAndUserInfo().getShopId(), shImg, token);

        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }
}

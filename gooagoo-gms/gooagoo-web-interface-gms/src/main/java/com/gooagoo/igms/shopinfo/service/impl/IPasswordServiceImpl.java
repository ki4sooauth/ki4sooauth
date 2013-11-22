package com.gooagoo.igms.shopinfo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.user.ShopUserPasswordCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.igms.shopinfo.service.IPasswordService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;

@Service("ipasswordService")
public class IPasswordServiceImpl implements IPasswordService
{

    @Autowired
    private ShopUserPasswordCoreService coreShopInfoService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<Object> updatePwd(HttpServletRequest request) throws Exception
    {
        String oldPwd = ServletRequestUtils.getStringParameter(request, "oldPassword");
        String newPwd = ServletRequestUtils.getStringParameter(request, "newPassword");
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);

        String shopid = shopInfo.getShopAndUserInfo().getShopId();
        String userId = shopInfo.getShopAndUserInfo().getUserId();
        boolean flag = true;
        try
        {
            flag = this.coreShopInfoService.updatePassword(shopid, userId, oldPwd, newPwd);
        }
        catch (Exception e)
        {
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_BASE_ORGPASSWORD_FAIL);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopid);
    }
}

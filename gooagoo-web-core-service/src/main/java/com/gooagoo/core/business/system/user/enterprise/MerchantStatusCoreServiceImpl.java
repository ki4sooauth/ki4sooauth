package com.gooagoo.core.business.system.user.enterprise;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.MerchantStatusCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserRole2GeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class MerchantStatusCoreServiceImpl implements MerchantStatusCoreService
{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;
    @Autowired
    private ShopUserRole2GeneratorCoreService shopUserRole2GeneratorCoreService;

    @Override
    public boolean updateMerchantStatus(String shopId, String shopStatus, String note) throws Exception
    {

        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setShopStatus(shopStatus);
        shopInfo.setNote(note);
        if (!this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo))
        {
            GooagooLog.error("修改商家状态异常[shopInfo=" + shopInfo.toString() + "]", null);
            return false;
        }
        return true;
    }

    @Override
    public boolean checkMerchant(String shopId, String shopStatus, String note) throws Exception
    {
        //1、修改商家状态
        ShopInfo shopInfo = this.shopInfoGeneratorCoreService.selectUnDelByPrimaryKey(shopId);
        if (!"W".equals(shopInfo.getShopStatus()))
        {
            GooagooLog.debug("审核商家:商家状态不是待审核状态、不能做审核操作[shopStatus=" + shopInfo.getShopStatus() + "]");
            return false;
        }
        shopInfo.setShopStatus(shopStatus);
        shopInfo.setNote(note);
        if (!this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo))
        {
            GooagooLog.error("修改商家状态异常[shopInfo=" + shopInfo.toString() + "]", null);
            return false;
        }
        //2、给予默认权限
        ShopUserRole2 shopUserRole2 = this.shopUserRole2GeneratorCoreService.selectUnDelByPrimaryKey(shopId);
        if (shopUserRole2 == null)
        {
            GooagooLog.debug("审核商家:该商家没有用户-角色关联2权限异常[shopId=" + shopId + "]");
            return false;
        }
        //只有持有注册默认权限时才要给予审核默认权限
        ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
        String registerRoleId = bundle.getString("register_default_role");
        if (registerRoleId.equals(shopUserRole2.getRoleId()))
        {
            String checkRoleId = bundle.getString("check_default_role");
            shopUserRole2.setRoleId(checkRoleId);
            shopUserRole2.setIsDel("N");
            if (!this.shopUserRole2GeneratorCoreService.updateByPrimaryKeySelective(shopUserRole2))
            {
                GooagooLog.error("审核商家：添加默认权限（" + shopUserRole2.toString() + "）异常", null);
                throw new OperateFailException("审核商家：添加默认权限（" + shopUserRole2.toString() + "）异常");
            }
        }
        return true;
    }

}

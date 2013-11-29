package com.gooagoo.core.business.shop.shopinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.shopinfo.ShopInfoCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.redis.data.RedisObjectDao;
import com.google.gson.Gson;

@Service
public class ShopInfoCoreServiceImpl implements ShopInfoCoreService
{
    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Override
    public boolean updateShopBaseInfo(String token, ShopInfo shopInfo) throws Exception
    {
        boolean isOK = this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);
        if (isOK)
        {
            this.freshShopLoginInfo(token, shopInfo);
        }
        return true;
    }

    @Override
    public boolean updateShopInfo(String shopId, String nickName, String token) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            GooagooLog.warn("修改商家昵称：主键为空，shopId=" + shopId);
            return false;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setNickName(nickName);
        boolean isOk = this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);
        if (isOk)
        {
            this.freshShopLoginInfo(token, shopInfo);
        }
        return isOk;
    }

    @Override
    public boolean updateShopLogo(String shopId, String url, String token) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            GooagooLog.warn("修改商家logo：主键为空，shopId=" + shopId);
            return false;
        }
        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("修改商家logo：图片地址为空，shopId=" + shopId + ",url=" + url);
            return false;
        }
        ShopInfo shop_db = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopId);
        if (shop_db == null)
        {
            GooagooLog.warn("修改商家logo：商家不存在，shopId=" + shopId);
            return false;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setLogo2(url);
        boolean isOk = this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);
        if (isOk)
        {
            this.freshShopLoginInfo(token, shopInfo);
        }
        return isOk;
    }

    @Override
    public boolean updateShopHead(String shopId, String url, String token) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            GooagooLog.warn("修改商家图标：主键为空，shopId=" + shopId);
            return false;
        }
        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("修改商家图标：图片地址为空，shopId=" + shopId + ",url=" + url);
            return false;
        }
        ShopInfo shop_db = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopId);
        if (shop_db == null)
        {
            GooagooLog.warn("修改商家图标：商家不存在，shopId=" + shopId);
            return false;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setLogo1(url);
        boolean isOk = this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);

        if (isOk)
        {
            this.freshShopLoginInfo(token, shopInfo);
        }
        return isOk;
    }

    @Override
    public boolean normalBusiness(String shopId) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            GooagooLog.warn("正常营业：主键为空，shopId=" + shopId);
            return false;
        }
        ShopInfo shop = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopId);
        if (shop == null)
        {
            GooagooLog.warn("正常营业：此商家不存在，shopId=" + shopId);
            return false;
        }
        if (!"P".equals(shop.getShopStatus()))
        {
            GooagooLog.warn("正常营业：商家不是待营业状态，shopId=" + shopId);
            return false;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setShopStatus("U");
        boolean isOk = this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);
        return isOk;
    }

    private void freshShopLoginInfo(String token, ShopInfo shopInfo)
    {
        if (!StringUtils.hasText(token))
        {
            GooagooLog.info("freshShopLoginInfo,token=" + token);
            return;
        }
        RedisObjectDao objectDao = new RedisObjectDao("login_gms");
        ShopLoginInfo shopLoginInfo = (ShopLoginInfo) objectDao.get(token);
        if (shopLoginInfo == null)
        {
            GooagooLog.info("freshShopLoginInfo,通过token取登录信息ShopLoginInfo为空，token=" + token);
            return;
        }
        if (!shopInfo.getShopId().equals(shopLoginInfo.getShopAndUserInfo().getShopId()))
        {
            GooagooLog.info("freshShopLoginInfo,shopId不一致，shopInfo.getShopId()=" + shopInfo.getShopId() + ",shopLoginInfo=" + new Gson().toJson(shopLoginInfo));
            return;
        }
        if (StringUtils.hasText(shopInfo.getLogo1()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopLogo1(shopInfo.getLogo1());
        }
        if (StringUtils.hasText(shopInfo.getLogo2()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopLogo2(shopInfo.getLogo2());
        }
        if (StringUtils.hasText(shopInfo.getNickName()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopNickName(shopInfo.getNickName());
        }
        if (StringUtils.hasText(shopInfo.getShopName()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopName(shopInfo.getShopName());
        }
        if (shopInfo.getShopTypeRoot() != null)
        {
            shopLoginInfo.getShopAndUserInfo().setShopTypeRoot(shopInfo.getShopTypeRoot());
        }
        if (shopInfo.getShopTypeLeaf() != null)
        {
            shopLoginInfo.getShopAndUserInfo().setShopTypeLeaf(shopInfo.getShopTypeLeaf());
        }
        if (StringUtils.hasText(shopInfo.getScope()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopScope(shopInfo.getScope());
        }
        if (StringUtils.hasText(shopInfo.getIsChain()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopIsChain(shopInfo.getIsChain());
        }
        if (StringUtils.hasText(shopInfo.getServiceStyle()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopServiceStyle(shopInfo.getServiceStyle());
        }
        if (StringUtils.hasText(shopInfo.getNickName()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopNickName(shopInfo.getNickName());
        }
        if (StringUtils.hasText(shopInfo.getShopStatus()))
        {
            shopLoginInfo.getShopAndUserInfo().setShopStatus(shopInfo.getShopStatus());
        }
        objectDao.set(token, shopLoginInfo);
    }

}

package com.gooagoo.query.business.shop.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.query.ShopQueryService;
import com.gooagoo.api.business.query.shop.user.ShopUserLoginQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;

@Service
public class ShopUserLoginQueryServiceImpl implements ShopUserLoginQueryService

{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private ShopUserInfoGeneratorQueryService shopUserInfoGeneratorQueryService;

    @Autowired
    private ShopQueryService shopQueryService;

    @Override
    public ShopLoginInfo login(String account, String password, Integer expireSecond) throws Exception
    {
        //1、校验登录信息
        this.checkLoginData(account, password);
        //2、获取商家营销中心用户信息
        ShopUserInfo shopUserInfo = this.getShopUserInfo(account, password);
        //3、获取商家信息
        ShopInfo shopInfo = this.getShopInfo(shopUserInfo);
        //4、获取商家用户登录数据
        ShopLoginInfo shopLoginInfo = this.shopQueryService.getShopLoginInfo(shopInfo, shopUserInfo);
        //5、登录信息放入缓存
        String token = UUID.getUUID();
        shopLoginInfo.setToken(token);
        RedisObjectDao objectDao = new RedisObjectDao("login_gms");
        objectDao.set(token, shopLoginInfo);
        if (expireSecond != null)
        {
            RedisDatabase redisDatabase = new RedisDatabase("login_gms");
            redisDatabase.setExpire(token, expireSecond);
        }

        return shopLoginInfo;
    }

    /**
     * 校验商家用户登录数据
     * @param account
     * @param password
     * @return
     * @throws NullException
     */
    private boolean checkLoginData(String account, String password) throws NullException
    {
        //1、校验账户
        if (StringUtils.isBlank(account))
        {
            GooagooLog.info("校验商家用户登录数据：账户（" + account + "）为空");
            throw new NullException("账户（" + account + "）为空");
        }
        //2、校验密码
        if (StringUtils.isBlank(password))
        {
            GooagooLog.info("校验商家用户登录数据：账户（" + account + "）输入的密码（" + password + "）为空");
            throw new NullException("账户（" + account + "）输入的密码（" + password + "）为空");
        }

        return true;
    }

    /**
     * 获取商家营销中心用户信息
     * @param account
     * @param password
     * @return
     * @throws AccountNotExistException
     * @throws PasswordIncorrectException
     * @throws AccountIsLockedException
     */
    private ShopUserInfo getShopUserInfo(String account, String password) throws AccountNotExistException, PasswordIncorrectException, AccountIsLockedException
    {
        ShopUserInfo shopUserInfo = this.shopUserInfoGeneratorQueryService.selectByPrimaryKey(account);
        if (shopUserInfo == null || "Y".equals(shopUserInfo.getIsDel()))
        {
            GooagooLog.info("获取商家营销中心用户信息：账户（" + account + "）不存在");
            throw new AccountNotExistException("账户（" + account + "）不存在");
        }
        if (!new Md5Utils().encrypt(password).equals(shopUserInfo.getPassword()))
        {
            GooagooLog.info("获取商家营销中心用户信息：账户（" + account + "）密码（" + password + "）不正确（" + shopUserInfo.getPassword() + "）");
            throw new PasswordIncorrectException("账户（" + account + "）密码（" + password + "）不正确（" + shopUserInfo.getPassword() + "）");
        }
        if ("N".equals(shopUserInfo.getIsShopAccount()) && "0".equals(shopUserInfo.getStatus()))
        {
            GooagooLog.info("获取商家营销中心用户信息：账户（" + account + "）已被锁定");
            throw new AccountIsLockedException("账户（" + account + "）已被锁定");
        }

        return shopUserInfo;
    }

    /**
     * 获取商家信息
     * @param shopUserInfo
     * @return
     * @throws AccountNotExistException
     * @throws AccountIsLockedException
     */
    private ShopInfo getShopInfo(ShopUserInfo shopUserInfo) throws AccountNotExistException, AccountIsLockedException
    {
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopUserInfo.getShopId());
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("获取商家信息：商家（" + shopUserInfo.getShopId() + "）不存在");
            throw new AccountNotExistException("商家（" + shopUserInfo.getShopId() + "）不存在");
        }
        if ("L".equals(shopInfo.getShopStatus()) && "N".equals(shopUserInfo.getIsShopAccount()))
        {
            GooagooLog.info("获取商家信息：账户（" + shopUserInfo.getUserId() + "）所属商家（" + shopUserInfo.getShopId() + "）已被锁定");
            throw new AccountIsLockedException("账户（" + shopUserInfo.getUserId() + "）所属商家（" + shopUserInfo.getShopId() + "）已被锁定");
        }

        return shopInfo;
    }

    @Override
    public ShopLoginInfo queryShopDetailInfo(String token, Integer expireSecond) throws Exception
    {
        if (StringUtils.isBlank(token))
        {
            return null;
        }
        RedisObjectDao objectDao = new RedisObjectDao("login_gms");
        Object o = objectDao.get(token);
        if (o == null)
        {
            return null;
        }
        if (expireSecond != null)
        {
            RedisDatabase redisDatabase = new RedisDatabase("login_gms");
            redisDatabase.setExpire(token, expireSecond);
        }
        return (ShopLoginInfo) o;
    }

}

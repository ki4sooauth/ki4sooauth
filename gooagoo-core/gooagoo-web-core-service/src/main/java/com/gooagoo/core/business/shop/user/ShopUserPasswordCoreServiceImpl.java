package com.gooagoo.core.business.shop.user;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.shop.user.ShopUserPasswordCoreService;
import com.gooagoo.api.generator.core.shop.ShopEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserInfoGeneratorCoreService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;

@Service
public class ShopUserPasswordCoreServiceImpl implements ShopUserPasswordCoreService

{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Autowired
    private ShopUserInfoGeneratorCoreService shopUserInfoGeneratorCoreService;

    @Autowired
    private ShopEmailactiveCodeGeneratorCoreService shopEmailactiveCodeGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean resetPassword(String password, String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、数据校验
        this.checkResetPasswordData(password, activeCode);
        //2、校验邮箱激活码
        ShopEmailactiveCode shopEmailactiveCode = this.shopEmailactiveCodeGeneratorCoreService.selectByPrimaryKey(activeCode);
        if (shopEmailactiveCode == null || "Y".equals(shopEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("重置密码：邮箱激活码（" + activeCode + "）不存在");
            throw new OperateFailException("邮箱激活码（" + activeCode + "）不存在");
        }
        if ("Y".equals(shopEmailactiveCode.getIsActive()) || currentTime.after(shopEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("重置密码：邮箱激活码（" + activeCode + "）已失效或有误");
            throw new OperateFailException("邮箱激活码（" + activeCode + "）已失效或有误");
        }
        shopEmailactiveCode.setIsActive("Y");
        shopEmailactiveCode.setActiveDate(currentTime);
        if (!this.shopEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(shopEmailactiveCode))
        {
            GooagooLog.error("重置密码：更新邮箱激活码信息（" + shopEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("更新邮箱激活码信息（" + shopEmailactiveCode.toString() + "）异常");
        }
        //3、校验商家
        ShopInfo shopInfo = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopEmailactiveCode.getShopId());
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("重置密码：商家（" + shopEmailactiveCode.getShopId() + "）不存在或已被删除");
            throw new OperateFailException("商家（" + shopEmailactiveCode.getShopId() + "）不存在或已被删除");
        }
        ShopUserInfo shopUserInfo = this.shopUserInfoGeneratorCoreService.selectByPrimaryKey(shopInfo.getEmail());
        if (shopUserInfo == null || "Y".equals(shopUserInfo.getIsDel()))
        {
            GooagooLog.info("重置密码：商家（" + shopInfo.getShopId() + "）用户（" + shopInfo.getEmail() + "）不存在或已被删除");
            throw new OperateFailException("商家（" + shopInfo.getShopId() + "）用户（" + shopInfo.getEmail() + "）不存在或已被删除");
        }
        if ("N".equals(shopUserInfo.getIsShopAccount()))
        {
            GooagooLog.info("重置密码：用户（" + shopInfo.getEmail() + "）非商家（" + shopInfo.getShopId() + "）账号");
            throw new OperateFailException("用户（" + shopInfo.getEmail() + "）非商家（" + shopInfo.getShopId() + "）账号");
        }
        //4、重置密码
        shopUserInfo.setPassword(new Md5Utils().encrypt(password));
        if (!this.shopUserInfoGeneratorCoreService.updateByPrimaryKeySelective(shopUserInfo))
        {
            GooagooLog.error("重置密码：更新商家用户信息（" + shopUserInfo.toString() + "）异常", null);
            throw new OperateFailException("更新商家用户信息（" + shopUserInfo.toString() + "）异常");
        }

        return true;
    }

    @Override
    public boolean updatePassword(String shopId, String userId, String oldPassword, String newPassword) throws Exception
    {
        //1、数据校验
        this.checkUpdatePasswordData(shopId, userId, oldPassword, newPassword);
        //2、校验商家
        ShopInfo shopInfo = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopId);
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("修改密码：修改密码（" + shopId + "）不存在或已被删除");
            throw new OperateFailException("修改密码（" + shopId + "）不存在或已被删除");
        }
        ShopUserInfo shopUserInfo = this.shopUserInfoGeneratorCoreService.selectByPrimaryKey(shopInfo.getEmail());
        if (shopUserInfo == null || "Y".equals(shopUserInfo.getIsDel()) || !userId.equals(shopUserInfo.getUserId()))
        {
            GooagooLog.info("修改密码：商家（" + shopInfo.getShopId() + "）用户（" + userId + "）不存在或已被删除");
            throw new OperateFailException("商家（" + shopInfo.getShopId() + "）用户（" + userId + "）不存在或已被删除");
        }
        //3、验证原密码
        if (!shopUserInfo.getPassword().equals(new Md5Utils().encrypt(oldPassword)))
        {
            GooagooLog.info("修改密码：商家（" + shopId + "）用户（" + userId + "）原密码（" + oldPassword + "）不正确");
            throw new PasswordIncorrectException("商家（" + shopId + "）用户（" + userId + "）原密码（" + oldPassword + "）不正确");
        }
        //4、修改密码
        shopUserInfo.setPassword(new Md5Utils().encrypt(newPassword));
        if (!this.shopUserInfoGeneratorCoreService.updateByPrimaryKeySelective(shopUserInfo))
        {
            GooagooLog.error("修改密码：更新密码（" + shopInfo.toString() + "）异常", null);
            throw new OperateFailException("更新密码（" + shopInfo.toString() + "）异常");
        }

        return true;
    }

    /**
     * 校验重置密码数据
     * @param password
     * @param activeCode
     * @return
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkResetPasswordData(String password, String activeCode) throws FormatErrorException, NullException
    {
        //1、校验密码
        if (StringUtils.isBlank(password))
        {
            GooagooLog.info("校验重置密码数据：新密码（" + password + "）为空");
            throw new NullException("新密码（" + password + "）为空");
        }
        if (password.length() < 6 || password.length() > 20)
        {
            GooagooLog.info("校验重置密码数据：新密码（" + password + "）长度只能在6-20位字符之间");
            throw new FormatErrorException("新密码（" + password + "）长度只能在6-20位字符之间");
        }
        //2、校验校验码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验重置密码数据：校验码（" + activeCode + "）为空");
            throw new NullException("校验码（" + activeCode + "）为空");
        }

        return true;
    }

    /**
     * 校验修改密码数据
     * @param shopId
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkUpdatePasswordData(String shopId, String userId, String oldPassword, String newPassword) throws FormatErrorException, NullException
    {
        //1、校验商家编号
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("校验修改密码数据：商家编号（" + shopId + "）为空");
            throw new NullException("商家编号（" + shopId + "）为空");
        }
        //2、校验商家用户编号
        if (StringUtils.isBlank(userId))
        {
            GooagooLog.info("校验修改密码数据：商家用户编号（" + userId + "）为空");
            throw new NullException("商家用户编号（" + userId + "）为空");
        }
        //3、校验原密码
        if (StringUtils.isBlank(oldPassword))
        {
            GooagooLog.info("校验修改密码数据：原密码（" + oldPassword + "）为空");
            throw new NullException("原密码（" + oldPassword + "）为空");
        }
        //4、校验新密码
        if (StringUtils.isBlank(newPassword))
        {
            GooagooLog.info("校验修改密码数据：新密码（" + newPassword + "）为空");
            throw new NullException("新密码（" + newPassword + "）为空");
        }
        if (newPassword.length() < 6 || newPassword.length() > 20)
        {
            GooagooLog.info("校验重置密码数据：新密码（" + newPassword + "）长度只能在6-20位字符之间");
            throw new FormatErrorException("新密码（" + newPassword + "）长度只能在6-20位字符之间");
        }

        return true;
    }

}

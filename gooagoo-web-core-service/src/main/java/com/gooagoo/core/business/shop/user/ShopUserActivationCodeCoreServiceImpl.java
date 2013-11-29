package com.gooagoo.core.business.shop.user;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.user.ShopUserActivationCodeCoreService;
import com.gooagoo.api.generator.core.shop.ShopEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ShopUserActivationCodeCoreServiceImpl implements ShopUserActivationCodeCoreService

{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Autowired
    private ShopEmailactiveCodeGeneratorCoreService shopEmailactiveCodeGeneratorCoreService;

    @Override
    public String getActivationCode(String account) throws Exception
    {
        Date currentTime = new Date();
        //1、校验账号
        if (StringUtils.isBlank(account))
        {
            GooagooLog.info("获取邮件激活码：邮箱地址（" + account + "）为空");
            throw new NullException("账号（" + account + "）为空");
        }
        if (!DataPatternUtils.chechEmail(account))
        {
            GooagooLog.info("获取邮件激活码：邮箱地址（" + account + "）格式不正确");
            throw new FormatErrorException("邮箱地址（" + account + "）格式不正确");
        }
        //2、校验商家信息
        ShopInfoExample queryCondition = new ShopInfoExample();
        queryCondition.createCriteria().andEmailEqualTo(account).andIsDelEqualTo("N");
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(shopInfoList))
        {
            GooagooLog.info("获取邮件激活码：账号（" + account + "）不存在或已被删除");
            throw new AccountNotExistException("账号（" + account + "）不存在或已被删除");
        }
        if (shopInfoList.size() > 1)
        {
            GooagooLog.info("获取邮件激活码：账号（" + account + "）信息异常");
            throw new AccountNotExistException("账号（" + account + "）信息异常");
        }
        ShopInfo shopInfo = shopInfoList.get(0);
        //3、获取邮件激活码
        ShopEmailactiveCode shopEmailactiveCode = new ShopEmailactiveCode();
        shopEmailactiveCode.setId(UUID.getUUID());
        shopEmailactiveCode.setShopId(shopInfo.getShopId());
        shopEmailactiveCode.setExpDate(TimeUtils.dateAdd(3, currentTime, 2));
        shopEmailactiveCode.setIsActive("N");
        shopEmailactiveCode.setIsDel("N");
        if (!this.shopEmailactiveCodeGeneratorCoreService.insertSelective(shopEmailactiveCode))
        {
            GooagooLog.error("获取邮件激活码：保存邮箱激活码表数据（" + shopEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("保存邮箱激活码表数据（" + shopEmailactiveCode.toString() + "）异常");
        }

        return shopEmailactiveCode.getId();
    }

    @Override
    public boolean checkActivationCode(String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、校验激活码编号
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验邮箱激活码：激活码（" + activeCode + "）为空");
            throw new NullException("激活码（" + activeCode + "）为空");
        }
        //2、校验激活码信息
        ShopEmailactiveCode shopEmailactiveCode = this.shopEmailactiveCodeGeneratorCoreService.selectByPrimaryKey(activeCode);
        if (shopEmailactiveCode == null || "Y".equals(shopEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("校验邮箱激活码：激活码（" + activeCode + "）不存在或已被删除");
            throw new NoDataException("激活码（" + activeCode + "）不存在或已被删除");
        }
        if ("Y".equals(shopEmailactiveCode.getIsActive()))
        {
            GooagooLog.info("校验邮箱激活码：激活码（" + activeCode + "）已被使用");
            throw new NoDataException("激活码（" + activeCode + "）已被使用");
        }
        if (currentTime.after(shopEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("校验邮箱激活码：激活码（" + activeCode + "）已过期");
            throw new NoDataException("激活码（" + activeCode + "）已过期");
        }

        return true;
    }

}

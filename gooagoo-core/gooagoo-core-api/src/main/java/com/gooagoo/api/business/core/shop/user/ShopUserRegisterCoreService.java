package com.gooagoo.api.business.core.shop.user;

import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface ShopUserRegisterCoreService

{
    /**
     * 商家用户注册
     * @param shopInfo
     * @param shopUserInfo
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws AccountAlreadyExistsException
     * @throws OperateFailException
     */
    public boolean register(ShopInfo shopInfo, ShopUserInfo shopUserInfo) throws Exception;

}

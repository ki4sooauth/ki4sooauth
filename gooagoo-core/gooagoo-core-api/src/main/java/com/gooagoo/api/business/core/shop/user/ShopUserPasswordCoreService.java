package com.gooagoo.api.business.core.shop.user;

import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface ShopUserPasswordCoreService

{

    /**
     * 重置密码
     * @param password 密码
     * @param activeCode 激活码
     * @return true/false
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean resetPassword(String password, String activeCode) throws Exception;

    /**
     * 修改密码
     * @param shopId 商家主键
     * @param userId 商家用户主键
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @return true/false
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean updatePassword(String shopId, String userId, String oldPassword, String newPassword) throws Exception;

}

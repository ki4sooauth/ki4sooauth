package com.gooagoo.api.business.core.shop.user;

import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface ShopUserActivationCodeCoreService

{

    /**
     * 获取邮件激活码
     * @param account
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws AccountNotExistException
     * @throws OperateFailException
     */
    public String getActivationCode(String account) throws Exception;

    /**
     * 校验邮箱激活码
     * @param activeCode
     * @return
     * @throws NullException
     * @throws NoDataException
     */
    public boolean checkActivationCode(String activeCode) throws Exception;

}

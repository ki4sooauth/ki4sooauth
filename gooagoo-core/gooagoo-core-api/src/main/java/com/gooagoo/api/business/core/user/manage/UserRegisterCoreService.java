package com.gooagoo.api.business.core.user.manage;

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface UserRegisterCoreService

{
    /**
     * 个人用户注册
     * @param activeCode
     * @param userInfo
     * @param userProfile
     * @param userMobileInfo
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws AccountAlreadyExistsException
     * @throws OperateFailException
     */
    public boolean register(String activeCode, UserInfo userInfo, UserProfile userProfile, UserMobileInfo userMobileInfo) throws Exception;

    /**
     * 个人用户账户激活
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean active(String activeCode) throws Exception;

}

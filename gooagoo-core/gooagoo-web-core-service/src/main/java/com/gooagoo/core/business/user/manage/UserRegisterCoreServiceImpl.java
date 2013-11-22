package com.gooagoo.core.business.user.manage;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.manage.UserRegisterCoreService;
import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserProfileGeneratorCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.SerialUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.business.user.EmailFormatErrorException;
import com.gooagoo.exception.business.user.PasswordFormatErrorException;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class UserRegisterCoreServiceImpl implements UserRegisterCoreService
{

    @Autowired
    private UserEmailactiveCodeGeneratorCoreService userEmailactiveCodeGeneratorCoreService;

    @Autowired
    private UserMobileCodeGeneratorCoreService userMobileCodeGeneratorCoreService;

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;

    @Autowired
    private UserProfileGeneratorCoreService userProfileGeneratorCoreService;

    @Autowired
    private UserMobileInfoGeneratorCoreService userMobileInfoGeneratorCoreService;

    private final static Object synObject = new Object();//用户注册同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean register(String activeCode, UserInfo userInfo, UserProfile userProfile, UserMobileInfo userMobileInfo) throws Exception
    {
        Date currentTime = new Date();
        //1、注册信息校验
        boolean isTelephone = DataPatternUtils.checkMobilePhone(userInfo.getMobile());
        boolean isEmail = DataPatternUtils.chechEmail(userInfo.getEmail());
        this.checkRegisterInfoData(activeCode, userInfo, userProfile, userMobileInfo, isTelephone, isEmail);
        //2、组装个人用户表数据
        this.setUserInfo(userInfo);
        //3、组装用户辅助信息表数据
        if (userProfile == null)
        {
            userProfile = new UserProfile();
        }
        this.setUserProfile(userInfo.getUserId(), userProfile);
        //4、组装用户移动终端信息表数据
        if (userMobileInfo == null)
        {
            userMobileInfo = new UserMobileInfo();
        }
        this.setUserMobileInfo(userInfo.getUserId(), userMobileInfo);
        //5、组装邮箱激活码表数据
        UserEmailactiveCode userEmailactiveCode = this.setUserEmailactiveCode(userInfo.getUserId(), activeCode, currentTime, isEmail);
        //6、判断账户是否已存在
        UserInfoExample queryCondition1 = new UserInfoExample();
        if (isTelephone)
        {
            queryCondition1.createCriteria().andMobileEqualTo(userInfo.getMobile().trim());
        }
        else if (isEmail)
        {
            queryCondition1.createCriteria().andEmailEqualTo(userInfo.getEmail().trim());
        }
        //7、校验手机验证码
        UserMobileCodeExample queryCondition2 = null;
        if (isTelephone)
        {
            queryCondition2 = new UserMobileCodeExample();
            queryCondition2.createCriteria().andMobileEqualTo(userInfo.getMobile()).andCaptchaCodeEqualTo(activeCode).andExpDateGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N").andIsDelEqualTo("N");
        }
        synchronized (synObject)
        {
            Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition1);
            if (count == null || count > 0)
            {
                GooagooLog.info("用户注册：邮箱（" + userInfo.getEmail() + "）或手机号码（" + userInfo.getMobile() + "）已被注册");
                throw new AccountAlreadyExistsException("邮箱（" + userInfo.getEmail() + "）或手机号码（" + userInfo.getMobile() + "）已被注册");
            }
            UserMobileCode userMobileCode = this.setUserEmailactiveCode2(activeCode, userInfo.getMobile(), userInfo, queryCondition2, currentTime, isTelephone);
            //8、保存注册信息
            userInfo.setUserNum(SerialUtils.createUserSerial());//默认卡号
            this.saveRegisterInfo(userInfo, userProfile, userMobileInfo, userEmailactiveCode, userMobileCode, isTelephone, isEmail);
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean active(String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、基本校验
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("个人用户账户激活：邮件激活码（" + activeCode + "）为空");
            throw new NullException("邮件激活码（" + activeCode + "）为空");
        }
        //2、激活码正确性校验
        UserEmailactiveCode userEmailactiveCode = this.userEmailactiveCodeGeneratorCoreService.selectByPrimaryKey(activeCode);
        if (userEmailactiveCode == null)
        {
            GooagooLog.info("个人用户账户激活：邮件激活码（" + activeCode + "）不存在");
            throw new NoDataException("邮件激活码（" + activeCode + "）不存在");
        }
        if ("Y".equals(userEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("个人用户账户激活：邮件激活码（" + activeCode + "）已删除");
            throw new NoDataException("邮件激活码（" + activeCode + "）已删除");
        }
        if ("Y".equals(userEmailactiveCode.getIsActive()))
        {
            GooagooLog.info("个人用户账户激活：邮件激活码（" + activeCode + "）已被使用");
            throw new NoDataException("邮件激活码（" + activeCode + "）已被使用");
        }
        if (currentTime.after(userEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("个人用户账户激活：邮件激活码（" + activeCode + "）已失效");
            throw new NoDataException("邮件激活码（" + activeCode + "）已失效");
        }
        //3、处理激活操作
        userEmailactiveCode.setIsActive("Y");
        userEmailactiveCode.setActiveDate(currentTime);
        if (!this.userEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(userEmailactiveCode))
        {
            GooagooLog.error("个人用户账户激活：更新邮件激活码（" + userEmailactiveCode.toString() + "）信息异常", null);
            throw new OperateFailException("更新邮件激活码（" + userEmailactiveCode.toString() + "）信息异常");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userEmailactiveCode.getUserId());
        userInfo.setIsActiveEmail("Y");
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("个人用户账户激活：更新用户（" + userInfo.toString() + "）信息异常", null);
            throw new OperateFailException("更新用户（" + userInfo.toString() + "）信息异常");
        }

        return true;
    }

    /**
     * 校验注册信息
     * @param activeCode
     * @param userInfo
     * @param userProfile
     * @param userMobileInfo
     * @param isTelephone
     * @param isEmail
     * @return
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkRegisterInfoData(String activeCode, UserInfo userInfo, UserProfile userProfile, UserMobileInfo userMobileInfo, boolean isTelephone, boolean isEmail) throws NullException, FormatErrorException
    {
        //1、校验注册账号
        if (StringUtils.isBlank(userInfo.getMobile()) && StringUtils.isBlank(userInfo.getEmail()))
        {
            GooagooLog.info("校验注册信息：邮箱（" + userInfo.getEmail() + "）和手机号码（" + userInfo.getMobile() + "）为空");
            throw new NullException("邮箱（" + userInfo.getEmail() + "）和手机号码（" + userInfo.getMobile() + "）为空");
        }
        if (!isTelephone && !isEmail)
        {
            GooagooLog.info("校验注册信息：邮箱（" + userInfo.getEmail() + "）和手机号码（" + userInfo.getMobile() + "）格式不正确");
            throw new EmailFormatErrorException("邮箱（" + userInfo.getEmail() + "）和手机号码（" + userInfo.getMobile() + "）格式不正确");
        }
        if (isEmail && userInfo.getEmail().length() > 50)
        {
            GooagooLog.info("校验注册信息：邮箱（" + userInfo.getEmail() + "）长度超过50个字符");
            throw new EmailFormatErrorException("邮箱（" + userInfo.getEmail() + "）长度超过50个字符");
        }
        //2、校验密码
        if (StringUtils.isBlank(userInfo.getPassword()))
        {
            GooagooLog.info("校验注册信息：密码（" + userInfo.getPassword() + "）为空");
            throw new NullException("密码（" + userInfo.getPassword() + "）为空");
        }
        if (userInfo.getPassword().length() < 6 || userInfo.getPassword().length() > 20)
        {
            GooagooLog.info("校验注册信息：密码（" + userInfo.getPassword() + "）长度只能在6-20个字符之间");
            throw new PasswordFormatErrorException("密码（" + userInfo.getPassword() + "）长度只能在6-20个字符之间");
        }
        //3、校验注册来源
        if (SysdictionaryCache.get("info_source", userInfo.getUserType()) == null)
        {
            GooagooLog.info("校验注册信息：信息来源（" + userInfo.getUserType() + "）有误");
            throw new NullException("信息来源（" + userInfo.getUserType() + "）有误");
        }
        //4、校验验证码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验注册信息：验证码（" + activeCode + "）为空");
            throw new NullException("验证码（" + activeCode + "）为空");
        }

        return true;

    }

    /**
     * 组装个人用户表数据
     * @param userInfo
     */
    private void setUserInfo(UserInfo userInfo)
    {
        userInfo.setUserId(UUID.getUUID());//用户ID
        userInfo.setPassword(new Md5Utils().encrypt(userInfo.getPassword()));//密码加密
        userInfo.setUserStatus("U"); //用户状态
        userInfo.setIsActiveEmail("N");//是否激活
        userInfo.setIsDel("N");
    }

    /**
     * 组装用户辅助信息表数据
     * @param userId
     * @param userProfile
     */
    private void setUserProfile(String userId, UserProfile userProfile)
    {
        userProfile.setUserId(userId);//用户ID
        userProfile.setIsAllowFriend("Y");//是否允许别人加自己为好友
        userProfile.setHeadPic("http://html." + UrlUtils.getBASE_HOST() + "/passport/images/deflogo.png");//用户头像图片URL
    }

    /**
     * 组装用户移动终端信息表数据
     * @param userId
     * @param userMobileInfo
     */
    private void setUserMobileInfo(String userId, UserMobileInfo userMobileInfo)
    {
        userMobileInfo.setUserId(userId);
    }

    /**
     * 组装邮箱激活码表数据
     * @param userId
     * @param activeCode
     * @param currentTime
     * @param isEmail
     * @return
     */
    private UserEmailactiveCode setUserEmailactiveCode(String userId, String activeCode, Date currentTime, boolean isEmail)
    {
        UserEmailactiveCode userEmailactiveCode = null;
        if (isEmail)
        {
            userEmailactiveCode = new UserEmailactiveCode();
            userEmailactiveCode.setId(activeCode);
            userEmailactiveCode.setUserId(userId);
            userEmailactiveCode.setExpDate(TimeUtils.dateAdd(3, currentTime, 2));
            userEmailactiveCode.setIsActive("N");
            userEmailactiveCode.setIsDel("N");
        }

        return userEmailactiveCode;
    }

    /**
     * 组装手机验证码表数据
     * @param activeCode
     * @param telephone
     * @param userInfo
     * @param queryCondition2
     * @param currentTime
     * @param isTelephone
     * @return
     * @throws OperateFailException
     */
    private UserMobileCode setUserEmailactiveCode2(String activeCode, String telephone, UserInfo userInfo, UserMobileCodeExample queryCondition2, Date currentTime, boolean isTelephone) throws OperateFailException
    {
        UserMobileCode userMobileCode = null;
        if (isTelephone)
        {
            List<UserMobileCode> userEmailactiveCode2List = this.userMobileCodeGeneratorCoreService.selectByExample(queryCondition2);
            if (userEmailactiveCode2List == null || userEmailactiveCode2List.size() == 0)
            {
                GooagooLog.info("组装手机验证码表数据：手机（" + telephone + "）未有有效的验证码");
                throw new OperateFailException("手机（" + telephone + "）未有有效的验证码");
            }
            userMobileCode = userEmailactiveCode2List.get(0);
            userMobileCode.setIsUsed("Y");
            userMobileCode.setUseDate(currentTime);
            userInfo.setIsActiveEmail("Y");//是否激活
        }

        return userMobileCode;
    }

    /**
     * 保存注册信息
     * @param userInfo
     * @param userProfile
     * @param userMobileInfo
     * @param userEmailactiveCode
     * @param userMobileCode
     * @param isTelephone
     * @param isEmail
     * @return
     * @throws OperateFailException
     */
    private boolean saveRegisterInfo(UserInfo userInfo, UserProfile userProfile, UserMobileInfo userMobileInfo, UserEmailactiveCode userEmailactiveCode, UserMobileCode userMobileCode, boolean isTelephone, boolean isEmail) throws OperateFailException
    {
        if (!this.userInfoGeneratorCoreService.insertSelective(userInfo))
        {
            GooagooLog.error("保存注册信息：保存个人用户表数据（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("保存个人用户表数据（" + userInfo.toString() + "）异常");
        }
        if (!this.userProfileGeneratorCoreService.insertSelective(userProfile))
        {
            GooagooLog.error("保存注册信息：保存用户辅助信息表数据（" + userProfile.toString() + "）异常", null);
            throw new OperateFailException("保存用户辅助信息表数据（" + userProfile.toString() + "）异常");
        }
        if (!this.userMobileInfoGeneratorCoreService.insertSelective(userMobileInfo))
        {
            GooagooLog.error("保存注册信息：保存用户移动终端信息表数据（" + userMobileInfo.toString() + "）异常", null);
            throw new OperateFailException("保存用户移动终端信息表数据（" + userMobileInfo.toString() + "）异常");
        }
        if (isEmail)
        {
            if (!this.userEmailactiveCodeGeneratorCoreService.insertSelective(userEmailactiveCode))
            {
                GooagooLog.error("保存注册信息：保存邮箱激活码表数据（" + userEmailactiveCode.toString() + "）异常", null);
                throw new OperateFailException("保存邮箱激活码表数据（" + userEmailactiveCode.toString() + "）异常");
            }
        }
        else if (isTelephone)
        {
            if (!this.userMobileCodeGeneratorCoreService.updateByPrimaryKeySelective(userMobileCode))
            {
                GooagooLog.error("保存注册信息：修改手机验证码表数据（" + userMobileCode.toString() + "）异常", null);
                throw new OperateFailException("修改手机验证码表数据（" + userMobileCode.toString() + "）异常");
            }
        }

        return true;
    }

}

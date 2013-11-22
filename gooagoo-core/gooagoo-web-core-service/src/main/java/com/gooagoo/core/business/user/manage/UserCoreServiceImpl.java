package com.gooagoo.core.business.user.manage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.manage.UserCoreService;
import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserProfileGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.casclient.personal.PersonalInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.personal.PersonalProfile;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeExample;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.business.user.AddressFormatErrorException;
import com.gooagoo.exception.business.user.BirthdayFormatErrorException;
import com.gooagoo.exception.business.user.IdNoFormatErrorException;
import com.gooagoo.exception.business.user.NameFormatErrorException;
import com.gooagoo.exception.business.user.PhoneFormatErrorException;
import com.gooagoo.exception.business.user.PostCodeFormatErrorException;
import com.gooagoo.exception.business.user.SexFormatErrorException;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisObjectDao;

public class UserCoreServiceImpl implements UserCoreService

{

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;

    @Autowired
    private UserProfileGeneratorCoreService userProfileGeneratorCoreService;

    @Autowired
    private UserEmailactiveCodeGeneratorCoreService userEmailactiveCodeGeneratorCoreService;

    @Autowired
    private UserMobileCodeGeneratorCoreService userMobileCodeGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    private final static Object synObject = new Object();//修改用户名同步锁

    @Override
    public boolean updateUserInfo(UserInfo userInfo) throws GooagooException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateUserHead(String userLoginRedisKey, String userId, String url) throws Exception
    {
        //1、数据校验
        this.checkUpdateUserHeadData(userId, url);
        //2、处理修改头像
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(userId);
        userProfile.setHeadPic(url);
        if (!this.userProfileGeneratorCoreService.updateByPrimaryKeySelective(userProfile))
        {
            GooagooLog.error("修改头像：修改头像（" + userProfile.toString() + "）异常", null);
            throw new OperateFailException("修改头像（" + userProfile.toString() + "）异常");
        }
        //更新redis用户信息
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        redisHashDao.put(userId, "headPic", url);
        //更新redis个人登录信息
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
        PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
        if (personalLoginInfo != null)
        {
            PersonalProfile personalProfile = personalLoginInfo.getPersonalProfile();
            personalProfile.setHeadPic(url);
            personalLoginInfo.setPersonalProfile(personalProfile);
            redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
        }
        return true;
    }

    @Override
    public boolean updateUserProfile(String userLoginRedisKey, UserProfile userProfile) throws Exception
    {
        //1、数据校验
        this.checkUpdateUserProfileData(userProfile);
        //2、处理修改用户辅助信息
        if (!this.userProfileGeneratorCoreService.updateByPrimaryKeySelective(userProfile))
        {
            GooagooLog.error("修改用户辅助信息：修改用户辅助信息（" + userProfile.toString() + "）异常", null);
            throw new OperateFailException("修改用户辅助信息（" + userProfile.toString() + "）异常");
        }
        //更新redis用户信息
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        redisHashDao.put(userProfile.getUserId(), "userId", userProfile.getUserId());
        redisHashDao.put(userProfile.getUserId(), "realName", userProfile.getRealName());
        redisHashDao.put(userProfile.getUserId(), "sex", userProfile.getSex());
        redisHashDao.put(userProfile.getUserId(), "birthday", userProfile.getBirthday() != null ? TimeUtils.convertDateToString(userProfile.getBirthday(), TimeUtils.FORMAT1) : "");
        redisHashDao.put(userProfile.getUserId(), "idType", userProfile.getIdType());
        redisHashDao.put(userProfile.getUserId(), "idNo", userProfile.getIdNo());
        redisHashDao.put(userProfile.getUserId(), "telephone", userProfile.getTelephone());
        redisHashDao.put(userProfile.getUserId(), "postCode", userProfile.getPostCode());
        redisHashDao.put(userProfile.getUserId(), "province", userProfile.getProvince());
        redisHashDao.put(userProfile.getUserId(), "city", userProfile.getCity());
        redisHashDao.put(userProfile.getUserId(), "area", userProfile.getArea());
        redisHashDao.put(userProfile.getUserId(), "address", userProfile.getAddress());
        redisHashDao.put(userProfile.getUserId(), "regIp", userProfile.getRegIp());
        redisHashDao.put(userProfile.getUserId(), "isAllowFriend", userProfile.getIsAllowFriend());
        redisHashDao.put(userProfile.getUserId(), "headPic", userProfile.getHeadPic());
        redisHashDao.put(userProfile.getUserId(), "cTimeStamp", userProfile.getCTimeStamp() != null ? TimeUtils.convertDateToString(userProfile.getCTimeStamp(), TimeUtils.FORMAT1) : "");
        //更新redis个人登录信息
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
        PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
        if (personalLoginInfo != null)
        {
            PersonalProfile personalProfile = new PersonalProfile();
            BeanUtils.copyProperties(userProfile, personalProfile);
            personalLoginInfo.setPersonalProfile(personalProfile);
            redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
        }
        return true;
    }

    @Override
    public boolean updateUserAccount(String userLoginRedisKey, String userId, String account) throws Exception
    {
        //1、获取用户信息
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("修改用户名：用户（" + userId + "）状态异常");
            throw new NullException("用户（" + userId + "）状态异常");
        }
        //2、校验用户名是否已存在
        if (StringUtils.isNotBlank(userInfo.getAccount()))
        {
            GooagooLog.info("修改用户名：用户（" + userId + "）已存在用户名（" + userInfo.getAccount() + "）");
            throw new OperateFailException("用户（" + userId + "）已存在用户名（" + userInfo.getAccount() + "）");
        }
        //3、校验用户名唯一性
        UserInfoExample queryCondition = new UserInfoExample();
        queryCondition.createCriteria().andAccountEqualTo(account);
        synchronized (synObject)
        {
            Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition);
            if (count == null || count != 0)
            {
                GooagooLog.info("修改用户名：用户名（" + userInfo.getAccount() + "）已存在");
                throw new AccountAlreadyExistsException("用户名（" + userInfo.getAccount() + "）已存在");
            }
            userInfo.setAccount(account);
            //4、保存用户名
            if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
            {
                GooagooLog.error("修改用户名：保存用户名（" + userInfo.toString() + "）异常", null);
                throw new OperateFailException("保存用户名（" + userInfo.toString() + "）异常");
            }
            RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
            redisHashDao.put(userInfo.getUserId(), "account", userInfo.getAccount());
            RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
            PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
            if (personalLoginInfo != null)
            {
                PersonalInfo personalInfo = personalLoginInfo.getPersonalInfo();
                if (personalInfo != null)
                {
                    personalInfo.setAccount(userInfo.getAccount());
                    redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
                }
            }
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateEmail(String userLoginRedisKey, String userId, String email, String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、验证用户
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("修改用户邮箱地址 ：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //2、验证邮箱地址
        this.checkEmail(email);
        UserInfoExample queryCondition1 = new UserInfoExample();
        queryCondition1.createCriteria().andEmailEqualTo(email);
        Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition1);
        if (count == null || count != 0)
        {
            GooagooLog.info("修改用户邮箱地址 ：邮箱地址（" + email + "）已存在");
            throw new OperateFailException("邮箱地址（" + email + "）已存在");
        }
        //3、验证邮箱激活码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("修改用户邮箱地址 ：邮箱激活码（" + activeCode + "）为空");
            throw new NullException("邮箱激活码（" + activeCode + "）为空");
        }
        UserEmailactiveCodeExample queryCondition2 = new UserEmailactiveCodeExample();
        queryCondition2.createCriteria().andIdEqualTo(activeCode).andIsActiveEqualTo("N").andExpDateGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N");
        List<UserEmailactiveCode> userEmailactiveCodeList = this.userEmailactiveCodeGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isEmpty(userEmailactiveCodeList))
        {
            GooagooLog.info("修改用户邮箱地址：邮箱激活码（" + activeCode + "）不存在或已被删除");
            throw new NoDataException("邮箱激活码（" + activeCode + "）不存在或已被删除");
        }
        UserEmailactiveCode userEmailactiveCode = userEmailactiveCodeList.get(0);
        if (!userEmailactiveCode.getUserId().equals(userId))
        {
            GooagooLog.info("修改用户邮箱地址：邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
            throw new NoDataException("邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
        }
        //4、修改邮箱激活码状态
        userEmailactiveCode.setIsActive("Y");
        userEmailactiveCode.setActiveDate(currentTime);
        if (!this.userEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(userEmailactiveCode))
        {
            GooagooLog.error("修改用户邮箱地址：修改邮箱激活码状态（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("修改邮箱激活码状态（" + userEmailactiveCode.toString() + "）异常");
        }
        //5、修改用户邮箱地址
        userInfo.setEmail(email);
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("修改用户邮箱地址：修改用户邮箱地址（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("修改用户邮箱地址（" + userInfo.toString() + "）异常");
        }
        //更新redis用户信息
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        redisHashDao.put(userId, "email", email);
        //更新redis个人登录信息
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
        PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
        if (personalLoginInfo != null)
        {
            PersonalInfo personalInfo = personalLoginInfo.getPersonalInfo();
            personalInfo.setEmail(email);
            personalLoginInfo.setPersonalInfo(personalInfo);
            redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateMobile(String userLoginRedisKey, String userId, String mobile, String mobileActiveCode, String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、验证用户
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("修改用户手机号码 ：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //2、验证手机号码
        this.checkMobile(mobile);
        UserInfoExample queryCondition1 = new UserInfoExample();
        queryCondition1.createCriteria().andMobileEqualTo(mobile);
        Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition1);
        if (count == null || count != 0)
        {
            GooagooLog.info("修改用户手机号码 ：手机号码（" + mobile + "）已存在");
            throw new OperateFailException("手机号码（" + mobile + "）已存在");
        }
        //3、验证手机验证码
        if (StringUtils.isBlank(mobileActiveCode))
        {
            GooagooLog.info("修改用户手机号码 ：手机验证码（" + activeCode + "）为空");
            throw new NullException("手机验证码（" + activeCode + "）为空");
        }
        UserMobileCodeExample queryCondition2 = new UserMobileCodeExample();
        queryCondition2.createCriteria().andMobileEqualTo(mobile).andCaptchaCodeEqualTo(mobileActiveCode).andExpDateGreaterThanOrEqualTo(currentTime).andIsUsedEqualTo("N").andIsDelEqualTo("N");
        List<UserMobileCode> userMobileCodeList = this.userMobileCodeGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isEmpty(userMobileCodeList))
        {
            GooagooLog.info("修改用户手机号码 ：手机（" + mobile + "）验证码（" + activeCode + "）无效");
            throw new NoDataException("手机（" + mobile + "）验证码（" + activeCode + "）无效");
        }
        //4、验证邮箱激活码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("修改用户手机号码 ：邮箱激活码（" + activeCode + "）为空");
            throw new NullException("邮箱激活码（" + activeCode + "）为空");
        }
        UserEmailactiveCodeExample queryCondition3 = new UserEmailactiveCodeExample();
        queryCondition3.createCriteria().andIdEqualTo(activeCode).andIsActiveEqualTo("N").andExpDateGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N");
        List<UserEmailactiveCode> userEmailactiveCodeList = this.userEmailactiveCodeGeneratorCoreService.selectByExample(queryCondition3);
        if (CollectionUtils.isEmpty(userEmailactiveCodeList))
        {
            GooagooLog.info("修改用户手机号码：邮箱激活码（" + activeCode + "）不存在或已被删除");
            throw new NoDataException("邮箱激活码（" + activeCode + "）不存在或已被删除");
        }
        UserEmailactiveCode userEmailactiveCode = userEmailactiveCodeList.get(0);
        if (!userEmailactiveCode.getUserId().equals(userId))
        {
            GooagooLog.info("修改用户手机号码：邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
            throw new NoDataException("邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
        }
        //5、修改手机验证码状态
        UserMobileCode userMobileCode = userMobileCodeList.get(0);
        userMobileCode.setIsUsed("Y");
        userMobileCode.setUseDate(currentTime);
        if (!this.userMobileCodeGeneratorCoreService.updateByPrimaryKeySelective(userMobileCode))
        {
            GooagooLog.error("修改用户手机号码：修改手机验证码状态（" + userMobileCode.toString() + "）异常", null);
            throw new OperateFailException("修改手机验证码状态（" + userMobileCode.toString() + "）异常");
        }
        //6、修改邮箱激活码状态
        userEmailactiveCode.setIsActive("Y");
        userEmailactiveCode.setActiveDate(currentTime);
        if (!this.userEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(userEmailactiveCode))
        {
            GooagooLog.error("修改用户手机号码：修改邮箱激活码状态（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("修改邮箱激活码状态（" + userEmailactiveCode.toString() + "）异常");
        }
        //7、修改用户手机号码
        userInfo.setMobile(mobile);
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("修改用户手机号码：修改用户手机号码（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("修改用户手机号码（" + userInfo.toString() + "）异常");
        }
        //更新redis用户信息
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        redisHashDao.put(userId, "mobile", mobile);
        //更新redis个人登录信息
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
        PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
        if (personalLoginInfo != null)
        {
            PersonalInfo personalInfo = personalLoginInfo.getPersonalInfo();
            personalInfo.setMobile(mobile);
            personalLoginInfo.setPersonalInfo(personalInfo);
            redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
        }
        return true;
    }

    /**
     * 校验修改头像数据
     * @param userId
     * @param url
     * @return
     * @throws NullException
     */
    private boolean checkUpdateUserHeadData(String userId, String url) throws NullException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("校验修改头像数据：用户（" + userId + "）状态异常");
            throw new NullException("用户（" + userId + "）状态异常");
        }
        //2、校验用户头像URL
        if (StringUtils.isBlank(url))
        {
            GooagooLog.info("校验修改头像数据：头像URL（" + url + "）为空");
            throw new NullException("头像URL（" + url + "）为空");
        }

        return true;
    }

    /**
     * 校验修改用户辅助信息数据
     * @param userProfile
     * @return
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkUpdateUserProfileData(UserProfile userProfile) throws FormatErrorException, NullException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userProfile.getUserId()))
        {
            GooagooLog.info("校验修改用户辅助信息数据：用户（" + userProfile.getUserId() + "）状态异常");
            throw new NullException("用户（" + userProfile.getUserId() + "）状态异常");
        }
        //2、校验姓名
        if (StringUtils.isNotBlank(userProfile.getRealName()) && userProfile.getRealName().length() > 50)
        {
            GooagooLog.info("校验修改用户辅助信息数据：姓名（" + userProfile.getRealName() + "）格式不正确");
            throw new NameFormatErrorException("姓名（" + userProfile.getRealName() + "）格式不正确");
        }
        //3、校验性别
        if (StringUtils.isNotBlank(userProfile.getSex()) && SysdictionaryCache.get("sex", userProfile.getSex()) == null)
        {
            GooagooLog.info("校验修改用户辅助信息数据：性别（" + userProfile.getSex() + "）格式不正确");
            throw new SexFormatErrorException("性别（" + userProfile.getSex() + "）格式不正确");
        }
        //4、校验证件类型、证件号码、性别、出生日期
        if ((StringUtils.isNotBlank(userProfile.getIdType()) && StringUtils.isBlank(userProfile.getIdNo())) || (StringUtils.isBlank(userProfile.getIdType()) && StringUtils.isNotBlank(userProfile.getIdNo())))
        {
            GooagooLog.info("校验修改用户辅助信息数据：证件类型（" + userProfile.getIdType() + "）、证件号码（" + userProfile.getIdNo() + "）需全部填写");
            throw new NullException("证件类型（" + userProfile.getIdType() + "）、证件号码（" + userProfile.getIdNo() + "）需全部填写");
        }
        if (StringUtils.isNotBlank(userProfile.getIdType()) && StringUtils.isNotBlank(userProfile.getIdNo()))
        {
            if (SysdictionaryCache.get("idtype", userProfile.getIdType()) == null)
            {
                GooagooLog.info("校验修改用户辅助信息数据：证件类型（" + userProfile.getIdType() + "）格式不正确");
                throw new NullException("证件类型（" + userProfile.getIdType() + "）格式不正确");
            }
            if (userProfile.getIdNo().length() > 30)
            {
                GooagooLog.info("校验修改用户辅助信息数据：证件号码（" + userProfile.getIdNo() + "）格式不正确");
                throw new IdNoFormatErrorException("证件号码（" + userProfile.getIdNo() + "）格式不正确");
            }
            if ("00".equals(userProfile.getIdType()))
            {
                if (!DataPatternUtils.checkIdNumber(userProfile.getIdNo()))
                {
                    GooagooLog.info("校验修改用户辅助信息数据：身份证号码（" + userProfile.getIdNo() + "）格式不正确");
                    throw new IdNoFormatErrorException("身份证号码（" + userProfile.getIdNo() + "）格式不正确");
                }
                if (StringUtils.isNotBlank(userProfile.getSex()) && !DataPatternUtils.checkSexByIdNumber(userProfile.getSex(), userProfile.getIdNo()))
                {
                    GooagooLog.info("校验修改用户辅助信息数据：性别（" + userProfile.getSex() + "）与身份证号码（" + userProfile.getIdNo() + "）不对应");
                    throw new SexFormatErrorException("性别（" + userProfile.getSex() + "）与身份证号码（" + userProfile.getIdNo() + "）不对应");
                }
                if (userProfile.getBirthday() != null && !DataPatternUtils.checkBirthdayByIdNumber(TimeUtils.convertDateToString(userProfile.getBirthday(), "yyyy-MM-dd"), userProfile.getIdNo()))
                {
                    GooagooLog.info("校验修改用户辅助信息数据：出生日期（" + userProfile.getBirthday() + "）与身份证号码（" + userProfile.getIdNo() + "）不对应");
                    throw new BirthdayFormatErrorException("出生日期（" + userProfile.getBirthday() + "）与身份证号码（" + userProfile.getIdNo() + "）不对应");
                }
            }
        }
        //5、校验联系电话
        if (StringUtils.isNotBlank(userProfile.getTelephone()) && !DataPatternUtils.checkTelePhone(userProfile.getTelephone()) && !DataPatternUtils.checkMobilePhone(userProfile.getTelephone()))
        {
            GooagooLog.info("校验修改用户辅助信息数据：联系电话（" + userProfile.getTelephone() + "）格式不正确");
            throw new PhoneFormatErrorException("联系电话（" + userProfile.getTelephone() + "）格式不正确");
        }
        //6、校验邮政编码
        if (StringUtils.isNotBlank(userProfile.getPostCode()) && !DataPatternUtils.checkZipCode(userProfile.getPostCode()))
        {
            GooagooLog.info("校验修改用户辅助信息数据：邮政编码（" + userProfile.getPostCode() + "）格式不正确");
            throw new PostCodeFormatErrorException("邮政编码（" + userProfile.getPostCode() + "）格式不正确");
        }
        //7、校验详细地址
        if (StringUtils.isNotBlank(userProfile.getAddress()) && userProfile.getAddress().length() > 255)
        {
            GooagooLog.info("校验修改用户辅助信息数据：详细地址（" + userProfile.getAddress() + "）格式不正确");
            throw new AddressFormatErrorException("详细地址（" + userProfile.getAddress() + "）格式不正确");
        }

        return true;
    }

    /**
     * 验证邮箱地址
     * @param email
     * @return
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkEmail(String email) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(email))
        {
            GooagooLog.info("验证邮箱地址：邮箱地址（" + email + "）为空");
            throw new NullException("邮箱地址（" + email + "）为空");
        }
        if (!DataPatternUtils.chechEmail(email))
        {
            GooagooLog.info("验证邮箱地址：邮箱地址（" + email + "）格式不正确");
            throw new FormatErrorException("邮箱地址（" + email + "）格式不正确");
        }

        return true;
    }

    /**
     * 验证手机号码
     * @param mobile
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    private boolean checkMobile(String mobile) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(mobile))
        {
            GooagooLog.info("验证手机号码：手机号码（" + mobile + "）为空");
            throw new NullException("手机号码（" + mobile + "）为空");
        }
        if (!DataPatternUtils.checkMobilePhone(mobile))
        {
            GooagooLog.info("验证手机号码：手机号码（" + mobile + "）格式不正确");
            throw new FormatErrorException("手机号码（" + mobile + "）格式不正确");
        }

        return true;
    }

}

package com.gooagoo.core.business.user.manage;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.manage.UserLoginCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserProfileGeneratorCoreService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.user.UserMobileInfoMapper;
import com.gooagoo.entity.casclient.personal.PersonalInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.personal.PersonalMobileInfo;
import com.gooagoo.entity.casclient.personal.PersonalProfile;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoKey;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotActiveException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;

@Service
public class UserLoginCoreServiceImpl implements UserLoginCoreService
{

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;
    @Autowired
    private UserProfileGeneratorCoreService userProfileGeneratorCoreService;
    @Autowired
    private UserMobileInfoGeneratorCoreService userMobileInfoGeneratorCoreService;
    @Autowired
    private UserMobileInfoMapper userMobileInfoMapper;

    @Override
    public PersonalLoginInfo login(String account, String password, UserMobileInfo userMobileInfo, Integer expireSecond) throws Exception
    {
        //1、基本验证
        if (StringUtils.isBlank(account))
        {
            GooagooLog.info("个人用户登录：用户账号（" + account + "）为空");
            throw new NullException("用户账号（" + account + "）为空");
        }
        if (StringUtils.isBlank(password))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）输入的密码（" + password + "）为空");
            throw new NullException("用户（" + account + "）输入的密码（" + password + "）为空");
        }
        //2、获取用户信息
        UserInfoExample queryCondition = new UserInfoExample();
        if (DataPatternUtils.checkMobilePhone(account))
        {
            queryCondition.createCriteria().andMobileEqualTo(account).andIsDelEqualTo("N");
        }
        else if (DataPatternUtils.chechEmail(account))
        {
            queryCondition.createCriteria().andEmailEqualTo(account).andIsDelEqualTo("N");
        }
        else
        {
            queryCondition.createCriteria().andAccountEqualTo(account).andIsDelEqualTo("N");
        }
        List<UserInfo> userInfoList = this.userInfoGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(userInfoList))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）不存在");
            throw new AccountNotExistException("用户（" + account + "）不存在");
        }
        UserInfo userInfo = userInfoList.get(0);
        //3、验证密码
        if (!userInfo.getPassword().equals(new Md5Utils().encrypt(password)))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）输入的密码（" + password + "）不正确");
            throw new PasswordIncorrectException("用户（" + account + "）输入的密码（" + password + "）不正确");
        }
        //4、验证激活状态
        if (!"Y".equals(userInfo.getIsActiveEmail()))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）未激活");
            throw new AccountNotActiveException("用户（" + account + "）未激活");
        }
        //5、验证账户状态
        if (!"U".equals(userInfo.getUserStatus()))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）已被锁定");
            throw new AccountIsLockedException("用户（" + account + "）已被锁定");
        }
        //6、获取用户辅助信息
        UserProfile userProfile = this.userProfileGeneratorCoreService.selectByPrimaryKey(userInfo.getUserId());
        //7、回写用户移动终端信息
        PersonalLoginInfo personalLoginInfo = new PersonalLoginInfo();
        if (userMobileInfo != null)
        {
            String userId = userInfo.getUserId();
            String sessionId = UUID.getUUID();
            userMobileInfo.setUserId(userId);
            userMobileInfo.setSessionid(sessionId);
            UserMobileInfo oldUserMobileInfo = this.userMobileInfoGeneratorCoreService.selectByPrimaryKey(userId);
            if (oldUserMobileInfo == null)
            {
                if (!this.userMobileInfoGeneratorCoreService.insertSelective(userMobileInfo))
                {
                    GooagooLog.error("个人用户登录：回写用户移动终端信息（" + userMobileInfo.toString() + "）异常", null);
                    throw new OperateFailException("回写用户移动终端信息（" + userMobileInfo.toString() + "）异常");
                }
            }
            else
            {
                if (!this.userMobileInfoGeneratorCoreService.updateByPrimaryKeySelective(userMobileInfo))
                {
                    GooagooLog.error("个人用户登录：回写用户移动终端信息（" + userMobileInfo.toString() + "）异常", null);
                    throw new OperateFailException("回写用户移动终端信息（" + userMobileInfo.toString() + "）异常");
                }
            }
            RedisObjectDao objectDao = new RedisObjectDao(RedisServerConstants.login_mobile);
            //手机登录将更新redis中userId和sessionId
            objectDao.set(userId, sessionId);
            //8、组装用户登录信息
            PersonalMobileInfo personalMobileInfo = new PersonalMobileInfo();
            personalMobileInfo.setUserId(userId);
            personalMobileInfo.setSessionid(sessionId);
            PersonalInfo personalInfo = new PersonalInfo();
            BeanUtils.copyProperties(userInfo, personalInfo);
            personalLoginInfo.setPersonalInfo(personalInfo);
            personalLoginInfo.setPersonalMobileInfo(personalMobileInfo);
        }
        else
        {
            //8、组装用户登录信息
            PersonalInfo personalInfo = new PersonalInfo();
            BeanUtils.copyProperties(userInfo, personalInfo);
            personalLoginInfo.setPersonalInfo(personalInfo);
            PersonalProfile personalProfile = new PersonalProfile();
            BeanUtils.copyProperties(userProfile, personalProfile);
            personalLoginInfo.setPersonalProfile(personalProfile);
            UserMobileInfoKey userMobileInfoKey = new UserMobileInfoKey();
            userMobileInfoKey.setUserId(userInfo.getUserId());
            UserMobileInfo mobileInfo = this.userMobileInfoMapper.selectByPrimaryKey(userMobileInfoKey);
            if (mobileInfo != null)
            {
                PersonalMobileInfo personalMobileInfo = new PersonalMobileInfo();
                BeanUtils.copyProperties(mobileInfo, personalMobileInfo);
                personalLoginInfo.setPersonalMobileInfo(personalMobileInfo);
            }
            //9、登录信息放入缓存
            String token = UUID.getUUID();
            personalLoginInfo.setToken(token);
            RedisObjectDao objectDao = new RedisObjectDao(RedisServerConstants.login_gus);
            objectDao.set(token, personalLoginInfo);
            if (expireSecond != null)
            {
                RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.login_gus);
                redisDatabase.setExpire(token, expireSecond);
            }
        }
        return personalLoginInfo;
    }

    @Override
    public boolean updateClientInfo(String token, String clientInfoJson) throws Exception
    {
        RedisObjectDao objectDao = new RedisObjectDao(RedisServerConstants.login_gus);
        PersonalLoginInfo personalLoginInfo = objectDao.getGenerics(token, PersonalLoginInfo.class);
        if (personalLoginInfo == null)
        {
            return false;
        }
        personalLoginInfo.setClientInfoJson(clientInfoJson);
        objectDao.set(token, personalLoginInfo);
        return true;
    }

}

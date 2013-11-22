package com.gooagoo.query.business.user.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.log.LogQueryService;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.user.ProductSerialNumberGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;

public class UserAccountQueryServiceImpl implements UserAccountQueryService
{
    @Autowired
    UserInfoGeneratorQueryService userInfoGeneratorQueryService;
    @Autowired
    UserMobileInfoGeneratorQueryService userMobileInfoGeneratorQueryService;
    @Autowired
    ProductSerialNumberGeneratorQueryService productSerialNumberGeneratorQueryService;
    @Autowired
    MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;
    @Autowired
    LogQueryService logQueryService;

    @Override
    public String queryUserIdFromUserAccount(String accountType, String account) throws Exception
    {
        String userId = "";
        if (!StringUtils.hasText(accountType) || !StringUtils.hasText(account))
        {
            throw new NullException("accountType=" + accountType + "，account=" + account);
        }
        if ("0".equals(accountType))//userid
        {
            userId = account;
        }
        else if ("1".equals(accountType))//gooagooid
        {
            userId = this.queryUserIdFromGooagooId(account);
        }
        else if ("2".equals(accountType))//ip
        {
            userId = this.queryUserIdFromIp(account);
        }
        else if ("3".equals(accountType))//mac
        {
            userId = this.queryUserIdFromMac(account);
        }
        else if ("4".equals(accountType))//hostname
        {
            userId = this.queryUserIdFromHostName(account);
        }
        else if ("5".equals(accountType))//phone
        {
            userId = this.queryUserIdFromPhone(account);
        }
        else if ("6".equals(accountType))//scardno
        {
            userId = this.queryUserIdFromScardNo(account);
        }
        else if ("7".equals(accountType))//phyno
        {
            userId = this.queryUserIdFromPhyNo(account);
        }
        else if ("8".equals(accountType))//ecaccount
        {
            userId = this.queryUserIdFromEcAccount(account);
        }
        return userId;
    }

    @Override
    public String queryEmailFromUserId(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String queryMobileFromUserId(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PersonalLoginInfo queryPersonalLoginInfo(String token, String resource, Integer expireSecond) throws Exception
    {
        if (!StringUtils.hasText(token))
        {
            return null;
        }
        RedisObjectDao objectDao = new RedisObjectDao("login_gus");
        Object o = objectDao.get(token);
        if (o == null)
        {
            return null;
        }
        RedisDatabase redisDatabase = null;
        if ("W".equals(resource))
        {
            redisDatabase = new RedisDatabase("login_gus");
        }
        else if ("M".equals(resource))
        {
            redisDatabase = new RedisDatabase("login_mobile");
        }
        if (expireSecond != null)
        {
            redisDatabase.setExpire(token, expireSecond);
        }

        return (PersonalLoginInfo) o;
    }

    @Override
    public boolean checkUserIdentity(String userId, String password) throws Exception
    {
        UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(userId);
        if (userInfo == null)
        {
            GooagooLog.info("用户登录：用户（" + userId + "）不存在");
            throw new AccountNotExistException("用户（" + userId + "）不存在");
        }
        if (!userInfo.getPassword().equals(new Md5Utils().encrypt(password)))
        {
            GooagooLog.info("用户登录：用户（" + userId + "）输入的密码（" + password + "）不正确");
            throw new PasswordIncorrectException("用户（" + userId + "）输入的密码（" + password + "）不正确");
        }
        return true;
    }

    /**
     * 根据用户id查询mac地址
     * @param userId 用户id
     * @return mac
     */
    @Override
    public String queryMacFromUserId(String userId) throws Exception
    {
        //第一步：在用户移动终端信息表中查询用户对应的mac地址
        String macAddress = "";
        String mac = "";
        UserMobileInfo userMobileInfo = this.userMobileInfoGeneratorQueryService.selectByPrimaryKey(userId);
        if (userMobileInfo != null)
        {
            macAddress = userMobileInfo.getMacAddress();
        }
        //第二步：在用户移动终端信息表中查询mac地址最新对应的用户编号（记为userid）
        if (StringUtils.hasText(macAddress))
        {
            UserMobileInfoExample userMobileInfoExample = new UserMobileInfoExample();
            userMobileInfoExample.setOrderByClause("c_time_stamp desc");
            userMobileInfoExample.setPage(1, 1);
            userMobileInfoExample.createCriteria().andMacAddressEqualTo(macAddress);
            List<UserMobileInfo> list = this.userMobileInfoGeneratorQueryService.selectByExample(userMobileInfoExample);
            //比较传入的account和查询出来的userid是否相同，如果相同，则返回mac地址，否则返回null。
            if (userId.equals(list.get(0).getUserId()))
            {
                mac = macAddress;
            }
        }
        return mac;
    }

    /**
     * 根据GooagooId查询用户id
     * @param account GooagooId
     * @return userid
     */
    private String queryUserIdFromGooagooId(String account)
    {
        String userId = "";
        ProductSerialNumber productSerialNumber = this.productSerialNumberGeneratorQueryService.selectByPrimaryKey(account);
        if (productSerialNumber != null)
        {
            userId = productSerialNumber.getMacAddress();
        }
        return userId;
    }

    /**
     * 根据手机号查询用户id
     * @param account 手机号
     * @return userId
     */
    private String queryUserIdFromPhone(String account)
    {
        String userId = "";
        //先从userinfo中查询，再从memberbaseinfo中查询
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andMobileEqualTo(account);
        userInfoExample.setOrderByClause("c_time_stamp desc");
        userInfoExample.setPage(1, 1);
        List<UserInfo> list = this.userInfoGeneratorQueryService.selectByExample(userInfoExample);
        if (!CollectionUtils.isEmpty(list))
        {
            userId = list.get(0).getUserId();
        }
        else
        {
            MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
            memberBaseInfoExample.createCriteria().andMobileEqualTo(account);
            memberBaseInfoExample.setOrderByClause("c_time_stamp desc");
            memberBaseInfoExample.setPage(1, 1);
            List<MemberBaseInfo> list2 = this.memberBaseInfoGeneratorQueryService.selectByExample(memberBaseInfoExample);
            if (!CollectionUtils.isEmpty(list2))
            {
                userId = this.queryUserIdFromPhyNo(list2.get(0).getPhyNo());
            }
        }
        return userId;
    }

    /**
     * 根据电子卡号查询用户id
     * @param account 电子卡号
     * @return userId
     */
    private String queryUserIdFromScardNo(String account)
    {
        String userId = "";
        MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectByPrimaryKey(account);
        if (memberOfCard != null)
        {
            userId = memberOfCard.getUserId();
        }
        return userId;
    }

    /**
     * 根据物理卡号查询用户id
     * @param account 物理卡号
     * @return userId
     */
    private String queryUserIdFromPhyNo(String account)
    {
        String userId = "";
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.setOrderByClause("c_time_stamp desc");
        memberOfCardExample.setPage(1, 1);
        memberOfCardExample.createCriteria().andPhyCardNoEqualTo(account);
        List<MemberOfCard> list = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
        if (!CollectionUtils.isEmpty(list))
        {
            userId = list.get(0).getUserId();
        }
        return userId;
    }

    /**
     * 根据mac地址查询用户id
     * @param account mac地址
     * @return userId
     */
    private String queryUserIdFromMac(String account)
    {
        String userId = "";
        UserMobileInfoExample userMobileInfoExample = new UserMobileInfoExample();
        userMobileInfoExample.setOrderByClause("c_time_stamp desc");
        userMobileInfoExample.setPage(1, 1);
        userMobileInfoExample.createCriteria().andMacAddressEqualTo(account);
        List<UserMobileInfo> list = this.userMobileInfoGeneratorQueryService.selectByExample(userMobileInfoExample);
        if (!CollectionUtils.isEmpty(list))
        {
            userId = list.get(0).getUserId();
        }
        return userId;
    }

    private String queryUserIdFromEcAccount(String account)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private String queryUserIdFromIp(String account)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private String queryUserIdFromHostName(String account)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
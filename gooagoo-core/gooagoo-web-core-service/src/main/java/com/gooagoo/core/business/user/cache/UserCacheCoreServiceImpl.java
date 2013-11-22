package com.gooagoo.core.business.user.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.cache.UserCacheCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserProfileGeneratorCoreService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisStringDao;

/**
 * 从缓存中查询用户相关信息
 */
@Service
public class UserCacheCoreServiceImpl implements UserCacheCoreService
{
    @Autowired
    UserMobileInfoGeneratorCoreService userMobileInfoGeneratorCoreService;

    @Autowired
    UserInfoGeneratorCoreService userInfoGeneratorCoreService;

    @Autowired
    UserProfileGeneratorCoreService userProfileGeneratorCoreService;

    @Override
    public String findUserIdByMac(String mac) throws Exception
    {
        RedisStringDao dao = new RedisStringDao(RedisServerConstants.business_mac);
        String userId = dao.get(mac);
        if (StringUtils.isBlank(userId))
        {
            UserMobileInfoExample example = new UserMobileInfoExample();
            example.createCriteria().andMacAddressEqualTo(mac);
            example.setOrderByClause("c_time_stamp");
            example.setPage(0, 1);
            List<UserMobileInfo> mobileInfos = this.userMobileInfoGeneratorCoreService.selectByExample(example);
            if (mobileInfos != null && mobileInfos.size() > 0)
            {
                userId = mobileInfos.get(0).getUserId();
                if (userId != null)
                {
                    dao.set(mac, userId);
                }
            }
            return null;
        }
        return userId;
    }

    @Override
    public Map<String, String> findUserInfo(String userId)
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_user);
        Map<String, String> result = dao.get(userId);
        if (result == null || result.size() == 0)
        {
            result = this.assembling(userId);
            dao.set(userId, result);
        }
        return result;
    }

    private Map<String, String> assembling(String userId)
    {
        UserInfo userInfo = this.userInfoGeneratorCoreService.selectByPrimaryKey(userId);
        UserProfile userProfile = this.userProfileGeneratorCoreService.selectByPrimaryKey(userId);
        Map<String, String> user = new HashMap<String, String>();
        user.put("account", userInfo.getAccount());//用户名
        user.put("mobile", userInfo.getMobile());//手机
        user.put("email", userInfo.getEmail());//邮箱
        user.put("userNum", userInfo.getUserNum());
        user.put("realName", userProfile.getRealName());//姓名
        user.put("sex", userProfile.getSex());//性别
        if (userProfile.getBirthday() != null)
        {
            user.put("birthday", TimeUtils.convertDateToString(userProfile.getBirthday(), TimeUtils.FORMAT1));//出生日期
        }
        user.put("idType", userProfile.getIdType()); //证件类型
        user.put("idNo", userProfile.getIdNo()); //证件号码
        user.put("telephone", userProfile.getTelephone());//电话
        user.put("postCode", userProfile.getPostCode());//邮编
        user.put("province", userProfile.getProvince());//省
        user.put("city", userProfile.getCity());//市 
        user.put("area", userProfile.getArea());//区县
        user.put("address", userProfile.getAddress());//地址
        user.put("headPic", userProfile.getHeadPic());//头像

        return user;
    }
}

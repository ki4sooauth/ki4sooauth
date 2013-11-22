package com.gooagoo.query.business.user.cache;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.user.MobilePushInfoBusiness;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.entity.business.user.account.property.AccountBaseInfo;
import com.gooagoo.entity.business.user.account.property.AccountTypeInfo;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.query.business.user.cache.subTask.UserQueryCentreTask;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisObjectDao;
import com.gooagoo.redis.data.RedisStringDao;
import com.mongodb.DBObject;

/**
 * 从缓存中查询用户相关信息
 */
@Service
public class UserCacheQueryServiceImpl implements UserCacheQueryService
{

    @Autowired
    UserMobileInfoGeneratorQueryService userMobileInfoGeneratorQueryService;

    @Autowired
    UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @Autowired
    UserProfileGeneratorQueryService userProfileGeneratorQueryService;

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
            List<UserMobileInfo> mobileInfos = this.userMobileInfoGeneratorQueryService.selectByExample(example);
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

    @Override
    public List<Account> getUserAccountsList(String shopId, HistoryCondition historyCondition) throws Exception
    {
        Set<Account> accounts = null;
        //accounts = InnerTools.getCache(shopId, historyCondition); //读缓存
        if (accounts == null) //缓存中不存在 查数据库
        {
            UserQueryCentreTask queryTask = new UserQueryCentreTask();
            accounts = queryTask.query(shopId, historyCondition);
            //InnerTools.putCache(accounts, shopId, historyCondition);
        }
        return new ArrayList<Account>(accounts);
    }

    @Override
    public PropertyRecord getUserPropertyRecord(String shopId, String accountType, String account) throws Exception
    {
        PropertyRecord record = new PropertyRecord();
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
        DBObject dbObject = mongoDao.findById(shopId + "_" + accountType + "_" + account);
        record.setAccountTypeInfo(this.assembleAccountType(dbObject));
        record.setAccountBaseInfo(this.assembleAccountBase(dbObject));
        record.setMemberFeatureInfoList(this.assembleFeature(dbObject));
        return record;
    }

    @Override
    public List<ActionRecord> getUserActionRecords(String shopId, String accountType, String account, Integer pageIndex, Integer pageSize) throws Exception
    {
        MongoDao mdao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);
        ActionRecord query = new ActionRecord();
        query.setShopId(shopId);
        if ("0".equals(accountType)) //userId
        {
            query.setUserId(account);
        }
        else if ("2".equals(accountType)) //ip
        {
            query.setIp(account);
        }
        else if ("3".equals(accountType)) //mac
        {
            query.setMac(account);
        }

        List<ActionRecord> result = mdao.findByConditionPage(query, ActionRecord.class, pageIndex, pageSize);
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        UserCacheQueryServiceImpl server = new UserCacheQueryServiceImpl();
        List<ActionRecord> result = server.getUserActionRecords("01822R97QK2FRDT085QBV2EIISWR0JGT", "0", "01822RBQ22JSDMA085QBV8EIISWR0JGT", 4, 10);
        System.out.println(result.size());
    }

    @Override
    public Integer countUserActionRecords(String shopId, String accountType, String account) throws Exception
    {
        MongoDao mdao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);
        ActionRecord query = new ActionRecord();
        query.setShopId(shopId);
        if ("0".equals(accountType)) //userId
        {
            query.setUserId(account);
        }
        else if ("2".equals(accountType)) //ip
        {
            query.setIp(account);
        }
        else if ("3".equals(accountType)) //mac
        {
            query.setMac(account);
        }

        long l = mdao.count(query);
        return (int) l;
    }

    private Map<String, String> assembling(String userId)
    {
        UserInfo userInfo = this.userInfoGeneratorQueryService.selectUnDelByPrimaryKey(userId);
        UserProfile userProfile = this.userProfileGeneratorQueryService.selectByPrimaryKey(userId);
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

    private AccountTypeInfo assembleAccountType(DBObject dbObject)
    {
        AccountTypeInfo info = new AccountTypeInfo();
        info.setUserId((String) dbObject.get("userId"));//gooagoo账号
        info.setGooagooId((String) dbObject.get("gooagooId")); //用户安装APP时分配的编号
        info.setIp((String) dbObject.get("ip")); //用户客户端的IP地址
        info.setMac((String) dbObject.get("mac"));//用户客户端的Mac地址
        info.setHostName((String) dbObject.get("hostName"));//用户客户端的主机名称
        info.setMobile((String) dbObject.get("mobile"));//手机号吗
        info.setCardNo((String) dbObject.get("scardNo"));//电子卡号
        info.setPhyCardNo((String) dbObject.get("phyCardNo"));//物理卡号
        dbObject.get("cardId");
        return info;
    }

    private AccountBaseInfo assembleAccountBase(DBObject dbObject) throws Exception
    {
        Date birthday = null;
        Integer age = null;
        String strBirthday = (String) dbObject.get("birthday");
        if (StringUtils.isNotBlank(strBirthday))
        {
            birthday = TimeUtils.convertStringToDate((String) dbObject.get("birthday"));
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            calendar.setTime(birthday);
            age = year - calendar.get(Calendar.YEAR);
        }

        AccountBaseInfo baseInfo = new AccountBaseInfo();
        baseInfo.setName((String) dbObject.get("name"));//姓名
        baseInfo.setSex((String) dbObject.get("sex"));//性别
        baseInfo.setBirthday(birthday);//生日
        baseInfo.setIdType((String) dbObject.get("idType")); //证件类型
        baseInfo.setIdNo((String) dbObject.get("idNo")); //证件号码
        baseInfo.setAge(age);//年龄 
        baseInfo.setEmail((String) dbObject.get("email"));//邮箱
        baseInfo.setTelephone((String) dbObject.get("telephone")); //联系电话
        baseInfo.setPostCode((String) dbObject.get("postCode")); //邮编
        baseInfo.setAddress((String) dbObject.get("address")); //联系地址
        baseInfo.setMemberLevel((String) dbObject.get("memberLevel")); //会员等级
        return baseInfo;
    }

    private List<MemberFeatureInfo> assembleFeature(DBObject dbObject)
    {
        List<MemberFeatureInfo> infos = new ArrayList<MemberFeatureInfo>();
        DBObject feautre = (DBObject) dbObject.get("feature");
        if (feautre != null)
        {
            for (String key : feautre.keySet())
            {
                MemberFeatureInfo featureInfo = new MemberFeatureInfo();
                featureInfo.setFeatureCode(key);//特征编码，如color
                featureInfo.setFeatureValue((String) feautre.get(key));//特征数值，如蓝色
                infos.add(featureInfo);
            }
        }
        return infos;
    }

    @Override
    public MobilePushInfoBusiness findUserMobileInfoByMacAddress(String mac) throws Exception
    {
        RedisObjectDao redisReadDao = new RedisObjectDao(RedisServerConstants.login_mobileSocket);
        MobilePushInfoBusiness mobilePushInfoBusiness = redisReadDao.getGenerics(mac, MobilePushInfoBusiness.class);
        return mobilePushInfoBusiness;
    }

}

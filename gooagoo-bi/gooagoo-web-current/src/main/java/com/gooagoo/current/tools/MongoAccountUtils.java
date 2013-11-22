package com.gooagoo.current.tools;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.mongodb.BasicDBObject;

public class MongoAccountUtils
{
    private MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
    private MemberOfCardGeneratorQueryService memberofcardService = SpringBeanUtils.getBean(MemberOfCardGeneratorQueryService.class);
    private MemberFeatureInfoGeneratorQueryService featureService = SpringBeanUtils.getBean(MemberFeatureInfoGeneratorQueryService.class);
    private MemberBaseInfoGeneratorQueryService memberBaseService = SpringBeanUtils.getBean(MemberBaseInfoGeneratorQueryService.class);
    private UserCacheQueryService userCacheService = SpringBeanUtils.getBean(UserCacheQueryService.class);

    public AnalysisAccount buildByMemberBaseInfo(MemberBaseInfo memberBaseInfo)
    {

        AnalysisAccount account = new AnalysisAccount();

        String shopId = memberBaseInfo.getShopId();
        String phyNo = memberBaseInfo.getPhyNo();
        fillByMemberBaseInfo(memberBaseInfo, account);

        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andShopIdEqualTo(shopId).andPhyCardNoEqualTo(phyNo);
        List<MemberOfCard> cards = memberofcardService.selectByExample(memberOfCardExample);
        if (cards != null && cards.size() != 0)
        {
            MemberOfCard card = cards.get(0);
            String userId = card.getUserId();
            account.setCardId(card.getCardId());
            account.setPhyCardNo(card.getPhyCardNo());
            account.setScardNo(card.getScardno());
            account.setUserId(userId);

            MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
            memberFeatureInfoExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
            List<MemberFeatureInfo> featureInfos = featureService.selectByExample(memberFeatureInfoExample);
            for (MemberFeatureInfo feature : featureInfos)
            {
                account.getFeature().put(feature.getFeatureCode(), feature.getFeatureValue());
            }
        }
        account.setMac(null);
        account.setIp(null);
        return account;
    }

    private AnalysisAccount fillByMemberBaseInfo(MemberBaseInfo memberBaseInfo, AnalysisAccount account)
    {
        if (account == null)
        {
            account = new AnalysisAccount();
        }

        account.setMobile(memberBaseInfo.getMobile());
        account.setSex(memberBaseInfo.getSex());
        account.setTelephone(memberBaseInfo.getTelephone());//联系电话
        account.setMobile(memberBaseInfo.getMobile()); //手机
        account.setPhyCardNo(memberBaseInfo.getPhyNo());
        account.setSex(memberBaseInfo.getSex());
        account.setShopId(memberBaseInfo.getShopId());
        account.setName(memberBaseInfo.getName());//姓名
        account.setBirthday(memberBaseInfo.getBirthday());//生日
        account.setIdType(memberBaseInfo.getIdType());//证件类型
        account.setIdNo(memberBaseInfo.getIdNo());//证件号码
        account.setEmail(memberBaseInfo.getEmail());//邮箱
        account.setTelephone(memberBaseInfo.getTelephone());
        account.setPostCode(memberBaseInfo.getPostcode());//邮编
        account.setAddress(memberBaseInfo.getAddress());//联系地址
        account.setMemberLevel(memberBaseInfo.getPhyName());//会员等级
        return account;
    }

    public AnalysisAccount buildByCard(MemberOfCard memberOfCard)
    {
        AnalysisAccount account = new AnalysisAccount();
        fillByCard(memberOfCard, account);
        String shopId = memberOfCard.getShopId();
        String userId = memberOfCard.getUserId();

        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andPhyNoEqualTo(memberOfCard.getPhyCardNo()).andShopIdEqualTo(shopId);
        List<MemberBaseInfo> members = memberBaseService.selectByExample(memberBaseInfoExample);
        if (members != null && members.size() != 0)
        {
            MemberBaseInfo memberBaseInfo = members.get(0);
            fillByMemberBaseInfo(memberBaseInfo, account);
        }
        MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
        memberFeatureInfoExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberFeatureInfo> featureInfos = featureService.selectByExample(memberFeatureInfoExample);
        for (MemberFeatureInfo feature : featureInfos)
        {
            account.getFeature().put(feature.getFeatureCode(), feature.getFeatureValue());
        }
        return account;
    }

    public AnalysisAccount fillByCard(MemberOfCard memberOfCard, AnalysisAccount account)
    {
        if (account == null)
        {
            account = new AnalysisAccount();
        }
        account.setShopId(memberOfCard.getShopId());
        account.setCardId(memberOfCard.getCardId());
        account.setPhyCardNo(memberOfCard.getPhyCardNo());
        account.setScardNo(memberOfCard.getScardno());
        account.setUserId(memberOfCard.getUserId());
        return account;
    }

    public AnalysisAccount buildById(String shopId, String userId)
    {
        AnalysisAccount account = new AnalysisAccount();

        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<MemberOfCard> cards = memberofcardService.selectByExample(memberOfCardExample);
        if (cards != null && cards.size() != 0)
        {
            MemberOfCard card = cards.get(0);
            fillByCard(card, account);

            MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
            memberBaseInfoExample.createCriteria().andPhyNoEqualTo(card.getPhyCardNo()).andShopIdEqualTo(shopId);
            List<MemberBaseInfo> members = memberBaseService.selectByExample(memberBaseInfoExample);
            if (members != null && members.size() != 0)
            {
                MemberBaseInfo memberBaseInfo = members.get(0);
                fillByMemberBaseInfo(memberBaseInfo, account);
            }

            MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
            memberFeatureInfoExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
            List<MemberFeatureInfo> featureInfos = featureService.selectByExample(memberFeatureInfoExample);
            for (MemberFeatureInfo feature : featureInfos)
            {
                account.getFeature().put(feature.getFeatureCode(), feature.getFeatureValue());
            }
        }
        account.setShopId(shopId);
        return account;
    }

    public AnalysisAccount buildByMac(String shopId, String mac)
    {
        AnalysisAccount account = new AnalysisAccount();
        try
        {
            String userId = userCacheService.findUserIdByMac(mac);
            if (StringUtils.hasText(userId))
            {
                account = buildById(shopId, userId);
            }
            account.setShopId(shopId);
            account.setMac(mac);

        }
        catch (Exception e)
        {
            GooagooLog.error("", e);
        }
        return account;
    }

    public AnalysisAccount buildByIp(String ip)
    {

        return null;
    }

    public void save(AnalysisAccount account)
    {
        String shopId = account.getShopId();
        if (shopId != null)
        {
            BasicDBObject dbObject = toMongo(account);
            if (StringUtils.hasText(account.getUserId()))
            {
                dbObject.put("_id", shopId + "_0_" + account.getUserId());
                mongoDao.save(dbObject);
                String email = getAccountEmail(account.getUserId());
                if (StringUtils.hasText(email))
                {
                    dbObject.put("_id", shopId + "_0_" + email);
                    mongoDao.save(dbObject);
                }
            }
            if (StringUtils.hasText(account.getIp()))
            {
                dbObject.put("_id", shopId + "_2_" + account.getIp());
                mongoDao.save(dbObject);

            }
            if (StringUtils.hasText(account.getMac()))
            {
                dbObject.put("_id", shopId + "_3_" + account.getMac());
                mongoDao.save(dbObject);
            }

            if (StringUtils.hasText(account.getPhyCardNo()))
            {
                dbObject.put("_id", shopId + "_7_" + account.getPhyCardNo());
                mongoDao.save(dbObject);
            }
        }
    }

    private String getAccountEmail(String userId)
    {
        Map<String, String> account = userCacheService.findUserInfo(userId);
        if (account != null && !account.isEmpty())
        {
            return account.get("email");
        }
        else
        {
            return null;
        }
    }

    private BasicDBObject toMongo(AnalysisAccount account)
    {
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put("phone", account.getTelephone());
        dbObject.put("phyCardNo", account.getPhyCardNo());
        dbObject.put("sex", account.getSex());
        dbObject.put("shopId", account.getShopId());
        dbObject.put("name", account.getName());//姓名

        dbObject.put("idType", account.getIdType());//证件类型
        dbObject.put("idNo", account.getIdNo());//证件号码
        dbObject.put("email", account.getEmail());//邮箱
        dbObject.put("telephone", account.getTelephone());//联系电话
        dbObject.put("postCode", account.getPostCode());//邮编
        dbObject.put("address", account.getAddress());//联系地址
        dbObject.put("mobile", account.getMobile());
        dbObject.put("memberLevel", account.getMemberLevel());//会员等级
        dbObject.put("userId", account.getUserId());
        dbObject.put("cardId", account.getCardId());
        dbObject.put("scardNo", account.getScardNo());
        dbObject.put("mobile", account.getMobile());
        dbObject.put("mac", account.getMac());
        dbObject.put("ip", account.getIp());
        dbObject.put("sex", account.getSex());
        if (account.getBirthday() != null)
        {
            dbObject.put("birthday", TimeUtils.convertDateToString(account.getBirthday(), TimeUtils.FORMAT2));//生日
            Calendar cal = Calendar.getInstance();
            cal.setTime(account.getBirthday());
            dbObject.put("birthYear", cal.get(Calendar.YEAR));
            dbObject.put("birthMonth", cal.get(Calendar.MONTH) + 1);
            dbObject.put("birthDay", cal.get(Calendar.DAY_OF_MONTH));
        }
        Map<String, String> features = account.getFeature();
        BasicDBObject feature = new BasicDBObject();
        for (String key : features.keySet())
        {
            feature.put(key, features.get(key));
        }
        dbObject.put("feature", feature);
        return dbObject;
    }
}
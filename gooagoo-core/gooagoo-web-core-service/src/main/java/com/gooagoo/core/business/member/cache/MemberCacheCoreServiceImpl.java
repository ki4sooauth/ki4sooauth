package com.gooagoo.core.business.member.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.member.cache.MemberCacheCoreService;
import com.gooagoo.api.generator.core.member.IntegralInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.redis.data.RedisHashDao;

/**
 * 从缓存中查询会员相关信息
 */
@Service
public class MemberCacheCoreServiceImpl implements MemberCacheCoreService
{

    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private MemberCardGeneratorCoreService memberCardGeneratorCoreService;
    @Autowired
    private IntegralInfoGeneratorCoreService integralInfoGeneratorCoreServices;
    @Autowired
    private MemberBaseInfoGeneratorCoreService memberBaseInfoGeneratorCoreService;

    @Override
    public Map<String, String> findMembeInfo(String userId, String shopId) throws Exception
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        Map<String, String> result = redisHashDao.get(userId + "_" + shopId);

        if (result == null || result.size() == 0)
        {
            MemberOfCard memberOfCard = this.selectMemberOfCard(userId, shopId);
            IntegralInfo integralInfo = this.selectIntegral(userId, shopId);
            MemberCard memberCard = this.selectMemberCard(memberOfCard.getCardId());
            MemberBaseInfo memberBaseInfo = this.selectmemberBaseInfo(memberOfCard.getPhyCardNo(), shopId);
            result = this.assembling(memberOfCard, integralInfo, memberCard, memberBaseInfo);
        }
        return result;
    }

    @Override
    public Map<String, String> findMembeInfoByScardno(String scardno) throws Exception
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        Map<String, String> result = redisHashDao.get(scardno);

        if (result == null || result.size() == 0)
        {
            result = new HashMap<String, String>();
            MemberOfCard memberOfCard = this.memberOfCardGeneratorCoreService.selectUnDelByPrimaryKey(scardno);
            if (memberOfCard != null)
            {
                MemberCard memberCard = this.selectMemberCard(memberOfCard.getCardId());
                if (memberCard != null)
                {
                    IntegralInfo integralInfo = this.selectIntegral(memberOfCard.getUserId(), memberOfCard.getShopId());
                    if (integralInfo != null)
                    {
                        MemberBaseInfo memberBaseInfo = this.selectmemberBaseInfo(memberOfCard.getPhyCardNo(), memberOfCard.getShopId());
                        if (memberBaseInfo != null)
                        {

                            result = this.assembling(memberOfCard, integralInfo, memberCard, memberBaseInfo);
                        }
                    }
                }
            }
        }
        return result;
    }

    private Map<String, String> assembling(MemberOfCard memberOfCard, IntegralInfo integralInfo, MemberCard memberCard, MemberBaseInfo memberBaseInfo)
    {
        Map<String, String> result = new HashMap<String, String>();
        if ("0".equals(memberOfCard.getCardType2())) //会员或关注
        {
            result.put("type", "A");
        }
        else
        {
            result.put("type", "M");
        }
        result.put("expireDate", TimeUtils.convertDateToString(memberOfCard.getExpireDate(), TimeUtils.FORMAT1));
        result.put("shopId", memberOfCard.getShopId());
        result.put("scardno", memberOfCard.getScardno());
        result.put("phyCardNo", memberOfCard.getPhyCardNo());
        result.put("cardId", memberOfCard.getCardId());
        result.put("cardName", memberCard.getCardName());
        result.put("cardType", memberCard.getCardType());
        result.put("cardType2", memberCard.getCardType2());
        result.put("cardLvl", memberCard.getCardLvl());
        result.put("cardUrl", memberCard.getCardUrl());
        result.put("description", memberCard.getDescription());
        result.put("useLimited", memberCard.getUseLimited().toString());
        result.put("integral", integralInfo.getUseableIntegralNumber().toString());
        result.put("phyName", memberBaseInfo.getPhyName());
        result.put("name", memberBaseInfo.getName());
        result.put("sex", memberBaseInfo.getSex());
        if (memberBaseInfo.getBirthday() != null)
        {
            result.put("birthday", TimeUtils.convertDateToString(memberBaseInfo.getBirthday(), TimeUtils.FORMAT1));
        }
        result.put("idType", memberBaseInfo.getIdType());
        result.put("idNo", memberBaseInfo.getIdNo());
        result.put("mobile", memberBaseInfo.getMobile());
        result.put("telephone", memberBaseInfo.getTelephone());
        result.put("email", memberBaseInfo.getEmail());
        result.put("postcode", memberBaseInfo.getPostcode());
        result.put("address", memberBaseInfo.getAddress());
        return result;
    }

    private MemberOfCard selectMemberOfCard(String userId, String shopId)
    {
        MemberOfCardExample example = new MemberOfCardExample();
        example.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCards = this.memberOfCardGeneratorCoreService.selectByExample(example);
        if (memberOfCards != null && memberOfCards.size() != 0)
        {
            return memberOfCards.get(0);
        }
        return null;
    }

    private IntegralInfo selectIntegral(String userId, String shopId)
    {
        IntegralInfoExample example = new IntegralInfoExample();
        example.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<IntegralInfo> infos = this.integralInfoGeneratorCoreServices.selectByExample(example);
        if (infos != null && infos.size() != 0)
        {
            return infos.get(0);
        }
        return null;
    }

    /**
     * 卡信息
     */
    private MemberCard selectMemberCard(String cardId)
    {
        MemberCard memberCard = this.memberCardGeneratorCoreService.selectUnDelByPrimaryKey(cardId);
        return memberCard;
    }

    private MemberBaseInfo selectmemberBaseInfo(String phyNo, String shopId)
    {
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andPhyNoEqualTo(phyNo).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberBaseInfo> memberBaseInfolList = this.memberBaseInfoGeneratorCoreService.selectByExample(memberBaseInfoExample);
        if (memberBaseInfolList != null && memberBaseInfolList.size() != 0)
        {
            return memberBaseInfolList.get(0);
        }
        return null;
    }
}

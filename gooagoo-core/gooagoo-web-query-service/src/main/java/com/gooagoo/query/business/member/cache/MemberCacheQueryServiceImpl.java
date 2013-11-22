package com.gooagoo.query.business.member.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
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
public class MemberCacheQueryServiceImpl implements MemberCacheQueryService
{
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;
    @Autowired
    private MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;

    @Override
    public Map<String, String> findMembeInfo(String userId, String shopId) throws Exception
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user_shop);
        Map<String, String> result = redisHashDao.get(userId + "_" + shopId);

        if (result == null || result.size() == 0)
        {
            MemberOfCard memberOfCard = this.selectMemberOfCard(userId, shopId);
            if (memberOfCard != null)
            {
                IntegralInfo integralInfo = this.selectIntegral(userId, shopId);
                MemberCard memberCard = this.selectMemberCard(memberOfCard.getCardId());
                MemberBaseInfo memberBaseInfo = this.selectmemberBaseInfo(memberOfCard.getPhyCardNo(), shopId);
                result = this.assembling(memberOfCard, integralInfo, memberCard, memberBaseInfo);
                redisHashDao.set(userId + "_" + shopId, result);
            }
        }
        return result;
    }

    @Override
    public Map<String, String> findMembeInfoByScardno(String scardno) throws Exception
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user_shop);
        Map<String, String> result = redisHashDao.get(scardno);

        if (result == null || result.size() == 0)
        {
            result = new HashMap<String, String>();
            MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectByPrimaryKey(scardno);
            if (memberOfCard != null)
            {
                MemberCard memberCard = this.selectMemberCard(memberOfCard.getCardId());
                IntegralInfo integralInfo = this.selectIntegral(memberOfCard.getUserId(), memberOfCard.getShopId());
                MemberBaseInfo memberBaseInfo = this.selectmemberBaseInfo(memberOfCard.getPhyCardNo(), memberOfCard.getShopId());
                result = this.assembling(memberOfCard, integralInfo, memberCard, memberBaseInfo);
                redisHashDao.set(scardno, result);
                result = redisHashDao.get(scardno);
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
        result.put("expireDate", memberOfCard.getExpireDate() != null ? TimeUtils.convertDateToString(memberOfCard.getExpireDate(), TimeUtils.FORMAT1) : null);
        result.put("userId", memberOfCard.getUserId());
        result.put("shopId", memberOfCard.getShopId());
        result.put("scardno", memberOfCard.getScardno());
        result.put("phyCardNo", memberOfCard.getPhyCardNo());
        result.put("cardId", memberOfCard.getCardId());
        if (memberCard != null)
        {
            result.put("cardName", memberCard.getCardName());
            result.put("cardType", memberCard.getCardType());
            result.put("cardType2", memberCard.getCardType2());
            result.put("cardLvl", memberCard.getCardLvl());
            result.put("cardUrl", memberCard.getCardUrl());
            result.put("description", memberCard.getDescription());
            result.put("useLimited", memberCard.getUseLimited().toString());
        }
        if (integralInfo != null)
        {
            result.put("integral", integralInfo.getUseableIntegralNumber().toString());
        }
        if (memberBaseInfo != null)
        {
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
        }
        return result;
    }

    private MemberOfCard selectMemberOfCard(String userId, String shopId)
    {
        MemberOfCardExample example = new MemberOfCardExample();
        example.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCards = this.memberOfCardGeneratorQueryService.selectByExample(example);
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
        List<IntegralInfo> infos = this.integralInfoGeneratorQueryService.selectByExample(example);
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
        MemberCard memberCard = this.memberCardGeneratorQueryService.selectUnDelByPrimaryKey(cardId);
        return memberCard;
    }

    private MemberBaseInfo selectmemberBaseInfo(String phyNo, String shopId)
    {
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andPhyNoEqualTo(phyNo).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberBaseInfo> memberBaseInfolList = this.memberBaseInfoGeneratorQueryService.selectByExample(memberBaseInfoExample);
        if (memberBaseInfolList != null && memberBaseInfolList.size() != 0)
        {
            return memberBaseInfolList.get(0);
        }
        return null;
    }
}

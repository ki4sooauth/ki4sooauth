package com.gooagoo.core.business.member.usermember;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.member.usermember.AttentionCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.MemberProtectedCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.business.user.ShopNotExistAttentionCardException;
import com.gooagoo.exception.business.user.UserAlreadyAttentionShopException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class AttentionCoreServiceImpl implements AttentionCoreService
{

    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private MemberCardGeneratorCoreService memberCardGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private MemberProtectedCoreService memberProtectedCoreService;

    @Override
    public boolean addAttention(String userId, String shopId) throws Exception
    {
        //检查用户状态、商家状态
        String cardId = this.checkStatus4Add(userId, shopId);
        //发关注卡
        return this.memberProtectedCoreService.sendCard(userId, cardId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteAttention(String userId, String shopId) throws Exception
    {
        //校验商家会员卡状态
        List<MemberOfCard> memberOfCardList = this.checkStatus4Del(userId, shopId);
        for (MemberOfCard memberOfCard : memberOfCardList)
        {
            memberOfCard.setIsDel("Y");
            if (!this.memberOfCardGeneratorCoreService.updateByPrimaryKeySelective(memberOfCard))
            {
                GooagooLog.error("取消关注：删除用户（" + userId + "）持有的商家（" + shopId + "）关注电子卡（" + memberOfCard.getScardno() + "）异常", null);
                return false;
            }
            //删除会员卡时,将redis缓存中关联信息清空
            RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.business_user_shop);
            redisDatabase.del(memberOfCard.getUserId() + "_" + memberOfCard.getShopId());
            redisDatabase.del(memberOfCard.getScardno());
        }
        return true;
    }

    /**检查用户状态、商家状态、判定商家是否有关注卡、商家有关注卡，判定用户是否已是商家的会员或已关注过商家
     * @param userId
     * @param shopId
     * @return cardId
     * @throws Exception
     */
    private String checkStatus4Add(String userId, String shopId) throws Exception
    {
        //1、检查用户状态
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("关注：用户（" + userId + "）状态异常");
            throw new GooagooException("用户（" + userId + "）状态异常");
        }
        //2、检查商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(shopId))
        {
            GooagooLog.info("关注：商家（" + shopId + "）状态异常");
            throw new GooagooException("商家（" + shopId + "）状态异常");
        }
        //3、判定商家是否有关注卡
        MemberCardExample queryCondition1 = new MemberCardExample();
        queryCondition1.createCriteria().andShopIdEqualTo(shopId).andCardTypeEqualTo("00").andCardType2EqualTo("0").andIsDelEqualTo("N");
        List<MemberCard> memberCardList = this.memberCardGeneratorCoreService.selectByExample(queryCondition1);
        if (CollectionUtils.isEmpty(memberCardList))
        {
            //商家无关注卡，不允许被关注
            GooagooLog.info("关注：用户（" + userId + "）需要关注的商家（" + shopId + "）无关注卡");
            throw new ShopNotExistAttentionCardException("用户（" + userId + "）需要关注的商家（" + shopId + "）无关注卡");
        }
        else if (memberCardList.size() > 1)
        {
            //商家持有多张关注卡
            GooagooLog.info("关注：商家（" + shopId + "）持有多张关注卡，用户（" + userId + "）关注失败");
            throw new GooagooException("商家（" + shopId + "）持有多张关注卡，用户（" + userId + "）关注失败");
        }
        //4、商家有关注卡，判定用户是否已是商家的会员或已关注过商家
        MemberOfCardExample queryCondition2 = new MemberOfCardExample();
        queryCondition2.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isNotEmpty(memberOfCardList))
        {
            if (memberOfCardList.size() == 1)
            {
                //判定用户现有卡类型
                if ("0".equals(memberOfCardList.get(0).getCardType2()))
                {
                    //3.2.2.1、用户已关注过商家
                    GooagooLog.info("关注：用户（" + userId + "）已关注过商家（" + shopId + "）");
                    throw new UserAlreadyAttentionShopException("用户（" + userId + "）已关注过商家（" + shopId + "）");
                }
                else
                {
                    //3.2.2.2、用户已是商家会员
                    GooagooLog.info("关注：用户（" + userId + "）已是商家（" + shopId + "）会员");
                    throw new UserAlreadyShopMemberException("用户（" + userId + "）已是商家（" + shopId + "）会员");
                }
            }
            else if (memberOfCardList.size() > 1)
            {
                //3.2.3、用户持有商家多张会员卡
                GooagooLog.info("关注：用户（" + userId + "）持有商家（" + shopId + "）多张会员卡");
                throw new GooagooException("用户（" + userId + "）持有商家（" + shopId + "）多张会员卡");
            }
        }
        return memberCardList.get(0).getCardId();
    }

    /**检查用户状态、商家状态、判断用户是否关注此商家
     * @param userId
     * @param shopId
     * @return cardId
     * @throws Exception
     */
    private List<MemberOfCard> checkStatus4Del(String userId, String shopId) throws Exception
    {
        //1、检查用户状态
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("关注：用户（" + userId + "）状态异常");
            throw new GooagooException("用户（" + userId + "）状态异常");
        }
        //2、检查商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(shopId))
        {
            GooagooLog.info("关注：商家（" + shopId + "）状态异常");
            throw new GooagooException("商家（" + shopId + "）状态异常");
        }
        //3、判断用户是否关注此商家
        MemberOfCardExample queryCondition1 = new MemberOfCardExample();
        queryCondition1.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andCardType2EqualTo("0").andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(queryCondition1);
        if (CollectionUtils.isEmpty(memberOfCardList))
        {
            //3.1、用户未关注过此商家
            GooagooLog.info("取消关注：用户（" + userId + "）未关注过商家（" + shopId + "）");
            throw new OperateFailException("用户（" + userId + "）未关注过商家（" + shopId + "）");
        }
        return memberOfCardList;
    }

}

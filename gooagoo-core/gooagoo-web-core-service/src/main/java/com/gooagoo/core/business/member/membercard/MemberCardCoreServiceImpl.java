package com.gooagoo.core.business.member.membercard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.member.membercard.MemberCardCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.business.card.AttentionCardNotExistsException;
import com.gooagoo.exception.business.card.BaseCardAlreadyExistsException;
import com.gooagoo.exception.business.card.BaseCardNotExistsException;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.card.CardAlreadyGivenException;
import com.gooagoo.exception.business.card.CardNameAlreadyExistsException;
import com.gooagoo.exception.business.card.CardTypeNotEnoughException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class MemberCardCoreServiceImpl implements MemberCardCoreService
{
    @Autowired
    private MemberCardGeneratorCoreService memberCardGeneratorCoreService;
    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;

    @Override
    public boolean addMemberCard(MemberCard memberCard) throws CardTypeNotEnoughException, CardAlreadyExistsException, AttentionCardNotExistsException, BaseCardNotExistsException, CardNameAlreadyExistsException, CardAlreadyGivenException, OperateFailException
    {
        List<MemberCard> memberCards = this.getShopMemberCardList(memberCard.getShopId());
        //校验商家会员卡状态
        this.checkMemberCardStatus(memberCard, memberCards, false);
        //初始化默认信息
        this.defaultCardInfo(memberCard, memberCards);
        //保存
        if (!this.memberCardGeneratorCoreService.insertSelective(memberCard))
        {
            throw new OperateFailException("创建会员卡失败");
        }
        return true;
    }

    @Override
    public boolean updateMemberCard(MemberCard memberCard) throws CardTypeNotEnoughException, CardAlreadyExistsException, AttentionCardNotExistsException, BaseCardNotExistsException, CardNameAlreadyExistsException, CardAlreadyGivenException, OperateFailException
    {
        List<MemberCard> memberCards = this.getShopMemberCardList(memberCard.getShopId());
        //初始化默认信息
        this.defaultCardInfo(memberCard, memberCards);
        //校验商家会员卡状态
        this.checkMemberCardStatus(memberCard, memberCards, true);
        //保存
        if (!this.memberCardGeneratorCoreService.updateByPrimaryKeySelective(memberCard))
        {
            throw new OperateFailException("修改会员卡失败");
        }
        return true;
    }

    @Override
    public boolean deleteMemberCard(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除会员卡：Id为空");
            return false;
        }
        //获取会员卡信息
        MemberCard memberCard = this.memberCardGeneratorCoreService.selectByPrimaryKey(id);
        //校验是否已发卡
        this.checkCardGiven(memberCard.getShopId(), memberCard.getCardId());
        //删除基础卡时检查是否有高级卡，删除基本卡时检查是否有基本卡
        boolean has = false;
        List<MemberCard> memberCards = this.getShopMemberCardList(memberCard.getShopId());
        if ("1".equals(memberCard.getCardLvl()))
        {
            has = this.checkCardExistByCardLvl(memberCard.getCardId(), "2", memberCards);
            if (has)
            {
                throw new CardAlreadyExistsException("存在高级卡");
            }
        }
        else if ("0".equals(memberCard.getCardLvl()))
        {
            has = this.checkCardExistByCardLvl(memberCard.getCardId(), "1", memberCards);
            if (has)
            {
                throw new BaseCardAlreadyExistsException("存在基本卡");
            }
        }
        if (!this.memberCardGeneratorCoreService.deleteByPrimaryKey(id))
        {
            throw new OperateFailException("删除会员卡失败");
        }
        return true;
    }

    /**
     * 初始化会员卡默认信息（卡类型、关注卡的升级积分和使用期限、基本卡的升级积分）
     * @param card 当前会员卡
     * @param memberCards 商家现在所拥有的卡
     * @throws CardTypeNotEnoughException 
     * @throws Exception
     */
    private void defaultCardInfo(MemberCard card, List<MemberCard> memberCards) throws CardTypeNotEnoughException
    {
        String cardType = this.getCardType(card, memberCards);
        card.setPublishStatus("W");
        card.setIsDel("N");
        card.setCardType(cardType);
        if ("0".equals(card.getCardLvl()))
        {
            card.setNeedJifen(0);
            card.setUseLimited(9999);
        }
        else if ("1".equals(card.getCardLvl()))
        {
            card.setNeedJifen(0);
        }
    }

    /**
     * 获取会员卡类型
     * @param card当前会员卡
     * @param memberCards 商家现在所拥有的卡
     * @return
     * @throws CardTypeNotEnoughException 
     */
    private String getCardType(MemberCard card, List<MemberCard> memberCards) throws CardTypeNotEnoughException
    {
        //查询出已被使用的会员卡类型
        List<Integer> usedCardTypes = new ArrayList<Integer>();
        if (memberCards != null)
        {
            for (MemberCard obj : memberCards)
            {
                usedCardTypes.add(Integer.parseInt(obj.getCardType(), 16));
            }
        }
        //确定卡类型取值范围
        String[] typeArray = null;
        if ("0".equals(card.getCardType2()))
        {
            return "00";
        }
        else if ("1".equals(card.getCardType2()))
        {
            typeArray = new String[] { "10", "F0" };
        }
        else if ("2".equals(card.getCardType2()))
        {
            typeArray = new String[] { "F1", "FF" };
        }
        //获取可用的卡类型
        for (int i = Integer.parseInt(typeArray[0], 16); i <= Integer.parseInt(typeArray[1], 16); i++)
        {
            if (usedCardTypes.contains(i))
            {
                continue;
            }
            else
            {
                return Integer.toHexString(i).toUpperCase();
            }
        }
        throw new CardTypeNotEnoughException("没有可用卡类型");
    }

    /**
     * 校验商家会员卡状态
     * 1.会员卡名称不能重复
     * 2.修改会员卡时需检查是否已发卡
     * 3.创建修改会员卡时非高级卡只能创建一个（当前卡除外）
     * 4.创建修改基础卡时检查是否有关注卡（当前卡除外），创建修改高级卡时检查是否有基本卡（当前卡除外）
     * @param memberCard 当前会员卡
     * @param memberCards 商家现在所拥有的卡
     * @param isUpdate 是否是修改卡信息
     * @throws CardAlreadyExistsException
     * @throws AttentionCardNotExistsException
     * @throws BaseCardNotExistsException
     * @throws CardNameAlreadyExistsException
     * @throws CardAlreadyGivenException
     */
    private void checkMemberCardStatus(MemberCard memberCard, List<MemberCard> memberCards, boolean isUpdate) throws CardAlreadyExistsException, AttentionCardNotExistsException, BaseCardNotExistsException, CardNameAlreadyExistsException, CardAlreadyGivenException
    {
        //会员卡名称不能重复
        boolean has = this.checkCardExistByCardName(memberCard.getCardId(), memberCard.getCardName(), memberCards);
        if (has)
        {
            throw new CardNameAlreadyExistsException("会员卡名称不能重复");
        }
        //修改会员卡时需检查是否已发卡
        if (isUpdate)
        {
            this.checkCardGiven(memberCard.getShopId(), memberCard.getCardId());
        }
        //非高级卡只能创建一个
        if (!"2".equals(memberCard.getCardLvl()))
        {
            if (this.checkCardExistByCardLvl(memberCard.getCardId(), memberCard.getCardLvl(), memberCards))
            {
                throw new CardAlreadyExistsException("非高级卡只能创建一个");
            }
        }
        //创建基础卡时检查是否有关注卡，创建高级卡时检查是否有基本卡
        if ("1".equals(memberCard.getCardLvl()))
        {
            if (!this.checkCardExistByCardLvl(memberCard.getCardId(), "0", memberCards))
            {
                throw new AttentionCardNotExistsException("关注卡不存在");
            }
        }
        else if ("2".equals(memberCard.getCardLvl()))
        {
            if (!this.checkCardExistByCardLvl(memberCard.getCardId(), "1", memberCards))
            {
                throw new BaseCardNotExistsException("基本卡不存在");
            }
        }
    }

    /**
     * 检查此会员卡是否已发卡
     * @param shopId
     * @param cardId
     * @throws CardAlreadyGivenException
     */
    private void checkCardGiven(String shopId, String cardId) throws CardAlreadyGivenException
    {
        MemberOfCardExample temp1 = new MemberOfCardExample();
        temp1.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andCardIdEqualTo(cardId);
        if (this.memberOfCardGeneratorCoreService.countByExample(temp1) > 0)
        {
            throw new CardAlreadyGivenException("会员卡已发放到用户");
        }
    }

    /**
     * 核查是否有指定会员卡级别的会员卡
     * @param cardId 当前卡id
     * @param cardLvl 当前卡级别
     * @param memberCards
     * @return
     */
    private boolean checkCardExistByCardLvl(String cardId, String cardLvl, List<MemberCard> memberCards)
    {
        for (Iterator<MemberCard> iterator = memberCards.iterator(); iterator.hasNext();)
        {
            MemberCard memberCard = iterator.next();
            if (!memberCard.getCardId().equals(cardId) && memberCard.getCardLvl().equals(cardLvl))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 核查是否有指定会员卡名称的会员卡
     * @param cardId 当前卡id
     * @param cardName 当前卡名称
     * @param memberCards
     * @return
     */
    private boolean checkCardExistByCardName(String cardId, String cardName, List<MemberCard> memberCards)
    {
        for (Iterator<MemberCard> iterator = memberCards.iterator(); iterator.hasNext();)
        {
            MemberCard memberCard = iterator.next();
            if (!memberCard.getCardId().equals(cardId) && memberCard.getCardName().equals(cardName))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询商家会员卡列表
     * @param shopId
     * @return
     */
    private List<MemberCard> getShopMemberCardList(String shopId)
    {
        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        List<MemberCard> shopCardList = this.memberCardGeneratorCoreService.selectByExample(memberCardExample);
        if (shopCardList == null)
        {
            shopCardList = new ArrayList<MemberCard>();
        }
        return shopCardList;
    }

    @Override
    public boolean reviewedMemberCard(String cardId, String status, String note)
    {
        MemberCard memberCard = this.memberCardGeneratorCoreService.selectByPrimaryKey(cardId);
        if (memberCard == null)
        {
            GooagooLog.warn("审核会员卡：会员卡不存在，activityId=" + cardId);
            return false;
        }
        if (!"W".equals(memberCard.getPublishStatus()))
        {
            GooagooLog.warn("审核会员卡：会员卡状态不是待审核，activityId=" + cardId + ",publishStatus=" + memberCard.getPublishStatus());
            return false;
        }
        memberCard = new MemberCard();
        memberCard.setCardId(cardId);
        memberCard.setAuditNote(note);
        if ("Y".equals(status))
        {
            memberCard.setPublishStatus("A");
        }
        else
        {
            memberCard.setPublishStatus("B");
        }
        return this.memberCardGeneratorCoreService.updateByPrimaryKeySelective(memberCard);
    }

    @Override
    public boolean publishMemberCard(String activityId) throws Exception
    {
        MemberCard memberCard = this.memberCardGeneratorCoreService.selectByPrimaryKey(activityId);
        if (memberCard == null)
        {
            GooagooLog.warn("发布会员卡：会员卡不存在，activityId=" + activityId);
            return false;
        }
        if (!"A".equals(memberCard.getPublishStatus()))
        {
            GooagooLog.warn("发布会员卡：会员卡状态不是已审核，activityId=" + activityId + ",publishStatus=" + memberCard.getPublishStatus());
            return false;
        }
        memberCard.setPublishStatus("P");
        return this.memberCardGeneratorCoreService.updateByPrimaryKeySelective(memberCard);
    }
}

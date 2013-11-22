package com.gooagoo.igms.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.member.membercard.MemberCardCoreService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberCardExample.Criteria;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.business.card.AttentionCardNotExistsException;
import com.gooagoo.exception.business.card.BaseCardNotExistsException;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.card.CardAlreadyGivenException;
import com.gooagoo.exception.business.card.CardNameAlreadyExistsException;
import com.gooagoo.exception.business.card.CardTypeNotEnoughException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.member.service.CardService;
import com.gooagoo.view.gms.member.FMemberCard;
import com.google.gson.Gson;

@Service(value = "cardService")
public class CardServiceImpl implements CardService
{
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private MemberCardCoreService memberCardCoreService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    /**
     * 商家新增会员卡
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FMemberCard fMemberCard = ServletUtils.objectMethod(FMemberCard.class, request);

        fMemberCard.setCardId(StringUtils.getUUID());
        fMemberCard.setShopId(shopId);

        MemberCard memberCard = this.convertToMemberCard(fMemberCard);

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean result = this.checkMemberCard(memberCard);
        if (result)
        {
            try
            {
                result = false;
                result = this.memberCardCoreService.addMemberCard(memberCard);
            }
            catch (CardTypeNotEnoughException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_TYPE_NOT_ENOUGH;
            }
            catch (CardAlreadyExistsException e)
            {
                if ("0".equals(memberCard.getCardLvl()))
                {
                    failMessage = MessageConst.GMS_MEMBER_ATTENTION_CARD_ALREADY_EXIST;
                }
                else if ("1".equals(memberCard.getCardLvl()))
                {
                    failMessage = MessageConst.GMS_MEMBER_BASE_CARD_ALREADY_EXIST;
                }
                else
                {
                    failMessage = MessageConst.GMS_OPERATE_FAIL;
                }
            }
            catch (AttentionCardNotExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_ATTENTIONCARD;
            }
            catch (BaseCardNotExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_TOPCARD;
            }
            catch (CardNameAlreadyExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_NAME_EXIST_SO_CAN_NOT＿CREATE;
            }
            catch (CardAlreadyGivenException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_ALREADY_GIVE_OUT;
            }
            catch (OperateFailException e)
            {
                failMessage = MessageConst.GMS_OPERATE_FAIL;
            }
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, failMessage, (Object) memberCard.getCardId(), memberCard.getCardId());
    }

    /**
     * 商家删除会员卡
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");

        boolean isOk = this.memberCardCoreService.deleteMemberCard(cardId);

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cardId);
    }

    /**
     * 商家编辑会员卡
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FMemberCard fMemberCard = ServletUtils.objectMethod(FMemberCard.class, request);
        fMemberCard.setShopId(shopId);

        MemberCard memberCard = this.convertToMemberCard(fMemberCard);

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean result = this.checkMemberCard(memberCard);
        if (result)
        {
            try
            {
                result = false;
                result = this.memberCardCoreService.updateMemberCard(memberCard);
            }
            catch (CardTypeNotEnoughException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_CREATE_EXCEPTION_CARDNO;
            }
            catch (CardAlreadyExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_NAME_EXIST_SO_CAN_NOT＿CREATE;
            }
            catch (AttentionCardNotExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_ATTENTIONCARD;
            }
            catch (BaseCardNotExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_TOPCARD;
            }
            catch (CardNameAlreadyExistsException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_NAME_EXIST_SO_CAN_NOT＿CREATE;
            }
            catch (CardAlreadyGivenException e)
            {
                failMessage = MessageConst.GMS_MEMBER_CARD_ALREADY_GIVEN_USER_NOT_UPDATE;
            }
            catch (OperateFailException e)
            {
                failMessage = MessageConst.GMS_OPERATE_FAIL;
                GooagooLog.error("编缉会员卡信息时异常，参数：" + new Gson().toJson(memberCard), e);
            }
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, failMessage, fMemberCard.getCardId());
    }

    /**
     * 会员卡列表查询
     */
    @Override
    public TransData<List<FMemberCard>> memberCardList(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MemberCardExample example = new MemberCardExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        example.setOrderByClause("card_Lvl");

        List<FMemberCard> list = new ArrayList<FMemberCard>();

        List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(example);
        for (MemberCard card : memberCardList)
        {
            list.add(this.convertToFMemberCard(card));
        }

        return new TransData<List<FMemberCard>>(true, null, list);
    }

    /**
     * 审核会员卡
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean result = this.memberCardCoreService.reviewedMemberCard(cardId, status, note);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cardId);
    }

    /**
     * 发布会员卡
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<Object> publish(HttpServletRequest request) throws Exception
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");

        boolean result = this.memberCardCoreService.publishMemberCard(cardId);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cardId);
    }

    /**
     * 会员卡详细信息查询
     */
    @Override
    public TransData<FMemberCard> getMemberCard(HttpServletRequest request) throws Exception
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");

        MemberCard memberCard = this.memberCardGeneratorQueryService.selectByPrimaryKey(cardId);
        FMemberCard fMemberCard = this.convertToFMemberCard(memberCard);

        return new TransData<FMemberCard>(true, null, fMemberCard);
    }

    /**
     * 查看商家会员卡是否已发放
     */
    @Override
    public TransData<Object> cardHasGive(HttpServletRequest request) throws Exception
    {
        boolean isOk = true;
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");

        MemberOfCardExample example = new MemberOfCardExample();
        com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria criteria = example.createCriteria();

        criteria.andShopIdEqualTo(shopId);
        criteria.andIsDelEqualTo(GMSConstant.NO);

        if (org.springframework.util.StringUtils.hasText(cardId))
        {
            criteria.andCardIdEqualTo(cardId);
        }

        Integer count = this.memberOfCardGeneratorQueryService.countByExample(example);
        if (count > 0)
        {
            isOk = false;
        }
        return new TransData<Object>(isOk, "", "");
    }

    private MemberCard convertToMemberCard(FMemberCard fMemberCard) throws Exception
    {
        MemberCard memberCard = new MemberCard();
        Date currentTime = new Date();
        Date expireDate = null;

        if (fMemberCard != null)
        {
            memberCard.setShopId(fMemberCard.getShopId());
            memberCard.setCardId(fMemberCard.getCardId());
            memberCard.setCardName(fMemberCard.getCardName());
            if ("0".equals(fMemberCard.getCardLvl()))
            {
                memberCard.setCardType2("0");
                memberCard.setNeedApproval("N");
            }
            else
            {
                if ((GMSConstant.NO).equals(fMemberCard.getExistPhy()))
                {
                    memberCard.setCardType2("1");
                }
                else if ((GMSConstant.YES).equals(fMemberCard.getExistPhy()))
                {
                    memberCard.setCardType2("2");
                }
                if ((GMSConstant.YEAR).equals(fMemberCard.getUseLimitedUnit()))
                {
                    expireDate = TimeUtils.dateAdd(1, currentTime, fMemberCard.getUseLimited());
                }
                else if ((GMSConstant.MONTH).equals(fMemberCard.getUseLimitedUnit()))
                {
                    expireDate = TimeUtils.dateAdd(2, currentTime, fMemberCard.getUseLimited());
                }
                else if ((GMSConstant.DAY).equals(fMemberCard.getUseLimitedUnit()))
                {
                    expireDate = TimeUtils.dateAdd(3, currentTime, fMemberCard.getUseLimited());
                }
                String end = TimeUtils.convertDateToString(expireDate, "yyyy-MM-dd");
                String start = TimeUtils.convertDateToString(currentTime, "yyyy-MM-dd");
                memberCard.setUseLimited(TimeUtils.dateDiff(3, start, end));
                memberCard.setNeedApproval(fMemberCard.getNeedApproval());

            }
            memberCard.setCardLvl(fMemberCard.getCardLvl());
            memberCard.setNeedJifen(fMemberCard.getNeedJifen());

            memberCard.setCardUrl(fMemberCard.getCardUrl());
            memberCard.setDescription(fMemberCard.getDescription());
            memberCard.setIsDel(GMSConstant.NO);
        }
        return memberCard;
    }

    private FMemberCard convertToFMemberCard(MemberCard memberCard) throws IllegalArgumentException, IllegalAccessException
    {
        FMemberCard fMemberCard = new FMemberCard();

        if (memberCard != null)
        {
            EntityTools.copyValue(memberCard, fMemberCard);
            fMemberCard.setCardHeadUrl(UrlUtils.getAttachUrlByImg("dh_top", memberCard.getCardUrl()));
            fMemberCard.setCardBodyUrl(UrlUtils.getAttachUrlByImg("dh_bottom", memberCard.getCardUrl()));
        }
        return fMemberCard;
    }

    /**
     * 校验会员卡
     * @param memberCard
     * @return
     */
    private boolean checkMemberCard(MemberCard memberCard)
    {
        if (memberCard == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getCardId()) || memberCard.getCardId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getCardName()) || memberCard.getCardId().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getShopId()))
        {
            return false;
        }

        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getCardType2()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getCardLvl()))
        {
            return false;
        }
        else if ("1".equals(memberCard.getCardLvl()) || "2".equals(memberCard.getCardLvl()))
        {
            if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getNeedApproval()))
            {
                return false;
            }
            if ("2".equals(memberCard.getCardLvl()))
            {
                if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getNeedApproval()))
                {
                    return false;
                }
            }
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getCardUrl()) || memberCard.getCardUrl().length() > 255)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getDescription()) || memberCard.getDescription().length() > 200)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(memberCard.getIsDel()))
        {
            return false;
        }
        //TODO 判断会员卡名称是否唯一
        //        MemberCardExample example = new MemberCardExample();
        //        Criteria criteria = example.createCriteria();
        //        criteria.andIsDelEqualTo(GMSConstant.NO);
        //        criteria.andShopIdEqualTo(memberCard.getShopId());
        //        criteria.andCardNameEqualTo(memberCard.getCardName());
        //
        //        Integer count = this.memberCardGeneratorQueryService.countByExample(example);
        //        if (count > 0)
        //        {
        //            return false;
        //        }
        return true;
    }
}

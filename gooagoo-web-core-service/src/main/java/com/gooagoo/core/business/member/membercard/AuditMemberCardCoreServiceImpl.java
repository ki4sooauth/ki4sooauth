package com.gooagoo.core.business.member.membercard;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.member.membercard.AuditMemberCardCoreService;
import com.gooagoo.api.generator.core.member.CardUpInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.ConvertApplyGeneratorCoreService;
import com.gooagoo.api.generator.core.member.IntegralInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberApplyGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.MemberProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.exception.business.card.GiveCardFailException;
import com.gooagoo.exception.business.member.MemberIntegralNotEnoughException;
import com.gooagoo.exception.business.member.ShopMemberNotExistsException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class AuditMemberCardCoreServiceImpl implements AuditMemberCardCoreService
{
    @Autowired
    private MemberApplyGeneratorCoreService memberApplyGeneratorCoreService;
    @Autowired
    private ConvertApplyGeneratorCoreService convertApplyGeneratorCoreService;
    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private MemberBaseInfoGeneratorCoreService memberBaseInfoGeneratorCoreService;
    @Autowired
    private MemberCardGeneratorCoreService memberCardGeneratorCoreService;
    @Autowired
    private IntegralInfoGeneratorCoreService IntegralInfoGeneratorQueryServices;
    @Autowired
    private CardUpInfoGeneratorCoreService CardUpInfoGeneratorCoreService;
    @Autowired
    private MemberProtectedCoreService memberProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean auditMemberCard(String applicationId, String status, String note) throws CardAlreadyExistsException, CardNotExistsException, GiveCardFailException, Exception
    {
        MemberApply apply = this.memberApplyGeneratorCoreService.selectUnDelByPrimaryKey(applicationId);
        if (apply == null)
        {
            GooagooLog.warn("会员卡申请审核，MemberApply为空：applicationId=" + applicationId);
            return false;
        }
        String shopId = apply.getShopId();
        String applyStatus = "N";
        if ("Y".equals(status))
        {
            applyStatus = "P";
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andCardLvlEqualTo("1");
            List<MemberCard> memberCardlist = this.memberCardGeneratorCoreService.selectByExample(memberCardExample);
            if (CollectionUtils.isEmpty(memberCardlist))
            {
                GooagooLog.info("会员卡申请审核：" + "商家shopId=" + shopId + "没有");
                throw new CardNotExistsException("商家没有");
            }
            if (!this.memberProtectedCoreService.sendCard(apply.getUserId(), memberCardlist.get(0).getCardId()))
            {
                return false;
            }
        }
        //更新申请卡的审核状态、添加或更新会员基本信息
        MemberApply applyNew = new MemberApply();
        applyNew.setApplicationId(applicationId);
        applyNew.setStatus(applyStatus);
        applyNew.setAuditNote(note);
        applyNew.setCTimeStamp(new Date());
        if (!this.memberApplyGeneratorCoreService.updateByPrimaryKeySelective(applyNew))
        {
            GooagooLog.info("会员卡申请审核,更新审核状态失败：applicationId=" + applicationId + "，applyStatus=" + applyStatus + "，note=" + note);
            throw new OperateFailException("更新申请卡的审核状态失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean auditConvertPhysicalCard(String applicationId, String status, String note) throws ShopMemberNotExistsException, CardAlreadyExistsException, CardNotExistsException, GiveCardFailException, Exception
    {
        ConvertApply convertApply = this.convertApplyGeneratorCoreService.selectUnDelByPrimaryKey(applicationId);
        if (convertApply == null)
        {
            GooagooLog.warn("物理卡转换申请审核，ConvertApply为空：applicationId=" + applicationId);
            return false;
        }
        String applyStatus = "N";
        if ("Y".equals(status))
        {
            applyStatus = "P";
            //1、校验申请数据
            this.memberProtectedCoreService.checkConvertCard(convertApply);
            //2、发卡
            this.sendCardForConvert(convertApply);
        }
        ConvertApply convertNew = new ConvertApply();
        convertNew.setApplicationId(applicationId);
        convertNew.setStatus(applyStatus);
        convertNew.setAuditNote(note);
        convertNew.setCTimeStamp(new Date());
        if (!this.convertApplyGeneratorCoreService.updateByPrimaryKeySelective(convertApply))
        {
            GooagooLog.info("审核物理卡转换申请为,更新审核状态失败：applicationId=" + applicationId + "，applyStatus=" + applyStatus + "，note=" + note);
            throw new OperateFailException("更新申请卡的审核状态失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean auditMemberCardUpgrade(String cardUpInfoId, String status, String note) throws CardAlreadyExistsException, GiveCardFailException, Exception
    {
        CardUpInfo cardUpInfo = this.CardUpInfoGeneratorCoreService.selectUnDelByPrimaryKey(cardUpInfoId);
        if (cardUpInfo == null)
        {
            GooagooLog.warn("会员卡升级审核，CardUpInfo为空：cardUpInfoId=" + cardUpInfoId);
            return false;
        }
        String applyStatus = "N";
        if ("Y".equals(status))
        {
            applyStatus = "P";
            //效验升级会员卡
            if (!this.checkMemberCardUpgrade(cardUpInfo))
            {
                return false;
            }
            //发卡
            if (!this.memberProtectedCoreService.sendCard(cardUpInfo.getUserId(), cardUpInfo.getUpCardId()))
            {
                GooagooLog.info("会员卡升级审核,发卡失败：userId=" + cardUpInfo.getUserId() + ",cardId=" + cardUpInfo.getUpCardId());
                throw new GiveCardFailException("发卡失败[userId=" + cardUpInfo.getUserId() + "cardId=" + cardUpInfo.getUpCardId() + "]");
            }
        }
        //更新会员卡升级信息中审核状态
        CardUpInfo cardUpInfoNew = new CardUpInfo();
        cardUpInfoNew.setId(cardUpInfoId);
        cardUpInfoNew.setStatus(applyStatus);
        cardUpInfoNew.setAuditNote(note);
        if (!this.CardUpInfoGeneratorCoreService.updateByPrimaryKeySelective(cardUpInfoNew))
        {
            GooagooLog.info("会员卡升级审核,更新审核状态失败：cardUpInfoId=" + cardUpInfoId + "，applyStatus=" + applyStatus + "，note=" + note);
            throw new OperateFailException("更新会员卡升级的审核状态失败");
        }
        //调自动升级接口(继续升级由于审核没升到的卡)
        IntegralInfoExample integralInfoExample = new IntegralInfoExample();
        integralInfoExample.createCriteria().andUserIdEqualTo(cardUpInfo.getUserId()).andShopIdEqualTo(cardUpInfo.getShopId()).andIsDelEqualTo("N");
        List<IntegralInfo> integralInfoList = this.IntegralInfoGeneratorQueryServices.selectByExample(integralInfoExample);
        if (CollectionUtils.isEmpty(integralInfoList))
        {
            GooagooLog.info("获取用户历史总积分为空[userId=" + cardUpInfo.getUserId() + "、shopId=" + cardUpInfo.getShopId() + "]");
            return false;
        }
        return this.memberProtectedCoreService.autoUpgradeCardByIntegral(cardUpInfo.getUserId(), cardUpInfo.getShopId(), integralInfoList.get(0).getHistoryTotalIntegral());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean specialApprovalMemberCard(String shopId, String userId, String newCardId, String oldCardId) throws GiveCardFailException, Exception
    {
        MemberOfCard memberOfCard = this.getMemberOfCard(userId, shopId);
        //判断用户是否已有该商家的此张卡
        if (StringUtils.hasText(oldCardId))
        {
            if (memberOfCard == null || !oldCardId.equals(memberOfCard.getCardId()))
            {
                GooagooLog.info("会员卡特批：用户没有此卡，oldCardId=" + oldCardId + "用户userId＝" + userId + ",cardId=" + memberOfCard.getCardId());
                throw new CardNotExistsException("用户没有此卡");
            }
        }
        if (memberOfCard != null && newCardId.equals(memberOfCard.getCardId()))
        {
            GooagooLog.info("会员卡特批：用户已有此卡，newCardId=" + newCardId + "用户userId＝" + userId + ",cardId=" + memberOfCard.getCardId());
            throw new CardAlreadyExistsException("用户已有此卡");
        }
        //发卡
        if (!this.memberProtectedCoreService.sendCard(userId, newCardId))
        {
            GooagooLog.info("会员卡特批,发卡失败：userId=" + userId + ",cardId=" + newCardId);
            throw new GiveCardFailException("发卡失败");
        }
        return true;
    }

    /**
     * 查询用户拥有此商家的会员卡（未过期）
     * @param userId
     * @param shopId
     * @return
     * @throws Exception 
     */
    private MemberOfCard getMemberOfCard(String userId, String shopId) throws Exception
    {
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.setOrderByClause("c_time_stamp DESC");
        memberOfCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andUserIdEqualTo(userId).andExpireDateGreaterThanOrEqualTo(TimeUtils.convertStringToDate(TimeUtils.getCurrentDate() + " 23:59:59"));
        List<MemberOfCard> list = this.memberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    /**
     * 发卡(物理卡转换)
     * @param shopId 商家编号
     * @throws Exception
     */
    private void sendCardForConvert(ConvertApply convertApply) throws Exception
    {
        //通过shopId、phyNo获取memberBaseInfo信息
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(convertApply.getShopId()).andPhyNoEqualTo(convertApply.getPhyNo());
        List<MemberBaseInfo> memberBaseInfoList = this.memberBaseInfoGeneratorCoreService.selectByExample(memberBaseInfoExample);
        if (CollectionUtils.isEmpty(memberBaseInfoList))
        {
            GooagooLog.info("物理卡转换申请审核，根据商家及物理卡号未查询到符合条件的会员信息：shopId=" + convertApply.getShopId() + ",物理卡号=" + convertApply.getPhyNo());
            throw new ShopMemberNotExistsException("商家无此会员！");
        }
        //通过shopId、phyName获取memberCard信息
        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(convertApply.getShopId()).andCardNameEqualTo(memberBaseInfoList.get(0).getPhyName());
        List<MemberCard> memberCardList = this.memberCardGeneratorCoreService.selectByExample(memberCardExample);
        if (CollectionUtils.isEmpty(memberCardList))
        {
            GooagooLog.info("会员卡申请审核：" + "商家shopId=" + convertApply.getShopId() + "没有" + memberBaseInfoList.get(0).getPhyName());
            throw new CardNotExistsException("商家shopId=" + convertApply.getShopId() + "没有" + memberBaseInfoList.get(0).getPhyName());
        }
        //判断用户是否申请过此卡
        MemberCard memberCard = memberCardList.get(0);
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(convertApply.getUserId()).andCardIdEqualTo(memberCard.getCardId());
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(memberOfCardList))
        {
            GooagooLog.info("userId=" + convertApply.getUserId() + "用户以持有会员卡cardId=" + memberCard.getCardId() + "");
            throw new CardAlreadyExistsException("userId=" + convertApply.getUserId() + "用户以持有会员卡cardId=" + memberCard.getCardId() + "");
        }
        //发卡
        MemberOfCard memberOfCard = new MemberOfCard();
        memberOfCard.setScardno(this.memberProtectedCoreService.getScardNo(convertApply.getShopId(), convertApply.getUserId(), memberOfCard.getCardType2()));
        memberOfCard.setPhyCardNo(convertApply.getPhyNo());
        memberOfCard.setCardId(memberCard.getCardId());
        memberOfCard.setUserId(convertApply.getUserId());
        memberOfCard.setShopId(memberCard.getShopId());
        memberOfCard.setCardType2("2");
        memberOfCard.setExpireDate(TimeUtils.dateAdd(3, new Date(), memberCard.getUseLimited()));
        memberOfCard.setIsDel("N");
        if (!this.memberOfCardGeneratorCoreService.insertSelective(memberOfCard))
        {
            GooagooLog.error("物理卡转换发卡失败[" + memberOfCard.toString() + "]", null);
            throw new OperateFailException("物理卡转换发卡失败[" + memberOfCard.toString() + "]");
        }
    }

    /**效验升级会员卡
     * @param cardUpInfo 会员卡升级信息
     * @return
     * @throws Exception 
     */
    private boolean checkMemberCardUpgrade(CardUpInfo cardUpInfo) throws Exception
    {
        MemberCard upMemberCard = this.memberCardGeneratorCoreService.selectUnDelByPrimaryKey(cardUpInfo.getUpCardId());
        if (!cardUpInfo.getShopId().equals(upMemberCard.getShopId()))//检查升级卡和当前卡是否一致
        {
            GooagooLog.warn("会员卡升级审核，shopId不一致：shopId=" + cardUpInfo.getShopId() + ",UpMemberCard.shopId=" + upMemberCard.getShopId());
            return false;
        }
        MemberOfCard memberOfCard = this.getMemberOfCard(cardUpInfo.getUserId(), cardUpInfo.getShopId());
        if (memberOfCard == null)
        {
            GooagooLog.warn("会员卡升级审核，用户没有此商家的有效会员卡：shopId=" + cardUpInfo.getShopId() + ",userId=" + cardUpInfo.getUserId());
            return false;
        }
        MemberCard memberCard = this.memberCardGeneratorCoreService.selectUnDelByPrimaryKey(memberOfCard.getCardId());
        if (memberCard.getCardId().equals(cardUpInfo.getUpCardId()))
        {
            GooagooLog.warn("会员卡升级审核，用户已有此：shopId=" + cardUpInfo.getShopId() + ",cardId=" + memberOfCard.getCardId());
            throw new CardAlreadyExistsException("用户已有此卡");
        }
        //检查积分够不够
        IntegralInfoExample integralInfoExample = new IntegralInfoExample();
        integralInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(cardUpInfo.getShopId()).andUserIdEqualTo(cardUpInfo.getUserId());
        List<IntegralInfo> integralInfos = this.IntegralInfoGeneratorQueryServices.selectByExample(integralInfoExample);
        if (upMemberCard.getNeedJifen() > integralInfos.get(0).getHistoryTotalIntegral())
        {
            GooagooLog.info("会员卡升级审核,积分不够：upMemberCard=" + upMemberCard.toString() + ",integralInfo=" + integralInfos.get(0).toString());
            throw new MemberIntegralNotEnoughException("会员卡升级审核,积分不够：upMemberCard=" + upMemberCard.toString() + ",integralInfo=" + integralInfos.get(0).toString());
        }
        return true;
    }
}

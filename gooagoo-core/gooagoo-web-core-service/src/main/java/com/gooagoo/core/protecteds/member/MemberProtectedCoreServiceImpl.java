package com.gooagoo.core.protecteds.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.member.crm.CrmMemberCoreService;
import com.gooagoo.api.generator.core.member.CardUpInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberApplyGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.MemberProtectedCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.exception.business.card.CardAlreadyConvertedException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.exception.business.shop.ShopCardStatusException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class MemberProtectedCoreServiceImpl implements MemberProtectedCoreService
{

    @Autowired
    private MemberApplyGeneratorCoreService memberApplyGeneratorCoreService;
    @Autowired
    private MemberCardGeneratorCoreService MemberCardGeneratorCoreService;
    @Autowired
    private MemberOfCardGeneratorCoreService MemberOfCardGeneratorCoreService;
    @Autowired
    private MemberBaseInfoGeneratorCoreService MemberBaseInfoGeneratorCoreService;
    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private CardUpInfoGeneratorCoreService cardUpInfoGeneratorCoreService;
    @Autowired
    private CrmMemberCoreService crmMemberCoreService;

    private final static Object synObject = new Object();//发卡同步锁

    @Override
    public String getScardNo(String shopId, String userId, String cardType) throws Exception
    {
        String lidBase = this.shopProtectedCoreService.getLidBase(shopId, null);
        if (StringUtils.isBlank(lidBase))
        {
            GooagooLog.info("获取电子卡号失败:商家未分配Lid信息[shopId=" + shopId + "]");
            throw new OperateFailException("获取电子卡号失败:商家未分配Lid信息[shopId=" + shopId + "]");
        }
        UserInfo userInfo = this.userInfoGeneratorCoreService.selectByPrimaryKey(userId);
        if (userInfo == null)
        {
            GooagooLog.info("获取电子卡号失败:用户信息为空[userId=" + userId + "]");
            throw new OperateFailException("获取电子卡号失败:用户信息为空[userId=" + userId + "]");
        }
        return lidBase + userInfo.getUserNum() + cardType;
    }

    @Override
    public void checkConvertCard(ConvertApply convertApply) throws Exception
    {
        //1、设置申请时间
        convertApply.setApplyTime(new Date());
        //2、校验申请来源
        if (SysdictionaryCache.get("info_source", convertApply.getSource()) == null)
        {
            GooagooLog.info("校验申请物理卡转换数据：申请来源（" + convertApply.getSource() + "）有误");
            throw new FormatErrorException("申请来源（" + convertApply.getSource() + "）有误");
        }
        //3、校验物理卡号
        if (StringUtils.isBlank(convertApply.getPhyNo()))
        {
            GooagooLog.info("校验申请物理卡转换数据：物理卡号（" + convertApply.getPhyNo() + "）为空");
            throw new NullException("物理卡号（" + convertApply.getPhyNo() + "）为空");
        }
        //4、校验身份证号与手机号
        if (StringUtils.isBlank(convertApply.getIdNo()) && StringUtils.isBlank(convertApply.getMobile()))
        {
            GooagooLog.info("校验申请物理卡转换数据：身份证号（" + convertApply.getIdNo() + "）与手机号码（" + convertApply.getMobile() + "）同时为空");
            throw new NullException("身份证号（" + convertApply.getIdNo() + "）与手机号码（" + convertApply.getMobile() + "）同时为空");
        }
        //5、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(convertApply.getUserId()))
        {
            GooagooLog.info("校验申请物理卡转换数据：用户（" + convertApply.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + convertApply.getUserId() + "）状态异常");
        }
        //6、校验商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(convertApply.getShopId()))
        {
            GooagooLog.info("校验申请物理卡转换数据：商家（" + convertApply.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + convertApply.getShopId() + "）状态异常");
        }
        //7、判断用户是否持有商家的物理卡
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andShopIdEqualTo(convertApply.getShopId()).andPhyNoEqualTo(convertApply.getPhyNo()).andIsDelEqualTo("N");
        List<MemberBaseInfo> memberBaseInfoList = this.MemberBaseInfoGeneratorCoreService.selectByExample(memberBaseInfoExample);
        if (CollectionUtils.isEmpty(memberBaseInfoList))
        {
            //用户未持有商家的物理卡
            GooagooLog.info("物理卡转换申请：用户（" + convertApply.getUserId() + "）未持有商家（" + convertApply.getShopId() + "）的物理卡");
            throw new OperateFailException("用户（" + convertApply.getUserId() + "）未持有商家（" + convertApply.getShopId() + "）的物理卡");
        }
        MemberBaseInfo memberBaseInfo = memberBaseInfoList.get(0);
        //8、判断申请手机号或身份证号是否一致
        if ((StringUtils.isNotBlank(convertApply.getIdNo()) && "00".equals(memberBaseInfo.getIdType()) && convertApply.getIdNo().equals(memberBaseInfo.getIdNo())) || (StringUtils.isNotBlank(convertApply.getMobile()) && convertApply.getMobile().equals(memberBaseInfo.getMobile())))
        {
            //9、用户持有商家的物理卡，判断商家的物理卡是否有对应的电子卡
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andCardNameEqualTo(memberBaseInfo.getPhyName()).andShopIdEqualTo(convertApply.getShopId()).andIsDelEqualTo("N");
            if (this.MemberCardGeneratorCoreService.countByExample(memberCardExample) == 0)
            {
                //10、商家的物理卡没有对应的电子卡
                GooagooLog.info("物理卡转换申请：商家（" + convertApply.getShopId() + "）的物理卡（" + memberBaseInfo.getPhyNo() + "）没有对应的电子卡");
                throw new OperateFailException("商家（" + convertApply.getShopId() + "）的物理卡（" + memberBaseInfo.getPhyNo() + "）没有对应的电子卡");
            }
            else
            {
                //11、商家的物理卡有对应的电子卡，判断物理卡是否已申请转换
                MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
                memberOfCardExample.createCriteria().andShopIdEqualTo(convertApply.getShopId()).andPhyCardNoEqualTo(memberBaseInfo.getPhyNo());
                if (this.MemberOfCardGeneratorCoreService.countByExample(memberOfCardExample) != 0)
                {
                    GooagooLog.info("物理卡转换申请：用户（" + convertApply.getUserId() + "）持有的物理卡（" + memberBaseInfo.getPhyNo() + "）已转换");
                    throw new CardAlreadyConvertedException("用户（" + convertApply.getUserId() + "）持有的物理卡（" + memberBaseInfo.getPhyNo() + "）已转换");
                }
            }
        }
        else
        {
            //用户未持有商家的物理卡
            GooagooLog.info("物理卡转换申请：用户（" + convertApply.getUserId() + "）持有的物理卡（" + memberBaseInfo.getPhyNo() + "）信息（" + memberBaseInfo.getIdType() + "|" + memberBaseInfo.getIdNo() + "|" + memberBaseInfo.getMobile() + "）不对应(00|" + convertApply.getIdNo() + "|" + convertApply.getMobile() + "）");
            throw new OperateFailException("用户（" + convertApply.getUserId() + "）持有的物理卡（" + memberBaseInfo.getPhyNo() + "）信息（" + memberBaseInfo.getIdType() + "|" + memberBaseInfo.getIdNo() + "|" + memberBaseInfo.getMobile() + "）不对应(00|" + convertApply.getIdNo() + "|" + convertApply.getMobile() + "）");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean sendCard(String userId, String cardId) throws Exception
    {
        //获取商家卡信息
        MemberCard memberCard = this.MemberCardGeneratorCoreService.selectUnDelByPrimaryKey(cardId);
        if (memberCard == null)
        {
            GooagooLog.info("发卡：会员卡（" + cardId + "）不存在或已被删除");
            throw new CardNotExistsException("会员卡（" + cardId + "）不存在或已被删除");
        }
        if (!"P".equals(memberCard.getPublishStatus()))
        {
            GooagooLog.debug("发卡:卡状态不是已发布[cardId=" + memberCard.getCardId() + "、publishStatus=" + memberCard.getPublishStatus() + "]");
            throw new ShopCardStatusException("发卡:卡状态不是已发布[cardId=" + memberCard.getCardId() + "、publishStatus=" + memberCard.getPublishStatus() + "]");
        }
        List<String> oldPhyNo = null;
        String newPhyNo = null;
        if ("2".equals(memberCard.getCardType2()))
        {//TODO 线下、通过crm系统获取商家物理卡号
            MemberBaseInfo memberBaseInfoCon = new MemberBaseInfo();
            newPhyNo = this.crmMemberCoreService.getPhyNoFromShop(memberBaseInfoCon);
        }
        //获取原始物理卡号、并删除原始会员卡与用户关联信息
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(memberCard.getShopId());
        List<MemberOfCard> oldMemberOfCardList = this.MemberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(oldMemberOfCardList))
        {
            oldPhyNo = new ArrayList<String>();
            for (MemberOfCard item : oldMemberOfCardList)
            {
                if ("N".equals(item.getIsDel()))
                {
                    oldPhyNo = new ArrayList<String>();
                    oldPhyNo.add(item.getPhyCardNo());
                    item.setIsDel("Y");
                    if (!this.MemberOfCardGeneratorCoreService.updateByPrimaryKeySelective(item))
                    {
                        GooagooLog.error("发卡:删除原始会员卡与用户关联信息失败[scardno=" + item.getScardno() + "]", null);
                        return false;
                    }
                    break;
                }
                else
                {
                    oldPhyNo.add(item.getPhyCardNo());
                }
            }
        }
        synchronized (synObject)
        {
            //保存会员卡与用户关联信息、会员基本信息
            return this.saveMemberInfo(memberCard, userId, oldPhyNo, newPhyNo);
        }
    }

    @Override
    public boolean autoUpgradeCardByIntegral(String userId, String shopId, Integer historyTotalIntegral) throws Exception
    {
        //1、判断用户状态
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            return false;
        }
        //2、判断商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(shopId))
        {
            return false;
        }
        //3、获取用户当前持有的卡
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.MemberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        if (CollectionUtils.isEmpty(memberOfCardList))
        {
            GooagooLog.info("会员卡升级（自动）：用户（" + userId + "）未持有商家（" + shopId + "）的会员卡");
            return false;
        }
        if (memberOfCardList.size() > 1)
        {
            GooagooLog.info("会员卡升级（自动）：用户（" + userId + "）持有商家（" + shopId + "）多张会员卡");
            return false;
        }
        MemberOfCard memberOfCard = memberOfCardList.get(0);
        //4、过滤关注卡
        if ("0".equals(memberOfCard.getCardType2()))
        {
            //关注卡无需升级
            return true;
        }
        //5、查询可升级到的会员卡
        String upgradeCardId = null;//需要升级到的会员卡ID
        MemberCardExample queryCondition2 = new MemberCardExample();
        queryCondition2.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        queryCondition2.setOrderByClause("need_jifen ASC");
        List<MemberCard> memberCardList = this.MemberCardGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isNotEmpty(memberCardList))
        {
            boolean upgrade = false;//当商家会员卡等级大于用户持有卡等级时为true
            for (MemberCard memberCard : memberCardList)
            {
                if (upgrade)
                {
                    if (historyTotalIntegral >= memberCard.getNeedJifen())
                    {
                        if ("N".equals(memberCard.getNeedApproval()))
                        {//无需审核直接发卡
                            upgradeCardId = memberCard.getCardId();
                        }
                        else
                        {//需要审核
                            MemberBaseInfo memberBaseInfo = this.getPhyCard(memberCard, memberOfCard.getPhyCardNo());
                            CardUpInfo cardUpInfo = new CardUpInfo();
                            cardUpInfo.setId(UUID.getUUID());//自动编号,UUID
                            cardUpInfo.setUserId(memberOfCard.getUserId());//用户编号
                            cardUpInfo.setShopId(memberOfCard.getShopId());//商家ID
                            cardUpInfo.setCardId(memberOfCard.getCardId());//当前会员卡编码
                            cardUpInfo.setUpCardId(memberCard.getCardId());//积分升级可获得的会员卡编码
                            cardUpInfo.setNeedIntegral(memberCard.getNeedJifen());//会员卡升级所需积分
                            if ("2".equals(memberCard.getCardType2()))
                            {
                                //TODO 物理卡号由商家CRM系统接口获取
                                MemberBaseInfo memberBaseInfoCon = new MemberBaseInfo();
                                String phyNo = this.crmMemberCoreService.getPhyNoFromShop(memberBaseInfoCon);
                                cardUpInfo.setPhyNo(phyNo);
                            }
                            else
                            {
                                cardUpInfo.setPhyNo(this.getScardNo(shopId, userId, memberCard.getCardType()));//物理卡号
                            }
                            cardUpInfo.setPhyName(memberCard.getCardName());//物理卡名称
                            cardUpInfo.setName(memberBaseInfo.getName());//姓名
                            cardUpInfo.setSex(memberBaseInfo.getSex());//性别，参考通用字典表的sex
                            cardUpInfo.setBirthday(memberBaseInfo.getBirthday());//出生日期
                            cardUpInfo.setIdType(memberBaseInfo.getIdType());//证件类型，参考通用字典表的idtype
                            cardUpInfo.setIdNo(memberBaseInfo.getIdNo());//证件号码
                            cardUpInfo.setMobile(memberBaseInfo.getMobile());//手机号码
                            cardUpInfo.setTelephone(memberBaseInfo.getTelephone());//联系电话
                            cardUpInfo.setEmail(memberBaseInfo.getEmail());//电子邮箱
                            cardUpInfo.setPostcode(memberBaseInfo.getPostcode());//邮政编码
                            cardUpInfo.setStatus("W");//审核状态，参考通用字典表的application_status
                            cardUpInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
                            return this.cardUpInfoGeneratorCoreService.insertSelective(cardUpInfo);
                        }
                    }
                }
                else if (memberOfCard.getCardId().equals(memberCard.getCardId()))
                {
                    upgrade = true;
                }
            }
        }
        if (StringUtils.isBlank(upgradeCardId))
        {
            return true;
        }
        //5、发卡
        try
        {
            if (!this.sendCard(userId, upgradeCardId))
            {
                GooagooLog.info("会员卡升级（自动）：将用户（" + userId + "）的现有会员卡 （" + memberOfCard.getCardId() + "）进行升级（" + upgradeCardId + "）");
                return false;
            }
        }
        catch (CardNotExistsException e)
        {
            GooagooLog.error("会员卡升级（自动）：将用户（" + userId + "）的现有会员卡 （" + memberOfCard.getCardId() + "）进行升级（" + upgradeCardId + "）", e);
            return false;
        }
        return true;
    }

    /**
     * 获取线下物理卡（针对先有线下的物理卡情况）
     * @param memberCard
     * @param phyCardNo
     * @return
     */
    private MemberBaseInfo getPhyCard(MemberCard memberCard, String phyCardNo)
    {
        MemberBaseInfo memberBaseInfo = null;
        if (StringUtils.isNotBlank(phyCardNo))
        {
            MemberBaseInfoExample queryCondition = new MemberBaseInfoExample();
            queryCondition.createCriteria().andShopIdEqualTo(memberCard.getShopId()).andPhyNoEqualTo(phyCardNo).andIsDelEqualTo("N");
            List<MemberBaseInfo> memberBaseInfoList = this.MemberBaseInfoGeneratorCoreService.selectByExample(queryCondition);
            if (memberBaseInfoList.size() == 0)
            {
                GooagooLog.info("获取线下物理卡：商家（" + memberCard.getShopId() + "）未拥有物理卡（" + memberCard.getCardName() + "|" + phyCardNo + "）");
                return null;
            }
            memberBaseInfo = memberBaseInfoList.get(0);
        }

        return memberBaseInfo;
    }

    /**保存会员卡与用户关联信息、会员基本信息
     * @return
     * @throws Exception 
     */
    private boolean saveMemberInfo(MemberCard memberCard, String userId, List<String> oldPhyNo, String newPhyNo) throws Exception
    {
        Date currentTime = new Date();//获取当前时间
        String scardNo = null;//音频卡号
        //判断是否曾发过卡？更新:新增
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(memberCard.getShopId()).andCardIdEqualTo(memberCard.getCardId());
        List<MemberOfCard> memberOfCardList = this.MemberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        MemberOfCard memberOfCard = CollectionUtils.isNotEmpty(memberOfCardList) ? memberOfCardList.get(0) : null;
        if (memberOfCard != null)
        {//更新MemberOfCard
            if (StringUtils.isNotBlank(newPhyNo))
            {
                memberOfCard.setPhyCardNo(newPhyNo);//当商家变更物理卡号时更新物理卡号编号
            }
            memberOfCard.setIsDel("N");
            memberOfCard.setExpireDate(TimeUtils.dateAdd(3, currentTime, memberCard.getUseLimited()));
            memberOfCard.setCreateTime(null);
            memberOfCard.setCTimeStamp(null);
            if (!this.MemberOfCardGeneratorCoreService.updateByPrimaryKeySelective(memberOfCard))
            {
                GooagooLog.error("发卡:更新会员卡与用户关联信息失败[memberOfCard=" + memberOfCard.toString() + "]", null);
                return false;
            }
        }
        else
        {//新增MemberOfCard
            scardNo = this.getScardNo(memberCard.getShopId(), userId, memberCard.getCardType());
            MemberOfCard newMemberOfCard = new MemberOfCard();
            newMemberOfCard.setScardno(scardNo);
            //TODO 当商家变更物理卡号时更新物理卡号编号、待确认
            newMemberOfCard.setPhyCardNo(StringUtils.isNotBlank(newPhyNo) ? newPhyNo : scardNo);
            newMemberOfCard.setCardId(memberCard.getCardId());
            newMemberOfCard.setUserId(userId);
            newMemberOfCard.setShopId(memberCard.getShopId());
            newMemberOfCard.setCardType2("00".equals(memberCard.getCardType()) ? "0" : "1");
            newMemberOfCard.setExpireDate(TimeUtils.dateAdd(3, currentTime, memberCard.getUseLimited()));
            newMemberOfCard.setIsDel("N");
            if (!this.MemberOfCardGeneratorCoreService.insertSelective(newMemberOfCard))
            {
                GooagooLog.error("发卡:新增会员卡与用户关联信息失败[memberOfCard=" + newMemberOfCard.toString() + "]", null);
                return false;
            }
        }
        //获取会员申请信息
        MemberApplyExample memberApplyExample = new MemberApplyExample();
        memberApplyExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(memberCard.getShopId()).andStatusEqualTo("W").andIsDelEqualTo("N");
        memberApplyExample.setOrderByClause("c_time_stamp DESC");
        List<MemberApply> memberApplyList = this.memberApplyGeneratorCoreService.selectByExample(memberApplyExample);
        MemberApply memberApply = CollectionUtils.isNotEmpty(memberApplyList) ? memberApplyList.get(0) : null;
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        if (CollectionUtils.isNotEmpty(oldPhyNo))
        {//更新MemberBaseInfo
         //TODO 当商家变更物理卡号时更新物理卡号编号、待确认
            memberBaseInfo.setPhyNo(StringUtils.isNotBlank(newPhyNo) ? newPhyNo : StringUtils.isNotBlank(scardNo) ? scardNo : memberOfCard.getPhyCardNo());
            memberBaseInfo.setPhyName(memberCard.getCardName());
            memberBaseInfo.setIsDel("N");
            if (memberApply != null)
            {
                this.completeMemberBaseInfo(memberApply, memberBaseInfo);
            }
            MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
            memberBaseInfoExample.createCriteria().andPhyNoIn(oldPhyNo).andShopIdEqualTo(memberCard.getShopId());
            if (!this.MemberBaseInfoGeneratorCoreService.updateByExampleSelective(memberBaseInfo, memberBaseInfoExample))
            {
                GooagooLog.error("发卡:更新会员基本信息失败[memberOfCard=" + memberOfCard.toString() + "]", null);
                return false;
            }
        }
        else
        {//新增MemberBaseInfo
            memberBaseInfo.setId(UUID.getUUID());
            memberBaseInfo.setShopId(memberCard.getShopId());
            //TODO 当商家变更物理卡号时更新物理卡号编号、待确认
            memberBaseInfo.setPhyNo(StringUtils.isNotBlank(newPhyNo) ? newPhyNo : scardNo);
            memberBaseInfo.setPhyName(memberCard.getCardName());
            memberBaseInfo.setIsDel("N");
            if (memberApply != null)
            {
                this.completeMemberBaseInfo(memberApply, memberBaseInfo);
            }
            if (!this.MemberBaseInfoGeneratorCoreService.insertSelective(memberBaseInfo))
            {
                GooagooLog.error("发卡:新增会员基本信息失败[newMemberBaseInfo=" + memberBaseInfo.toString() + "]", null);
                return false;
            }
        }
        return true;
    }

    /**获取申请卡信息补全会员基础信息
     * @param memberApply 申请卡信息
     * @param memberBaseInfo 会员基础信息
     * @return
     */
    private MemberBaseInfo completeMemberBaseInfo(MemberApply memberApply, MemberBaseInfo memberBaseInfo)
    {
        memberBaseInfo.setName(memberApply.getName());
        memberBaseInfo.setSex(memberApply.getSex());
        memberBaseInfo.setBirthday(memberApply.getBirthday());
        memberBaseInfo.setIdType(memberApply.getIdType());
        memberBaseInfo.setIdNo(memberApply.getIdNo());
        memberBaseInfo.setMobile(memberApply.getMobile());
        memberBaseInfo.setTelephone(memberApply.getTelephone());
        memberBaseInfo.setEmail(memberApply.getEmail());
        memberBaseInfo.setPostcode(memberApply.getPostcode());
        memberBaseInfo.setAddress(memberApply.getAddress());
        return memberBaseInfo;
    }

}

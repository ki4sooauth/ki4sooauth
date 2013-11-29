package com.gooagoo.core.business.member.usermember;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.member.usermember.UserMemberCoreService;
import com.gooagoo.api.generator.core.member.ConvertApplyGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberApplyGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberFeatureGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberFeatureInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.MemberProtectedCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.CheckMemberUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.business.card.CardAlreadyConvertedException;
import com.gooagoo.exception.business.member.MemberFeatureCodeIsNullException;
import com.gooagoo.exception.business.member.MemberFeatureCodeTooLongException;
import com.gooagoo.exception.business.member.MemberFeatureValueIsNullException;
import com.gooagoo.exception.business.member.MemberFeatureValueTooLongException;
import com.gooagoo.exception.business.user.UserAlreadyApplyException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;
import com.gooagoo.exception.business.user.UserCanNotRepetitionApplyMemberException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class UserMemberCoreServiceImpl implements UserMemberCoreService
{

    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private MemberCardGeneratorCoreService memberCardGeneratorCoreService;
    @Autowired
    private MemberApplyGeneratorCoreService memberApplyGeneratorCoreService;
    @Autowired
    private ConvertApplyGeneratorCoreService convertApplyGeneratorCoreService;
    @Autowired
    private MemberFeatureInfoGeneratorCoreService memberFeatureInfoGeneratorCoreService;
    @Autowired
    private MemberFeatureGeneratorCoreService memberFeatureGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private MemberBaseInfoGeneratorCoreService memberBaseInfoGeneratorCoreService;
    @Autowired
    private MemberProtectedCoreService memberProtectedCoreService;

    private final static Object synObject1 = new Object();//提交申请会员卡同步锁
    private final static Object synObject2 = new Object();//提交申请物理卡转换同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean applyMember(MemberApply memberApply) throws Exception
    {
        //1、申请数据校验
        this.checkApplyMemberCardData(memberApply);
        //2、补全申请信息
        memberApply.setApplicationId(StringUtils.isNotBlank(memberApply.getApplicationId()) ? memberApply.getApplicationId() : UUID.getUUID());//申请编号，UUID
        memberApply.setApplyTime(new Date());//申请时间
        memberApply.setStatus("W");//申请状态
        memberApply.setIsDel("N");//是否删除
        //3、判定用户是否拥有该商家会员卡
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(memberApply.getUserId()).andShopIdEqualTo(memberApply.getShopId()).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
        MemberOfCard memberOfCard = CollectionUtils.isNotEmpty(memberOfCardList) ? memberOfCardList.get(0) : null;
        if (memberOfCard == null)
        {
            //3.1、用户未持有该商家会员卡，判定商家是否有基础卡
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andShopIdEqualTo(memberApply.getShopId()).andCardLvlEqualTo("1").andIsDelEqualTo("N");
            List<MemberCard> memberCardList = this.memberCardGeneratorCoreService.selectByExample(memberCardExample);
            if (CollectionUtils.isEmpty(memberCardList))
            {
                //3.1.1、商家没有基础卡
                GooagooLog.info("申请会员：商家（" + memberApply.getShopId() + "）没有基础卡，用户（" + memberApply.getUserId() + "）申请会员卡失败");
                throw new OperateFailException("商家（" + memberApply.getShopId() + "）没有基础卡，用户（" + memberApply.getUserId() + "）申请会员卡失败");
            }
            else if (memberCardList.size() == 1)
            {
                //商家有基础卡，判定商家的基础卡是否为自动发放
                MemberCard memberCard = memberCardList.get(0);
                if ("Y".equals(memberCard.getNeedApproval()))
                {
                    //商家持有的基础卡需要审批，提交申请信息
                    this.submitApplyMemberCard(memberApply);
                }
                else
                {
                    //商家持有的基础卡自动发放，立即发卡
                    this.memberProtectedCoreService.sendCard(memberApply.getUserId(), memberCard.getCardId());
                }
            }
        }
        else
        {
            //用户已拥有该商家会员卡，判定当前卡是否为关注卡
            if ("0".equals(memberOfCard.getCardType2()))
            {
                //用户持有的是关注卡，提交申请信息
                this.submitApplyMemberCard(memberApply);
            }
            else
            {
                //用户已是该商家会员
                GooagooLog.info("申请会员：用户（" + memberApply.getUserId() + "）已是商家（" + memberApply.getShopId() + "）会员（" + memberOfCard.getCardId() + "）");
                throw new UserAlreadyShopMemberException("用户（" + memberApply.getUserId() + "）已是商家（" + memberApply.getShopId() + "）会员（" + memberOfCard.getCardId() + "）");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteMember(String scardNo, String userId, String shopId) throws Exception
    {
        //1、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("删除会员卡：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //2、校验商家编号
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("删除会员卡：商家编号（" + shopId + "）为空");
            throw new OperateFailException("商家编号（" + shopId + "）为空");
        }
        //3、判断用户是否持有商家会员卡
        MemberOfCardExample queryCondition1 = new MemberOfCardExample();
        queryCondition1.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(queryCondition1);
        if (memberOfCardList.size() == 0)
        {
            //3.1、用户未持有商家会员卡
            GooagooLog.info("删除会员卡：用户（" + userId + "）未持有商家（" + shopId + "）会员卡");
            throw new OperateFailException("用户（" + userId + "）未持有商家（" + shopId + "）会员卡");
        }
        else
        {
            RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.business_user_shop);
            int count = 0;
            //3.2、判断用户是否持有商家会员卡
            for (int i = 0; i < memberOfCardList.size(); i++)
            {
                MemberOfCard memberOfCard = memberOfCardList.get(i);
                //3.2.1、用户持有商家会员卡，删除会员卡
                if (!"0".equals(memberOfCard.getCardType2()))
                {
                    memberOfCard.setIsDel("Y");
                    if (!this.memberOfCardGeneratorCoreService.updateByPrimaryKeySelective(memberOfCard))
                    {
                        GooagooLog.error("删除会员卡：删除用户（" + userId + "）持有的商家（" + shopId + "）会员电子卡（" + memberOfCard.getScardno() + "）异常", null);
                        throw new OperateFailException("删除用户（" + userId + "）持有的商家（" + shopId + "）会员电子卡（" + memberOfCard.getScardno() + "）异常");
                    }
                    continue;
                }
                count++;
                //3.2.2、用户未持有商家会员卡
                if (count == memberOfCardList.size())
                {
                    GooagooLog.info("删除会员卡：用户（" + userId + "）未持有商家（" + shopId + "）会员卡");
                    throw new OperateFailException("用户（" + userId + "）未持有商家（" + shopId + "）会员卡");
                }
                //删除会员卡时,将redis缓存中关联信息清空
                redisDatabase.del(memberOfCard.getUserId() + "_" + memberOfCard.getShopId());
                redisDatabase.del(memberOfCard.getScardno());
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void deleteMemberForMobile(List<String> scardNoList, String userId) throws Exception
    {
        //1、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("删除会员卡：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //软删会员卡与用户关联表member_of_card
        MemberOfCard memberOfCard = new MemberOfCard();
        memberOfCard.setIsDel("Y");
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andScardnoIn(scardNoList);
        this.memberOfCardGeneratorCoreService.updateByExampleSelective(memberOfCard, memberOfCardExample);
    }

    @Override
    public boolean applyConvertPhysicalCard(ConvertApply convertApply) throws Exception
    {
        //1、校验申请数据
        this.memberProtectedCoreService.checkConvertCard(convertApply);
        //2、提交申请信息
        return this.sumbitApplyPhysicCardConversion(convertApply);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateMemberInfo(String userId, MemberBaseInfo memberBaseInfo, List<MemberFeatureInfo> memberFeatureInfoList) throws Exception
    {
        Date currentTime = new Date();
        //1、数据校验
        this.checkUpdateMemberInfoData(userId, memberBaseInfo, memberFeatureInfoList, currentTime);
        //2、处理会员修改会员信息
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        if (StringUtils.isBlank(memberBaseInfo.getPhyNo()))
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(memberBaseInfo.getShopId()).andIsDelEqualTo("N");
            List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
            if (CollectionUtils.isEmpty(memberOfCardList))
            {
                GooagooLog.info("用户[userId=" + userId + "]在商家[shopId=" + memberBaseInfo.getShopId() + "无会员卡]");
                return false;
            }
            memberBaseInfo.setPhyNo(memberOfCardList.get(0).getPhyCardNo());
        }
        memberBaseInfoExample.createCriteria().andShopIdEqualTo(memberBaseInfo.getShopId()).andPhyNoEqualTo(memberBaseInfo.getPhyNo()).andIsDelEqualTo("N");
        if (!this.memberBaseInfoGeneratorCoreService.updateByExampleSelective(memberBaseInfo, memberBaseInfoExample))
        {
            GooagooLog.error("会员修改会员信息：更新会员信息（" + memberBaseInfo.toString() + "）异常", null);
            throw new OperateFailException("更新会员信息（" + memberBaseInfo.toString() + "）异常");
        }
        if (memberFeatureInfoList == null || memberFeatureInfoList.size() == 0)
        {
            return true;
        }
        MemberOfCard memberOfCard = this.getMemberOfCard(userId, memberBaseInfo.getShopId());
        for (MemberFeatureInfo memberFeatureInfo : memberFeatureInfoList)
        {
            memberFeatureInfo.setShopId(memberBaseInfo.getShopId());
            memberFeatureInfo.setPhyNo(memberOfCard.getPhyCardNo());
            memberFeatureInfo.setUserId(userId);
            memberFeatureInfo.setScardNo(memberOfCard.getScardno());
            memberFeatureInfo.setIsDel("N");
            MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
            memberFeatureInfoExample.createCriteria().andShopIdEqualTo(memberBaseInfo.getShopId()).andPhyNoEqualTo(memberOfCard.getPhyCardNo()).andFeatureCodeEqualTo(memberFeatureInfo.getFeatureCode());
            List<MemberFeatureInfo> resultList = this.memberFeatureInfoGeneratorCoreService.selectByExample(memberFeatureInfoExample);
            if (resultList.size() == 0)
            {
                memberFeatureInfo.setId(UUID.getUUID());
                if (!this.memberFeatureInfoGeneratorCoreService.insertSelective(memberFeatureInfo))
                {
                    GooagooLog.error("会员修改会员信息：保存会员特征信息（" + memberFeatureInfo.toString() + "）异常", null);
                    throw new OperateFailException("保存会员特征信息（" + memberFeatureInfo.toString() + "）异常");
                }
            }
            else
            {
                memberFeatureInfo.setId(resultList.get(0).getId());
                if (!this.memberFeatureInfoGeneratorCoreService.updateByPrimaryKeySelective(memberFeatureInfo))
                {
                    GooagooLog.error("会员修改会员信息：更新会员特征信息（" + memberFeatureInfo.toString() + "）异常", null);
                    throw new OperateFailException("更新会员特征信息（" + memberFeatureInfo.toString() + "）异常");
                }
            }
        }

        return true;
    }

    /**
     * 校验申请会员卡数据
     * @param memberApply
     * @param currentTime
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     * @throws UserCanNotRepetitionApplyMemberException 用户不可重复提交申请会员
     */
    private boolean checkApplyMemberCardData(MemberApply memberApply) throws Exception
    {
        //1、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(memberApply.getUserId()))
        {
            GooagooLog.info("校验申请会员卡数据：用户（" + memberApply.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + memberApply.getUserId() + "）状态异常");
        }
        //2、校验商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(memberApply.getShopId()))
        {
            GooagooLog.info("校验申请会员卡数据：商家（" + memberApply.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + memberApply.getShopId() + "）状态异常");
        }
        //3、校验信息来源
        if (SysdictionaryCache.get("info_source", memberApply.getSource()) == null)
        {
            GooagooLog.info("校验申请会员卡数据：信息来源（" + memberApply.getSource() + "）格式不正确");
            throw new FormatErrorException("信息来源（" + memberApply.getSource() + "）格式不正确");
        }
        //4、校验姓名
        CheckMemberUtils.checkName(memberApply.getName());
        //5、校验证件类型、证件号码
        CheckMemberUtils.checkIdTypeAndIdNo(memberApply.getIdType(), memberApply.getIdNo());
        //6、校验性别
        CheckMemberUtils.checkSex(memberApply.getSex(), memberApply.getIdType(), memberApply.getIdNo());
        //7、校验出生日期
        CheckMemberUtils.checkBirthday(memberApply.getBirthday(), memberApply.getIdType(), memberApply.getIdNo());
        //8、校验手机号码、证件号码
        CheckMemberUtils.checkMobileAndIdNo(memberApply.getMobile(), memberApply.getIdType(), memberApply.getIdNo());
        //9、校验联系电话
        CheckMemberUtils.checkTelephone(memberApply.getTelephone());
        //10、校验电子邮箱
        CheckMemberUtils.checkEmail(memberApply.getEmail());
        //11、校验邮政编码
        CheckMemberUtils.checkPostcode(memberApply.getPostcode());
        //12、校验通讯地址
        CheckMemberUtils.checkAddress(memberApply.getAddress());
        //13、效验是否重复申请
        MemberApplyExample memberApplyExample = new MemberApplyExample();
        memberApplyExample.createCriteria().andUserIdEqualTo(memberApply.getUserId()).andShopIdEqualTo(memberApply.getShopId()).andStatusEqualTo("W").andIsDelEqualTo("N");
        List<MemberApply> memberApplyList = this.memberApplyGeneratorCoreService.selectByExample(memberApplyExample);
        if (CollectionUtils.isNotEmpty(memberApplyList))
        {
            GooagooLog.info("不可以重复申请会员[申请状态=未处理、userId=" + memberApply.getUserId() + "、shopId=" + memberApply.getShopId() + "]");
            throw new UserCanNotRepetitionApplyMemberException("不可以重复申请会员[申请状态=未处理、userId=" + memberApply.getUserId() + "、shopId=" + memberApply.getShopId() + "]");
        }
        return true;
    }

    /**
     * 提交申请会员卡
     * @param memberCard
     * @return
     * @throws OperateFailException 
     */
    private void submitApplyMemberCard(MemberApply memberApply) throws Exception
    {
        //1、判定用户是否已申请该商家会员
        MemberApplyExample memberApplyExample = new MemberApplyExample();
        memberApplyExample.createCriteria().andUserIdEqualTo(memberApply.getUserId()).andShopIdEqualTo(memberApply.getShopId()).andStatusEqualTo(memberApply.getStatus()).andIsDelEqualTo("N");
        synchronized (synObject1)
        {
            Integer count = this.memberApplyGeneratorCoreService.countByExample(memberApplyExample);
            if (count != 0)
            {
                //1.1、用户已申请该商家会员
                GooagooLog.info("提交申请会员卡：用户（" + memberApply.getUserId() + "）已申请商家（" + memberApply.getShopId() + "）会员");
                throw new UserAlreadyApplyException("用户（" + memberApply.getUserId() + "）已申请商家（" + memberApply.getShopId() + "）会员");
            }
            else
            {
                //1.2、用户未申请该商家会员
                if (!this.memberApplyGeneratorCoreService.insertSelective(memberApply))
                {
                    GooagooLog.error("提交申请会员卡：保存申请会员信息（" + memberApply.toString() + "）异常", null);
                    throw new OperateFailException("保存申请会员信息（" + memberApply.toString() + "）异常");
                }
            }
        }
    }

    /**
     * 校验申请物理卡转换数据
     * @param convertApply
     * @throws CardAlreadyConvertedException
     */
    private void checkApplyPhysicCardConversionData(ConvertApply convertApply) throws Exception
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
        List<MemberBaseInfo> memberBaseInfoList = this.memberBaseInfoGeneratorCoreService.selectByExample(memberBaseInfoExample);
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
            if (this.memberCardGeneratorCoreService.countByExample(memberCardExample) == 0)
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
                if (this.memberOfCardGeneratorCoreService.countByExample(memberOfCardExample) != 0)
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

    /**
     * 提交申请物理卡转换
     * @param convertApply
     * @return
     * @throws OperateFailException
     */
    private boolean sumbitApplyPhysicCardConversion(ConvertApply convertApply) throws Exception
    {
        synchronized (synObject2)
        {
            convertApply.setApplicationId(convertApply.getApplicationId() != null ? convertApply.getApplicationId() : UUID.getUUID());
            convertApply.setStatus("W");
            convertApply.setIsDel("N");
            //1.1、未申请物理卡转换
            if (!this.convertApplyGeneratorCoreService.insertSelective(convertApply))
            {
                GooagooLog.error("提交申请物理卡转换：保存申请物理卡转换信息（" + convertApply.toString() + "）异常", null);
                throw new OperateFailException("保存申请物理卡转换信息（" + convertApply.toString() + "）异常");
            }
        }
        return true;
    }

    /**
     * 校验会员修改会员信息数据
     * @param userId
     * @param memberBaseInfo
     * @param currentTime
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException 
     */
    private boolean checkUpdateMemberInfoData(String userId, MemberBaseInfo memberBaseInfo, List<MemberFeatureInfo> memberFeatureInfoList, Date currentTime) throws Exception
    {
        //1、校验会员信息数据
        this.checkMemberInfoData(userId, memberBaseInfo, currentTime);
        //2、校验会员特征信息数据
        this.checkMemberFeatureInfoData(memberFeatureInfoList, currentTime);
        return true;
    }

    /**
     * 校验会员信息数据
     * @param memberBaseInfo
     * @param currentTime
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException 
     */
    private boolean checkMemberInfoData(String userId, MemberBaseInfo memberBaseInfo, Date currentTime) throws NullException, FormatErrorException, OperateFailException
    {

        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("校验会员信息数据：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //2、校验商家
        if (!this.shopProtectedCoreService.checkShopStatus(memberBaseInfo.getShopId()))
        {
            GooagooLog.info("校验会员信息数据：商家（" + memberBaseInfo.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + memberBaseInfo.getShopId() + "）状态异常");
        }
        //3、校验姓名
        CheckMemberUtils.checkName(memberBaseInfo.getName());
        //4、校验证件类型、证件号码
        CheckMemberUtils.checkIdTypeAndIdNo(memberBaseInfo.getIdType(), memberBaseInfo.getIdNo());
        //5、校验性别
        CheckMemberUtils.checkSex(memberBaseInfo.getSex(), memberBaseInfo.getIdType(), memberBaseInfo.getIdNo());
        //6、校验出生日期
        CheckMemberUtils.checkBirthday(memberBaseInfo.getBirthday(), memberBaseInfo.getIdType(), memberBaseInfo.getIdNo());
        //7、校验手机号码、证件号码
        CheckMemberUtils.checkMobileAndIdNo(memberBaseInfo.getMobile(), memberBaseInfo.getIdType(), memberBaseInfo.getIdNo());
        //8、校验联系电话
        CheckMemberUtils.checkTelephone(memberBaseInfo.getTelephone());
        //9、校验电子邮箱
        CheckMemberUtils.checkEmail(memberBaseInfo.getEmail());
        //10、校验邮政编码
        CheckMemberUtils.checkPostcode(memberBaseInfo.getPostcode());
        //11、校验通讯地址
        CheckMemberUtils.checkAddress(memberBaseInfo.getAddress());
        return true;
    }

    /**
     * 校验会员特征信息数据
     * @param memberFeatureInfoList
     * @param currentTime
     * @return
     * @throws OperateFailException 
     * @throws NullException 
     * @throws FormatErrorException 
     */
    private boolean checkMemberFeatureInfoData(List<MemberFeatureInfo> memberFeatureInfoList, Date currentTime) throws Exception
    {
        if (memberFeatureInfoList == null || memberFeatureInfoList.size() == 0)
        {
            return true;
        }
        Map<String, String> temp = new HashMap<String, String>();
        for (MemberFeatureInfo memberFeatureInfo : memberFeatureInfoList)
        {
            temp.put(memberFeatureInfo.getUserId(), memberFeatureInfo.getUserId());
            //1、校验特征编码
            if (StringUtils.isBlank(memberFeatureInfo.getFeatureCode()))
            {
                GooagooLog.info("校验会员特征信息数据：特征编码（" + memberFeatureInfo.getFeatureCode() + "）为空");
                throw new MemberFeatureCodeIsNullException("特征编码（" + memberFeatureInfo.getFeatureCode() + "）为空");
            }
            if (memberFeatureInfo.getFeatureCode().length() > 32)
            {
                GooagooLog.info("校验会员特征信息数据：特征编码（" + memberFeatureInfo.getFeatureCode() + "）长度超过32个字符");
                throw new MemberFeatureCodeTooLongException("特征编码（" + memberFeatureInfo.getFeatureCode() + "）长度超过32个字符");
            }
            if (temp.get(memberFeatureInfo.getFeatureCode()) != null)
            {
                MemberFeature memberFeature = this.memberFeatureGeneratorCoreService.selectByPrimaryKey(memberFeatureInfo.getFeatureCode());
                if (memberFeature == null)
                {
                    GooagooLog.info("校验会员特征信息数据：特征编码（" + memberFeatureInfo.getFeatureCode() + "）不存在或已被删除");
                    throw new OperateFailException("特征编码（" + memberFeatureInfo.getFeatureCode() + "）不存在或已被删除");
                }
            }
            temp.put(memberFeatureInfo.getFeatureCode(), memberFeatureInfo.getFeatureCode());
            //2、校验特征值
            if (StringUtils.isBlank(memberFeatureInfo.getFeatureValue()))
            {
                GooagooLog.info("校验会员特征信息数据：特征值（" + memberFeatureInfo.getFeatureValue() + "）为空");
                throw new MemberFeatureValueIsNullException("特征值（" + memberFeatureInfo.getFeatureValue() + "）为空");
            }
            if (memberFeatureInfo.getFeatureValue().length() > 32)
            {
                GooagooLog.info("校验会员特征信息数据：特征值（" + memberFeatureInfo.getFeatureValue() + "）长度超过32个字符");
                throw new MemberFeatureValueTooLongException("特征值（" + memberFeatureInfo.getFeatureValue() + "）长度超过32个字符");
            }
        }

        return true;
    }

    /**
     * 获取用户会员卡信息
     * @param userId
     * @param shopId
     * @return
     * @throws OperateFailException
     */
    private MemberOfCard getMemberOfCard(String userId, String shopId) throws OperateFailException
    {
        MemberOfCardExample querycondition = new MemberOfCardExample();
        querycondition.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(querycondition);
        if (memberOfCardList == null || memberOfCardList.size() != 1)
        {
            GooagooLog.info("获取用户会员卡信息：用户（" + userId + "）未持有商家（" + shopId + "）会员卡，或持有的会员卡异常");
            throw new OperateFailException("用户（" + userId + "）未持有商家（" + shopId + "）会员卡，或持有的会员卡异常");
        }

        return memberOfCardList.get(0);
    }

}

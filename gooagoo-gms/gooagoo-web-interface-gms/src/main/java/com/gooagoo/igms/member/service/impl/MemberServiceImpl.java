package com.gooagoo.igms.member.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.business.core.member.membercard.AuditMemberCardCoreService;
import com.gooagoo.api.business.core.member.memberfeature.MemberFeatureCoreService;
import com.gooagoo.api.business.query.member.query.ShopMemberQueryService;
import com.gooagoo.api.generator.query.member.CardUpInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.ConvertApplyGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberApplyGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.member.MemberBaseInfoAdapter;
import com.gooagoo.entity.business.member.ShopMemberDetail;
import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.CardUpInfoExample;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberApplyExample.Criteria;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.exception.business.card.GiveCardFailException;
import com.gooagoo.exception.business.member.ShopMemberNotExistsException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.member.service.MemberService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.FCardUpInfo;
import com.gooagoo.view.gms.member.FConvertApply;
import com.gooagoo.view.gms.member.FMemberApply;
import com.gooagoo.view.gms.member.FMemberBaseInfo;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.gooagoo.view.gms.member.FMemberSpecial;
import com.gooagoo.view.gms.member.FSAIntegralMember;
import com.gooagoo.view.gms.member.FUser;
import com.google.gson.Gson;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService
{
    @Autowired
    private MemberApplyGeneratorQueryService memberApplyGeneratorQueryService;
    @Autowired
    private ConvertApplyGeneratorQueryService convertApplyGeneratorQueryService;
    @Autowired
    private MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;
    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;
    @Autowired
    private UserProfileGeneratorQueryService userProfileGeneratorQueryService;
    @Autowired
    private ShopMemberQueryService shopMemberQueryService;
    @Autowired
    private AuditMemberCardCoreService auditMemberCardCoreService;
    @Autowired
    private IntegralCoreService integralCoreService;
    @Autowired
    private CardUpInfoGeneratorQueryService cardUpInfoGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;
    @Autowired
    private MemberFeatureGeneratorQueryService memberFeatureGeneratorQueryService;
    @Autowired
    private MemberFeatureInfoGeneratorQueryService memberFeatureInfoGeneratorQueryService;
    @Autowired
    private MemberFeatureCoreService memberFeatureCoreService;

    /**
     * 会员卡审批列表信息
     */
    @Override
    public TransData<PageModel<FMemberApply>> pageMemberApply(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FMemberApply memberApply = ServletUtils.objectMethod(FMemberApply.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FMemberApply> pm = new PageModel<FMemberApply>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }

        MemberApplyExample example = new MemberApplyExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(memberApply.getName()))
        {
            criteria.andNameLike("%" + memberApply.getName() + "%");
        }
        if (org.springframework.util.StringUtils.hasText(memberApply.getStatus()))
        {
            criteria.andStatusEqualTo(memberApply.getStatus());
        }

        int count = this.memberApplyGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MemberApply> list = this.memberApplyGeneratorQueryService.selectByExample(example);
            for (MemberApply apply : list)
            {
                pm.getResult().add(this.convertFMemberApply(apply));
            }
        }
        return new TransData<PageModel<FMemberApply>>(true, null, pm);
    }

    /**
     * 审批会员卡申请
     * 
     * @throws Exception
     */
    @Override
    public TransData<Object> approvalAppCard(HttpServletRequest request) throws Exception
    {
        String applicationId = ServletRequestUtils.getStringParameter(request, "applicationId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean isOk = false;
        try
        {
            isOk = this.auditMemberCardCoreService.auditMemberCard(applicationId, status, note);
        }
        catch (CardAlreadyExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_ALREADY_HAVE_THIS_CARD;
        }
        catch (CardNotExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_NOT_EXIST_OR_DEL;
        }
        catch (GiveCardFailException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_GIVECARD_FAIL;
        }

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, failMessage, applicationId);
    }

    /**
     * 物理卡转换审批列表信息
     */
    @Override
    public TransData<PageModel<FConvertApply>> pageConvertApply(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FConvertApply convertApply = ServletUtils.objectMethod(FConvertApply.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FConvertApply> pm = new PageModel<FConvertApply>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }

        ConvertApplyExample example = new ConvertApplyExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(pc.getOrderBy());
        com.gooagoo.entity.generator.member.ConvertApplyExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(convertApply.getPhyNo()))
        {
            criteria.andPhyNoLike("%" + convertApply.getPhyNo() + "%");
        }
        if (org.springframework.util.StringUtils.hasText(convertApply.getStatus()))
        {
            criteria.andStatusEqualTo(convertApply.getStatus());
        }

        int count = this.convertApplyGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<ConvertApply> list = this.convertApplyGeneratorQueryService.selectByExample(example);
            for (ConvertApply convert : list)
            {
                pm.getResult().add(this.convertFConvertApply(convert));
            }
        }
        return new TransData<PageModel<FConvertApply>>(true, null, pm);
    }

    /**
     * 审批物理卡转换申请
     * 
     * @throws Exception
     */
    @Override
    public TransData<Object> approvalPsyConvert(HttpServletRequest request) throws Exception
    {
        String applicationId = ServletRequestUtils.getStringParameter(request, "applicationId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean isOk = false;
        try
        {
            isOk = this.auditMemberCardCoreService.auditConvertPhysicalCard(applicationId, status, note);
        }
        catch (ShopMemberNotExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_SHOP_DONOT_HAVE_THIS_MEMBER;
        }
        catch (CardAlreadyExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_ISSWITCH;
        }
        catch (CardNotExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_NOT_EXIST_OR_DEL;
        }
        catch (GiveCardFailException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_GIVECARD_FAIL;
        }
        catch (OperateFailException e)
        {
            failMessage = MessageConst.GMS_OPERATE_FAIL;
            GooagooLog.error("物理卡转换审批时错误!", e);
        }

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, failMessage, applicationId);
    }

    /**
     * 会员卡升级（通过积分）审批列表信息
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<PageModel<FCardUpInfo>> pageIntegralUpgrade(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FCardUpInfo fCardUpInfo = ServletUtils.objectMethod(FCardUpInfo.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FCardUpInfo> pm = new PageModel<FCardUpInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }

        CardUpInfoExample example = new CardUpInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(pc.getOrderBy());
        com.gooagoo.entity.generator.member.CardUpInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (!StringUtils.isBlank(fCardUpInfo.getName()))
        {
            criteria.andNameLike("%" + fCardUpInfo.getName() + "%");
        }

        Integer count = this.cardUpInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CardUpInfo> list = this.cardUpInfoGeneratorQueryService.selectByExample(example);
            for (CardUpInfo cardUpInfo : list)
            {
                pm.getResult().add(this.convertToFCardUpInfo(cardUpInfo));
            }
        }

        return new TransData<PageModel<FCardUpInfo>>(true, null, pm);
    }

    /**
     * 审批会员卡升级（通过积分）
     */
    @Override
    public TransData<Object> approvalUpgrade(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean isOk = false;
        try
        {
            isOk = this.auditMemberCardCoreService.auditMemberCardUpgrade(userId, shopId, cardId);
        }
        catch (CardAlreadyExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_ALREADY_HAVE_THIS_CARD;
        }
        catch (GiveCardFailException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_GIVECARD_FAIL;
        }

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, failMessage);
    }

    /**
     * 查询商家会员信息列表
     */
    @Override
    public TransData<PageModel<FMemberBaseInfo>> pageMemberBaseInfo(HttpServletRequest request) throws Exception
    {
        PageModel<FMemberBaseInfo> findMemberBaseInfoByPage = this.findMemberBaseInfoByPage(request);
        return new TransData<PageModel<FMemberBaseInfo>>(true, null, findMemberBaseInfoByPage);
    }

    /**
     * 根据电话号码、电子邮件查询用户信息
     * 
     * @param request
     * @return
     * @throws UserException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    @Override
    public TransData<FUser> getSpecialUser(HttpServletRequest request) throws UserException, IllegalArgumentException, IllegalAccessException
    {
        String mobile = ServletRequestUtils.getStringParameter(request, "mobile", null);
        String email = ServletRequestUtils.getStringParameter(request, "email", null);

        UserInfoExample example = new UserInfoExample();
        com.gooagoo.entity.generator.user.UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        if (org.springframework.util.StringUtils.hasText(mobile))
        {
            criteria.andMobileEqualTo(mobile);
        }
        if (org.springframework.util.StringUtils.hasText(email))
        {
            criteria.andEmailEqualTo(email);
        }
        List<UserInfo> list = this.userInfoGeneratorQueryService.selectByExample(example);
        UserInfo userInfo = new UserInfo();
        UserProfile userProfile = new UserProfile();
        FUser user = null;
        if (list != null && list.size() > 0)
        {
            userInfo = list.get(0);
            userProfile = this.userProfileGeneratorQueryService.selectByPrimaryKey(userInfo.getUserId());

            String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userInfo.getUserId()).andIsDelEqualTo("N");
            List<MemberOfCard> selectByExample = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
            MemberOfCard memberOfCard = null;
            if (!CollectionUtils.isEmpty(selectByExample))
            {
                memberOfCard = selectByExample.get(0);
            }
            MemberCard memberCard = null;
            if (memberOfCard != null)
            {
                String cardId = memberOfCard.getCardId();
                memberCard = this.memberCardGeneratorQueryService.selectByPrimaryKey(cardId);
            }

            user = this.convertFUser(userInfo, userProfile, memberOfCard, memberCard);
        }

        return new TransData<FUser>(true, null, user);
    }

    /**
     * 特批会员卡
     */
    @Override
    public TransData<Object> approveSpecial(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String newCardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        String oldCardId = ServletRequestUtils.getStringParameter(request, "gradeId", "");

        String failMessage = MessageConst.GMS_OPERATE_FAIL;

        boolean isOk = false;
        try
        {
            isOk = this.auditMemberCardCoreService.specialApprovalMemberCard(shopId, userId, newCardId, oldCardId);
        }
        catch (CardNotExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_USER_DONOT_HAVE_THIS_CARD;
        }
        catch (CardAlreadyExistsException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_ALREADY_HAVE_THIS_CARD;
        }
        catch (GiveCardFailException e)
        {
            failMessage = MessageConst.GMS_MEMBER_CARD_GIVECARD_FAIL;
        }

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, failMessage);
    }

    /**
     * 积分特批信息列表
     */
    @Override
    public TransData<PageModel<FMemberBaseInfo>> pageSAIntegralMember(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        PageModel<FMemberBaseInfo> pm = this.findMemberBaseInfoByPage(request);
        List<FMemberBaseInfo> result = pm.getResult();
        for (FMemberBaseInfo fMemberBaseInfo : result)
        {
            ShopMemberDetail detail = this.shopMemberQueryService.findShopMemberDetailByPhyCardNo(shopId, fMemberBaseInfo.getPhyNo());
            IntegralInfo integralInfo = detail.getIntegralInfo();
            if (integralInfo != null)
            {
                fMemberBaseInfo.setIntegralId(integralInfo.getIntegralId());
                fMemberBaseInfo.setUseableIntegralNumber(integralInfo.getUseableIntegralNumber());
                fMemberBaseInfo.setHistoryTotalIntegral(integralInfo.getHistoryTotalIntegral());
            }
        }

        return new TransData<PageModel<FMemberBaseInfo>>(true, null, pm);
    }

    /**
     * 特批积分
     */
    @Override
    public TransData<Object> iApproveSpecial(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String integralNumber = ServletRequestUtils.getStringParameter(request, "integralNumber", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean isOk = this.integralCoreService.integralSpecialApproval(shopId, userId, integralNumber, note);

        return GMSUtil.getBooleanResult(isOk, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Integer> memberCount(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        Integer count = this.memberOfCardGeneratorQueryService.countByExample(memberOfCardExample);
        return GMSUtil.toTransData(true, null, count);
    }

    @Override
    public TransData<Object> addSpecial(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MemberFeature feature = ServletUtils.objectMethod(MemberFeature.class, request);
        feature.setShopId(shopId);
        feature.setId(UUID.getUUID());
        feature.setEnumValue(new Gson().toJson(request.getParameterValues("enumValue")));
        boolean flag = false;
        // 判断特征编号是否存在
        MemberFeatureExample memberFeatureExample = new MemberFeatureExample();
        memberFeatureExample.createCriteria().andIsDelEqualTo("N").andTypeCodeEqualTo(feature.getTypeCode()).andShopIdEqualTo(shopId);
        List<MemberFeature> selectByExample = this.memberFeatureGeneratorQueryService.selectByExample(memberFeatureExample);
        if (selectByExample != null && selectByExample.size() > 0)
        {
            return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_MEMBER_FEATURE_CODE_ALREADY_EXIST, feature.getId());
        }
        flag = this.memberFeatureCoreService.addMemberFeature(feature);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, feature.getId());
    }

    @Override
    public TransData<Object> delSpecial(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = this.memberFeatureCoreService.deleteMemberFeature(id);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateSpecial(HttpServletRequest request) throws Exception
    {
        MemberFeature feature = ServletUtils.objectMethod(MemberFeature.class, request);
        feature.setEnumValue(new Gson().toJson(request.getParameterValues("enumValue")));
        boolean flag = this.memberFeatureCoreService.updateMemberFeature(feature);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, feature.getId());
    }

    @Override
    public TransData<List<FMemberFeature>> getSpecials(HttpServletRequest request) throws Exception
    {
        List<FMemberFeature> featureList = new ArrayList<FMemberFeature>();
        FMemberFeature feature = null;
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MemberFeatureExample memberFeatureExample = new MemberFeatureExample();
        memberFeatureExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        List<MemberFeature> selectByExample = this.memberFeatureGeneratorQueryService.selectByExample(memberFeatureExample);
        for (MemberFeature memberFeature : selectByExample)
        {
            feature = new FMemberFeature();
            BeanUtils.copyProperties(memberFeature, feature);
            featureList.add(feature);
        }
        return GMSUtil.toTransData(true, null, featureList);
    }

    @Override
    public TransData<List<FMemberSpecial>> getSpecialValues(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");

        MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
        memberFeatureInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andUserIdEqualTo(userId);
        List<MemberFeatureInfo> featureInfoList = this.memberFeatureInfoGeneratorQueryService.selectByExample(memberFeatureInfoExample);
        List<FMemberSpecial> specials = new ArrayList<FMemberSpecial>(0);
        FMemberSpecial memberSpecial = null;
        for (MemberFeatureInfo memberFeatureInfo : featureInfoList)
        {
            memberSpecial = new FMemberSpecial();
            BeanUtils.copyProperties(memberFeatureInfo, memberSpecial);
            specials.add(memberSpecial);
        }
        return GMSUtil.toTransData(true, null, specials, userId);
    }

    @Override
    public TransData<Object> updateSpecialValue(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        MemberFeatureInfo memberFeatureInfo = ServletUtils.objectMethod(MemberFeatureInfo.class, request);

        String[] code = request.getParameterValues("featureCode");
        String[] value = request.getParameterValues("featureValue");
        String phyNo = memberFeatureInfo.getPhyNo();
        String userId = memberFeatureInfo.getUserId();
        String scardNo = memberFeatureInfo.getScardNo();

        boolean flag = this.memberFeatureCoreService.updateMemberFeatureInfos(shopId, userId, phyNo, scardNo, Arrays.asList(code), Arrays.asList(value));
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, userId);
    }

    /**
     * 查询会员当前拥有的会员卡
     * 
     * @param shopId
     * @param userId
     * @return
     */
    private MemberOfCard getMemberCardId(String shopId, String userId)
    {
        MemberOfCard memberOfCard = null;

        MemberOfCardExample example = new MemberOfCardExample();

        com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        criteria.andUserIdEqualTo(userId);

        List<MemberOfCard> list = this.memberOfCardGeneratorQueryService.selectByExample(example);
        if (list != null && list.size() > 0)
        {
            memberOfCard = list.get(0);
        }
        return memberOfCard;
    }

    /**
     * 查询商家基础卡
     * 
     * @param shopId
     * @return
     */
    private MemberCard getShopBaseCard(String shopId)
    {
        MemberCard card = new MemberCard();
        MemberCardExample example = new MemberCardExample();

        com.gooagoo.entity.generator.member.MemberCardExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        criteria.andCardLvlEqualTo("1");

        List<MemberCard> list = this.memberCardGeneratorQueryService.selectByExample(example);
        if (list != null && list.size() > 0)
        {
            card = list.get(0);
        }
        return card;
    }

    private FMemberApply convertFMemberApply(MemberApply apply) throws IllegalArgumentException, IllegalAccessException
    {
        FMemberApply fMemberApply = new FMemberApply();
        if (apply != null)
        {
            EntityTools.copyValue(apply, fMemberApply);
            MemberOfCard ofCard = this.getMemberCardId(apply.getShopId(), apply.getUserId());
            if (ofCard != null)
            {
                MemberCard card = this.memberCardGeneratorQueryService.selectByPrimaryKey(ofCard.getCardId());
                if (card != null)
                {
                    fMemberApply.setCardId(card.getCardId());
                    fMemberApply.setCardName(card.getCardName());
                }
            }
            MemberCard memberCard = this.getShopBaseCard(apply.getShopId());
            if (memberCard != null)
            {
                fMemberApply.setApplyCardId(memberCard.getCardId());
                fMemberApply.setApplyCardName(memberCard.getCardName());
            }
        }
        return fMemberApply;
    }

    private FConvertApply convertFConvertApply(ConvertApply convert) throws IllegalArgumentException, IllegalAccessException
    {
        FConvertApply fConvertApply = new FConvertApply();

        if (convert != null)
        {
            EntityTools.copyValue(convert, fConvertApply);
            String source = SysdictionaryCache.get("info_source", convert.getSource());
            fConvertApply.setSource(StringUtils.isBlank(source) ? "其他" : source);
            fConvertApply.setRealName(this.getUserName(convert.getUserId()));
            MemberOfCard ofCard = this.getMemberCardId(convert.getShopId(), convert.getUserId());
            if (ofCard != null)
            {
                MemberCard card = this.memberCardGeneratorQueryService.selectByPrimaryKey(ofCard.getCardId());
                if (card != null)
                {
                    fConvertApply.setCardId(ofCard.getCardId());
                    fConvertApply.setCardName(card.getCardName());
                }
            }
            //            MemberCard memberCard = this.getShopBaseCard(convert.getShopId());
            MemberCard convertCard = this.getMemberCardByPhyNo(convert.getShopId(), convert.getPhyNo());
            if (convertCard != null)
            {
                fConvertApply.setConvertCardId(convertCard.getCardId());
                fConvertApply.setConvertCardName(convertCard.getCardName());
            }
        }

        return fConvertApply;
    }

    /**
     * 通过物理卡号查询会员卡信息
     * @param shopId
     * @param phyNo
     * @return
     */
    private MemberCard getMemberCardByPhyNo(String shopId, String phyNo)
    {
        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andPhyNoEqualTo(phyNo);
        List<MemberBaseInfo> memberBaseInfos = this.memberBaseInfoGeneratorQueryService.selectByExample(memberBaseInfoExample);
        if (memberBaseInfos == null || memberBaseInfos.size() == 0)
        {
            return null;
        }
        String phyName = memberBaseInfos.get(0).getPhyName();

        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andCardNameEqualTo(phyName);
        List<MemberCard> list = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
        if (list == null || list.size() == 0)
        {
            return null;
        }
        return list.get(0);
    }

    private FCardUpInfo convertToFCardUpInfo(CardUpInfo cardUpInfo) throws IllegalArgumentException, IllegalAccessException
    {
        FCardUpInfo fCardUpInfo = new FCardUpInfo();

        if (cardUpInfo != null)
        {
            EntityTools.copyValue(cardUpInfo, fCardUpInfo);
            MemberOfCard ofCard = this.getMemberCardId(cardUpInfo.getShopId(), cardUpInfo.getUserId());
            MemberCard card = this.memberCardGeneratorQueryService.selectByPrimaryKey(ofCard.getCardId());
            MemberCard card1 = this.memberCardGeneratorQueryService.selectByPrimaryKey(cardUpInfo.getUpCardId());
            fCardUpInfo.setCardId(ofCard.getCardId());
            fCardUpInfo.setCardName(card.getCardName());
            fCardUpInfo.setUpCardName(card1.getCardName());
            IntegralInfoExample integralInfoExample = new IntegralInfoExample();
            com.gooagoo.entity.generator.member.IntegralInfoExample.Criteria criteria2 = integralInfoExample.createCriteria();
            criteria2.andIsDelEqualTo(GMSConstant.NO);
            criteria2.andShopIdEqualTo(cardUpInfo.getShopId());
            criteria2.andUserIdEqualTo(cardUpInfo.getUserId());
            List<IntegralInfo> integralInfos = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
            if (integralInfos != null && integralInfos.size() > 0)
            {
                fCardUpInfo.setHistoryTotalIntegral(integralInfos.get(0).getHistoryTotalIntegral());
            }
        }

        return fCardUpInfo;
    }

    private FSAIntegralMember convertToFSAIntegralMember(ShopMemberDetail detail)
    {
        FSAIntegralMember fsaIntegralMember = new FSAIntegralMember();

        if (detail != null)
        {
            MemberBaseInfo baseInfo = detail.getMemberBaseInfo();
            MemberOfCard ofCard = detail.getMemberOfCard();
            MemberCard card = detail.getMemberCard();
            IntegralInfo integralInfo = detail.getIntegralInfo();

            if (baseInfo != null)
            {
                fsaIntegralMember.setShopId(baseInfo.getShopId());
                fsaIntegralMember.setName(baseInfo.getName());
                fsaIntegralMember.setSex(baseInfo.getSex());
                fsaIntegralMember.setBirthday(baseInfo.getBirthday());
                fsaIntegralMember.setIdType(baseInfo.getIdType());
                fsaIntegralMember.setIdNo(baseInfo.getIdNo());
                fsaIntegralMember.setMobile(baseInfo.getMobile());
                fsaIntegralMember.setEmail(baseInfo.getEmail());
                fsaIntegralMember.setPhyNo(baseInfo.getPhyNo());
                fsaIntegralMember.setCardName(baseInfo.getPhyName());
                fsaIntegralMember.setTelephone(baseInfo.getTelephone());
            }
            if (ofCard != null)
            {
                fsaIntegralMember.setUserId(ofCard.getUserId());
            }
            if (card != null)
            {
                fsaIntegralMember.setCardId(card.getCardId());
                fsaIntegralMember.setCardType(card.getCardType());
            }
            if (integralInfo != null)
            {
                fsaIntegralMember.setIntegralId(integralInfo.getIntegralId());
                fsaIntegralMember.setUseableIntegralNumber(integralInfo.getUseableIntegralNumber());
                fsaIntegralMember.setHistoryTotalIntegral(integralInfo.getHistoryTotalIntegral());
            }
        }
        return fsaIntegralMember;
    }

    private FUser convertFUser(UserInfo userInfo, UserProfile userProfile, MemberOfCard memberOfCard, MemberCard memberCard) throws IllegalArgumentException, IllegalAccessException
    {
        FUser user = new FUser();
        if (userInfo != null)
        {
            EntityTools.copyValue(userInfo, user);
            user.setPhone(userInfo.getMobile());
        }
        if (userProfile != null)
        {
            EntityTools.copyValue(userProfile, user);
            user.setTelephone(userProfile.getTelephone());
        }

        if (memberOfCard != null)
        {
            user.setPhyCardNo(memberOfCard.getPhyCardNo());
        }

        if (memberCard != null)
        {
            user.setGradeName(memberCard.getCardName());
            user.setGradeId(memberCard.getCardId());
        }
        return user;
    }

    private FMemberBaseInfo convertToFMemberBaseInfo(ShopMemberDetail detail)
    {
        FMemberBaseInfo memberBaseInfo = new FMemberBaseInfo();
        MemberBaseInfo baseInfo = detail.getMemberBaseInfo();
        MemberOfCard ofCard = detail.getMemberOfCard();
        MemberCard card = detail.getMemberCard();
        if (card != null)
        {
            memberBaseInfo.setCreateTime(card.getCTimeStamp());
            memberBaseInfo.setGradeId(card.getCardId());// 会员卡等级
        }
        if (baseInfo != null)
        {
            memberBaseInfo.setId(baseInfo.getId());
            memberBaseInfo.setShopId(baseInfo.getShopId());
            memberBaseInfo.setPhyNo(baseInfo.getPhyNo());
            memberBaseInfo.setPhyName(baseInfo.getPhyName());
            memberBaseInfo.setName(baseInfo.getName());
            memberBaseInfo.setSex(baseInfo.getSex());
            memberBaseInfo.setBirthday(baseInfo.getBirthday());
            memberBaseInfo.setIdType(baseInfo.getIdType());
            memberBaseInfo.setIdNo(baseInfo.getIdNo());
            memberBaseInfo.setMobile(baseInfo.getMobile());
            memberBaseInfo.setTelephone(baseInfo.getTelephone());
            memberBaseInfo.setEmail(baseInfo.getEmail());
            memberBaseInfo.setPostcode(baseInfo.getPostcode());
            memberBaseInfo.setAddress(baseInfo.getAddress());
        }

        if (ofCard != null)
        {
            memberBaseInfo.setUserId(ofCard.getUserId());
            memberBaseInfo.setScardNo(ofCard.getScardno());
            UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(ofCard.getUserId());
            if (userInfo != null)
            {
                memberBaseInfo.setAccount(org.apache.commons.lang.StringUtils.isNotBlank(userInfo.getEmail()) ? userInfo.getEmail() : userInfo.getMobile());
            }
        }
        return memberBaseInfo;
    }

    private String getUserName(String userId)
    {
        UserProfile userProfile = this.userProfileGeneratorQueryService.selectByPrimaryKey(userId);
        String realName = "";
        if (userProfile != null)
        {
            realName = userProfile.getRealName();
        }
        return realName;
    }

    private PageModel<FMemberBaseInfo> findMemberBaseInfoByPage(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FMemberBaseInfo fMemberBaseInfo = ServletUtils.objectMethod(FMemberBaseInfo.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FMemberBaseInfo> pm = new PageModel<FMemberBaseInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        pm.setCount(0);
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }

        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setName(fMemberBaseInfo.getName());
        memberBaseInfo.setShopId(shopId);
        Integer count = this.shopMemberQueryService.countMemberBaseInfo(memberBaseInfo);

        if (count != null && count > 0)
        {
            pm.setCount(count);
            FMemberBaseInfo fbaseInfo = null;
            List<MemberBaseInfoAdapter> findMemberBaseInfo = this.shopMemberQueryService.findMemberBaseInfo(memberBaseInfo, pm.getPageIndex(), pm.getPageSize());
            for (MemberBaseInfoAdapter baseInfo : findMemberBaseInfo)
            {
                fbaseInfo = new FMemberBaseInfo();
                fbaseInfo.setName(baseInfo.getName());
                fbaseInfo.setAddress(baseInfo.getAddress());
                fbaseInfo.setBirthday(baseInfo.getBirthday());
                fbaseInfo.setEmail(baseInfo.getEmail());
                fbaseInfo.setId(baseInfo.getId());
                fbaseInfo.setIdNo(baseInfo.getIdNo());
                fbaseInfo.setIdType(baseInfo.getIdType());
                fbaseInfo.setMobile(baseInfo.getMobile());
                fbaseInfo.setPhyName(baseInfo.getPhyName());
                fbaseInfo.setPhyNo(baseInfo.getPhyNo());
                fbaseInfo.setPostcode(baseInfo.getPostcode());
                fbaseInfo.setSex(baseInfo.getSex());
                fbaseInfo.setUserId(baseInfo.getUserId());
                fbaseInfo.setGradeId(baseInfo.getCardId());
                fbaseInfo.setShopId(baseInfo.getShopId());
                fbaseInfo.setTelephone(baseInfo.getTelephone());
                pm.getResult().add(fbaseInfo);
            }
        }

        return pm;
    }

}

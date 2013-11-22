package com.gooagoo.query.business.member.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.member.query.ShopMemberQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.dao.business.member.info.MemberInfoAdapterMapper;
import com.gooagoo.entity.business.member.MemberBaseInfoAdapter;
import com.gooagoo.entity.business.member.ShopMemberDetail;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
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

@Service
public class ShopMemberQueryServiceImpl implements ShopMemberQueryService
{
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;
    @Autowired
    private MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;
    @Autowired
    private MemberFeatureGeneratorQueryService memberFeatureGeneratorQueryService;
    @Autowired
    private MemberFeatureInfoGeneratorQueryService memberFeatureInfoGeneratorQueryService;
    @Autowired
    private MemberInfoAdapterMapper memberInfoAdapterMapper;

    @Override
    public void findMemberInfo(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findMemberList(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findTraces(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public ShopMemberDetail findShopMemberDetailByPhyCardNo(String shopId, String phyCardNo) throws Exception
    {
        ShopMemberDetail shopMemberDetail = new ShopMemberDetail();

        MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
        memberBaseInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andPhyNoEqualTo(phyCardNo);
        List<MemberBaseInfo> memberBaseInfos = this.memberBaseInfoGeneratorQueryService.selectByExample(memberBaseInfoExample);
        if (memberBaseInfos == null || memberBaseInfos.size() == 0)
        {
            GooagooLog.warn("通过物理卡查询会员详细信息（包括会员基本信息、积分信息、会员卡基本信息、会员卡和用户关联信息）,会员基本信息为空，shopId=" + shopId + ",phyCardNo=" + phyCardNo);
            return null;
        }
        MemberBaseInfo memberBaseInfo = memberBaseInfos.get(0);
        shopMemberDetail.setMemberBaseInfo(memberBaseInfo);

        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andPhyCardNoEqualTo(phyCardNo);
        List<MemberOfCard> memberOfCards = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
        MemberOfCard memberOfCard = null;
        if (memberOfCards != null && memberOfCards.size() > 0)
        {
            memberOfCard = memberOfCards.get(0);
            shopMemberDetail.setMemberOfCard(memberOfCard);
        }

        if (memberOfCard != null)
        {
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andCardIdEqualTo(memberOfCard.getCardId());
            List<MemberCard> memberCards = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
            if (memberCards != null && memberCards.size() > 0)
            {
                MemberCard memberCard = memberCards.get(0);
                shopMemberDetail.setMemberCard(memberCard);
            }

            IntegralInfoExample integralInfoExample = new IntegralInfoExample();
            integralInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andUserIdEqualTo(memberOfCard.getUserId());
            List<IntegralInfo> integralInfos = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
            if (integralInfos != null && integralInfos.size() > 0)
            {
                IntegralInfo integralInfo = integralInfos.get(0);
                shopMemberDetail.setIntegralInfo(integralInfo);
            }
        }

        return shopMemberDetail;
    }

    @Override
    public List<MemberFeatureInfo> findMemberFeatures(String shopId, String userId) throws Exception
    {
        List<MemberFeatureInfo> memberFeatureInfoList = new ArrayList<MemberFeatureInfo>();
        //数据库中已有的会员特征
        MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
        memberFeatureInfoExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andUserIdEqualTo(userId);
        List<MemberFeatureInfo> memberFeatureInfoDbs = this.memberFeatureInfoGeneratorQueryService.selectByExample(memberFeatureInfoExample);
        if (memberFeatureInfoDbs == null)
        {
            return memberFeatureInfoDbs = new ArrayList<MemberFeatureInfo>();
        }
        //商家定义的会员特征项
        MemberFeatureExample memberFeatureExample = new MemberFeatureExample();
        memberFeatureExample.setOrderByClause(" type_code ");
        memberFeatureExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        List<MemberFeature> memberFeatures = this.memberFeatureGeneratorQueryService.selectByExample(memberFeatureExample);
        if (memberFeatures == null)
        {
            return memberFeatureInfoList;
        }
        //根据特征项组合会员特征列表
        for (Iterator<MemberFeature> iterator = memberFeatures.iterator(); iterator.hasNext();)
        {
            MemberFeature memberFeature = iterator.next();

            MemberFeatureInfo memberFeatureInfo = null;
            for (Iterator<MemberFeatureInfo> iterator2 = memberFeatureInfoDbs.iterator(); iterator2.hasNext();)
            {
                MemberFeatureInfo temp = iterator2.next();
                if (temp.getFeatureCode().equals(memberFeature.getTypeCode()))
                {
                    memberFeatureInfo = temp;
                    break;
                }
            }
            if (memberFeatureInfo == null)
            {
                memberFeatureInfo = new MemberFeatureInfo();
                memberFeatureInfo.setShopId(shopId);
                memberFeatureInfo.setUserId(userId);
                memberFeatureInfo.setFeatureCode(memberFeature.getTypeCode());
                memberFeatureInfo.setFeatureValue("");
            }
            memberFeatureInfoList.add(memberFeatureInfo);
        }
        return memberFeatureInfoList;
    }

    @Override
    public Integer countMemberBaseInfo(MemberBaseInfo memberBaseInfo) throws Exception
    {
        String shopId = StringUtils.hasText(memberBaseInfo.getShopId()) ? memberBaseInfo.getShopId() : null;
        String phyNo = StringUtils.hasText(memberBaseInfo.getPhyNo()) ? memberBaseInfo.getPhyNo() : null;
        String name = StringUtils.hasText(memberBaseInfo.getName()) ? memberBaseInfo.getName() : null;
        return this.memberInfoAdapterMapper.countMemberBaseInfo(shopId, phyNo, name);
    }

    @Override
    public List<MemberBaseInfoAdapter> findMemberBaseInfo(MemberBaseInfo memberBaseInfo, Integer pageIndex, Integer pageSize) throws Exception
    {
        String shopId = StringUtils.hasText(memberBaseInfo.getShopId()) ? memberBaseInfo.getShopId() : null;
        String phyNo = StringUtils.hasText(memberBaseInfo.getPhyNo()) ? memberBaseInfo.getPhyNo() : null;
        String name = StringUtils.hasText(memberBaseInfo.getName()) ? memberBaseInfo.getName() : null;
        return this.memberInfoAdapterMapper.findMemberBaseInfo(shopId, phyNo, name, pageIndex, pageSize);
    }

}

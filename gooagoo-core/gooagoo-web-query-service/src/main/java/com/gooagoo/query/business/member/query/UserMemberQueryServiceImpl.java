package com.gooagoo.query.business.member.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.member.MemberBaseInfoBusiness;
import com.gooagoo.entity.business.member.MemberFeatureBusiness;
import com.gooagoo.entity.business.member.MemberInfoBusiness;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria;

@Service
public class UserMemberQueryServiceImpl implements UserMemberQueryService
{

    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    @Autowired
    private MemberBaseInfoGeneratorQueryService memberBaseInfoGeneratorQueryService;

    @Autowired
    private MemberFeatureGeneratorQueryService memberFeatureGeneratorQueryService;

    @Autowired
    private MemberFeatureInfoGeneratorQueryService memberFeatureInfoGeneratorQueryService;

    @Autowired
    private ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsQueryService;

    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;

    @Autowired
    private UserCacheQueryService userCacheQueryService;

    @Autowired
    private MemberCacheQueryService memberCacheQueryService;

    @Override
    public MemberInfoBusiness findMemberInfo(String userId, String shopId, String scardno) throws Exception
    {
        MemberInfoBusiness memberInfoBusiness = null;
        //会员卡与用户关联
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        Criteria criteria = memberOfCardExample.createCriteria();
        if (StringUtils.hasText(scardno))
        {
            criteria.andScardnoEqualTo(scardno);
        }
        else
        {
            criteria.andUserIdEqualTo(userId).andShopIdEqualTo(shopId);
        }
        criteria.andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(memberOfCardList))
        {
            MemberOfCard memberOfCard = memberOfCardList.get(0);
            if (StringUtils.hasText(memberOfCard.getPhyCardNo()))
            {
                //会员基本信息
                MemberBaseInfoExample memberBaseInfoExample = new MemberBaseInfoExample();
                memberBaseInfoExample.createCriteria().andShopIdEqualTo(memberOfCard.getShopId()).andPhyNoEqualTo(memberOfCard.getPhyCardNo()).andIsDelEqualTo("N");
                List<MemberBaseInfo> memberBaseInfoList = this.memberBaseInfoGeneratorQueryService.selectByExample(memberBaseInfoExample);
                if (CollectionUtils.isNotEmpty(memberBaseInfoList))
                {
                    memberInfoBusiness = new MemberInfoBusiness();
                    MemberBaseInfo memberBaseInfo = memberBaseInfoList.get(0);
                    memberInfoBusiness.setCardName(memberBaseInfo.getPhyName());
                    memberInfoBusiness.setName(memberBaseInfo.getName());
                    memberInfoBusiness.setUserId(memberOfCard.getUserId());
                    //                    if ("M".equals(memberBaseInfo.getSex()))
                    //                    {
                    //                        memberInfoBusiness.setSex("男");
                    //                    }
                    //                    else if ("F".equals(memberBaseInfo.getSex()))
                    //                    {
                    //                        memberInfoBusiness.setSex("女");
                    //                    }
                    memberInfoBusiness.setBirthday(memberBaseInfo.getBirthday() != null ? TimeUtils.convertDateToString(memberBaseInfo.getBirthday(), TimeUtils.FORMAT2) : null);
                    memberInfoBusiness.setIdtype(memberBaseInfo.getIdType());
                    memberInfoBusiness.setIdno(memberBaseInfo.getIdNo());
                    memberInfoBusiness.setMobile(memberBaseInfo.getMobile());
                    memberInfoBusiness.setTelephone(memberBaseInfo.getTelephone());
                    memberInfoBusiness.setEmail(memberBaseInfo.getEmail());
                    memberInfoBusiness.setPostcode(memberBaseInfo.getPostcode());
                    memberInfoBusiness.setAddress(memberBaseInfo.getAddress());
                    memberInfoBusiness.setSex(memberBaseInfo.getSex());
                    IntegralInfoExample integralInfoExample = new IntegralInfoExample();
                    integralInfoExample.createCriteria().andShopIdEqualTo(memberOfCard.getShopId()).andUserIdEqualTo(memberOfCard.getUserId());
                    List<IntegralInfo> integralInfoList = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
                    if (CollectionUtils.isNotEmpty(integralInfoList))
                    {
                        IntegralInfo integralInfo = integralInfoList.get(0);
                        memberInfoBusiness.setUseableIntegralNumber(integralInfo.getUseableIntegralNumber() == null ? "0" : integralInfo.getUseableIntegralNumber().toString());
                    }
                    //会员特征字典
                    MemberFeatureExample memberFeatureExample = new MemberFeatureExample();
                    memberFeatureExample.createCriteria().andShopIdEqualTo(memberOfCard.getShopId()).andIsDelEqualTo("N");
                    List<MemberFeature> memberFeatureList = this.memberFeatureGeneratorQueryService.selectByExample(memberFeatureExample);
                    List<MemberFeatureBusiness> MemberFeatureBusinessList = null;
                    if (CollectionUtils.isNotEmpty(memberFeatureList))
                    {
                        MemberFeatureBusinessList = new ArrayList<MemberFeatureBusiness>();
                        for (MemberFeature memberFeature : memberFeatureList)
                        {
                            MemberFeatureBusiness memberFeatureBusiness = new MemberFeatureBusiness();
                            memberFeatureBusiness.setTypecode(memberFeature.getTypeCode());
                            memberFeatureBusiness.setTypename(memberFeature.getTypeName());
                            memberFeatureBusiness.setEnumvalue(JsonUtils.json2List(memberFeature.getEnumValue()));
                            //会员特征
                            MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
                            memberFeatureInfoExample.createCriteria().andUserIdEqualTo(memberOfCard.getUserId()).andShopIdEqualTo(memberOfCard.getShopId()).andPhyNoEqualTo(memberOfCard.getPhyCardNo()).andFeatureCodeEqualTo(memberFeature.getTypeCode()).andIsDelEqualTo("N");
                            List<MemberFeatureInfo> memberFeatureInfoList = this.memberFeatureInfoGeneratorQueryService.selectByExample(memberFeatureInfoExample);
                            if (CollectionUtils.isNotEmpty(memberFeatureInfoList))
                            {
                                MemberFeatureInfo memberFeatureInfo = memberFeatureInfoList.get(0);
                                memberFeatureBusiness.setFeaturevalue(memberFeatureInfo.getFeatureValue());
                            }
                            MemberFeatureBusinessList.add(memberFeatureBusiness);
                        }
                    }
                    memberInfoBusiness.setMemberspecialinfo(MemberFeatureBusinessList);
                    Map<String, String> userInfo = this.userCacheQueryService.findUserInfo(memberOfCard.getUserId());
                    if (userInfo != null)
                    {
                        memberInfoBusiness.setHeadPic(userInfo.get("headPic"));
                    }
                }
            }
        }
        return memberInfoBusiness;
    }

    @Override
    public void findMemberFeatureList(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findMemberFeature(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public List<MemberBaseInfoBusiness> findMemberListInPosition(String shopId, String positionid, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<MemberBaseInfoBusiness> memberBaseInfoBusinessList = null;
        List<String> peopleList = this.shopEntityPeopleStatisticsQueryService.findEntityAreaPeople(positionid, "M");//取到區域全部會員(有会员卡)
        if (CollectionUtils.isNotEmpty(peopleList))
        {
            List<String> userIdList = new ArrayList<String>();
            for (String people : peopleList)
            {
                //过滤mac信息
                if (people.startsWith("0_"))
                {
                    userIdList.add(people.substring(2, people.length()));
                }
            }
            memberBaseInfoBusinessList = new ArrayList<MemberBaseInfoBusiness>();
            for (String userId : userIdList)
            {
                //通过userId和shopId从缓存获取商家信息

                Map<String, String> memberInfoMap = this.memberCacheQueryService.findMembeInfo(userId, shopId);
                if (memberInfoMap != null && memberInfoMap.size() > 0)
                {
                    MemberBaseInfoBusiness memberBaseInfoBusiness = new MemberBaseInfoBusiness();
                    memberBaseInfoBusiness.setUserId(userId);
                    memberBaseInfoBusiness.setScardno(memberInfoMap.get("scardno"));
                    memberBaseInfoBusiness.setId(memberInfoMap.get("id"));
                    memberBaseInfoBusiness.setShopId(shopId);
                    memberBaseInfoBusiness.setPhyNo(memberInfoMap.get("phyCardNo"));
                    memberBaseInfoBusiness.setPhyName(memberInfoMap.get("phyName"));
                    memberBaseInfoBusiness.setName(memberInfoMap.get("name"));
                    memberBaseInfoBusiness.setSex(memberInfoMap.get("sex"));
                    if (StringUtils.hasText(memberInfoMap.get("birthday")))
                    {
                        memberBaseInfoBusiness.setBirthday(TimeUtils.convertStringToDate(memberInfoMap.get("birthday")));
                    }
                    memberBaseInfoBusiness.setIdType(memberInfoMap.get("idType"));
                    memberBaseInfoBusiness.setIdNo(memberInfoMap.get("idNo"));
                    memberBaseInfoBusiness.setMobile(memberInfoMap.get("mobile"));
                    memberBaseInfoBusiness.setTelephone(memberInfoMap.get("telephone"));
                    memberBaseInfoBusiness.setEmail(memberInfoMap.get("email"));
                    memberBaseInfoBusiness.setPostcode(memberInfoMap.get("postcode"));
                    memberBaseInfoBusiness.setAddress(memberInfoMap.get("address"));
                    memberBaseInfoBusiness.setIsDel(memberInfoMap.get("isDel"));
                    if (StringUtils.hasText(memberInfoMap.get("createTime")))
                    {
                        memberBaseInfoBusiness.setCreateTime(TimeUtils.convertStringToDate(memberInfoMap.get("createTime")));
                    }
                    if (StringUtils.hasText(memberInfoMap.get("cTimeStamp")))
                    {
                        memberBaseInfoBusiness.setCTimeStamp(TimeUtils.convertStringToDate(memberInfoMap.get("cTimeStamp")));
                    }
                    memberBaseInfoBusinessList.add(memberBaseInfoBusiness);
                }
            }
        }
        return memberBaseInfoBusinessList;
    }

}

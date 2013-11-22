package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.member.membercard.AuditMemberCardCoreService;
import com.gooagoo.api.business.core.member.usermember.UserMemberCoreService;
import com.gooagoo.api.business.core.user.notice.UserNoticeCoreService;
import com.gooagoo.api.business.query.marketing.notice.NoticeQueryService;
import com.gooagoo.api.business.query.member.card.UserCardQueryService;
import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.marketing.NoticeInfoBusiness;
import com.gooagoo.entity.business.marketing.NoticeLinkInfoBussiness;
import com.gooagoo.entity.business.member.MemberFeatureBusiness;
import com.gooagoo.entity.business.member.MemberInfoBusiness;
import com.gooagoo.entity.business.member.MemberOfCardBusiness;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CardTopLinkUserMobileService;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.moba04.transform.Isdeleted;
import com.gooagoo.mobile.entity.moba04.transform.Membernotice;
import com.gooagoo.mobile.entity.moba04.transform.MembernoticeRoot;
import com.gooagoo.mobile.entity.moba12.transform.AgreeCardRoot;
import com.gooagoo.mobile.entity.moba12.transform.Usermembercard;
import com.gooagoo.mobile.entity.moba13.transform.GetMemberBaseInfoRoot;
import com.gooagoo.mobile.entity.moba13.transform.Memberbaseinfo;
import com.gooagoo.mobile.entity.moba13.transform.Memberspecialinfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class CardTopLinkUserMobileServiceImpl implements CardTopLinkUserMobileService
{
    @Autowired
    private NoticeQueryService noticeQueryService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private IntegralQueryService integralQueryService;
    @Autowired
    private UserMemberCoreService userMemberCoreService;
    @Autowired
    private AuditMemberCardCoreService auditMemberCardCoreService;
    @Autowired
    private UserMemberQueryService userMemberQueryService;
    @Autowired
    private UserNoticeCoreService userNoticeCoreService;
    @Autowired
    private UserCardQueryService userCardQueryService;

    @Override
    public MembernoticeRoot getUserReceiveNotice(String userId, String sessionId, String cTimeStamp, String shopId, String pageId, String pageType, String pageSize) throws Exception
    {
        GooagooLog.info("getUserReceiveNotice-->入参:【userId=" + userId + ",sessionId=" + sessionId + " ,cTimeStamp=" + cTimeStamp + ",shopId=" + shopId + " ,pageId=" + pageId + ",pageType=" + pageType + ",pageSize=" + pageSize + "】");

        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.封装查询用户得到"通知"api的入参信息

        //3.查询用户得到"通知" 
        NoticeLinkInfoBussiness noticeLinkInfoBussiness = this.noticeQueryService.findUserReceiveNotice(userId, shopId, cTimeStamp, pageId, pageType, Integer.valueOf(pageSize));

        GooagooLog.debug("查询到用户接收到的通知列表信息为:【" + new Gson().toJson(noticeLinkInfoBussiness) + "】");

        //4.组装查询到用户得到"通知"信息
        List<Membernotice> membernoticeList = null;
        Isdeleted isdeleted = null;

        if (noticeLinkInfoBussiness != null)
        {
            //1)封装未删除的数据
            if (CollectionUtils.isNotEmpty(noticeLinkInfoBussiness.getNoticeInfoBusinessList()))
            {
                membernoticeList = new ArrayList<Membernotice>();
                for (NoticeInfoBusiness temp : noticeLinkInfoBussiness.getNoticeInfoBusinessList())
                {
                    Membernotice membernotice = new Membernotice();
                    membernotice.setIsread(temp.getIsread());//是否已读标志 Y-已经读取 N-未读取
                    membernotice.setPageid(temp.getPageId());
                    membernotice.setNoticeuserid(temp.getMarketingUserLinkId());
                    membernotice.setNoticeinfoid(temp.getNoticeInfoId());
                    membernotice.setShopid(temp.getShopId());
                    membernotice.setLogo(temp.getLogo2());
                    membernotice.setTitle(temp.getNoticeTitle());
                    membernotice.setImg(temp.getImg());
                    membernotice.setNoticetextmobile(temp.getNoticeTextMobile());
                    membernotice.setCtimestamp(temp.getcTimeStamp());
                    membernotice.setIsdel(temp.getIsdel());
                    membernoticeList.add(membernotice);
                }
            }
            //2)封装已经删除的数据
            if (noticeLinkInfoBussiness.getIsdeletedInfo() != null)
            {
                isdeleted = new Isdeleted();
                isdeleted.setFlag(noticeLinkInfoBussiness.getIsdeletedInfo().getFlag());
                isdeleted.setNoticeidstr(noticeLinkInfoBussiness.getIsdeletedInfo().getIdstr());
                isdeleted.setCtimestamp(noticeLinkInfoBussiness.getIsdeletedInfo().getCtimestamp());
            }

        }

        MembernoticeRoot root = new MembernoticeRoot();
        root.setMembernotice(membernoticeList);
        root.setIsdeleted(isdeleted);
        return root;
    }

    @Override
    public String getUserIntegral(String userId, String sessionId, String shopId) throws Exception
    {
        GooagooLog.info("getUserIntegral-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.查询用户积分
        return this.integralQueryService.findIntegral(userId, shopId);
    }

    @Override
    public boolean userApplyCard(HttpServletRequest request, String userId, String sessionId, String shopId, String realName) throws Exception
    {
        GooagooLog.info("userApplyCard-->入参:request=" + request + ",userId=" + userId + ",sessionId=" + sessionId);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.会员卡信息
        Parameter parameter = InterfaceUtils.collectParameter(request);
        String realname = parameter.getString("realname");
        String mobile = parameter.getString("mobile");
        String idno = parameter.getString("idno");
        String sex = parameter.getString("sex");
        String birthday = parameter.getString("birthday");
        String address = parameter.getString("address");
        String postcode = parameter.getString("postcode");

        MemberApply memberApply = new MemberApply();
        memberApply.setUserId(userId);
        memberApply.setShopId(shopId);
        memberApply.setName(realname);
        if (StringUtils.hasText(birthday))
        {
            memberApply.setBirthday(TimeUtils.convertStringToDate(birthday));
        }
        memberApply.setSex(sex);
        if (StringUtils.hasText(idno))
        {
            memberApply.setIdType("00");//证件类型，身份证
            memberApply.setIdNo(idno);
        }
        memberApply.setMobile(mobile);
        memberApply.setPostcode(postcode);
        memberApply.setAddress(address);
        memberApply.setSource("M");
        //2. 用户申请电子会员卡
        boolean applyMember = this.userMemberCoreService.applyMember(memberApply);
        return applyMember;
    }

    @Override
    public boolean physicToElecCard(String userId, String sessionId, String shopId, String mobile, String idNo, String phyNo) throws Exception
    {
        GooagooLog.info("physicToElecCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId + ",mobile=" + mobile + ",idNo=" + idNo + ",phyNo" + phyNo);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.用户申请实体卡电子化参数
        ConvertApply convertApply = new ConvertApply();
        convertApply.setUserId(userId);
        convertApply.setShopId(shopId);
        convertApply.setMobile(mobile);
        convertApply.setSource("M");
        convertApply.setIdNo(idNo);
        convertApply.setPhyNo(phyNo);
        convertApply.setIsDel("N");
        //3.用户申请实体卡电子化
        boolean bool = this.userMemberCoreService.applyConvertPhysicalCard(convertApply);
        if (!bool)
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_FAIL);
        }
        return bool;
    }

    @Override
    public AgreeCardRoot agreeGiveCard(String userId, String sessionId, String shopId, String cardId, String cardType, String isAgree) throws Exception
    {
        GooagooLog.info("agreeGiveCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId + ",cardId=" + cardId + ",cardType=" + cardType + ",isAgree=" + isAgree);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.用户是否同意发卡

        //        if ("N".equals(isAgree))
        //        { //无需发卡
        //            return null;
        //        }

        //需要发卡
        boolean bool = this.auditMemberCardCoreService.specialApprovalMemberCard(shopId, userId, cardId, null);

        //查询发卡成功的会员卡信息
        Usermembercard usermembercard = null;
        if (bool == true && "Y".equals(isAgree))
        {
            List<MemberOfCardBusiness> memberOfCardBusinessList = this.userCardQueryService.findUserMemberCardList(userId, shopId, null, null);

            if (CollectionUtils.isNotEmpty(memberOfCardBusinessList))
            {
                MemberOfCardBusiness memberOfCardBusiness = memberOfCardBusinessList.get(0);
                usermembercard = new Usermembercard();
                usermembercard.setScardno(memberOfCardBusiness.getMemberOfCard().getScardno());
                usermembercard.setScardnotdcurl(memberOfCardBusiness.getScardnoQrUrl());//会员卡音频编号二维码地址
                usermembercard.setScardnourl(memberOfCardBusiness.getScardnoUrl());//会员卡音频编号音频地址
                usermembercard.setPhycardno(memberOfCardBusiness.getMemberOfCard().getPhyCardNo());
                usermembercard.setCardid(memberOfCardBusiness.getMemberOfCard().getCardId());
                usermembercard.setUserid(memberOfCardBusiness.getMemberOfCard().getUserId());
                usermembercard.setShopid(memberOfCardBusiness.getMemberOfCard().getShopId());
                usermembercard.setExpiredate(TimeUtils.convertDateToString(memberOfCardBusiness.getMemberOfCard().getExpireDate(), TimeUtils.FORMAT1));
                usermembercard.setIsdel(memberOfCardBusiness.getMemberOfCard().getIsDel());
                usermembercard.setCreatetime(TimeUtils.convertDateToString(memberOfCardBusiness.getMemberOfCard().getCreateTime(), TimeUtils.FORMAT1));
                usermembercard.setCtimestamp(TimeUtils.convertDateToString(memberOfCardBusiness.getMemberOfCard().getCTimeStamp(), TimeUtils.FORMAT1));
                //分享者相关信息，暂时没有
                usermembercard.setNeedshare(null);
                usermembercard.setSharetimes(null);
                usermembercard.setShareuserid(null);
                usermembercard.setSharedemail(null);
                usermembercard.setSharednickname(null);
                usermembercard.setShareexpiredate(null);
                usermembercard.setUseableintegralnumber(memberOfCardBusiness.getUseableIntegralNumber());
            }
        }

        if (!bool && usermembercard == null)
        {//发卡失败
            throw new MessageException(MessageConst.MOBILE_CARDTOP_GIVE_CARD_FAIL);
        }

        AgreeCardRoot root = new AgreeCardRoot();
        root.setUsermembercard(usermembercard);

        return root;
    }

    @Override
    public GetMemberBaseInfoRoot getMemberBaseInfo(String userId, String sessionId, String shopId) throws Exception
    {
        GooagooLog.info("getMemberBaseInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询会员信息
        MemberInfoBusiness memberInfoBusiness = this.userMemberQueryService.findMemberInfo(userId, shopId, null);

        GooagooLog.debug("查询到的会员信息为：" + new Gson().toJson(memberInfoBusiness));

        //3.组装返回会员信息对象

        //会员基本信息
        Memberbaseinfo memberbaseinfo = new Memberbaseinfo();
        memberbaseinfo.setName(memberInfoBusiness.getName() != null ? memberInfoBusiness.getName() : "");
        memberbaseinfo.setSex(memberInfoBusiness.getSex());//query已做过个非空校验
        memberbaseinfo.setBirthday(memberInfoBusiness.getBirthday());
        memberbaseinfo.setIdtype(memberInfoBusiness.getIdtype());//证件类型
        memberbaseinfo.setIdno(memberInfoBusiness.getIdno());//证件号码
        memberbaseinfo.setMobile(memberInfoBusiness.getMobile());//手机号码
        memberbaseinfo.setTelephone(memberInfoBusiness.getTelephone());//联系电话
        memberbaseinfo.setEmail(memberInfoBusiness.getEmail());
        memberbaseinfo.setPostcode(memberInfoBusiness.getPostcode());//邮政编码
        memberbaseinfo.setAddress(memberInfoBusiness.getAddress());//通讯地址

        //会员特征信息
        if (CollectionUtils.isNotEmpty(memberInfoBusiness.getMemberspecialinfo()))
        {
            List<Memberspecialinfo> memberspecialinfoList = new ArrayList<Memberspecialinfo>();
            for (MemberFeatureBusiness temp : memberInfoBusiness.getMemberspecialinfo())
            {
                Memberspecialinfo memberspecialInfo = new Memberspecialinfo();
                memberspecialInfo.setEnumvalue(new Gson().toJson(temp.getEnumvalue()));
                memberspecialInfo.setFeaturevalue(temp.getFeaturevalue());
                memberspecialInfo.setTypecode(temp.getTypecode());
                memberspecialInfo.setTypename(temp.getTypename());
                memberspecialinfoList.add(memberspecialInfo);
            }
            memberbaseinfo.setMemberspecialinfo(memberspecialinfoList);
        }
        else
        {
            memberbaseinfo.setMemberspecialinfo(null);
        }

        GetMemberBaseInfoRoot root = new GetMemberBaseInfoRoot();

        root.setMemberbaseinfo(memberbaseinfo);
        return root;
    }

    @Override
    public boolean updateMemberBaseInfo(HttpServletRequest request, String userId, String sessionId, String shopId, String idType, String idNo, String mobile) throws Exception
    {
        GooagooLog.info("updateMemberBaseInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId);
        //1.校验是否登陆
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //组织会员信息 
        Parameter parameter = InterfaceUtils.collectParameter(request);
        String name = parameter.getString("name");
        String sex = parameter.getString("sex");
        String birthday = parameter.getString("birthday");
        String telephone = parameter.getString("telephone");
        String email = parameter.getString("email");
        String postcode = parameter.getString("postcode");
        String address = parameter.getString("address");
        String memberspecialinfo = parameter.getString("memberspecialinfo");
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setAddress(address);
        memberBaseInfo.setBirthday(TimeUtils.convertStringToDate(birthday));
        memberBaseInfo.setEmail(email);
        memberBaseInfo.setIdNo(idNo);
        memberBaseInfo.setIdType(idType);
        memberBaseInfo.setMobile(mobile);
        memberBaseInfo.setName(name);
        memberBaseInfo.setPostcode(postcode);
        memberBaseInfo.setSex(sex);
        memberBaseInfo.setShopId(shopId);
        memberBaseInfo.setTelephone(telephone);
        //会员特征信息
        List<MemberFeatureInfo> memberFeatureInfoList = null;
        if (StringUtils.hasText(memberspecialinfo))
        {
            memberFeatureInfoList = new ArrayList<MemberFeatureInfo>();
            List<Map<String, String>> memberFeatureInfoLists = new Gson().fromJson(memberspecialinfo, new TypeToken<List<Map<String, String>>>()
            {
            }.getType());
            for (Map<String, String> map : memberFeatureInfoLists)
            {
                MemberFeatureInfo temp = new MemberFeatureInfo();
                temp.setFeatureCode(map.get("featurecode"));
                //                temp.set
                temp.setFeatureValue(map.get("featurevalue"));
                memberFeatureInfoList.add(temp);
            }
        }

        //3.修改会员信息 
        boolean bool = this.userMemberCoreService.updateMemberInfo(userId, memberBaseInfo, memberFeatureInfoList);
        return bool;
    }

    @Override
    public void DelUserMemberCard(String userId, String sessionId, String scardno) throws Exception
    {
        GooagooLog.info("DelUseMemberCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",scardno=" + scardno);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.封装要批量删除的会员名卡卡号信息
        List<String> scardNoList = Arrays.asList(scardno.split(","));
        //3.删除用户会员卡
        this.userMemberCoreService.deleteMemberForMobile(scardNoList, userId);
    }

    @Override
    public void DelUserReceiveNotice(String userId, String sessionId, String noticeinfoid) throws Exception
    {
        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户接收到的通知
        if (!this.userNoticeCoreService.deleteNotice(noticeinfoid))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_RECEIVE_NOTICE_FAIL);
        }
    }
}

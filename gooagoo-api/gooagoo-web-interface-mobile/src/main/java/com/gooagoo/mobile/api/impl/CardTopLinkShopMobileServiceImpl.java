package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.api.business.query.member.card.UserCardQueryService;
import com.gooagoo.api.business.query.shop.query.UserShopQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.recommend.RecommendShop;
import com.gooagoo.entity.business.member.MemberOfCardBusiness;
import com.gooagoo.entity.business.shop.ShopInfoBusiness;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.mobile.api.CardTopLinkShopMobileService;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.entity.moba01.transform.Isdeleted;
import com.gooagoo.mobile.entity.moba01.transform.Noreadnoticeinfo;
import com.gooagoo.mobile.entity.moba01.transform.UserMemberCardRoot;
import com.gooagoo.mobile.entity.moba01.transform.Usermembercard;
import com.gooagoo.mobile.entity.moba05.transform.RecommendShopRoot;
import com.gooagoo.mobile.entity.moba05.transform.Recommendshop;
import com.gooagoo.mobile.entity.moba08.transform.ShopListRoot;
import com.gooagoo.mobile.entity.moba08.transform.Shoplist;
import com.gooagoo.mobile.entity.moba09.transform.ShopCardInfoRoot;
import com.gooagoo.mobile.entity.moba09.transform.Shopcardinfo;
import com.google.gson.Gson;

@Service
public class CardTopLinkShopMobileServiceImpl implements CardTopLinkShopMobileService
{
    @Autowired
    private RecommendQueryService recommendQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private UserShopQueryService userShopQueryService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private UserCardQueryService userCardQueryService;
    @Autowired
    private MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    @Override
    public RecommendShopRoot getRecommendShopInfo(String userId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getRecommendShopInfo-->入参:userId=" + userId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //查询推荐商家信息
        List<RecommendShop> recommendShopList = this.recommendQueryService.recommendShop(userId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("推荐商家信息为:" + new Gson().toJson(recommendShopList));
        List<Recommendshop> recommendshopList = null;
        if (CollectionUtils.isNotEmpty(recommendShopList))
        {
            recommendshopList = new ArrayList<Recommendshop>();
            for (RecommendShop temp : recommendShopList)
            {
                Recommendshop recommendshop = new Recommendshop();
                recommendshop.setLogo(temp.getShopLogo());
                recommendshop.setShopid(temp.getShopId());
                recommendshop.setShopname(temp.getShopName());
                recommendshop.setMembernums(temp.getMemberNum() != null ? temp.getMemberNum().toString() : "0");
                recommendshop.setAttentionnums(temp.getAttentionNum() != null ? temp.getAttentionNum().toString() : "0");
                recommendshop.setColortype(temp.getColor());
                recommendshopList.add(recommendshop);
            }
        }

        //组装返回结果
        RecommendShopRoot root = new RecommendShopRoot();
        root.setRecommendshop(recommendshopList);
        return root;
    }

    @Override
    public ShopListRoot getShopList(String shopId, String pageType, String pageSize, String shopType, String keyWord) throws Exception

    {
        GooagooLog.info("getShopList-->入参:shopId=" + shopId + ",pageType=" + pageType + ",pageSize=" + pageSize + " ,shopType=" + shopType + " ,keyWord" + keyWord);
        //分页查询商家列表
        List<ShopInfoBusiness> shopInfoBusinessList = null;
        shopInfoBusinessList = this.userShopQueryService.findUserShopList(keyWord, shopType, shopId, pageType, Integer.valueOf(pageSize));

        GooagooLog.debug("查询到的商家列表信息为: " + new Gson().toJson(shopInfoBusinessList));
        List<Shoplist> shoplist = null;
        if (CollectionUtils.isNotEmpty(shopInfoBusinessList))
        {
            shoplist = new ArrayList<Shoplist>();
            for (ShopInfoBusiness temp : shopInfoBusinessList)
            {
                Shoplist shop = new Shoplist();
                shop.setShopid(temp.getShopid());
                shop.setShopname(temp.getShopname());
                shop.setSquarelogo(temp.getSquarelogo());
                shop.setOblonglogo(temp.getOblonglogo());
                shop.setShopfirstchar(temp.getShopfirstchar());
                shop.setShoptypeleaf(temp.getShoptypeleaf());
                shop.setIsdel(temp.getIsdel());
                shop.setCtimestamp(temp.getCtimestamp());
                shoplist.add(shop);
            }
        }

        //组装返回参数
        ShopListRoot root = new ShopListRoot();
        root.setShoplist(shoplist);
        return root;
    }

    @Override
    public ShopCardInfoRoot getShopMemberCard(String shopId) throws Exception
    {
        GooagooLog.info("getShopMemberCard-->入参:shopId=" + shopId);
        //查询商家会员卡信息列表 
        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberCard> memberCardlList = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
        GooagooLog.debug("查询到商家会员卡信息为 :" + new Gson().toJson(memberCardlList));
        List<Shopcardinfo> shopcardinfoList = null;
        if (CollectionUtils.isNotEmpty(memberCardlList))
        {
            shopcardinfoList = new ArrayList<Shopcardinfo>();
            for (MemberCard temp : memberCardlList)
            {
                Shopcardinfo shopcardinfo = new Shopcardinfo();
                shopcardinfo.setCardname(temp.getCardName());
                shopcardinfo.setCardheadurl(UrlUtils.getAttachUrlByImg("dh_top", temp.getCardUrl()));//卡头url
                shopcardinfo.setCardbodyurl(UrlUtils.getAttachUrlByImg("dh_bottom", temp.getCardUrl()));//卡身url
                shopcardinfo.setNeedjifen(temp.getNeedJifen().toString());
                shopcardinfo.setDescription(temp.getDescription());
                shopcardinfo.setUselimited(temp.getUseLimited().toString());
                shopcardinfo.setCreatetime(TimeUtils.convertDateToString(temp.getCreateTime(), TimeUtils.FORMAT1));
                shopcardinfoList.add(shopcardinfo);
            }
        }

        //封装返回参数
        ShopCardInfoRoot root = new ShopCardInfoRoot();
        root.setShopcardinfo(shopcardinfoList);
        return root;
    }

    @Override
    public UserMemberCardRoot getUserMemberCard(String userId, String sessionId, String cTimeStamp, String pageSize) throws Exception
    {
        GooagooLog.info("getUserMemberCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",cTimeStamp=" + cTimeStamp + ",pageSize=" + pageSize);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询用户会员卡列表
        List<MemberOfCardBusiness> memberOfCardBusinessList = null;
        memberOfCardBusinessList = this.userCardQueryService.findUserMemberCardList(userId, null, cTimeStamp, Integer.valueOf(pageSize));
        GooagooLog.debug("查询到未删除的用户会员卡列表信息为: " + new Gson().toJson(memberOfCardBusinessList));

        //3.封装查询到的用户会员卡列表信息
        List<Usermembercard> usermembercardList = null;
        List<Noreadnoticeinfo> noreadnoticeinfoList = null;
        if (CollectionUtils.isNotEmpty(memberOfCardBusinessList))
        {
            usermembercardList = new ArrayList<Usermembercard>();
            for (MemberOfCardBusiness temp : memberOfCardBusinessList)
            {
                Usermembercard usermembercard = new Usermembercard();
                usermembercard.setScardno(temp.getMemberOfCard().getScardno());
                usermembercard.setScardnotdcurl(temp.getScardnoQrUrl());//会员卡音频编号二维码地址
                usermembercard.setScardnourl(temp.getScardnoUrl());//会员卡音频编号音频地址
                usermembercard.setPhycardno(temp.getMemberOfCard().getPhyCardNo());
                usermembercard.setCardid(temp.getMemberOfCard().getCardId());
                usermembercard.setUserid(temp.getMemberOfCard().getUserId());
                usermembercard.setShopid(temp.getMemberOfCard().getShopId());
                usermembercard.setExpiredate(TimeUtils.convertDateToString(temp.getMemberOfCard().getExpireDate(), TimeUtils.FORMAT1));
                usermembercard.setCreatetime(TimeUtils.convertDateToString(temp.getMemberOfCard().getCreateTime(), TimeUtils.FORMAT1));
                usermembercard.setCtimestamp(TimeUtils.convertDateToString(temp.getMemberOfCard().getCTimeStamp(), TimeUtils.FORMAT1));
                usermembercard.setNeedshare(null);
                usermembercard.setSharetimes(null);
                usermembercard.setShareuserid(null);
                usermembercard.setSharedemail(null);
                usermembercard.setSharednickname(null);
                usermembercard.setShareexpiredate(null);
                usermembercard.setUseableintegralnumber(temp.getUseableIntegralNumber() != null ? temp.getUseableIntegralNumber() : "0");
                usermembercardList.add(usermembercard);
            }
        }
        //4.查询未读通知条数
        MarketingUserLinkExample marketingUserLinkExample = new MarketingUserLinkExample();
        marketingUserLinkExample.setOrderByClause("shop_id ASC");
        //markeing_type:2-通知，account_type:0-userId(用户编号)
        marketingUserLinkExample.createCriteria().andMarketingTypeEqualTo("2").andAccountTypeEqualTo("0").andAccountEqualTo(userId).andIsPushedEqualTo("Y").andIsReadEqualTo("N").andIsDelEqualTo("N");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample);

        if (CollectionUtils.isNotEmpty(marketingUserLinkList))
        {
            noreadnoticeinfoList = new ArrayList<Noreadnoticeinfo>();
            String shopId = marketingUserLinkList.get(0).getShopId();//用来区分统计相同商家的通知信息
            Integer noticeNums = 0;//未读通知条数
            Integer position = 0;//当前读取到的位置
            for (MarketingUserLink marketingUserLink : marketingUserLinkList)
            {
                String tempShopId = marketingUserLink.getShopId();
                if (shopId.equals(tempShopId) && marketingUserLinkList.size() != 1 && position != marketingUserLinkList.size() - 1)
                {//有多条通知是,当前通知是同一个商家的,走该处
                    noticeNums++;
                }
                else if ((shopId.equals(tempShopId) && position == marketingUserLinkList.size() - 1))
                {//有多条通知是,当前通知是同一个商家的,且最后一条信息也是该商家的
                    noticeNums++;
                    Noreadnoticeinfo noreadnoticeinfo = new Noreadnoticeinfo();
                    noreadnoticeinfo.setShopid(shopId);
                    noreadnoticeinfo.setNoreadnoticenums(noticeNums.toString());
                    noreadnoticeinfoList.add(noreadnoticeinfo);
                }
                else
                {//不是同一个商家时，把上一个商家的通知信息加入到List节点中

                    Noreadnoticeinfo noreadnoticeinfo = new Noreadnoticeinfo();
                    noreadnoticeinfo.setShopid(shopId);
                    noreadnoticeinfo.setNoreadnoticenums(noticeNums.toString());
                    noreadnoticeinfoList.add(noreadnoticeinfo);
                    shopId = marketingUserLink.getShopId();
                    if (position == marketingUserLinkList.size() - 1)
                    {//当前商家只有一条未读通知
                        Noreadnoticeinfo nextNnoreadnoticeinfo = new Noreadnoticeinfo();
                        nextNnoreadnoticeinfo.setShopid(shopId);
                        nextNnoreadnoticeinfo.setNoreadnoticenums("1");
                        noreadnoticeinfoList.add(nextNnoreadnoticeinfo);
                    }
                    else
                    {
                        noticeNums = 1;
                    }

                }
                position++;
            }
        }
        //5.查询删除会员卡信息

        MemberOfCardExample delMemberOfCardExample = new MemberOfCardExample();
        delMemberOfCardExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("Y");
        List<MemberOfCard> delMemberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(delMemberOfCardExample);
        String delScardNoStr = null;
        if (CollectionUtils.isNotEmpty(delMemberOfCardList))
        {
            for (MemberOfCard memberOfCard : delMemberOfCardList)
            {
                if (delScardNoStr == null)
                {
                    delScardNoStr = memberOfCard.getScardno();
                }
                else
                {
                    delScardNoStr = delScardNoStr + "," + memberOfCard.getScardno();
                }
            }
        }
        Isdeleted isdeleted = new Isdeleted();
        isdeleted.setScardnostr(delScardNoStr);
        isdeleted.setCount(this.userCardQueryService.countUserMemberCardList(userId, null).toString());

        //6.封装返回数据
        UserMemberCardRoot root = new UserMemberCardRoot();
        root.setUsermembercard(usermembercardList);
        root.setNoreadnoticeinfo(noreadnoticeinfoList);
        root.setIsdeleted(isdeleted);
        return root;
    }
}

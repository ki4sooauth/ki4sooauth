package com.gooagoo.query.business.marketing.cryout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.cryout.CryoutPlaceQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.statistics.MemberStatisticQueryService;
import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingQualityGoodsGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.SecondMenu;
import com.gooagoo.entity.business.marketing.ShopDetailForPlace;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;

@Service
public class CryoutPlaceQueryServiceImpl implements CryoutPlaceQueryService
{

    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;

    @Autowired
    private MemberStatisticQueryService memberStatisticQueryService;

    @Autowired
    private CryoutInfoGeneratorQueryService cryoutInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private MarketingQualityGoodsGeneratorQueryService marketingQualityGoodsGeneratorQueryService;

    @Override
    public List<FirstMenu> findCryoutPlaceMenu() throws Exception
    {
        List<FirstMenu> firstmenuList = new ArrayList<FirstMenu>();
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        shopTypeExample.createCriteria().andParentShopTypeIdEqualTo("-1").andIsDelEqualTo("N");
        shopTypeExample.setOrderByClause("shop_type_id ASC");
        List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);
        if (CollectionUtils.isNotEmpty(shopTypeList))
        {
            //全部，包括所有商家类型
            FirstMenu mainFirstmenu = new FirstMenu();//一级菜单
            mainFirstmenu.setFirstmenucode("");
            mainFirstmenu.setFirstmenuname("全部");
            firstmenuList.add(mainFirstmenu);
            for (ShopType shopType : shopTypeList)
            {
                FirstMenu firstmenu = new FirstMenu();//一级菜单
                firstmenu.setFirstmenucode(shopType.getShopTypeId().toString());
                firstmenu.setFirstmenuname(shopType.getShopTypeName());
                //二级菜单(固定四项 全部0、精品1、优惠2、活动3)
                for (int i = 0; i < 4; i++)
                {
                    SecondMenu secondmenu = new SecondMenu();
                    if (i == 0)
                    {
                        secondmenu.setSecondmenuname("全部");
                        secondmenu.setSecondmenucode(shopType.getShopTypeId().toString());
                    }
                    else if (i == 1)
                    {
                        secondmenu.setSecondmenuname("精品");
                        secondmenu.setSecondmenucode("G" + shopType.getShopTypeId().toString());
                    }
                    else if (i == 2)
                    {
                        secondmenu.setSecondmenuname("优惠");
                        secondmenu.setSecondmenucode("C" + shopType.getShopTypeId().toString());
                    }
                    else if (i == 3)
                    {
                        secondmenu.setSecondmenuname("活动");
                        secondmenu.setSecondmenucode("A" + shopType.getShopTypeId().toString());
                    }
                    firstmenu.getSecondmenu().add(secondmenu);
                }
                firstmenuList.add(firstmenu);
            }
        }
        return firstmenuList;
    }

    @Override
    public List<ShopDetailForPlace> findCryoutPlaceList(String keyword, String typeCode, Integer pageIndex, Integer pageSize) throws Exception
    {
        String type = null;
        String code = null;
        if (StringUtils.hasText(typeCode))
        {
            if (typeCode.trim().length() > 1)
            {
                type = typeCode.substring(0, 1);
                code = typeCode.substring(1, typeCode.length());
            }
            else if ("GAC".contains(typeCode))
            {//当输入分类编码为基类编码不带商家类型，如G、A、C
                type = typeCode.substring(0, 1);
            }
            else
            {//查询某商家类型下的全部商家信息
                code = typeCode.substring(0, 1);
            }

        }
        List<ShopDetailForPlace> shopDetailForPlaceList = null;
        //获取吆喝广场下为删除已发布的所有商家列表(去重)
        List<String> shopIdList = new ArrayList<String>();
        CryoutInfoExample cryoutInfoExample = new CryoutInfoExample();
        if (StringUtils.hasText(type))
        {//查询类型存在，如：商品、优惠券、活动
            cryoutInfoExample.createCriteria().andMarketingLinkTypeEqualTo(type).andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        }
        else
        {
            cryoutInfoExample.createCriteria().andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        }
        List<CryoutInfo> cryoutInfoList = this.cryoutInfoGeneratorQueryService.selectByExample(cryoutInfoExample);
        if (CollectionUtils.isNotEmpty(cryoutInfoList))
        {
            Set<String> shopIdSet = new HashSet<String>();
            for (CryoutInfo cryoutInfo : cryoutInfoList)
            {
                shopIdSet.add(cryoutInfo.getShopId());
            }
            shopIdList.addAll(shopIdSet);
        }
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        Criteria criteria = shopInfoExample.createCriteria();
        if (StringUtils.hasText(keyword))
        {
            criteria.andShopNameLike("%" + keyword + "%");
        }
        else if (StringUtils.hasText(code))
        {
            //查询商家类型及所下属类型
            List<String> shopTypeIdList = new ArrayList<String>();
            shopTypeIdList.add(code);
            this.shopProtectedQueryService.getShopTypeIdByRecursion(shopTypeIdList, code);
            //            criteria.andShopTypeRootEqualTo(code);
            criteria.andShopTypeLeafIn(shopTypeIdList);
        }
        if (CollectionUtils.isNotEmpty(shopIdList))
        {
            criteria.andShopIdIn(shopIdList);
        }
        criteria.andShopStatusEqualTo("U").andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            shopInfoExample.setPage(pageIndex, pageSize);
        }
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
        if (CollectionUtils.isNotEmpty(shopInfoList))
        {
            shopDetailForPlaceList = new ArrayList<ShopDetailForPlace>();
            for (ShopInfo shopInfo : shopInfoList)
            {
                ShopDetailForPlace shopDetailForPlace = new ShopDetailForPlace();
                shopDetailForPlace.setShopid(shopInfo.getShopId());//商家编号
                shopDetailForPlace.setShopName(shopInfo.getShopName());//商家名称
                shopDetailForPlace.setLogo2(shopInfo.getLogo2());//商家长方形图片(大)
                //关注数量
                shopDetailForPlace.setAttentionnum(this.memberStatisticQueryService.countAttention(shopInfo.getShopId(), "A").toString());
                //会员数量
                shopDetailForPlace.setMembernum(this.memberStatisticQueryService.countMember(shopInfo.getShopId()).toString());
                shopDetailForPlaceList.add(shopDetailForPlace);
            }
        }
        return shopDetailForPlaceList;
    }

    @Override
    public ShopDetailForPlace findCryoutPlaceDetail(String shopId) throws Exception
    {
        ShopDetailForPlace cryoutShopDetail = null;
        //查询商家基本信息
        Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(shopId);
        if (shopInfoMap != null && shopInfoMap.size() > 0)
        {
            cryoutShopDetail = new ShopDetailForPlace();
            cryoutShopDetail.setShopid(shopId);
            cryoutShopDetail.setShopName(shopInfoMap.get("shopName"));
            cryoutShopDetail.setLogo1(shopInfoMap.get("logo1"));
            cryoutShopDetail.setLogo2(shopInfoMap.get("logo2"));

            //查询商家会员相关信息
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N").andCardUrlIsNotNull();
            List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
            if (CollectionUtils.isNotEmpty(memberCardList))
            {

                cryoutShopDetail.setCardheaderurl(UrlUtils.getAttachUrlByImg("dh_top", memberCardList.get(0).getCardUrl()));
            }

            //查询商家精品数量信息
            MarketingQualityGoodsExample marketingQualityGoodsExample = new MarketingQualityGoodsExample();
            marketingQualityGoodsExample.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
            cryoutShopDetail.setNum(this.marketingQualityGoodsGeneratorQueryService.countByExample(marketingQualityGoodsExample).toString());
            //关注数量
            cryoutShopDetail.setAttentionnum(this.memberStatisticQueryService.countAttention(shopId, "A").toString());
            //会员数量
            cryoutShopDetail.setMembernum(this.memberStatisticQueryService.countMember(shopId).toString());

        }
        return cryoutShopDetail;
    }

}

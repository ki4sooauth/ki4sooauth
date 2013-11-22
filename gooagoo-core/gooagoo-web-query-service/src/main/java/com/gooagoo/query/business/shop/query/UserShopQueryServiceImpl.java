package com.gooagoo.query.business.shop.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.shop.query.UserShopQueryService;
import com.gooagoo.api.business.query.statistics.MemberStatisticQueryService;
import com.gooagoo.api.business.query.statistics.TableStatisticQueryService;
import com.gooagoo.api.generator.query.behave.UserLastTimeGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.shop.MyShopInfoBusiness;
import com.gooagoo.entity.business.shop.ShopInfoBusiness;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;

@Service
public class UserShopQueryServiceImpl implements UserShopQueryService
{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;

    @Autowired
    private UserLastTimeGeneratorQueryService userLastTimeGeneratorQueryService;

    @Autowired
    private MemberCacheQueryService memberCacheQueryService;

    @Autowired
    private MemberStatisticQueryService memberStatisticQueryService;

    @Autowired
    private TableStatisticQueryService tableStatisticQueryService;

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Override
    public List<ShopInfoBusiness> findUserShopList(String keyword, String shoptypeId, String pageId, String pageType, Integer pageSize) throws Exception
    {
        List<ShopInfoBusiness> shopInfoBusinessList = null;
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        Criteria criteria = shopInfoExample.createCriteria();
        if (StringUtils.hasText(keyword))
        {
            criteria.andShopNameLike("%" + keyword + "%");
        }
        if (StringUtils.hasText(pageId))
        {
            if ("P".equalsIgnoreCase(pageType))//上一页
            {
                criteria.andShopIdGreaterThan(pageId);
            }
            else if ("N".equalsIgnoreCase(pageType))//下一页
            {
                criteria.andShopIdLessThan(pageId);
            }
        }
        if (StringUtils.hasText(shoptypeId))
        {
            List<String> shopTypeIdList = new ArrayList<String>();
            shopTypeIdList.add(shoptypeId);
            //封装商家类型编号列表
            this.shopProtectedQueryService.getShopTypeIdByRecursion(shopTypeIdList, shoptypeId);
            criteria.andShopTypeLeafIn(shopTypeIdList);
        }
        if (pageSize != null)
        {
            shopInfoExample.setPage(1, pageSize);
        }
        shopInfoExample.setOrderByClause("shop_id DESC");
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
        if (CollectionUtils.isNotEmpty(shopInfoList))
        {
            shopInfoBusinessList = new ArrayList<ShopInfoBusiness>();
            for (ShopInfo shopInfo : shopInfoList)
            {
                ShopInfoBusiness shopInfoBusiness = new ShopInfoBusiness();
                shopInfoBusiness.setShopid(shopInfo.getShopId());
                shopInfoBusiness.setShopname(shopInfo.getShopName());
                shopInfoBusiness.setSquarelogo(shopInfo.getLogo1());
                shopInfoBusiness.setOblonglogo(shopInfo.getLogo2());
                if (shopInfo.getShopTypeLeaf() != null)
                {
                    ShopType shopTypeCache = this.shopCacheQueryService.findShopCategory(shopInfo.getShopTypeLeaf().toString());
                    if (shopTypeCache != null)
                    {
                        shopInfoBusiness.setShoptypeleaf(shopTypeCache.getShopTypeName());
                    }
                }
                shopInfoBusiness.setIsdel(shopInfo.getIsDel());
                shopInfoBusiness.setCtimestamp(TimeUtils.convertDateToString(shopInfo.getCTimeStamp(), TimeUtils.FORMAT1));

                shopInfoBusinessList.add(shopInfoBusiness);
            }
        }
        return shopInfoBusinessList;
    }

    @Override
    public List<MyShopInfoBusiness> findMyShopList(String userId, String shopTypeRoot, String shopName, String cardType2, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception
    {
        //1、校验入参
        if (!StringUtils.hasText(userId))
        {
            return null;
        }
        //2、获取满足条件的我的商家
        List<UserLastTime> userLastTimeList = this.getUserLastTimeList(userId, shopTypeRoot, shopName, cardType2, pageIndex, pageSize, orderByClause);
        if (CollectionUtils.isEmpty(userLastTimeList))
        {
            return null;
        }
        //3、组装返回数据
        List<MyShopInfoBusiness> myShopInfoBusinessList = new ArrayList<MyShopInfoBusiness>();
        Map<String, ShopInfo> shopInfoMap = new HashMap<String, ShopInfo>();
        Map<String, String> shopEntityIdMap = new HashMap<String, String>();
        for (UserLastTime userLastTime : userLastTimeList)
        {
            MyShopInfoBusiness myShopInfoBusiness = new MyShopInfoBusiness();
            //3.1、获取商家信息
            ShopInfo shopInfo = this.getShopInfo(shopInfoMap, userLastTime.getShopId());
            if (shopInfo == null)
            {
                continue;
            }
            shopInfoMap.put(shopInfo.getShopId(), shopInfo);
            myShopInfoBusiness.setShopId(shopInfo.getShopId());
            myShopInfoBusiness.setShopName(shopInfo.getShopName());
            myShopInfoBusiness.setShopTypeRoot(shopInfo.getShopTypeRoot());
            //3.2、获取商家人气/满座率
            String shopPopularity = this.getShopPopularity(shopInfo, shopEntityIdMap);
            myShopInfoBusiness.setShopPopularity(shopPopularity);
            //3.3、获取会员卡信息
            MemberCard memberCard = this.memberCardGeneratorQueryService.selectByPrimaryKey(userLastTime.getCardId());
            if (memberCard == null)
            {
                continue;
            }
            myShopInfoBusiness.setMyCardId(userLastTime.getScardno());
            myShopInfoBusiness.setMyCardImageUrl(memberCard.getCardUrl());
            myShopInfoBusiness.setMyCardName(memberCard.getCardName());
            myShopInfoBusiness.setMyCardType2(userLastTime.getCardType2());
            //3.4、获取用户积分
            myShopInfoBusiness.setMyUseableIntegralNumber(this.getUserIntegral(userId, shopInfo.getShopId()));

            myShopInfoBusinessList.add(myShopInfoBusiness);
        }

        return myShopInfoBusinessList;
    }

    /**
     * 获取用户足迹列表
     * @param userId
     * @param shopId
     * @param shopTypeRoot
     * @param shopName
     * @param cardType2
     * @param pageIndex
     * @param pageSize
     * @param orderByClause
     * @return
     */
    private List<UserLastTime> getUserLastTimeList(String userId, String shopTypeRoot, String shopName, String cardType2, Integer pageIndex, Integer pageSize, String orderByClause)
    {
        List<String> cardType2List = null;
        if (StringUtils.hasText(cardType2))
        {
            String[] cardType2s = cardType2.split(",");
            if (cardType2s.length == 2)
            {
                cardType2List = new ArrayList<String>();
                cardType2List.add(cardType2s[0]);
                cardType2List.add(cardType2s[1]);
            }
        }
        UserLastTimeExample queryCondition = new UserLastTimeExample();
        com.gooagoo.entity.generator.behave.UserLastTimeExample.Criteria criteria = queryCondition.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.hasText(shopTypeRoot))
        {
            criteria.andShopTypeRootEqualTo(shopTypeRoot);
        }
        if (StringUtils.hasText(shopName))
        {
            criteria.andShopNameLike("%" + shopName + "%");
        }
        if (CollectionUtils.isNotEmpty(cardType2List))
        {
            criteria.andCardType2In(cardType2List);
        }
        queryCondition.setPage(pageIndex, pageSize);
        queryCondition.setOrderByClause(orderByClause);
        return this.userLastTimeGeneratorQueryService.selectByExample(queryCondition);
    }

    /**
     * 获取商家信息
     * @param shopInfoMap
     * @param shopId
     * @return
     */
    private ShopInfo getShopInfo(Map<String, ShopInfo> shopInfoMap, String shopId)
    {
        ShopInfo shopInfo = shopInfoMap.get(shopId);
        if (shopInfo == null)
        {
            shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopId);
            if (shopInfo == null)
            {
                return null;
            }
            shopInfoMap.put(shopInfo.getShopId(), shopInfo);
        }

        return shopInfo;
    }

    /**
     * 获取商家人气/满座率
     * @param shopInfo
     * @param shopEntityIdMap
     * @return
     */
    private String getShopPopularity(ShopInfo shopInfo, Map<String, String> shopEntityIdMap)
    {
        try
        {
            String shopPopularity = null;
            if (shopInfo.getShopTypeRoot() == 1)
            {
                String shopEntityId = shopEntityIdMap.get(shopInfo.getShopId());
                if (shopEntityId == null)
                {
                    shopEntityId = this.shopProtectedQueryService.getShopEntity(shopInfo.getShopId(), null);
                    if (shopEntityId == null)
                    {
                        return null;
                    }
                    shopEntityIdMap.put(shopInfo.getShopId(), shopEntityId);
                }
                shopPopularity = this.tableStatisticQueryService.findTableAttendance(shopEntityId) + "%";//满座率
            }
            else
            {
                shopPopularity = this.memberStatisticQueryService.countAttention(shopInfo.getShopId(), "A") + this.memberStatisticQueryService.countMember(shopInfo.getShopId()) + "";
            }

            return shopPopularity;
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家人气/满座率：获取商家人气/满座率异常", e);
            return null;
        }
    }

    /**
     * 获取用户积分
     * @param userId
     * @param shopId
     * @return
     */
    private Integer getUserIntegral(String userId, String shopId)
    {
        try
        {
            return Integer.valueOf(this.memberCacheQueryService.findMembeInfo(userId, shopId).get("integral"));
        }
        catch (Exception e)
        {
            GooagooLog.error("获取用户积分：获取用户积分异常", e);
            return null;
        }
    }

}

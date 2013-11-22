package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.member.MemberBaseInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderDetailInShopEntity;
import com.gooagoo.entity.business.transaction.OrderInShopEntity;
import com.gooagoo.entity.business.user.FavoriteInfoBusiness;
import com.gooagoo.entity.business.user.FavoriteLinkInfoBusiness;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.gas.api.service.MemberStatusGasService;
import com.gooagoo.gas.entity.gase01.transform.UserInfo;
import com.gooagoo.gas.entity.gase01.transform.UserListRoot;
import com.gooagoo.gas.entity.gase03.transform.UserBillRoot;
import com.gooagoo.gas.entity.gase03.transform.Userbillinfo;
import com.gooagoo.gas.entity.gase04.transform.Goodsdetailextend;
import com.gooagoo.gas.entity.gase04.transform.UserBillDetailRoot;
import com.gooagoo.gas.entity.gase04.transform.Userbilldetailinfo;
import com.gooagoo.gas.entity.gase06.transform.FavoriteListRoot;
import com.gooagoo.gas.entity.gase06.transform.Favoritelist;
import com.google.gson.Gson;

@Service
public class MemberStatusGasServiceImpl implements MemberStatusGasService
{
    @Autowired
    private FavoriteQueryService favoriteQueryService;
    @Autowired
    private UserMemberQueryService userMemberQueryService;
    @Autowired
    private OrderQueryService orderQueryService;

    @Override
    public UserListRoot queryShopInsideMemberInfo(String shopId, String positionId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryConsumeTrackDetails-->入参:shopId=" + shopId + ",positionId=" + positionId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.查询区域会员基本信息
        List<MemberBaseInfoBusiness> memberBaseInfoBusinessList = this.userMemberQueryService.findMemberListInPosition(shopId, positionId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("查询到的区域会员信息为:" + new Gson().toJson(memberBaseInfoBusinessList));

        List<UserInfo> userInfoList = null;
        if (CollectionUtils.isNotEmpty(memberBaseInfoBusinessList))
        {
            //2.封装区域会员信息
            userInfoList = new ArrayList<UserInfo>();
            for (MemberBaseInfoBusiness temp : memberBaseInfoBusinessList)
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(temp.getUserId());
                userInfo.setScardno(temp.getScardno());
                userInfo.setCardname(temp.getPhyName());
                userInfo.setSex(temp.getSex() != null ? temp.getSex() : "");
                userInfo.setAge(temp.getBirthday() != null ? String.valueOf(TimeUtils.calAge(TimeUtils.convertDateToString(temp.getBirthday(), TimeUtils.FORMAT1), "Y")) : "");
                userInfo.setRealname(temp.getName() != null ? temp.getName() : "");
                userInfo.setPhone(temp.getMobile() != null ? temp.getMobile() : "");
                userInfoList.add(userInfo);
            }
        }
        //3.组装返回数据
        UserListRoot root = new UserListRoot();
        root.setUserInfo(userInfoList);
        return root;
    }

    @Override
    public UserBillRoot queryConsumeTracks(String shopEntityId, String userId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryConsumeTrackDetails-->入参:shopEntityId=" + shopEntityId + ",userId=" + userId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.查询用户在店内消费记录
        List<OrderInShopEntity> orderInShopEntityList = this.orderQueryService.findOrderListInShopEntity(shopEntityId, userId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("用户在店内消费记录信息为:" + new Gson().toJson(orderInShopEntityList));
        List<Userbillinfo> userbillinfoList = null;
        if (CollectionUtils.isNotEmpty(orderInShopEntityList))
        {
            //2.封装用户在店内消费记录
            userbillinfoList = new ArrayList<Userbillinfo>();
            for (OrderInShopEntity temp : orderInShopEntityList)
            {
                Userbillinfo userbillinfo = new Userbillinfo();
                userbillinfo.setPayprice(temp.getPayprice());
                userbillinfo.setOrderid(temp.getOrderId());
                userbillinfo.setRequesttime(temp.getRequesttime());
                userbillinfoList.add(userbillinfo);
            }
        }
        //3.组装返回数据
        UserBillRoot root = new UserBillRoot();
        root.setUserbillinfo(userbillinfoList);
        return root;
    }

    @Override
    public UserBillDetailRoot queryConsumeTrackDetails(String orderid, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryConsumeTrackDetails-->入参:orderid=" + orderid + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.查询用户在店内消费记录明细
        List<OrderDetailInShopEntity> orderDetailInShopEntityList = this.orderQueryService.findOrderDetailInShopEntity(orderid, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("用户在店内消费记录明细信息为:" + new Gson().toJson(orderDetailInShopEntityList));
        List<Userbilldetailinfo> userbilldetailinfoList = null;
        if (CollectionUtils.isNotEmpty(orderDetailInShopEntityList))
        {
            //2.封装消费记录明细信息
            userbilldetailinfoList = new ArrayList<Userbilldetailinfo>();
            for (OrderDetailInShopEntity temp : orderDetailInShopEntityList)
            {
                Userbilldetailinfo userbilldetailinfo = new Userbilldetailinfo();
                userbilldetailinfo.setBillid(temp.getOrderDetailInfo().getOrderId());
                userbilldetailinfo.setGoodsid(temp.getOrderDetailInfo().getGoodsId());
                userbilldetailinfo.setGoodsname(temp.getOrderDetailInfo().getGoodsName());
                userbilldetailinfo.setGoodsprice(temp.getOrderDetailInfo().getPrice().toString());
                userbilldetailinfo.setGoodsnum(temp.getOrderDetailInfo().getGoodsNum().toString());
                userbilldetailinfo.setGoodsimg(temp.getOrderDetailInfo().getGoodsImg());
                userbilldetailinfo.setCategoryid(temp.getOrderDetailInfo().getGoodsCategoryLeaf());//叶节点
                userbilldetailinfo.setCategoryname(temp.getGoodsCategoryLeafName());
                userbilldetailinfo.setGoodsbrandname(temp.getGoodsBrandName());
                List<Goodsdetailextend> goodsdetailextendList = null;
                if (CollectionUtils.isNotEmpty(temp.getGoodsFeatureInfoList()))
                {
                    goodsdetailextendList = new ArrayList<Goodsdetailextend>();
                    for (GoodsFeatureInfo tempGoodsFeatureInfo : temp.getGoodsFeatureInfoList())
                    {
                        Goodsdetailextend goodsdetailextend = new Goodsdetailextend();
                        goodsdetailextend.setFeaturecode(tempGoodsFeatureInfo.getFeatureCode());
                        goodsdetailextend.setFeaturename(tempGoodsFeatureInfo.getFeatureName());
                        goodsdetailextend.setFeaturevalue(tempGoodsFeatureInfo.getFeatureValue());
                        goodsdetailextendList.add(goodsdetailextend);
                    }
                }

                userbilldetailinfo.setGoodsdetailextend(goodsdetailextendList);
                userbilldetailinfoList.add(userbilldetailinfo);
            }
        }
        //3.组装返回数据
        UserBillDetailRoot root = new UserBillDetailRoot();
        root.setUserbilldetailinfo(userbilldetailinfoList);
        return root;
    }

    @Override
    public FavoriteListRoot queryUserFavoriates(String userId, String shopId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryUserFavoriates-->入参:userId=" + userId + ",shopId=" + shopId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.查询会员的收藏信息
        FavoriteLinkInfoBusiness favoriteLinkInfoBusiness = this.favoriteQueryService.findMemberFavorite(userId, shopId, null, null, null, null, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("查询的用户userId=" + userId + "在商家shopId=" + shopId + "的收藏信息为:" + new Gson().toJson(favoriteLinkInfoBusiness));
        List<Favoritelist> favoriteList = null;
        if (favoriteLinkInfoBusiness != null && CollectionUtils.isNotEmpty(favoriteLinkInfoBusiness.getFavoriteInfoBusinessList()))
        {
            //2.封装查询到会员收藏信息
            favoriteList = new ArrayList<Favoritelist>();
            for (FavoriteInfoBusiness temp : favoriteLinkInfoBusiness.getFavoriteInfoBusinessList())
            {
                Favoritelist favorite = new Favoritelist();
                favorite.setFavoriteid(temp.getFavoriteid());
                favorite.setCtimestamp(temp.getCtimestamp());
                favorite.setInfobegindate(temp.getInfobegindate() != null ? temp.getInfobegindate() : "");
                favorite.setInfoenddate(temp.getInfoenddate() != null ? temp.getInfoenddate() : "");
                favorite.setInfopic(temp.getInfopic());
                favorite.setInfotitle(temp.getInfotitle());
                favorite.setInfotype(temp.getInfotype());
                favorite.setInfourl(temp.getInfourl());
                favorite.setIsdel(temp.getIsdel());
                favorite.setIsused(temp.getIsused() != null ? temp.getIsused() : "");
                favorite.setObjectid(temp.getObjectid());
                favorite.setPrice(temp.getPrice() != null ? temp.getPrice() : "");
                favoriteList.add(favorite);
            }
        }
        //3.组装返回数据
        FavoriteListRoot root = new FavoriteListRoot();
        root.setFavoritelist(favoriteList);
        return root;
    }
}

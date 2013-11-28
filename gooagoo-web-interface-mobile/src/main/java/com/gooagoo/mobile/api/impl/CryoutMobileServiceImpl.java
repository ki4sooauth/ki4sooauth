package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.cryout.CryoutPlaceQueryService;
import com.gooagoo.api.business.query.marketing.cryout.CryoutQueryService;
import com.gooagoo.api.business.query.marketing.qualitygoods.QualityGoodsQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.QualityGoodsBusiness;
import com.gooagoo.entity.business.marketing.QualityGoodsForPlace;
import com.gooagoo.entity.business.marketing.SecondMenu;
import com.gooagoo.entity.business.marketing.ShopDetailForPlace;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfo;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfoBusiness;
import com.gooagoo.mobile.api.CryoutMobileService;
import com.gooagoo.mobile.entity.mobc01.transform.CryoutListgRoot;
import com.gooagoo.mobile.entity.mobc01.transform.Cryoutlistg;
import com.gooagoo.mobile.entity.mobc01.transform.Isdeleted;
import com.gooagoo.mobile.entity.mobc02.transform.CryoutPlazaRoot;
import com.gooagoo.mobile.entity.mobc02.transform.Firstmenu;
import com.gooagoo.mobile.entity.mobc02.transform.Secondmenu;
import com.gooagoo.mobile.entity.mobc03.transform.CryoutPlazaShopListRoot;
import com.gooagoo.mobile.entity.mobc03.transform.Shoplist;
import com.gooagoo.mobile.entity.mobc04.transform.CryoutPlazaShopRoot;
import com.gooagoo.mobile.entity.mobc04.transform.Shopdetail;
import com.gooagoo.mobile.entity.mobc05.transform.BoutiqueRecommendRoot;
import com.gooagoo.mobile.entity.mobc05.transform.Boutiquerecommend;
import com.gooagoo.mobile.entity.mobc07.transform.RecommendCryoutListRoot;
import com.gooagoo.mobile.entity.mobc07.transform.Recommendcryoutlist;
import com.google.gson.Gson;

@Service
public class CryoutMobileServiceImpl implements CryoutMobileService
{
    @Autowired
    private CryoutPlaceQueryService cryoutPlaceQueryService;
    @Autowired
    private QualityGoodsQueryService qualityGoodsQueryService;
    @Autowired
    private CryoutQueryService cryoutQueryService;

    @Override
    public CryoutPlazaRoot getCryoutPlazaMenu() throws Exception
    {
        //1.吆喝广场侧边栏分类查询
        List<FirstMenu> firstmenuList = this.cryoutPlaceQueryService.findCryoutPlaceMenu();

        GooagooLog.debug("吆喝广场侧边栏分类查询" + new Gson().toJson(firstmenuList));
        List<Firstmenu> firstmenuLists = null;
        if (CollectionUtils.isNotEmpty(firstmenuList))
        {
            //2.封装查询到吆喝广场侧边栏分类信息
            firstmenuLists = new ArrayList<Firstmenu>();
            for (FirstMenu temp : firstmenuList)
            {
                Firstmenu firstmenu = new Firstmenu();
                firstmenu.setFirstmenucode(temp.getFirstmenucode());
                firstmenu.setFirstmenuname(temp.getFirstmenuname());
                List<Secondmenu> secondmenuList = null;
                if (CollectionUtils.isNotEmpty(temp.getSecondmenu()))
                {
                    secondmenuList = new ArrayList<Secondmenu>();

                    for (SecondMenu tempSecondmenu : temp.getSecondmenu())
                    {
                        Secondmenu secondmenu = new Secondmenu();
                        secondmenu.setSecondmenucode(tempSecondmenu.getSecondmenucode());
                        secondmenu.setSecondmenuname(tempSecondmenu.getSecondmenuname());
                        secondmenuList.add(secondmenu);
                    }
                }
                firstmenu.setSecondmenu(secondmenuList);
                firstmenuLists.add(firstmenu);
            }
        }

        //3.组装返回数据
        CryoutPlazaRoot root = new CryoutPlazaRoot();
        root.setFirstmenu(firstmenuLists);
        return root;
    }

    @Override
    public CryoutPlazaShopListRoot getCryoutPlazaShopList(String keyword, String type, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getCryoutPlazaShopList-->入参:keyword=" + keyword + ",type=" + type);
        //1.吆喝广场商家列表查询
        List<ShopDetailForPlace> shopDetailForPlaceList = this.cryoutPlaceQueryService.findCryoutPlaceList(keyword, type, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("查询到的吆喝广场商家列表信息为：" + new Gson().toJson(shopDetailForPlaceList));
        List<Shoplist> shopList = null;
        if (CollectionUtils.isNotEmpty(shopDetailForPlaceList))
        {
            //2.封装吆喝广场商家列表信息
            shopList = new ArrayList<Shoplist>();
            for (ShopDetailForPlace temp : shopDetailForPlaceList)
            {
                Shoplist shoplist = new Shoplist();
                shoplist.setAttentionnum(temp.getAttentionnum());
                shoplist.setShopid(temp.getShopid());
                shoplist.setMembernum(temp.getMembernum());
                shoplist.setShopname(temp.getShopName());
                shoplist.setShopurl(temp.getLogo2());
                shopList.add(shoplist);
            }
        }

        //3.组装返回数据
        CryoutPlazaShopListRoot root = new CryoutPlazaShopListRoot();
        root.setShoplist(shopList);
        return root;
    }

    @Override
    public CryoutPlazaShopRoot getCryoutPlazaShopRoot(String shopId) throws Exception
    {
        GooagooLog.info("getCryoutPlazaShopRoot-->入参:shopId=" + shopId);
        //1.吆喝广场商家详情查询
        ShopDetailForPlace findCryoutPlaceDetail = this.cryoutPlaceQueryService.findCryoutPlaceDetail(shopId);
        GooagooLog.debug("吆喝广场商家详情查询" + new Gson().toJson(findCryoutPlaceDetail));
        Shopdetail shopdetail = null;
        if (findCryoutPlaceDetail != null)
        {
            //2.组装查询到的吆喝广场商家详情
            shopdetail = new Shopdetail();
            shopdetail.setAttentionnum(findCryoutPlaceDetail.getAttentionnum());
            shopdetail.setShopid(findCryoutPlaceDetail.getShopid());
            shopdetail.setLogo1(findCryoutPlaceDetail.getLogo1());
            shopdetail.setLogo2(findCryoutPlaceDetail.getLogo2());
            shopdetail.setMembernum(findCryoutPlaceDetail.getMembernum());
            shopdetail.setCardheaderurl(findCryoutPlaceDetail.getCardheaderurl());
        }

        CryoutPlazaShopRoot root = new CryoutPlazaShopRoot();
        root.setShopdetail(shopdetail);
        return root;
    }

    @Override
    public BoutiqueRecommendRoot getBoutiqueRecommend(String userId, String shopId, String type, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getBoutiqueRecommend-->入参:userId=" + userId + " ,shopId=" + shopId + ",type=" + type + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);

        //1.查询吆喝广场下精品推荐信息
        QualityGoodsForPlace findQualityGoodsForPlace = this.qualityGoodsQueryService.findQualityGoodsForPlace(userId, shopId, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("查询到吆喝广场下精品推荐信息为：  " + new Gson().toJson(findQualityGoodsForPlace));
        List<Boutiquerecommend> boutiquerecommendList = null;
        if (null != findQualityGoodsForPlace && CollectionUtils.isNotEmpty(findQualityGoodsForPlace.getQualityGoodsBusinessList()))
        {
            boutiquerecommendList = new ArrayList<Boutiquerecommend>();
            for (QualityGoodsBusiness temp : findQualityGoodsForPlace.getQualityGoodsBusinessList())
            {
                Boutiquerecommend boutiquerecommend = new Boutiquerecommend();
                boutiquerecommend.setNoticeimage(temp.getGoodsImg());
                boutiquerecommend.setNoticetype("G");
                boutiquerecommendList.add(boutiquerecommend);
            }
        }

        //2.组装查询到的精品推荐信息
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root.setBoutiquerecommend(boutiquerecommendList);
        return root;
    }

    @Override
    public CryoutListgRoot getCryoutListg(String shopId, String userId, String cryoutInfoId, String pageType, String pageSize, String type, String gpsx, String gpsy, String infotype, String cTimeStamp) throws Exception
    {
        GooagooLog.info("getCryoutListg-->入参:cryoutInfoId=" + cryoutInfoId + ",pageType=" + pageType + ",pageSize=" + pageSize + ",type=" + type + ",gpsx=" + gpsx + ",gpsx=" + gpsx + " ,infotype" + infotype + ",cTimeStamp=" + cTimeStamp);

        //1.查询商家吆喝
        Integer tempPageSize = null;
        if (StringUtils.hasText(pageSize))
        {
            tempPageSize = Integer.valueOf(pageSize);
        }
        ShopCryoutInfoBusiness shopCryoutInfoBusiness = this.cryoutQueryService.findCryoutList("M", userId, shopId, type, infotype, cryoutInfoId, pageType, tempPageSize, cTimeStamp);

        List<Cryoutlistg> cryoutlistgList = null;
        if (shopCryoutInfoBusiness != null && CollectionUtils.isNotEmpty(shopCryoutInfoBusiness.getShopCryoutInfoList()))
        {
            //2.封装查询到的商家吆喝信息
            cryoutlistgList = new ArrayList<Cryoutlistg>();
            for (ShopCryoutInfo temp : shopCryoutInfoBusiness.getShopCryoutInfoList())
            {
                Cryoutlistg cryoutlistg = new Cryoutlistg();
                cryoutlistg.setPageid(temp.getPageId());
                cryoutlistg.setCryoutuserid(temp.getCryoutUserId());
                cryoutlistg.setCryoutid(temp.getCryoutid());
                cryoutlistg.setUserid(temp.getUserid());
                cryoutlistg.setShopid(temp.getShopid());
                cryoutlistg.setAddress(temp.getAddress());
                cryoutlistg.setShopname(temp.getShopname());
                cryoutlistg.setLogo1(temp.getLogo1());
                cryoutlistg.setLogo2(temp.getLogo2());
                cryoutlistg.setAddress(temp.getAddress());
                cryoutlistg.setCryouttextmobile(temp.getCryouttextmobile());
                cryoutlistg.setThumbnailpic(temp.getThumbnailpic());
                cryoutlistg.setBmiddlepic(temp.getBmiddlepic());
                cryoutlistg.setOriginalpic(temp.getOriginalpic());
                cryoutlistg.setSource(temp.getSource());
                cryoutlistg.setCreatetime(temp.getPushTime());
                cryoutlistg.setAllowat(temp.getAllowat());
                cryoutlistg.setRelation(temp.getRelation());
                cryoutlistgList.add(cryoutlistg);
            }
        }

        //封装查询到删除数据
        Isdeleted isdeleted = null;
        if (shopCryoutInfoBusiness != null && shopCryoutInfoBusiness.getIsdeletedInfo() != null)
        {
            isdeleted = new Isdeleted();
            isdeleted.setCryoutidstr(shopCryoutInfoBusiness.getIsdeletedInfo().getIdstr());
            isdeleted.setCtimestamp(shopCryoutInfoBusiness.getIsdeletedInfo().getCtimestamp());
            isdeleted.setFlag(shopCryoutInfoBusiness.getIsdeletedInfo().getFlag());
        }

        //3.组装返回数据
        CryoutListgRoot root = new CryoutListgRoot();
        root.setCryoutlistg(cryoutlistgList);
        root.setIsdeleted(isdeleted);
        return root;
    }

    @Override
    public RecommendCryoutListRoot getRecommendCryoutList(String userId) throws Exception
    {
        GooagooLog.info("getRecommendCryoutList-->入参:userId=" + userId);
        List<ShopCryoutInfo> listCryoutInfo = this.cryoutQueryService.findCryoutOther(userId);
        GooagooLog.debug("根据userId=" + userId + "mobc07:商家推荐吆喝 ：" + new Gson().toJson(listCryoutInfo));
        List<Recommendcryoutlist> list = null;
        if (CollectionUtils.isNotEmpty(listCryoutInfo))
        {
            list = new ArrayList<Recommendcryoutlist>();
            for (ShopCryoutInfo t : listCryoutInfo)
            {
                Recommendcryoutlist recommendcryoutlist = new Recommendcryoutlist();
                recommendcryoutlist.setCryoutid(t.getCryoutid());
                recommendcryoutlist.setUserid(t.getUserid());
                recommendcryoutlist.setShopid(t.getShopid());
                recommendcryoutlist.setShopname(t.getShopname());
                recommendcryoutlist.setLogo(t.getLogo1());
                recommendcryoutlist.setAddress(t.getAddress());
                recommendcryoutlist.setCryouttextmobile(t.getCryouttextmobile());
                recommendcryoutlist.setThumbnailpic(t.getThumbnailpic());
                recommendcryoutlist.setBmiddlepic(t.getBmiddlepic());
                recommendcryoutlist.setSource(t.getSource());
                //                recommendcryoutlist.setCreatetime(TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT1));
                recommendcryoutlist.setAllowat(t.getAllowat());
                recommendcryoutlist.setRelation(t.getRelation());
                list.add(recommendcryoutlist);
            }

        }
        RecommendCryoutListRoot root = new RecommendCryoutListRoot();
        root.setRecommendcryoutlist(list);
        return root;
    }
}

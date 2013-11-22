package com.gooagoo.query.business.user.favorite;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.user.favorite.FavoritePlaceQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.base.QualitySquareGoodsTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.user.favorite.FavoritePlaceAdapterMapper;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.SecondMenu;
import com.gooagoo.entity.business.user.FavoritePlace;
import com.gooagoo.entity.business.user.MobileFavoritePlace;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 收藏广场
 */

@Service
public class FavoritePlaceQueryServiceImpl implements FavoritePlaceQueryService
{

    @Autowired
    private QualitySquareGoodsTypeGeneratorQueryService qualitySquareGoodsTypeGeneratorQueryService;

    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;

    @Autowired
    private FavoritePlaceAdapterMapper favoritePlaceAdapterMapper;

    @Autowired
    private FavoriteQueryService favoriteQueryService;

    @Override
    public List<FirstMenu> findFavoritePlaceLeftMenu() throws Exception
    {
        List<FirstMenu> firstmenuList = new ArrayList<FirstMenu>();
        //全部
        //        FirstMenu firstmenu = new FirstMenu();
        //        firstmenu.setFirstmenucode("");
        //        firstmenu.setFirstmenuname("全部");
        //        firstmenu.setSecondmenu(null);
        //        firstmenuList.add(firstmenu);
        //优惠凭证收藏
        FirstMenu yhpzfirstmenu = new FirstMenu();
        yhpzfirstmenu.setFirstmenucode("C");
        yhpzfirstmenu.setFirstmenuname("优惠凭证收藏");
        List<SecondMenu> yhSecondMenu = this.getYHPZSecondMenu();
        yhpzfirstmenu.setSecondmenu(yhSecondMenu);
        firstmenuList.add(yhpzfirstmenu);

        //精品收藏
        FirstMenu jpfirstmenu = new FirstMenu();
        jpfirstmenu.setFirstmenucode("G");
        jpfirstmenu.setFirstmenuname("精品收藏");
        List<SecondMenu> jpSecondMenu = this.getJPSecondMenu();
        jpfirstmenu.setSecondmenu(jpSecondMenu);
        firstmenuList.add(jpfirstmenu);

        //活动收藏
        FirstMenu hdfirstmenu = new FirstMenu();
        hdfirstmenu.setFirstmenucode("A");
        hdfirstmenu.setFirstmenuname("活动收藏");
        hdfirstmenu.setSecondmenu(null);
        firstmenuList.add(hdfirstmenu);
        return firstmenuList;
    }

    /**
     *  获取精品收藏二级菜单
     */
    private List<SecondMenu> getJPSecondMenu() throws Exception
    {
        List<SecondMenu> secondmenuList = new ArrayList<SecondMenu>();
        SecondMenu secondmenu = new SecondMenu();
        secondmenu.setSecondmenucode("G");
        secondmenu.setSecondmenuname("全部");
        secondmenuList.add(secondmenu);
        QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample = new QualitySquareGoodsTypeExample();
        qualitySquareGoodsTypeExample.createCriteria().andParentGoodsTypeIdEqualTo("-1").andIsDelEqualTo("N");
        List<QualitySquareGoodsType> qualitySquareGoodsTypeList = this.qualitySquareGoodsTypeGeneratorQueryService.selectByExample(qualitySquareGoodsTypeExample);
        if (CollectionUtils.isNotEmpty(qualitySquareGoodsTypeList))
        {
            for (QualitySquareGoodsType item : qualitySquareGoodsTypeList)
            {
                SecondMenu sm = new SecondMenu();
                sm.setSecondmenucode("G" + item.getGoodsTypeId());
                sm.setSecondmenuname(item.getGoodsTypeName());
                secondmenuList.add(sm);
            }
        }
        return secondmenuList;
    }

    /**
     *  获取优惠凭证收藏二级菜单
     */
    private List<SecondMenu> getYHPZSecondMenu()
    {
        List<SecondMenu> secondmenuList = new ArrayList<SecondMenu>();
        SecondMenu secondmenu = new SecondMenu();
        secondmenu.setSecondmenucode("C");
        secondmenu.setSecondmenuname("全部");
        secondmenuList.add(secondmenu);
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        shopTypeExample.createCriteria().andParentShopTypeIdEqualTo("-1").andIsDelEqualTo("N");
        shopTypeExample.setOrderByClause("shop_type_id ASC");
        List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);
        if (CollectionUtils.isNotEmpty(shopTypeList))
        {
            for (ShopType shopType : shopTypeList)
            {
                SecondMenu sm = new SecondMenu();
                sm.setSecondmenucode("C" + shopType.getShopTypeId());
                sm.setSecondmenuname(shopType.getShopTypeName());
                secondmenuList.add(sm);
            }
        }
        return secondmenuList;
    }

    @Override
    public List<FavoritePlace> findFavoritePlace(String userid, String shopid, String objType, String keyword, String typecode, Integer pageIndex, Integer pageSize) throws Exception
    {
        if (pageIndex != null)
        {
            if (pageIndex == 1 && pageSize == -1)
            {
                pageIndex = null;
                pageSize = null;
            }
            else
            {
                pageIndex = (pageIndex - 1) * pageSize;

            }
        }
        List<FavoritePlace> favoriteplaceList = new ArrayList<FavoritePlace>();
        if (StringUtils.hasText(typecode))
        {
            if (!StringUtils.hasText(keyword))
            {
                keyword = "";
            }
            String type = typecode.substring(0, 1);
            String code = typecode.substring(1, typecode.length());
            if (type.equalsIgnoreCase("G"))//精品
            {
                if (StringUtils.hasText(code))
                {
                    List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.findMarketingQualityGoodsOfplaceById(code, pageIndex, pageSize);
                    favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
                }
                else
                {
                    List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.fuzzyFindMarketingQualityGoodsOfplaceByKeyWord(keyword, pageIndex, pageSize);
                    favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
                }
            }
            else if (type.equalsIgnoreCase("C"))//优惠
            {
                if (StringUtils.hasText(code))
                {
                    List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.findCouponOfplaceById(shopid, objType, code, pageIndex, pageSize);
                    favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
                }
                else
                {
                    List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.fuzzyFindCouponOfplaceByKeyWord(shopid, objType, keyword, pageIndex, pageSize);
                    favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
                }
            }
            else if (type.equalsIgnoreCase("A"))//活动
            {
                List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.fuzzyFindActivityOfplaceByKeyWord(keyword, pageIndex, pageSize);
                favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
            }
        }
        else
        {
            List<MobileFavoritePlace> mobileFavoriteplaceList = this.favoritePlaceAdapterMapper.findMobileFavoritePlace(keyword, pageIndex, pageSize);
            favoriteplaceList = this.mobileFavoriteplaceList2FavoriteplaceList(userid, mobileFavoriteplaceList, favoriteplaceList);
        }
        return favoriteplaceList;
    }

    private List<FavoritePlace> mobileFavoriteplaceList2FavoriteplaceList(String userId, List<MobileFavoritePlace> mobilelist, List<FavoritePlace> list) throws Exception
    {
        for (MobileFavoritePlace item : mobilelist)
        {
            FavoritePlace favoritePlace = new FavoritePlace();
            favoritePlace.setObjType(item.getObjType());
            favoritePlace.setObjId(item.getObjId());
            favoritePlace.setObjName(item.getObjName());
            if ("G".equalsIgnoreCase(item.getObjType()))
            {
                if (StringUtils.hasText(item.getObjImg()))
                {//取出商品主图片
                    List<String> imgs = new Gson().fromJson(item.getObjImg(), new TypeToken<List<String>>()
                    {
                    }.getType());
                    favoritePlace.setObjImg(imgs.get(0));
                }
            }
            else
            {
                favoritePlace.setObjImg(item.getObjImg());
            }

            if ("A".equalsIgnoreCase(item.getObjType()))
            {
                favoritePlace.setLinkUrl(UrlUtils.getActiveUrl(item.getObjId()));
                favoritePlace.setCommentNums("0");
            }
            else if ("C".equalsIgnoreCase(item.getObjType()))
            {
                favoritePlace.setLinkUrl(UrlUtils.getCouponUrl(item.getObjId()));
                favoritePlace.setCommentNums("0");
            }
            else if ("G".equalsIgnoreCase(item.getObjType()))
            {
                favoritePlace.setLinkUrl(UrlUtils.getGoodsUrl(item.getObjId()));
                //暂时只有商品有评论数量
                UserCommentExample userCommentExample = new UserCommentExample();
                userCommentExample.createCriteria().andGoodsIdEqualTo(item.getObjId()).andIsDelEqualTo("N");
                Integer commentnums = this.userCommentGeneratorQueryService.countByExample(userCommentExample);
                favoritePlace.setCommentNums(commentnums.toString());
            }
            favoritePlace.setShopId(item.getShopId());
            favoritePlace.setShopName(item.getShopName());
            FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
            favoriteInfoExample.createCriteria().andObjectIdEqualTo(item.getObjId()).andIsDelEqualTo("N");
            Integer favnums = this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample);
            favoritePlace.setFavNums(favnums.toString());
            if (StringUtils.hasText(userId))
            {
                if (this.favoriteQueryService.isFavorite(userId, item.getObjId()))
                {
                    favoritePlace.setIsFav("Y");
                }
                else
                {
                    favoritePlace.setIsFav("N");
                }
            }
            //用户没登陆 默认全是未收藏
            else
            {
                favoritePlace.setIsFav("N");
            }
            list.add(favoritePlace);
        }
        return list;
    }

}

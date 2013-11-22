package com.gooagoo.query.business.user.shoppingmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.statistics.UserPositionStatisticQueryService;
import com.gooagoo.api.business.query.user.shoppingmatch.ShoppingMatchQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.dao.business.user.shoppingmatch.ShoppingMatchAdapterMapper;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.user.shoppingmatch.MatchInfoList;
import com.gooagoo.entity.business.user.shoppingmatch.PositionInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.user.UserMobileInfo;

/**
 * 购物匹配
 */
@Service
public class ShoppingMatchQueryServiceImpl implements ShoppingMatchQueryService
{

    @Autowired
    private UserMobileInfoGeneratorQueryService userMobileInfoGeneratorQueryService;

    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;

    @Autowired
    private ShoppingMatchAdapterMapper shoppingMatchAdapterMapper;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private UserPositionStatisticQueryService userPositionStatisticQueryService;

    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Override
    public List<PositionInfo> shoppingMatch(String userid, String mac, String keyword) throws Exception
    {
        List<PositionInfo> positionList = null;
        PositionInfo position = null;
        if (!StringUtils.hasText(mac))
        {
            UserMobileInfo userMobileInfo = this.userMobileInfoGeneratorQueryService.selectByPrimaryKey(userid);
            mac = userMobileInfo.getMacAddress();
        }
        if (StringUtils.hasText(mac))
        {
            position = new PositionInfo();
            //通过mac地址从redis获取positionid区域编号
            Map<String, String> userPositionInfoCache = this.userPositionStatisticQueryService.findUserPositionInfo(mac);
            if (userPositionInfoCache != null)
            {
                String positionId = userPositionInfoCache.get("positionId");
                position.setPositionid(positionId);//位置id
                ShopPosition shopPosition = this.shopPositionGeneratorQueryService.selectUnDelByPrimaryKey(positionId);
                if (shopPosition != null && StringUtils.hasText(shopPosition.getPositionName()))
                {
                    position.setPositionname(shopPosition.getPositionName());//位置
                }
                //购物匹配列表
                List<MatchInfoList> list = null;
                if (StringUtils.hasText(keyword))
                {
                    String[] keywordArr = keyword.split(",");
                    for (int i = 0; i < keywordArr.length; i++)
                    {
                        List<GoodsBaseInfo> goodsBaseInfoList = this.shoppingMatchAdapterMapper.findShoppingMatchInfo(positionId, keywordArr[i]);
                        if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
                        {
                            if (list == null)
                            {
                                list = new ArrayList<MatchInfoList>();
                            }
                            for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
                            {
                                MatchInfoList matchlist = new MatchInfoList();
                                matchlist.setKeyword(keywordArr[i]);
                                matchlist.setGoodsid(goodsBaseInfo.getGoodsId());
                                matchlist.setGoodsname(goodsBaseInfo.getGoodsName());
                                list.add(matchlist);
                            }
                        }
                    }
                }
                if (list == null)
                {
                    position.setMatchlist(null);//无匹配商品
                }
                else
                {
                    position.setMatchlist(list);//购物匹配列表
                }
                positionList = new ArrayList<PositionInfo>();
                positionList.add(position);
            }
        }
        return positionList;
    }

    @Override
    public List<ShopGoodsDetailInfo> getMatchgoodslistInfo(String goodsIds) throws Exception
    {
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = null;
        if (StringUtils.hasText(goodsIds))
        {
            shopGoodsDetailInfoList = new ArrayList<ShopGoodsDetailInfo>();
            String[] goodsIdArr = goodsIds.split(",");
            for (int i = 0; i < goodsIdArr.length; i++)
            {
                String goodsId = goodsIdArr[i];
                //商品基本信息
                GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(goodsId);
                if (goodsBaseInfo != null)
                {
                    ShopGoodsDetailInfo shopGoodsDetailInfo = new ShopGoodsDetailInfo();
                    shopGoodsDetailInfo.setGoodsBaseInfo(goodsBaseInfo);
                    //商品营销信息
                    GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(goodsId);
                    shopGoodsDetailInfo.setGoodsMarketingInfo(goodsMarketingInfo);
                    //商家信息
                    ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(goodsBaseInfo.getShopId());
                    if (shopInfo != null)
                    {
                        shopGoodsDetailInfo.setShopName(shopInfo.getShopName());
                    }
                    //商品所在区域名称
                    Map<String, String> goodsInfoCache = this.goodsCacheQueryService.findGoodsInfo(goodsId);
                    String positionName = goodsInfoCache.get("positionName");
                    shopGoodsDetailInfo.setPositionName(positionName);
                    shopGoodsDetailInfoList.add(shopGoodsDetailInfo);
                }
            }
        }
        return shopGoodsDetailInfoList;
    }

}

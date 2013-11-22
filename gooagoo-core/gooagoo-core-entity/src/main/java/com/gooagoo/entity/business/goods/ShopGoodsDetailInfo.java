package com.gooagoo.entity.business.goods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;

/**
 * 商品详情（包括商品基本、营销、特征信息）
 */
public class ShopGoodsDetailInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String shopName;
    private String goodsscore;//商品评分(平均分)
    private String salesw;//本周销量
    private String salesd;//当天点餐量
    private String positionName;//位置信息描述
    private String discountprice;//促销价格
    private String isFav;//是否收藏，Y-已收藏 N-未收藏
    private String goodsCategoryRootName;//品类编号名称（根节点）
    private String goodsCategoryLeafName;//品类编号名称（叶节点）
    private GoodsBaseInfo goodsBaseInfo;//商品基本信息
    private GoodsMarketingInfo goodsMarketingInfo;//商品营销信息
    private List<GoodsFeatureInfo> goodsFeatureInfoList = new ArrayList<GoodsFeatureInfo>();//商品特征信息
    private List<CrossGoods> crossGoodsList = new ArrayList<CrossGoods>();//交叉商品信息列表

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getGoodsscore()
    {
        return this.goodsscore;
    }

    public void setGoodsscore(String goodsscore)
    {
        this.goodsscore = goodsscore;
    }

    public String getSalesw()
    {
        return this.salesw;
    }

    public void setSalesw(String salesw)
    {
        this.salesw = salesw;
    }

    public String getSalesd()
    {
        return this.salesd;
    }

    public void setSalesd(String salesd)
    {
        this.salesd = salesd;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getDiscountprice()
    {
        return this.discountprice;
    }

    public void setDiscountprice(String discountprice)
    {
        this.discountprice = discountprice;
    }

    public GoodsBaseInfo getGoodsBaseInfo()
    {
        return this.goodsBaseInfo;
    }

    public void setGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo)
    {
        this.goodsBaseInfo = goodsBaseInfo;
    }

    public GoodsMarketingInfo getGoodsMarketingInfo()
    {
        return this.goodsMarketingInfo;
    }

    public void setGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo)
    {
        this.goodsMarketingInfo = goodsMarketingInfo;
    }

    public List<GoodsFeatureInfo> getGoodsFeatureInfoList()
    {
        return this.goodsFeatureInfoList;
    }

    public void setGoodsFeatureInfoList(List<GoodsFeatureInfo> goodsFeatureInfoList)
    {
        this.goodsFeatureInfoList = goodsFeatureInfoList;
    }

    public List<CrossGoods> getCrossGoodsList()
    {
        return this.crossGoodsList;
    }

    public void setCrossGoodsList(List<CrossGoods> crossGoodsList)
    {
        this.crossGoodsList = crossGoodsList;
    }

    public String getIsFav()
    {
        return this.isFav;
    }

    public void setIsFav(String isFav)
    {
        this.isFav = isFav;
    }

    public String getGoodsCategoryRootName()
    {
        return this.goodsCategoryRootName;
    }

    public void setGoodsCategoryRootName(String goodsCategoryRootName)
    {
        this.goodsCategoryRootName = goodsCategoryRootName;
    }

    public String getGoodsCategoryLeafName()
    {
        return this.goodsCategoryLeafName;
    }

    public void setGoodsCategoryLeafName(String goodsCategoryLeafName)
    {
        this.goodsCategoryLeafName = goodsCategoryLeafName;
    }

    @Override
    public String toString()
    {
        return "ShopGoodsDetailInfo [shopName=" + this.shopName + ", goodsscore=" + this.goodsscore + ", salesw=" + this.salesw + ", salesd=" + this.salesd + ", positionName=" + this.positionName + ", discountprice=" + this.discountprice + ", isFav=" + this.isFav + ", goodsCategoryRootName=" + this.goodsCategoryRootName + ", goodsCategoryLeafName=" + this.goodsCategoryLeafName + ", goodsBaseInfo=" + this.goodsBaseInfo + ", goodsMarketingInfo=" + this.goodsMarketingInfo + ", goodsFeatureInfoList=" + this.goodsFeatureInfoList + ", crossGoodsList=" + this.crossGoodsList + "]";
    }

}

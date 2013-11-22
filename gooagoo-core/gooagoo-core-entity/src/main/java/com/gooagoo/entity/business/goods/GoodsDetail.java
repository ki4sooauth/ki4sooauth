package com.gooagoo.entity.business.goods;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;

/**
 * 商品详细信息表
 */

public class GoodsDetail implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopName;//商家名称
    private String shopLogo1;//商家logo1，正方形
    private String shopLogo2;//商家logo2，长方形
    private String shopEntityPhone;//实体店联系电话
    private String goodsHot;//人气
    private String commentLevel;//评分
    private String commentNums;//评论次数
    private String goodsContent;//商品推荐描述
    private String goodsCategoryRoot;//品类编码（根节点）
    private String goodsCategoryLeaf;//品类编码（叶节点）
    private String goodsCategoryRootName;//品类名称（根节点）
    private String goodsCategoryLeafName;//品类名称（叶节点）
    private String goodsBrandName;//品牌名称
    private String goodsImg;//商品图片URL，json串
    private String inventory;//商品库存量：0：无，1：有 
    private GoodsBaseInfo goodsBaseInfo;
    private GoodsMarketingInfo goodsMarketingInfo;
    private List<GoodsFeatureInfo> goodsFeatureInfoList;

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopLogo1()
    {
        return this.shopLogo1;
    }

    public void setShopLogo1(String shopLogo1)
    {
        this.shopLogo1 = shopLogo1;
    }

    public String getShopLogo2()
    {
        return this.shopLogo2;
    }

    public void setShopLogo2(String shopLogo2)
    {
        this.shopLogo2 = shopLogo2;
    }

    public String getShopEntityPhone()
    {
        return this.shopEntityPhone;
    }

    public void setShopEntityPhone(String shopEntityPhone)
    {
        this.shopEntityPhone = shopEntityPhone;
    }

    public String getGoodsHot()
    {
        return this.goodsHot;
    }

    public void setGoodsHot(String goodsHot)
    {
        this.goodsHot = goodsHot;
    }

    public String getCommentLevel()
    {
        return this.commentLevel;
    }

    public void setCommentLevel(String commentLevel)
    {
        this.commentLevel = commentLevel;
    }

    public String getCommentNums()
    {
        return this.commentNums;
    }

    public void setCommentNums(String commentNums)
    {
        this.commentNums = commentNums;
    }

    public String getGoodsContent()
    {
        return this.goodsContent;
    }

    public void setGoodsContent(String goodsContent)
    {
        this.goodsContent = goodsContent;
    }

    public String getGoodsCategoryRoot()
    {
        return this.goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return this.goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
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

    public String getGoodsBrandName()
    {
        return this.goodsBrandName;
    }

    public void setGoodsBrandName(String goodsBrandName)
    {
        this.goodsBrandName = goodsBrandName;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
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

    public String getInventory()
    {
        return this.inventory;
    }

    public void setInventory(String inventory)
    {
        this.inventory = inventory;
    }

    @Override
    public String toString()
    {
        return "GoodsDetail [shopName=" + this.shopName + ", shopLogo1=" + this.shopLogo1 + ", shopLogo2=" + this.shopLogo2 + ", shopEntityPhone=" + this.shopEntityPhone + ", goodsHot=" + this.goodsHot + ", commentLevel=" + this.commentLevel + ", commentNums=" + this.commentNums + ", goodsContent=" + this.goodsContent + ", goodsCategoryRoot=" + this.goodsCategoryRoot + ", goodsCategoryLeaf=" + this.goodsCategoryLeaf + ", goodsCategoryRootName=" + this.goodsCategoryRootName + ", goodsCategoryLeafName=" + this.goodsCategoryLeafName + ", goodsBrandName=" + this.goodsBrandName + ", goodsImg=" + this.goodsImg + ", inventory=" + this.inventory + ", goodsBaseInfo=" + this.goodsBaseInfo + ", goodsMarketingInfo=" + this.goodsMarketingInfo + ", goodsFeatureInfoList=" + this.goodsFeatureInfoList + "]";
    }

}

package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;

/**
 * 店内消费记录
 * @author YL
 *
 */
public class OrderDetailInShopEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsCategoryRootName;//品类名称（根节点）

    private String goodsCategoryLeafName;//品类名称（叶节点）

    private String goodsBrandName;//品牌名称

    private OrderDetailInfo orderDetailInfo;//订单商品详细信息

    private List<GoodsFeatureInfo> goodsFeatureInfoList;//商家订单原始信息图片详情

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

    public OrderDetailInfo getOrderDetailInfo()
    {
        return this.orderDetailInfo;
    }

    public void setOrderDetailInfo(OrderDetailInfo orderDetailInfo)
    {
        this.orderDetailInfo = orderDetailInfo;
    }

    public List<GoodsFeatureInfo> getGoodsFeatureInfoList()
    {
        return this.goodsFeatureInfoList;
    }

    public void setGoodsFeatureInfoList(List<GoodsFeatureInfo> goodsFeatureInfoList)
    {
        this.goodsFeatureInfoList = goodsFeatureInfoList;
    }

    @Override
    public String toString()
    {
        return "OrderDetailInShopEntity [goodsCategoryRootName=" + this.goodsCategoryRootName + ", goodsCategoryLeafName=" + this.goodsCategoryLeafName + ", goodsBrandName=" + this.goodsBrandName + ", orderDetailInfo=" + this.orderDetailInfo.toString() + ", goodsFeatureInfoList=" + this.goodsFeatureInfoList.toString() + "]";
    }

}

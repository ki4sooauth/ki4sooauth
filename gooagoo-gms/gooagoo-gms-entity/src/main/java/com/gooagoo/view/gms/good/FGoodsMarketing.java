package com.gooagoo.view.gms.good;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FGoodsMarketing implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String crossGoods;//交叉营销商品
    private String goodsContent;//推荐商品描述
    private String goodsId;//商品编号
    private String goodsSolution; //商品解决方案描述 
    private String positionId;//位置编号
    private String positionName;//位置名称
    private String relationGoods;//关联销售商品
    private String replaceGoods;//可替换商品
    private String shopEntityId;//实体店编号
    private String shopId;//商家编号
    private String vendor;//供应商
    private String useType;//自用型，送礼型
    private String lifeIdea;//环保型，健康型，实惠型，品质型

    private String feature;//功能
    private String address;//产地
    private String crowd;//人群
    private String useMessage;//使用方法
    private String goodsImg;//商品图片URL，json串

    private String mainImg; //商品主图片
    private List<String> subImgs = new ArrayList<String>();//商品次图片 

    public String getCrossGoods()
    {
        return this.crossGoods;
    }

    public String getGoodsContent()
    {
        return this.goodsContent;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public String getGoodsSolution()
    {
        return this.goodsSolution;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public String getRelationGoods()
    {
        return this.relationGoods;
    }

    public String getReplaceGoods()
    {
        return this.replaceGoods;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getVendor()
    {
        return this.vendor;
    }

    public void setCrossGoods(String crossGoods)
    {
        this.crossGoods = crossGoods;
    }

    public void setGoodsContent(String goodsContent)
    {
        this.goodsContent = goodsContent;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public void setGoodsSolution(String goodsSolution)
    {
        this.goodsSolution = goodsSolution;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public void setRelationGoods(String relationGoods)
    {
        this.relationGoods = relationGoods;
    }

    public void setReplaceGoods(String replaceGoods)
    {
        this.replaceGoods = replaceGoods;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public String getUseType()
    {
        return this.useType;
    }

    public void setUseType(String useType)
    {
        this.useType = useType;
    }

    public String getLifeIdea()
    {
        return this.lifeIdea;
    }

    public void setLifeIdea(String lifeIdea)
    {
        this.lifeIdea = lifeIdea;
    }

    public String getFeature()
    {
        return this.feature;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCrowd()
    {
        return this.crowd;
    }

    public void setCrowd(String crowd)
    {
        this.crowd = crowd;
    }

    public String getUseMessage()
    {
        return this.useMessage;
    }

    public void setUseMessage(String useMessage)
    {
        this.useMessage = useMessage;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getMainImg()
    {
        return this.mainImg;
    }

    public void setMainImg(String mainImg)
    {
        this.mainImg = mainImg;
    }

    public List<String> getSubImgs()
    {
        return this.subImgs;
    }

    public void setSubImgs(List<String> list)
    {
        this.subImgs = list;
    }
}
